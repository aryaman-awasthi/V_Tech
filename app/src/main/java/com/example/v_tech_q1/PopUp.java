package com.example.v_tech_q1;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;


import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatDialogFragment;

import java.util.HashMap;
import java.util.Map;

public class PopUp extends AppCompatDialogFragment {
    private TextView title;
    private TextView Occ;
    private TextView ans;
    private int occ = 0;
    private String type = "";
    private HashMap<Character, Integer> hashMap ;
    PopUp(int o, String t, HashMap h)
    {
        occ = o;
        type = t;
        hashMap = h;
    }
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.popup, null);
        builder.setView(view)
        .setPositiveButton("Okay", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        title = view.findViewById(R.id.d_tv);title.setText(type);
        Occ = view.findViewById(R.id.d_occ); Occ.setText(new StringBuilder().append(type).append(" in your input: ").append(occ).toString());
        ans = view.findViewById(R.id.ans);
        String final_ans =  "Character\t->\tOccurrence(s)\n";
        for (Map.Entry<Character,Integer> entry : hashMap.entrySet())
        {
            char key = entry.getKey();
            int obj = entry.getValue();
            if(obj != 0)
            {
                final_ans = final_ans + key + "\t->\t" + obj+"\n";
            }
        }
        ans.setText(final_ans);
        return builder.create();
    }
}
