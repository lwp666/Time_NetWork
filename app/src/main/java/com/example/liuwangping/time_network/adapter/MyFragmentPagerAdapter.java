package com.example.liuwangping.time_network.adapter;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

/**
 * Created by liuwangping on 2017/3/23.
 */

public class MyFragmentPagerAdapter extends FragmentPagerAdapter {
    private ArrayList<Fragment> mList;

    public MyFragmentPagerAdapter(FragmentManager fm, ArrayList<Fragment> mList) {
        super(fm);
        this.mList=mList;
    }

    @Override
    public Fragment getItem(int position) {
        return mList.get(position);
    }

    @Override
    public int getCount() {
        return mList.size();
    }
}
