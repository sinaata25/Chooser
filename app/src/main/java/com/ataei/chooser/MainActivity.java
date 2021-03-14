package com.ataei.chooser;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentManager;

import android.animation.LayoutTransition;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.AnimationDrawable;
import android.os.Build;
import android.os.Bundle;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import android.util.Xml;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.hanks.htextview.HTextView;
import com.hanks.htextview.HTextViewType;

import org.xmlpull.v1.XmlPullParser;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;
import java.util.Timer;
import java.util.TimerTask;



public class MainActivity extends AppCompatActivity  {
        TextView textView_one,textView_two,textView_tree,textView_four,textView_five,textView_finger,textView_group;
        TextView textView_smallrect,textView_copy,count_sec;
        ImageView qestion;
        ConstraintLayout constraintLayout;
         Timer timer;
         Timer reset_timer;
        int finger_rest_lock=0;
    Object[] finger_randoms_array;
    MotionEvent event;
        int sec=3;
        int sec_reset_timer=1;
        HTextView hTextView,reaction;
        ImageView  press_hold,non_select_finger1,non_select_finger2,non_select_finger3,non_select_finger4,non_select_finger5;
        ImageView non_select_finger6,non_select_finger7,non_select_finger8,non_select_finger9,non_select_finger10;
        ImageView bluecircle_1,bluecircle_2,bluecircle_3,bluecircle_4,bluecircle_5,bluecircle_6,bluecircle_7,bluecircle_8,bluecircle_9,bluecircle_10;
        ImageView redcircle_1,redcircle_2,redcircle_3,redcircle_4,redcircle_5,redcircle_6,redcircle_7,redcircle_8,redcircle_9,redcircle_10;
        ImageView darkblue_1,darkblue_2,darkblue_3,darkblue_4,darkblue_5,darkblue_6,darkblue_7,darkblue_8,darkblue_9,darkblue_10;
        ImageView yellowcircle_1,yellowcircle_2,yellowcircle_3,yellowcircle_4,yellowcircle_5,yellowcircle_6,yellowcircle_7,yellowcircle_8,yellowcircle_9,yellowcircle_10;
        ImageView greencircle_1,greencircle_2,greencircle_3,greencircle_4,greencircle_5,greencircle_6,greencircle_7,greencircle_8,greencircle_9,greencircle_10;
        int num_finger=1,pointer_count;
        String final_Mode;
        String final_number;
    AnimationDrawable anim;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SetupViews();
        Handle_Views();
    }
    //////////////////////////////////////Main funcs
    public void SetupViews(){
        constraintLayout=findViewById(R.id.constraint);
        textView_one=findViewById(R.id.textView_one);
        textView_two=findViewById(R.id.textView_two);
        textView_tree=findViewById(R.id.textView_tree);
        textView_four=findViewById(R.id.textView_four);
        textView_five=findViewById(R.id.textView_five);
        textView_finger=findViewById(R.id.textView_finger);
        textView_group=findViewById(R.id.textView_groupe);
        count_sec=findViewById(R.id.textView_count_secrnd);
        textView_smallrect=findViewById(R.id.textView_smallrect);
        textView_copy=findViewById(R.id.textView_one_copy);
        press_hold=findViewById(R.id.imageView_press_hold);
        non_select_finger1=findViewById(R.id.imageView_non_1);
        non_select_finger2=findViewById(R.id.imageView_non_2);
        non_select_finger3=findViewById(R.id.imageView_non_3);
        non_select_finger4=findViewById(R.id.imageView_non_4);
        non_select_finger5=findViewById(R.id.imageView_non_5);
        non_select_finger6=findViewById(R.id.imageView_non_6);
        non_select_finger7=findViewById(R.id.imageView_non_7);
        non_select_finger8=findViewById(R.id.imageView_non_8);
        non_select_finger9=findViewById(R.id.imageView_non_9);
        non_select_finger10=findViewById(R.id.imageView_non_10);
        redcircle_1=findViewById(R.id.imageView_redcircle_1);
        redcircle_2=findViewById(R.id.imageView_redcircle_2);
        redcircle_3=findViewById(R.id.imageView_redcircle_3);
        redcircle_4=findViewById(R.id.imageView_redcircle_4);
        redcircle_5=findViewById(R.id.imageView_redcircle_5);
        redcircle_6=findViewById(R.id.imageView_redcircle_6);
        redcircle_7=findViewById(R.id.imageView_redcircle_7);
        redcircle_8=findViewById(R.id.imageView_redcircle_8);
        redcircle_9=findViewById(R.id.imageView_redcircle_9);
        redcircle_10=findViewById(R.id.imageView_redcircle_10);
        bluecircle_1=findViewById(R.id.imageView_bluecircle_1);
        bluecircle_2=findViewById(R.id.imageView_bluecircle_2);
        bluecircle_3=findViewById(R.id.imageView_bluecircle_3);
        bluecircle_4=findViewById(R.id.imageView_bluecircle_4);
        bluecircle_5=findViewById(R.id.imageView_bluecircle_5);
        bluecircle_6=findViewById(R.id.imageView_bluecircle_6);
        bluecircle_7=findViewById(R.id.imageView_bluecircle_7);
        bluecircle_8=findViewById(R.id.imageView_bluecircle_8);
        bluecircle_9=findViewById(R.id.imageView_bluecircle_9);
        bluecircle_10=findViewById(R.id.imageView_bluecircle_10);
        qestion=findViewById(R.id.imageView_question);
        darkblue_1=findViewById(R.id.imageView_darkbluecircle_1);
        darkblue_2=findViewById(R.id.imageView_darkbluecircle_2);
        darkblue_3=findViewById(R.id.imageView_darkbluecircle_3);
        darkblue_4=findViewById(R.id.imageView_darkbluecircle_4);
        darkblue_5=findViewById(R.id.imageView_darkbluecircle_5);
        darkblue_6=findViewById(R.id.imageView_darkbluecircle_6);
        darkblue_7=findViewById(R.id.imageView_darkbluecircle_7);
        darkblue_8=findViewById(R.id.imageView_darkbluecircle_8);
        darkblue_9=findViewById(R.id.imageView_darkbluecircle_9);
        darkblue_10=findViewById(R.id.imageView_darkbluecircle_10);
        yellowcircle_1=findViewById(R.id.imageView_yellowcircle_1);
        yellowcircle_2=findViewById(R.id.imageView_yellowcircle_2);
        yellowcircle_3=findViewById(R.id.imageView_yellowcircle_3);
        yellowcircle_4=findViewById(R.id.imageView_yellowcircle_4);
        yellowcircle_5=findViewById(R.id.imageView_yellowcircle_5);
        yellowcircle_6=findViewById(R.id.imageView_yellowcircle_6);
        yellowcircle_7=findViewById(R.id.imageView_yellowcircle_7);
        yellowcircle_8=findViewById(R.id.imageView_yellowcircle_8);
        yellowcircle_9=findViewById(R.id.imageView_yellowcircle_9);
        yellowcircle_10=findViewById(R.id.imageView_yellowcircle_10);
        greencircle_1=findViewById(R.id.imageView_greencircle_1);
        greencircle_2=findViewById(R.id.imageView_greencircle_2);
        greencircle_3=findViewById(R.id.imageView_greencircle_3);
        greencircle_4=findViewById(R.id.imageView_greencircle_4);
        greencircle_5=findViewById(R.id.imageView_greencircle_5);
        greencircle_6=findViewById(R.id.imageView_greencircle_6);
        greencircle_7=findViewById(R.id.imageView_greencircle_7);
        greencircle_8=findViewById(R.id.imageView_greencircle_8);
        greencircle_9=findViewById(R.id.imageView_greencircle_9);
        greencircle_10=findViewById(R.id.imageView_greencircle_10);
        hTextView = (HTextView) findViewById(R.id.text);
        reaction=(HTextView)findViewById(R.id.react);
    }
    public void Handle_Views(){
        Thread thread=new Thread(new Runnable() {
            @Override
            public void run() {
                background_animation();
            }
        });thread.start();
        Handle_copy_btn();
        Handle_finger_btn();
        Handle_group_btn();
        Handle_numbers();
        Handle_Question();
    }
    //////////////////////////////////////front funcs
    private void SetVisible_Circles(){
        textView_copy.setVisibility(View.GONE);
        textView_one.setVisibility(View.VISIBLE);
        textView_two.setVisibility(View.VISIBLE);
        textView_tree.setVisibility(View.VISIBLE);
        textView_four.setVisibility(View.VISIBLE);
        textView_five.setVisibility(View.VISIBLE);
    }
    private void SetGone_Circles(){
        textView_copy.setVisibility(View.VISIBLE);
        textView_one.setVisibility(View.GONE);
        textView_two.setVisibility(View.GONE);
        textView_tree.setVisibility(View.GONE);
        textView_four.setVisibility(View.GONE);
        textView_five.setVisibility(View.GONE);

    }
    private void SetGone_non_fingers(){
        non_select_finger1.setVisibility(View.GONE);
        non_select_finger1.setX(-1000);
        non_select_finger1.setY(-1000);
        //
        non_select_finger2.setVisibility(View.GONE);
        non_select_finger2.setX(-1000);
        non_select_finger2.setY(-1000);
        //
        non_select_finger3.setVisibility(View.GONE);
        non_select_finger3.setX(-1000);
        non_select_finger3.setY(-1000);
        //
        non_select_finger4.setVisibility(View.GONE);
        non_select_finger4.setX(-1000);
        non_select_finger4.setY(-1000);
        //
        non_select_finger5.setVisibility(View.GONE);
        non_select_finger5.setX(-1000);
        non_select_finger5.setY(-1000);
        //
        non_select_finger6.setVisibility(View.GONE);
        non_select_finger6.setX(-1000);
        non_select_finger6.setY(-1000);
        //
        non_select_finger7.setVisibility(View.GONE);
        non_select_finger7.setX(-1000);
        non_select_finger7.setY(-1000);
        //
        non_select_finger8.setVisibility(View.GONE);
        non_select_finger8.setX(-1000);
        non_select_finger8.setY(-1000);
        //
        non_select_finger9.setVisibility(View.GONE);
        non_select_finger9.setX(-1000);
        non_select_finger9.setY(-1000);
        //
        non_select_finger10.setVisibility(View.GONE);
        non_select_finger10.setX(-1000);
        non_select_finger10.setY(-1000);
    }
    private void SetGone_Selected_Circles(){
        alpha_animation(redcircle_1,0);
        redcircle_1.setVisibility(View.GONE); redcircle_1.setX(-1000);   redcircle_1.setY(-1000);
        alpha_animation(redcircle_2,0);
        redcircle_2.setVisibility(View.GONE); redcircle_2.setX(-1000);   redcircle_2.setY(-1000);
        alpha_animation(redcircle_3,0);
        redcircle_3.setVisibility(View.GONE); redcircle_3.setX(-1000);   redcircle_3.setY(-1000);
        alpha_animation(redcircle_4,0);
        redcircle_4.setVisibility(View.GONE); redcircle_4.setX(-1000);   redcircle_4.setY(-1000);
        alpha_animation(redcircle_5,0);
        redcircle_5.setVisibility(View.GONE); redcircle_5.setX(-1000);   redcircle_5.setY(-1000);
        alpha_animation(redcircle_6,0);
        redcircle_6.setVisibility(View.GONE); redcircle_6.setX(-1000);   redcircle_6.setY(-1000);
        alpha_animation(redcircle_7,0);
        redcircle_7.setVisibility(View.GONE); redcircle_7.setX(-1000);   redcircle_7.setY(-1000);
        alpha_animation(redcircle_8,0);
        redcircle_8.setVisibility(View.GONE);redcircle_8.setX(-1000);   redcircle_8.setY(-1000);
        alpha_animation(redcircle_9,0);
        redcircle_9.setVisibility(View.GONE);redcircle_9.setX(-1000);   redcircle_9.setY(-1000);
        alpha_animation(redcircle_10,0);
        redcircle_10.setVisibility(View.GONE);redcircle_10.setX(-1000);   redcircle_10.setY(-1000);
        alpha_animation(bluecircle_1,0);
        bluecircle_1.setVisibility(View.GONE);bluecircle_1.setX(-1000);   bluecircle_1.setY(-1000);
        alpha_animation(bluecircle_2,0);
        bluecircle_2.setVisibility(View.GONE);bluecircle_2.setX(-1000);   bluecircle_2.setY(-1000);
        alpha_animation(bluecircle_3,0);
        bluecircle_3.setVisibility(View.GONE);bluecircle_3.setX(-1000);   bluecircle_3.setY(-1000);
        alpha_animation(bluecircle_4,0);
        bluecircle_4.setVisibility(View.GONE);bluecircle_4.setX(-1000);   bluecircle_4.setY(-1000);
        alpha_animation(bluecircle_5,0);
        bluecircle_5.setVisibility(View.GONE);bluecircle_5.setX(-1000);   bluecircle_5.setY(-1000);
        alpha_animation(bluecircle_6,0);
        bluecircle_6.setVisibility(View.GONE);bluecircle_6.setX(-1000);   bluecircle_6.setY(-1000);
        alpha_animation(bluecircle_7,0);
        bluecircle_7.setVisibility(View.GONE);bluecircle_7.setX(-1000);   bluecircle_7.setY(-1000);
        alpha_animation(bluecircle_8,0);
        bluecircle_8.setVisibility(View.GONE);bluecircle_8.setX(-1000);   bluecircle_8.setY(-1000);
        alpha_animation(bluecircle_9,0);
        bluecircle_9.setVisibility(View.GONE);bluecircle_9.setX(-1000);   bluecircle_9.setY(-1000);
        alpha_animation(bluecircle_10,0);
        bluecircle_10.setVisibility(View.GONE);bluecircle_10.setX(-1000);   bluecircle_10.setY(-1000);
        alpha_animation(darkblue_1,0);
        darkblue_1.setVisibility(View.GONE);darkblue_1.setX(-1000);   darkblue_1.setY(-1000);
        alpha_animation(darkblue_2,0);
        darkblue_2.setVisibility(View.GONE);darkblue_2.setX(-1000);   darkblue_2.setY(-1000);
        alpha_animation(darkblue_3,0);
        darkblue_3.setVisibility(View.GONE);darkblue_3.setX(-1000);   darkblue_3.setY(-1000);
        alpha_animation(darkblue_4,0);
        darkblue_4.setVisibility(View.GONE);darkblue_4.setX(-1000);   darkblue_4.setY(-1000);
        alpha_animation(darkblue_5,0);
        darkblue_5.setVisibility(View.GONE);darkblue_5.setX(-1000);   darkblue_5.setY(-1000);
        alpha_animation(darkblue_6,0);
        darkblue_6.setVisibility(View.GONE);darkblue_6.setX(-1000);   darkblue_6.setY(-1000);
        alpha_animation(darkblue_7,0);
        darkblue_7.setVisibility(View.GONE);darkblue_7.setX(-1000);   darkblue_7.setY(-1000);
        alpha_animation(darkblue_8,0);
        darkblue_8.setVisibility(View.GONE);darkblue_8.setX(-1000);   darkblue_8.setY(-1000);
        alpha_animation(darkblue_9,0);
        darkblue_9.setVisibility(View.GONE);darkblue_9.setX(-1000);   darkblue_9.setY(-1000);
        alpha_animation(darkblue_10,0);
        darkblue_10.setVisibility(View.GONE);darkblue_10.setX(-1000);   darkblue_10.setY(-1000);
        alpha_animation(yellowcircle_1,0);
        yellowcircle_1.setVisibility(View.GONE);yellowcircle_1.setX(-1000);   yellowcircle_1.setY(-1000);
        alpha_animation(yellowcircle_2,0);
        yellowcircle_2.setVisibility(View.GONE);yellowcircle_2.setX(-1000);   yellowcircle_2.setY(-1000);
        alpha_animation(yellowcircle_3,0);
        yellowcircle_3.setVisibility(View.GONE);yellowcircle_3.setX(-1000);   yellowcircle_3.setY(-1000);
        alpha_animation(yellowcircle_4,0);
        yellowcircle_4.setVisibility(View.GONE);yellowcircle_4.setX(-1000);   yellowcircle_4.setY(-1000);
        alpha_animation(yellowcircle_5,0);
        yellowcircle_5.setVisibility(View.GONE);yellowcircle_5.setX(-1000);   yellowcircle_5.setY(-1000);
        alpha_animation(yellowcircle_6,0);
        yellowcircle_6.setVisibility(View.GONE);yellowcircle_6.setX(-1000);   yellowcircle_6.setY(-1000);
        alpha_animation(yellowcircle_7,0);
        yellowcircle_7.setVisibility(View.GONE);yellowcircle_7.setX(-1000);   yellowcircle_7.setY(-1000);
        alpha_animation(yellowcircle_8,0);
        yellowcircle_8.setVisibility(View.GONE);yellowcircle_8.setX(-1000);   yellowcircle_8.setY(-1000);
        alpha_animation(yellowcircle_9,0);
        yellowcircle_9.setVisibility(View.GONE);yellowcircle_9.setX(-1000);   yellowcircle_9.setY(-1000);
        alpha_animation(yellowcircle_10,0);
        yellowcircle_10.setVisibility(View.GONE);yellowcircle_10.setX(-1000);  yellowcircle_10.setY(-1000);
        alpha_animation(greencircle_1,0);
        greencircle_1.setVisibility(View.GONE);greencircle_1.setX(-1000);   greencircle_1.setY(-1000);
        alpha_animation(greencircle_2,0);
        greencircle_2.setVisibility(View.GONE);greencircle_2.setX(-1000);   greencircle_2.setY(-1000);
        alpha_animation(greencircle_3,0);
        greencircle_3.setVisibility(View.GONE);greencircle_3.setX(-1000);   greencircle_3.setY(-1000);
        alpha_animation(greencircle_4,0);
        greencircle_4.setVisibility(View.GONE);greencircle_4.setX(-1000);   greencircle_4.setY(-1000);
        alpha_animation(greencircle_5,0);
        greencircle_5.setVisibility(View.GONE);greencircle_5.setX(-1000);   greencircle_5.setY(-1000);
        alpha_animation(greencircle_6,0);
        greencircle_6.setVisibility(View.GONE);greencircle_6.setX(-1000);   greencircle_6.setY(-1000);
        alpha_animation(greencircle_7,0);
        greencircle_7.setVisibility(View.GONE);greencircle_7.setX(-1000);   greencircle_7.setY(-1000);
        alpha_animation(greencircle_8,0);
        greencircle_8.setVisibility(View.GONE);greencircle_8.setX(-1000);   greencircle_8.setY(-1000);
        alpha_animation(greencircle_9,0);
        greencircle_9.setVisibility(View.GONE);greencircle_9.setX(-1000);   greencircle_9.setY(-1000);
        alpha_animation(greencircle_10,0);
        greencircle_10.setVisibility(View.GONE);greencircle_10.setX(-1000);  greencircle_10.setY(-1000);

        reaction.setAnimateType(HTextViewType.EVAPORATE);reaction.animateText(" ");

    }
    private void Cancle_non_finger_alpha_animation(){
        alpha_animation(non_select_finger1,0);
        alpha_animation(non_select_finger2,0);
        alpha_animation(non_select_finger3,0);
        alpha_animation(non_select_finger4,0);
        alpha_animation(non_select_finger5,0);
        alpha_animation(non_select_finger6,0);
        alpha_animation(non_select_finger7,0);
        alpha_animation(non_select_finger8,0);
        alpha_animation(non_select_finger9,0);
        alpha_animation(non_select_finger10,0);
    }
    private void Handle_group_btn(){
        textView_group.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textView_copy.setText(R.string.two);
                String saver=textView_finger.getText().toString();
                textView_finger.setText(textView_group.getText().toString());
                textView_group.setText(saver);
                textView_group.setVisibility(View.GONE);
                textView_finger.setContentDescription("notselect");

            }
        });
    }
    private void Handle_finger_btn(){
        textView_finger.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(textView_finger.getContentDescription().equals("notselect")){
                    textView_group.setVisibility(View.VISIBLE);
                    textView_finger.setContentDescription("select");

                }else{
                    textView_group.setVisibility(View.GONE);
                    textView_finger.setContentDescription("notselect");

                }
            }
        });
    }
    private void Handle_Question(){
        final Question_Dialog_Fragment question_dialog_fragment=new Question_Dialog_Fragment();
        final FragmentManager fragmentManager=getSupportFragmentManager();
        qestion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            question_dialog_fragment.show(fragmentManager,"");
            }
        });
    }
    private void Handle_copy_btn(){

        textView_copy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Roatate_Animation(textView_copy);
                    if(textView_finger.getText().toString().equals("Finger")){
                        textView_smallrect.setText(R.string.f);
                        textView_one.setText(R.string.one);
                        textView_two.setText(R.string.two);
                        textView_tree.setText(R.string.three);
                        textView_four.setText(R.string.four);
                        textView_five.setText(R.string.five);
                        SetVisible_Circles();
                    }else{
                        textView_smallrect.setText(R.string.g);
                        textView_one.setText(R.string.two);
                        textView_two.setText(R.string.three);
                        textView_tree.setText(R.string.four);
                        textView_four.setText(R.string.five);
                        SetVisible_Circles();
                        textView_five.setVisibility(View.GONE);

                    }
                    textView_finger.setVisibility(View.GONE);
                int mio=textView_group.getVisibility();
                if(mio==0){
                    textView_group.setVisibility(View.GONE);
                    textView_finger.setContentDescription("notselect");
                }
                    textView_smallrect.setVisibility(View.VISIBLE);

            }
        });
    }
    private void Handle_numbers(){
        textView_one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textView_copy.setText(textView_one.getText().toString());
                SetGone_Circles();
                textView_finger.setVisibility(View.VISIBLE);
                textView_smallrect.setVisibility(View.GONE);
            }
        });
        ///
        textView_two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textView_copy.setText(textView_two.getText().toString());
                SetGone_Circles();
                textView_finger.setVisibility(View.VISIBLE);
                textView_smallrect.setVisibility(View.GONE);
            }
        });
        ///
        textView_tree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textView_copy.setText(textView_tree.getText().toString());
                SetGone_Circles();
                textView_finger.setVisibility(View.VISIBLE);
                textView_smallrect.setVisibility(View.GONE);
            }
        });
        ///
        textView_four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textView_copy.setText(textView_four.getText().toString());
                SetGone_Circles();
                textView_finger.setVisibility(View.VISIBLE);
                textView_smallrect.setVisibility(View.GONE);
            }
        });
        ///
        textView_five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textView_copy.setText(textView_five.getText().toString());
                SetGone_Circles();
                textView_finger.setVisibility(View.VISIBLE);
                textView_smallrect.setVisibility(View.GONE);
            }
        });

    }
    private void background_animation(){
        anim = (AnimationDrawable) constraintLayout.getBackground();
        anim.setEnterFadeDuration(3000);
        anim.setExitFadeDuration(2000);
        Scale_Animation(press_hold,1);
    }
    private void Selected_Fingers_Circle(MotionEvent event){
try {
    for(int i=0;i<=finger_randoms_array.length;i++){
        int xx=(int) finger_randoms_array[i]-1;
        int yy=(int) finger_randoms_array[i]-1;
        float ix=event.getX(xx);
        float jy=event.getY(yy);
        if(finger_randoms_array.length==1){
            Set_React_In_Pos(reaction,ix,jy);
        }
        switch(xx){
            case 0:SetVisView_In_Pos_Selecteds(redcircle_1,ix,jy); finger_rest_lock=1;break;
            case 1:SetVisView_In_Pos_Selecteds(redcircle_2,ix,jy); finger_rest_lock=1;break;
            case 2:SetVisView_In_Pos_Selecteds(redcircle_3,ix,jy); finger_rest_lock=1;break;
            case 3:SetVisView_In_Pos_Selecteds(redcircle_4,ix,jy); finger_rest_lock=1;break;
            case 4:SetVisView_In_Pos_Selecteds(redcircle_5,ix,jy); finger_rest_lock=1;break;
            case 5:SetVisView_In_Pos_Selecteds(redcircle_6,ix,jy); finger_rest_lock=1;break;
            case 6:SetVisView_In_Pos_Selecteds(redcircle_7,ix,jy); finger_rest_lock=1;break;
            case 7:SetVisView_In_Pos_Selecteds(redcircle_8,ix,jy); finger_rest_lock=1;break;
            case 8:SetVisView_In_Pos_Selecteds(redcircle_9,ix,jy); finger_rest_lock=1;break;
            case 9:SetVisView_In_Pos_Selecteds(redcircle_10,ix,jy); finger_rest_lock=1;break;
            case 10:SetVisView_In_Pos_Selecteds(bluecircle_1,ix,jy); finger_rest_lock=1;break;
            case 11:SetVisView_In_Pos_Selecteds(bluecircle_2,ix,jy); finger_rest_lock=1;break;
            case 12:SetVisView_In_Pos_Selecteds(bluecircle_3,ix,jy); finger_rest_lock=1;break;
            case 13:SetVisView_In_Pos_Selecteds(bluecircle_4,ix,jy); finger_rest_lock=1;break;
            case 14:SetVisView_In_Pos_Selecteds(bluecircle_5,ix,jy); finger_rest_lock=1;break;

        }
    }

}catch (Exception e){
    Log.i("TAG", "Eror: "+e.getMessage());
}

    }
    private void Selected_Groups_Circle(MotionEvent event){

        int min=0;
        int max=Integer.valueOf(final_number);
        try {
            int finalnumber=Integer.valueOf(final_number);
          int  finalnumber_1=pointer_count/finalnumber;
            int[] team_num_array=new int[finalnumber_1];
          for(int j=0;j<finalnumber_1;j++){
              team_num_array[j]=j;
            for(int i=min;i<max;i++){
                int xx=(int) finger_randoms_array[i]-1;
                int yy=(int) finger_randoms_array[i]-1;
                float ix=event.getX(xx);
                float jy=event.getY(yy);
                if(team_num_array[j]==0){//1 if
                    switch(xx){
                        case 0:SetVisView_In_Pos_Selecteds(redcircle_1,ix,jy);finger_rest_lock=1;break;
                        case 1:SetVisView_In_Pos_Selecteds(redcircle_2,ix,jy);finger_rest_lock=1;break;
                        case 2:SetVisView_In_Pos_Selecteds(redcircle_3,ix,jy);finger_rest_lock=1;break;
                        case 3:SetVisView_In_Pos_Selecteds(redcircle_4,ix,jy);finger_rest_lock=1;break;
                        case 4:SetVisView_In_Pos_Selecteds(redcircle_5,ix,jy);finger_rest_lock=1;break;
                        case 5:SetVisView_In_Pos_Selecteds(redcircle_6,ix,jy);finger_rest_lock=1;break;
                        case 6:SetVisView_In_Pos_Selecteds(redcircle_7,ix,jy);finger_rest_lock=1;break;
                        case 7:SetVisView_In_Pos_Selecteds(redcircle_8,ix,jy);finger_rest_lock=1;break;
                        case 8:SetVisView_In_Pos_Selecteds(redcircle_9,ix,jy);finger_rest_lock=1;break;
                        case 9:SetVisView_In_Pos_Selecteds(redcircle_10,ix,jy);finger_rest_lock=1;break;
                    }

                }//1 if

                if(team_num_array[j]==1){
                    switch(xx){
                        case 0:SetVisView_In_Pos_Selecteds(bluecircle_1,ix,jy);finger_rest_lock=1;break;
                        case 1:SetVisView_In_Pos_Selecteds(bluecircle_2,ix,jy);finger_rest_lock=1;break;
                        case 2:SetVisView_In_Pos_Selecteds(bluecircle_3,ix,jy);finger_rest_lock=1;break;
                        case 3:SetVisView_In_Pos_Selecteds(bluecircle_4,ix,jy);finger_rest_lock=1;break;
                        case 4:SetVisView_In_Pos_Selecteds(bluecircle_5,ix,jy);finger_rest_lock=1;break;
                        case 5:SetVisView_In_Pos_Selecteds(bluecircle_6,ix,jy);finger_rest_lock=1;break;
                        case 6:SetVisView_In_Pos_Selecteds(bluecircle_7,ix,jy);finger_rest_lock=1;break;
                        case 7:SetVisView_In_Pos_Selecteds(bluecircle_8,ix,jy);finger_rest_lock=1;break;
                        case 8:SetVisView_In_Pos_Selecteds(bluecircle_9,ix,jy);finger_rest_lock=1;break;
                        case 9:SetVisView_In_Pos_Selecteds(bluecircle_10,ix,jy);finger_rest_lock=1;break;
                    }
                }

                if(team_num_array[j]==2){
                    switch(xx){
                        case 0:SetVisView_In_Pos_Selecteds(darkblue_1,ix,jy);finger_rest_lock=1;break;
                        case 1:SetVisView_In_Pos_Selecteds(darkblue_2,ix,jy);finger_rest_lock=1;break;
                        case 2:SetVisView_In_Pos_Selecteds(darkblue_3,ix,jy);finger_rest_lock=1;break;
                        case 3:SetVisView_In_Pos_Selecteds(darkblue_4,ix,jy);finger_rest_lock=1;break;
                        case 4:SetVisView_In_Pos_Selecteds(darkblue_5,ix,jy);finger_rest_lock=1;break;
                        case 5:SetVisView_In_Pos_Selecteds(darkblue_6,ix,jy);finger_rest_lock=1;break;
                        case 6:SetVisView_In_Pos_Selecteds(darkblue_7,ix,jy);finger_rest_lock=1;break;
                        case 7:SetVisView_In_Pos_Selecteds(darkblue_8,ix,jy);finger_rest_lock=1;break;
                        case 8:SetVisView_In_Pos_Selecteds(darkblue_9,ix,jy);finger_rest_lock=1;break;
                        case 9:SetVisView_In_Pos_Selecteds(darkblue_10,ix,jy);finger_rest_lock=1;break;
                    }
                }

                if(team_num_array[j]==3){
                    switch(xx){
                        case 0:SetVisView_In_Pos_Selecteds(yellowcircle_1,ix,jy);finger_rest_lock=1;break;
                        case 1:SetVisView_In_Pos_Selecteds(yellowcircle_2,ix,jy);finger_rest_lock=1;break;
                        case 2:SetVisView_In_Pos_Selecteds(yellowcircle_3,ix,jy);finger_rest_lock=1;break;
                        case 3:SetVisView_In_Pos_Selecteds(yellowcircle_4,ix,jy);finger_rest_lock=1;break;
                        case 4:SetVisView_In_Pos_Selecteds(yellowcircle_5,ix,jy);finger_rest_lock=1;break;
                        case 5:SetVisView_In_Pos_Selecteds(yellowcircle_6,ix,jy);finger_rest_lock=1;break;
                        case 6:SetVisView_In_Pos_Selecteds(yellowcircle_7,ix,jy);finger_rest_lock=1;break;
                        case 7:SetVisView_In_Pos_Selecteds(yellowcircle_8,ix,jy);finger_rest_lock=1;break;
                        case 8:SetVisView_In_Pos_Selecteds(yellowcircle_9,ix,jy);finger_rest_lock=1;break;
                        case 9:SetVisView_In_Pos_Selecteds(yellowcircle_10,ix,jy);finger_rest_lock=1;break;
                    }
                }

                if(team_num_array[j]==4){
                    switch(xx){
                        case 0:SetVisView_In_Pos_Selecteds(greencircle_1,ix,jy);finger_rest_lock=1;break;
                        case 1:SetVisView_In_Pos_Selecteds(greencircle_2,ix,jy);finger_rest_lock=1;break;
                        case 2:SetVisView_In_Pos_Selecteds(greencircle_3,ix,jy);finger_rest_lock=1;break;
                        case 3:SetVisView_In_Pos_Selecteds(greencircle_4,ix,jy);finger_rest_lock=1;break;
                        case 4:SetVisView_In_Pos_Selecteds(greencircle_5,ix,jy);finger_rest_lock=1;break;
                        case 5:SetVisView_In_Pos_Selecteds(greencircle_6,ix,jy);finger_rest_lock=1;break;
                        case 6:SetVisView_In_Pos_Selecteds(greencircle_7,ix,jy);finger_rest_lock=1;break;
                        case 7:SetVisView_In_Pos_Selecteds(greencircle_8,ix,jy);finger_rest_lock=1;break;
                        case 8:SetVisView_In_Pos_Selecteds(greencircle_9,ix,jy);finger_rest_lock=1;break;
                        case 9:SetVisView_In_Pos_Selecteds(greencircle_10,ix,jy);finger_rest_lock=1;break;
                    }
                }

            }
            min=max;
            max+=finalnumber;
          }
        }catch (Exception e){
            Log.i("TAG", "Eror: "+e.getMessage());
        }
    }
    private void alpha_animation(final View view, int lock){
        AlphaAnimation alphaAnimation=new AlphaAnimation(1f,0f);
        alphaAnimation.setDuration(700);
        alphaAnimation.setFillAfter(false);
        alphaAnimation.setRepeatCount(Animation.INFINITE);
        alphaAnimation.setRepeatMode(Animation.REVERSE);
        if(lock==2){
            alphaAnimation.setRepeatMode(2);
            alphaAnimation.setRepeatCount(5);
        }

        view.startAnimation(alphaAnimation);
        if(lock==0){
            alphaAnimation.cancel();
        }
    }
    private void Scale_Animation(View view,int lock){
        ScaleAnimation scaleAnimation=new ScaleAnimation(1f,0.75f,1f,0.75f,Animation.RELATIVE_TO_SELF,0.5f,Animation.RELATIVE_TO_SELF,0.5f);
scaleAnimation.setFillAfter(false);
scaleAnimation.setDuration(3000);
scaleAnimation.setRepeatCount(Animation.INFINITE);
scaleAnimation.setRepeatMode(Animation.REVERSE);
scaleAnimation.setInterpolator(new DecelerateInterpolator());
view.startAnimation(scaleAnimation);
if(lock==0){
    scaleAnimation.cancel();

}
    }
    private void Roatate_Animation(View view){
        RotateAnimation rotateAnimation=new RotateAnimation(0f,360f,Animation.RELATIVE_TO_SELF,0.5f,Animation.RELATIVE_TO_SELF,0.5f);
        rotateAnimation.setDuration(200);
        rotateAnimation.setFillAfter(false);
        rotateAnimation.setRepeatCount(0);
        view.startAnimation(rotateAnimation);
    }
    //////////////////////////////////////back funcs
    private void vibrate(int vibarate){
        Vibrator v = (Vibrator) getSystemService(getApplicationContext().VIBRATOR_SERVICE);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            v.vibrate(VibrationEffect.createOneShot(vibarate, VibrationEffect.DEFAULT_AMPLITUDE));
        } else {//api26>>x
            v.vibrate(vibarate);
        }
    }
    private void My_timer(){
        hTextView.setAnimateType(HTextViewType.FALL);
        timer=new Timer();
        if(sec==3){
            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                         //   count_sec.setVisibility(View.VISIBLE);
                            hTextView.setVisibility(View.VISIBLE);
                            hTextView.animateText(String.valueOf(sec));
                         //   count_sec.setText(String.valueOf(sec));
                            sec--;
                            if(sec==-1){
                                timer.cancel();
                                timer.purge();
                           //     count_sec.setVisibility(View.GONE);
                                hTextView.setVisibility(View.GONE);
                                vibrate(500);
                                Random_Selection();
                                SetGone_non_fingers();
                                Cancle_non_finger_alpha_animation();
                                sec=3;
                            }
                        }
                    });
                }
            },0,1000);}
    }
    private void Reset_Timer(){
        if(sec_reset_timer==1){
            reset_timer=new Timer();
            reset_timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            sec_reset_timer--;
                            if(sec_reset_timer==0){
                                SetGone_Selected_Circles();
                                reset_timer.cancel();
                                reset_timer.purge();
                                sec_reset_timer=1;
                            }
                        }
                    });
                }
            },0,1000);}
    }
    private void Random_Selection(){
        if(Integer.parseInt(final_number)>pointer_count){
            final_number=String.valueOf(pointer_count);
        }
        int[] list=new int[Integer.parseInt(final_number)];
        if(final_Mode.equals("Finger")){////finger
                Random randNum = new Random();
                Set<Integer> set = new LinkedHashSet<Integer>();
                while (set.size() < list.length) {
                    set.add(randNum.nextInt(pointer_count)+1);
                }
                finger_randoms_array= set.toArray();
                Selected_Fingers_Circle(event);
        }////finger
        if(final_Mode.equals("Group")){////Group
            Random randNum = new Random();
            Set<Integer> set = new LinkedHashSet<Integer>();
            Log.i("TAG", "pointer count: "+pointer_count);
            while (set.size() <pointer_count) {
                set.add(randNum.nextInt(pointer_count)+1);
            }
            finger_randoms_array= set.toArray();
            Log.i("TAG", "set: "+set);
            Selected_Groups_Circle(event);
        }////Group


    }
    private void SetVisView_In_Pos(View view,float x,float y){
        view.setX(x-dpToPx(48));
        view.setY(y-dpToPx(48+24));
        view.setVisibility(View.VISIBLE);
    }
    private void SetVisView_In_Pos_Selecteds(View view,float x,float y){
        view.setX(x-dpToPx(84));
        view.setY(y-dpToPx(63+32));
        view.setVisibility(View.VISIBLE);
        alpha_animation(view,2);
    }
    private void Set_React_In_Pos(View view,float x,float y){
        String[] string_reacts= new String[8];
        string_reacts[0]="Heyyy,lucky!";string_reacts[1]="lucky luke!";
        string_reacts[2]="just unlucky in love";string_reacts[3]="God of luck";
        string_reacts[4]="lucky luke!";string_reacts[5]="look that lucky guy!";
        string_reacts[6]="Heyyy,lucky!";string_reacts[7]="look that lucky guy!";

        WindowManager wm = (WindowManager) getApplicationContext().getSystemService(getApplicationContext().WINDOW_SERVICE);
        Display display = wm.getDefaultDisplay();
        DisplayMetrics metrics = new DisplayMetrics();
        ((Display) display).getMetrics(metrics);
        int width = metrics.widthPixels;
        int height = metrics.heightPixels;


if(x<183){
    view.setX(x+dpToPx(30));
    view.setY(y-dpToPx(40));
}
else if(x>width-245){
    view.setX(x-dpToPx(290));
    view.setY(y-dpToPx(40));
}
else if(y<300){
    view.setX(x-dpToPx(130));
    view.setY(y+dpToPx(30));
}
else {
    view.setX(x-dpToPx(130));
    view.setY(y-dpToPx(150));
}

        view.setVisibility(View.VISIBLE);
        Random random=new Random();
        reaction.setAnimateType(HTextViewType.EVAPORATE);reaction.animateText(string_reacts[random.nextInt(8)]);
    }
    public static int pxToDp(int px) {
        return (int) (px / Resources.getSystem().getDisplayMetrics().density);
    }
    public static int dpToPx(int dp) {
        return (int) (dp * Resources.getSystem().getDisplayMetrics().density);
    }
    private void Case_Action_Pointer_Down(MotionEvent event,int pointerid){
        float x=event.getX(pointerid);
        float y=event.getY(pointerid);
        Log.i("TAG", "Case_Action_Pointer_Down: "+pointerid);
        switch (pointerid){
            case 0: SetVisView_In_Pos(non_select_finger1,x,y);alpha_animation(non_select_finger1,1);vibrate(50);break;
            case 1: SetVisView_In_Pos(non_select_finger2,x,y);alpha_animation(non_select_finger2,1);vibrate(50);break;
            case 2: SetVisView_In_Pos(non_select_finger3,x,y);alpha_animation(non_select_finger3,1);vibrate(50);break;
            case 3: SetVisView_In_Pos(non_select_finger4,x,y);alpha_animation(non_select_finger4,1);vibrate(50);break;
            case 4: SetVisView_In_Pos(non_select_finger5,x,y);alpha_animation(non_select_finger5,1);vibrate(50);break;
            case 5: SetVisView_In_Pos(non_select_finger6,x,y);alpha_animation(non_select_finger6,1);vibrate(50);break;
            case 6: SetVisView_In_Pos(non_select_finger7,x,y);alpha_animation(non_select_finger7,1);vibrate(50);break;
            case 7: SetVisView_In_Pos(non_select_finger8,x,y);alpha_animation(non_select_finger8,1);vibrate(50);break;
            case 8: SetVisView_In_Pos(non_select_finger9,x,y);alpha_animation(non_select_finger9,1);vibrate(50);break;
            case 9: SetVisView_In_Pos(non_select_finger10,x,y);alpha_animation(non_select_finger10,1);vibrate(50);break;
        }

    }
    private void Move_Finger(MotionEvent event,int pointerid){

/*
        float x=event.getX(pointer_test);
        float y=event.getY(pointer_test);
        Log.i("TAG", "Case_Action_MOve: "+pointerid);
        switch (pointerid){
            case 0: SetVisView_In_Pos(non_select_finger1,x,y);break;
            case 1: SetVisView_In_Pos(non_select_finger2,x,y);break;
            case 2: SetVisView_In_Pos(non_select_finger3,x,y);break;
            case 3: SetVisView_In_Pos(non_select_finger4,x,y);break;
            case 4: SetVisView_In_Pos(non_select_finger5,x,y);break;
            case 5: SetVisView_In_Pos(non_select_finger6,x,y);break;
            case 6: SetVisView_In_Pos(non_select_finger7,x,y);break;
            case 7: SetVisView_In_Pos(non_select_finger8,x,y);break;
            case 8: SetVisView_In_Pos(non_select_finger9,x,y);break;
            case 9: SetVisView_In_Pos(non_select_finger10,x,y);break;
        }
*/

    }
    private void Case_Action_Pointer_Up(MotionEvent event,int pointerid){
        switch (pointerid){
            case 0:non_select_finger1.setVisibility(View.GONE);alpha_animation(non_select_finger1,0); break;
            case 1:non_select_finger2.setVisibility(View.GONE);alpha_animation(non_select_finger2,0); break;
            case 2:non_select_finger3.setVisibility(View.GONE);alpha_animation(non_select_finger3,0);  break;
            case 3:non_select_finger4.setVisibility(View.GONE);alpha_animation(non_select_finger4,0);  break;
            case 4:non_select_finger5.setVisibility(View.GONE); alpha_animation(non_select_finger5,0); break;
            case 5:non_select_finger6.setVisibility(View.GONE);alpha_animation(non_select_finger6,0);  break;
            case 6:non_select_finger7.setVisibility(View.GONE);alpha_animation(non_select_finger7,0);  break;
            case 7:non_select_finger8.setVisibility(View.GONE);alpha_animation(non_select_finger8,0);  break;
            case 8:non_select_finger9.setVisibility(View.GONE);alpha_animation(non_select_finger9,0);  break;
            case 9:non_select_finger10.setVisibility(View.GONE); alpha_animation(non_select_finger10,0); break;
        }
    }
    private void Case_Action_Down(MotionEvent event){
        int mio=textView_group.getVisibility();
        if(mio==0){
            textView_group.setVisibility(View.GONE);
            textView_finger.setContentDescription("notselect");
        }
        final_Mode=textView_finger.getText().toString();
        final_number=textView_copy.getText().toString();


        if(textView_finger.getText().toString().equals("Finger")){
            textView_smallrect.setText(R.string.f);
        }else{
            textView_smallrect.setText(R.string.g);
        }

        Scale_Animation(press_hold,0);
        press_hold.setVisibility(View.GONE);
        textView_smallrect.setVisibility(View.VISIBLE);
        textView_finger.setVisibility(View.GONE);
        float x=event.getX();
        float y=event.getY();
        SetVisView_In_Pos(non_select_finger1,x,y);
        alpha_animation(non_select_finger1,1);
        vibrate(59);
        My_timer();

    }
    private void Case_Action_up(MotionEvent event,int pointerid){
       // non_select_finger1.setVisibility(View.GONE);
        Case_Action_Pointer_Up(event,pointerid);
        //count_sec.setVisibility(View.GONE);
        hTextView.setVisibility(View.GONE);
        press_hold.setVisibility(View.VISIBLE);
        Scale_Animation(press_hold,1);
        textView_smallrect.setVisibility(View.GONE);
        textView_finger.setVisibility(View.VISIBLE);
        timer.cancel();
        timer.purge();
        sec=3;
        if(finger_rest_lock==1){
            Reset_Timer();
            finger_rest_lock=0;
        }
    }
    //////////////////////////////////////

   @Override
    public boolean onTouchEvent(MotionEvent event) {
       float x=event.getX();
       this.event=event;
       float y=event.getY();
       int pointerIndex = event.getActionIndex();
       int pointerId = event.getPointerId(pointerIndex);
       int maskedAction = event.getActionMasked();
       pointer_count=event.getPointerCount();
       switch (maskedAction) {
           case MotionEvent.ACTION_DOWN:Case_Action_Down(event); break;
           case MotionEvent.ACTION_POINTER_DOWN:Case_Action_Pointer_Down(event,pointerId); num_finger++;break;
           case MotionEvent.ACTION_UP:Case_Action_up(event,pointerId); break;
           case MotionEvent.ACTION_POINTER_UP:num_finger--; Case_Action_Pointer_Up(event,pointerId);break;
       //    case MotionEvent.ACTION_MOVE:Move_Finger(event,pointerId);break;

       }

           return true;
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (anim != null && !anim.isRunning())
            anim.start();
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (anim != null && anim.isRunning())
            anim.stop();
    }
}