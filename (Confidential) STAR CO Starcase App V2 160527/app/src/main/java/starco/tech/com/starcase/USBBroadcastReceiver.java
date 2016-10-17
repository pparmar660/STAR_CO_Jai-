package starco.tech.com.starcase;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.hardware.usb.UsbDevice;
import android.hardware.usb.UsbDeviceConnection;
import android.hardware.usb.UsbEndpoint;
import android.hardware.usb.UsbInterface;
import android.hardware.usb.UsbManager;
import android.widget.Toast;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/**
 * Created by Noah on 5/20/2016.
 */
public class USBBroadcastReceiver extends BroadcastReceiver
{

    @Override
    public void onReceive(Context context, Intent intent)
    {
        String action = intent.getAction();

        if(UsbManager.ACTION_USB_DEVICE_DETACHED.equals(action))
        {
            GlobalVariables.usbConnected = false;


        }
        else
        {
            GlobalVariables.usbConnected = true;

//            GlobalVariables.device = (UsbDevice)intent.getParcelableExtra(UsbManager.EXTRA_DEVICE);
//            GlobalVariables.manager = (UsbManager)context.getSystemService(Context.USB_SERVICE);
//            GlobalVariables.usbInterface = GlobalVariables.device.getInterface(0);
//            GlobalVariables.connection = GlobalVariables.manager.openDevice(GlobalVariables.device);

        }
    }



}
