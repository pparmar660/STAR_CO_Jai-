package starco.tech.com.starcase.ListAdapters;

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import starco.tech.com.starcase.Activities.DeveloperActivity;
import starco.tech.com.starcase.R;

/**
 * Created by Noah on 5/20/2016.
 */
public class USBTestAdapter extends BaseAdapter
{
    private ArrayList<String> sentMessages;
    private ArrayList<String> receivedMessages;
    private Context context;
    private static LayoutInflater inflater = null;

    public USBTestAdapter(DeveloperActivity developerActivity)
    {
        this.context = developerActivity;

        sentMessages = new ArrayList<>();
        receivedMessages = new ArrayList<>();

        inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount()
    {
        return sentMessages.size();
    }

    @Override
    public Object getItem(int position)
    {
        return position;
    }

    public void addSent(String sent)
    {
        sentMessages.add(sent);
        receivedMessages.add(null);

        this.notifyDataSetChanged();
    }

    public void addReceived(String received)
    {
        if(receivedMessages.size() == 0)
        {
            sentMessages.add("");
            receivedMessages.add(received);
        }
        else
        {
            receivedMessages.set(receivedMessages.size() - 1, received);
        }

        this.notifyDataSetChanged();
    }

    @Override
    public long getItemId(int position)
    {
        return position;
    }

    class Duple
    {
        TextView sent;
        TextView received;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent)
    {
        Duple duple = new Duple();

        View rowView;

        rowView = inflater.inflate(R.layout.message_item, null);
        duple.sent = (TextView)rowView.findViewById(R.id.sentTextView);
        duple.received = (TextView)rowView.findViewById(R.id.receivedTextView);

        duple.sent.setText(sentMessages.get(position));
        duple.received.setText(receivedMessages.get(position));

        return rowView;
    }
}
