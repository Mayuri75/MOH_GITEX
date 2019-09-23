package mohu.smartID.gitex.network;


import mohu.smartID.gitex.constants.Constants;
import mohu.smartID.gitex.models.LocationModel;
import mohu.smartID.gitex.models.Response;
import mohu.smartID.gitex.models.ValidationPost;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface NetworkService {
    @POST("/user/profile")
    Call<Response<String>> postUserRegistration(@Body ValidationPost contactRes);
    @POST(Constants.API_RESGISTRAION)
    Call<Response<ValidationPost>> userRegistration(@Body ValidationPost contactRes);
    @POST("locate/user")
    Call<Object> postLocation(@Body LocationModel locationModel);
   /* @GET("incidents")
    Call<Response<List<IncidentList>>> getIncidents(@Header(value = "hajjNumber") String header);


    //@Headers({"userId: 1"})
    @GET("schedule")
    Call<Response<List<ScheduleModel>>> getSchedule(@Header(value = "hajjNumber") String header);


    @GET("busschedule")
    Call<Response<List<BusModel>>> getBusSchedule();

    @GET("trainschedule")
    Call<Response<List<BusModel>>> getTrainSchedule();


    @POST(Constants.API_SAVE_PREF)
    Call<Object> savePref(@Body List<SlotPrefModel> slotPrefModel);

    @GET("schedulePreference")
    Call<Response<List<SlotPrefModel>>> getPref(@Header(value = "hajjNumber") String header);


    @POST("incidents")
    Call<Response<Double>> postIncident(@HeaderMap Map<String, String> maps, @Body postIncidentRes incidentList);

    @DELETE("contact")
    Call<Response<Nullable>> deleteContact(@Header(value = "targetHajjNumber") String header, @Header(value = "sourceHajjNumber") String header1, @Header(value = "Content-Type") String header2);



    @Multipart
    @POST(Constants.API_POST_ATTACHMENT)
    Call<Response<String>> postAttachment(@Part MultipartBody.Part filePart, @Header(value = "hajjNumber") String header, @Header(value = "incident-id") String header1);


    @POST(Constants.API_CONTACT_APPROVE)
    Call<Response<Object>> postContactAprove(@Header(value = "hajjNumber") String header, @Header(value = "contactHajjNumber") String header1);

    @POST(Constants.API_CONTACT_DECLINE)
    Call<Response<Object>> postContactDecline(@Header(value = "hajjNumber") String header, @Header(value = "contactHajjNumber") String header1);

    //@Headers({"userId: 1"})
    @GET("contact")
    Call<Response<List<Organizeers>>> getContact(@Header(value = "hajjNumber") String header);


    @GET("user")
    Call<Response<List<Organizeers>>> getScanPilgrim(@Header(value = "hajjNumber") String header);

    @GET("exists")
    Call<Response<Validations>> getExistLogin(@Header(value = "email") String header);

    // changes
    @POST("user/contact")
    Call<Response<ContactOutput>> postContact(@Body ContactRes contactRes);


    @POST("locate/user")
    Call<Object> postLocation(@Body LocationModel locationModel);


//    @Headers({"userId: 1"})
    @GET("user")
    Call<Response<PersonalInformationRes>> getPersonalInfo(@Header(value = "hajjNumber") String header);


    //    @Headers({"userId: 1"})
    @GET("validate")
    Call<Response<Validations>> getValidate(@Header(value = "id") String header, @Header(value = "email") String header1, @Header(value = "type") String header2);

    @POST("/user/profile")
    Call<Response<String>> postUserRegistration(@Body ValidationPost contactRes);


    @POST(Constants.API_RESGISTRAION)
    Call<Response<ValidationPost>> userRegistration(@Body ValidationPost contactRes);


    @GET("conversations")
    Call<Response<List<ChatMessageListRes>>> getChatList(@Header(value = "hajjNumber") String header);

    @GET(Constants.API_GET_CHATHISTORY_DETAILS)
    Call<Response<List<ChatDetailsRes>>> getChatDetails(@Header(value = "senderHajjNumber") String header, @Header(value = "receiverHajjNumber") String header1);

    //@Headers({"hajjNumber: 000010010053"})
    @GET("user")
    Call<Response<LocateUserRes>> getUserLocation(@Header(value = "hajjNumber") String header);

    @GET(Constants.API_ESTABLISHMENT)
    Call<Response<List<Establishment>>> getEstablishment();

    @GET(Constants.API_ALERTS)
    Call<Response<List<Alerts>>> getAlerts(@Header(value = "hajjNumber") String header);


    @GET(Constants.API_OFFICE)
    Call<Response<List<Office>>> getOfficeId(@Header(value = "establishmentId") String header);

    @GET(Constants.API_CONTACT_PENDING)
    Call<Response<List<PendingContact>>> getPendingContact(@Header(value = "hajjNumber") String header);

    @GET(Constants.API_COUNTRY)
    Call<Response<List<String>>> getCounty();

    @POST(Constants.API_LOGOUT)
    Call<Response<Nullable>> postLogout();


*/
}
