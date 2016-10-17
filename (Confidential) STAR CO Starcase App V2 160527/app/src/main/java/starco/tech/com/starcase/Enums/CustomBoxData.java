package starco.tech.com.starcase.Enums;

import android.content.Context;
import android.support.annotation.NonNull;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import starco.tech.com.starcase.UserPreferences;

/**
 * Created by Noah on 5/26/2016.
 */
public enum CustomBoxData
{
    CALL_ICON("Call Icon"),
    CONTACT_PICTURE("Contact Picture"),
    CALL("Call"),
    FIRST_NAME("First Name"),
    LAST_NAME("Last Name"),
    FIRST_NAME_LAST_INITIAL("First Name, Last Initial"),
    LAST_NAME_FIRST_INITIAL("Last Name, First Initial"),
    FIRST_NAME_LAST_NAME("First Name, Last Name"),
    LAST_NAME_FIRST_NAME("Last Name, First Name"),
    PHONE_NUMBER("Phone Number"),
    COMPANY("Company"),
    CUSTOM("Custom"),
    MESSAGES_ICON("Messages Icon"),
    TEXT("Text"),
    TEXT_PREVIEW("Text Preview"),
    FULL_TEXT("Full Text"),
    EMAIL_ICON("Email Icon"),
    EMAIL("Email"),
    EMAIL_ADDRESS("Email Address"),
    SUBJECT_OF_EMAIL("Subject of Email"),
    EMAIL_PREVIEW("Email Preview"),
    NOTIFICATIONS_ICON("Notifications Icon"),
    TITLE("Title"),
    SUBJECT("Subject"),
    ERROR("Error");

    private String text;

    CustomBoxData(String text)
    {
        this.text = text;
    }

    public String getText()
    {
        return this.text;
    }

    public static CustomBoxData fromString(String text) {
        if (text != null) {
            for (CustomBoxData b : CustomBoxData.values()) {
                if (text.equalsIgnoreCase(b.text)) {
                    return b;
                }
            }
        }
        return ERROR;
    }

    public static class CustomBoxDataDuple
    {
        public CustomBoxData field;
        public boolean value;
        
        public CustomBoxDataDuple(CustomBoxData field, boolean value)
        {
            this.field = field;
            this.value = value;
        }
    }

    /*

            Phone Lists

     */

    public static ArrayList<CustomBoxDataDuple> getPhoneBoxOneList(Context context)
    {
        ArrayList<CustomBoxDataDuple> map = new ArrayList<>();
        map.add(new CustomBoxDataDuple(CALL_ICON, false));
        map.add(new CustomBoxDataDuple(CONTACT_PICTURE, false));

        CustomBoxData chosen = UserPreferences.getPhoneBoxOne(context);

        for(int i = 0; i < map.size(); i++)
        {
            if(map.get(i).field == chosen)
            {
                map.set(i, new CustomBoxDataDuple(chosen, true));
            }
        }

        return map;
    }

    public static ArrayList<CustomBoxDataDuple> getPhoneBoxTwoList(Context context)
    {
        ArrayList<CustomBoxDataDuple> map = new ArrayList<>();
        map.add(new CustomBoxDataDuple(CALL, false));
        map.add(new CustomBoxDataDuple(FIRST_NAME, false));
        map.add(new CustomBoxDataDuple(LAST_NAME, false));
        map.add(new CustomBoxDataDuple(FIRST_NAME_LAST_INITIAL, false));
        map.add(new CustomBoxDataDuple(LAST_NAME_FIRST_INITIAL, false));
        map.add(new CustomBoxDataDuple(FIRST_NAME_LAST_NAME, false));
        map.add(new CustomBoxDataDuple(LAST_NAME_FIRST_NAME, false));
        map.add(new CustomBoxDataDuple(PHONE_NUMBER, false));
        map.add(new CustomBoxDataDuple(COMPANY, false));
        map.add(new CustomBoxDataDuple(CUSTOM, false));

        CustomBoxData chosenTwo = UserPreferences.getPhoneBoxTwo(context);
        CustomBoxData chosenThree = UserPreferences.getPhoneBoxThree(context);

        for(int i = 0; i < map.size(); i++)
        {
            if(map.get(i).field == chosenTwo)
            {
                map.set(i, new CustomBoxDataDuple(chosenTwo, true));
            }
            else if(map.get(i).field == chosenThree)
            {
                map.set(i, new CustomBoxDataDuple(chosenThree, true));
            }
        }

        return map;
    }

