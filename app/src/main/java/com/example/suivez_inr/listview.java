package com.example.suivez_inr;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class listview extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listview);

        ListView listViewJava =(ListView) findViewById(R.id.list);
        String[] tabl= {"Dr Youssef EROUCHDI","Dr Youssef EROUCHDI","Dr Youssef EROUCHDI","Dr Youssef EROUCHDI","Dr Youssef EROUCHDI","Dr Youssef EROUCHDI","Dr Youssef EROUCHDI", "Dr Youssef EROUCHDI" ,"Dr Youssef EROUCHDI","Dr Youssef EROUCHDI", "Dr Youssef EROUCHDI"};
        int xmlFill=androidx.appcompat.R.layout.support_simple_spinner_dropdown_item;
        ArrayAdapter myAdaoter =new ArrayAdapter(listview.this,xmlFill,tabl);
        listViewJava.setAdapter(myAdaoter);
    }
}