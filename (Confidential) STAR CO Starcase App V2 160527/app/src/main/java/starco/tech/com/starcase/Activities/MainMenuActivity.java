package starco.tech.com.starcase.Activities;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

import starco.tech.com.starcase.ListAdapters.MainMenuAdapter;
import starco.tech.com.starcase.R;

/**
 * Created by Noah on 5/19/2016.
 */
public class MainMenuActivity extends Activity
{
    private ListView listView;

    private static int[] images = {R.drawable.phone_icon, R.drawable.messages_icon, R.drawable.email_icon, R.drawable.notifications_icon, R.drawable.lightshow_icon,
                                    R.drawable.widgets_icon, R.drawable.battery_icon, R.drawable.backdesign_icon, R.drawable.restore_icon};

    private static String[] names = {"Phone", "Messages", "Email", "Notifications", "Lightshows for Contacts", "Widgets", "Battery", "Back Design", "Developer Options"};

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mainmenu_screen);

        listView = (ListView)findViewById(R.id.mainmenu_listview);
        listView.setDivider(null);
        listView.setDividerHeight(0);
        listView.setAdapter(new MainMenuAdapter(this, names, images));
    }

}
