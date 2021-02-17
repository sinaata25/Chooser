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

public class Dialog_F_3 extends DialogFragment {
    View view;
    ImageView back;
    TextView gp_mode;
    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder=new AlertDialog.Builder(getContext());
        view= LayoutInflater.from(getContext()).inflate(R.layout.dialog_f_3,null,false);
        builder.setView(view);
        setupviwes();
        handleclicks();
        return builder.create();
    }

    private void handleclicks() {
        back.setOnClickListener(new View.OnClickListener() {
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

    private void setupviwes() {
        back=view.findViewById(R.id.back_f_3);
        gp_mode=view.findViewById(R.id.groupemode_f_3);
    }


}
