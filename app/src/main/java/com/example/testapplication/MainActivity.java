package com.example.testapplication;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

// 과제 1
public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        // 과제 3
        TextView textView = findViewById(R.id.main_textView);
        Button button = findViewById(R.id.main_button);
        LinearLayout parent_layout = findViewById(R.id.main_layout);

        // 과제 3
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Get the current background color
                ColorDrawable buttonColor = (ColorDrawable) button.getBackground();
                int currentColor = buttonColor.getColor();

                if (currentColor == ContextCompat.getColor(getApplicationContext(), R.color.main)) {
                    // 이미 배경 색상이 main인 경우 grey로 변경
                    button.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.grey));
                    button.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.black));
                    textView.setText(R.string.main_textVIew_1);
                } else {
                    // main이 아닌 경우 배경 색상을 main으로 변경
                    button.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.main));
                    button.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.white));
                    textView.setText(R.string.main_textView_0);
                }
            }
        });

        // 과제 3
        parent_layout.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {

                button.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.grey));
                button.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.black));
                textView.setText(R.string.main_default_textView);
                return false;
            }
        });

    }
}