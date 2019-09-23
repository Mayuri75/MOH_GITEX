package mohu.smartID.gitex.interfaces;

import mohu.smartID.gitex.models.BaseData;

public interface RequestCallback {

    public void onSuccess(BaseData baseData);

    public void onFailure(BaseData baseData);
}
