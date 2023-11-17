package com.example.testapplication;

import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class edit_text extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.edit_text);

        // 과제 5
        Button close_button = findViewById(R.id.edit_text_close_button);
        LinearLayout parent_layout = findViewById(R.id.edit_text_main_layout);
        EditText name_editText = findViewById(R.id.edit_text_name_editText);

        // 과제 9
        EditText birth_editText = findViewById(R.id.edit_text_birth_editText);
        EditText phone_editText = findViewById(R.id.edit_text_phone_editText);
        EditText email_editText = findViewById(R.id.edit_text_email_editText);
        EditText email_num_editText = findViewById(R.id.edit_text_email_num_editText);

        // 과제 10
        Button visible_button = findViewById(R.id.edit_text_visible_button);

        // 과제 5
        close_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });


        phone_editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                String inputEmail = charSequence.toString();

                Log.d("test", "input : " + inputEmail);     // 과제 9

                // 과제 10
                if (inputEmail.isEmpty()) {
                    visible_button.setVisibility(View.INVISIBLE);
                } else {
                    visible_button.setVisibility(View.VISIBLE);
                }

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        // 과제 10
        visible_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (phone_editText.getText().toString().isEmpty()) {
                    return;
                }

                int currentVisibility = phone_editText.getTransformationMethod() == PasswordTransformationMethod.getInstance() ? View.GONE : View.VISIBLE;

                phone_editText.setTransformationMethod(
                        phone_editText.getTransformationMethod() == PasswordTransformationMethod.getInstance()
                                ? HideReturnsTransformationMethod.getInstance()
                                : PasswordTransformationMethod.getInstance()
                );

                if (currentVisibility == View.VISIBLE) {
                    visible_button.setBackgroundResource(R.drawable.btn_visible);
                } else {
                    visible_button.setBackgroundResource(R.drawable.btn_invisible);
                }

                phone_editText.setSelection(phone_editText.getText().length());
            }
        });


        parent_layout.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {

                name_editText.clearFocus();     // 과제 5
                birth_editText.clearFocus();    // 과제 9
                phone_editText.clearFocus();    // 과제 9
                email_editText.clearFocus();    // 과제 9
                email_num_editText.clearFocus();    // 과제 9

                InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
                return false;
            }
        });
    }
}
