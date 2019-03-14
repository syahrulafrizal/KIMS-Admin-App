package com.kharisma.inside.mandiri.sejahtera.kimsapp.Activity;

import android.content.Intent;
import android.support.design.widget.BottomSheetDialog;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.kharisma.inside.mandiri.sejahtera.kimsapp.Adapter.AdapterProduct;
import com.kharisma.inside.mandiri.sejahtera.kimsapp.Adapter.AdapterStore;
import com.kharisma.inside.mandiri.sejahtera.kimsapp.Model.ModelProduct;
import com.kharisma.inside.mandiri.sejahtera.kimsapp.Model.ModelStore;
import com.kharisma.inside.mandiri.sejahtera.kimsapp.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class StoreActivity extends AppCompatActivity implements View.OnClickListener {

    Toolbar toolbar;
    Intent intentData;
    String title;
    TextView txtTitle;
    List<ModelStore> modelStores;
    RecyclerView listStores;
    RecyclerView.Adapter adapterStores;
    RecyclerView.LayoutManager layoutManagerStores;
    FloatingActionButton btnAdd;
    View modalBottomSheet;
    TextView optionDetail, optionEdit, optionDelete, optionExcel, optionManual;
    BottomSheetDialog bottomSheetDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_store);
        intentData = getIntent();

        btnAdd = findViewById(R.id.actionBtnAddStore);
        btnAdd.setOnClickListener(this);

        modelStores = new ArrayList<>();
        listStores = findViewById(R.id.listStores);
        layoutManagerStores = new LinearLayoutManager(this);
        listStores.setLayoutManager(layoutManagerStores);

        title = intentData.getStringExtra("title");
        toolbar = findViewById(R.id.toolbar);
        txtTitle = findViewById(R.id.textViewTitle);
        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setHomeButtonEnabled(true);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        txtTitle.setText(title.toUpperCase());

        ModelStore modelStore1 = new ModelStore("AN'S COMPUTER", "Jl. P Suryanegara No. 120, Cirebon",
                "08123456789", "Cirebon");
        ModelStore modelStore2 = new ModelStore("INDEPENDENT COMPUTER", "Ramai Mall Lt. 2 Blok C5",
                "08123457111", "Jakarta");
        ModelStore modelStore3 = new ModelStore("ALJABAR", "Perumahan Indah Magorejo B7/14",
                "08129756789", "Sleman");
        ModelStore modelStore4 = new ModelStore("ATM COMP", "Jl. Purnawarman No. 13-15",
                "08123456789", "Bandung");
        ModelStore modelStore5 = new ModelStore("COC COMPUTER", "Mangga Dua Mall Blok C No 228",
                "08123126789", "Jakarta");
        ModelStore modelStore6 = new ModelStore("SPRINT COMPUTER", "Jl. Kancil No. 140 Cikarang Bekasi",
                "08123456232", "Bekasi");
        ModelStore modelStore7 = new ModelStore("CHALLENGER", "Jl. Jendral Sudirman",
                "08567456789", "Jakarta");
        ModelStore modelStore8 = new ModelStore("BERLIAN COMPUTER", "Kalisari 3 No. 15B, Surabaya",
                "08233456789", "Surabaya");
        ModelStore modelStore9 = new ModelStore("PELANGI COMPUTER", "Hitech Mall Lt Dasar Blok D No. 25, Surabaya",
                "08223456789", "Surabaya");
        ModelStore modelStore10 = new ModelStore("BEC", "Jl. Purnawarman",
                "08123456789", "Bandung");

        modelStores.add(modelStore1);
        modelStores.add(modelStore2);
        modelStores.add(modelStore3);
        modelStores.add(modelStore4);
        modelStores.add(modelStore5);
        modelStores.add(modelStore6);
        modelStores.add(modelStore7);
        modelStores.add(modelStore8);
        modelStores.add(modelStore9);
        modelStores.add(modelStore10);

        adapterStores = new AdapterStore(this, modelStores);
        listStores.setAdapter(adapterStores);
        adapterStores.notifyDataSetChanged();
        listStores.setItemAnimator(new DefaultItemAnimator());

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
