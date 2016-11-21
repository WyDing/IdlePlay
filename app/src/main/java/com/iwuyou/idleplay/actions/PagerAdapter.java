package com.iwuyou.idleplay.actions;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.util.Pair;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by duanding on 16/11/21.
 */

public class PagerAdapter extends FragmentPagerAdapter {

    private final List<Pair<String, Integer>> catalogs;

    public PagerAdapter(FragmentManager fm, List<Pair<String, Integer>> titles) {
        super(fm);
        catalogs = titles;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return catalogs.get(position).first;
    }

    @Override
    public int getCount() {
        return catalogs.size();
    }

    @Override
    public Fragment getItem(int position) {
        return ActionsFragment.newInstance(catalogs.get(position).second);
    }

}
