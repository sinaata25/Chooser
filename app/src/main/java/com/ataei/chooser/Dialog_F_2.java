package com.ataei.chooser;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentManager;

public class Dialog_F_2 extends DialogFragment {
    View view;
    ImageView next,back;
    TextView gp_mode;
    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder=new AlertDialog.Builder(getContext());
        view= LayoutInflater.from(getContext()).inflate(R.layout.dialog_f_2,null,false);
        builder.setView(view);
        setupviwes();
        handleclicks();
        return builder.create();
    }

    private void handleclicks() {
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fragmentManager=getFragmentManager();
                Dialog_F_3 dialog_f_3=new Dialog_F_3();
                dialog_f_3.show(fragmentManager,"");
                dismiss();
            }
        });
        /////
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fragmentManager=getFragmentManager();
               Question_Dialog_Fragment question_dialog_fragment=new Question_Dialog_Fragment();
               question_dialog_fragment.show(fragmentManager,"");
                dismiss();
            }
        });
        //////
        gp_mode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fragmentManager=getFragmentManager();
                Dialog_G_1 dialog_g_1=new Dialog_G_1();
                dialog_g_1.show(fragmentManager,"");
                dismiss();
            }
        });
    }

    private void setupviwes() {
        next=view.findViewById(R.id.next_f_2);
        back=view.findViewById(R.id.back_f_2);
        gp_mode=view.findViewById(R.id.groupemode_f_2);
    }


}