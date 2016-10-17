package starco.tech.com.starcase;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.widget.Toast;

import starco.tech.com.starcase.Enums.CustomBoxData;

/**
 * Created by Noah on 5/26/2016.
 */
public class UserPreferences
{

    public static class RGB
    {
        int red;
        int green;
        int blue;
        int sliderValue;

        public int getRGB()
        {
            return Color.rgb(red, green, blue);
        }

        public int getSliderValue()
        {
            return sliderValue;
        }
    }

    /*

            Phone Getters and Setters

     */

    public static void savePhoneBoxOne(Context context, CustomBoxData field)
    {
        SharedPreferences sharedPreferences = context.getSharedPreferences("USER_SETTINGS", Context.MODE_PRIVATE);
        sharedPreferences.edit().putString("Phone_Box_One", field.getText()).commit();
        
    }

    public static CustomBoxData getPhoneBoxOne(Context context)
    {
        SharedPreferences sharedPreferences = context.getSharedPreferences("USER_SETTINGS", Context.MODE_PRIVATE);
        return CustomBoxData.fromString(sharedPreferences.getString("Phone_Box_One", null));
    }

    public static void savePhoneBoxOneColor(Context context, int red, int green, int blue, int sliderValue)
    {
        SharedPreferences sharedPreferences = context.getSharedPreferences("USER_SETTINGS", Context.MODE_PRIVATE);
        sharedPreferences.edit().putInt("Phone_Box_One_R", red).commit();
        sharedPreferences.edit().putInt("Phone_Box_One_G", green).commit();
        sharedPreferences.edit().putInt("Phone_Box_One_B", blue).commit();
        sharedPreferences.edit().putInt("Phone_Box_One_Slider", sliderValue).commit();
        
    }

    public static RGB getPhoneBoxOneColor(Context context)
    {
        SharedPreferences sharedPreferences = context.getSharedPreferences("USER_SETTINGS", Context.MODE_PRIVATE);
        RGB rgb = new RGB();
        rgb.red = sharedPreferences.getInt("Phone_Box_One_R", 0);
        rgb.green = sharedPreferences.getInt("Phone_Box_One_G", 0);
        rgb.blue = sharedPreferences.getInt("Phone_Box_One_B", 0);
        rgb.sliderValue = sharedPreferences.getInt("Phone_Box_One_Slider", 0);
        return rgb;
    }

    public static void savePhoneBoxTwo(Context context, CustomBoxData field)
    {
        SharedPreferences sharedPreferences = context.getSharedPreferences("USER_SETTINGS", Context.MODE_PRIVATE);
        sharedPreferences.edit().putString("Phone_Box_Two", field.getText()).commit();
        
    }

    public static CustomBoxData getPhoneBoxTwo(Context context)
    {
        SharedPreferences sharedPreferences = context.getSharedPreferences("USER_SETTINGS", Context.MODE_PRIVATE);
        return CustomBoxData.fromString(sharedPreferences.getString("Phone_Box_Two", null));
    }

    public static void savePhoneBoxTwoColor(Context context, int red, int green, int blue, int sliderValue)
    {
        SharedPreferences sharedPreferences = context.getSharedPreferences("USER_SETTINGS", Context.MODE_PRIVATE);
        sharedPreferences.edit().putInt("Phone_Box_Two_R", red).commit();
        sharedPreferences.edit().putInt("Phone_Box_Two_G", green).commit();
        sharedPreferences.edit().putInt("Phone_Box_Two_B", blue).commit();
        sharedPreferences.edit().putInt("Phone_Box_Two_Slider", sliderValue).commit();
        
    }

    public static RGB getPhoneBoxTwoColor(Context context)
    {
        SharedPreferences sharedPreferences = context.getSharedPreferences("USER_SETTINGS", Context.MODE_PRIVATE);
        RGB rgb = new RGB();
        rgb.red = sharedPreferences.getInt("Phone_Box_Two_R", 0);
        rgb.green = sharedPreferences.getInt("Phone_Box_Two_G", 0);
        rgb.blue = sharedPreferences.getInt("Phone_Box_Two_B", 0);
        rgb.sliderValue = sharedPreferences.getInt("Phone_Box_Two_Slider", 0);
        return rgb;
    }

