package com.kharisma.inside.mandiri.sejahtera.kimsapp.activity.store;

import android.app.Dialog;
import android.content.Intent;
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

import com.kharisma.inside.mandiri.sejahtera.kimsapp.adapter.AdapterStore;
import com.kharisma.inside.mandiri.sejahtera.kimsapp.model.ModelStore;
import com.kharisma.inside.mandiri.sejahtera.kimsapp.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class StoreActivity extends AppCompatActivity implements View.OnClickListener {

    Toolbar toolbar;
    Intent intentData;
    String title;
    TextView txtTitle, toolbaDialog;
    List<ModelStore> modelStores;
    RecyclerView listStores;
    RecyclerView.Adapter adapterStores;
    RecyclerView.LayoutManager layoutManagerStores;
    FloatingActionButton btnAdd;
    private Dialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_store);
        intentData = getIntent();

        btnAdd = findViewById(R.id.actionBtnAddStore);
        btnAdd.setOnClickListener(this);

        dialog = new Dialog(this);
        dialog.setContentView(R.layout.activity_add_store);
        toolbaDialog = dialog.findViewById(R.id.textViewTitle);
        dialog.setCanceledOnTouchOutside(false);
        dialog.getWindow().getAttributes().windowAnimations = R.style.DialogTheme;
        dialog.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE);
        dialog.getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT);

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
        toolbaDialog.setText(R.string.add_store);
        dialog.show();
//        startActivity(new Intent(StoreActivity.this, AddStoreActivity.class));
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
