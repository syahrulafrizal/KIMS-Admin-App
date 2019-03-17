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
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.kharisma.inside.mandiri.sejahtera.kimsapp.model.ModelAdmin;
import com.kharisma.inside.mandiri.sejahtera.kimsapp.R;

import java.util.Objects;

public class HolderDataAdmin extends RecyclerView.ViewHolder implements View.OnClickListener {
    public ModelAdmin admin;
    public TextView name, postion;
    public Context context;

    private View modalBottomSheet;
    private TextView optionDetail, optionEdit, optionDelete;
    private BottomSheetDialog bottomSheetDialog;
    private TextInputEditText valName, valPhone, valEmail;
    private RadioButton valPositionAdmin, valPositionNonAdmin;
    private Dialog dialog;
    private TextView toolbarDialog;
    private Button save;

    public HolderDataAdmin(@NonNull View itemView) {
        super(itemView);
        name = itemView.findViewById(R.id.txtName);
        postion = itemView.findViewById(R.id.txtPosition);

        itemView.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        modalBottomSheet = LayoutInflater.from(context).inflate(R.layout.option_list, null);
        bottomSheetDialog = new BottomSheetDialog(context);

        optionEdit = modalBottomSheet.findViewById(R.id.textEdit);
        optionDetail = modalBottomSheet.findViewById(R.id.textDetail);
        optionDelete = modalBottomSheet.findViewById(R.id.textDelete);

        optionDelete.setOnClickListener(this);
        optionDetail.setOnClickListener(this);
        optionEdit.setOnClickListener(this);

        optionEdit.setVisibility(View.VISIBLE);
        optionDetail.setVisibility(View.VISIBLE);
        optionDelete.setVisibility(View.VISIBLE);

        dialog = new Dialog(context);
        dialog.setContentView(R.layout.activity_add_admin);
        toolbarDialog = dialog.findViewById(R.id.textViewTitle);
        valName = dialog.findViewById(R.id.inputNama);
        valPhone = dialog.findViewById(R.id.inputPhone);
        valEmail = dialog.findViewById(R.id.inputEmail);
        valPositionAdmin = dialog.findViewById(R.id.admin);
        valPositionNonAdmin = dialog.findViewById(R.id.nonAdmin);
        save = dialog.findViewById(R.id.btnSave);
        valName.setText(admin.getName());
        valPhone.setText(admin.getPhone());
        valEmail.setText(admin.getEmail());
        if (admin.getPostion().equals("Admin")){
            valPositionAdmin.setChecked(true);
            valPositionNonAdmin.setChecked(false);
        }else {
            valPositionAdmin.setChecked(false);
            valPositionNonAdmin.setChecked(true);
        }
        dialog.setCanceledOnTouchOutside(false);
        Objects.requireNonNull(dialog.getWindow()).getAttributes().windowAnimations = R.style.DialogTheme;
        dialog.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE);
        dialog.getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT);

        switch (v.getId()){
            case R.id.textEdit :
                toolbarDialog.setText(context.getString(R.string.edit_admin));
                dialog.show();
                bottomSheetDialog.hide();
                break;

            case R.id.textDetail :
                toolbarDialog.setText(context.getString(R.string.detail_admin));
                save.setVisibility(View.GONE);
                if (admin.getPostion().equals("Admin")){
                    valPositionAdmin.setChecked(true);
                    valPositionNonAdmin.setChecked(false);
                    valPositionAdmin.setVisibility(View.VISIBLE);
                    valPositionNonAdmin.setVisibility(View.GONE);
                }else {
                    valPositionAdmin.setChecked(false);
                    valPositionNonAdmin.setChecked(true);
                    valPositionAdmin.setVisibility(View.GONE);
                    valPositionNonAdmin.setVisibility(View.VISIBLE);
                }
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

                valEmail.setFocusable(false);
                valEmail.setEnabled(false);
                valEmail.setCursorVisible(false);
                valEmail.setKeyListener(null);
                valEmail.setTextColor(Color.parseColor("#000000"));
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
