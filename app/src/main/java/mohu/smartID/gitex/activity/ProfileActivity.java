package mohu.smartID.gitex.activity;

//Created By Mayuri

import android.Manifest;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.databinding.DataBindingUtil;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.location.Location;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.cherrywork.mohaj.R;
import mohu.smartID.gitex.base.BaseActivity;
import mohu.smartID.gitex.constants.Constants;
import com.cherrywork.mohaj.databinding.ActivityProfileBinding;

import mohu.smartID.gitex.network.LocationEmitService;
import mohu.smartID.gitex.utils.LocalSharedStorage;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class ProfileActivity extends BaseActivity implements  OnMapReadyCallback,
        GoogleApiClient.ConnectionCallbacks,
        GoogleApiClient.OnConnectionFailedListener,
        LocationListener {



    GoogleMap mGoogleMap;
    SupportMapFragment mapFrag;
    LocationRequest mLocationRequest;
    GoogleApiClient mGoogleApiClient;
    Location mLastLocation;
    Marker mCurrLocationMarker;
    Double latitude, longtitude;
    String loadPage;
    LocalSharedStorage sharedStorage;
    ActivityProfileBinding binding;
    String fullName,companyName,mobileNo,emailAddress;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_profile);
      //  profilePresenter = new ProfilePresenter(this);
        sharedStorage = new LocalSharedStorage(this);
        Constants.userName = sharedStorage.getUserID();
        startForegroundService();
//getLocation();

        mapFrag = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFrag.getMapAsync(this);
     //   getLocation();
if(getIntent().getExtras()!=null) {
    fullName = getIntent().getExtras().getString("fullName");
    companyName = getIntent().getExtras().getString("companyName");
    mobileNo = getIntent().getExtras().getString("mobileNo");
    emailAddress = getIntent().getExtras().getString("emailAddress");

    if (fullName!=null&&!fullName.isEmpty()){
        binding.tvName.setText(fullName);
        binding.tvName.setVisibility(View.VISIBLE);
    }else {
        binding.tvName.setVisibility(View.GONE);
    }
    if (companyName!=null&&!companyName.isEmpty()){
        binding.tvcompanyname.setText(companyName);
        binding.tvcompanyname.setVisibility(View.VISIBLE);
    }else {
        binding.tvcompanyname.setVisibility(View.GONE);
    }
    if (emailAddress!=null&&!emailAddress.isEmpty()){
        binding.tvemail.setText(emailAddress);
        binding.tvemail.setVisibility(View.VISIBLE);
    }else {
        binding.tvemail.setVisibility(View.GONE);
    }
    if (mobileNo!=null&&!mobileNo.isEmpty()){
        binding.tvPhoneNo.setText(mobileNo);
        binding.tvPhoneNo.setVisibility(View.VISIBLE);
    }else {
        binding.tvPhoneNo.setVisibility(View.GONE);
    }



    if(fullName!=null && fullName.length()>0) {

        binding.tvImageText.setText("" + fullName.charAt(0));
    }

}

    }
/*
    @Override
    public void updateUI() {
        if(selectedOrg!=null) {
            profilePresenter.getLocationByUser(selectedOrg.getTargetHajjNumber());
            if(selectedOrg.getFirstName() != null)
                binding.tvName.setText(selectedOrg.getFirstName());
            if(selectedOrg.getFirstName() != null)
                binding.tvName.setText(" "+selectedOrg.getLastName());
            if(selectedOrg.getPhoneNumber() != null)
                binding.tvPhoneNo.setText(selectedOrg.getPhoneNumber().toString());
        }

    }*/


