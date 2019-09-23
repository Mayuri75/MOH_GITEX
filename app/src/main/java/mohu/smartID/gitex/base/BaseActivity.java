package mohu.smartID.gitex.base;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;

import com.cherrywork.mohaj.R;

import mohu.smartID.gitex.constants.Constants;

import mohu.smartID.gitex.utils.NetworkUtility;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static android.Manifest.permission.ACCESS_FINE_LOCATION;
import static android.Manifest.permission.CALL_PHONE;
import static android.Manifest.permission.CAMERA;
import static android.Manifest.permission.READ_EXTERNAL_STORAGE;
import static android.Manifest.permission.WRITE_EXTERNAL_STORAGE;

public class BaseActivity extends AppCompatActivity implements BaseContract {

    public static final int REQUEST_CAMERA = 100;
    public static final int REQUEST_CALL = 103;
    public static final int REQUEST_EXTERNAL_STORAGE = 101;
    public static final int REQUEST_READ_EXTERNAL_STORAGE = 102;
    public static final int REQUEST_LOCATION = 104;
    private ProgressDialog dialog;
  //  public RoleData roleData;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // getRoleData();

        SharedPreferences prefs = getSharedPreferences(getPackageName(), MODE_PRIVATE);
        String userId = prefs.getString(Constants.USERID, null);
        Constants.userName= userId;
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    @Override
    public void onError(int resId) {
        onError(getString(resId));
    }

    @Override
    public void onError(String error) {
        if (error != null) {
            showSnackBar(error);
        } else {
            //showSnackBar(getString(R.string.some_error));
        }
    }

    @Override
    public void showMessage(String message) {
        if (message != null) {
            //Toast.makeText(getBaseContext(),message,Toast.LENGTH_SHORT).show();
            showSnackBar(message);
        } else {
            //Toast.makeText(getBaseContext(),getString(R.string.some_error),Toast.LENGTH_SHORT).show();
            //showSnackBar(getString(R.string.some_error));
        }
    }

    @Override
    public void showMessage(int resId) {
        showMessage(getString(resId));
    }

    @Override
    public boolean isNetworkConnected() {
        return NetworkUtility.hasNetworkAccess(getApplicationContext());
    }

    private void showSnackBar(String message) {
     /*   Snackbar snackbar = Snackbar.make(findViewById(R.id.rootlayout),
                message, Snackbar.LENGTH_SHORT);
        View sbView = snackbar.getView();
        TextView textView = (TextView) sbView
                .findViewById(android.support.design.R.id.snackbar_text);
        textView.setMaxLines(3);
        textView.setTextColor(ContextCompat.getColor(this, R.color.colorWhite));
        snackbar.show();*/
    }

    public boolean checkCallPermission() {
        return (ContextCompat.checkSelfPermission(getApplicationContext(), CALL_PHONE) == PackageManager.PERMISSION_GRANTED);
    }

    public void requestCallPermission() {
        ActivityCompat.requestPermissions(this, new String[]{CALL_PHONE}, REQUEST_CALL);
    }

    public boolean checkCameraPermission() {
        return (ContextCompat.checkSelfPermission(getApplicationContext(), CAMERA) == PackageManager.PERMISSION_GRANTED);
    }

    public void requestCameraPermission() {
        ActivityCompat.requestPermissions(this, new String[]{CAMERA}, REQUEST_CAMERA);
    }

    public void requestReadStoragePermission() {
        ActivityCompat.requestPermissions(this, new String[]{READ_EXTERNAL_STORAGE}, REQUEST_READ_EXTERNAL_STORAGE);
    }