    public static ArrayList<CustomBoxDataDuple> getPhoneBoxThreeList(Context context)
    {
        ArrayList<CustomBoxDataDuple> map = new ArrayList<>();
        map.add(new CustomBoxDataDuple(CALL, false));
        map.add(new CustomBoxDataDuple(FIRST_NAME, false));
        map.add(new CustomBoxDataDuple(LAST_NAME, false));
        map.add(new CustomBoxDataDuple(FIRST_NAME_LAST_INITIAL, false));
        map.add(new CustomBoxDataDuple(LAST_NAME_FIRST_INITIAL, false));
        map.add(new CustomBoxDataDuple(FIRST_NAME_LAST_NAME, false));
        map.add(new CustomBoxDataDuple(LAST_NAME_FIRST_NAME, false));
        map.add(new CustomBoxDataDuple(PHONE_NUMBER, false));
        map.add(new CustomBoxDataDuple(COMPANY, false));
        map.add(new CustomBoxDataDuple(CUSTOM, false));

        CustomBoxData chosenTwo = UserPreferences.getPhoneBoxTwo(context);
        CustomBoxData chosenThree = UserPreferences.getPhoneBoxThree(context);

        for(int i = 0; i < map.size(); i++)
        {
            if(map.get(i).field == chosenTwo)
            {
                map.set(i, new CustomBoxDataDuple(chosenTwo, true));
            }
            else if(map.get(i).field == chosenThree)
            {
                map.set(i, new CustomBoxDataDuple(chosenThree, true));
            }
        }

        return map;
    }
    
    
    /*
    
            Messages List
    
     */

    public static ArrayList<CustomBoxDataDuple> getMessagesBoxOneList(Context context)
{
    ArrayList<CustomBoxDataDuple> map = new ArrayList<>();
    map.add(new CustomBoxDataDuple(MESSAGES_ICON, false));
    map.add(new CustomBoxDataDuple(CONTACT_PICTURE, false));

    CustomBoxData chosen = UserPreferences.getMessagesBoxOne(context);

    for(int i = 0; i < map.size(); i++)
    {
        if(map.get(i).field == chosen)
        {
            map.set(i, new CustomBoxDataDuple(chosen, true));
        }
    }

    return map;
}

    public static ArrayList<CustomBoxDataDuple> getMessagesBoxTwoList(Context context)
    {
        ArrayList<CustomBoxDataDuple> map = new ArrayList<>();
        map.add(new CustomBoxDataDuple(TEXT, false));
        map.add(new CustomBoxDataDuple(FIRST_NAME, false));
        map.add(new CustomBoxDataDuple(LAST_NAME, false));
        map.add(new CustomBoxDataDuple(FIRST_NAME_LAST_INITIAL, false));
        map.add(new CustomBoxDataDuple(LAST_NAME_FIRST_INITIAL, false));
        map.add(new CustomBoxDataDuple(FIRST_NAME_LAST_NAME, false));
        map.add(new CustomBoxDataDuple(LAST_NAME_FIRST_NAME, false));
        map.add(new CustomBoxDataDuple(PHONE_NUMBER, false));
        map.add(new CustomBoxDataDuple(COMPANY, false));
        map.add(new CustomBoxDataDuple(TEXT_PREVIEW, false));
        map.add(new CustomBoxDataDuple(FULL_TEXT, false));
        map.add(new CustomBoxDataDuple(CUSTOM, false));

        CustomBoxData chosenTwo = UserPreferences.getMessagesBoxTwo(context);
        CustomBoxData chosenThree = UserPreferences.getMessagesBoxThree(context);

        for(int i = 0; i < map.size(); i++)
        {
            if(map.get(i).field == chosenTwo)
            {
                map.set(i, new CustomBoxDataDuple(chosenTwo, true));
            }
            else if(map.get(i).field == chosenThree)
            {
                map.set(i, new CustomBoxDataDuple(chosenThree, true));
            }
        }

        return map;
    }

