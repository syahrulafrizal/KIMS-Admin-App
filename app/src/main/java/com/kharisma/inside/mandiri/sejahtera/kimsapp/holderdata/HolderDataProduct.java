package com.kharisma.inside.mandiri.sejahtera.kimsapp.holderdata;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomSheetDialog;
import android.support.design.widget.TextInputEditText;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.kharisma.inside.mandiri.sejahtera.kimsapp.model.ModelProduct;
import com.kharisma.inside.mandiri.sejahtera.kimsapp.R;

import java.util.Objects;

public class HolderDataProduct extends RecyclerView.ViewHolder implements View.OnClickListener {

    public TextView valSN, valProduct, valClaimer, valStatus, valPoint;
    public ModelProduct product;
    public Context context;
    public LinearLayout claim, status;
    public ImageView imgProduct;

    private View modalBottomSheet;
    private TextView optionDetail, optionEdit, optionDelete, optionExcel, optionManual;
    private BottomSheetDialog bottomSheetDialog;
    private Dialog dialog;
    private TextView toolbarDialog;
    private Button save;
    private TextInputEditText valEdtSerial, valEdtJenis, valEdtqrCode, valEdtPoint, valEdtStatus;

    public HolderDataProduct(@NonNull View itemView) {
        super(itemView);

        valSN = itemView.findViewById(R.id.txtSN);
        valProduct = itemView.findViewById(R.id.valueProduct);
        valClaimer = itemView.findViewById(R.id.valueClaimer);
        valStatus = itemView.findViewById(R.id.valueStatus);
        valPoint = itemView.findViewById(R.id.valuePoint);
        claim = itemView.findViewById(R.id.linear2);
        status = itemView.findViewById(R.id.linear3);
        imgProduct = itemView.findViewById(R.id.imageViewProduct);

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
        optionEdit.setOnClickListener(this);

        optionEdit.setVisibility(View.VISIBLE);
        optionDetail.setVisibility(View.VISIBLE);
        optionDelete.setVisibility(View.VISIBLE);

        dialog = new Dialog(context);
        dialog.setContentView(R.layout.activity_add_product);
        toolbarDialog = dialog.findViewById(R.id.textViewTitle);
        valEdtSerial = dialog.findViewById(R.id.inputSN);
        valEdtJenis = dialog.findViewById(R.id.inputJenis);
        valEdtPoint = dialog.findViewById(R.id.inputPoint);
        valEdtqrCode = dialog.findViewById(R.id.inputqrCode);
        valEdtStatus = dialog.findViewById(R.id.inputStatus);
        save = dialog.findViewById(R.id.btnSave);
        valEdtSerial.setText(product.getSerialNumber());
        valEdtJenis.setText(product.getProduct());
        valEdtPoint.setText(String.valueOf(product.getPoint()));
        valEdtqrCode.setText(product.getQrCode());
        valEdtStatus.setText(product.getStatus());
        dialog.setCanceledOnTouchOutside(false);
        Objects.requireNonNull(dialog.getWindow()).getAttributes().windowAnimations = R.style.DialogTheme;
        dialog.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE);
        dialog.getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT);

        switch (v.getId()){
            case R.id.textEdit :
                toolbarDialog.setText(context.getString(R.string.edit_product));
                dialog.show();
                bottomSheetDialog.hide();
                break;

            case R.id.textDetail :
                save.setVisibility(View.GONE);
                toolbarDialog.setText(context.getString(R.string.detail_product));
                valEdtStatus.setFocusable(false);
                valEdtStatus.setEnabled(false);
                valEdtStatus.setCursorVisible(false);
                valEdtStatus.setKeyListener(null);
                valEdtStatus.setTextColor(Color.parseColor("#000000"));

                valEdtqrCode.setFocusable(false);
                valEdtqrCode.setEnabled(false);
                valEdtqrCode.setCursorVisible(false);
                valEdtqrCode.setKeyListener(null);
                valEdtqrCode.setTextColor(Color.parseColor("#000000"));

                valEdtPoint.setFocusable(false);
                valEdtPoint.setEnabled(false);
                valEdtPoint.setCursorVisible(false);
                valEdtPoint.setKeyListener(null);
                valEdtPoint.setTextColor(Color.parseColor("#000000"));

                valEdtJenis.setFocusable(false);
                valEdtJenis.setEnabled(false);
                valEdtJenis.setCursorVisible(false);
                valEdtJenis.setKeyListener(null);
                valEdtJenis.setTextColor(Color.parseColor("#000000"));

                valEdtSerial.setFocusable(false);
                valEdtSerial.setEnabled(false);
                valEdtSerial.setCursorVisible(false);
                valEdtSerial.setKeyListener(null);
                valEdtSerial.setTextColor(Color.parseColor("#000000"));
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
