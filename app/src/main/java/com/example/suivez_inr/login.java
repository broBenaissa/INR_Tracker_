package com.example.suivez_inr;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import androidx.appcompat.app.AlertDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class login extends AppCompatActivity {

    FirebaseDatabase firebaseDatabase;
    DatabaseReference reference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        EditText token = findViewById(R.id.userID);
        EditText pass = findViewById(R.id.password);
        TextView createAccount =findViewById(R.id.createAcount);
        TextView login = findViewById(R.id.loginid);
        TextView btn =findViewById(R.id.brefHome);


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
                String userID =((TextView) findViewById(R.id.userID)).getText().toString();
                String Password=((TextView) findViewById(R.id.password)).getText().toString();
                long  passCheck = Long.parseLong(pass.getText().toString());
                firebaseDatabase = FirebaseDatabase.getInstance();
                reference =firebaseDatabase.getReference("User");
                Query query = reference.orderByChild("Token").equalTo(userID);
                query.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {

                        if (snapshot.exists()) {
                            Long pass = snapshot.child(userID).child("pass").getValue(Long.class);
                            if (pass.equals(passCheck)) {
                                Intent intent = new Intent(getApplicationContext(), home.class);
                                intent.putExtra("Token", userID);
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

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),home.class));
            }
        });
    }
}