package com.kharisma.inside.mandiri.sejahtera.kimsapp.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.kharisma.inside.mandiri.sejahtera.kimsapp.HolderData.HolderDataStore;
import com.kharisma.inside.mandiri.sejahtera.kimsapp.Model.ModelStore;
import com.kharisma.inside.mandiri.sejahtera.kimsapp.R;

import java.util.List;

public class AdapterStore extends RecyclerView.Adapter<HolderDataStore> {
    private Context context;
    private List<ModelStore> modelStoreList;

    public AdapterStore(Context context, List<ModelStore> modelStoreList) {
        this.context = context;
        this.modelStoreList = modelStoreList;
    }

    @NonNull
    @Override
    public HolderDataStore onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.custom_list_store, viewGroup, false);
        return new HolderDataStore(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HolderDataStore holderDataStore, int i) {
        ModelStore modelStore = modelStoreList.get(i);
        holderDataStore.valStoreName.setText(modelStore.getStoreName());
        holderDataStore.valPhone.setText(modelStore.getStorePhone());
        holderDataStore.valArea.setText(modelStore.getStoreArea());
        holderDataStore.valAddress.setText(modelStore.getStroreAddress());
        holderDataStore.context = context;
        holderDataStore.store = modelStore;
    }

    @Override
    public int getItemCount() {
        return modelStoreList.size();
    }
}
