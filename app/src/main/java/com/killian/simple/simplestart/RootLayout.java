package com.killian.simple.simplestart;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.RelativeLayout;

/**
 * Created by Silas on 8/30/2016.
 * This class allows me to pass touch events through my fragment to the views below.
 */
public class RootLayout extends RelativeLayout
{

    public RootLayout(Context context)
    {
        super(context);
    }

    public RootLayout(Context context, AttributeSet attrs)
    {
        super(context, attrs);
    }

    public RootLayout(Context context, AttributeSet attrs, int defStyleAttr)
    {
        super(context, attrs, defStyleAttr);
    }


    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev)
    {
        onTouchEvent(ev);
        return true;
    }
}