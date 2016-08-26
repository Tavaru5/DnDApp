package com.killian.simple.simplestart;

import android.content.Context;
import android.support.v4.view.GestureDetectorCompat;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;

/**
 * Created by Silas on 8/25/2016.
 */
public class MyViewPager extends ViewPager
{
    CreationActivity parent;

    GestureDetectorCompat mDetector;

//    MyViewPager(Context context)
//    {
//        super(context);
//        mDetector = new GestureDetectorCompat(this.getContext(), new MyGestureListener(parent));
//        System.out.println("CHECK");
//    }

    MyViewPager(Context context, CreationActivity activity)
    {
        super(context);
        parent = activity;
        System.out.println("TEST");
        mDetector = new GestureDetectorCompat(this.getContext(), new MyGestureListener(parent));
        System.out.println("MEMES");
    }

    MyViewPager(Context context, AttributeSet attrs)
    {
        super(context, attrs);
        System.out.println("CALLED");
        //mDetector = new GestureDetectorCompat(this.getContext(), new MyGestureListener(parent));
    }

    public void passActivity(CreationActivity activity)
    {
        parent = activity;
    }

    public void setmDetector(GestureDetectorCompat detector)
    {
        mDetector = detector;
    }

    public GestureDetectorCompat getmDetector()
    {
        return mDetector;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event)
    {
        this.mDetector.onTouchEvent(event);
        return super.onTouchEvent(event);
    }
}
