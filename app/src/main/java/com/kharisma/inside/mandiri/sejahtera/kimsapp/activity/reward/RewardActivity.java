package com.kharisma.inside.mandiri.sejahtera.kimsapp.activity.reward;

import android.app.Dialog;
import android.content.Intent;
import android.support.design.widget.BottomSheetDialog;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;

import com.kharisma.inside.mandiri.sejahtera.kimsapp.adapter.AdapterReward;
import com.kharisma.inside.mandiri.sejahtera.kimsapp.model.ModelReward;
import com.kharisma.inside.mandiri.sejahtera.kimsapp.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class RewardActivity extends AppCompatActivity implements View.OnClickListener {

    Toolbar toolbar;
    Intent intentData;
    String title;
    TextView txtTitle, toolbarDialog;
    List<ModelReward> modelRewardList;
    RecyclerView listReward;
    RecyclerView.Adapter adapterReward;
    RecyclerView.LayoutManager layoutManagerReward;
    FloatingActionButton btnAdd;
    View modalBottomSheet;
    TextView optionDetail, optionEdit, optionDelete, optionExcel, optionManual;
    BottomSheetDialog bottomSheetDialog;
    private Dialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reward);
        intentData = getIntent();

        btnAdd = findViewById(R.id.actionBtnAddReward);
        btnAdd.setOnClickListener(this);

        dialog = new Dialog(this);
        dialog.setContentView(R.layout.activity_add_reward);
        toolbarDialog = dialog.findViewById(R.id.textViewTitle);
        dialog.setCanceledOnTouchOutside(false);
        dialog.getWindow().getAttributes().windowAnimations = R.style.DialogTheme;
        dialog.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE);
        dialog.getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT);

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

        ModelReward modelReward1 = new ModelReward(100000, "Cash", 2);
        ModelReward modelReward2 = new ModelReward(50000, "Pulsa", 1);
        ModelReward modelReward3 = new ModelReward(100000, "Pulsa", 2);
        ModelReward modelReward4 = new ModelReward(5000000, "Cash", 2);
        ModelReward modelReward5 = new ModelReward(150000, "Pulsa", 2);
        ModelReward modelReward6 = new ModelReward(50000, "Cash", 2);
        ModelReward modelReward7 = new ModelReward(1000000, "Cash", 2);
        ModelReward modelReward8 = new ModelReward(500000, "Pulsa", 8);
        ModelReward modelReward9 = new ModelReward(250000, "Cash", 2);
        ModelReward modelReward10 = new ModelReward(100000, "Pulsa", 7);

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
//        modalBottomSheet = LayoutInflater.from(this).inflate(R.layout.option_list, null);
//        bottomSheetDialog = new BottomSheetDialog(this);
//
//        optionEdit = modalBottomSheet.findViewById(R.id.textEdit);
//        optionDetail = modalBottomSheet.findViewById(R.id.textDetail);
//        optionDelete = modalBottomSheet.findViewById(R.id.textDelete);
//        optionExcel = modalBottomSheet.findViewById(R.id.textExcel);
//        optionManual = modalBottomSheet.findViewById(R.id.textManual);
//
//        optionExcel.setVisibility(View.VISIBLE);
//        optionManual.setVisibility(View.VISIBLE);
//
//        bottomSheetDialog.setContentView(modalBottomSheet);
//        bottomSheetDialog.show();
        toolbarDialog.setText(R.string.add_reward);
        dialog.show();
//        startActivity(new Intent(RewardActivity.this, AddRewardActivity.class));
//        overridePendingTransition(R.anim.intent_in, R.anim.intent_out);
    }
    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    protected void onStop() {
        super.onStop();
//        dialog.dismiss();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
    }
}
