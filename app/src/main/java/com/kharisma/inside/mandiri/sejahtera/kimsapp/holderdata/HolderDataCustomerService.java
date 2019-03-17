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
import android.widget.TextView;
import android.widget.Toast;

import com.kharisma.inside.mandiri.sejahtera.kimsapp.model.ModelCustomerService;
import com.kharisma.inside.mandiri.sejahtera.kimsapp.R;

import java.util.Objects;

public class HolderDataCustomerService extends RecyclerView.ViewHolder implements View.OnClickListener {
    public ModelCustomerService customerService;
    public TextView valPerson, valPlace, valOffice;
    public Context context;

    private View modalBottomSheet;
    private TextView optionDetail, optionEdit, optionDelete, optionExcel, optionManual;
    private BottomSheetDialog bottomSheetDialog;
    private Button save;
    private Dialog dialog;
    private TextView toolbarDialog;
    private TextInputEditText valName, valPhone, valTel, valWilayah;

    public HolderDataCustomerService(@NonNull View itemView) {
        super(itemView);
        valPerson = itemView.findViewById(R.id.valuePerson);
        valPlace = itemView.findViewById(R.id.txtPlace);
        valOffice = itemView.findViewById(R.id.valueOffice);

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
        dialog.setContentView(R.layout.activity_add_customer_service);
        toolbarDialog = dialog.findViewById(R.id.textViewTitle);
        valName = dialog.findViewById(R.id.inputNama);
        valPhone = dialog.findViewById(R.id.inputPhone);
        valTel = dialog.findViewById(R.id.inputTelepone);
        valWilayah = dialog.findViewById(R.id.inputWilayah);
        save = dialog.findViewById(R.id.btnSave);
        valName.setText(customerService.getPerson());
        valPhone.setText(customerService.getPhone());
        valTel.setText(customerService.getOffice());
        valWilayah.setText(customerService.getPlace());
        dialog.setCanceledOnTouchOutside(false);
        Objects.requireNonNull(dialog.getWindow()).getAttributes().windowAnimations = R.style.DialogTheme;
        dialog.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE);
        dialog.getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT);

        switch (v.getId()){
            case R.id.textEdit :
                toolbarDialog.setText(context.getString(R.string.edit_customer_service));
                dialog.show();
                bottomSheetDialog.dismiss();
                break;

            case R.id.textDetail :
                toolbarDialog.setText(context.getString(R.string.detail_customer_service));
                save.setVisibility(View.GONE);
                valName.setFocusable(false);
                valName.setEnabled(false);
                valName.setCursorVisible(false);
                valName.setKeyListener(null);
                valName.setTextColor(Color.parseColor("#000000"));

                valPhone.setFocusable(false);
                valPhone.setEnabled(false);
                valPhone.setCursorVisible(false);
                valPhone.setKeyListener(null);
                valPhone.setTextColor(Color.parseColor("#000000"));

                valTel.setFocusable(false);
                valTel.setEnabled(false);
                valTel.setCursorVisible(false);
                valTel.setKeyListener(null);
                valTel.setTextColor(Color.parseColor("#000000"));

                valWilayah.setFocusable(false);
                valWilayah.setEnabled(false);
                valWilayah.setCursorVisible(false);
                valWilayah.setKeyListener(null);
                valWilayah.setTextColor(Color.parseColor("#000000"));
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
