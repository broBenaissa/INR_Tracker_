package com.example.suivez_inr;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.suivez_inr.models.Doctor;
import com.example.suivez_inr.models.INR;
import com.github.mikephil.charting.charts.LineChart;

import java.sql.Date;
import java.time.LocalDateTime;
import java.util.ArrayList;


public class Mon_Graphique_INR extends AppCompatActivity  {

    private LineChart lineChart;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mon_graphique_inr);

       lineChart = findViewById(R.id.lineChart);
        ArrayList<INR> list=new ArrayList<>();
        list.add(new INR(1.3, new Date(2023,02,01)));
        list.add(new INR(2.3, new Date(2023,02,02)));
        list.add(new INR(3, new Date(2023,02,03)));
        list.add(new INR(1.8, new Date(2023,02,04)));
        list.add(new INR(0.5, new Date(2023,02,05)));



        /*GraphView graph = (GraphView) findViewById(R.id.graph);
        LineGraphSeries<DataPoint> series = new LineGraphSeries<DataPoint>(new DataPoint[] {
                new DataPoint(0, 1),
                new DataPoint(1, 5),
                new DataPoint(2, 3),
                new DataPoint(3, 2),
                new DataPoint(4, 6)
        });
        graph.addSeries(series);*/
    }
}