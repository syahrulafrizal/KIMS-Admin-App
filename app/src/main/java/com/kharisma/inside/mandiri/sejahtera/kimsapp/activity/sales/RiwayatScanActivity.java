package com.kharisma.inside.mandiri.sejahtera.kimsapp.activity.sales;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.kharisma.inside.mandiri.sejahtera.kimsapp.R;
import com.kharisma.inside.mandiri.sejahtera.kimsapp.adapter.AdapterRiwayatReward;
import com.kharisma.inside.mandiri.sejahtera.kimsapp.adapter.AdapterRiwayatScan;
import com.kharisma.inside.mandiri.sejahtera.kimsapp.model.ModelRiwayatReward;
import com.kharisma.inside.mandiri.sejahtera.kimsapp.model.ModelRiwayatScan;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class RiwayatScanActivity extends AppCompatActivity {
    List<ModelRiwayatScan> modelScanList;
    RecyclerView listScan;
    RecyclerView.Adapter adapterScan;
    RecyclerView.LayoutManager layoutManagerScan;
    TextView toolbarDialog;
    Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_riwayat_scan);
        toolbarDialog = findViewById(R.id.textViewTitle);
        toolbarDialog.setText(getString(R.string.list_riwayat_scan));
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setHomeButtonEnabled(true);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        modelScanList = new ArrayList<>();
        listScan = findViewById(R.id.listRiwayatScan);
        layoutManagerScan = new LinearLayoutManager(this);
        listScan.setLayoutManager(layoutManagerScan);
        ModelRiwayatScan modelRiwayatScan = new ModelRiwayatScan("FZ98FDZ98HTWTJBFDYE", "17-03-2019 07:00:00");
        modelScanList.add(modelRiwayatScan);
        modelScanList.add(modelRiwayatScan);
        modelScanList.add(modelRiwayatScan);
        modelScanList.add(modelRiwayatScan);
        modelScanList.add(modelRiwayatScan);
        modelScanList.add(modelRiwayatScan);
        modelScanList.add(modelRiwayatScan);
        modelScanList.add(modelRiwayatScan);
        modelScanList.add(modelRiwayatScan);

        adapterScan = new AdapterRiwayatScan(this, modelScanList);
        listScan.setAdapter(adapterScan);
        adapterScan.notifyDataSetChanged();
        listScan.setItemAnimator(new DefaultItemAnimator());

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentListContent = new Intent();
                finish();
            }
        });
    }
}
