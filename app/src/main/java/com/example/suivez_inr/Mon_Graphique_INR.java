package com.example.suivez_inr;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import java.util.ArrayList;


public class Mon_Graphique_INR extends AppCompatActivity  {

    private BarChart barChart;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mon_graphique_inr);

       barChart = findViewById(R.id.barChart);

       ArrayList<BarEntry> arrayList = new ArrayList<>();arrayList.add(new BarEntry(2,3));
        arrayList.add(new BarEntry(3,3));
        arrayList.add(new BarEntry(6,3));
        arrayList.add(new BarEntry(7,5));
        arrayList.add(new BarEntry(10,4));
        arrayList.add(new BarEntry(2,4));
        arrayList.add(new BarEntry(14,7));
        arrayList.add(new BarEntry(12,5));
        arrayList.add(new BarEntry(13,4));
        arrayList.add(new BarEntry(15,5));

        BarDataSet  barDataSet = new BarDataSet(arrayList ,"arrayList");




        BarData barData = new BarData(barDataSet);
        barChart.setData(barData);
        barChart.setData(barData);
        barChart.getDescription().setText("BarEntry Graphe");
        barChart.animateY(200);

    }
}