    public static void savePhoneBoxThree(Context context, CustomBoxData field)
    {
        SharedPreferences sharedPreferences = context.getSharedPreferences("USER_SETTINGS", Context.MODE_PRIVATE);
        sharedPreferences.edit().putString("Phone_Box_Three", field.getText()).commit();
        
    }

    public static CustomBoxData getPhoneBoxThree(Context context)
    {
        SharedPreferences sharedPreferences = context.getSharedPreferences("USER_SETTINGS", Context.MODE_PRIVATE);
        return CustomBoxData.fromString(sharedPreferences.getString("Phone_Box_Three", null));
    }

    public static void savePhoneBoxThreeColor(Context context, int red, int green, int blue, int sliderValue)
    {
        SharedPreferences sharedPreferences = context.getSharedPreferences("USER_SETTINGS", Context.MODE_PRIVATE);
        sharedPreferences.edit().putInt("Phone_Box_Three_R", red).commit();
        sharedPreferences.edit().putInt("Phone_Box_Three_G", green).commit();
        sharedPreferences.edit().putInt("Phone_Box_Three_B", blue).commit();
        sharedPreferences.edit().putInt("Phone_Box_Three_Slider", sliderValue).commit();
        
    }

    public static RGB getPhoneBoxThreeColor(Context context)
    {
        SharedPreferences sharedPreferences = context.getSharedPreferences("USER_SETTINGS", Context.MODE_PRIVATE);
        RGB rgb = new RGB();
        rgb.red = sharedPreferences.getInt("Phone_Box_Three_R", 0);
        rgb.green = sharedPreferences.getInt("Phone_Box_Three_G", 0);
        rgb.blue = sharedPreferences.getInt("Phone_Box_Three_B", 0);
        rgb.sliderValue = sharedPreferences.getInt("Phone_Box_Three_Slider", 0);
        return rgb;
    }

    public static void savePhoneBoxFour(Context context, CustomBoxData field)
    {
        SharedPreferences sharedPreferences = context.getSharedPreferences("USER_SETTINGS", Context.MODE_PRIVATE);
        sharedPreferences.edit().putString("Phone_Box_Four", field.getText()).commit();
        
    }

    public static CustomBoxData getPhoneBoxFour(Context context)
    {
        SharedPreferences sharedPreferences = context.getSharedPreferences("USER_SETTINGS", Context.MODE_PRIVATE);
        return CustomBoxData.fromString(sharedPreferences.getString("Phone_Box_Four", null));
    }

    public static void savePhoneBoxFourColor(Context context, int red, int green, int blue, int sliderValue)
    {
        SharedPreferences sharedPreferences = context.getSharedPreferences("USER_SETTINGS", Context.MODE_PRIVATE);
        sharedPreferences.edit().putInt("Phone_Box_Four_R", red).commit();
        sharedPreferences.edit().putInt("Phone_Box_Four_G", green).commit();
        sharedPreferences.edit().putInt("Phone_Box_Four_B", blue).commit();
        sharedPreferences.edit().putInt("Phone_Box_Four_Slider", sliderValue).commit();
        
    }

    public static RGB getPhoneBoxFourColor(Context context)
    {
        SharedPreferences sharedPreferences = context.getSharedPreferences("USER_SETTINGS", Context.MODE_PRIVATE);
        RGB rgb = new RGB();
        rgb.red = sharedPreferences.getInt("Phone_Box_Four_R", 0);
        rgb.green = sharedPreferences.getInt("Phone_Box_Four_G", 0);
        rgb.blue = sharedPreferences.getInt("Phone_Box_Four_B", 0);
        rgb.sliderValue = sharedPreferences.getInt("Phone_Box_Four_Slider", 0);
        return rgb;
    }



    /*

            Messages Getters and Setters

     */

    public static void saveMessagesBoxOne(Context context, CustomBoxData field)
    {
        SharedPreferences sharedPreferences = context.getSharedPreferences("USER_SETTINGS", Context.MODE_PRIVATE);
        sharedPreferences.edit().putString("Messages_Box_One", field.getText()).commit();
        
    }

    public static CustomBoxData getMessagesBoxOne(Context context)
    {
        SharedPreferences sharedPreferences = context.getSharedPreferences("USER_SETTINGS", Context.MODE_PRIVATE);
        return CustomBoxData.fromString(sharedPreferences.getString("Messages_Box_One", null));
    }

