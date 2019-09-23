package mohu.smartID.gitex.presenters;

import android.util.Log;

import mohu.smartID.gitex.Contracts.UserProceedContract;
import mohu.smartID.gitex.base.BasePresenter;
import mohu.smartID.gitex.constants.Constants;
import mohu.smartID.gitex.models.BaseData;
import mohu.smartID.gitex.models.Response;
import mohu.smartID.gitex.models.ValidationPost;
import mohu.smartID.gitex.models.Validations;
import mohu.smartID.gitex.network.AppNetworkHelper;
import com.google.gson.Gson;

public class UserProceedPresenter extends BasePresenter {
    UserProceedContract contract;
    AppNetworkHelper helper;
    public UserProceedPresenter(UserProceedContract profileContract){
        contract = profileContract;
        helper = new AppNetworkHelper(this);

    }


    public void postUserRegistration(String fullName,String companyName,String phoneNo, String emailId)
    {

        contract.showLoadingDefault();
        BaseData baseData = new BaseData();
        baseData.setApi(Constants.API_RESGISTRAION);
        ValidationPost _obj= new ValidationPost();
        _obj.setMobileNumber(phoneNo);
        baseData.setObject(_obj);
        Gson gson = new Gson();
        String jsonParamsmDeviceReq = gson.toJson(_obj);
        Log.e("Tag","PostRegistrationObjext"+jsonParamsmDeviceReq);
        Log.e("Tag","PostRegistrationObjt"+_obj.toString());

        helper.getData(baseData);
    }
    public void getUserData(String mail, String userId, String type) {
        contract.showLoadingDefault();
        BaseData baseData = new BaseData();
        baseData.setObject(mail);
        baseData.setSourceId(userId);
        baseData.setType(type);
        baseData.setApi(Constants.API_GET_USER_VALIDATE);
        helper.getData(baseData);
    }


    @Override
    public void onSuccess(BaseData baseData) {
        super.onSuccess(baseData);
        contract.hideLoading();
        if (baseData.getApi().equals(Constants.API_GET_USER_VALIDATE)) {
            Validations locateUserRes= (Validations)((Response)baseData.getObject()).getOutput();
            contract.ShowInfo(locateUserRes);
            Log.e("Tag","PostSuccess");

        }
        if (baseData.getApi().equals(Constants.API_RESGISTRAION)) {
            // contract.showMessage("Execution Successful!");
            //contract.moveActivity();
            Log.e("Tag","PostSuccess");


        }

    }

    @Override
    public void onFailure(BaseData baseData) {
        super.onFailure(baseData);
        contract.hideLoading();



    }



}
