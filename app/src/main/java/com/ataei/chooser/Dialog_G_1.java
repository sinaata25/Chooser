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

public class Dialog_G_1 extends DialogFragment {
    View view;
    ImageView next;
    TextView f_mode;
    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder=new AlertDialog.Builder(getContext());
        view= LayoutInflater.from(getContext()).inflate(R.layout.dialog_g_1,null,false);
          setupviwes();
          handleclicks();
        builder.setView(view);
        return builder.create();
    }

    private void setupviwes(){
        next=view.findViewById(R.id.next_g_1);
        f_mode=view.findViewById(R.id.fingetmode_g_1);
    }

    private void handleclicks() {
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fragmentManager=getFragmentManager();
                Dialog_G_2 dialog_g_2=new Dialog_G_2();
                dialog_g_2.show(fragmentManager,"");
                dismiss();
            }
        });
        //////////
        f_mode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fragmentManager=getFragmentManager();
                Question_Dialog_Fragment question_dialog_fragment=new Question_Dialog_Fragment();
                question_dialog_fragment.show(fragmentManager,"");
                dismiss();
            }
        });

    }


}
