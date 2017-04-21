package com.uwacoding.app.codelabs.core.iklan_saya.newiklan;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.uwacoding.app.codelabs.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Firman on 3/29/2017.
 */

public class ItemHolderImage extends RecyclerView.ViewHolder {

    @BindView(R.id.image)
    ImageView images;

    public ItemHolderImage(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    public void onBindView(String image) {
        Glide.with(itemView.getContext()).load(image).centerCrop().into(images);
    }
}
