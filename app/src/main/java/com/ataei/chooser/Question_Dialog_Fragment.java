package com.ataei.chooser;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentManager;

public class Question_Dialog_Fragment extends DialogFragment {
    View view;
    ImageView next;
    TextView gp_mode;
    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder=new AlertDialog.Builder(getContext());
        view= LayoutInflater.from(getContext()).inflate(R.layout.question_dialog_fragment,null,false);
        setupviwes();
        handleclicks();
        builder.setView(view);
        return builder.create();
    }

    private void setupviwes(){
        next=view.findViewById(R.id.next_f_1);
        gp_mode=view.findViewById(R.id.groupemode_f_1);
    }

    private void handleclicks() {
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fragmentManager=getFragmentManager();
                Dialog_F_2 dialog_f_2=new Dialog_F_2();
                dialog_f_2.show(fragmentManager,"");
                dismiss();
            }
        });
        ////
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


}
