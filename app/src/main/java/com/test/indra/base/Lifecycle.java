package com.test.indra.base;

import androidx.annotation.NonNull;

/**
 * Created by manuelvicnt on 11/11/2016.
 */
public interface Lifecycle {

    interface View {

    }

    interface ViewModel {

        void onViewResumed();
        void onViewAttached(@NonNull Lifecycle.View viewCallback);
        void onViewDetached();
    }
}
