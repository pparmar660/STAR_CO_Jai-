package starco.tech.com.starcase;

import android.hardware.usb.UsbDevice;
import android.hardware.usb.UsbDeviceConnection;
import android.hardware.usb.UsbInterface;
import android.hardware.usb.UsbManager;

/**
 * Created by Noah on 5/20/2016.
 */
public class GlobalVariables
{

    public static boolean usbConnected = false;

    //public static USBTestAdapter usbTestAdapter = null;

    public static UsbDevice device = null;
    public static UsbManager manager = null;
    public static UsbDeviceConnection connection;
    public static UsbInterface usbInterface;

    public static USBHandler usbHandler = null;

}
