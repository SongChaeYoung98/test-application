package com.example.testapplication;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class nestedscrollview extends AppCompatActivity {

    private ArrayList<String> userNumbers = new ArrayList<>();
    private ArrayList<String> userNames = new ArrayList<>(Arrays.asList(        // test data
            "house", "jellyfish", "wizard", "xylophone", "*개발", "!기획관리", "~솔루션", "#시스템", "@R&D", "apple", "baloon", "cake", "dog", "egg", "flamingo", "grape", "house", "icecream", "kite", "lemon", "nose", "mouse", "pig", "orange", "rabbit", "queen", "zebra", "yo-wassup","violin", "umbrella", "tomato", "sun"
    ));

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nestedscrollview);

        // 과제 12
        RecyclerView recyclerView_0 = findViewById(R.id.nested_recyclerView_0);
        recyclerView_0.setLayoutManager(new LinearLayoutManager(this));
        RecyclerView recyclerView_1 = findViewById(R.id.nested_recyclerView_1);
        recyclerView_1.setLayoutManager(new LinearLayoutManager(this));

        // making user dummy data
        for (int i = 0; i <= userNames.size(); i++) {
            String userNumber = String.format("010%04d%04d", generateRandomNumber(), generateRandomNumber());

            userNumbers.add(userNumber);
        }

        nestedscrollview_adapter adapter_0 = new nestedscrollview_adapter(userNames, userNumbers);
        recyclerView_0.setAdapter(adapter_0);

        nestedscrollview_adapter adapter_1 = new nestedscrollview_adapter(userNames, userNumbers);
        recyclerView_1.setAdapter(adapter_1);

    }

    // generating test phone number data (dummy data)
    private int generateRandomNumber() {
        Random random = new Random();
        return random.nextInt(10000);
    }
}
