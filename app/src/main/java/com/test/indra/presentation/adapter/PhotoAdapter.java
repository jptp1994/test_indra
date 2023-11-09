package com.test.indra.presentation.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;
import com.test.indra.R;
import com.test.indra.presentation.model.PhotoModel;

import java.util.ArrayList;
import java.util.List;


public class PhotoAdapter  extends RecyclerView.Adapter<PhotoAdapter.ViewHolder>{

    private final List<PhotoModel> photoModelList = new ArrayList<>();
    // RecyclerView recyclerView;

    public void setPhotoModelList(@Nullable List<PhotoModel> photoModelList) {
        if (photoModelList == null) {
            return;
        }
        photoModelList.clear();
        photoModelList.addAll(photoModelList);
        notifyDataSetChanged();
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem= layoutInflater.inflate(R.layout.item_photo, parent, false);
        return new ViewHolder(listItem);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final PhotoModel myListData = photoModelList.get(position);
        holder.textView.setText(myListData.title);
        Picasso.get()
                .load(myListData.url)
                .into(holder.imageView);
    }


    @Override
    public int getItemCount() {
        return photoModelList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView imageView;
        public TextView textView;
        public ViewHolder(View itemView) {
            super(itemView);
            this.imageView = (ImageView) itemView.findViewById(R.id.iv_photo);
            this.textView = (TextView) itemView.findViewById(R.id.tv_title);
        }
    }
}