    public boolean checkLocationPermission() {
        return (ContextCompat.checkSelfPermission(getApplicationContext(), ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED);
    }

    public void requestLocationPermission() {
        ActivityCompat.requestPermissions(this, new String[]{ACCESS_FINE_LOCATION}, REQUEST_LOCATION);
    }

    public boolean checkStoragePermission() {
        return (ContextCompat.checkSelfPermission(getApplicationContext(), WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED);
    }

    public boolean checkReadStoragePermission() {
        return (ContextCompat.checkSelfPermission(getApplicationContext(), READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED);
    }

    public void requestStoragePermission() {
        ActivityCompat.requestPermissions(this, new String[]{WRITE_EXTERNAL_STORAGE}, REQUEST_EXTERNAL_STORAGE);
    }

    protected void showMessageOKCancel(String message, DialogInterface.OnClickListener okListener) {
        new android.support.v7.app.AlertDialog.Builder(this, R.style.AppTheme_Dialog)
                .setMessage(message)
                .setPositiveButton("OK", okListener)
                .setNegativeButton("Cancel", null)
                .create()
                .show();
    }

    protected void showMessageOKCancel(String message, DialogInterface.OnClickListener okListener, DialogInterface.OnClickListener cancelListener) {
        new android.support.v7.app.AlertDialog.Builder(this, R.style.AppTheme_Dialog)
                .setMessage(message)
                .setPositiveButton("OK", okListener)
                .setNegativeButton("Cancel", cancelListener)
                .create()
                .show();
    }

    @Override
    public void showLoading(String message) {
        showLoading(message, true);
    }

    @Override
    public void showLoadingDefault() {
        showLoading("Loading");
    }

    @Override
    public void showLoading(String message, boolean isCancelable) {
        if (dialog == null) {
            dialog = new ProgressDialog(this, R.style.AppTheme_Dialog);
            dialog.setMessage(message);
            dialog.setCanceledOnTouchOutside(false);
            dialog.setCancelable(isCancelable);
        }
        dialog.show();
    }

    @Override
    public void showLoading(String message, DialogInterface.OnCancelListener listener) {
        if (dialog == null) {
            dialog = new ProgressDialog(this, R.style.AppTheme_Dialog);
            dialog.setMessage(message);
            dialog.setCanceledOnTouchOutside(false);
            dialog.setCancelable(false);
            dialog.setOnCancelListener(listener);
        }
        dialog.show();
    }

    @Override
    public void hideLoading() {
        if (dialog != null && dialog.isShowing()) {
            dialog.dismiss();
            dialog = null;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        hideLoading();
    }

    @Override
    public void showAlert(String message, DialogInterface.OnClickListener okListener) {
        new android.support.v7.app.AlertDialog.Builder(this, R.style.AppTheme_Dialog)
                .setMessage(message)
                .setCancelable(false)
                .setPositiveButton("OK", okListener)
                .create()
                .show();
    }

  /*  public void showCustomAdapter(RecyclerView recyclerView, int layout, Class cl) {
        CustomAdapter customAdapter = new CustomAdapter(this, layout, cl);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, OrientationHelper.VERTICAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(customAdapter);

    }
*/


    public void moveToActivity(Class cl, Bundle bundle) {
        Intent intent = new Intent(getBaseContext(), cl);

        if (bundle != null) {
            intent.putExtras(bundle);
        }
        startActivity(intent);


    }

    public void moveToActivityFinish(Class cl, Bundle bundle) {
        Intent intent = new Intent(getBaseContext(), cl);

        if (bundle != null) {
            intent.putExtras(bundle);
        }
        startActivity(intent);
        finish();


    }

  /*  public void getRoleData() {
        roleData = new Gson().fromJson(JSONResponses.RESPONSE_ROLE_DATA, RoleData.class);
        Log.d("*******", "" + roleData.getRoleData().get(0).getRole());
    }*/





    public String showDateFormate(String dateString) throws ParseException {
        String [] d1=dateString.split("T");
        System.out.println("Given date is " + d1[0]);

        DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date = sdf.parse(d1[0]);
        System.out.println("yyyy-MM-dd formatted date : " + new SimpleDateFormat("MM/dd/yyyy").format(date));
        return  new SimpleDateFormat("MM/dd/yyyy").format(date);
    }
    public String showDateFormateTime(String dateString) throws ParseException {
        //String [] d1=dateString.split("T");


        //System.out.println("Given date is " + d1[0]);

        DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = sdf.parse(dateString);
        //System.out.println("yyyy-MM-dd formatted date : " + new SimpleDateFormat("MM/dd/yyyy").format(date));
        return  new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
    }


}
