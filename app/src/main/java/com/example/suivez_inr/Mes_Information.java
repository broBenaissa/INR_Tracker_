package com.example.suivez_inr;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Mes_Information extends AppCompatActivity {

    private EditText name, mob, age, weight, height, sex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mes_information);

        name = findViewById(R.id.editText);
        mob = findViewById(R.id.editText2);
        age = findViewById(R.id.editText3);
        weight = findViewById(R.id.editText4);
        height = findViewById(R.id.editText5);
        sex = findViewById(R.id.editText6);


    }
}