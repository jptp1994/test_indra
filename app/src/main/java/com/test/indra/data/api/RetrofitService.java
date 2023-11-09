package com.test.indra.data.api;

import com.test.indra.presentation.model.PhotoModel;

import java.util.List;

import retrofit2.http.GET;
import rx.Observable;

public interface RetrofitService  {
    @GET("photos")

    Observable<List<PhotoModel>> getPhotoList();
}
