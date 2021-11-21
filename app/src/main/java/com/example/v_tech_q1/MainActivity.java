package com.example.v_tech_q1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Locale;

@SuppressWarnings("ALL")
public class MainActivity extends AppCompatActivity {

    EditText editText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


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
    public void openDialog(int occ, HashMap hashMap, String type)
    {
        PopUp popUp = new PopUp(occ, type, hashMap);
        popUp.show(getSupportFragmentManager(), "open dialog");
    }
    public boolean vowelCheck(char character)
    {
        return character == 'A' || character == 'E' || character == 'I' || character == 'O' || character == 'U';
    }
}