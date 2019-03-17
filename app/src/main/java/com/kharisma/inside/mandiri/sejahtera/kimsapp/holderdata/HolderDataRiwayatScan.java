package com.kharisma.inside.mandiri.sejahtera.kimsapp.holderdata;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.kharisma.inside.mandiri.sejahtera.kimsapp.R;
import com.kharisma.inside.mandiri.sejahtera.kimsapp.model.ModelRiwayatScan;

public class HolderDataRiwayatScan extends RecyclerView.ViewHolder {
    public ModelRiwayatScan riwayatScan;
    public Context context;
    public TextView txtDate, txtQRCode;
    public HolderDataRiwayatScan(@NonNull View itemView) {
        super(itemView);
        txtDate = itemView.findViewById(R.id.txtDate);
        txtQRCode = itemView.findViewById(R.id.valueQrCode);
    }
}
