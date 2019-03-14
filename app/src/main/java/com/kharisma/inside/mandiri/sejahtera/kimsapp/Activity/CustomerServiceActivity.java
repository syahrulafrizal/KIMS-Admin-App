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

import com.kharisma.inside.mandiri.sejahtera.kimsapp.Adapter.AdapterCS;
import com.kharisma.inside.mandiri.sejahtera.kimsapp.Adapter.AdapterProduct;
import com.kharisma.inside.mandiri.sejahtera.kimsapp.Model.ModelCustomerService;
import com.kharisma.inside.mandiri.sejahtera.kimsapp.Model.ModelProduct;
import com.kharisma.inside.mandiri.sejahtera.kimsapp.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class CustomerServiceActivity extends AppCompatActivity implements View.OnClickListener {

    Toolbar toolbar;
    Intent intentData;
    String title;
    TextView txtTitle;
    List<ModelCustomerService> modelCustomerServiceList;
    RecyclerView listCustomerService;
    RecyclerView.Adapter adapterCustomerService;
    RecyclerView.LayoutManager layoutManagerCustomerService;
    FloatingActionButton btnAdd;
    View modalBottomSheet;
    TextView optionDetail, optionEdit, optionDelete, optionExcel, optionManual;
    BottomSheetDialog bottomSheetDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_service);
        intentData = getIntent();

        btnAdd = findViewById(R.id.actionBtnAddCS);
        btnAdd.setOnClickListener(this);

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
                "085200610811 (Syahrul)", "02741211331");
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
