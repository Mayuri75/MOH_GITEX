package mohu.smartID.gitex.models;

import java.io.Serializable;

import okhttp3.MultipartBody;

public class BaseData implements Serializable {
    public Object object;
    public String api;
    public String userId;
    public String scanPilgrims;
    public String senderHajjNo;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String type;

    public String getSuccessMsg() {
        return SuccessMsg;
    }

    public void setSuccessMsg(String successMsg) {
        SuccessMsg = successMsg;
    }

    public String reciverHajjNo;

    public String SuccessMsg;

    public String getNotificationHajj() {
        return notificationHajj;
    }

    public void setNotificationHajj(String notificationHajj) {
        this.notificationHajj = notificationHajj;
    }

    public String getNotificationContract() {
        return notificationContract;
    }

    public void setNotificationContract(String notificationContract) {
        this.notificationContract = notificationContract;
    }

    public String notificationHajj;
    public String notificationContract;




    public String getSenderHajjNo() {
        return senderHajjNo;
    }

    public void setSenderHajjNo(String senderHajjNo) {
        this.senderHajjNo = senderHajjNo;
    }

    public String getReciverHajjNo() {
        return reciverHajjNo;
    }

    public void setReciverHajjNo(String reciverHajjNo) {
        this.reciverHajjNo = reciverHajjNo;
    }

    public String getScanPilgrims() {
        return scanPilgrims;
    }

    public void setScanPilgrims(String scanPilgrims) {
        this.scanPilgrims = scanPilgrims;
    }

    public Integer incidentId;

    public String getSourceId() {
        return sourceId;
    }

    public void setSourceId(String sourceId) {
        this.sourceId = sourceId;
    }

    public String getTargetId() {
        return targetId;
    }

    public void setTargetId(String targetId) {
        this.targetId = targetId;
    }

    public String sourceId;
    public  String targetId;
    MultipartBody.Part body;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Integer getIncidentId() {
        return incidentId;
    }

    public void setIncidentId(Integer incidentId) {
        this.incidentId = incidentId;
    }

    public MultipartBody.Part getBody() {
        return body;
    }

    public void setBody(MultipartBody.Part body) {
        this.body = body;
    }

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }

    public String getApi() {
        return api;
    }

    public void setApi(String api) {
        this.api = api;
    }
}
