package com.killian.simple.simplestart;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GestureDetectorCompat;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

/*Alright so crazy idea. Ya know how I didn't use fragments for race selection?
 *Well what if I made all of character creation on a slide view? (with fragments)
 *First slide is name and race, second can be ability scores, third can be class, etc.
 *Spells could be an optional extra page depending on what class you choose?
 *Well we'll cross that bridge when we get to it. Which hopefully will be soon*/


public class CreationActivity extends FragmentActivity
{

    RacialTraitsFragment raceFrag;
    EditText nameField;
    private GestureDetectorCompat mDetector;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {

//        ViewPager raceSwipe = new ViewPager(this, this);




        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_creation);

        nameField = (EditText) findViewById(R.id.charName);

        ViewPager raceSwipe = (ViewPager) findViewById(R.id.raceSwipe);
//        raceSwipe.setmDetector(mDetector);
        raceSwipe.setAdapter(new CustomPagerAdapter(this));

        raceFrag = new RacialTraitsFragment();

        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.add(R.id.creationScreen, raceFrag).hide(raceFrag).commit();

        mDetector = new GestureDetectorCompat(this,new MyGestureListener(this));





        //Adding a page change listener. I'm sure there's a less messy way to do this, but I don't
        //know it. I really just need this to update the textViews when a new page is selected.
        raceSwipe.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset,
                    int positionOffsetPixels){}
            @Override
            public void onPageSelected(int position)
            {
                //Call a method to update the race info. Mostly so I don't have to write all that
                //code in the middle of a parameter list.
                raceFrag.updateRaceInfo(position);
                //Make this a race frag method. That will make it work much better.
            }
            @Override
            public void onPageScrollStateChanged(int state){}
        });
    }

    //Method to return the fragment that is created in order for the gestureViewer to use it.
    public RacialTraitsFragment getRaceFrag()
    {
        return raceFrag;
    }

    public boolean onTouchEvent(MotionEvent event)
    {
        this.mDetector.onTouchEvent(event);
        return super.onTouchEvent(event);
    }

    public boolean dispatchTouchEvent(MotionEvent event)
    {
        onTouchEvent(event);
        return super.dispatchTouchEvent(event);
    }




}
