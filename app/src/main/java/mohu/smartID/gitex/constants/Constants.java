package mohu.smartID.gitex.constants;

public class Constants {

    public static final String API_GET_PROFILE = "getProfile";
    public static final String API_GET_PERSONALINFO = "getPersonalInfo";
    public static final String API_GET_EXISTLOGIN = "getExistsLogin";
    public static final String API_GET_PILIGRIMS = "getPiligrims";
    public static final String API_GET_Schedule = "schedule";
    public static final String API_GET_CHATHISTORY = "getChatHistory";
    public static final String API_GET_CHATHISTORY_DETAILS = "messages";
    public static final String API_GET_INCIDENTSHISTORY = "getIncidentsHistory";
    public static final String API_POST_INCIDENT = "postIncident";
    public static final String API_POST_CONTACT = "postContact";

    public static final String API_GET_ORGANIZEERS = "getOrganizeers";
    public static final String API_GET_CONTACTS = "getContacts";
    public static final String API_GET_SCAN_PILGRIMS = "getScanPilgrims";
    public static final String API_GET_RESTAURANTS = "getRESTAURANTS";

    public static final String API_GET_NOTIFICATIONS = "getNotifications";
    public static final String API_POST_ATTACHMENT = "attachment";
    public static final String API_GET_USERLOCATION = "getUserLocation";
    public static final String API_DELETE_CONTACT = "deleteContact";

    public static final String USERID = "USERID";
    public static final String API_GET_BUS_SCHEDULE = "busschedule";
    public static final String API_GET_TRAIN_SCHEDULE = "trainschedule";
    public static final String API_GET_USER_VALIDATE = "getUserValidate";
    public static final String API_POST_RESGISTRAION = "postRegistration";

    public static final String API_RESGISTRAION = "user/register";
    public static final String API_ESTABLISHMENT = "establishment";
    public static final String API_ALERTS = "incidents";
    public static final String API_OFFICE = "office";
    public static final String API_COUNTRY = "country";
    public static final String API_CONTACT_PENDING = "pending";
    public static final String API_CONTACT_APPROVE = "approve";
    public static final String API_CONTACT_DECLINE = "decline";
    public static final String API_LOGOUT = "logout";


    public static String userName = "";
    public static final String API_SAVE_PREF = "schedulePreference";
    public static final String API_GET_PREF = "getPref";

    public static String DATE_FORMAT = "DD-MM-YY";
    public static String DATETIME_ddMMyyyyEEE = "yyyy-MM-dd'T'HH:mms.SSSZ";
    public static String DATE_ddMMyyyyEEE = "yyyy-MM-dd HH:mms.SSSZ";

    //DEV
  /*  public static String BUILD_MAIN = "https://alertsmanagement.cfapps.eu10.hana.ondemand.com/";
    public static String BUILD_ATTACHMENT = "https://filestore-aws-service.cfapps.eu10.hana.ondemand.com/incident/";
    public static String BUILD_CONSTANT = "https://userregistration.cfapps.eu10.hana.ondemand.com/user/";
    public static String BUILD_LOCATE = "https://spatial-data-services.cfapps.eu10.hana.ondemand.com/";
    public static String BUILD_CONTACT_BASE = "https://userregistration.cfapps.eu10.hana.ondemand.com/";
    public static String BUILD_MASTER_DATA = "https://masterdatamaintenance.cfapps.eu10.hana.ondemand.com/";
    public static String BUILD_PROFILE = "https://userregistration.cfapps.eu10.hana.ondemand.com/";
    public static String BUILD_VALIDATE = "https://user-validation-noauth-services.cfapps.eu10.hana.ondemand.com/user/";
    public static String BUILD_LOCATION = "https://spatial-data-services.cfapps.eu10.hana.ondemand.com/locate/";
    public static String BUILD_SCHEDULE = "https://schedulemanagement.cfapps.eu10.hana.ondemand.com/";
    public static String BUILD_CHAT = "https://chatapplication.cfapps.eu10.hana.ondemand.com/load/user/";
    public static String BUILD_PROFILE_PIC = "https://filestore-aws-service.cfapps.eu10.hana.ondemand.com/user/profile/photo";
    public static String BUILD_SOCKET = "https://chatapplication.cfapps.eu10.hana.ondemand.com/chatSocket";
    public static String BUILD_ESTABLISHMENT = "https://profile-data-services.cfapps.eu10.hana.ondemand.com/lookup/";
    public static String BUILD_OFFICE = "https://profile-data-services.cfapps.eu10.hana.ondemand.com/lookup/";
    public static String BUILD_COUNTRY = "https://profile-data-services.cfapps.eu10.hana.ondemand.com/lookup/";
    public static String BUILD_CONTACT_PENDING = "https://userregistration.cfapps.eu10.hana.ondemand.com/user/contact/";
    public static String BUILD_CONTACT_APROVE = "https://profile-data-services.cfapps.eu10.hana.ondemand.com/contact/";
    public static String BUILD_CONTACT_DECLINE = "https://profile-data-services.cfapps.eu10.hana.ondemand.com/contact/";
    public static String BUILD_ALERT = "https://alertsmanagement.cfapps.eu10.hana.ondemand.com/";
    public static String BUILD_LOGOUT = "https://mohapps-mohu-dev-com-moh-hajj.cfapps.eu10.hana.ondemand.com/mobileservices/sessions/";*/
    //QA
   /* public static String BUILD_MAIN = "https://alertsmanagement-q.cfapps.eu10.hana.ondemand.com/";
    public static String BUILD_ATTACHMENT = "https://filestore-aws-service-q.cfapps.eu10.hana.ondemand.com/incident/";
    public static String BUILD_CONSTANT = "https://userregistration-q.cfazpps.eu10.hana.ondemand.com/user/";
    public static String BUILD_LOCATE = "https://spatial-data-services-q.cfapps.eu10.hana.ondemand.com/";
    public static String BUILD_CONTACT_BASE = "https://userregistration-q.cfapps.eu10.hana.ondemand.com/";
    public static String BUILD_MASTER_DATA = "https://masterdatamaintenance-q.cfapps.eu10.hana.ondemand.com/";
    public static String BUILD_PROFILE = "https://userregistration-q.cfapps.eu10.hana.ondemand.com/";
    public static String BUILD_VALIDATE = "https://user-validation-noauth-services-q.cfapps.eu10.hana.ondemand.com/user/";
    public static String BUILD_LOCATION = "https://spatial-data-services-q.cfapps.eu10.hana.ondemand.com/locate/";
    public static String BUILD_SCHEDULE = "https://schedulemanagement-q.cfapps.eu10.hana.ondemand.com/";
    public static String BUILD_PROFILE_PIC = "https://filestore-aws-service-q.cfapps.eu10.hana.ondemand.com/user/profile/photo";*/

