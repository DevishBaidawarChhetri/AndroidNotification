package np.com.devish.notification.service;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class MyService extends Service {
    public Context context = this;
    public Handler handler = null;
    public Runnable runnable = null;

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        Toast.makeText(context, "Service created!", Toast.LENGTH_SHORT).show();
        super.onCreate();
        handler = new Handler();

    }
}
