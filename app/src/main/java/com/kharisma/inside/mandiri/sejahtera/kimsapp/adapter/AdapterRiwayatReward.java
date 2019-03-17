package com.kharisma.inside.mandiri.sejahtera.kimsapp.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.kharisma.inside.mandiri.sejahtera.kimsapp.R;
import com.kharisma.inside.mandiri.sejahtera.kimsapp.holderdata.HolderDataRiwayatReward;
import com.kharisma.inside.mandiri.sejahtera.kimsapp.model.ModelRiwayatReward;

import java.util.List;

public class AdapterRiwayatReward extends RecyclerView.Adapter<HolderDataRiwayatReward> {
    private Context context;
    private List<ModelRiwayatReward> modelRiwayatRewardList;

    public AdapterRiwayatReward(Context context, List<ModelRiwayatReward> modelRiwayatRewardList) {
        this.context = context;
        this.modelRiwayatRewardList = modelRiwayatRewardList;
    }

    @NonNull
    @Override
    public HolderDataRiwayatReward onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.custom_list_riwayat_reward, viewGroup, false);
        return new HolderDataRiwayatReward(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HolderDataRiwayatReward holderDataRiwayatReward, int i) {
        ModelRiwayatReward modelRiwayatReward = modelRiwayatRewardList.get(i);
        holderDataRiwayatReward.txtNominal.setText(String.valueOf(modelRiwayatReward.getNominal()));
        holderDataRiwayatReward.txtType.setText(modelRiwayatReward.getJenis());
        holderDataRiwayatReward.txtDate.setText(modelRiwayatReward.getTanggal());
        holderDataRiwayatReward.context = context;
        holderDataRiwayatReward.riwayatReward = modelRiwayatReward;
    }

    @Override
    public int getItemCount() {
        return modelRiwayatRewardList.size();
    }
}
