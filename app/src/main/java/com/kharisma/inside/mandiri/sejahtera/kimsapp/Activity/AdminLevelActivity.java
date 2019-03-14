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

import com.kharisma.inside.mandiri.sejahtera.kimsapp.Adapter.AdapterAdmin;
import com.kharisma.inside.mandiri.sejahtera.kimsapp.Adapter.AdapterProduct;
import com.kharisma.inside.mandiri.sejahtera.kimsapp.Model.ModelAdmin;
import com.kharisma.inside.mandiri.sejahtera.kimsapp.Model.ModelProduct;
import com.kharisma.inside.mandiri.sejahtera.kimsapp.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class AdminLevelActivity extends AppCompatActivity implements View.OnClickListener {

    Toolbar toolbar;
    Intent intentData;
    String title;
    TextView txtTitle;
    List<ModelAdmin> modelAdminList;
    RecyclerView listAdmin;
    RecyclerView.Adapter adapterAdmin;
    RecyclerView.LayoutManager layoutManagerAdmin;
    FloatingActionButton btnAdd;
    View modalBottomSheet;
    TextView optionDetail, optionEdit, optionDelete, optionExcel, optionManual;
    BottomSheetDialog bottomSheetDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_level);
        intentData = getIntent();

        btnAdd = findViewById(R.id.actionBtnAddAdmin);
        btnAdd.setOnClickListener(this);

        modelAdminList = new ArrayList<>();
        listAdmin = findViewById(R.id.listAdmin);
        layoutManagerAdmin = new LinearLayoutManager(this);
        listAdmin.setLayoutManager(layoutManagerAdmin);

        title = intentData.getStringExtra("title");
        toolbar = findViewById(R.id.toolbar);
        txtTitle = findViewById(R.id.textViewTitle);
        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setHomeButtonEnabled(true);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        txtTitle.setText(title.toUpperCase());

        ModelAdmin modelAdmin1 = new ModelAdmin("Syahrul Afrizal", "Admin");
        ModelAdmin modelAdmin2 = new ModelAdmin("Syahrul Afrizal", "Non Admin");
        ModelAdmin modelAdmin3 = new ModelAdmin("Syahrul Afrizal", "Non Admin");
        ModelAdmin modelAdmin4 = new ModelAdmin("Syahrul Afrizal", "Non Admin");
        ModelAdmin modelAdmin5 = new ModelAdmin("Syahrul Afrizal", "Admin");
        ModelAdmin modelAdmin6 = new ModelAdmin("Syahrul Afrizal", "Non Admin");

        modelAdminList.add(modelAdmin1);
        modelAdminList.add(modelAdmin2);
        modelAdminList.add(modelAdmin3);
        modelAdminList.add(modelAdmin4);
        modelAdminList.add(modelAdmin5);
        modelAdminList.add(modelAdmin6);

        adapterAdmin = new AdapterAdmin(modelAdminList, this);
        listAdmin.setAdapter(adapterAdmin);
        adapterAdmin.notifyDataSetChanged();
        listAdmin.setItemAnimator(new DefaultItemAnimator());

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