    public static void saveMessagesBoxOneColor(Context context, int red, int green, int blue, int sliderValue)
    {
        SharedPreferences sharedPreferences = context.getSharedPreferences("USER_SETTINGS", Context.MODE_PRIVATE);
        sharedPreferences.edit().putInt("Messages_Box_One_R", red).commit();
        sharedPreferences.edit().putInt("Messages_Box_One_G", green).commit();
        sharedPreferences.edit().putInt("Messages_Box_One_B", blue).commit();
        sharedPreferences.edit().putInt("Messages_Box_One_Slider", sliderValue).commit();
        
    }

    public static RGB getMessagesBoxOneColor(Context context)
    {
        SharedPreferences sharedPreferences = context.getSharedPreferences("USER_SETTINGS", Context.MODE_PRIVATE);
        RGB rgb = new RGB();
        rgb.red = sharedPreferences.getInt("Messages_Box_One_R", 0);
        rgb.green = sharedPreferences.getInt("Messages_Box_One_G", 0);
        rgb.blue = sharedPreferences.getInt("Messages_Box_One_B", 0);
        rgb.sliderValue = sharedPreferences.getInt("Messages_Box_One_Slider", 0);
        return rgb;
    }

    public static void saveMessagesBoxTwo(Context context, CustomBoxData field)
    {
        SharedPreferences sharedPreferences = context.getSharedPreferences("USER_SETTINGS", Context.MODE_PRIVATE);
        sharedPreferences.edit().putString("Messages_Box_Two", field.getText()).commit();
        
    }

    public static CustomBoxData getMessagesBoxTwo(Context context)
    {
        SharedPreferences sharedPreferences = context.getSharedPreferences("USER_SETTINGS", Context.MODE_PRIVATE);
        return CustomBoxData.fromString(sharedPreferences.getString("Messages_Box_Two", null));
    }

    public static void saveMessagesBoxTwoColor(Context context, int red, int green, int blue, int sliderValue)
    {
        SharedPreferences sharedPreferences = context.getSharedPreferences("USER_SETTINGS", Context.MODE_PRIVATE);
        sharedPreferences.edit().putInt("Messages_Box_Two_R", red).commit();
        sharedPreferences.edit().putInt("Messages_Box_Two_G", green).commit();
        sharedPreferences.edit().putInt("Messages_Box_Two_B", blue).commit();
        sharedPreferences.edit().putInt("Messages_Box_Two_Slider", sliderValue).commit();
        
    }

    public static RGB getMessagesBoxTwoColor(Context context)
    {
        SharedPreferences sharedPreferences = context.getSharedPreferences("USER_SETTINGS", Context.MODE_PRIVATE);
        RGB rgb = new RGB();
        rgb.red = sharedPreferences.getInt("Messages_Box_Two_R", 0);
        rgb.green = sharedPreferences.getInt("Messages_Box_Two_G", 0);
        rgb.blue = sharedPreferences.getInt("Messages_Box_Two_B", 0);
        rgb.sliderValue = sharedPreferences.getInt("Messages_Box_Two_Slider", 0);
        return rgb;
    }

    public static void saveMessagesBoxThree(Context context, CustomBoxData field)
    {
        SharedPreferences sharedPreferences = context.getSharedPreferences("USER_SETTINGS", Context.MODE_PRIVATE);
        sharedPreferences.edit().putString("Messages_Box_Three", field.getText()).commit();
        
    }

    public static CustomBoxData getMessagesBoxThree(Context context)
    {
        SharedPreferences sharedPreferences = context.getSharedPreferences("USER_SETTINGS", Context.MODE_PRIVATE);
        return CustomBoxData.fromString(sharedPreferences.getString("Messages_Box_Three", null));
    }

    public static void saveMessagesBoxThreeColor(Context context, int red, int green, int blue, int sliderValue)
    {
        SharedPreferences sharedPreferences = context.getSharedPreferences("USER_SETTINGS", Context.MODE_PRIVATE);
        sharedPreferences.edit().putInt("Messages_Box_Three_R", red).commit();
        sharedPreferences.edit().putInt("Messages_Box_Three_G", green).commit();
        sharedPreferences.edit().putInt("Messages_Box_Three_B", blue).commit();
        sharedPreferences.edit().putInt("Messages_Box_Three_Slider", sliderValue).commit();
        
    }

