package net.ozero.linksmediatest;

import android.app.Application;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import net.ozero.linksmediatest.api.Api;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class App extends Application {

    public static final String EXTRA_CATEGORY = "category";

    public static final String CATEGORY_FOOTBALL = "football";
    public static final String CATEGORY_HOCKEY = "hockey";
    public static final String CATEGORY_TENNIS = "tennis";
    public static final String CATEGORY_BASKETBALL = "basketball";
    public static final String CATEGORY_VOLLEYBALL = "volleyball";
    public static final String CATEGORY_CYBERSPORT = "cybersport";

    private Api mApi;

    @Override
    public void onCreate() {
        super.onCreate();

        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                .setDateFormat("yyyy-MM-dd HH:mm:ss")
                .create();

//        OkHttpClient okHttpClient = new OkHttpClient.Builder()
//                .addInterceptor(new HttpLoggingInterceptor().setLevel(BuildConfig.DEBUG ? HttpLoggingInterceptor.Level.HEADERS : HttpLoggingInterceptor.Level.NONE))
//                .build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://mikonatoruri.win")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        mApi = retrofit.create(Api.class);


    }

    public Api api() {
        return mApi;
    }
}
