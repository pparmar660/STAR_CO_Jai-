package starco.tech.com.starcase.ListAdapters;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Handler;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import starco.tech.com.starcase.Enums.MenuType;
import starco.tech.com.starcase.PopupWindowHandler;
import starco.tech.com.starcase.R;
import starco.tech.com.starcase.UserPreferences;

/**
 * Created by Noah on 5/24/2016.
 */
public class DisplayListAdapter extends BaseAdapter
{

    private String[] names;
    private int[] colors;
    private Context context;
    private static LayoutInflater inflater = null;
    private Activity phoneActivity;

    private Handler handler;
    private MenuType type;

    public DisplayListAdapter(Activity phoneActivity, String[] names, int[] colors, MenuType type, Handler handler)
    {
        this.names = names;
        this.colors = colors;
        this.context = phoneActivity;
        this.phoneActivity = phoneActivity;
        this.handler = handler;
        this.type = type;

        inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount()
    {
        return names.length;
    }

    @Override
    public Object getItem(int position)
    {
        return position;
    }

    @Override
    public long getItemId(int position)
    {
        return position;
    }

    class Duple
    {
        TextView textView;
        ImageView imageView;
        View viewView;
    }

    @Override
    public View getView(final int position, final View convertView, ViewGroup parent)
    {
        final Duple duple = new Duple();

        final View rowView;

        rowView = inflater.inflate(R.layout.phone_display_item, null);
        duple.textView = (TextView)rowView.findViewById(R.id.phoneDisplayItemText);
        duple.imageView = (ImageView)rowView.findViewById(R.id.phoneDisplayItemNumber);
        duple.viewView = (View)rowView.findViewById(R.id.phoneDisplayItemColorWheel);

        duple.textView.setText(names[position]);

        switch(position)
        {
            case 0:
                duple.imageView.setImageResource(R.drawable.one_circle_icon);
                break;

            case 1:
                duple.imageView.setImageResource(R.drawable.two_circle_icon);
                break;

            case 2:
                duple.imageView.setImageResource(R.drawable.three_image_icon);
                break;

            case 3:
                duple.imageView.setImageResource(R.drawable.four_circle_icon);
                break;

            default:
                duple.imageView.setImageResource(R.drawable.starcase_icon);
                break;
        }

        GradientDrawable gradientDrawable = (GradientDrawable) duple.viewView.getBackground();
        gradientDrawable.setColor(colors[position]);
        gradientDrawable.setStroke(1, Color.WHITE);



        rowView.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                PopupWindowHandler popupWindowHandler = new PopupWindowHandler(type, phoneActivity);
                popupWindowHandler.init(position);
                popupWindowHandler.display();

                popupWindowHandler.setOnDismissListener(new PopupWindow.OnDismissListener()
                {
                    @Override
                    public void onDismiss()
                    {
                        switch(type) 
                        {
                            case PHONE:
                                switch (position) 
                                {
                                    case 0:
                                        duple.textView.setText(UserPreferences.getPhoneBoxOne(context).getText());
                                        ((GradientDrawable) duple.viewView.getBackground()).setColor(UserPreferences.getPhoneBoxOneColor(context).getRGB());
                                        break;
    
                                    case 1:
                                        duple.textView.setText(UserPreferences.getPhoneBoxTwo(context).getText());
                                        ((GradientDrawable) duple.viewView.getBackground()).setColor(UserPreferences.getPhoneBoxTwoColor(context).getRGB());
                                        break;
    
                                    case 2:
                                        duple.textView.setText(UserPreferences.getPhoneBoxThree(context).getText());
                                        ((GradientDrawable) duple.viewView.getBackground()).setColor(UserPreferences.getPhoneBoxThreeColor(context).getRGB());
                                        break;
    
                                    case 3:
                                        ((GradientDrawable) duple.viewView.getBackground()).setColor(UserPreferences.getPhoneBoxFourColor(context).getRGB());
                                        break;
                                }
                                break;
                            
                            case MESSAGES:
                                switch(position)
                                {
                                    case 0:
                                        duple.textView.setText(UserPreferences.getMessagesBoxOne(context).getText());
                                        ((GradientDrawable)duple.viewView.getBackground()).setColor(UserPreferences.getPhoneBoxOneColor(context).getRGB());
                                        break;

                                    case 1:
                                        duple.textView.setText(UserPreferences.getMessagesBoxTwo(context).getText());
                                        ((GradientDrawable) duple.viewView.getBackground()).setColor(UserPreferences.getMessagesBoxTwoColor(context).getRGB());
                                        break;

                                    case 2:
                                        duple.textView.setText(UserPreferences.getMessagesBoxThree(context).getText());
                                        ((GradientDrawable) duple.viewView.getBackground()).setColor(UserPreferences.getMessagesBoxThreeColor(context).getRGB());
                                        break;

                                    case 3:
                                        ((GradientDrawable) duple.viewView.getBackground()).setColor(UserPreferences.getMessagesBoxFourColor(context).getRGB());
                                        break;
                                }
                                break;
                            
                            
                            case EMAIL:
                                switch (position)
                                {
                                    case 0:
                                        duple.textView.setText(UserPreferences.getEmailBoxOne(context).getText());
                                        ((GradientDrawable) duple.viewView.getBackground()).setColor(UserPreferences.getEmailBoxOneColor(context).getRGB());
                                        break;

                                    case 1:
                                        duple.textView.setText(UserPreferences.getEmailBoxTwo(context).getText());
                                        ((GradientDrawable) duple.viewView.getBackground()).setColor(UserPreferences.getEmailBoxTwoColor(context).getRGB());
                                        break;

                                    case 2:
                                        duple.textView.setText(UserPreferences.getEmailBoxThree(context).getText());
                                        ((GradientDrawable) duple.viewView.getBackground()).setColor(UserPreferences.getEmailBoxThreeColor(context).getRGB());
                                        break;

                                    case 3:
                                        ((GradientDrawable) duple.viewView.getBackground()).setColor(UserPreferences.getEmailBoxFourColor(context).getRGB());
                                        break;
                                }
                                break;
                            
                            case NOTIFICATION:
                                switch (position)
                                {
                                    case 0:
                                        duple.textView.setText(UserPreferences.getNotificationsBoxOne(context).getText());
                                        ((GradientDrawable) duple.viewView.getBackground()).setColor(UserPreferences.getNotificationsBoxOneColor(context).getRGB());
                                        break;

                                    case 1:
                                        duple.textView.setText(UserPreferences.getNotificationsBoxTwo(context).getText());
                                        ((GradientDrawable) duple.viewView.getBackground()).setColor(UserPreferences.getNotificationsBoxTwoColor(context).getRGB());
                                        break;

                                    case 2:
                                        duple.textView.setText(UserPreferences.getNotificationsBoxThree(context).getText());
                                        ((GradientDrawable) duple.viewView.getBackground()).setColor(UserPreferences.getNotificationsBoxThreeColor(context).getRGB());
                                        break;

                                    case 3:
                                        ((GradientDrawable) duple.viewView.getBackground()).setColor(UserPreferences.getNotificationsBoxFourColor(context).getRGB());
                                        break;
                                }
                                break;
                        }
                        handler.sendMessage(new Message());
                    }
                });
            }
        });


        return rowView;
    }
}
