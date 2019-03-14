package com.kharisma.inside.mandiri.sejahtera.kimsapp.Activity;

import android.content.Intent;
import android.support.design.widget.BottomSheetDialog;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.kharisma.inside.mandiri.sejahtera.kimsapp.Adapter.AdapterProduct;
import com.kharisma.inside.mandiri.sejahtera.kimsapp.Adapter.AdapterReward;
import com.kharisma.inside.mandiri.sejahtera.kimsapp.Model.ModelProduct;
import com.kharisma.inside.mandiri.sejahtera.kimsapp.Model.ModelReward;
import com.kharisma.inside.mandiri.sejahtera.kimsapp.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class RewardActivity extends AppCompatActivity implements View.OnClickListener {

    Toolbar toolbar;
    Intent intentData;
    String title;
    TextView txtTitle;
    List<ModelReward> modelRewardList;
    RecyclerView listReward;
    RecyclerView.Adapter adapterReward;
    RecyclerView.LayoutManager layoutManagerReward;
    FloatingActionButton btnAdd;
    View modalBottomSheet;
    TextView optionDetail, optionEdit, optionDelete, optionExcel, optionManual;
    BottomSheetDialog bottomSheetDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reward);
        intentData = getIntent();

        btnAdd = findViewById(R.id.actionBtnAddReward);
        btnAdd.setOnClickListener(this);

        modelRewardList = new ArrayList<>();
        listReward = findViewById(R.id.listReward);
        layoutManagerReward = new LinearLayoutManager(this);
        listReward.setLayoutManager(layoutManagerReward);

        title = intentData.getStringExtra("title");
        toolbar = findViewById(R.id.toolbar);
        txtTitle = findViewById(R.id.textViewTitle);
        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setHomeButtonEnabled(true);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        txtTitle.setText(title.toUpperCase());

        ModelReward modelReward1 = new ModelReward("Reward One", "Cash", 2);
        ModelReward modelReward2 = new ModelReward("Reward Two", "Pulsa", 1);
        ModelReward modelReward3 = new ModelReward("Reward Three", "Pulsa", 2);
        ModelReward modelReward4 = new ModelReward("Reward Four", "Cash", 2);
        ModelReward modelReward5 = new ModelReward("Reward Five", "Pulsa", 2);
        ModelReward modelReward6 = new ModelReward("Reward Six", "Cash", 2);
        ModelReward modelReward7 = new ModelReward("Reward Seven", "Cash", 2);
        ModelReward modelReward8 = new ModelReward("Reward Eight", "Pulsa", 8);
        ModelReward modelReward9 = new ModelReward("Reward Nine", "Cash", 2);
        ModelReward modelReward10 = new ModelReward("Reward Ten", "Pulsa", 7);

        modelRewardList.add(modelReward1);
        modelRewardList.add(modelReward2);
        modelRewardList.add(modelReward3);
        modelRewardList.add(modelReward4);
        modelRewardList.add(modelReward5);
        modelRewardList.add(modelReward6);
        modelRewardList.add(modelReward7);
        modelRewardList.add(modelReward8);
        modelRewardList.add(modelReward9);
        modelRewardList.add(modelReward10);

        adapterReward = new AdapterReward(modelRewardList, this);
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

    @Override
    public void onClick(View v) {
        modalBottomSheet = LayoutInflater.from(this).inflate(R.layout.option_list, null);
        bottomSheetDialog = new BottomSheetDialog(this);

        optionEdit = modalBottomSheet.findViewById(R.id.textEdit);
        optionDetail = modalBottomSheet.findViewById(R.id.textDetail);
        optionDelete = modalBottomSheet.findViewById(R.id.textDelete);
        optionExcel = modalBottomSheet.findViewById(R.id.textExcel);
        optionManual = modalBottomSheet.findViewById(R.id.textManual);

        optionExcel.setVisibility(View.VISIBLE);
        optionManual.setVisibility(View.VISIBLE);

        bottomSheetDialog.setContentView(modalBottomSheet);
        bottomSheetDialog.show();
    }
}
