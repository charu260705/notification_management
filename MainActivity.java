package com.example.exno5;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
public class MainActivity extends AppCompatActivity {
Button notifybtn;
@RequiresApi(api = Build.VERSION_CODES.O)
@Override
protected void onCreate(Bundle savedInstanceState) {
super.onCreate(savedInstanceState);
setContentView(R.layout.activity_main);
notifybtn = findViewById(R.id.button);
if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.O_MR1)
{
NotificationChannel channel=new NotificationChannel("my notification","my
notification", NotificationManager.IMPORTANCE_DEFAULT);
NotificationManager manager = getSystemService(NotificationManager.class);
manager.createNotificationChannel(channel);
}
notifybtn.setOnClickListener(new View.OnClickListener() {
@Override
public void onClick(View view) {
NotificationCompat.Builder builder = new
NotificationCompat.Builder(MainActivity.this, "my notification");
builder.setContentTitle("My Notification");
builder.setContentText("Notification is working now");
builder.setSmallIcon(R.drawable.ic_launcher_background);
builder.setAutoCancel(true);
NotificationManagerCompat managerCompat =
NotificationManagerCompat.from(MainActivity.this);
managerCompat.notify(1, builder.build());
}
});
}
}
