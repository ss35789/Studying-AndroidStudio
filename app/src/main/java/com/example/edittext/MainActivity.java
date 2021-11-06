package com.example.edittext;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText et_id;
    private Button btn_test;
    private String string;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et_id=findViewById(R.id.et_id);
        btn_test=findViewById((R.id.btn_test));


        btn_test.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                string=et_id.getText().toString();

                Intent intent = new Intent(MainActivity.this,Subactivity.class);
                intent.putExtra("str",string);
                startActivity(intent);
            }
        });
    }
}