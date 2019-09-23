package mohu.smartID.gitex.base;

import android.content.DialogInterface;
import android.support.annotation.StringRes;

public interface BaseContract {

    void showLoading(String message, DialogInterface.OnCancelListener listener);

    void showLoading(String message);

    void showLoadingDefault();

    void showLoading(String message, boolean isCancelable);

    void hideLoading();

    void onError(@StringRes int resId);

    void onError(String error);

    void showMessage(String message);

    void showMessage(@StringRes int resId);

    boolean isNetworkConnected();

    void showAlert(String message, DialogInterface.OnClickListener okListener);
}
