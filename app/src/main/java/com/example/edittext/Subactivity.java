package com.example.edittext;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Subactivity extends AppCompatActivity {

    private TextView sub_text;
    private Button btn_move;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subactivity);

        sub_text=findViewById(R.id.sub_text);
        btn_move=findViewById(R.id.btn_move);
        Intent intent=getIntent();
        String str=intent.getStringExtra("str");

        sub_text.setText(str);

        btn_move.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1=new Intent(Subactivity.this,MainActivity.class);
                startActivity(intent1);
            }
        });


    }
}