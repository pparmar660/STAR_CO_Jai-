package starco.tech.com.starcase;

import android.content.Context;
import android.hardware.usb.UsbDevice;
import android.hardware.usb.UsbDeviceConnection;
import android.hardware.usb.UsbEndpoint;
import android.hardware.usb.UsbInterface;
import android.hardware.usb.UsbManager;
import android.os.Handler;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;


import java.nio.ByteBuffer;
import java.nio.ByteOrder;

import android.content.Context;
import android.hardware.usb.UsbDevice;
import android.hardware.usb.UsbDeviceConnection;
import android.hardware.usb.UsbEndpoint;
import android.hardware.usb.UsbInterface;
import android.hardware.usb.UsbManager;
import android.os.Handler;
import android.widget.Toast;

import starco.tech.com.starcase.Interfaces.CommunicationInterface;

public class USBHandler implements Runnable, CommunicationInterface
{
    private UsbDevice device = null;
    private UsbManager manager = null;
    private Handler handler = null;
    private Integer toggleLEDCount = 0;
    private boolean lastButtonState = false;
    private boolean buttonStatusInitialized = false;
    private Boolean closeRequested = new Boolean(false);
    private UsbDeviceConnection connection;
    private UsbInterface intf;
    private String toSend = new String();
    private boolean connected = false;
    Thread thread;

    Context context;

    private byte commandCode = 0x20;

    private final static int CUSTOM_HID_DEMO_BUTTON_PRESSED = (int) 0x00;

    public USBHandler(Context context, UsbDevice device, Handler handler) {

        this.device = device;
        this.context = context;
        this.handler = handler;

		/* Get the USB manager from the requesting context */
        this.manager = (UsbManager) context.getSystemService(Context.USB_SERVICE);


        intf = device.getInterface(0);

		/* Open a connection to the USB device */
        connection = manager.openDevice(device);



        if (connection == null) {
            return;
        }

		/* Claim the required interface to gain access to it */
        if (connection.claimInterface(intf, true) == true)
        {

            thread = new Thread(this);
            thread.start();
            connected = true;
        } else {

            connection.close();
        }
    }


    public boolean isConnected() {
        return connected;
    }


    public void close() {
        connected = false;


        synchronized (closeRequested) {
            closeRequested = true;
        }
    }

    public void sendString(String s, byte code)
    {
        this.commandCode = code;
        synchronized (toSend) {
            toSend = toSend+"J"+s;

        }
    }

    /**
     * The man thread for the demo
     */
    @Override
    public void run()
    {
        /* Get the OUT endpoint.  It is the second endpoint in the interface */
        UsbEndpoint endpointOUT = intf.getEndpoint(1);

		/* Get the IN endpoint.  It is the first endpoint in the interface */
        UsbEndpoint endpointIN = intf.getEndpoint(0);

		/* Create the packets that we are going to send to the attached USB
		 * device.
		 */

        byte[] RxData = new byte[64];
        byte[] TxBuff = new byte[]{(byte) 0x20};
        byte[] TxData = new byte[64];
        int potentiometerLastResults = Integer.MAX_VALUE;
        int result;


        while (true) {
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            if(GlobalVariables.usbConnected == false)
            {
                destroy();
            }


            synchronized (toSend) {
                if (toSend.length() > 0) {
                    TxData = toSend.getBytes();
                    toSend = new String();
                }


            }

            if (TxData != null)
            {
                TxBuff[0] = this.commandCode;
                System.arraycopy(TxBuff, 0, TxData, 0, 1);


                do {
                    result = connection.bulkTransfer(endpointOUT, TxData, TxData.length, 1000);
                } while ((result < 0) && (wasCloseRequested() == false));


                do {
                    result = connection.bulkTransfer(endpointIN, RxData, RxData.length, 1000);
                } while ((result < 0) && (wasCloseRequested() == false));

                byte[] potentiometerBuffer = new byte[]{0, 0, 0, 0};
                potentiometerBuffer[0] = RxData[1];
                potentiometerBuffer[1] = RxData[2];

                ByteBuffer buf = ByteBuffer.wrap(potentiometerBuffer);
                buf.order(ByteOrder.LITTLE_ENDIAN);
                int potentiometerResults = buf.getInt();

			/* If the new results are different from the previous results, then send
			 * a message to the specified handler containing the new data.
			 */
//                if (potentiometerResults != potentiometerLastResults)
//                {

                    //GlobalVariables.usbTestAdapter.addReceived(new String(RxData));
                    handler.obtainMessage(0, new String(RxData)).sendToTarget();
                    potentiometerLastResults = potentiometerResults;


               // }


/* If the connection was closed, destroy the connections and variables
			 *
            if(TxData != null)
            {
                System.arraycopy(TxBuff, 0, TxData, 0, 1);
                do {
                    result = connection.bulkTransfer(endpointOUT, TxData, TxData.length, 1000);
                } while ((result < 0) && (wasCloseRequested() == false));

                if(result != 0)
                {
                    TxData = null;

                }
            }
            do {
                result = connection.bulkTransfer(endpointIN, RxData, RxData.length, 1000);
            } while ((result < 0) && (wasCloseRequested() == false));


            if(result > 0) {
                handler.obtainMessage(0, new MessageText(new String(RxData))).sendToTarget();
            }

			 and exit this thread.
			 */


			/* Sleep the thread for a while */


            }
        }
    }

    private boolean wasCloseRequested() {
        synchronized (closeRequested) {
            return closeRequested;
        }
    }

    /**
     * Closes connections, releases resources, cleans up variables
     */
    private void destroy() {
		/* Release the interface that was previously claimed and close
		 * the connection.
		 */
        connection.releaseInterface(intf);
        connection.close();

		/* Clear up all of the locals */
        device = null;
        manager = null;
        handler = null;
        toggleLEDCount = 0;
        lastButtonState = false;
        buttonStatusInitialized = false;
        closeRequested = false;
        connection = null;
        intf = null;
    }


}
