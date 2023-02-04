package com.example.suivez_inr;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.app.NotificationCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;

import java.util.ArrayList;

public class DoctorHome extends AppCompatActivity {

    private TextView notify;
    private EditText editText;
    BarChart barChart;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_home);

        notify = findViewById(R.id.textView);
        editText = findViewById(R.id.editTxt);

        barChart = findViewById(R.id.barChart);

        ArrayList<BarEntry> arrayList = new ArrayList<>();arrayList.add(new BarEntry(2,3));
        arrayList.add(new BarEntry(3,3));
        arrayList.add(new BarEntry(6,3));
        arrayList.add(new BarEntry(7,5));
        arrayList.add(new BarEntry(1,4));
        arrayList.add(new BarEntry(2,4));
        arrayList.add(new BarEntry(4,7));
        arrayList.add(new BarEntry(9,5));
        arrayList.add(new BarEntry(12,4));
        arrayList.add(new BarEntry(18,5));

        BarDataSet barDataSet = new BarDataSet(arrayList ,"arrayList");




        BarData barData = new BarData(barDataSet);
        barChart.setData(barData);
        barChart.setData(barData);
        barChart.getDescription().setText("BarEntry Graphe");
        barChart.animateY(200);
        notify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String msg =editText.getText().toString();
                NotificationCompat.Builder builder = new NotificationCompat.Builder(DoctorHome.this)
                        .setSmallIcon(R.drawable.logo)
                        .setContentTitle("New Notification")
                        .setContentText(msg)
                        .setAutoCancel(true);
                NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
                notificationManager.notify(0,builder.build());
            }
        });

    }




}