    public static ArrayList<CustomBoxDataDuple> getMessagesBoxThreeList(Context context)
    {
        ArrayList<CustomBoxDataDuple> map = new ArrayList<>();
        map.add(new CustomBoxDataDuple(TEXT, false));
        map.add(new CustomBoxDataDuple(FIRST_NAME, false));
        map.add(new CustomBoxDataDuple(LAST_NAME, false));
        map.add(new CustomBoxDataDuple(FIRST_NAME_LAST_INITIAL, false));
        map.add(new CustomBoxDataDuple(LAST_NAME_FIRST_INITIAL, false));
        map.add(new CustomBoxDataDuple(FIRST_NAME_LAST_NAME, false));
        map.add(new CustomBoxDataDuple(LAST_NAME_FIRST_NAME, false));
        map.add(new CustomBoxDataDuple(PHONE_NUMBER, false));
        map.add(new CustomBoxDataDuple(COMPANY, false));
        map.add(new CustomBoxDataDuple(TEXT_PREVIEW, false));
        map.add(new CustomBoxDataDuple(FULL_TEXT, false));
        map.add(new CustomBoxDataDuple(CUSTOM, false));

        CustomBoxData chosenTwo = UserPreferences.getMessagesBoxTwo(context);
        CustomBoxData chosenThree = UserPreferences.getMessagesBoxThree(context);

        for(int i = 0; i < map.size(); i++)
        {
            if(map.get(i).field == chosenTwo)
            {
                map.set(i, new CustomBoxDataDuple(chosenTwo, true));
            }
            else if(map.get(i).field == chosenThree)
            {
                map.set(i, new CustomBoxDataDuple(chosenThree, true));
            }
        }

        return map;
    }


    /*

            Email Lists

     */

    public static ArrayList<CustomBoxDataDuple> getEmailBoxOneList(Context context)
    {
        ArrayList<CustomBoxDataDuple> map = new ArrayList<>();
        map.add(new CustomBoxDataDuple(EMAIL_ICON, false));
        map.add(new CustomBoxDataDuple(CONTACT_PICTURE, false));

        CustomBoxData chosen = UserPreferences.getEmailBoxOne(context);

        for(int i = 0; i < map.size(); i++)
        {
            if(map.get(i).field == chosen)
            {
                map.set(i, new CustomBoxDataDuple(chosen, true));
            }
        }

        return map;
    }

    public static ArrayList<CustomBoxDataDuple> getEmailBoxTwoList(Context context)
    {
        ArrayList<CustomBoxDataDuple> map = new ArrayList<>();
        map.add(new CustomBoxDataDuple(EMAIL, false));
        map.add(new CustomBoxDataDuple(FIRST_NAME, false));
        map.add(new CustomBoxDataDuple(LAST_NAME, false));
        map.add(new CustomBoxDataDuple(FIRST_NAME_LAST_INITIAL, false));
        map.add(new CustomBoxDataDuple(LAST_NAME_FIRST_INITIAL, false));
        map.add(new CustomBoxDataDuple(FIRST_NAME_LAST_NAME, false));
        map.add(new CustomBoxDataDuple(LAST_NAME_FIRST_NAME, false));
        map.add(new CustomBoxDataDuple(EMAIL_ADDRESS, false));
        map.add(new CustomBoxDataDuple(SUBJECT_OF_EMAIL, false));
        map.add(new CustomBoxDataDuple(EMAIL_PREVIEW, false));
        map.add(new CustomBoxDataDuple(FULL_TEXT, false));
        map.add(new CustomBoxDataDuple(CUSTOM, false));

        CustomBoxData chosenTwo = UserPreferences.getEmailBoxTwo(context);
        CustomBoxData chosenThree = UserPreferences.getEmailBoxThree(context);

        for(int i = 0; i < map.size(); i++)
        {
            if(map.get(i).field == chosenTwo)
            {
                map.set(i, new CustomBoxDataDuple(chosenTwo, true));
            }
            else if(map.get(i).field == chosenThree)
            {
                map.set(i, new CustomBoxDataDuple(chosenThree, true));
            }
        }

        return map;
    }

