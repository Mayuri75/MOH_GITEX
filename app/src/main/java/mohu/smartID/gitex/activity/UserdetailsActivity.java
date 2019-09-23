package mohu.smartID.gitex.activity;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import mohu.smartID.gitex.Contracts.UserProceedContract;
import com.cherrywork.mohaj.R;
import mohu.smartID.gitex.base.BaseActivity;
import com.cherrywork.mohaj.databinding.ActivityRegisterBinding;
import mohu.smartID.gitex.models.Validations;
import mohu.smartID.gitex.presenters.UserProceedPresenter;
import mohu.smartID.gitex.utils.Utils;


// mayuri

public class UserdetailsActivity extends BaseActivity implements UserProceedContract {
ActivityRegisterBinding binding;
UserProceedPresenter proceedPresenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_register);
        proceedPresenter=new UserProceedPresenter(this);

    }

    public void onClickRegister(View view) {
        Bundle bundle = new Bundle();
        if (binding.etGuestname.getText().toString().isEmpty()) {
            Toast.makeText(this, "Please Enter full name", Toast.LENGTH_SHORT).show();
        }else if (binding.etCompanyname.getText().toString().isEmpty()) {
            Toast.makeText(this, "Please Enter company  name", Toast.LENGTH_SHORT).show();
        }else if ( !Utils.isValidEmail( binding.etEmailAddress.getText().toString())) {
            Toast.makeText(this, "Please Enter valid email", Toast.LENGTH_SHORT).show();
        }else if (binding.etMobileno.getText().toString().isEmpty()) {
            Toast.makeText(this, "Please Enter mobile number", Toast.LENGTH_SHORT).show();
        } else {
             bundle.putString("fullName",binding.etGuestname.getText().toString());
             bundle.putString("companyName",binding.etCompanyname.getText().toString());
             bundle.putString("mobileNo",binding.etMobileno.getText().toString());
             bundle.putString("emailAddress", binding.etEmailAddress.getText().toString());
             moveToActivity(ProfileActivity.class,bundle);
         }
//proceedPresenter.postUserRegistration(binding.etGuestname.getText().toString(),binding.etCompanyname.getText().toString(),binding.etMobileno.getText().toString(),binding.etEmailAddress.getText().toString());
    }

    @Override
    public void ShowInfo(Validations list) {

    }
}
