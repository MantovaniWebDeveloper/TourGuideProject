package com.example.android.tourguideproject;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.android.tourguideproject.citydata.UtilsData;
/**
 * Created by Emanuele on 15/12/2017.
 * Custom fragment pager adapter
 */
public class TabAdapter extends FragmentPagerAdapter {
    //number of tabs
    private final int TABS_NUMBER = 4;
    //context needed to access string resources
    private final Context context;
    /**
     * Construct new TabAdapter object
     *
     * @param fm fragment manager
     * @param c  context object
     */
    public TabAdapter(FragmentManager fm, Context c) {
        super(fm);
        this.context = c;
    }
    @Override
    public Fragment getItem(int position) {
        //only @FragmentType allowed
        @UtilsData.FragmentType String fragmentType;
        Bundle bundle = new Bundle();
        switch (position) {
            case 0:
                fragmentType = UtilsData.FragmentType.MONUMENTS;
                break;
            case 1:
                fragmentType = UtilsData.FragmentType.EVENTS;
                break;
            case 2:
                fragmentType = UtilsData.FragmentType.HOTELS_RESTAURANTS;
                break;
            default:
                fragmentType = UtilsData.FragmentType.SHOPPING;
        }
        bundle.putString("FRAGMENT_TYPE", fragmentType);
        ListFragment listFragment = new ListFragment();
        listFragment.setArguments(bundle);
        return listFragment;
    }
    @Override
    public int getCount() {
        return TABS_NUMBER;
    }
    @Override
    public CharSequence getPageTitle(int position) {
        //return the bar label
        switch (position) {
            case 0:
                return context.getString(R.string.places_tab);
            case 1:
                return context.getString(R.string.event_tab);
            case 2:
                return context.getString(R.string.hotel_restaurants_tab);
            default:
                return context.getString(R.string.shopping_tab);
        }
    }
}
