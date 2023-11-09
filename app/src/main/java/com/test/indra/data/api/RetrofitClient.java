package com.test.indra.data.api;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.test.indra.presentation.model.PhotoModel;

import java.util.List;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;

public class RetrofitClient {
    private static final String PHOTO_BASE_URL = "https://jsonplaceholder.typicode.com/";
    private static RetrofitClient instance;
    private final RetrofitService photoService;
    private RetrofitClient() {
        final Gson gson =
                new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES).create();
        final Retrofit retrofit = new Retrofit.Builder().baseUrl(PHOTO_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        photoService = retrofit.create(RetrofitService.class);
    }
    public static RetrofitClient getInstance() {
        if (instance == null) {
            instance = new RetrofitClient();
        }
        return instance;
    }
    public Observable<List<PhotoModel>> getPhotoList() {
        return photoService.getPhotoList();
    }
}
