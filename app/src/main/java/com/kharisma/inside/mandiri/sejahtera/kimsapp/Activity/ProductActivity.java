package com.kharisma.inside.mandiri.sejahtera.kimsapp.Activity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.design.widget.BottomSheetDialog;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.kharisma.inside.mandiri.sejahtera.kimsapp.Adapter.AdapterMenu;
import com.kharisma.inside.mandiri.sejahtera.kimsapp.Adapter.AdapterProduct;
import com.kharisma.inside.mandiri.sejahtera.kimsapp.Model.ModelProduct;
import com.kharisma.inside.mandiri.sejahtera.kimsapp.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ProductActivity extends AppCompatActivity implements View.OnClickListener {

    Toolbar toolbar;
    Intent intentData;
    String title;
    TextView txtTitle;
    List<ModelProduct> modelProducts;
    RecyclerView listProducts;
    RecyclerView.Adapter adapterProducts;
    RecyclerView.LayoutManager layoutManagerProducts;
    FloatingActionButton btnAdd;
    View modalBottomSheet;
    TextView optionDetail, optionEdit, optionDelete, optionExcel, optionManual;
    BottomSheetDialog bottomSheetDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);
        intentData = getIntent();

        btnAdd = findViewById(R.id.actionBtnAddProduct);
        btnAdd.setOnClickListener(this);

        modelProducts = new ArrayList<>();
        listProducts = findViewById(R.id.listProducts);
        layoutManagerProducts = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        listProducts.setLayoutManager(layoutManagerProducts);

        title = intentData.getStringExtra("title");
        toolbar = findViewById(R.id.toolbar);
        txtTitle = findViewById(R.id.textViewTitle);
        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setHomeButtonEnabled(true);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        txtTitle.setText(title.toUpperCase());

        ModelProduct modelProduct1 = new ModelProduct("SNP1", "Product Name One",
                "", "Belum Discan", 1, R.drawable.mcafee_logo_2);
        ModelProduct modelProduct7 = new ModelProduct("SNP7", "Product Name Seven",
                "Claimer Two", "Sudah Discan", 1, R.drawable.mcafee_logo_3);
        ModelProduct modelProduct3 = new ModelProduct("SNP3", "Product Name Three",
                "", "Belum Discan", 1, R.drawable.mcafee_logo_4);
        ModelProduct modelProduct4 = new ModelProduct("SNP4", "Product Name Four",
                "", "Belum Discan", 1, R.drawable.mcafee_logo_4);
        ModelProduct modelProduct10 = new ModelProduct("SNP610", "Product Name Ten",
                "Claimer Five", "Sudah Discan", 1, R.drawable.mcafee_logo_2);
        ModelProduct modelProduct5 = new ModelProduct("SNP5", "Product Name Five",
                "", "Belum Discan", 1, R.drawable.mcafee_logo_2);
        ModelProduct modelProduct6 = new ModelProduct("SNP6", "Product Name Six",
                "Claimer One", "Sudah Discan", 1, R.drawable.mcafee_logo_3);
        ModelProduct modelProduct8 = new ModelProduct("SNP8", "Product Name Eight",
                "Claimer Three", "Sudah Discan", 1, R.drawable.mcafee_logo_4);
        ModelProduct modelProduct9 = new ModelProduct("SNP9", "Product Name Nine",
                "Claimer Four", "Sudah Discan", 1, R.drawable.mcafee_logo_2);
        ModelProduct modelProduct2 = new ModelProduct("SNP2", "Product Name Two",
                "", "Belum Discan", 1, R.drawable.mcafee_logo_3);

        modelProducts.add(modelProduct10);
        modelProducts.add(modelProduct1);
        modelProducts.add(modelProduct7);
        modelProducts.add(modelProduct6);
        modelProducts.add(modelProduct4);
        modelProducts.add(modelProduct8);
        modelProducts.add(modelProduct3);
        modelProducts.add(modelProduct5);
        modelProducts.add(modelProduct9);
        modelProducts.add(modelProduct2);

        adapterProducts = new AdapterProduct(this, modelProducts);
        listProducts.setAdapter(adapterProducts);
        adapterProducts.notifyDataSetChanged();
        listProducts.setItemAnimator(new DefaultItemAnimator());

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentListContent = new Intent();
                finish();
            }
        });
    }

    @SuppressLint("InflateParams")
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
