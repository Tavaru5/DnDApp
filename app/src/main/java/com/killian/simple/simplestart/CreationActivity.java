package com.killian.simple.simplestart;

import android.content.Context;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/*Alright so crazy idea. Ya know how I didn't use fragments for race selection?
 *Well what if I made all of character creation on a slide view?
 *First slide is name and race, second can be ability scores, third can be class, etc.
 *Spells could be an optional extra page depending on what class you choose?
 *Well we'll cross that bridge when we get to it. Which hopefully will be soon*/

//I REALLY NEED A PLACE FOR RACE STATS. Below?

public class CreationActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_creation);

        ViewPager raceSwipe = (ViewPager) findViewById(R.id.raceSwipe);
        raceSwipe.setAdapter(new CustomPagerAdapter(this));

        //Adding a page change listener. I'm sure there's a less messy way to do this, but I don't
        //know it. I really just need this to update the textViews when a new page is selected.
        /*raceSwipe.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels){}
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

    //A method to update the textViews with each race's information
    /*public void updateRaceInfo (int position)
    {
        TextView abilityScores = (TextView) findViewById(R.id.abilityScores);
        abilityScores.setText(Integer.toString(position));
    }*/

    //Most of the following code is based off of the tutorial at
    //bignerdranch.com/blog/viewpager-without-fragments/
    //enum to access data on each of the races

    public enum RacesEnum
    {
        DRAGONBORN(R.string.dragonborn, R.layout.dragonborn),
        DROW(R.string.drow, R.layout.drow),
        HIGHELF(R.string.highelf, R.layout.highelf),
        WOODELF(R.string.woodelf, R.layout.woodelf),
        HELF(R.string.helf, R.layout.helf),
        HUMAN(R.string.human, R.layout.human),
        FORESTGNOME(R.string.forestgnome, R.layout.forestgnome),
        STONEGNOME(R.string.stonegnome, R.layout.stonegnome),
        HILLDWARF(R.string.hilldwarf, R.layout.hilldwarf),
        MOUNTAINDWARF(R.string.mountaindwarf, R.layout.mountaindward),
        HORC(R.string.horc, R.layout.horc),
        LIGHTHALFLING(R.string.lighthalfling, R.layout.lighthalfling),
        STOUTHALFLING(R.string.stouthalfling, R.layout.stouthalfling),
        TIEFLING(R.string.tiefling, R.layout.tiefling);

        private int mTitleResId;
        private int mLayoutResId;

        RacesEnum(int titleResId, int layoutResId)
        {
            mTitleResId = titleResId;
            mLayoutResId = layoutResId;
        }

        public int getTitleResId()
        {
            return mTitleResId;
        }

        public int getLayoutResId()
        {
            return mLayoutResId;
        }

    }

    public class CustomPagerAdapter extends PagerAdapter
    {
        private Context mContext;

        public CustomPagerAdapter(Context context)
        {
            mContext = context;
        }

        @Override
        public Object instantiateItem(ViewGroup collection, int position) {
            RacesEnum racesEnum = RacesEnum.values()[position];
            LayoutInflater inflater = LayoutInflater.from(mContext);
            ViewGroup layout = (ViewGroup) inflater.inflate(racesEnum.getLayoutResId(), collection, false);
            collection.addView(layout);
            return layout;
        }

        @Override
        public void destroyItem(ViewGroup collection, int position, Object view) {
            collection.removeView((View) view);
        }

        @Override
        public int getCount() {
            return RacesEnum.values().length;
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            RacesEnum racesEnum = RacesEnum.values()[position];
            return mContext.getString(racesEnum.getTitleResId());
        }

    }
}
