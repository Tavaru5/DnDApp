package com.killian.simple.simplestart;

/**
 * Created by Silas on 8/25/2016.
 * This is an enum containing references to the pictures and titles of races for the viewPager
 */
public enum RacesEnum
{
    DRAGONBORN(R.string.dragonborn, R.layout.dragonborn),
    DROW( R.string.drow, R.layout.drow),
    HIGHELF(R.string.highelf, R.layout.highelf),
    WOODELF(R.string.woodelf, R.layout.woodelf),
    HELF(R.string.helf, R.layout.helf),
    HUMAN(R.string.human, R.layout.human),
    FORESTGNOME(R.string.forestgnome, R.layout.forestgnome),
    ROCKGNOME(R.string.rockgnome, R.layout.rockgnome),
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