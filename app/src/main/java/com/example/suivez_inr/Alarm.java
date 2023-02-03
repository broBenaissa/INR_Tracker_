package com.example.suivez_inr;


import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

public class Alarm extends Service {
    ma_carte_AVK alarm = new ma_carte_AVK();
    public void onCreate()
    {
        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId)
    {
        //alarm.setA(this);
        return START_STICKY;
    }

    @Override
    public void onStart(Intent intent, int startId)
    {
       //alarm.setAlarm(this);
    }

    @Override
    public IBinder onBind(Intent intent)
    {
        return null;
    }
}

/*
public class ma_carte_AVK extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        NotificationManager notificationManager = (NotificationManager)context.getSystemService(Context.NOTIFICATION_SERVICE);

        Intent notificationIntent = new Intent(context, MainActivity.class);
        notificationIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

        PendingIntent pendingIntent = PendingIntent.getActivity(context, 0, notificationIntent, PendingIntent.FLAG_UPDATE_CURRENT);

        NotificationCompat.Builder mNotifyBuilder = new NotificationCompat.Builder(context)
                .setContentTitle("Reminder")
                .setContentText("You need to eat")
                .setWhen(System.currentTimeMillis())
                .setContentIntent(pendingIntent);

        notificationManager.notify(1, mNotifyBuilder.build());
    }

    public void check_products(int hour, int minute){
        Calendar calendar = Calendar.getInstance();

        Intent intent = new Intent(ma_carte_AVK.this, home.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(MainActivity.this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);
        AlarmManager am = (AlarmManager) ma_carte_AVK.this.getSystemService(ma_carte_AVK.this.ALARM_SERVICE);
        am.setRepeating(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), 1000, pendingIntent);
    }
}*/
