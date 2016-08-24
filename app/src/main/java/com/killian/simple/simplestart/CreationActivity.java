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

public class CreationActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_creation);

        ViewPager raceSwipe = (ViewPager) findViewById(R.id.raceSwipe);
        raceSwipe.setAdapter(new CustomPagerAdapter(this));
    }

    //Most of the following code is based off of the tutorial at
    //bignerdranch.com/blog/viewpager-without-fragments/
    //enum to access data on each of the races

    public enum RacesEnum
    {
        DRAGONBORN(R.string.dragonborn, R.layout.dragonborn),
        DROW(R.string.drow, R.layout.drow);

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
