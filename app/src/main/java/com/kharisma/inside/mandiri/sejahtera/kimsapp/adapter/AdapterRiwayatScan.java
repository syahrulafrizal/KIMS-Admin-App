package com.kharisma.inside.mandiri.sejahtera.kimsapp.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.kharisma.inside.mandiri.sejahtera.kimsapp.R;
import com.kharisma.inside.mandiri.sejahtera.kimsapp.holderdata.HolderDataRiwayatScan;
import com.kharisma.inside.mandiri.sejahtera.kimsapp.model.ModelRiwayatScan;

import java.util.List;

public class AdapterRiwayatScan extends RecyclerView.Adapter<HolderDataRiwayatScan> {
    private Context context;
    private List<ModelRiwayatScan> modelRiwayatScanList;

    public AdapterRiwayatScan(Context context, List<ModelRiwayatScan> modelRiwayatScanList) {
        this.context = context;
        this.modelRiwayatScanList = modelRiwayatScanList;
    }

    @NonNull
    @Override
    public HolderDataRiwayatScan onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.custom_list_riwayat_scan, viewGroup, false);
        return new HolderDataRiwayatScan(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HolderDataRiwayatScan holderDataRiwayatScan, int i) {
        ModelRiwayatScan modelRiwayatScan = modelRiwayatScanList.get(i);
        holderDataRiwayatScan.txtDate.setText(modelRiwayatScan.getTanggal());
        holderDataRiwayatScan.txtQRCode.setText(modelRiwayatScan.getQrCode());
        holderDataRiwayatScan.context = context;
        holderDataRiwayatScan.riwayatScan = modelRiwayatScan;
    }

    @Override
    public int getItemCount() {
        return modelRiwayatScanList.size();
    }
}
