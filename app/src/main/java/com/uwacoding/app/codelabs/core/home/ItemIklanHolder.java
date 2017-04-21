package com.uwacoding.app.codelabs.core.home;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.ahmadrosid.lib.baseapp.core.view.BaseImageView;
import com.ahmadrosid.lib.baseapp.helper.CurrencyHelper;
import com.uwacoding.app.codelabs.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Firman on 3/29/2017.
 */

public class ItemIklanHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.img_iklan)BaseImageView img_iklan;
    @BindView(R.id.title_iklan)TextView title_iklan;
    @BindView(R.id.price_iklan)TextView price_iklan;

    public ItemIklanHolder(View itemView){
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    public void bindView(IklanModel data) {
        try {
            String[] urlImage = data.getUrl_image().split(",");
            img_iklan.setImageUrl(urlImage[0]);
            title_iklan.setText(data.getJudul());
            price_iklan.setText(CurrencyHelper.format(data.getHarga()));
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
