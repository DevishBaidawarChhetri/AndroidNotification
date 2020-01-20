package np.com.devish.notification;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.Notification;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private NotificationManagerCompat notificationManagerCompat;
    private Button btnFirstNotification, btnSecondNotification;
    int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        notificationManagerCompat = NotificationManagerCompat.from(this);
        CreateChannel channel = new CreateChannel(this);
        channel.createChannel();

        btnFirstNotification = findViewById(R.id.btnFirstNotification);
        btnSecondNotification = findViewById(R.id.btnSecondNotification);

        btnFirstNotification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DisplayFirstNotification();
            }
        });

        btnSecondNotification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DisplaySecondNotification();
            }
        });

    }
    private void DisplayFirstNotification(){
        Notification notification = new NotificationCompat.Builder(this, CreateChannel.CHANNEL_1)
                .setSmallIcon(R.drawable.ic_directions_bus_black_24dp)
                .setContentTitle("App's name here")
                .setContentText("Your ride is here")
                .setCategory(NotificationCompat.CATEGORY_MESSAGE)
                .build();
        notificationManagerCompat.notify(count ++ , notification);
    }
    private void DisplaySecondNotification(){
        Notification notification = new NotificationCompat.Builder(this, CreateChannel.CHANNEL_2)
                .setSmallIcon(R.drawable.ic_headset_mic_black_24dp)
                .setContentTitle("App's name here")
                .setContentText("Your recording is ready")
                .setCategory(NotificationCompat.CATEGORY_MESSAGE)
                .build();
        notificationManagerCompat.notify(count ++, notification);
    }
}
