package com.kharisma.inside.mandiri.sejahtera.kimsapp.holderdata;

import android.app.Dialog;
import android.content.Context;
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

import com.kharisma.inside.mandiri.sejahtera.kimsapp.model.ModelStore;
import com.kharisma.inside.mandiri.sejahtera.kimsapp.R;

import java.util.Objects;

public class HolderDataStore extends RecyclerView.ViewHolder implements View.OnClickListener {
    public TextView valStoreName, valPhone, valArea, valAddress;
    public ModelStore store;
    public Context context;

    private View modalBottomSheet;
    private TextView optionDetail, optionEdit, optionDelete, optionExcel, optionManual;
    private BottomSheetDialog bottomSheetDialog;
    private Dialog dialog;
    private TextView toolbarDialog;
    private Button save;
    private TextInputEditText valEdtNama, valEdtWilayah, valEdtPhone, valEdtAlamat;

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
        optionDelete.setVisibility(View.VISIBLE);

        bottomSheetDialog.setContentView(modalBottomSheet);
        bottomSheetDialog.show();

        dialog = new Dialog(context);
        dialog.setContentView(R.layout.activity_add_store);
        toolbarDialog = dialog.findViewById(R.id.textViewTitle);
        valEdtNama = dialog.findViewById(R.id.inputNama);
        valEdtAlamat = dialog.findViewById(R.id.inputAlamat);
        valEdtPhone = dialog.findViewById(R.id.inputPhone);
        valEdtWilayah = dialog.findViewById(R.id.inputWilayah);
        save = dialog.findViewById(R.id.btnSave);
        valEdtNama.setText(store.getStoreName());
        valEdtAlamat.setText(store.getStroreAddress());
        valEdtWilayah.setText(store.getStoreArea());
        valEdtPhone.setText(store.getStorePhone());
        dialog.setCanceledOnTouchOutside(false);
        Objects.requireNonNull(dialog.getWindow()).getAttributes().windowAnimations = R.style.DialogTheme;
        dialog.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE);
        dialog.getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT);

        switch (v.getId()){
            case R.id.textEdit :
                toolbarDialog.setText(context.getString(R.string.edit_store));
                dialog.show();
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
