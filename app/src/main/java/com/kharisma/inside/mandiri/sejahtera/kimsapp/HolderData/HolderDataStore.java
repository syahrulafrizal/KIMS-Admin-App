package com.kharisma.inside.mandiri.sejahtera.kimsapp.HolderData;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomSheetDialog;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.kharisma.inside.mandiri.sejahtera.kimsapp.Model.ModelStore;
import com.kharisma.inside.mandiri.sejahtera.kimsapp.R;

public class HolderDataStore extends RecyclerView.ViewHolder implements View.OnClickListener {
    public TextView valStoreName, valPhone, valArea, valAddress;
    public ModelStore store;
    public Context context;

    private View modalBottomSheet;
    private TextView optionDetail, optionEdit, optionDelete, optionExcel, optionManual;
    private BottomSheetDialog bottomSheetDialog;

    public HolderDataStore(@NonNull View itemView) {
        super(itemView);
        valStoreName = itemView.findViewById(R.id.txtStoreName);
        valPhone = itemView.findViewById(R.id.valuePhone);
        valArea = itemView.findViewById(R.id.valueArea);
        valAddress = itemView.findViewById(R.id.valueAddress);

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

        bottomSheetDialog.setContentView(modalBottomSheet);
        bottomSheetDialog.show();

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

//            default:
//                bottomSheetDialog.show();
//                break;
        }
    }
}
