package com.kharisma.inside.mandiri.sejahtera.kimsapp.activity.adminlevel;

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
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.Toast;

import com.kharisma.inside.mandiri.sejahtera.kimsapp.adapter.AdapterAdmin;
import com.kharisma.inside.mandiri.sejahtera.kimsapp.model.ModelAdmin;
import com.kharisma.inside.mandiri.sejahtera.kimsapp.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class AdminLevelActivity extends AppCompatActivity implements View.OnClickListener {

    Toolbar toolbar;
    Intent intentData;
    String title;
    TextView txtTitle, toolbarDialog;
    List<ModelAdmin> modelAdminList;
    RecyclerView listAdmin;
    RecyclerView.Adapter adapterAdmin;
    RecyclerView.LayoutManager layoutManagerAdmin;
    FloatingActionButton btnAdd;
    View modalBottomSheet;
    TextView optionDetail, optionEdit, optionDelete, optionExcel, optionManual;
    BottomSheetDialog bottomSheetDialog;
    private Dialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_level);
        intentData = getIntent();

        btnAdd = findViewById(R.id.actionBtnAddAdmin);
        btnAdd.setOnClickListener(this);

        dialog = new Dialog(this);

        dialog.setContentView(R.layout.activity_add_admin);

        toolbarDialog = dialog.findViewById(R.id.textViewTitle);

        dialog.setCanceledOnTouchOutside(false);
        Objects.requireNonNull(dialog.getWindow()).getAttributes().windowAnimations = R.style.DialogTheme;
        dialog.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE);
        dialog.getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT);

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

        ModelAdmin modelAdmin1 = new ModelAdmin("Syahrul Afrizal", "Admin",
                "085200610811", "afrizalsyahrul@gmail.com");
        ModelAdmin modelAdmin2 = new ModelAdmin("Syahrul Afrizal", "Non Admin",
                "085200610811", "afrizalsyahrul@gmail.com");
        ModelAdmin modelAdmin3 = new ModelAdmin("Syahrul Afrizal", "Non Admin",
                "085200610811", "afrizalsyahrul@gmail.com");
        ModelAdmin modelAdmin4 = new ModelAdmin("Syahrul Afrizal",
                "Non Admin", "085200610811", "afrizalsyahrul@gmail.com");
        ModelAdmin modelAdmin5 = new ModelAdmin("Syahrul Afrizal", "Admin",
                "085200610811", "afrizalsyahrul@gmail.com");
        ModelAdmin modelAdmin6 = new ModelAdmin("Syahrul Afrizal", "Non Admin",
                "085200610811", "afrizalsyahrul@gmail.com");

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
        optionExcel.setOnClickListener(this);
        optionManual.setOnClickListener(this);

        switch (v.getId()){
            case R.id.textManual:
                toolbarDialog.setText(R.string.add_admin);
                dialog.show();
//                startActivity(new Intent(AdminLevelActivity.this, AddAdminActivity.class));
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
