package com.kharisma.inside.mandiri.sejahtera.kimsapp.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.kharisma.inside.mandiri.sejahtera.kimsapp.holderdata.HolderDataAdmin;
import com.kharisma.inside.mandiri.sejahtera.kimsapp.model.ModelAdmin;
import com.kharisma.inside.mandiri.sejahtera.kimsapp.R;

import java.util.List;

public class AdapterAdmin extends RecyclerView.Adapter<HolderDataAdmin> {
    private List<ModelAdmin> modelAdminList;
    private Context context;

    public AdapterAdmin(List<ModelAdmin> modelAdminList, Context context) {
        this.modelAdminList = modelAdminList;
        this.context = context;
    }

    @NonNull
    @Override
    public HolderDataAdmin onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.custom_list_admin, viewGroup, false);
        return new HolderDataAdmin(view);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull HolderDataAdmin holderDataAdmin, int i) {
        ModelAdmin modelAdmin = modelAdminList.get(i);
        holderDataAdmin.admin = modelAdmin;
        holderDataAdmin.context = context;
        holderDataAdmin.postion.setText("("+modelAdmin.getPostion()+")");
        holderDataAdmin.name.setText(modelAdmin.getName());
    }

    @Override
    public int getItemCount() {
        return modelAdminList.size();
    }
}
