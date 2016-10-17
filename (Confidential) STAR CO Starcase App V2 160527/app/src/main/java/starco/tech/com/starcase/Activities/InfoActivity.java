package starco.tech.com.starcase.Activities;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.InputStream;

import starco.tech.com.starcase.R;
import starco.tech.com.starcase.TouchListener;

/**
 * Created by Noah on 5/19/2016.
 */
public class InfoActivity extends Activity
{

    private WebView webView;
    private ImageView backButton;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.info_screen);

        webView = (WebView)findViewById(R.id.aboutScreenText);
        backButton = (ImageView)findViewById(R.id.infoBackArrow);

        backButton.setOnTouchListener(new TouchListener(backButton, Color.GRAY));
        backButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        });

        try
        {
            InputStream is = getAssets().open("about_page.html");
            StringBuilder builder = new StringBuilder();
            int size = is.available();

            byte[] buffer = new byte[size];

            while(is.read(buffer) != -1)
            {
                builder.append(new String(buffer));
            }

            is.close();

            String str = builder.toString();

            webView.loadDataWithBaseURL(null, str, "text/html", "utf-8", null);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

    }
}
