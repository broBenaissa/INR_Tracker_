package com.example.suivez_inr;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Calendar;

public class Mes_Information extends AppCompatActivity {

    private EditText name, mob, age, weight, height, sex;
    PendingIntent pendingintent2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mes_information);


        Intent myIntent1 = new Intent(getApplicationContext(),ma_carte_AVK.class);
        pendingintent2 = PendingIntent.getService(Mes_Information.this, 1,myIntent1, 1);
        AlarmManager alarmManager1 = (AlarmManager) getSystemService(ALARM_SERVICE);
        Calendar calendar1Notify = Calendar.getInstance();

        calendar1Notify.setTimeInMillis(System.currentTimeMillis());
        calendar1Notify.set(Calendar.HOUR_OF_DAY, 8);
        calendar1Notify.set(Calendar.MINUTE, 00);

        alarmManager1.set(AlarmManager.RTC_WAKEUP,calendar1Notify.getTimeInMillis(), pendingintent2);
        long time24h = 24*60*60*1000;
        alarmManager1.setInexactRepeating(AlarmManager.RTC_WAKEUP, calendar1Notify.getTimeInMillis(),time24h,pendingintent2);



        /*name = findViewById(R.id.editText);
        mob = findViewById(R.id.editText2);
        age = findViewById(R.id.editText3);
        weight = findViewById(R.id.editText4);
        height = findViewById(R.id.editText5);
        sex = findViewById(R.id.editText6);*/


    }
}