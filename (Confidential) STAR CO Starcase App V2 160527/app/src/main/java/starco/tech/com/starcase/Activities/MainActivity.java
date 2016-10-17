package starco.tech.com.starcase.Activities;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.hardware.usb.UsbManager;
import android.os.Bundle;
import android.os.Environment;
import android.support.v4.app.ActivityCompat;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStreamReader;

import starco.tech.com.starcase.Enums.CustomBoxData;
import starco.tech.com.starcase.GlobalVariables;
import starco.tech.com.starcase.R;
import starco.tech.com.starcase.TouchListener;
import starco.tech.com.starcase.USBBroadcastReceiver;
import starco.tech.com.starcase.UserPreferences;

public class MainActivity extends Activity
{

    private ImageView skipButton;
    private ImageView infoButton;

    private boolean isRegistered = false;

    FileOutputStream writer;

    USBBroadcastReceiver receiver;
    IntentFilter filter;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        SharedPreferences sharedPreferences = getSharedPreferences("USER_SETTINGS", Context.MODE_PRIVATE);

        if(sharedPreferences.getBoolean("firstrun", true))
        {
            Toast.makeText(getApplicationContext(), "First Time", Toast.LENGTH_SHORT).show();
            sharedPreferences.edit().putBoolean("firstrun", false).commit();

            UserPreferences.savePhoneBoxOne(this, CustomBoxData.CALL_ICON);
            UserPreferences.savePhoneBoxTwo(this, CustomBoxData.FIRST_NAME);
            UserPreferences.savePhoneBoxThree(this, CustomBoxData.PHONE_NUMBER);
            UserPreferences.savePhoneBoxOneColor(this, 255, 0, 0, 0);
            UserPreferences.savePhoneBoxTwoColor(this, 0, 255, 0, 0);
            UserPreferences.savePhoneBoxThreeColor(this, 0, 0, 255, 0);
            UserPreferences.savePhoneBoxFourColor(this, 255, 0, 255, 0);

            UserPreferences.saveMessagesBoxOne(this, CustomBoxData.MESSAGES_ICON);
            UserPreferences.saveMessagesBoxTwo(this, CustomBoxData.FIRST_NAME);
            UserPreferences.saveMessagesBoxThree(this, CustomBoxData.PHONE_NUMBER);
            UserPreferences.saveMessagesBoxOneColor(this, 255, 0, 0, 0);
            UserPreferences.saveMessagesBoxTwoColor(this, 0, 255, 0, 0);
            UserPreferences.saveMessagesBoxThreeColor(this, 0, 0, 255, 0);
            UserPreferences.saveMessagesBoxFourColor(this, 255, 0, 255, 0);

            UserPreferences.saveEmailBoxOne(this, CustomBoxData.EMAIL_ICON);
            UserPreferences.saveEmailBoxTwo(this, CustomBoxData.SUBJECT_OF_EMAIL);
            UserPreferences.saveEmailBoxThree(this, CustomBoxData.EMAIL_ADDRESS);
            UserPreferences.saveEmailBoxOneColor(this, 255, 0, 0, 0);
            UserPreferences.saveEmailBoxTwoColor(this, 0, 255, 0, 0);
            UserPreferences.saveEmailBoxThreeColor(this, 0, 0, 255, 0);
            UserPreferences.saveEmailBoxFourColor(this, 255, 0, 255, 0);

            UserPreferences.saveNotificationsBoxOne(this, CustomBoxData.NOTIFICATIONS_ICON);
            UserPreferences.saveNotificationsBoxTwo(this, CustomBoxData.TITLE);
            UserPreferences.saveNotificationsBoxThree(this, CustomBoxData.TEXT);
            UserPreferences.saveNotificationsBoxOneColor(this, 255, 0, 0, 0);
            UserPreferences.saveNotificationsBoxTwoColor(this, 0, 255, 0, 0);
            UserPreferences.saveNotificationsBoxThreeColor(this, 0, 0, 255, 0);
            UserPreferences.saveNotificationsBoxFourColor(this, 255, 0, 255, 0);
        }

        skipButton = (ImageView)findViewById(R.id.skipButton);
        infoButton = (ImageView)findViewById(R.id.infoButton);

        skipButton.setOnTouchListener(new TouchListener(skipButton, Color.GRAY));
        infoButton.setOnTouchListener(new TouchListener(infoButton, Color.GRAY));

        skipButton.setOnClickListener(new ClickListener(this));
        infoButton.setOnClickListener(new ClickListener(this));


//        final String ACTION = "starco.tech.com.starcase.USBBroadcastReceiver";
        filter = new IntentFilter();

        filter.addAction(UsbManager.ACTION_USB_ACCESSORY_ATTACHED);
        filter.addAction(UsbManager.ACTION_USB_ACCESSORY_DETACHED);
        receiver = new USBBroadcastReceiver();
        registerReceiver(receiver, filter);
        isRegistered = true;


//        Intent i2 = new Intent(ACTION);
//        PendingIntent pendingIntent = PendingIntent.getBroadcast(getApplicationContext(), 0, i2, 0);

    }


    @Override
    protected void onResume()
    {
        super.onResume();

        if(!isRegistered)
        {
            registerReceiver(receiver, filter);
            isRegistered = true;
        }

        Toast.makeText(getApplicationContext(), (GlobalVariables.usbConnected) ? "Connected" : "Disconnected", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onPause()
    {
        super.onPause();

        if(isRegistered)
        {
            unregisterReceiver(receiver);
            isRegistered = false;
        }
        //unregisterReceiver(receiver);
    }

    @Override
    protected void onDestroy()
    {
        super.onDestroy();

        if(isRegistered)
        {
            unregisterReceiver(receiver);
            isRegistered = false;
        }
    }

    @Override
    protected void onRestart()
    {
        super.onRestart();

        if(!isRegistered)
        {
            registerReceiver(receiver, filter);
            isRegistered = true;
        }
    }



    /**
     * Private Class to implement onClickListeners for the MainActivity
     */
    private class ClickListener implements View.OnClickListener
    {
        private Context context;

        public ClickListener(Context context)
        {
            this.context = context;
        }

        @Override
        public void onClick(View v)
        {
            if(v.getId() == R.id.skipButton)
            {
                Toast.makeText(getApplicationContext(), "USB Mode Skipped", Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(context, MainMenuActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
            else if(v.getId() == R.id.infoButton)
            {
                Intent intent = new Intent(context, InfoActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        }
    }
}
