package com.test.indra.presentation.viewmodel;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;

import com.test.indra.base.Lifecycle;
import com.test.indra.data.api.RetrofitClient;
import com.test.indra.presentation.model.PhotoModel;
import com.test.indra.presentation.ui.PhotoContract;

import java.util.List;

import rx.Observer;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class AppViewModel extends ViewModel  implements PhotoContract.ViewModel {
    private static final String TAG = AppViewModel.class.getSimpleName();
    private PhotoContract.View viewCallback;

    @Override
    public void onViewResumed() {

    }

    @Override
    public void onViewAttached(@NonNull Lifecycle.View viewCallback) {
        this.viewCallback = (PhotoContract.View) viewCallback;
    }

    @Override
    public void onViewDetached() {
        this.viewCallback = null;
    }

    @Override
    public void getPhotoData() {
        getStarredRepos();
    }

    private void getStarredRepos() {
        Subscription subscription = RetrofitClient.getInstance()
                .getPhotoList()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .take(15)
                .subscribe(new Observer<List<PhotoModel>>() {
                    @Override
                    public void onCompleted() {
                        Log.d(TAG, "In onCompleted()");
                    }

                    @Override
                    public void onError(Throwable e) {
                        e.printStackTrace();
                        Log.d(TAG, "In onError()");
                    }

                    @Override
                    public void onNext(List<PhotoModel> photoModels) {
                        viewCallback.showSuccessfulMessage(photoModels);
                        viewCallback.hideLoading();
                    }
                });
    }
}