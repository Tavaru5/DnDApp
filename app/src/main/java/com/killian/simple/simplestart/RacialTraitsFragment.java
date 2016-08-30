package com.killian.simple.simplestart;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by Silas on 8/25/2016.
 * This fragment slides up from the bottom to show details on each race. It should be given
 * the updateRaceInfo method at some point. Pretty much just a text fragment that changes text
 * based on what position the ViewPager is in.
 */

//We might need a scrollView
//We also need to figure out where to put languages
public class RacialTraitsFragment extends Fragment
{
    TextView abilityView;
    TextView sizeView;
    TextView speedView;
    TextView traitsView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        return inflater.inflate(R.layout.racial_traits_fragment, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState)
    {
        super.onActivityCreated(savedInstanceState);
        abilityView = (TextView) getView().findViewById(R.id.abilityView);
        sizeView = (TextView) getView().findViewById(R.id.sizeView);
        speedView = (TextView) getView().findViewById(R.id.speedView);
        traitsView = (TextView) getView().findViewById(R.id.traitsView);
        this.updateRaceInfo(0);

    }


    public void updateRaceInfo(int position)
    {
        //Switch to show information based on position
        //Traits might end up having to use formatted strings.
        //Resources res = getResources();
        //String text = String.format(res.getString(R.string.main_text),
        //        res.getString(R.string.parameter_text), etc.   );
        switch(position)
        {
            //Dragonborn
            case 0:
                abilityView.setText(R.string.ability0);
                sizeView.setText(R.string.sizeM);
                speedView.setText(R.string.spd30);
                traitsView.setText(Html.fromHtml(String.format(getString(R.string.traits0),
                        getString(R.string.draconicAncestry),getString(R.string.breathWeapon),
                        getString(R.string.draconicResistance))));
                break;
            //Drow
            case 1:
                abilityView.setText(R.string.ability1);
                sizeView.setText(R.string.sizeM);
                speedView.setText(R.string.spd30);
                traitsView.setText(R.string.traits0);
                break;
            //High Elf
            case 2:
                abilityView.setText(R.string.ability2);
                sizeView.setText(R.string.sizeM);
                speedView.setText(R.string.spd30);
                traitsView.setText(R.string.traits0);
                break;
            //Wood Elf
            case 3:
                abilityView.setText(R.string.ability3);
                sizeView.setText(R.string.sizeM);
                speedView.setText(R.string.spd35);
                traitsView.setText(R.string.traits0);
                break;
            //Half Elf
            case 4:
                abilityView.setText(R.string.ability4);
                sizeView.setText(R.string.sizeM);
                speedView.setText(R.string.spd30);
                traitsView.setText(R.string.traits0);
                break;
            //Human
            case 5:
                abilityView.setText(R.string.ability5);
                sizeView.setText(R.string.sizeM);
                speedView.setText(R.string.spd30);
                traitsView.setText(R.string.traits0);
                break;
            //Forest Gnome
            case 6:
                abilityView.setText(R.string.ability6);
                sizeView.setText(R.string.sizeS);
                speedView.setText(R.string.spd25);
                traitsView.setText(R.string.traits0);
                break;
            //Rock Gnome
            case 7:
                abilityView.setText(R.string.ability7);
                sizeView.setText(R.string.sizeS);
                speedView.setText(R.string.spd25);
                traitsView.setText(R.string.traits0);
                break;
            //Hill Dwarf
            case 8:
                abilityView.setText(R.string.ability8);
                sizeView.setText(R.string.sizeM);
                speedView.setText(R.string.spd25);
                traitsView.setText(R.string.traits0);
                break;
            //Mountain Dwarf
            case 9:
                abilityView.setText(R.string.ability9);
                sizeView.setText(R.string.sizeM);
                speedView.setText(R.string.spd25);
                traitsView.setText(R.string.traits0);
                break;
            //Half Orc
            case 10:
                abilityView.setText(R.string.ability10);
                sizeView.setText(R.string.sizeM);
                speedView.setText(R.string.spd30);
                traitsView.setText(R.string.traits0);
                break;
            //Lightfoot Halfling
            case 11:
                abilityView.setText(R.string.ability11);
                sizeView.setText(R.string.sizeS);
                speedView.setText(R.string.spd25);
                traitsView.setText(R.string.traits0);
                break;
            //Stout Halfling
            case 12:
                abilityView.setText(R.string.ability12);
                sizeView.setText(R.string.sizeS);
                speedView.setText(R.string.spd25);
                traitsView.setText(R.string.traits0);
                break;
            //Tiefling
            case 13:
                abilityView.setText(R.string.ability13);
                sizeView.setText(R.string.sizeM);
                speedView.setText(R.string.spd30);
                traitsView.setText(R.string.traits0);
                break;
        }




    }
}