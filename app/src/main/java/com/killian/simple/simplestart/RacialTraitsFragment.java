package com.killian.simple.simplestart;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Silas on 8/25/2016.
 */
public class RacialTraitsFragment extends Fragment
{
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        return inflater.inflate(R.layout.racial_traits_fragment, container, false);
    }
}