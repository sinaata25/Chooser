package com.ataei.chooser.adapter;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.ataei.chooser.fragments.F_1;

import java.util.ArrayList;
import java.util.List;

public class ViewPageradapter extends FragmentPagerAdapter {

    List<Fragment>list;

    public ViewPageradapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
        list=new ArrayList<>();

    }


    @NonNull
    @Override
    public Fragment getItem(int position) {
        return list.get(position);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    public void addfragment(Fragment fragment){
        try {
            list.add(fragment);
        }catch (Exception e){
            Log.i("TAG", "Error pager add: "+e.getMessage());
        }


    }


}
