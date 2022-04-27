package com.example.syscapstone;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.gesture.GestureOverlayView;
import android.view.GestureDetector;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.ScrollView;
import android.widget.TextView;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    //객체 선언
    View view1, view2;
    ScrollView scrollView1;
    TextView textView1;
    GestureDetector detector; //무슨 제스쳐를 했는지 감지

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //객체 초기화
        view1 = findViewById(R.id.view1);
        scrollView1 = findViewById(R.id.scrollView1);
        textView1 = findViewById(R.id.textView1);

        //터치를 했을때 작동하는 메서드
        view1.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                int action = event.getAction();
                float curX = event.getX();  //눌린 곳의 X좌표
                float curY = event.getY();  //눌린 곳의 Y좌표

                if(action == event.ACTION_DOWN) {   //처음 눌렸을 때
                    printString("손가락 눌림 : " + curX + ", " + curY);
                } else if(action == event.ACTION_MOVE) {    //누르고 움직였을 때
                    printString("손가락 움직임 : " + curX + ", " + curY);
                } else if(action == event.ACTION_UP) {    //누른걸 뗐을 때
                    printString("손가락 뗌 : " + curX + ", " + curY);
                }
                return true;
            }
        });
    }

    private void printString(String s) {
        //좌표 출력
        textView1.append(s + "\n"); //한 줄씩 추가

        //자동으로 마지막 줄로 스크롤 내림
        scrollView1.fullScroll(View.FOCUS_DOWN);
    }

    public void click1(View view){

        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
    public void click2(View view){

        Intent intent = new Intent(this, MainActivity2.class);
        startActivity(intent);
    }
    public void click3(View view){

        Intent intent = new Intent(this, MainActivity3.class);
        startActivity(intent);
    }
}