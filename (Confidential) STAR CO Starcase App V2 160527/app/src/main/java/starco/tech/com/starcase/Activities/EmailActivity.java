package starco.tech.com.starcase.Activities;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.TextView;

import starco.tech.com.starcase.Enums.MenuType;
import starco.tech.com.starcase.ListAdapters.DisplayListAdapter;
import starco.tech.com.starcase.R;
import starco.tech.com.starcase.TouchListener;
import starco.tech.com.starcase.UserPreferences;

/**
 * Created by Noah on 5/27/2016.
 */
public class EmailActivity extends Activity
{
    private Switch enableSwitch;
    private ListView phoneDisplayOptionsListView;
    private DisplayListAdapter adapter;
    private ImageView backButton;
    private SeekBar slider;

    private ImageView logo;

    private ImageView boxOne;
    private TextView boxTwo;
    private TextView boxThree;
    private View boxFour;


    private RelativeLayout phoneRelativeLayout;

    String[] names = {"Contact Picture", "First Name, Last Name", "Phone Number", "Background:Fill"};
    int[] colors = {Color.RED, Color.GREEN, Color.BLUE, Color.rgb(255, 0, 255)};

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.phone_display_screen);

        enableSwitch = (Switch)findViewById(R.id.phoneEnableSwitch);
        phoneDisplayOptionsListView = (ListView)findViewById(R.id.phoneDisplayListView);
        slider = (SeekBar)findViewById(R.id.phoneDisplaySlider);
        backButton = (ImageView)findViewById(R.id.phoneDisplayBackButton);
        boxOne = (ImageView)findViewById(R.id.phoneDisplayIconPreview);
        boxTwo = (TextView)findViewById(R.id.phoneDisplayNameTextPreview);
        boxThree = (TextView)findViewById(R.id.phoneDisplayLargeTextPreview);
        boxFour = (View)findViewById(R.id.displayLayoutView);
        phoneRelativeLayout = (RelativeLayout)findViewById(R.id.phoneDisplayRelativeLayout);
        logo = (ImageView)findViewById(R.id.phoneDisplayStarcaseLogo);

        logo.setImageResource(R.drawable.email_icon);

        boxOne.setColorFilter(UserPreferences.getEmailBoxOneColor(getApplicationContext()).getRGB());

        switch(UserPreferences.getEmailBoxOne(getApplicationContext()))
        {
            case EMAIL_ICON:
                boxOne.setImageResource(R.drawable.email_icon);
                break;

            case CONTACT_PICTURE:
                boxOne.setImageResource(R.drawable.info_i);
                break;
        }

        boxTwo.setTextColor(UserPreferences.getEmailBoxTwoColor(getApplicationContext()).getRGB());
        boxTwo.setText(UserPreferences.getEmailBoxTwo(getApplicationContext()).getText());

        boxThree.setTextColor(UserPreferences.getEmailBoxThreeColor(getApplicationContext()).getRGB());
        boxThree.setText(UserPreferences.getEmailBoxThree(getApplicationContext()).getText());

        boxFour.setBackgroundColor(UserPreferences.getEmailBoxFourColor(getApplicationContext()).getRGB());

        enableSwitch.setChecked(true);

        phoneDisplayOptionsListView.setDivider(null);
        phoneDisplayOptionsListView.setDividerHeight(0);

        names[0] = UserPreferences.getEmailBoxOne(this).getText();
        names[1] = UserPreferences.getEmailBoxTwo(this).getText();
        names[2] = UserPreferences.getEmailBoxThree(this).getText();

        colors[0] = UserPreferences.getEmailBoxOneColor(this).getRGB();
        colors[1] = UserPreferences.getEmailBoxTwoColor(this).getRGB();
        colors[2] = UserPreferences.getEmailBoxThreeColor(this).getRGB();
        colors[3] = UserPreferences.getEmailBoxFourColor(this).getRGB();



        backButton.setOnTouchListener(new TouchListener(backButton, Color.GRAY));
        backButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent(getApplicationContext(), MainMenuActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        });

        enableSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked)
            {
                if(isChecked)
                {
                    disableEnableControls(true, phoneRelativeLayout);
                }
                else
                {
                    disableEnableControls(false, phoneRelativeLayout);
                }
            }
        });

        adapter = new DisplayListAdapter(this, names, colors, MenuType.EMAIL, handler);
        phoneDisplayOptionsListView.setAdapter(adapter);

    }

    private Handler handler = new Handler()
    {
        @Override
        public void handleMessage(Message msg)
        {
            super.handleMessage(msg);

            boxOne.setColorFilter(UserPreferences.getEmailBoxOneColor(getApplicationContext()).getRGB());

            switch(UserPreferences.getEmailBoxOne(getApplicationContext()))
            {
                case EMAIL_ICON:
                    boxOne.setImageResource(R.drawable.email_icon);
                    break;

                case CONTACT_PICTURE:
                    boxOne.setImageResource(R.drawable.info_i);
                    break;
            }

            boxTwo.setTextColor(UserPreferences.getEmailBoxTwoColor(getApplicationContext()).getRGB());
            boxTwo.setText(UserPreferences.getEmailBoxTwo(getApplicationContext()).getText());

            boxThree.setTextColor(UserPreferences.getEmailBoxThreeColor(getApplicationContext()).getRGB());
            boxThree.setText(UserPreferences.getEmailBoxThree(getApplicationContext()).getText());

            boxFour.setBackgroundColor(UserPreferences.getEmailBoxFourColor(getApplicationContext()).getRGB());
        }
    };

    private void disableEnableControls(boolean enable, ViewGroup vg){
        for (int i = 0; i < vg.getChildCount(); i++){
            View child = vg.getChildAt(i);
            child.setEnabled(enable);
            if (child instanceof ViewGroup){
                disableEnableControls(enable, (ViewGroup)child);
            }
        }
    }
}
