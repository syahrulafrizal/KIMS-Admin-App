package com.kharisma.inside.mandiri.sejahtera.kimsapp.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.kharisma.inside.mandiri.sejahtera.kimsapp.holderdata.HolderDataClaim;
import com.kharisma.inside.mandiri.sejahtera.kimsapp.model.ModelClaim;
import com.kharisma.inside.mandiri.sejahtera.kimsapp.R;

import java.util.List;

public class AdapterClaim extends RecyclerView.Adapter<HolderDataClaim> {
    private Context context;
    private List<ModelClaim> modelClaimList;

    public AdapterClaim(Context context, List<ModelClaim> modelClaimList) {
        this.context = context;
        this.modelClaimList = modelClaimList;
    }

    @NonNull
    @Override
    public HolderDataClaim onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.custom_list_claim, viewGroup, false);
        return new HolderDataClaim(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HolderDataClaim holderDataClaim, int i) {
        ModelClaim modelClaim = modelClaimList.get(i);
        holderDataClaim.nama.setText(modelClaim.getNama());
        holderDataClaim.jenis.setText(modelClaim.getJenis());
        holderDataClaim.email.setText(modelClaim.getEmail());
        holderDataClaim.nominal.setText(String.valueOf(modelClaim.getNominal()));
        holderDataClaim.claim = modelClaim;
        holderDataClaim.context = context;
    }

    @Override
    public int getItemCount() {
        return modelClaimList.size();
    }
}
