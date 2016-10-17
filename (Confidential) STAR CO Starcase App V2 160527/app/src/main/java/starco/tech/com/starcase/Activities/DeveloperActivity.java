package starco.tech.com.starcase.Activities;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.hardware.usb.UsbDevice;
import android.hardware.usb.UsbManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.HashMap;
import java.util.Iterator;

import starco.tech.com.starcase.GlobalVariables;
import starco.tech.com.starcase.R;
import starco.tech.com.starcase.USBHandler;
import starco.tech.com.starcase.ListAdapters.USBTestAdapter;

/**
 * Created by Noah on 5/19/2016.
 */
public class DeveloperActivity extends Activity
{

    private TextView connectionStatus;
    private Spinner protocolSelecter;
    private EditText messageEditText;
    private ImageView pictureImageView;
    private Button uploadPictureButton;
    private Button sendButton;
    private RadioButton sendMessageRadioButton;
    private RadioButton sendPictureRadioButton;
    private RadioGroup selectSendItemRadioGroup;
    private ListView chatListView;

    private USBHandler usbHandler = null;

    private USBTestAdapter usbTestAdapter = null;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.developer_send_screen);

        connectionStatus = (TextView)findViewById(R.id.connectionStatusText);
        protocolSelecter = (Spinner)findViewById(R.id.codeSpinner);
        messageEditText = (EditText)findViewById(R.id.messageEditText);
        pictureImageView = (ImageView)findViewById(R.id.uploadImagePreview);
        uploadPictureButton = (Button)findViewById(R.id.uploadPictureButton);
        sendButton = (Button)findViewById(R.id.sendButton);
        sendMessageRadioButton = (RadioButton)findViewById(R.id.sendMessageRadioButton);
        sendPictureRadioButton = (RadioButton)findViewById(R.id.sendPictureRadioButton);
        selectSendItemRadioGroup = (RadioGroup)findViewById(R.id.selectSendingRadioGroup);
        chatListView = (ListView)findViewById(R.id.resultsListView);

        if(GlobalVariables.usbConnected)
        {
            connectionStatus.setText("Connected");
            connectionStatus.setTextColor(Color.GREEN);

            uploadPictureButton.setEnabled(true);
            sendButton.setEnabled(true);
        }
        else
        {
            connectionStatus.setText("Disconnected");
            connectionStatus.setTextColor(Color.RED);

            uploadPictureButton.setEnabled(false);
            sendButton.setEnabled(false);
        }

        final ArrayAdapter<CharSequence> spinnerAdapter = ArrayAdapter.createFromResource(this, R.array.protocolChoices, android.R.layout.simple_spinner_item);
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        protocolSelecter.setAdapter(spinnerAdapter);

        usbTestAdapter = new USBTestAdapter(this);

        chatListView.setAdapter(usbTestAdapter);

        selectSendItemRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId)
            {
                if(checkedId == R.id.sendMessageRadioButton)
                {
                    uploadPictureButton.setEnabled(false);
                    messageEditText.setEnabled(true);
                    protocolSelecter.setEnabled(true);
                }

                if(checkedId == R.id.sendPictureRadioButton)
                {
                    uploadPictureButton.setEnabled(true);
                    messageEditText.setEnabled(false);
                    protocolSelecter.setEnabled(false);
                }
            }
        });

    }

    @Override
    protected void onResume()
    {
        super.onResume();
        Intent intent = getIntent();
        String action = intent.getAction();



        if(UsbManager.ACTION_USB_DEVICE_ATTACHED.equals(action))
        {
            UsbDevice device = (UsbDevice)intent.getParcelableExtra(UsbManager.EXTRA_DEVICE);
            usbHandler = load(device);
        }
        else
        {
            UsbManager manager = (UsbManager)getSystemService(Context.USB_SERVICE);
            HashMap<String, UsbDevice> deviceList = manager.getDeviceList();
            Iterator<UsbDevice> deviceIterator = deviceList.values().iterator();

            while(deviceIterator.hasNext())
            {
                usbHandler = load(deviceIterator.next());

                if(usbHandler != null)
                {
                    break;
                }
            }
        }
    }


    @Override
    protected void onPause()
    {
        super.onPause();

        if(usbHandler != null)
        {
            usbHandler.close();
        }

        usbHandler = null;
    }

    public USBHandler load(UsbDevice device)
    {
        USBHandler temp = new USBHandler(getApplicationContext(), device, handler);

        return temp;
    }

    public void sendStringOnClick(View v)
    {
        if(usbHandler != null)
        {
            String message = messageEditText.getText().toString();
            int position = protocolSelecter.getSelectedItemPosition();
            usbTestAdapter.addSent(protocolSelecter.getSelectedItem().toString() + " " + message);
            usbHandler.sendString(message, convertPositionToCode(position));
        }
    }

    private byte convertPositionToCode(int position)
    {
        switch(position)
        {
            case 0:
                return 0x10;

            case 1:
                return 0x15;

            case 2:
                return 0x20;

            case 3:
                return 0x25;

            case 4:
                return 0x30;

            case 5:
                return 0x35;

            case 6:
                return 0x40;

            case 7:
                return 0x45;

            case 8:
                return 0x50;

            case 9:
                return 0x55;

            case 10:
                return 0x60;

            case 11:
                return 0x65;

            case 12:
                return 0x70;
        }

        return 0x10;
    }

    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg)
        {
            String data = (String)msg.obj;

            usbTestAdapter.addReceived(data);

            //Toast.makeText(getApplicationContext(), data, Toast.LENGTH_SHORT).show();



            //dumb(data);

            //usbTestAdapter.addReceived(data);
        } //handleMessage
    }; //handler

}
