package com.kharisma.inside.mandiri.sejahtera.kimsapp.activity.faq;

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

import com.kharisma.inside.mandiri.sejahtera.kimsapp.adapter.AdapterFAQ;
import com.kharisma.inside.mandiri.sejahtera.kimsapp.model.ModelFAQ;
import com.kharisma.inside.mandiri.sejahtera.kimsapp.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class FAQActivity extends AppCompatActivity implements View.OnClickListener {

    Toolbar toolbar;
    Intent intentData;
    String title;
    TextView txtTitle;
    List<ModelFAQ> modelFAQList;
    RecyclerView listFAQ;
    RecyclerView.Adapter adapterFAQ;
    RecyclerView.LayoutManager layoutManagerFAQ;
    FloatingActionButton btnAdd;
    View modalBottomSheet;
    TextView optionDetail, optionEdit, optionDelete, optionExcel, optionManual;
    BottomSheetDialog bottomSheetDialog;
    private Dialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_faq);
        intentData = getIntent();

        btnAdd = findViewById(R.id.actionBtnAddFAQ);
        btnAdd.setOnClickListener(this);

        dialog = new Dialog(this);
        dialog.setContentView(R.layout.activity_add_faq);
        dialog.setCanceledOnTouchOutside(false);
        dialog.getWindow().getAttributes().windowAnimations = R.style.DialogTheme;
        dialog.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE);
        dialog.getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT);

        modelFAQList = new ArrayList<>();
        listFAQ = findViewById(R.id.listFAQ);
        layoutManagerFAQ = new LinearLayoutManager(this);
        listFAQ.setLayoutManager(layoutManagerFAQ);

        title = intentData.getStringExtra("title");
        toolbar = findViewById(R.id.toolbar);
        txtTitle = findViewById(R.id.textViewTitle);
        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setHomeButtonEnabled(true);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        txtTitle.setText(title.toUpperCase());

        ModelFAQ modelFAQ1 = new ModelFAQ("How To Using KIMS App 1", "Lorem Ipsum is " +
                "simply dummy text of the printing and typesetting industry. Lorem Ipsum has been " +
                "the industry's standard dummy text ever since the 1500s, when an unknown printer " +
                "took a galley of type and scrambled it to make a type specimen book. It has survived");

        ModelFAQ modelFAQ2 = new ModelFAQ("How To Using KIMS App 2", "Lorem Ipsum is " +
                "simply dummy text of the printing and typesetting industry. Lorem Ipsum has been " +
                "the industry's standard dummy text ever since the 1500s, when an unknown printer " +
                "took a galley of type and scrambled it to make a type specimen book. It has survived");

        ModelFAQ modelFAQ3 = new ModelFAQ("How To Using KIMS App 3", "Lorem Ipsum is " +
                "simply dummy text of the printing and typesetting industry. Lorem Ipsum has been " +
                "the industry's standard dummy text ever since the 1500s, when an unknown printer " +
                "took a galley of type and scrambled it to make a type specimen book. It has survived");

        ModelFAQ modelFAQ4 = new ModelFAQ("How To Using KIMS App 4", "Lorem Ipsum is " +
                "simply dummy text of the printing and typesetting industry. Lorem Ipsum has been " +
                "the industry's standard dummy text ever since the 1500s, when an unknown printer " +
                "took a galley of type and scrambled it to make a type specimen book. It has survived");

        ModelFAQ modelFAQ5 = new ModelFAQ("How To Using KIMS App 5", "Lorem Ipsum is " +
                "simply dummy text of the printing and typesetting industry. Lorem Ipsum has been " +
                "the industry's standard dummy text ever since the 1500s, when an unknown printer " +
                "took a galley of type and scrambled it to make a type specimen book. It has survived");

        modelFAQList.add(modelFAQ1);
        modelFAQList.add(modelFAQ2);
        modelFAQList.add(modelFAQ3);
        modelFAQList.add(modelFAQ4);
        modelFAQList.add(modelFAQ5);

        adapterFAQ = new AdapterFAQ(listFAQ, modelFAQList, this);
        listFAQ.setAdapter(adapterFAQ);
        adapterFAQ.notifyDataSetChanged();
        listFAQ.setItemAnimator(new DefaultItemAnimator());

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
        dialog.show();
//        startActivity(new Intent(FAQActivity.this, AddFAQActivity.class));
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