    public static ArrayList<CustomBoxDataDuple> getEmailBoxThreeList(Context context)
    {
        ArrayList<CustomBoxDataDuple> map = new ArrayList<>();
        map.add(new CustomBoxDataDuple(EMAIL, false));
        map.add(new CustomBoxDataDuple(FIRST_NAME, false));
        map.add(new CustomBoxDataDuple(LAST_NAME, false));
        map.add(new CustomBoxDataDuple(FIRST_NAME_LAST_INITIAL, false));
        map.add(new CustomBoxDataDuple(LAST_NAME_FIRST_INITIAL, false));
        map.add(new CustomBoxDataDuple(FIRST_NAME_LAST_NAME, false));
        map.add(new CustomBoxDataDuple(LAST_NAME_FIRST_NAME, false));
        map.add(new CustomBoxDataDuple(EMAIL_ADDRESS, false));
        map.add(new CustomBoxDataDuple(SUBJECT_OF_EMAIL, false));
        map.add(new CustomBoxDataDuple(EMAIL_PREVIEW, false));
        map.add(new CustomBoxDataDuple(FULL_TEXT, false));
        map.add(new CustomBoxDataDuple(CUSTOM, false));

        CustomBoxData chosenTwo = UserPreferences.getEmailBoxTwo(context);
        CustomBoxData chosenThree = UserPreferences.getEmailBoxThree(context);

        for(int i = 0; i < map.size(); i++)
        {
            if(map.get(i).field == chosenTwo)
            {
                map.set(i, new CustomBoxDataDuple(chosenTwo, true));
            }
            else if(map.get(i).field == chosenThree)
            {
                map.set(i, new CustomBoxDataDuple(chosenThree, true));
            }
        }

        return map;
    }
    
    
    /*
    
            Notifications Lists
    
     */

    public static ArrayList<CustomBoxDataDuple> getNotificationsBoxOneList(Context context)
    {
        ArrayList<CustomBoxDataDuple> map = new ArrayList<>();
        map.add(new CustomBoxDataDuple(NOTIFICATIONS_ICON, false));
        map.add(new CustomBoxDataDuple(CONTACT_PICTURE, false));

        CustomBoxData chosen = UserPreferences.getNotificationsBoxOne(context);

        for(int i = 0; i < map.size(); i++)
        {
            if(map.get(i).field == chosen)
            {
                map.set(i, new CustomBoxDataDuple(chosen, true));
            }
        }

        return map;
    }

    public static ArrayList<CustomBoxDataDuple> getNotificationsBoxTwoList(Context context)
    {
        ArrayList<CustomBoxDataDuple> map = new ArrayList<>();
        map.add(new CustomBoxDataDuple(TITLE, false));
        map.add(new CustomBoxDataDuple(SUBJECT, false));
        map.add(new CustomBoxDataDuple(TEXT, false));
        map.add(new CustomBoxDataDuple(CUSTOM, false));

        CustomBoxData chosenTwo = UserPreferences.getNotificationsBoxTwo(context);
        CustomBoxData chosenThree = UserPreferences.getNotificationsBoxThree(context);

        for(int i = 0; i < map.size(); i++)
        {
            if(map.get(i).field == chosenTwo)
            {
                map.set(i, new CustomBoxDataDuple(chosenTwo, true));
            }
            else if(map.get(i).field == chosenThree)
            {
                map.set(i, new CustomBoxDataDuple(chosenThree, true));
            }
        }

        return map;
    }

    public static ArrayList<CustomBoxDataDuple> getNotificationsBoxThreeList(Context context)
    {
        ArrayList<CustomBoxDataDuple> map = new ArrayList<>();
        map.add(new CustomBoxDataDuple(TITLE, false));
        map.add(new CustomBoxDataDuple(SUBJECT, false));
        map.add(new CustomBoxDataDuple(TEXT, false));
        map.add(new CustomBoxDataDuple(CUSTOM, false));

        CustomBoxData chosenTwo = UserPreferences.getNotificationsBoxTwo(context);
        CustomBoxData chosenThree = UserPreferences.getNotificationsBoxThree(context);

        for(int i = 0; i < map.size(); i++)
        {
            if(map.get(i).field == chosenTwo)
            {
                map.set(i, new CustomBoxDataDuple(chosenTwo, true));
            }
            else if(map.get(i).field == chosenThree)
            {
                map.set(i, new CustomBoxDataDuple(chosenThree, true));
            }
        }

        return map;
    }

}