    //PRODUCTION
    public static String BUILD_MAIN = "https://alertsmanagement-p.cfapps.eu10.hana.ondemand.com/";
    public static String BUILD_ATTACHMENT = "https://filestore-aws-service-p.cfapps.eu10.hana.ondemand.com/incident/";
    public static String BUILD_CONSTANT = "https://userregistration-p.cfapps.eu10.hana.ondemand.com/user/";
    public static String BUILD_LOCATE = "https://spatial-data-services-p.cfapps.eu10.hana.ondemand.com/";
    public static String BUILD_CONTACT_BASE = "https://userregistration-p.cfapps.eu10.hana.ondemand.com/";
    public static String BUILD_MASTER_DATA = "https://masterdatamaintenance-p.cfapps.eu10.hana.ondemand.com/";
    public static String BUILD_PROFILE = "https://userregistration-p.cfapps.eu10.hana.ondemand.com/";
    public static String BUILD_VALIDATE = "https://user-validation-noauth-services-p.cfapps.eu10.hana.ondemand.com/user/";
    public static String BUILD_LOCATION = "https://spatial-data-services-p.cfapps.eu10.hana.ondemand.com/locate/";
    public static String BUILD_SCHEDULE = "https://schedulemanagement-p.cfapps.eu10.hana.ondemand.com/";
    public static String BUILD_CHAT = "https://chatapplication-p.cfapps.eu10.hana.ondemand.com/load/user/";
    public static String BUILD_PROFILE_PIC = "https://filestore-aws-service-p.cfapps.eu10.hana.ondemand.com/user/profile/photo";
    public static String BUILD_SOCKET = "https://chatapplication-p.cfapps.eu10.hana.ondemand.com/chatSocket";
    public static String BUILD_ESTABLISHMENT = "https://profile-data-services-p.cfapps.eu10.hana.ondemand.com/lookup/";
    public static String BUILD_OFFICE = "https://profile-data-services-p.cfapps.eu10.hana.ondemand.com/lookup/";
    public static String BUILD_COUNTRY = "https://profile-data-services-p.cfapps.eu10.hana.ondemand.com/lookup/";
    public static String BUILD_CONTACT_PENDING = "https://userregistration-p.cfapps.eu10.hana.ondemand.com/user/contact/";
    public static String BUILD_CONTACT_APROVE = "https://profile-data-services-p.cfapps.eu10.hana.ondemand.com/contact/";
    public static String BUILD_CONTACT_DECLINE = "https://profile-data-services-p.cfapps.eu10.hana.ondemand.com/contact/";
    public static String BUILD_ALERT = "https://alertsmanagement-p.cfapps.eu10.hana.ondemand.com/";
    public static String BUILD_LOGOUT = "https://mohapps-mohu-dev-com-moh-hajj-p.cfapps.eu10.hana.ondemand.com/mobileservices/sessions/";
}