/*    @Override
    public void getLocation(double lati, double longti) {
        //LatLng latLng = new LatLng(12.972442, 77.580643);
        Log.d("lati", "" + lati);
        latitude = lati;
        longtitude = longti;

        try {
            LatLng latLng = new LatLng(latitude, longtitude);
            mGoogleMap.addMarker(createMarker(latLng, "", null));
            mGoogleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(latitude, longtitude), 12.0f));

        } catch (Exception e) {
            e.printStackTrace();
        }


    }*/

    public void getLocation() {

        latitude = 13.02182;
        longtitude = 77.60571;
        Log.d("lati", "" + latitude);
        try {
            LatLng latLng = new LatLng(latitude, longtitude);
            mGoogleMap.addMarker(createMarker(latLng, "", null));
            mGoogleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(latitude, longtitude), 12.0f));

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void getLocation(double lati, double longti) {
        //LatLng latLng = new LatLng(12.972442, 77.580643);
        Log.d("lati", "" + lati);
        latitude = lati;
        longtitude = longti;

        try {
            LatLng latLng = new LatLng(latitude, longtitude);
            mGoogleMap.addMarker(createMarker(latLng, "you are here", null));
            mGoogleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(latitude, longtitude), 12.0f));

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    @Override
    public void onPause() {
        super.onPause();

        //stop location updates when Activity is no longer active
        if (mGoogleApiClient != null) {
            LocationServices.FusedLocationApi.removeLocationUpdates(mGoogleApiClient, this);
        }
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mGoogleMap = googleMap;
        mGoogleMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);

        //Initialize Google Play Services
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (ContextCompat.checkSelfPermission(this,
                    Manifest.permission.ACCESS_FINE_LOCATION)
                    == PackageManager.PERMISSION_GRANTED) {
                //Location Permission already granted
                buildGoogleApiClient();

            } else {
                //Request Location Permission
                checkLocationPermissionN();
            }
        } else {
            buildGoogleApiClient();
            mGoogleMap.setMyLocationEnabled(true);
        }



    }
    public void startForegroundService() {
        Intent i = new Intent(getBaseContext(), LocationEmitService.class);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            startForegroundService(i);
        } else {
            startService(i);
        }
    }
    protected synchronized void buildGoogleApiClient() {
        mGoogleApiClient = new GoogleApiClient.Builder(this)
                .addConnectionCallbacks(this)
                .addOnConnectionFailedListener(this)
                .addApi(LocationServices.API)
                .build();
        mGoogleApiClient.connect();
    }

    @Override
    public void onConnected(Bundle bundle) {
        mLocationRequest = LocationRequest.create();
        mLocationRequest.setInterval(1000);
        mLocationRequest.setFastestInterval(1000);
        mLocationRequest.setPriority(LocationRequest.PRIORITY_BALANCED_POWER_ACCURACY);
        if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.ACCESS_FINE_LOCATION)
                == PackageManager.PERMISSION_GRANTED) {

        }
        Location location = LocationServices.FusedLocationApi.getLastLocation(mGoogleApiClient);

        if (location == null) {
            LocationServices.FusedLocationApi.requestLocationUpdates(mGoogleApiClient, mLocationRequest, this);

        } else {
            //If everything went fine lets get latitude and longitude
          Double  currentLatitude = location.getLatitude();
            Double currentLongitude = location.getLongitude();
            getLocation(currentLatitude,currentLongitude);

           /* Toast.makeText(this, currentLatitude + " WORKS " + currentLongitude + "", Toast.LENGTH_LONG).show();*/
        }
    }

    @Override
    public void onConnectionSuspended(int i) {
    }

    @Override
    public void onConnectionFailed(ConnectionResult connectionResult) {
    }

    @Override
    public void onLocationChanged(Location location) {
        mLastLocation = location;
        mLastLocation.getLatitude();
        //Log.i("mlastlocation",""+mLastLocation.getLatitude());
        if (mCurrLocationMarker != null) {
            mCurrLocationMarker.remove();
        }
        mGoogleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(location.getLatitude(), location.getLongitude()), 12.0f));
        //Place current location marker

        /*if (bitmap != null) {
            LatLng latLng = new LatLng(location.getLatitude(), location.getLongitude());
            MarkerOptions markerOptions = new MarkerOptions();
            markerOptions.position(latLng);
            markerOptions.title("Current Position");
            markerOptions.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_MAGENTA));

            mCurrLocationMarker = mGoogleMap.addMarker(markerOptions);

            //move map camera
            mGoogleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng, 16.0f));

        }*/
    }

    private MarkerOptions createMarker(LatLng latLng, String title, Bitmap bitmap) {
        LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View v = inflater.inflate(R.layout.layout_map_marker, null);
        TextView txt= (TextView)v.findViewById(R.id.marker_imageView);
        Character ss = fullName.charAt(0);
        txt.setText(""+ss);
        bitmap = createDrawableFromView(v.findViewById(R.id.relative_layout));

        MarkerOptions markerOptions = new MarkerOptions();
        markerOptions.position(latLng);
        markerOptions.title(title);

        markerOptions.icon(BitmapDescriptorFactory.fromBitmap(bitmap));

        return markerOptions;
    }

    public Bitmap createDrawableFromView(View view) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        view.setLayoutParams(new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT));
        view.measure(displayMetrics.widthPixels, displayMetrics.heightPixels);
        view.layout(0, 0, displayMetrics.widthPixels, displayMetrics.heightPixels);
        view.buildDrawingCache();
        Bitmap bitmap = Bitmap.createBitmap(view.getMeasuredWidth(), view.getMeasuredHeight(), Bitmap.Config.ARGB_8888);

        Canvas canvas = new Canvas(bitmap);

        view.draw(canvas);

        return bitmap;
    }

    public static final int MY_PERMISSIONS_REQUEST_LOCATION = 99;

    public void checkLocationPermissionN() {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED) {

            // Should we show an explanation?
            if (ActivityCompat.shouldShowRequestPermissionRationale(this,
                    Manifest.permission.ACCESS_FINE_LOCATION)) {

                // Show an explanation to the user *asynchronously* -- don't block
                // this thread waiting for the user's response! After the user
                // sees the explanation, try again to request the permission.
                new AlertDialog.Builder(this)
                        .setTitle("Location Permission Needed")
                        .setMessage("This app needs the Location permission, please accept to use location functionality")
                        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                //Prompt the user once explanation has been shown
                                ActivityCompat.requestPermissions(ProfileActivity.this,
                                        new String[]{Manifest.permission.ACCESS_FINE_LOCATION},
                                        MY_PERMISSIONS_REQUEST_LOCATION);
                            }
                        })
                        .create()
                        .show();


            } else {
                // No explanation needed, we can request the permission.
                ActivityCompat.requestPermissions(this,
                        new String[]{Manifest.permission.ACCESS_FINE_LOCATION},
                        MY_PERMISSIONS_REQUEST_LOCATION);
            }
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           String permissions[], int[] grantResults) {
        switch (requestCode) {
            case MY_PERMISSIONS_REQUEST_LOCATION: {
                // If request is cancelled, the result arrays are empty.
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                    // permission was granted, yay! Do the
                    // location-related task you need to do.
                    if (ContextCompat.checkSelfPermission(this,
                            Manifest.permission.ACCESS_FINE_LOCATION)
                            == PackageManager.PERMISSION_GRANTED) {

                        if (mGoogleApiClient == null) {
                            buildGoogleApiClient();
                        }
                        mGoogleMap.setMyLocationEnabled(true);
                    }

                } else {

                    // permission denied, boo! Disable the
                    // functionality that depends on this permission.
                    Toast.makeText(this, "permission denied", Toast.LENGTH_LONG).show();
                }
                return;
            }

            // other 'case' lines to check for other
            // permissions this app might request
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        onBackPressed();
        return super.onOptionsItemSelected(item);
    }


    public static Bitmap getResizedBitmap(Bitmap bm, int newHeight, int newWidth) {
        int width = bm.getWidth();
        int height = bm.getHeight();
        float scaleWidth = ((float) newWidth) / width;
        float scaleHeight = ((float) newHeight) / height;
        Matrix matrix = new Matrix();
// RESIZE THE BIT MAP
        matrix.postScale(scaleWidth, scaleHeight);
        // RECREATE THE NEW BITMAP
        Bitmap resizedBitmap = Bitmap.createBitmap(bm, 0, 0, width, height,
                matrix, false);
        return resizedBitmap;
    }


    public void onClickUnfollow(View view) {
       moveToActivity(UserdetailsActivity.class,null);
    }
}
