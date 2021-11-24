package com.example.edittext;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.WebBackForwardList;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
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
    private Button btn_open;
    private Button btn_close;

    private String string;
    private ImageView test_Image;
    private ListView list;
    private String shared;
    private WebView webview;
    private String url="https://www.naver.com/";

    private DrawerLayout drawerLayout;
    private View    drawer;




    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if((keyCode==KeyEvent.KEYCODE_BACK)&&webview.canGoBack()){
            webview.goBack();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et_id=findViewById(R.id.et_id);
        btn_test=findViewById((R.id.btn_test));
        drawerLayout=findViewById(R.id.main);
        drawer=findViewById(R.id.drawer);
        btn_open=findViewById(R.id.btn_openmenu);
        btn_close=findViewById(R.id.btn_close);


        webview=findViewById(R.id.webview);
        webview.getSettings().setJavaScriptEnabled(true);
        webview.loadUrl(url);
        webview.setWebChromeClient((new WebChromeClient()));
        webview.setWebViewClient(new WebViewClientClass());

        test_Image=(ImageView)findViewById(R.id.test_Image);
        SharedPreferences sharedPreferences=getSharedPreferences(shared,0);
        String value=sharedPreferences.getString("임시기억자료","");
        et_id.setText(value);


        Intent intent = new Intent(MainActivity.this,Subactivity.class);
        drawerLayout=findViewById(R.id.main);



        btn_open.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.openDrawer(drawer);
            }
        });

        btn_close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.closeDrawer(drawer);
            }
        });

        btn_test.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                string=et_id.getText().toString();
                if(string.length()==0)Toast.makeText(getApplicationContext(),"Need Data",Toast.LENGTH_LONG).show();


                intent.putExtra("str",string);
                startActivity(intent);
            }
        });



        test_Image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"Just test!",Toast.LENGTH_SHORT).show();
                startActivity(intent);
            }
        });
        drawerLayout.setDrawerListener(listener);
        drawer.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return true;
            }
        });



    }

    DrawerLayout.DrawerListener listener= new DrawerLayout.DrawerListener() {
        @Override
        public void onDrawerSlide(@NonNull View drawerView, float slideOffset) {

        }

        @Override
        public void onDrawerOpened(@NonNull View drawerView) {

        }

        @Override
        public void onDrawerClosed(@NonNull View drawerView) {

        }

        @Override
        public void onDrawerStateChanged(int newState) {

        }
    };

    @Override
    protected void onDestroy() {
        super.onDestroy();

        SharedPreferences sharedPreferences=getSharedPreferences(shared,0);
        SharedPreferences.Editor editor=sharedPreferences.edit();
        String value=et_id.getText().toString();
        editor.putString("임시기억자료",value);
        editor.commit();
    }

    private class WebViewClientClass extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {//햔재 페이지의 url을 읽어오는 메서드
            view.loadUrl(url);
            return true;
        }
    }





}