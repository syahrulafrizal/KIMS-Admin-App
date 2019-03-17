package com.kharisma.inside.mandiri.sejahtera.kimsapp.activity.product;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Intent;
import android.support.design.widget.BottomSheetDialog;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.Toast;

import com.kharisma.inside.mandiri.sejahtera.kimsapp.adapter.AdapterProduct;
import com.kharisma.inside.mandiri.sejahtera.kimsapp.model.ModelProduct;
import com.kharisma.inside.mandiri.sejahtera.kimsapp.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ProductActivity extends AppCompatActivity implements View.OnClickListener {

    Toolbar toolbar;
    Intent intentData;
    String title;
    TextView txtTitle, toolbarDialod;
    List<ModelProduct> modelProducts;
    RecyclerView listProducts;
    RecyclerView.Adapter adapterProducts;
    RecyclerView.LayoutManager layoutManagerProducts;
    FloatingActionButton btnAdd;
    View modalBottomSheet;
    TextView optionDetail, optionEdit, optionDelete, optionExcel, optionManual;
    BottomSheetDialog bottomSheetDialog;
    private Dialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);
        intentData = getIntent();

        dialog = new Dialog(this);
        dialog.setContentView(R.layout.activity_add_product);
        toolbarDialod = dialog.findViewById(R.id.textViewTitle);
        dialog.setCanceledOnTouchOutside(false);
        dialog.getWindow().getAttributes().windowAnimations = R.style.DialogTheme;
        dialog.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE);
        dialog.getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT);

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
                "", "Belum Discan", "AS688DB2BB2BHH", 1, R.drawable.mcafee_logo_2);
        ModelProduct modelProduct7 = new ModelProduct("SNP7", "Product Name Seven",
                "Claimer Two", "Sudah Discan", "02863TGW88DB2BB2BHH", 1, R.drawable.mcafee_logo_3);
        ModelProduct modelProduct3 = new ModelProduct("SNP3", "Product Name Three",
                "", "Belum Discan", "DSADJS78GB3QBB", 1, R.drawable.mcafee_logo_4);
        ModelProduct modelProduct4 = new ModelProduct("SNP4", "Product Name Four",
                "", "Belum Discan", "KJFDHFDFDSKB5443", 1, R.drawable.mcafee_logo_4);
        ModelProduct modelProduct10 = new ModelProduct("SNP610", "Product Name Ten",
                "Claimer Five", "Sudah Discan", "8D97FD978FDS9&fDS978F", 1, R.drawable.mcafee_logo_2);
        ModelProduct modelProduct5 = new ModelProduct("SNP5", "Product Name Five",
                "", "Belum Discan", "3232FDFGSGR65", 1, R.drawable.mcafee_logo_2);
        ModelProduct modelProduct6 = new ModelProduct("SNP6", "Product Name Six",
                "Claimer One", "Sudah Discan", "541FEAQ3A4QT", 1, R.drawable.mcafee_logo_3);
        ModelProduct modelProduct8 = new ModelProduct("SNP8", "Product Name Eight",
                "Claimer Three", "Sudah Discan", "54V5TV4RE434TV ", 1, R.drawable.mcafee_logo_4);
        ModelProduct modelProduct9 = new ModelProduct("SNP9", "Product Name Nine",
                "Claimer Four", "Sudah Discan", "FG365QRTAE4TV2", 1, R.drawable.mcafee_logo_2);
        ModelProduct modelProduct2 = new ModelProduct("SNP2", "Product Name Two",
                "", "Belum Discan", "FFD5EFT4WET32", 1, R.drawable.mcafee_logo_3);

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
        optionExcel.setOnClickListener(this);
        optionManual.setOnClickListener(this);

        switch (v.getId()){
            case R.id.textManual:
                toolbarDialod.setText(R.string.add_product);
                dialog.show();
//                startActivity(new Intent(ProductActivity.this, AddProductActivity.class));
//                overridePendingTransition(R.anim.intent_in, R.anim.intent_out);
                bottomSheetDialog.dismiss();
                break;

            case R.id.textExcel:
                Toast.makeText(this, "Excel", Toast.LENGTH_SHORT).show();
                bottomSheetDialog.dismiss();
                break;

            default:
                bottomSheetDialog.setContentView(modalBottomSheet);
                bottomSheetDialog.show();
        }
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
