package com.kharisma.inside.mandiri.sejahtera.kimsapp.activity.customerservice;

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

import com.kharisma.inside.mandiri.sejahtera.kimsapp.adapter.AdapterCS;
import com.kharisma.inside.mandiri.sejahtera.kimsapp.model.ModelCustomerService;
import com.kharisma.inside.mandiri.sejahtera.kimsapp.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class CustomerServiceActivity extends AppCompatActivity implements View.OnClickListener {

    Toolbar toolbar;
    Intent intentData;
    String title;
    TextView txtTitle,toolbarDialog;
    List<ModelCustomerService> modelCustomerServiceList;
    RecyclerView listCustomerService;
    RecyclerView.Adapter adapterCustomerService;
    RecyclerView.LayoutManager layoutManagerCustomerService;
    FloatingActionButton btnAdd;
    View modalBottomSheet;
    TextView optionDetail, optionEdit, optionDelete, optionExcel, optionManual;
    BottomSheetDialog bottomSheetDialog;
    private Dialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_service);
        intentData = getIntent();

        btnAdd = findViewById(R.id.actionBtnAddCS);
        btnAdd.setOnClickListener(this);

        dialog = new Dialog(this);
        dialog.setContentView(R.layout.activity_add_customer_service);
        toolbarDialog = dialog.findViewById(R.id.textViewTitle);
        dialog.setCanceledOnTouchOutside(false);
        dialog.getWindow().getAttributes().windowAnimations = R.style.DialogTheme;
        dialog.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE);
        dialog.getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT);

        modelCustomerServiceList = new ArrayList<>();
        listCustomerService = findViewById(R.id.listCS);
        layoutManagerCustomerService = new LinearLayoutManager(this);
        listCustomerService.setLayoutManager(layoutManagerCustomerService);

        title = intentData.getStringExtra("title");
        toolbar = findViewById(R.id.toolbar);
        txtTitle = findViewById(R.id.textViewTitle);
        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setHomeButtonEnabled(true);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        txtTitle.setText(title.toUpperCase());

        ModelCustomerService customerService1 = new ModelCustomerService("Yogyakarta",
                "Syahrul Afrizal", "02741211331", "085200610811");
        modelCustomerServiceList.add(customerService1);
        modelCustomerServiceList.add(customerService1);
        modelCustomerServiceList.add(customerService1);
        modelCustomerServiceList.add(customerService1);
        modelCustomerServiceList.add(customerService1);
        modelCustomerServiceList.add(customerService1);

        adapterCustomerService = new AdapterCS(modelCustomerServiceList, this);
        listCustomerService.setAdapter(adapterCustomerService);
        adapterCustomerService.notifyDataSetChanged();
        listCustomerService.setItemAnimator(new DefaultItemAnimator());

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
        toolbarDialog.setText(R.string.add_customer_service);
        dialog.show();
//        startActivity(new Intent(CustomerServiceActivity.this, AddCustomerServiceActivity.class));
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
