package com.example.user.notification;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity implements View.OnClickListener {

    private Button sendNotice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sendNotice = (Button) findViewById(R.id.send_notice);
        sendNotice.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.send_notice:
                NotificationManager manager = (NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);
                Notification.Builder builder = new Notification.Builder(MainActivity.this);
                builder.setSmallIcon(R.drawable.ic_launcher);
                builder.setContentTitle("This is ticker text");
                builder.setContentText("Content text");
                builder.setWhen(System.currentTimeMillis());
                builder.setDefaults(Notification.DEFAULT_ALL);
                builder.setAutoCancel(true);
                Notification notification = builder.build();
                manager.notify(1,notification);
                break;
            default:
                break;
        }
    }
}
