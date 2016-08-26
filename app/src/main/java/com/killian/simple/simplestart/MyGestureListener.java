package com.killian.simple.simplestart;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.GestureDetector;
import android.view.MotionEvent;

/**
 * Created by Silas on 8/25/2016.
 */
class MyGestureListener extends GestureDetector.SimpleOnGestureListener
{

    RacialTraitsFragment raceFrag;
    CreationActivity parent;

    public MyGestureListener(CreationActivity activity)
    {
        super();
        parent = activity;
        this.raceFrag = parent.getRaceFrag();
    }

    @Override
    public boolean onDown(MotionEvent event)
    {
        return true;
    }

    @Override
    public boolean onFling(MotionEvent event1, MotionEvent event2, float velocityX,
                           float velocityY)
    {

//        nameField.setText("TEST");

        FragmentManager fm = parent.getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.setCustomAnimations(R.anim.slide_in_up, R.anim.slide_out_down);

        if (!raceFrag.isAdded())
        {
//            nameField.setText("IT ISN'T ADDED");
            ft.add(R.id.creationScreen, raceFrag);
        }
        if (raceFrag.isHidden())
        {
//            nameField.setText(String.valueOf(velocityY));
            ft.show(raceFrag);
        }
        else
        {
            ft.hide(raceFrag);
        }

        ft.commit();
        return true;
    }
}