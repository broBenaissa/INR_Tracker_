package com.example.suivez_inr;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import androidx.appcompat.app.AlertDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.suivez_inr.models.user;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class login extends AppCompatActivity {

    EditText token,pass;
    TextView createAccount,login,homBtn,doctorBtn,oterBtn;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference reference;
    FirebaseAuth auth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        token = findViewById(R.id.username);
        pass = findViewById(R.id.password);
        createAccount = findViewById(R.id.createAcount);
        login = findViewById(R.id.loginid);
        homBtn = findViewById(R.id.brefHome);
        doctorBtn = findViewById(R.id.brefdoctor);
        // oterBtn=findViewById(R.id.other);
        user myuser = new user();

        Spinner spinner = (Spinner) findViewById(R.id.spinner);
        //spinner.setOnItemSelectedListener(d);
        List<String> categories = new ArrayList<String>();
        categories.add("doctor");
        categories.add("patient");
        categories.add("other");
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, categories);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(dataAdapter);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String strToken = ((TextView) findViewById(R.id.username)).getText().toString();
                String passCheck = ((TextView) findViewById(R.id.password)).getText().toString();
                firebaseDatabase = FirebaseDatabase.getInstance();
                reference = firebaseDatabase.getReference("User");
                Query query = reference.orderByChild("Token").equalTo(strToken);

                // signin existing user


                query.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {

                        if (snapshot.exists()) {
                            String strPass = snapshot.child(strToken).child("pass").getValue(String.class);
                            if (strPass.equals(passCheck)) {
                                Intent intent = new Intent(getApplicationContext(), home.class);
                                intent.putExtra("Token", strToken);
                                startActivity(intent);
                                Toast.makeText(login.this, "login succesfull!!", Toast.LENGTH_SHORT).show();
                            } else {
                                AlertDialog.Builder builder = new AlertDialog.Builder(login.this);
                                builder.setCancelable(true);
                                builder.setTitle("Wrong Credential");
                                builder.setMessage("Wrong Credential");
                                builder.show();
                            }

                        } else {
                            Toast.makeText(login.this, "No data exists ", Toast.LENGTH_SHORT).show();
                        }
                    }


                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });

            }
        });


        createAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), register.class));
            }
        });

//a suprimer

        homBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), home.class));
            }
        });
        doctorBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), DoctorHome.class));
            }
        });
    }
}