    public static RGB getMessagesBoxThreeColor(Context context)
    {
        SharedPreferences sharedPreferences = context.getSharedPreferences("USER_SETTINGS", Context.MODE_PRIVATE);
        RGB rgb = new RGB();
        rgb.red = sharedPreferences.getInt("Messages_Box_Three_R", 0);
        rgb.green = sharedPreferences.getInt("Messages_Box_Three_G", 0);
        rgb.blue = sharedPreferences.getInt("Messages_Box_Three_B", 0);
        rgb.sliderValue = sharedPreferences.getInt("Messages_Box_Three_Slider", 0);
        return rgb;
    }

    public static void saveMessagesBoxFour(Context context, CustomBoxData field)
    {
        SharedPreferences sharedPreferences = context.getSharedPreferences("USER_SETTINGS", Context.MODE_PRIVATE);
        sharedPreferences.edit().putString("Messages_Box_Four", field.getText()).commit();
        
    }

    public static CustomBoxData getMessagesBoxFour(Context context)
    {
        SharedPreferences sharedPreferences = context.getSharedPreferences("USER_SETTINGS", Context.MODE_PRIVATE);
        return CustomBoxData.fromString(sharedPreferences.getString("Messages_Box_Four", null));
    }

    public static void saveMessagesBoxFourColor(Context context, int red, int green, int blue, int sliderValue)
    {
        SharedPreferences sharedPreferences = context.getSharedPreferences("USER_SETTINGS", Context.MODE_PRIVATE);
        sharedPreferences.edit().putInt("Messages_Box_Four_R", red).commit();
        sharedPreferences.edit().putInt("Messages_Box_Four_G", green).commit();
        sharedPreferences.edit().putInt("Messages_Box_Four_B", blue).commit();
        sharedPreferences.edit().putInt("Messages_Box_Four_Slider", sliderValue).commit();
        
    }

    public static RGB getMessagesBoxFourColor(Context context)
    {
        SharedPreferences sharedPreferences = context.getSharedPreferences("USER_SETTINGS", Context.MODE_PRIVATE);
        RGB rgb = new RGB();
        rgb.red = sharedPreferences.getInt("Messages_Box_Four_R", 0);
        rgb.green = sharedPreferences.getInt("Messages_Box_Four_G", 0);
        rgb.blue = sharedPreferences.getInt("Messages_Box_Four_B", 0);
        rgb.sliderValue = sharedPreferences.getInt("Messages_Box_Four_Slider", 0);
        return rgb;
    }

    /*

            Messages Getters and Setters

     */

    public static void saveEmailBoxOne(Context context, CustomBoxData field)
    {
        SharedPreferences sharedPreferences = context.getSharedPreferences("USER_SETTINGS", Context.MODE_PRIVATE);
        sharedPreferences.edit().putString("Email_Box_One", field.getText()).commit();
        
    }

    public static CustomBoxData getEmailBoxOne(Context context)
    {
        SharedPreferences sharedPreferences = context.getSharedPreferences("USER_SETTINGS", Context.MODE_PRIVATE);
        return CustomBoxData.fromString(sharedPreferences.getString("Email_Box_One", null));
    }

    public static void saveEmailBoxOneColor(Context context, int red, int green, int blue, int sliderValue)
    {
        SharedPreferences sharedPreferences = context.getSharedPreferences("USER_SETTINGS", Context.MODE_PRIVATE);
        sharedPreferences.edit().putInt("Email_Box_One_R", red).commit();
        sharedPreferences.edit().putInt("Email_Box_One_G", green).commit();
        sharedPreferences.edit().putInt("Email_Box_One_B", blue).commit();
        sharedPreferences.edit().putInt("Email_Box_One_Slider", sliderValue).commit();
        
    }

    public static RGB getEmailBoxOneColor(Context context)
    {
        SharedPreferences sharedPreferences = context.getSharedPreferences("USER_SETTINGS", Context.MODE_PRIVATE);
        RGB rgb = new RGB();
        rgb.red = sharedPreferences.getInt("Email_Box_One_R", 0);
        rgb.green = sharedPreferences.getInt("Email_Box_One_G", 0);
        rgb.blue = sharedPreferences.getInt("Email_Box_One_B", 0);
        rgb.sliderValue = sharedPreferences.getInt("Email_Box_One_Slider", 0);
        return rgb;
    }

