package com.youweihui.tourismstore.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.youweihui.tourismstore.ui.fragment.ShopTabFragment;

import java.util.ArrayList;
import java.util.List;

public class ShopTabAdapter extends FragmentPagerAdapter {

    private List<ShopTabFragment> list;

    private List<String> titles;

    public ShopTabAdapter(FragmentManager fm, ArrayList<ShopTabFragment> list, ArrayList<String> titles) {
        super(fm);
        this.list = list;
        this.titles = titles;
    }

    @Override
    public Fragment getItem(int position) {
        return list.get(position);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titles.get(position);
    }

    public void setData(List<ShopTabFragment> fragments, List<String> list){
        this.list = fragments;
        this.titles = list;
        notifyDataSetChanged();
    }
}
