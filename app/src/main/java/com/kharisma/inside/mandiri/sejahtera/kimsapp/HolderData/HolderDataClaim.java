package com.kharisma.inside.mandiri.sejahtera.kimsapp.HolderData;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomSheetDialog;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.kharisma.inside.mandiri.sejahtera.kimsapp.Model.ModelClaim;
import com.kharisma.inside.mandiri.sejahtera.kimsapp.R;

public class HolderDataClaim extends RecyclerView.ViewHolder {
    public ModelClaim claim;
    public TextView nama, email, jenis, nominal;
    public Context context;
    private View modalBottomSheet;
    private TextView optionDetail, optionEdit, optionDelete, optionExcel, optionManual;
    private BottomSheetDialog bottomSheetDialog;
    public HolderDataClaim(@NonNull View itemView) {
        super(itemView);
        nama = itemView.findViewById(R.id.txtName);
        email = itemView.findViewById(R.id.valueEmail);
        jenis = itemView.findViewById(R.id.valueJenis);
        nominal = itemView.findViewById(R.id.valueNominal);

        itemView.setOnClickListener(new View.OnClickListener() {
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


                switch (v.getId()){
                    case R.id.textEdit :
                        Toast.makeText(context, "Edit", Toast.LENGTH_SHORT).show();
                        bottomSheetDialog.hide();
                        break;

                    case R.id.textDetail :
                        Toast.makeText(context, "Detail", Toast.LENGTH_SHORT).show();
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
        });
    }
}