    public static void saveEmailBoxTwo(Context context, CustomBoxData field)
    {
        SharedPreferences sharedPreferences = context.getSharedPreferences("USER_SETTINGS", Context.MODE_PRIVATE);
        sharedPreferences.edit().putString("Email_Box_Two", field.getText()).commit();
        
    }

    public static CustomBoxData getEmailBoxTwo(Context context)
    {
        SharedPreferences sharedPreferences = context.getSharedPreferences("USER_SETTINGS", Context.MODE_PRIVATE);
        return CustomBoxData.fromString(sharedPreferences.getString("Email_Box_Two", null));
    }

    public static void saveEmailBoxTwoColor(Context context, int red, int green, int blue, int sliderValue)
    {
        SharedPreferences sharedPreferences = context.getSharedPreferences("USER_SETTINGS", Context.MODE_PRIVATE);
        sharedPreferences.edit().putInt("Email_Box_Two_R", red).commit();
        sharedPreferences.edit().putInt("Email_Box_Two_G", green).commit();
        sharedPreferences.edit().putInt("Email_Box_Two_B", blue).commit();
        sharedPreferences.edit().putInt("Email_Box_Two_Slider", sliderValue).commit();
        
    }

    public static RGB getEmailBoxTwoColor(Context context)
    {
        SharedPreferences sharedPreferences = context.getSharedPreferences("USER_SETTINGS", Context.MODE_PRIVATE);
        RGB rgb = new RGB();
        rgb.red = sharedPreferences.getInt("Email_Box_Two_R", 0);
        rgb.green = sharedPreferences.getInt("Email_Box_Two_G", 0);
        rgb.blue = sharedPreferences.getInt("Email_Box_Two_B", 0);
        rgb.sliderValue = sharedPreferences.getInt("Email_Box_Two_Slider", 0);
        return rgb;
    }

    public static void saveEmailBoxThree(Context context, CustomBoxData field)
    {
        SharedPreferences sharedPreferences = context.getSharedPreferences("USER_SETTINGS", Context.MODE_PRIVATE);
        sharedPreferences.edit().putString("Email_Box_Three", field.getText()).commit();
        
    }

    public static CustomBoxData getEmailBoxThree(Context context)
    {
        SharedPreferences sharedPreferences = context.getSharedPreferences("USER_SETTINGS", Context.MODE_PRIVATE);
        return CustomBoxData.fromString(sharedPreferences.getString("Email_Box_Three", null));
    }

    public static void saveEmailBoxThreeColor(Context context, int red, int green, int blue, int sliderValue)
    {
        SharedPreferences sharedPreferences = context.getSharedPreferences("USER_SETTINGS", Context.MODE_PRIVATE);
        sharedPreferences.edit().putInt("Email_Box_Three_R", red).commit();
        sharedPreferences.edit().putInt("Email_Box_Three_G", green).commit();
        sharedPreferences.edit().putInt("Email_Box_Three_B", blue).commit();
        sharedPreferences.edit().putInt("Email_Box_Three_Slider", sliderValue).commit();
        
    }

    public static RGB getEmailBoxThreeColor(Context context)
    {
        SharedPreferences sharedPreferences = context.getSharedPreferences("USER_SETTINGS", Context.MODE_PRIVATE);
        RGB rgb = new RGB();
        rgb.red = sharedPreferences.getInt("Email_Box_Three_R", 0);
        rgb.green = sharedPreferences.getInt("Email_Box_Three_G", 0);
        rgb.blue = sharedPreferences.getInt("Email_Box_Three_B", 0);
        rgb.sliderValue = sharedPreferences.getInt("Email_Box_Three_Slider", 0);
        return rgb;
    }

    public static void saveEmailBoxFour(Context context, CustomBoxData field)
    {
        SharedPreferences sharedPreferences = context.getSharedPreferences("USER_SETTINGS", Context.MODE_PRIVATE);
        sharedPreferences.edit().putString("Email_Box_Four", field.getText()).commit();
        
    }

    public static CustomBoxData getEmailBoxFour(Context context)
    {
        SharedPreferences sharedPreferences = context.getSharedPreferences("USER_SETTINGS", Context.MODE_PRIVATE);
        return CustomBoxData.fromString(sharedPreferences.getString("Email_Box_Four", null));
    }

