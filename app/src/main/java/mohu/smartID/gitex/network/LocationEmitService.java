package mohu.smartID.gitex.network;

import android.Manifest;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v4.app.NotificationCompat;
import android.support.v4.content.ContextCompat;
import android.util.Log;

import com.cherrywork.mohaj.R;

import mohu.smartID.gitex.models.LocationModel;
import mohu.smartID.gitex.utils.LocalSharedStorage;
import retrofit2.Call;
import retrofit2.Callback;


public class LocationEmitService extends Service implements LocationListener {

    Location mLastLocation;
    double latitude;
    double longitude;

    LocalSharedStorage sharedStorage;
    String userName;

    Bitmap bitmap;

    private static final long MIN_DISTANCE_CHANGE_FOR_UPDATES = 10;

    private static final long MIN_TIME_BW_UPDATES = 1000 * 60;

    protected LocationManager locationManager;



    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onLocationChanged(Location location) {
        mLastLocation = location;

        LocationModel locationModel = new LocationModel();
        locationModel.setLatitude(""+mLastLocation.getLatitude());
        locationModel.setLongitude(""+mLastLocation.getLongitude());
        locationModel.setAltitude(""+mLastLocation.getAltitude());
        locationModel.setHajjNumber("mayuri");

        NetworkServiceBuilder.buildLocate()
                .postLocation(locationModel)
                .enqueue(new Callback<Object>() {
                    @Override
                    public void onResponse(Call<Object> call, retrofit2.Response<Object> response) {

                      //Log.d("***********SUCCEESSS",""+response.body().toString());
                    }

                    @Override
                    public void onFailure(Call<Object> call, Throwable t) {
                      //  Log.d("***********ERRORRR","");
                    }
                });

    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {

    }

    @Override
    public void onProviderEnabled(String provider) {

    }

    @Override
    public void onProviderDisabled(String provider) {

    }

    @Override
    public void onCreate() {
        super.onCreate();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O)
            startMyOwnForeground();
        else
            startForeground(1, new Notification());


        sharedStorage=new LocalSharedStorage(this);
        userName = sharedStorage.getUserID();
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        getLocation();
        return START_STICKY;
    }

    private void getLocation() {
        try {
            locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);
            if (locationManager != null) {
                boolean isGpsEnabled = locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER);
                boolean isNetworkEnabled = locationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER);

                if (!isGpsEnabled && !isNetworkEnabled) {
                   // Toast.makeText(this, "Can't get the location", Toast.LENGTH_SHORT).show();
                } else {
                    if (isNetworkEnabled && ContextCompat.checkSelfPermission(this,
                            Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
                        locationManager.requestLocationUpdates(
                                LocationManager.NETWORK_PROVIDER,
                                MIN_TIME_BW_UPDATES,
                                MIN_DISTANCE_CHANGE_FOR_UPDATES,
                                this
                        );
                        Log.d("LOCATION", "From Network");
                        if (locationManager != null) {
                            mLastLocation = locationManager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);
                            if (mLastLocation != null) {
                                latitude = mLastLocation.getLatitude();
                                longitude = mLastLocation.getLongitude();
                                Log.i("LOCATION", ""+latitude);
                            }
                        }
                    }
                    if (isGpsEnabled && ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
                        locationManager.requestLocationUpdates(
                                LocationManager.GPS_PROVIDER,
                                MIN_TIME_BW_UPDATES,
                                MIN_DISTANCE_CHANGE_FOR_UPDATES,
                                this
                        );
                        Log.d("LOCATION", "From GPS");
                        if (locationManager != null) {
                            mLastLocation = locationManager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);
                            if (mLastLocation != null) {
                                latitude = mLastLocation.getLatitude();
                                longitude = mLastLocation.getLongitude();
                                Log.i("latitude", ""+latitude);
                            }
                        }
                    } else {
                        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                           //TODO: Handle the location request permission
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public double getLatitude() {
        if (mLastLocation != null) {
            latitude = mLastLocation.getLatitude();
        }
        return latitude;
    }

    public double getLongitude() {
        if (mLastLocation != null) {
            longitude = mLastLocation.getLongitude();
        }
        return longitude;
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    private void startMyOwnForeground(){
        String NOTIFICATION_CHANNEL_ID = "com.example.simpleapp";
        String channelName = "My Background Service";
        NotificationChannel chan = new NotificationChannel(NOTIFICATION_CHANNEL_ID, channelName, NotificationManager.IMPORTANCE_NONE);
        chan.setLightColor(Color.BLUE);
        chan.setLockscreenVisibility(Notification.VISIBILITY_PRIVATE);
        NotificationManager manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        assert manager != null;
        manager.createNotificationChannel(chan);

        NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(this, NOTIFICATION_CHANNEL_ID);
        Notification notification = notificationBuilder.setOngoing(true)
                .setSmallIcon(R.drawable.ic_launcher_background)
                .setContentTitle("App is running in background")
                .setPriority(NotificationManager.IMPORTANCE_MIN)
                .setCategory(Notification.CATEGORY_SERVICE)
                .build();
        startForeground(2, notification);
    }
}