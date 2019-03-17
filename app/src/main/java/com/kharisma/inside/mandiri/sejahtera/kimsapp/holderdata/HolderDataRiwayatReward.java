package com.kharisma.inside.mandiri.sejahtera.kimsapp.holderdata;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.kharisma.inside.mandiri.sejahtera.kimsapp.R;
import com.kharisma.inside.mandiri.sejahtera.kimsapp.model.ModelRiwayatReward;

public class HolderDataRiwayatReward extends RecyclerView.ViewHolder {
    public ModelRiwayatReward riwayatReward;
    public TextView txtDate, txtType, txtNominal;
    public Context context;
    public HolderDataRiwayatReward(@NonNull View itemView) {
        super(itemView);
        txtDate = itemView.findViewById(R.id.valueDate);
        txtType = itemView.findViewById(R.id.valueType);
        txtNominal = itemView.findViewById(R.id.valueNominal);
    }
}