    public static void saveEmailBoxFourColor(Context context, int red, int green, int blue, int sliderValue)
    {
        SharedPreferences sharedPreferences = context.getSharedPreferences("USER_SETTINGS", Context.MODE_PRIVATE);
        sharedPreferences.edit().putInt("Email_Box_Four_R", red).commit();
        sharedPreferences.edit().putInt("Email_Box_Four_G", green).commit();
        sharedPreferences.edit().putInt("Email_Box_Four_B", blue).commit();
        sharedPreferences.edit().putInt("Email_Box_Four_Slider", sliderValue).commit();
        
    }

    public static RGB getEmailBoxFourColor(Context context)
    {
        SharedPreferences sharedPreferences = context.getSharedPreferences("USER_SETTINGS", Context.MODE_PRIVATE);
        RGB rgb = new RGB();
        rgb.red = sharedPreferences.getInt("Email_Box_Four_R", 0);
        rgb.green = sharedPreferences.getInt("Email_Box_Four_G", 0);
        rgb.blue = sharedPreferences.getInt("Email_Box_Four_B", 0);
        rgb.sliderValue = sharedPreferences.getInt("Email_Box_Four_Slider", 0);
        return rgb;
    }

    /*

            Notifications Getters and Setters

     */

    public static void saveNotificationsBoxOne(Context context, CustomBoxData field)
    {
        SharedPreferences sharedPreferences = context.getSharedPreferences("USER_SETTINGS", Context.MODE_PRIVATE);
        sharedPreferences.edit().putString("Notifications_Box_One", field.getText()).commit();
        
    }

    public static CustomBoxData getNotificationsBoxOne(Context context)
    {
        SharedPreferences sharedPreferences = context.getSharedPreferences("USER_SETTINGS", Context.MODE_PRIVATE);
        return CustomBoxData.fromString(sharedPreferences.getString("Notifications_Box_One", null));
    }

    public static void saveNotificationsBoxOneColor(Context context, int red, int green, int blue, int sliderValue)
    {
        SharedPreferences sharedPreferences = context.getSharedPreferences("USER_SETTINGS", Context.MODE_PRIVATE);
        sharedPreferences.edit().putInt("Notifications_Box_One_R", red).commit();
        sharedPreferences.edit().putInt("Notifications_Box_One_G", green).commit();
        sharedPreferences.edit().putInt("Notifications_Box_One_B", blue).commit();
        sharedPreferences.edit().putInt("Notifications_Box_One_Slider", sliderValue).commit();
        
    }

    public static RGB getNotificationsBoxOneColor(Context context)
    {
        SharedPreferences sharedPreferences = context.getSharedPreferences("USER_SETTINGS", Context.MODE_PRIVATE);
        RGB rgb = new RGB();
        rgb.red = sharedPreferences.getInt("Notifications_Box_One_R", 0);
        rgb.green = sharedPreferences.getInt("Notifications_Box_One_G", 0);
        rgb.blue = sharedPreferences.getInt("Notifications_Box_One_B", 0);
        rgb.sliderValue = sharedPreferences.getInt("Notifications_Box_One_Slider", 0);
        return rgb;
    }

    public static void saveNotificationsBoxTwo(Context context, CustomBoxData field)
    {
        SharedPreferences sharedPreferences = context.getSharedPreferences("USER_SETTINGS", Context.MODE_PRIVATE);
        sharedPreferences.edit().putString("Notifications_Box_Two", field.getText()).commit();
        
    }

    public static CustomBoxData getNotificationsBoxTwo(Context context)
    {
        SharedPreferences sharedPreferences = context.getSharedPreferences("USER_SETTINGS", Context.MODE_PRIVATE);
        return CustomBoxData.fromString(sharedPreferences.getString("Notifications_Box_Two", null));
    }

    public static void saveNotificationsBoxTwoColor(Context context, int red, int green, int blue, int sliderValue)
    {
        SharedPreferences sharedPreferences = context.getSharedPreferences("USER_SETTINGS", Context.MODE_PRIVATE);
        sharedPreferences.edit().putInt("Notifications_Box_Two_R", red).commit();
        sharedPreferences.edit().putInt("Notifications_Box_Two_G", green).commit();
        sharedPreferences.edit().putInt("Notifications_Box_Two_B", blue).commit();
        sharedPreferences.edit().putInt("Notifications_Box_Two_Slider", sliderValue).commit();
        
    }

