package com.kharisma.inside.mandiri.sejahtera.kimsapp.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.kharisma.inside.mandiri.sejahtera.kimsapp.Adapter.AdapterProduct;
import com.kharisma.inside.mandiri.sejahtera.kimsapp.Adapter.AdapterSales;
import com.kharisma.inside.mandiri.sejahtera.kimsapp.Model.ModelSales;
import com.kharisma.inside.mandiri.sejahtera.kimsapp.Model.ModelStore;
import com.kharisma.inside.mandiri.sejahtera.kimsapp.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class SalesActivity extends AppCompatActivity {

    Toolbar toolbar;
    Intent intentData;
    String title;
    TextView txtTitle;
    List<ModelSales> modelSalesList;
    RecyclerView listSalaes;
    RecyclerView.Adapter adapterSales;
    RecyclerView.LayoutManager layoutManagerSales;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sales);
        intentData = getIntent();

        modelSalesList = new ArrayList<>();
        listSalaes = findViewById(R.id.listSales);
        layoutManagerSales = new LinearLayoutManager(this);
        listSalaes.setLayoutManager(layoutManagerSales);

        title = intentData.getStringExtra("title");
        toolbar = findViewById(R.id.toolbar);
        txtTitle = findViewById(R.id.textViewTitle);
        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setHomeButtonEnabled(true);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        txtTitle.setText(title.toUpperCase());

        ModelSales modelSales1 = new ModelSales("Syahrul Afrizal",
                "afrizalsyahrul@gmail.com", "085200610811");
        ModelSales modelSales2 = new ModelSales("Lalu Hilmy Fadli",
                "Hilmy@gmail.com", "085543510811");
        ModelSales modelSales3 = new ModelSales("M. Fairul Adnan",
                "Fairul@gmail.com", "085634563256");
        ModelSales modelSales4 = new ModelSales("Deri Selamet",
                "Selamet@gmail.com", "085200610811");
        ModelSales modelSales5 = new ModelSales("Gery Muhammad",
                "Gery@gmail.com", "085200612432");
        ModelSales modelSales6 = new ModelSales("Desi Rindiastuti",
                "Rindiastuti@gmail.com", "083245350811");
        ModelSales modelSales7 = new ModelSales("Tsani Elvia Nita",
                "Tsani@gmail.com", "085200124657");
        ModelSales modelSales8 = new ModelSales("Jodi Darso",
                "Jodi@gmail.com", "085200610000");
        ModelSales modelSales9 = new ModelSales("Selamet Riyadi",
                "Riyadi@gmail.com", "085200143251");
        ModelSales modelSales10 = new ModelSales("Nur Maulana Indah",
                "Maulana@gmail.com", "082244610811");

        modelSalesList.add(modelSales1);
        modelSalesList.add(modelSales2);
        modelSalesList.add(modelSales3);
        modelSalesList.add(modelSales4);
        modelSalesList.add(modelSales5);
        modelSalesList.add(modelSales6);
        modelSalesList.add(modelSales7);
        modelSalesList.add(modelSales8);
        modelSalesList.add(modelSales9);
        modelSalesList.add(modelSales10);

        adapterSales = new AdapterSales(this, modelSalesList);
        listSalaes.setAdapter(adapterSales);
        adapterSales.notifyDataSetChanged();
        listSalaes.setItemAnimator(new DefaultItemAnimator());

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentListContent = new Intent();
                finish();
            }
        });
    }
}
