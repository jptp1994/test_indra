package com.test.indra.presentation.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.test.indra.R;
import com.test.indra.presentation.adapter.PhotoAdapter;
import com.test.indra.presentation.model.PhotoModel;
import com.test.indra.presentation.viewmodel.AppViewModel;

import java.util.List;
public class PhotoFragment extends Fragment implements PhotoContract.View{

    private final PhotoAdapter adapter = new PhotoAdapter();

    private PhotoContract.ViewModel appViewModel;

    @Override
    public void showSuccessfulMessage(List<PhotoModel> photos) {
        adapter.setPhotoModelList(photos);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        appViewModel = new AppViewModel();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_photo, container, false);
        final RecyclerView rvData = (RecyclerView) rootView.findViewById(R.id.rv_data);
        rvData.setAdapter(adapter);
        appViewModel.getPhotoData();
        return rootView;
    }
    @Override
    public void hideLoading() {

    }

}
