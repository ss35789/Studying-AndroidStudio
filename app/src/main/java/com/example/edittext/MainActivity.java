package com.example.edittext;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private EditText et_id;
    private Button btn_test;
    private Button btn_NDmove;
    private String string;
    private ImageView test_Image;
    private ListView list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et_id=findViewById(R.id.et_id);
        btn_test=findViewById((R.id.btn_test));
        btn_NDmove=findViewById((R.id.btn_NDmove));
        test_Image=(ImageView)findViewById(R.id.test_Image);


        Intent intent = new Intent(MainActivity.this,Subactivity.class);
        Intent intent_ND = new Intent(MainActivity.this,NDActivity.class);




        btn_test.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                string=et_id.getText().toString();
                if(string.length()==0)Toast.makeText(getApplicationContext(),"Need Data",Toast.LENGTH_LONG).show();


                intent.putExtra("str",string);
                startActivity(intent);
            }
        });
        btn_NDmove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intent_ND);
            }
        });


        test_Image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"Just test!",Toast.LENGTH_SHORT).show();
                startActivity(intent);
            }
        });







    }
}