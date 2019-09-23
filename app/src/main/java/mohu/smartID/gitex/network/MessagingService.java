package mohu.smartID.gitex.network;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.TaskStackBuilder;
import android.support.v4.content.ContextCompat;
import android.util.Log;

import com.cherrywork.mohaj.R;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

import java.util.Map;

public class MessagingService extends FirebaseMessagingService {

    public MessagingService() {
    }

    @Override
    public void onMessageReceived(RemoteMessage message) {

        Log.d("@@@@@@@@@",""+message.getData().size());

        for (Map.Entry<String, String> entry : message.getData().entrySet())
            Log.d("$$$$$$$$$$$$$","Key = " + entry.getKey() +
                    ", Value = " + entry.getValue());

        Resources resources = getBaseContext().getResources();
       // int largeArtResourceId = R.drawable.ic_location_city_black_24dp;

        Bitmap largeIcon = BitmapFactory.decodeResource(
                resources,
                1);

        String notificationTitle = getBaseContext().getString(R.string.app_name);

        String notificationText = "";
        if (message.getNotification() != null &&
                message.getNotification().getBody() != null) {
            notificationText = message.getNotification().getBody();
        } else {

            Map data = message.getData();
            if (data.containsKey("body")) {
                notificationText = (String) data.get("body");
            }
        }

       // int smallArtResourceId = R.drawable.ic_location_city_black_24dp;

        //Intent detailIntentForNotification = new Intent(getBaseContext(), DashboardActivity.class);


        TaskStackBuilder taskStackBuilder = TaskStackBuilder.create(getBaseContext());
       // taskStackBuilder.addNextIntentWithParentStack(detailIntentForNotification);
        PendingIntent resultPendingIntent = taskStackBuilder
                .getPendingIntent(0, PendingIntent.FLAG_UPDATE_CURRENT);

        String CHANNEL_ID = "my_channel_01";
        CharSequence name = "Transactional";
        int importance = NotificationManager.IMPORTANCE_HIGH;

        NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(getBaseContext())
                .setColor(ContextCompat.getColor(getBaseContext(), R.color.colorPrimary))
              //  .setSmallIcon(smallArtResourceId)
                .setLargeIcon(largeIcon)
                .setContentTitle(notificationTitle)
                .setContentText(notificationText)
                .setAutoCancel(true)
                .setPriority(NotificationCompat.PRIORITY_MAX)
                .setContentIntent(resultPendingIntent)
                .setChannelId(CHANNEL_ID)
                .setDefaults(NotificationCompat.DEFAULT_ALL);


        NotificationManager notificationManager = (NotificationManager)
                getBaseContext().getSystemService(Context.NOTIFICATION_SERVICE);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel notificationChannel = new NotificationChannel(CHANNEL_ID, name, importance);
            notificationManager.createNotificationChannel(notificationChannel);
        }


        if (notificationManager != null) {
            notificationManager.notify(0, notificationBuilder.build());
        }



    }
}
