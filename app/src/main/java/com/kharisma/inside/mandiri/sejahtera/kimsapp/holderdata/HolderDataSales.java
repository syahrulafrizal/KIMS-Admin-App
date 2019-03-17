package com.kharisma.inside.mandiri.sejahtera.kimsapp.holderdata;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomSheetDialog;
import android.support.design.widget.TextInputEditText;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.Toast;

import com.kharisma.inside.mandiri.sejahtera.kimsapp.activity.sales.RiwayatRewardAcivity;
import com.kharisma.inside.mandiri.sejahtera.kimsapp.activity.sales.RiwayatScanActivity;
import com.kharisma.inside.mandiri.sejahtera.kimsapp.adapter.AdapterReward;
import com.kharisma.inside.mandiri.sejahtera.kimsapp.adapter.AdapterRiwayatReward;
import com.kharisma.inside.mandiri.sejahtera.kimsapp.model.ModelReward;
import com.kharisma.inside.mandiri.sejahtera.kimsapp.model.ModelRiwayatReward;
import com.kharisma.inside.mandiri.sejahtera.kimsapp.model.ModelSales;
import com.kharisma.inside.mandiri.sejahtera.kimsapp.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class HolderDataSales extends RecyclerView.ViewHolder implements View.OnClickListener {
    public TextView txtName, valEmail, valHP;
    public ModelSales sales;
    public Context context;

    private View modalBottomSheet;
    private TextView optionDetail, optionEdit, optionDelete, optionExcel, optionManual;
    private BottomSheetDialog bottomSheetDialog;
    private TextInputEditText valName, valPhone, valDetEmail;
    private Dialog dialog;
    private TextView toolbarDialog;

    public HolderDataSales(@NonNull View itemView) {
        super(itemView);
        txtName = itemView.findViewById(R.id.txtSalesName);
        valEmail = itemView.findViewById(R.id.valueEmail);
        valHP = itemView.findViewById(R.id.valuePhone);

        itemView.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        modalBottomSheet = LayoutInflater.from(context).inflate(R.layout.option_list, null);
        bottomSheetDialog = new BottomSheetDialog(context);

        optionEdit = modalBottomSheet.findViewById(R.id.textEdit);
        optionDetail = modalBottomSheet.findViewById(R.id.textDetail);
        optionDelete = modalBottomSheet.findViewById(R.id.textDelete);
        optionExcel = modalBottomSheet.findViewById(R.id.textExcel);
        optionManual = modalBottomSheet.findViewById(R.id.textManual);

        optionDelete.setOnClickListener(this);
        optionDetail.setOnClickListener(this);
        optionManual.setOnClickListener(this);
        optionExcel.setOnClickListener(this);
        optionManual.setText(context.getString(R.string.riwayat_reward));
        optionExcel.setText(context.getString(R.string.riwayat_scan));
        optionExcel.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_qr_code, 0, 0, 0);
        optionManual.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_gift, 0, 0, 0);

        optionManual.setVisibility(View.VISIBLE);
        optionDetail.setVisibility(View.VISIBLE);
        optionDelete.setVisibility(View.VISIBLE);
        optionExcel.setVisibility(View.VISIBLE);

        dialog = new Dialog(context);
        dialog.setCanceledOnTouchOutside(false);
        Objects.requireNonNull(dialog.getWindow()).getAttributes().windowAnimations = R.style.DialogTheme;
        dialog.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE);
        dialog.getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT);


        switch (v.getId()){
            case R.id.textExcel :
                context.startActivity(new Intent(context, RiwayatScanActivity.class));
                bottomSheetDialog.hide();
                break;

            case R.id.textManual :
                context.startActivity(new Intent(context, RiwayatRewardAcivity.class));
                bottomSheetDialog.hide();
                break;

            case R.id.textDetail :
                dialog.setContentView(R.layout.activity_detail_sales);
                toolbarDialog = dialog.findViewById(R.id.textViewTitle);
                valName = dialog.findViewById(R.id.inputNama);
                valPhone = dialog.findViewById(R.id.inputPhone);
                valDetEmail = dialog.findViewById(R.id.inputEmail);
                toolbarDialog.setText(context.getString(R.string.detail_sales));
                valName.setText(sales.getSalesName());
                valPhone.setText(sales.getSalesHP());
                valDetEmail.setText(sales.getSalesEmail());
                dialog.show();
                bottomSheetDialog.hide();
                break;

            case R.id.textDelete :
                Toast.makeText(context, "Delete", Toast.LENGTH_SHORT).show();
                bottomSheetDialog.hide();
                break;

            default:
                bottomSheetDialog.setContentView(modalBottomSheet);
                bottomSheetDialog.show();
        }
    }
}
