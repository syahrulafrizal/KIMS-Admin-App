package com.kharisma.inside.mandiri.sejahtera.kimsapp.activity.sales;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.kharisma.inside.mandiri.sejahtera.kimsapp.R;
import com.kharisma.inside.mandiri.sejahtera.kimsapp.adapter.AdapterRiwayatReward;
import com.kharisma.inside.mandiri.sejahtera.kimsapp.model.ModelRiwayatReward;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class RiwayatRewardAcivity extends AppCompatActivity {
    List<ModelRiwayatReward> modelRewardList;
    RecyclerView listReward;
    RecyclerView.Adapter adapterReward;
    RecyclerView.LayoutManager layoutManagerReward;
    TextView toolbarDialog;
    Toolbar toolbar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_riwayat_reward);
        toolbarDialog = findViewById(R.id.textViewTitle);
        toolbarDialog.setText(R.string.list_riawayt_reward);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setHomeButtonEnabled(true);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        modelRewardList = new ArrayList<>();
        listReward = findViewById(R.id.listRiwayatReward);
        layoutManagerReward = new LinearLayoutManager(this);
        listReward.setLayoutManager(layoutManagerReward);
        ModelRiwayatReward modelRiwayatReward = new ModelRiwayatReward("Pulsa", "17-03-2019 07:00:00", 100000);
        modelRewardList.add(modelRiwayatReward);
        modelRewardList.add(modelRiwayatReward);
        modelRewardList.add(modelRiwayatReward);
        modelRewardList.add(modelRiwayatReward);
        modelRewardList.add(modelRiwayatReward);
        modelRewardList.add(modelRiwayatReward);
        modelRewardList.add(modelRiwayatReward);
        modelRewardList.add(modelRiwayatReward);
        modelRewardList.add(modelRiwayatReward);

        adapterReward = new AdapterRiwayatReward(this, modelRewardList);
        listReward.setAdapter(adapterReward);
        adapterReward.notifyDataSetChanged();
        listReward.setItemAnimator(new DefaultItemAnimator());

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentListContent = new Intent();
                finish();
            }
        });
    }
}
