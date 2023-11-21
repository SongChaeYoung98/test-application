package com.example.testapplication;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class user_profile extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_profile);

        TextView name_textView = findViewById(R.id.profile_name_textView);
        TextView number_textView = findViewById(R.id.profile_number_textView);


        Intent intent = getIntent();
        String userName = intent.getStringExtra("userName");
        String userNumber = intent.getStringExtra("userNumber");

        Log.d("test", "userName : " + userName);
        Log.d("test", "userNumber : " + userNumber);

        name_textView.setText(userName);

        // number_textview : change userNumber Format (010-0000-0000) & setText
        if (userNumber.length() == 11) {
            String formattedNumber = userNumber.substring(0, 3) + "-" + userNumber.substring(3, 7) + "-" + userNumber.substring(7);
            number_textView.setText(formattedNumber);
        }


    }
}
