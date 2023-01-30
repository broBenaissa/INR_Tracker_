package com.example.suivez_inr;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class register extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        // Spinner element
        Spinner spinner = (Spinner) findViewById(R.id.spinner);

        // Spinner click listener
        //spinner.setOnItemSelectedListener(d);

        // Spinner Drop down elements
        List<String> categories = new ArrayList<String>();
        categories.add("Automobile");
        categories.add("Business Services");
        categories.add("Computers");
        categories.add("Education");
        categories.add("Personal");
        categories.add("Travel");

        // Creating adapter for spinner
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, categories);

        // Drop down layout style - list view with radio button
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // attaching data adapter to spinner
        spinner.setAdapter(dataAdapter);





        TextView register=findViewById(R.id.registerMe);
        TextView have =findViewById(R.id.have);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String userID = ((TextView) findViewById(R.id.userID)).getText().toString();
                int userIDnum =Integer.valueOf(userID);
                String name = ((TextView) findViewById(R.id.name)).getText().toString();
                String password = ((TextView) findViewById(R.id.password)).getText().toString();
                String password2 = ((TextView) findViewById(R.id.password2)).getText().toString();
//db
                DataBase dataBase=new DataBase(getApplicationContext(),"suivez_inr",null,1 );

                if (userID.isEmpty()||name.isEmpty()||password.isEmpty()||password2.isEmpty()||!password.equals(password2)){
                    Toast.makeText(getApplicationContext(),"tray again",Toast.LENGTH_SHORT).show();
                }
                else {
                    if (userIDnum<2000||userIDnum>1000){
                   dataBase.registerFonction(userID,name,password);
                    Toast.makeText(getApplicationContext(),"regestered succesfull!!",Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(getApplicationContext(),login.class));
                    finish();}


                }
            }
        });

        have.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(register.this,login.class));
            }
        });

    }


    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        // On selecting a spinner item
        String item = parent.getItemAtPosition(position).toString();

        // Showing selected spinner item
        Toast.makeText(parent.getContext(), "Selected: " + item, Toast.LENGTH_LONG).show();
    }
    public void onNothingSelected(AdapterView<?> arg0) {
        // TODO Auto-generated method stub
    }
}