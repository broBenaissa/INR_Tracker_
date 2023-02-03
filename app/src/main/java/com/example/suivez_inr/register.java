package com.example.suivez_inr;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.suivez_inr.models.user;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GetTokenResult;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


import java.util.ArrayList;
import java.util.List;

public class register extends AppCompatActivity {

    private EditText userID;
    private EditText pass;
    private EditText pass2;
    private EditText name;
    private user myUser;
    private TextView register;
    private TextView Signin;
    private FirebaseAuth mAuth;
    private DatabaseReference myRef;
    private FirebaseDatabase database;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);


        Spinner spinner = (Spinner) findViewById(R.id.spinner);
        //spinner.setOnItemSelectedListener(d);
        List<String> categories = new ArrayList<String>();
        categories.add("doctor");
        categories.add("patient");
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, categories);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(dataAdapter);

        userID = findViewById(R.id.userID);
        name=findViewById(R.id.name);
        pass=findViewById(R.id.password);
        pass2=findViewById(R.id.password2);
        register= findViewById(R.id.registerMe);
        Signin = findViewById(R.id.have);

        Signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(getApplicationContext(),login.class);
                startActivity(intent);
                finish();
            }
        });

        register.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                String Token=userID.getText().toString().trim();
                String nom=name.getText().toString();
                String password2=pass2.getText().toString();
                String password = pass.getText().toString();
                database = FirebaseDatabase.getInstance();
                myRef = database.getReference("User");
                if(TextUtils.isEmpty(Token)){
                    Toast.makeText(getApplicationContext(),"please get your Token from Doctor",Toast.LENGTH_SHORT).show();
                }
                else if(TextUtils.isEmpty(password)){
                    Toast.makeText(getApplicationContext(),"please enter password",Toast.LENGTH_SHORT).show();

                }
                else if(password.length()<6)
                {
                    Toast.makeText(getApplicationContext(),"please enter a stong password",Toast.LENGTH_SHORT).show();
                }
                else if (!password.equals(password2)) {
                    Toast.makeText(getApplicationContext(),"password not muched",Toast.LENGTH_SHORT).show();
                }
                else {
                myRef.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        if (checkUser(snapshot,Token)){
                            myUser = new user(Token,nom,password);
                            myRef.child(Token).setValue(myUser);
                            userID.setText("");
                            name.setText("");
                            pass.setText("");
                            pass2.setText("");
                            Toast.makeText(register.this,"Data inserted",Toast.LENGTH_SHORT).show();
                            Intent i = new Intent(register.this,login.class);
                            startActivity(i);
                        }else {
                            Toast.makeText(register.this,"User Name Already Exists",Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });}




                    }

                });
    }


private boolean checkUser(DataSnapshot snapshot,String user) {
        String user1;
        for (DataSnapshot ds: snapshot.getChildren()){
        user1 =ds.child("Token").getValue(String.class);
        if (user.equals(user1)){
        return false;
        }
        }
        return true;
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