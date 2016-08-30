package com.killian.simple.simplestart;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.GestureDetector;
import android.view.MotionEvent;

/**
 * Created by Silas on 8/25/2016.
 * This is the gestureListener's code. It should control the fragment to open and close
 * based on the user's swipes.
 */
class MyGestureListener extends GestureDetector.SimpleOnGestureListener
{

    RacialTraitsFragment raceFrag;
    CreationActivity parent;

    //This constructor gets us the parent activity, and through that we also get the race fragment
    public MyGestureListener(CreationActivity activity)
    {
        super();
        parent = activity;
        raceFrag = parent.getRaceFrag();
    }

    //We don't want to ignore any swipes, so always return true
    @Override
    public boolean onDown(MotionEvent event)
    {
        return true;
    }


    //On flings is when we want to open the fragment.
    //Still need to adjust so only opens on proper y velocities,
    //as well as fix so that it can add and open in one swipe. Maybe add it then hide it on create?
    @Override
    public boolean onFling(MotionEvent event1, MotionEvent event2, float velocityX,
                           float velocityY)
    {

        //We can't get a fragment manager without the parent? Idk it was annoying
        FragmentManager fm = parent.getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        //Set our animations
        ft.setCustomAnimations(R.anim.slide_in_up, R.anim.slide_out_down);

        //Make it show if it's hidden, and vice versa. This is where we will check velocities.
        if (raceFrag.isHidden() && (Math.abs(velocityY) > Math.abs(velocityX) && velocityY < 0))
        {
            ft.show(raceFrag);
        }
        else if (raceFrag.isVisible() && velocityY > Math.abs(velocityX))
        {
            ft.hide(raceFrag);
        }

        ft.commit();
        return true;
    }
}