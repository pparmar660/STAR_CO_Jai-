package starco.tech.com.starcase.ListAdapters;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;

import starco.tech.com.starcase.Enums.CustomBoxData;
import starco.tech.com.starcase.Enums.MenuType;
import starco.tech.com.starcase.R;
import starco.tech.com.starcase.UserPreferences;

/**
 * Created by Noah on 5/25/2016.
 */
public class PopUpAdapter extends BaseAdapter
{

    private String[] names;
    private boolean[] addTo;
    private Context context;
    private static LayoutInflater layoutInflater = null;
    private Activity phoneActivity;
    private int circleNumber;
    private PopupWindow popupWindow;
    private MenuType type;

    public PopUpAdapter(Activity phoneActivity, String[] names, boolean[] addTo, int circleNumber, PopupWindow popupWindow, MenuType type)
    {
        this.names = names;
        this.addTo = addTo;
        this.context = phoneActivity;
        this.phoneActivity = phoneActivity;
        this.circleNumber = circleNumber;
        this.popupWindow = popupWindow;
        this.type = type;

        layoutInflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
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
    }

    @Override
    public View getView(final int position, final View convertView, ViewGroup parent)
    {

        Duple duple = new Duple();

        View rowView;

        rowView = layoutInflater.inflate(R.layout.popup_list_item, null);
        duple.textView = (TextView)rowView.findViewById(R.id.addItemTextView);
        duple.imageView = (ImageView)rowView.findViewById(R.id.addItemImageView);

        duple.textView.setText(names[position]);

        if(!addTo[position])
        {
            duple.imageView.setImageResource(R.drawable.plus_icon);
        }
        else
        {
            duple.imageView.setImageResource(0);
        }

        rowView.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                if(!addTo[position])
                {
                    switch(type) 
                    {
                        case PHONE:
                            switch (circleNumber) 
                            {
                                case 0:
                                    UserPreferences.savePhoneBoxOne(context, CustomBoxData.fromString(names[position]));
                                    break;
    
                                case 1:
                                    UserPreferences.savePhoneBoxTwo(context, CustomBoxData.fromString(names[position]));
                                    break;
    
                                case 2:
                                    UserPreferences.savePhoneBoxThree(context, CustomBoxData.fromString(names[position]));
                                    break;
    
                                case 3:
                                    UserPreferences.savePhoneBoxFour(context, CustomBoxData.fromString(names[position]));
                                    break;
                            }
                            break;
                        
                        case MESSAGES:
                            switch (circleNumber)
                            {
                                case 0:
                                    UserPreferences.saveMessagesBoxOne(context, CustomBoxData.fromString(names[position]));
                                    break;

                                case 1:
                                    UserPreferences.saveMessagesBoxTwo(context, CustomBoxData.fromString(names[position]));
                                    break;

                                case 2:
                                    UserPreferences.saveMessagesBoxThree(context, CustomBoxData.fromString(names[position]));
                                    break;

                                case 3:
                                    UserPreferences.saveMessagesBoxFour(context, CustomBoxData.fromString(names[position]));
                                    break;
                            }
                            break;
                        
                        case EMAIL:
                            switch (circleNumber)
                            {
                                case 0:
                                    UserPreferences.saveEmailBoxOne(context, CustomBoxData.fromString(names[position]));
                                    break;

                                case 1:
                                    UserPreferences.saveEmailBoxTwo(context, CustomBoxData.fromString(names[position]));
                                    break;

                                case 2:
                                    UserPreferences.saveEmailBoxThree(context, CustomBoxData.fromString(names[position]));
                                    break;

                                case 3:
                                    UserPreferences.saveEmailBoxFour(context, CustomBoxData.fromString(names[position]));
                                    break;
                            }
                            break;
                        
                        case NOTIFICATION:
                            switch (circleNumber)
                            {
                                case 0:
                                    UserPreferences.saveNotificationsBoxOne(context, CustomBoxData.fromString(names[position]));
                                    break;

                                case 1:
                                    UserPreferences.saveNotificationsBoxTwo(context, CustomBoxData.fromString(names[position]));
                                    break;

                                case 2:
                                    UserPreferences.saveNotificationsBoxThree(context, CustomBoxData.fromString(names[position]));
                                    break;

                                case 3:
                                    UserPreferences.saveNotificationsBoxFour(context, CustomBoxData.fromString(names[position]));
                                    break;
                            }
                            break;
                    }

                    popupWindow.dismiss();
                }
            }
        });

        return rowView;
    }
}
