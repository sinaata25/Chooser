package com.ataei.chooser;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.Dialog;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TableLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.ataei.chooser.adapter.ViewPageradapter;
import com.ataei.chooser.fragments.F_1;
import com.ataei.chooser.fragments.F_2;
import com.ataei.chooser.fragments.F_3;
import com.ataei.chooser.fragments.G_1;
import com.ataei.chooser.fragments.G_2;
import com.ataei.chooser.fragments.G_3;
import com.google.android.material.tabs.TabLayout;
import com.tbuonomo.viewpagerdotsindicator.WormDotsIndicator;

public class Question_Dialog_Fragment extends DialogFragment {
    View view;
    TextView finger_mode;
    TextView gp_mode;
    ViewPageradapter viewPageradapter;

     ViewPager mPager;
     ViewPager cpager;
     WormDotsIndicator wormDotsIndicator;



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.question_dialog_fragment,container,false);
        setupviwes();
        Handle_pager(0);
        Handle_Clicks();
        return view;
    }

    private void setupviwes(){
        mPager =  view.findViewById(R.id.pager_e);
        wormDotsIndicator = view.findViewById(R.id.worm_dots_indicator);
        cpager=view.findViewById(R.id.pager_c);
       finger_mode=view.findViewById(R.id.finger_mode);
        gp_mode=view.findViewById(R.id.gp_mode);
    }
@SuppressLint("Range")
private void Handle_pager(int lock){

        if (lock==0){
            cpager.setVisibility(View.GONE);
            mPager.setVisibility(View.VISIBLE);
            finger_mode.setTextColor(Color.parseColor("#A8A8EA"));
            gp_mode.setTextColor(Color.parseColor("#FF7676A5"));
            finger_mode.setTextSize(22);
            gp_mode.setTextSize(18);
            viewPageradapter=new ViewPageradapter(getChildFragmentManager(), FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
            viewPageradapter.addfragment(new F_1());
            viewPageradapter.addfragment(new F_2());
            viewPageradapter.addfragment(new F_3());
            mPager.setAdapter(viewPageradapter);
            wormDotsIndicator.setViewPager(mPager);
        }else {
            mPager.setVisibility(View.GONE);
            cpager.setVisibility(View.VISIBLE);
            gp_mode.setTextColor(Color.parseColor("#A8A8EA"));
            finger_mode.setTextColor(Color.parseColor("#FF7676A5"));
            finger_mode.setTextSize(18);
            gp_mode.setTextSize(22);
            ViewPageradapter  viewPageradapter1=new ViewPageradapter(getChildFragmentManager(), FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
            viewPageradapter1.addfragment(new G_1());
            viewPageradapter1.addfragment(new G_2());
            viewPageradapter1.addfragment(new G_3());
            cpager.setAdapter(viewPageradapter1);
            wormDotsIndicator.setViewPager(cpager);
        }

}
private void Handle_Clicks(){
        finger_mode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Handle_pager(0);
            }
        });
        gp_mode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Handle_pager(1);
            }
        });


}


    @Override
    public void onStop() {
        super.onStop();
        Handle_pager(0);
    }
}
