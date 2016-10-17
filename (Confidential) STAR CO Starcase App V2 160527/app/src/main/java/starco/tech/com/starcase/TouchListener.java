package starco.tech.com.starcase;

import android.graphics.Color;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;

/**
 * Created by Noah on 5/18/2016.
 */
public class TouchListener implements View.OnTouchListener
{
    private ImageView imageView;
    private int pressedColor;
    private int r;
    private int g;
    private int b;

    private boolean useRGB;

    /**
     * TouchListener Constructor
     *
     * @param imageView - ImageView object to apply the TouchListener to
     * @param pressedColor - Color of the image tint when touched
     */
    public TouchListener(ImageView imageView, int pressedColor)
    {
        this.imageView = imageView;
        this.pressedColor = pressedColor;
        this.useRGB = false;
    }

    /**
     * TouchListener Constructor
     *
     * @param imageView - ImageView object to apply the TouchListener to
     * @param r - Red Value for RGB Color Scheme tint
     * @param g - Green Value for RGB Color Scheme tint
     * @param b - Blue Value for RGB Color Scheme tint
     */
    public TouchListener(ImageView imageView, int r, int g, int b)
    {
        this.imageView = imageView;
        this.r = r;
        this.g = g;
        this.b = b;
        this.useRGB = true;
    }

    /**
     * onTouch method for the TouchListener
     *
     * @param v - View of the current Screen
     * @param event - Touch Event
     * @return - true if the image was touched
     *          - false if not
     */
    @Override
    public boolean onTouch(View v, MotionEvent event)
    {
        switch(event.getAction())
        {
            case MotionEvent.ACTION_DOWN:

                if(useRGB)
                {
                    imageView.setColorFilter(Color.rgb(r, g, b));
                }
                else
                {
                    imageView.setColorFilter(pressedColor);
                }
//                return true;
                break;

            case MotionEvent.ACTION_UP:

                imageView.clearColorFilter();
//                return true;
                break;
        }

        return false;
    }
}