    public static RGB getNotificationsBoxTwoColor(Context context)
    {
        SharedPreferences sharedPreferences = context.getSharedPreferences("USER_SETTINGS", Context.MODE_PRIVATE);
        RGB rgb = new RGB();
        rgb.red = sharedPreferences.getInt("Notifications_Box_Two_R", 0);
        rgb.green = sharedPreferences.getInt("Notifications_Box_Two_G", 0);
        rgb.blue = sharedPreferences.getInt("Notifications_Box_Two_B", 0);
        rgb.sliderValue = sharedPreferences.getInt("Notifications_Box_Two_Slider", 0);
        return rgb;
    }

    public static void saveNotificationsBoxThree(Context context, CustomBoxData field)
    {
        SharedPreferences sharedPreferences = context.getSharedPreferences("USER_SETTINGS", Context.MODE_PRIVATE);
        sharedPreferences.edit().putString("Notifications_Box_Three", field.getText()).commit();
        
    }

    public static CustomBoxData getNotificationsBoxThree(Context context)
    {
        SharedPreferences sharedPreferences = context.getSharedPreferences("USER_SETTINGS", Context.MODE_PRIVATE);
        return CustomBoxData.fromString(sharedPreferences.getString("Notifications_Box_Three", null));
    }

    public static void saveNotificationsBoxThreeColor(Context context, int red, int green, int blue, int sliderValue)
    {
        SharedPreferences sharedPreferences = context.getSharedPreferences("USER_SETTINGS", Context.MODE_PRIVATE);
        sharedPreferences.edit().putInt("Notifications_Box_Three_R", red).commit();
        sharedPreferences.edit().putInt("Notifications_Box_Three_G", green).commit();
        sharedPreferences.edit().putInt("Notifications_Box_Three_B", blue).commit();
        sharedPreferences.edit().putInt("Notifications_Box_Three_Slider", sliderValue).commit();
        
    }

    public static RGB getNotificationsBoxThreeColor(Context context)
    {
        SharedPreferences sharedPreferences = context.getSharedPreferences("USER_SETTINGS", Context.MODE_PRIVATE);
        RGB rgb = new RGB();
        rgb.red = sharedPreferences.getInt("Notifications_Box_Three_R", 0);
        rgb.green = sharedPreferences.getInt("Notifications_Box_Three_G", 0);
        rgb.blue = sharedPreferences.getInt("Notifications_Box_Three_B", 0);
        rgb.sliderValue = sharedPreferences.getInt("Notifications_Box_Three_Slider", 0);
        return rgb;
    }

    public static void saveNotificationsBoxFour(Context context, CustomBoxData field)
    {
        SharedPreferences sharedPreferences = context.getSharedPreferences("USER_SETTINGS", Context.MODE_PRIVATE);
        sharedPreferences.edit().putString("Notifications_Box_Four", field.getText()).commit();
        
    }

    public static CustomBoxData getNotificationsBoxFour(Context context)
    {
        SharedPreferences sharedPreferences = context.getSharedPreferences("USER_SETTINGS", Context.MODE_PRIVATE);
        return CustomBoxData.fromString(sharedPreferences.getString("Notifications_Box_Four", null));
    }

    public static void saveNotificationsBoxFourColor(Context context, int red, int green, int blue, int sliderValue)
    {
        SharedPreferences sharedPreferences = context.getSharedPreferences("USER_SETTINGS", Context.MODE_PRIVATE);
        sharedPreferences.edit().putInt("Notifications_Box_Four_R", red).commit();
        sharedPreferences.edit().putInt("Notifications_Box_Four_G", green).commit();
        sharedPreferences.edit().putInt("Notifications_Box_Four_B", blue).commit();
        sharedPreferences.edit().putInt("Notifications_Box_Four_Slider", sliderValue).commit();
        
    }

    public static RGB getNotificationsBoxFourColor(Context context)
    {
        SharedPreferences sharedPreferences = context.getSharedPreferences("USER_SETTINGS", Context.MODE_PRIVATE);
        RGB rgb = new RGB();
        rgb.red = sharedPreferences.getInt("Notifications_Box_Four_R", 0);
        rgb.green = sharedPreferences.getInt("Notifications_Box_Four_G", 0);
        rgb.blue = sharedPreferences.getInt("Notifications_Box_Four_B", 0);
        rgb.sliderValue = sharedPreferences.getInt("Notifications_Box_Four_Slider", 0);
        return rgb;
    }
}
