package com.kharisma.inside.mandiri.sejahtera.kimsapp.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.kharisma.inside.mandiri.sejahtera.kimsapp.HolderData.HolderDataSales;
import com.kharisma.inside.mandiri.sejahtera.kimsapp.Model.ModelSales;
import com.kharisma.inside.mandiri.sejahtera.kimsapp.R;

import java.util.List;

public class AdapterSales extends RecyclerView.Adapter<HolderDataSales> {
    private Context context;
    private List<ModelSales> modelSalesList;

    public AdapterSales(Context context, List<ModelSales> modelSalesList) {
        this.context = context;
        this.modelSalesList = modelSalesList;
    }

    @NonNull
    @Override
    public HolderDataSales onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.custom_list_sales, viewGroup, false);
        return new HolderDataSales(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HolderDataSales holderDataSales, int i) {
        ModelSales modelSales = modelSalesList.get(i);
        holderDataSales.txtName.setText(modelSales.getSalesName());
        holderDataSales.valEmail.setText(modelSales.getSalesEmail());
        holderDataSales.valHP.setText(modelSales.getSalesHP());
        holderDataSales.context = context;
        holderDataSales.sales = modelSales;
    }

    @Override
    public int getItemCount() {
        return modelSalesList.size();
    }
}
