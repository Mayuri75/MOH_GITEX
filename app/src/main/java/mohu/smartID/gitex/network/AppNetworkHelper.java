package mohu.smartID.gitex.network;

import android.os.CountDownTimer;


import mohu.smartID.gitex.constants.Constants;

import mohu.smartID.gitex.interfaces.RequestCallback;

import mohu.smartID.gitex.models.BaseData;
import mohu.smartID.gitex.models.Response;
import mohu.smartID.gitex.models.ValidationPost;

import retrofit2.Call;
import retrofit2.Callback;


public class AppNetworkHelper {

    private RequestCallback listener;

    public AppNetworkHelper(RequestCallback listener) {
        this.listener = listener;
    }

    public void getData(final BaseData baseData) {
        CountDownTimer countDownTimer = new CountDownTimer(2000, 2000) {
            @Override
            public void onTick(long millisUntilFinished) {

            }

            @Override
            public void onFinish() {
                switch (baseData.getApi()) {
                    case Constants.API_GET_PROFILE: {
                        //getProfile(baseData);
                        break;
                    }
                    case Constants.API_GET_PERSONALINFO: {
                        //getPersonalInfoList(baseData);
                        break;
                    }
                    case Constants.API_GET_USER_VALIDATE: {
                      //  getValidateUser(baseData);
                        break;
                    }
                    case Constants.API_GET_PILIGRIMS: {
                      //  getContactList(baseData);
                        break;
                    }
                    case Constants.API_GET_CHATHISTORY: {
                     //   getChatHistoryList(baseData);
                        break;
                    }
                    case Constants.API_GET_CHATHISTORY_DETAILS: {
                       // getChatHistoryDetailsList(baseData);
                        break;
                    }
                    case Constants.API_GET_ORGANIZEERS: {
                       // getContactList(baseData);
                        break;
                    }
                    case Constants.API_GET_CONTACTS: {
                       // getContacts(baseData);
                        break;
                    }
                    case Constants.API_GET_RESTAURANTS: {
                     //   getRestaurants(baseData);
                        break;
                    }
                    case Constants.API_GET_INCIDENTSHISTORY: {
                       // getIncidentsList(baseData);
                        break;
                    }
                    case Constants.API_POST_INCIDENT: {
                     //   postIncident(baseData);
                        break;
                    }

                    case Constants.API_GET_EXISTLOGIN: {
                       // getExistLogin(baseData);
                        break;
                    }
                    case Constants.API_ESTABLISHMENT: {
                      //  getEstablishment(baseData);
                        break;
                    }
                    case Constants.API_ALERTS: {
                      //  getAlerts(baseData);
                        break;
                    }
                    case Constants.API_OFFICE: {
                        //getOffice(baseData);
                        break;
                    }
                    case Constants.API_CONTACT_PENDING: {
                      //  getPendingcontact(baseData);
                        break;
                    }

                    case Constants.API_CONTACT_APPROVE: {
                       // postAproveContact(baseData);
                        break;
                    }
                    case Constants.API_LOGOUT: {
                      //  postLogout(baseData);
                        break;
                    }

                    case Constants.API_CONTACT_DECLINE: {
                       // postDeclineContact(baseData);
                        break;
                    }
                    case Constants.API_COUNTRY: {
                       // getCountry(baseData);
                        break;
                    }
                    case Constants.API_POST_CONTACT: {
                       // postContact(baseData);
                        break;
                    }
                    case Constants.API_GET_SCAN_PILGRIMS: {
                       // getScanPilgrims(baseData);

                        break;
                    }
                    case Constants.API_POST_ATTACHMENT: {
                       // postAttachments(baseData);
                        break;
                    }
                    case Constants.API_POST_RESGISTRAION: {
                       // postUserRegistration(baseData);
                        break;
                    }

                    case Constants.API_RESGISTRAION: {
                       // userRegistration(baseData);
                        break;
                    }


                    default:
                        break;
                }
            }

        };
        countDownTimer.start();

    }


    private void userRegistration(final BaseData baseData) {
        final Response _res = new Response();
        //  ContactOutput _obj= new ContactOutput();
        NetworkServiceBuilder.buildProfile()
                .userRegistration((ValidationPost) baseData.getObject())
                .enqueue(new Callback<Response<ValidationPost>>() {
                    @Override
                    public void onResponse(Call<Response<ValidationPost>> call, retrofit2.Response<Response<ValidationPost>> response) {
                        if (response.body() != null) {
                            baseData.setObject(response.body().getMessage());
                            listener.onSuccess(baseData);
                        } else {
                            listener.onFailure(baseData);
                        }
                    }

                    @Override
                    public void onFailure(Call<Response<ValidationPost>> call, Throwable t) {
                        listener.onFailure(baseData);
                    }
                });
    }





}
