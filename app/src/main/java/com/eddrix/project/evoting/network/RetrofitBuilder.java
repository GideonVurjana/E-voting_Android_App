package com.eddrix.project.evoting.network;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

public class RetrofitBuilder {

     static RetrofitBuilder retrofitBuilder = new RetrofitBuilder();

    private RetrofitBuilder() {
    }

    public static RetrofitBuilder getInstance() {

        return retrofitBuilder;
    }

    public ApiEndPointInterface getRetrofit() {

        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        httpClient.connectTimeout(10, TimeUnit.MINUTES);
        httpClient.readTimeout(10, TimeUnit.MINUTES);
        httpClient.writeTimeout(10, TimeUnit.MINUTES);
        httpClient.addInterceptor(logging);


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(AppUtils.BASE_URL)
                .client(httpClient.build())
                .addConverterFactory(JacksonConverterFactory.create())
                .build()
                ;

        return retrofit.create(ApiEndPointInterface.class);
    }

}
