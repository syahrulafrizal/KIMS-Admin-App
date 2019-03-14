package com.kharisma.inside.mandiri.sejahtera.kimsapp.Adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.kharisma.inside.mandiri.sejahtera.kimsapp.HolderData.HolderDataProduct;
import com.kharisma.inside.mandiri.sejahtera.kimsapp.Model.ModelProduct;
import com.kharisma.inside.mandiri.sejahtera.kimsapp.R;

import java.util.List;

public class AdapterProduct extends RecyclerView.Adapter<HolderDataProduct> {

    private Context context;
    private List<ModelProduct> modelProductList;

    public AdapterProduct(Context context, List<ModelProduct> modelProductList) {
        this.context = context;
        this.modelProductList = modelProductList;
    }

    @NonNull
    @Override
    public HolderDataProduct onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.custom_list_products,viewGroup, false);
        return new HolderDataProduct(view);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull HolderDataProduct holderDataProduct, int i) {
        ModelProduct modelProduct = modelProductList.get(i);
        holderDataProduct.valSN.setText("SN : "+modelProduct.getSerialNumber());
        holderDataProduct.valProduct.setText(modelProduct.getProduct());
        holderDataProduct.valStatus.setText(modelProduct.getStatus());
        holderDataProduct.valPoint.setText(String.valueOf(modelProduct.getPoint()+" Point"));
        holderDataProduct.imgProduct.setImageResource(modelProduct.getImgProduct());
        holderDataProduct.context = context;
        holderDataProduct.product = modelProduct;

        if (modelProduct.getClaimBy().equals("")){
            holderDataProduct.claim.setVisibility(View.GONE);
            holderDataProduct.status.setBackgroundColor(Color.parseColor("#FFFFFF"));
        }else {
            holderDataProduct.claim.setVisibility(View.VISIBLE);
            holderDataProduct.valClaimer.setText("Claim By : "+modelProduct.getClaimBy());
            holderDataProduct.status.setBackgroundColor(Color.parseColor("#FFFFFF"));
            holderDataProduct.claim.setBackgroundColor(Color.parseColor("#F7F7F7"));
        }
    }

    @Override
    public int getItemCount() {
        return modelProductList.size();
    }
}
