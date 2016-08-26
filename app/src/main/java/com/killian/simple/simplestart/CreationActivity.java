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

//I REALLY NEED A PLACE FOR RACE STATS. We're gonna put it in a swipe-up fragment

public class CreationActivity extends FragmentActivity
{

    RacialTraitsFragment raceFrag;
    EditText nameField;
//    GestureDetectorCompat mDetector;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {

        raceFrag = new RacialTraitsFragment();

        System.out.println("AHHHH");
        MyViewPager raceSwipe = new MyViewPager(this, this);

        GestureDetectorCompat mDetector = raceSwipe.getmDetector();

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_creation);

        nameField = (EditText) findViewById(R.id.charName);



        System.out.println("AH");
        raceSwipe = (MyViewPager) findViewById(R.id.raceSwipe);
        raceSwipe.setmDetector(mDetector);
        raceSwipe.setAdapter(new CustomPagerAdapter(this));



        //Implementing the gesture detector. Not entirely sure how this works, mostly just
        //following the tutorials on the android website.
        //Uses the MyGestureListener created below. Still trying to figure out if I can link that
        //through comments.
//        mDetector = new GestureDetectorCompat(this, new MyGestureListener());

        //Adding a page change listener. I'm sure there's a less messy way to do this, but I don't
        //know it. I really just need this to update the textViews when a new page is selected.
        /*raceSwipe.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset,
                    int positionOffsetPixels){}
            @Override
            public void onPageSelected(int position)
            {
                //Call a method to update the race info. Mostly so I don't have to write all that
                //code in the middle of a parameter list.
                updateRaceInfo(position);
            }
            @Override
            public void onPageScrollStateChanged(int state){}
        });*/
    }

    //Method to return the fragment that is created in order for the gestureViewer to use it.
    public RacialTraitsFragment getRaceFrag()
    {
        return raceFrag;
    }



    //Adding onClick just for testing. Final product will be on an upwards swipe (hopefully)
    ///HOLD UP WE"RE GOIN RIGHT IN ON THAT GESTURE LISTENER


    //A method to update the textViews with each race's information
    /*public void updateRaceInfo (int position)
    {
        TextView abilityScores = (TextView) findViewById(R.id.abilityScores);
        abilityScores.setText(Integer.toString(position));
    }*/

    //Most of the following code is based off of the tutorial at
    //bignerdranch.com/blog/viewpager-without-fragments/

    //enum to access data on each of the races
//    public enum RacesEnum
//    {
//        DRAGONBORN(R.string.dragonborn, R.layout.dragonborn),
//        DROW( R.string.drow, R.layout.drow),
//        HIGHELF(R.string.highelf, R.layout.highelf),
//        WOODELF(R.string.woodelf, R.layout.woodelf),
//        HELF(R.string.helf, R.layout.helf),
//        HUMAN(R.string.human, R.layout.human),
//        FORESTGNOME(R.string.forestgnome, R.layout.forestgnome),
//        STONEGNOME(R.string.stonegnome, R.layout.stonegnome),
//        HILLDWARF(R.string.hilldwarf, R.layout.hilldwarf),
//        MOUNTAINDWARF(R.string.mountaindwarf, R.layout.mountaindward),
//        HORC(R.string.horc, R.layout.horc),
//        LIGHTHALFLING(R.string.lighthalfling, R.layout.lighthalfling),
//        STOUTHALFLING(R.string.stouthalfling, R.layout.stouthalfling),
//        TIEFLING(R.string.tiefling, R.layout.tiefling);
//
//        private int mTitleResId;
//        private int mLayoutResId;
//
//        RacesEnum(int titleResId, int layoutResId)
//        {
//            mTitleResId = titleResId;
//            mLayoutResId = layoutResId;
//        }
//
//        public int getTitleResId()
//        {
//            return mTitleResId;
//        }
//
//        public int getLayoutResId()
//        {
//            return mLayoutResId;
//        }
//
//    }

//    class MyGestureListener extends GestureDetector.SimpleOnGestureListener
//    {
//
//        @Override
//        public boolean onDown(MotionEvent event)
//        {
//            return true;
//        }
//
//        @Override
//        public boolean onFling(MotionEvent event1, MotionEvent event2, float velocityX,
//                               float velocityY)
//        {
//
//            nameField.setText("TEST");
//
//            FragmentManager fm = getSupportFragmentManager();
//            FragmentTransaction ft = fm.beginTransaction();
//            ft.setCustomAnimations(R.anim.slide_in_up, R.anim.slide_out_down);
//
//            if (!raceFrag.isAdded())
//            {
//                nameField.setText("IT ISN'T ADDED");
//                ft.add(R.id.creationScreen, raceFrag);
//            }
//            if (raceFrag.isHidden())
//            {
//                nameField.setText(String.valueOf(velocityY));
//                ft.show(raceFrag);
//            }
//            else
//            {
//                ft.hide(raceFrag);
//            }
//
//            ft.commit();
//            return true;
//        }
//    }

//    public class MyViewPager extends ViewPager
//    {
//        GestureDetectorCompat mDetector;
//        MyViewPager(Context context)
//        {
//            super(context);
//            mDetector = new GestureDetectorCompat(this.getContext(), new MyGestureListener());
//        }
//
//        MyViewPager(Context context, AttributeSet attrs)
//        {
//            super(context, attrs);
//            mDetector = new GestureDetectorCompat(this.getContext(), new MyGestureListener());
//        }
//
//        @Override
//        public boolean onTouchEvent(MotionEvent event)
//        {
//            this.mDetector.onTouchEvent(event);
//            return super.onTouchEvent(event);
//        }
//    }

//    public class CustomPagerAdapter extends PagerAdapter
//    {
//        private Context mContext;
//
//        public CustomPagerAdapter(Context context)
//        {
//            mContext = context;
//        }
//
//        //It appears as though we are going to have to make our own viewpager class and intercept
//        //upward swipes, but only upward swipes. Hopefully won't be too hard.
//
//        @Override
//        public Object instantiateItem(ViewGroup collection, int position) {
//            RacesEnum racesEnum = RacesEnum.values()[position];
//            LayoutInflater inflater = LayoutInflater.from(mContext);
//            ViewGroup layout = (ViewGroup) inflater.inflate(racesEnum.getLayoutResId(), collection, false);
//            collection.addView(layout);
//            return layout;
//        }
//
//        @Override
//        public void destroyItem(ViewGroup collection, int position, Object view) {
//            collection.removeView((View) view);
//        }
//
//        @Override
//        public int getCount() {
//            return RacesEnum.values().length;
//        }
//
//        @Override
//        public boolean isViewFromObject(View view, Object object) {
//            return view == object;
//        }
//
//        @Override
//        public CharSequence getPageTitle(int position) {
//            RacesEnum racesEnum = RacesEnum.values()[position];
//            return mContext.getString(racesEnum.getTitleResId());
//        }
//
//    }

    //Fragment to show racial bonuses
//    public class RacialTraitsFragment extends Fragment
//    {
//        @Override
//        public View onCreateView(LayoutInflater inflater, ViewGroup container,
//                                 Bundle savedInstanceState)
//        {
//            return inflater.inflate(R.layout.racial_traits_fragment, container, false);
//        }
//    }
}
