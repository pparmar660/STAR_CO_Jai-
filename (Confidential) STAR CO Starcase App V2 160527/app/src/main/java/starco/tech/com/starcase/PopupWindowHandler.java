package starco.tech.com.starcase;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RectShape;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.SeekBar;

import java.util.ArrayList;

import starco.tech.com.starcase.Enums.CustomBoxData;
import starco.tech.com.starcase.Enums.MenuType;
import starco.tech.com.starcase.ListAdapters.PopUpAdapter;

/**
 * Created by Noah on 5/27/2016.
 */
public class PopupWindowHandler extends PopupWindow
{

    private MenuType menu;
    private int position;
    private Activity activity;

    private View layout;
    private PopUpAdapter popUpAdapter;

    private ListView popupListView;
    private ImageView exitButton;
    private ImageView colorCircle;
    private SeekBar colorPicker;

    public PopupWindowHandler(MenuType menu, Activity activity)
    {
        this.menu = menu;
        this.activity = activity;
    }

    public void init(int position)
    {
        this.position = position;

        switch(menu)
        {
            case PHONE:
                setupPhonePopupWindow();
                initPhonePopupElements();
                break;

            case MESSAGES:
                setupMessagesPopupWindow();
                initMessagesPopupElements();
                break;

            case EMAIL:
                setupEmailPopupWindow();
                initEmailPopupElements();
                break;

            case NOTIFICATION:
                setupNotificationsPopupWindow();
                initNotificationsPopupElements();
                break;
        }

        setContentView(layout);
        setWidth(RelativeLayout.LayoutParams.WRAP_CONTENT);
        setHeight(RelativeLayout.LayoutParams.WRAP_CONTENT);
        setFocusable(true);

    }

    public void display()
    {
        showAtLocation(layout, Gravity.CENTER, 0, 0);
    }

    private void setupPhonePopupWindow()
    {
        LayoutInflater layoutInflater = (LayoutInflater)activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        RelativeLayout relativeLayout = (RelativeLayout)activity.findViewById(R.id.phoneDisplayPopupRelativeLayout);

        layout = layoutInflater.inflate(R.layout.phone_display_popup, relativeLayout);

        ArrayList<CustomBoxData.CustomBoxDataDuple> temp = new ArrayList<>();

        switch(position)
        {
            case 0:

                temp = CustomBoxData.getPhoneBoxOneList(activity);
                break;

            case 1:
                temp = CustomBoxData.getPhoneBoxTwoList(activity);
                break;

            case 2:
                temp = CustomBoxData.getPhoneBoxThreeList(activity);
                break;

            case 3:
                break;

        }

        boolean[] dumb = new boolean[temp.size()];
        String[] dumber = new String[temp.size()];

        for(int i = 0; i < temp.size(); i++)
        {
            dumber[i] = temp.get(i).field.getText();
            dumb[i] = temp.get(i).value;
        }

        popUpAdapter = new PopUpAdapter(activity, dumber, dumb, position, this, menu);
    }

