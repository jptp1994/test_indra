package com.test.indra.presentation.ui;


import com.test.indra.base.Lifecycle;
import com.test.indra.presentation.model.PhotoModel;

import java.util.List;

/**
 * Created by manuelvicnt on 11/11/2016.
 */

public interface PhotoContract {

    interface View extends Lifecycle.View {

        void showSuccessfulMessage(List<PhotoModel> photos);

        void hideLoading();
    }

    interface ViewModel extends Lifecycle.ViewModel {

        void getPhotoData();
    }
}
