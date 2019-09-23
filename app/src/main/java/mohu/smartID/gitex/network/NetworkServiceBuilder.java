package mohu.smartID.gitex.network;

import android.support.annotation.NonNull;

import mohu.smartID.gitex.constants.Constants;
import com.facebook.stetho.okhttp3.StethoInterceptor;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class NetworkServiceBuilder {

    private static OkHttpClient okHttpClient = new OkHttpClient.Builder()
                    .addNetworkInterceptor(new StethoInterceptor())
                    .addInterceptor(new Interceptor() {
                        @Override
                        public Response intercept(@NonNull Chain chain) throws IOException {
                            Request original = chain.request();
                            Request request = NetworkServiceBuilder
                                    .getRequestBuilder(original)
                                    .build();
                            return chain.proceed(request);
                        }
                    })
                    .readTimeout(60 * 5, TimeUnit.SECONDS)
                    .connectTimeout(60 * 5, TimeUnit.SECONDS)
                    .build();


    private static OkHttpClient authClient =
            new OkHttpClient.Builder()
                    .addNetworkInterceptor(new StethoInterceptor())
                    .addInterceptor(new Interceptor() {
                        @Override
                        public Response intercept(@NonNull Chain chain) throws IOException {
                            Request original = chain.request();
                            Request request = NetworkServiceBuilder
                                    .getRequestBuilder(original)
                                    .build();
                            return chain.proceed(request);
                        }
                    })
                    .readTimeout(60 * 5, TimeUnit.SECONDS)
                    .connectTimeout(60 * 5, TimeUnit.SECONDS)
                    .build();


    public static NetworkService buildMain() {
      //  https://incidentmanagement.cfapps.eu10.hana.ondemand.com/
        Gson gson = new GsonBuilder()
                .create();
        Retrofit retrofit =
                new Retrofit.Builder()

                        .baseUrl(Constants.BUILD_MAIN)
                        .addConverterFactory(GsonConverterFactory.create(gson))
                        .client(getInterceptor())
                        .build();
        return retrofit.create(NetworkService.class);
    }

    public static NetworkService buildAttachment() {
        //  https://incidentmanagement.cfapps.eu10.hana.ondemand.com/
        Gson gson = new GsonBuilder()
                .create();
        Retrofit retrofit =
                new Retrofit.Builder()

                        .baseUrl(Constants.BUILD_ATTACHMENT)
                        .addConverterFactory(GsonConverterFactory.create(gson))
                        .client(getInterceptor())
                        .build();
        return retrofit.create(NetworkService.class);



    }
    public static NetworkService buildContact() {
        Gson gson = new GsonBuilder().create();

        Retrofit retrofit =
                new Retrofit.Builder()
                        .baseUrl(Constants.BUILD_CONSTANT)
                        .addConverterFactory(GsonConverterFactory.create(gson))
                        .client(getInterceptor())
                        .build();
        return retrofit.create(NetworkService.class);
    }

    public static NetworkService buildLocate() {
        Gson gson = new GsonBuilder()

                .create();

        Retrofit retrofit =
                new Retrofit.Builder()
                        .baseUrl(Constants.BUILD_LOCATE)
                        .addConverterFactory(GsonConverterFactory.create(gson))
                        .client(getInterceptor())
                        .build();
        return retrofit.create(NetworkService.class);
    }

    public static NetworkService buildContactBase() {
        Gson gson = new GsonBuilder()
                .create();
        Retrofit retrofit =
                new Retrofit.Builder()
                        .baseUrl(Constants.BUILD_CONTACT_BASE)
                        .addConverterFactory(GsonConverterFactory.create(gson))
                        .client(getInterceptor())
                        .build();
        return retrofit.create(NetworkService.class);
    }
    public static NetworkService buildMasterData() {
        Gson gson = new GsonBuilder()
                .create();
        Retrofit retrofit =
                new Retrofit.Builder()
                        .baseUrl(Constants.BUILD_MASTER_DATA)
                        .addConverterFactory(GsonConverterFactory.create(gson))
                        .client(getInterceptor())
                        .build();
        return retrofit.create(NetworkService.class);
    }

    public static NetworkService buildProfile() {
        Gson gson = new GsonBuilder()
                .create();
        Retrofit retrofit =
                new Retrofit.Builder()
                        .baseUrl(Constants.BUILD_PROFILE)
                        .addConverterFactory(GsonConverterFactory.create(gson))
                        .client(getInterceptor())
                        .build();
        return retrofit.create(NetworkService.class);
    }
    public static NetworkService buildValidate() {
        Gson gson = new GsonBuilder()
                .create();
        Retrofit retrofit =
                new Retrofit.Builder()
                        .baseUrl(Constants.BUILD_VALIDATE)
                        .addConverterFactory(GsonConverterFactory.create(gson))
                        .client(getInterceptor())
                        .build();
        return retrofit.create(NetworkService.class);
    }
    public static NetworkService buildEstablishment() {
        Gson gson = new GsonBuilder()
                .create();
        Retrofit retrofit =
                new Retrofit.Builder()
                        .baseUrl(Constants.BUILD_ESTABLISHMENT)
                        .addConverterFactory(GsonConverterFactory.create(gson))
                        .client(getInterceptor())
                        .build();
        return retrofit.create(NetworkService.class);
    }

    public static NetworkService buildAlerts() {
        Gson gson = new GsonBuilder()
                .create();
        Retrofit retrofit =
                new Retrofit.Builder()
                        .baseUrl(Constants.BUILD_ALERT)
                        .addConverterFactory(GsonConverterFactory.create(gson))
                        .client(getInterceptor())
                        .build();
        return retrofit.create(NetworkService.class);
    }

    public static NetworkService buildPendingcontact() {
        Gson gson = new GsonBuilder()
                .create();
        Retrofit retrofit =
                new Retrofit.Builder()
                        .baseUrl(Constants.BUILD_CONTACT_PENDING)
                        .addConverterFactory(GsonConverterFactory.create(gson))
                        .client(getInterceptor())
                        .build();
        return retrofit.create(NetworkService.class);
    }
    public static NetworkService buildAprovecontact() {
        Gson gson = new GsonBuilder()
                .create();
        Retrofit retrofit =
                new Retrofit.Builder()
                        .baseUrl(Constants.BUILD_CONTACT_APROVE)
                        .addConverterFactory(GsonConverterFactory.create(gson))
                        .client(getInterceptor())
                        .build();
        return retrofit.create(NetworkService.class);
    }
    public static NetworkService buildLogout() {
        Gson gson = new GsonBuilder()
                .create();
        Retrofit retrofit =
                new Retrofit.Builder()
                        .baseUrl(Constants.BUILD_LOGOUT)
                        .addConverterFactory(GsonConverterFactory.create(gson))
                        .client(getInterceptor())
                        .build();
        return retrofit.create(NetworkService.class);
    }
    public static NetworkService buildDeclinecontact() {
        Gson gson = new GsonBuilder()
                .create();
        Retrofit retrofit =
                new Retrofit.Builder()
                        .baseUrl(Constants.BUILD_CONTACT_DECLINE)
                        .addConverterFactory(GsonConverterFactory.create(gson))
                        .client(getInterceptor())
                        .build();
        return retrofit.create(NetworkService.class);
    }

    public static NetworkService buildLocation() {
        Gson gson = new GsonBuilder()
                .create();
        Retrofit retrofit =
                new Retrofit.Builder()
                        .baseUrl(Constants.BUILD_LOCATION)
                        .addConverterFactory(GsonConverterFactory.create(gson))
                        .client(getInterceptor())
                        .build();
        return retrofit.create(NetworkService.class);
    }
    public static NetworkService buildSchedule() {
        Gson gson = new GsonBuilder()
                .create();
        Retrofit retrofit =
                new Retrofit.Builder()
                        .baseUrl(Constants.BUILD_SCHEDULE)
                        .addConverterFactory(GsonConverterFactory.create(gson))
                        .client(getInterceptor())
                        .build();
        return retrofit.create(NetworkService.class);
    }
    public static NetworkService buildChat() {
        Gson gson = new GsonBuilder()
                .create();
        Retrofit retrofit =
                new Retrofit.Builder()
                        .baseUrl(Constants.BUILD_CHAT)
                        .addConverterFactory(GsonConverterFactory.create(gson))
                        .client(getInterceptor())
                        .build();
        return retrofit.create(NetworkService.class);
    }
    private static OkHttpClient getInterceptor() {
        return okHttpClient;
    }

    private static OkHttpClient getAuthInterceptor() {
        return authClient;
    }


    private static Request.Builder getRequestBuilder(Request request) {
        return request.newBuilder();
    }

    public static void cancelRequests() {
        okHttpClient.dispatcher().cancelAll();
    }
}
