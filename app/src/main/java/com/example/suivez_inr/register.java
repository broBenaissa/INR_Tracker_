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

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GetTokenResult;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


import java.util.ArrayList;
import java.util.List;

public class register extends AppCompatActivity {

    private EditText userID;
    private EditText pass;
    private EditText name;
    private TextView register;
    private TextView Signin;
    private FirebaseAuth mAuth;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);


        mAuth=FirebaseAuth.getInstance();

        registration();

        Spinner spinner = (Spinner) findViewById(R.id.spinner);

        //spinner.setOnItemSelectedListener(d);
        List<String> categories = new ArrayList<String>();
        categories.add("doctor");
        categories.add("patient");
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, categories);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(dataAdapter);






    }

     private void registration(){
        userID = findViewById(R.id.userID);
        name=findViewById(R.id.name);
        pass=findViewById(R.id.password);
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
                String password = pass.getText().toString().trim();
                if(TextUtils.isEmpty(Token)){
                    Toast.makeText(getApplicationContext(),"please get your Token from Doctor",Toast.LENGTH_SHORT).show();
                }
                if(TextUtils.isEmpty(password)){
                    Toast.makeText(getApplicationContext(),"please enter password",Toast.LENGTH_SHORT).show();

                }
                if(password.length()<6)
                {
                    Toast.makeText(getApplicationContext(),"please enter a stong password",Toast.LENGTH_SHORT).show();

                }

                mAuth.createUserWithEmailAndPassword(Token,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {

                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){


                            userID=findViewById(R.id.userID);
                            String Token=userID.getText().toString().trim();
                            FirebaseUser mUser=mAuth.getCurrentUser();
                            if(mAuth!=null) {
                                String uid = mUser.getUid();
                                DatabaseReference myRootRef = FirebaseDatabase.getInstance().getReference().child("UserInfo").child(uid);
                                DatabaseReference userNameRef =  myRootRef.child("Token");
                                userNameRef.setValue(Token);
                                Toast.makeText(getApplicationContext(),"valid ..",Toast.LENGTH_SHORT).show();


                            }
                        }
                        else {

                            Toast.makeText(getApplicationContext(),"Registration failed..",Toast.LENGTH_SHORT).show();

                        }
                    }

                });
            }
        });
    }

             /*   @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()){

                        muserid=findViewById(R.id.userID);
                        String userid = muserid.getText().toString().trim();
                        FirebaseUser mUser=mAuth.getCurrentUser();
                        if(mAuth!=null) {
                            String uid = mUser.getUid();
                            DatabaseReference myRootRef = FirebaseDatabase.getInstance().getReference().child("UserInfo").child(uid);
                            DatabaseReference userNameRef =  myRootRef.child("Email");
                            userNameRef.setValue(uid);
                            Toast.makeText(getApplicationContext(),"regestered succesfull!!",Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(getApplicationContext(),login.class));
                            finish();
                        }
                    }
                }

*/
    /*public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        // On selecting a spinner item
        String item = parent.getItemAtPosition(position).toString();

        // Showing selected spinner item
        Toast.makeText(parent.getContext(), "Selected: " + item, Toast.LENGTH_LONG).show();
    }
    public void onNothingSelected(AdapterView<?> arg0) {
        // TODO Auto-generated method stub
    }*/


/*mUser.getIdToken(true)
    .addOnCompleteListener(new OnCompleteListener<GetTokenResult>() {
        public void onComplete(@NonNull Task<GetTokenResult> task) {
            if (task.isSuccessful()) {
                String idToken = task.getResult().getToken();
                // Send token to your backend via HTTPS
                // ...
            } else {
                // Handle error -> task.getException();
            }
        }
    });*/
}