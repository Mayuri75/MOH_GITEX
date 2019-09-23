package mohu.smartID.gitex.network;

import android.util.Log;

import mohu.smartID.gitex.utils.LocalSharedStorage;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;

public class FirebaseInstanceIDService extends FirebaseInstanceIdService {

    private static String TAG = FirebaseInstanceIDService.class.getName();

    LocalSharedStorage localSharedStorage;

    public FirebaseInstanceIDService() {
        localSharedStorage = new LocalSharedStorage(this);
    }

    @Override
    public void onTokenRefresh() {
        String tokenId = FirebaseInstanceId.getInstance().getToken();
        Log.d(TAG, "onTokenRefresh: " + tokenId);
        localSharedStorage=new LocalSharedStorage(this);
        if(localSharedStorage != null)
            localSharedStorage.setSaveToken(tokenId);


    }
}
