package com.example.v_tech_q1;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

@SuppressWarnings("ALL")
public class MainActivity extends AppCompatActivity {

    EditText editText;
    Dialog dialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dialog = new Dialog(this);
        dialog.getWindow().getAttributes().windowAnimations = R.style.animation;
    }

    public void vowels(View view) {
        editText = (EditText) findViewById(R.id.et);
        String text = editText.getText().toString().replace(" ", "").replace("\n", "");
        if (text.isEmpty())
        {
            editText.setHint("Empty Field!");
            editText.setHintTextColor(getResources().getColor(R.color.l_red));
        }
        else
        {
            char[] arr = text.toUpperCase().toCharArray();
            int v_count = 0;
            HashMap<Character, Integer> hashMap = new HashMap<>();
            hashMap.put('A', 0);
            hashMap.put('E', 0);
            hashMap.put('I', 0);
            hashMap.put('O', 0);
            hashMap.put('U', 0);

            for (char character : arr)
            {
                if (vowelCheck(character))
                {
                    v_count++;
                    int occ = hashMap.get(character) + 1;
                    hashMap.put(character, occ);
                }
            }
            openDialog(v_count, hashMap, "Vowels");
        }
    }

    public void consonants(View view) {
        editText = (EditText) findViewById(R.id.et);
        String text = editText.getText().toString().replace(" ", "").replace("\n", "");
        if (text.isEmpty())
        {
            editText.setHint("Empty Field!");
            editText.setHintTextColor(getResources().getColor(R.color.l_red));
        }
        else
        {
            char[] arr = text.toUpperCase().toCharArray();
            int c_count = 0;
            HashMap<Character, Integer> hashMap = new HashMap<>();
            for (char character : arr)
            {
                if (Character.isAlphabetic(character) && (!vowelCheck(character)))
                {
                    hashMap.put(character, 0);
                }
            }

            for (char character : arr)
            {
                if (Character.isAlphabetic(character) && (!vowelCheck(character)))
                {
                    c_count++;
                    int occ = hashMap.get(character) + 1;
                    hashMap.put(character, occ);
                }
            }
            openDialog(c_count, hashMap, "Consonants");
        }
    }

    public void capital_letters(View view) {
        editText = (EditText) findViewById(R.id.et);
        String text = editText.getText().toString().replace(" ", "").replace("\n", "");
        if (text.isEmpty())
        {
            editText.setHint("Empty Field!");

            editText.setHintTextColor(getResources().getColor(R.color.l_red));
        }
        else {
            editText.setHintTextColor(getResources().getColor(R.color.l_red));
            char[] arr = text.toCharArray();
            Arrays.sort(arr);
            int ucc_count = 0;
            HashMap<Character, Integer> hashMap = new HashMap<>();

            for (char character = 'A' ; character <= 'Z'; character++)
            {
                hashMap.put(character, 0);
            }
            for (char character : arr)
            {
                if (Character.isAlphabetic(character))
                {
                    if(Character.isUpperCase(character))
                    {
                        ucc_count ++;
                        int occ = hashMap.get(character) + 1;
                        hashMap.put(character, occ);
                    }
                    else break;
                }
                else
                {
                    continue;
                }
            }
            openDialog(ucc_count, hashMap, "Upper case Characters");
        }
    }

    public void small_letters(View view) {
        editText = (EditText) findViewById(R.id.et);
        String text = editText.getText().toString().replace(" ", "").replace("\n", "");
        if (text.isEmpty())
        {
            editText.setHint("Empty Field!");
            editText.setHintTextColor(getResources().getColor(R.color.l_red));
        }
        else {
            char[] arr = text.toCharArray();
            Arrays.sort(arr);
            int lcc_count = 0;
            HashMap<Character, Integer> hashMap = new HashMap<>();

            for (char character = 'a' ; character <= 'z'; character++)
            {
                hashMap.put(character, 0);
            }
            for (char character : arr)
            {
                if (Character.isAlphabetic(character))
                {
                    if(Character.isLowerCase(character))
                    {
                        lcc_count ++;
                        int occ = hashMap.get(character) + 1;
                        hashMap.put(character, occ);
                    }
                }
                else
                {
                    continue;
                }
            }
            openDialog(lcc_count, hashMap, "Lower Case Characters");
        }
    }

    public void digits(View view) {
        editText = (EditText) findViewById(R.id.et);
        String text = editText.getText().toString().replace(" ", "").replace("\n", "");
        if (text.isEmpty())
        {
            editText.setHint("Empty Field!");
            editText.setHintTextColor(getResources().getColor(R.color.l_red));
        }
        else
        {
            char arr[] = text.toUpperCase().toCharArray();
            int d_count = 0;
            HashMap<Character, Integer> hashMap = new HashMap<>();
            for (int i = 0; i <= 9; i++)
            {
                hashMap.put((i+"").charAt(0), 0);
            }

            for (char character : arr)
            {
                if (Character.isDigit(character))
                {
                    d_count++;
                    int occ = hashMap.get(character) + 1;
                    hashMap.put(character, occ);
                }
            }
            openDialog(d_count, hashMap, "Digits");
        }
    }
    boolean vowelCheck(char character)
    {
        return character == 'A' || character == 'E' || character == 'I' || character == 'O' || character == 'U';
    }

    private void openDialog(int occ, HashMap<Character,Integer> hashMap, String type)
    {
        dialog.setContentView(R.layout.popup);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        TextView title = dialog.findViewById(R.id.d_tv);
        TextView Occ = dialog.findViewById(R.id.d_occ);
        TextView ans = dialog.findViewById(R.id.ans);
        Button button = dialog.findViewById(R.id.btn);
        title.setText(type);
        Occ.setText(new StringBuilder().append(type).append(" in your input: ").append(occ).toString());
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
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        dialog.show();
    }
}