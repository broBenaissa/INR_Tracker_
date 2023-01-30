package com.example.suivez_inr;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        TextView createAccount =findViewById(R.id.createAcount);
        TextView login = findViewById(R.id.loginid);
        TextView btn =findViewById(R.id.brefHome);
        //myDB db = new myDB(getApplicationContext(),"login2",null,1);//not here


        createAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),register.class));
                finish();
            }
        });


        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

               DataBase db = new DataBase(getApplicationContext(),"suivez_inr",null,1);

                String userID =((TextView) findViewById(R.id.userID)).getText().toString();
                String Password=((TextView) findViewById(R.id.password)).getText().toString();
                if (userID.isEmpty()||Password.isEmpty()){
                    Toast.makeText(getApplicationContext(),"one fild is empty.",Toast.LENGTH_SHORT).show();
                }
                else if (db.loginFonction(userID,Password)==1){
                    Toast.makeText(getApplicationContext(),"succesfull.",Toast.LENGTH_SHORT).show();
                    //secondly
                    SharedPreferences sharedpreferences = getSharedPreferences("shared_prefs", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedpreferences.edit();
                    editor.putString("userID", userID);
                    //save data
                    editor.apply();
                    startActivity(new Intent(login.this,home.class));
                    finish();

                }
                else {
                    Toast.makeText(getApplicationContext(),"username or password is wrong.",Toast.LENGTH_SHORT).show();

                }

            }
        });

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),home.class));
            }
        });
    }
}