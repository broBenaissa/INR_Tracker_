package com.example.suivez_inr;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.NotificationManager;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class DoctorHome extends AppCompatActivity {

    private Button button;
    private EditText editText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_home);

     /*   button = findViewById(R.id.button);
        editText = findViewById(R.id.editTxt);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String msg =editText.getText().toString();
                NotificationCompat.Builder builder = new NotificationCompat.Builder(ma_carte_AVK.this)
                        .setSmallIcon(R.drawable.logo)
                        .setContentTitle("New Notification")
                        .setContentText(msg)
                        .setAutoCancel(true);
                NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
                notificationManager.notify(0,builder.build());
            }
        });*/
    }
}