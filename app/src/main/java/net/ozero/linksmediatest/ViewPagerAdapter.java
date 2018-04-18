package net.ozero.linksmediatest;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class ViewPagerAdapter extends FragmentPagerAdapter {

    private final String[] titleTabs = {
            App.CATEGORY_FOOTBALL,
            App.CATEGORY_HOCKEY,
            App.CATEGORY_TENNIS,
            App.CATEGORY_BASKETBALL,
            App.CATEGORY_VOLLEYBALL,
            App.CATEGORY_CYBERSPORT
    };


    public ViewPagerAdapter(FragmentManager fm) {
        super(fm);

    }

    @Override
    public Fragment getItem(int position) {
        Bundle args = new Bundle();
        args.putString(App.EXTRA_CATEGORY, titleTabs[position]);
        EventsFragment eventsFragment = new EventsFragment();
        eventsFragment.setArguments(args);
//        notifyDataSetChanged();
        return eventsFragment;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return titleTabs[position];
    }

    @Override
    public int getCount() {
        return titleTabs.length;
    }
}
