package starco.tech.com.starcase.ListAdapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import starco.tech.com.starcase.Activities.DeveloperActivity;
import starco.tech.com.starcase.Activities.EmailActivity;
import starco.tech.com.starcase.Activities.MainActivity;
import starco.tech.com.starcase.Activities.MainMenuActivity;
import starco.tech.com.starcase.Activities.MessagesActivity;
import starco.tech.com.starcase.Activities.NotificationsActivity;
import starco.tech.com.starcase.Activities.PhoneActivity;
import starco.tech.com.starcase.R;

/**
 * Created by Noah on 5/19/2016.
 */
public class MainMenuAdapter extends BaseAdapter
{
    private String[] names;
    private int[] images;
    private Context context;
    private static LayoutInflater inflater = null;

    public MainMenuAdapter(MainMenuActivity mainMenuActivity, String[] names, int[] images)
    {
        this.names = names;
        this.images = images;
        this.context = mainMenuActivity;

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
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent)
    {
        Duple duple = new Duple();

        View rowView;

        rowView = inflater.inflate(R.layout.mainmenu_item, null);
        duple.textView = (TextView)rowView.findViewById(R.id.mainmenu_item_text);
        duple.imageView = (ImageView)rowView.findViewById(R.id.mainmenu_item_image);

        duple.textView.setText(names[position]);
        duple.imageView.setImageResource(images[position]);

        rowView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Intent intent;

                switch(position)
                {
                    //Phone
                    case 0:
                        intent = new Intent(context, PhoneActivity.class);
                        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        context.startActivity(intent);
                        break;

                    //Messages
                    case 1:
                        intent = new Intent(context, MessagesActivity.class);
                        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        context.startActivity(intent);
                        break;

                    //Email
                    case 2:
                        intent = new Intent(context, EmailActivity.class);
                        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        context.startActivity(intent);
                        break;

                    //Notifications
                    case 3:
                        intent = new Intent(context, NotificationsActivity.class);
                        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        context.startActivity(intent);
                        break;

                    //Lightshows
                    case 4:

                        break;

                    //Widgets
                    case 5:

                        break;

                    //Battery
                    case 6:

                        break;

                    //Back Design
                    case 7:

                        break;

                    //Developer
                    case 8:

                        intent = new Intent(context, DeveloperActivity.class);
                        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        context.startActivity(intent);

                        break;


                }
//                Toast.makeText(context, names[position], Toast.LENGTH_SHORT).show();
            }
        });

        return rowView;
    }
}
