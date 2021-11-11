package com.example.edittext;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class Subactivity extends AppCompatActivity {

    private TextView sub_text;
    private Button btn_move;
    private ListView list;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subactivity);

        sub_text=findViewById(R.id.sub_text);
        btn_move=findViewById(R.id.btn_move);
        list=findViewById(R.id.list);

        List<String> data=new ArrayList<>();
        ArrayAdapter <String> adapter=new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,data);
        list.setAdapter(adapter);//Main에서 입력한 아이디를 List(data)에 저장하여 로그인할 때마다 입력했던 정보들을 Sub의 ListView에 나오게 구현하고 싶음


        Intent intent=getIntent();
        String str=intent.getStringExtra("str");


        sub_text.setText(str);
        data.add(str);
        data.add("사과");
        adapter.notifyDataSetChanged();
        btn_move.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1=new Intent(Subactivity.this,MainActivity.class);
                startActivity(intent1);
            }
        });


    }


}