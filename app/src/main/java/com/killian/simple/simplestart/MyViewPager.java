package com.killian.simple.simplestart;

import android.content.Context;
import android.support.v4.view.GestureDetectorCompat;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;

/**
 * Created by Silas on 8/25/2016.
 * Our custom ViewPager. It's basically just a ViewPager with an onTouchEvent, and a lot of extra
 * junk to get our GestureDetector and CreationActivity to the right spots.
 */
public class MyViewPager extends ViewPager
{
    CreationActivity parent;

    GestureDetectorCompat mDetector;

    //Entirely unused constructor
//    MyViewPager(Context context)
//    {
//        super(context);
//        mDetector = new GestureDetectorCompat(this.getContext(), new MyGestureListener(parent));
//        System.out.println("CHECK");
//    }

    //Constructor with the creation activity. This way we can get an mDetector with the correct
    //initialization. Not entirely sure if it's needed, but this is the best solution
    //we could figure out.


    //Constructor used by setContentView. We just use super. Not sure if this is necessary.
    MyViewPager(Context context, AttributeSet attrs)
    {
        super(context, attrs);
    }


}