    private void initPhonePopupElements()
    {
        //Popup ListView
        popupListView = (ListView)layout.findViewById(R.id.phonePopUpListView);
        popupListView.setDivider(null);
        popupListView.setDividerHeight(0);
        popupListView.setAdapter(popUpAdapter);


        //Popup Exit Button
        exitButton = (ImageView)layout.findViewById(R.id.phonePopUpExitButton);
        exitButton.setOnTouchListener(new TouchListener(exitButton, Color.GRAY));
        exitButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                dismiss();
            }
        });


        //Popup Color Circle
        colorCircle = (ImageView)layout.findViewById(R.id.popupColorCircle);
        GradientDrawable gradientDrawable = (GradientDrawable)colorCircle.getBackground();
        int color = 0;
        int progress = 0;

        switch(position)
        {
            case 0:
                color = UserPreferences.getPhoneBoxOneColor(activity).getRGB();
                progress = UserPreferences.getPhoneBoxOneColor(activity).getSliderValue();
                break;

            case 1:
                color = UserPreferences.getPhoneBoxTwoColor(activity).getRGB();
                progress = UserPreferences.getPhoneBoxTwoColor(activity).getSliderValue();
                break;

            case 2:
                color = UserPreferences.getPhoneBoxThreeColor(activity).getRGB();
                progress = UserPreferences.getPhoneBoxThreeColor(activity).getSliderValue();
                break;

            case 3:
                color = UserPreferences.getPhoneBoxFourColor(activity).getRGB();
                progress = UserPreferences.getPhoneBoxFourColor(activity).getSliderValue();
                break;

            default:
                color = Color.BLACK;
        }
        gradientDrawable.setColor(color);


        //SeekBar
        LinearGradient test = new LinearGradient(0.f, 0.f, 1200.f, 0.0f,

                new int[] { 0xFF000000, 0xFF0000FF, 0xFF00FF00, 0xFF00FFFF,
                        0xFFFF0000, 0xFFFF00FF, 0xFFFFFF00, 0xFFFFFFFF},
                null, Shader.TileMode.CLAMP);
        ShapeDrawable shape = new ShapeDrawable(new RectShape());
        shape.getPaint().setShader(test);

        colorPicker = (SeekBar)layout.findViewById(R.id.phonePopUpSeekBar);
        colorPicker.setProgressDrawable((Drawable)shape);

        colorPicker.setMax(256 * 7 - 1);

        colorPicker.setProgress(progress);
        colorPicker.setBackgroundColor(color);
        colorPicker.setOnSeekBarChangeListener(new ColorPickerListener());
    }

    private void setupMessagesPopupWindow()
    {
        LayoutInflater layoutInflater = (LayoutInflater)activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        RelativeLayout relativeLayout = (RelativeLayout)activity.findViewById(R.id.phoneDisplayPopupRelativeLayout);

        layout = layoutInflater.inflate(R.layout.phone_display_popup, relativeLayout);

        ArrayList<CustomBoxData.CustomBoxDataDuple> temp = new ArrayList<>();

        switch(position)
        {
            case 0:

                temp = CustomBoxData.getMessagesBoxOneList(activity);
                break;

            case 1:
                temp = CustomBoxData.getMessagesBoxTwoList(activity);
                break;

            case 2:
                temp = CustomBoxData.getMessagesBoxThreeList(activity);
                break;

            case 3:
                break;

        }

        boolean[] dumb = new boolean[temp.size()];
        String[] dumber = new String[temp.size()];

        for(int i = 0; i < temp.size(); i++)
        {
            dumber[i] = temp.get(i).field.getText();
            dumb[i] = temp.get(i).value;
        }

        popUpAdapter = new PopUpAdapter(activity, dumber, dumb, position, this, menu);
    }

    private void initMessagesPopupElements()
    {
        //Popup ListView
        popupListView = (ListView)layout.findViewById(R.id.phonePopUpListView);
        popupListView.setDivider(null);
        popupListView.setDividerHeight(0);
        popupListView.setAdapter(popUpAdapter);


        //Popup Exit Button
        exitButton = (ImageView)layout.findViewById(R.id.phonePopUpExitButton);
        exitButton.setOnTouchListener(new TouchListener(exitButton, Color.GRAY));
        exitButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                dismiss();
            }
        });


        //Popup Color Circle
        colorCircle = (ImageView)layout.findViewById(R.id.popupColorCircle);
        GradientDrawable gradientDrawable = (GradientDrawable)colorCircle.getBackground();
        int color = 0;
        int progress = 0;

        switch(position)
        {
            case 0:
                color = UserPreferences.getMessagesBoxOneColor(activity).getRGB();
                progress = UserPreferences.getMessagesBoxOneColor(activity).getSliderValue();
                break;

            case 1:
                color = UserPreferences.getMessagesBoxTwoColor(activity).getRGB();
                progress = UserPreferences.getMessagesBoxTwoColor(activity).getSliderValue();
                break;

            case 2:
                color = UserPreferences.getMessagesBoxThreeColor(activity).getRGB();
                progress = UserPreferences.getMessagesBoxThreeColor(activity).getSliderValue();
                break;

            case 3:
                color = UserPreferences.getMessagesBoxFourColor(activity).getRGB();
                progress = UserPreferences.getMessagesBoxFourColor(activity).getSliderValue();
                break;

            default:
                color = Color.BLACK;
        }
        gradientDrawable.setColor(color);


        //SeekBar
        LinearGradient test = new LinearGradient(0.f, 0.f, 1200.f, 0.0f,

                new int[] { 0xFF000000, 0xFF0000FF, 0xFF00FF00, 0xFF00FFFF,
                        0xFFFF0000, 0xFFFF00FF, 0xFFFFFF00, 0xFFFFFFFF},
                null, Shader.TileMode.CLAMP);
        ShapeDrawable shape = new ShapeDrawable(new RectShape());
        shape.getPaint().setShader(test);

        colorPicker = (SeekBar)layout.findViewById(R.id.phonePopUpSeekBar);
        colorPicker.setProgressDrawable((Drawable)shape);

        colorPicker.setMax(256 * 7 - 1);

        colorPicker.setProgress(progress);
        colorPicker.setBackgroundColor(color);
        colorPicker.setOnSeekBarChangeListener(new ColorPickerListener());
    }

    private void setupEmailPopupWindow()
    {
        LayoutInflater layoutInflater = (LayoutInflater)activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        RelativeLayout relativeLayout = (RelativeLayout)activity.findViewById(R.id.phoneDisplayPopupRelativeLayout);

        layout = layoutInflater.inflate(R.layout.phone_display_popup, relativeLayout);

        ArrayList<CustomBoxData.CustomBoxDataDuple> temp = new ArrayList<>();

        switch(position)
        {
            case 0:

                temp = CustomBoxData.getEmailBoxOneList(activity);
                break;

            case 1:
                temp = CustomBoxData.getEmailBoxTwoList(activity);
                break;

            case 2:
                temp = CustomBoxData.getEmailBoxThreeList(activity);
                break;

            case 3:
                break;

        }

        boolean[] dumb = new boolean[temp.size()];
        String[] dumber = new String[temp.size()];

        for(int i = 0; i < temp.size(); i++)
        {
            dumber[i] = temp.get(i).field.getText();
            dumb[i] = temp.get(i).value;
        }

        popUpAdapter = new PopUpAdapter(activity, dumber, dumb, position, this, menu);
    }

    private void initEmailPopupElements()
    {
        //Popup ListView
        popupListView = (ListView)layout.findViewById(R.id.phonePopUpListView);
        popupListView.setDivider(null);
        popupListView.setDividerHeight(0);
        popupListView.setAdapter(popUpAdapter);


        //Popup Exit Button
        exitButton = (ImageView)layout.findViewById(R.id.phonePopUpExitButton);
        exitButton.setOnTouchListener(new TouchListener(exitButton, Color.GRAY));
        exitButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                dismiss();
            }
        });


        //Popup Color Circle
        colorCircle = (ImageView)layout.findViewById(R.id.popupColorCircle);
        GradientDrawable gradientDrawable = (GradientDrawable)colorCircle.getBackground();
        int color = 0;
        int progress = 0;

        switch(position)
        {
            case 0:
                color = UserPreferences.getEmailBoxOneColor(activity).getRGB();
                progress = UserPreferences.getEmailBoxOneColor(activity).getSliderValue();
                break;

            case 1:
                color = UserPreferences.getEmailBoxTwoColor(activity).getRGB();
                progress = UserPreferences.getEmailBoxTwoColor(activity).getSliderValue();
                break;

            case 2:
                color = UserPreferences.getEmailBoxThreeColor(activity).getRGB();
                progress = UserPreferences.getEmailBoxThreeColor(activity).getSliderValue();
                break;

            case 3:
                color = UserPreferences.getEmailBoxFourColor(activity).getRGB();
                progress = UserPreferences.getEmailBoxFourColor(activity).getSliderValue();
                break;

            default:
                color = Color.BLACK;
        }
        gradientDrawable.setColor(color);


        //SeekBar
        LinearGradient test = new LinearGradient(0.f, 0.f, 1200.f, 0.0f,

                new int[] { 0xFF000000, 0xFF0000FF, 0xFF00FF00, 0xFF00FFFF,
                        0xFFFF0000, 0xFFFF00FF, 0xFFFFFF00, 0xFFFFFFFF},
                null, Shader.TileMode.CLAMP);
        ShapeDrawable shape = new ShapeDrawable(new RectShape());
        shape.getPaint().setShader(test);

        colorPicker = (SeekBar)layout.findViewById(R.id.phonePopUpSeekBar);
        colorPicker.setProgressDrawable((Drawable)shape);

        colorPicker.setMax(256 * 7 - 1);

        colorPicker.setProgress(progress);
        colorPicker.setBackgroundColor(color);
        colorPicker.setOnSeekBarChangeListener(new ColorPickerListener());
    }

    private void setupNotificationsPopupWindow()
    {
        LayoutInflater layoutInflater = (LayoutInflater)activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        RelativeLayout relativeLayout = (RelativeLayout)activity.findViewById(R.id.phoneDisplayPopupRelativeLayout);

        layout = layoutInflater.inflate(R.layout.phone_display_popup, relativeLayout);

        ArrayList<CustomBoxData.CustomBoxDataDuple> temp = new ArrayList<>();

        switch(position)
        {
            case 0:

                temp = CustomBoxData.getNotificationsBoxOneList(activity);
                break;

            case 1:
                temp = CustomBoxData.getNotificationsBoxTwoList(activity);
                break;

            case 2:
                temp = CustomBoxData.getNotificationsBoxThreeList(activity);
                break;

            case 3:
                break;

        }

        boolean[] dumb = new boolean[temp.size()];
        String[] dumber = new String[temp.size()];

        for(int i = 0; i < temp.size(); i++)
        {
            dumber[i] = temp.get(i).field.getText();
            dumb[i] = temp.get(i).value;
        }

        popUpAdapter = new PopUpAdapter(activity, dumber, dumb, position, this, menu);
    }

    private void initNotificationsPopupElements()
    {
        //Popup ListView
        popupListView = (ListView)layout.findViewById(R.id.phonePopUpListView);
        popupListView.setDivider(null);
        popupListView.setDividerHeight(0);
        popupListView.setAdapter(popUpAdapter);


        //Popup Exit Button
        exitButton = (ImageView)layout.findViewById(R.id.phonePopUpExitButton);
        exitButton.setOnTouchListener(new TouchListener(exitButton, Color.GRAY));
        exitButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                dismiss();
            }
        });


        //Popup Color Circle
        colorCircle = (ImageView)layout.findViewById(R.id.popupColorCircle);
        GradientDrawable gradientDrawable = (GradientDrawable)colorCircle.getBackground();
        int color = 0;
        int progress = 0;

        switch(position)
        {
            case 0:
                color = UserPreferences.getNotificationsBoxOneColor(activity).getRGB();
                progress = UserPreferences.getNotificationsBoxOneColor(activity).getSliderValue();
                break;

            case 1:
                color = UserPreferences.getNotificationsBoxTwoColor(activity).getRGB();
                progress = UserPreferences.getNotificationsBoxTwoColor(activity).getSliderValue();
                break;

            case 2:
                color = UserPreferences.getNotificationsBoxThreeColor(activity).getRGB();
                progress = UserPreferences.getNotificationsBoxThreeColor(activity).getSliderValue();
                break;

            case 3:
                color = UserPreferences.getNotificationsBoxFourColor(activity).getRGB();
                progress = UserPreferences.getNotificationsBoxFourColor(activity).getSliderValue();
                break;

            default:
                color = Color.BLACK;
        }
        gradientDrawable.setColor(color);


        //SeekBar
        LinearGradient test = new LinearGradient(0.f, 0.f, 1200.f, 0.0f,

                new int[] { 0xFF000000, 0xFF0000FF, 0xFF00FF00, 0xFF00FFFF,
                        0xFFFF0000, 0xFFFF00FF, 0xFFFFFF00, 0xFFFFFFFF},
                null, Shader.TileMode.CLAMP);
        ShapeDrawable shape = new ShapeDrawable(new RectShape());
        shape.getPaint().setShader(test);

        colorPicker = (SeekBar)layout.findViewById(R.id.phonePopUpSeekBar);
        colorPicker.setProgressDrawable((Drawable)shape);

        colorPicker.setMax(256 * 7 - 1);

        colorPicker.setProgress(progress);
        colorPicker.setBackgroundColor(color);
        colorPicker.setOnSeekBarChangeListener(new ColorPickerListener());
    }

    class ColorPickerListener implements SeekBar.OnSeekBarChangeListener
    {

        @Override
        public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser)
        {
            if(fromUser)
            {
                int r = 0;
                int g = 0;
                int b = 0;

                if (progress < 256)
                {
                    b = progress;
                }
                else if (progress < 256 * 2)
                {
                    g = progress % 256;
                    b = 256 - progress % 256;
                }
                else if (progress < 256 * 3)
                {
                    g = 255;
                    b = progress % 256;
                }
                else if (progress < 256 * 4)
                {
                    r = progress % 256;
                    g = 256 - progress % 256;
                    b = 256 - progress % 256;
                }
                else if (progress < 256 * 5)
                {
                    r = 255;
                    g = 0;
                    b = progress % 256;
                }
                else if (progress < 256 * 6)
                {
                    r = 255;
                    g = progress % 256;
                    b = 256 - progress % 256;
                }
                else if (progress < 256 * 7)
                {
                    r = 255;
                    g = 255;
                    b = progress % 256;
                }

                colorPicker.setBackgroundColor(Color.argb(255, r, g, b));
                GradientDrawable gradientDrawable = (GradientDrawable)colorCircle.getBackground();
                gradientDrawable.setColor(Color.argb(255, r, g, b));

                switch(menu) 
                {
                    case PHONE:
                        switch (position) 
                        {
                            case 0:
                                UserPreferences.savePhoneBoxOneColor(activity, r, g, b, progress);
                                break;
    
                            case 1:
                                UserPreferences.savePhoneBoxTwoColor(activity, r, g, b, progress);
                                break;
    
                            case 2:
                                UserPreferences.savePhoneBoxThreeColor(activity, r, g, b, progress);
                                break;
    
                            case 3:
                                UserPreferences.savePhoneBoxFourColor(activity, r, g, b, progress);
                                break;
                        }
                        break;
                    
                    case MESSAGES:
                        switch (position)
                        {
                            case 0:
                                UserPreferences.saveMessagesBoxOneColor(activity, r, g, b, progress);
                                break;

                            case 1:
                                UserPreferences.saveMessagesBoxTwoColor(activity, r, g, b, progress);
                                break;

                            case 2:
                                UserPreferences.saveMessagesBoxThreeColor(activity, r, g, b, progress);
                                break;

                            case 3:
                                UserPreferences.saveMessagesBoxFourColor(activity, r, g, b, progress);
                                break;
                        }
                        break;
                    
                    case EMAIL:
                        switch (position)
                        {
                            case 0:
                                UserPreferences.saveEmailBoxOneColor(activity, r, g, b, progress);
                                break;

                            case 1:
                                UserPreferences.saveEmailBoxTwoColor(activity, r, g, b, progress);
                                break;

                            case 2:
                                UserPreferences.saveEmailBoxThreeColor(activity, r, g, b, progress);
                                break;

                            case 3:
                                UserPreferences.saveEmailBoxFourColor(activity, r, g, b, progress);
                                break;
                        }
                        break;
                    
                    case NOTIFICATION:
                        switch (position)
                        {
                            case 0:
                                UserPreferences.saveNotificationsBoxOneColor(activity, r, g, b, progress);
                                break;

                            case 1:
                                UserPreferences.saveNotificationsBoxTwoColor(activity, r, g, b, progress);
                                break;

                            case 2:
                                UserPreferences.saveNotificationsBoxThreeColor(activity, r, g, b, progress);
                                break;

                            case 3:
                                UserPreferences.saveNotificationsBoxFourColor(activity, r, g, b, progress);
                                break;
                        }
                        break;
                }
            }
        }

        @Override
        public void onStartTrackingTouch(SeekBar seekBar)
        {

        }

        @Override
        public void onStopTrackingTouch(SeekBar seekBar)
        {

        }
    }
}
