package com.example.v_tech_q1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText editText = (EditText) findViewById(R.id.et);

        Button btn = (Button) findViewById(R.id.buttonPanel);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = editText.getText().toString().replace(" ","").replace("\n","");
                char[] arr = text.toCharArray();
                Arrays.sort(arr);
                TextView tv = (TextView)findViewById(R.id.tv);
                tv.setText(Arrays.toString(arr));
            }
        });
    }
}