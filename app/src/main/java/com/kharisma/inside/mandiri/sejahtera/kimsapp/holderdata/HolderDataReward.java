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
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.kharisma.inside.mandiri.sejahtera.kimsapp.model.ModelReward;
import com.kharisma.inside.mandiri.sejahtera.kimsapp.R;

import java.util.Objects;

public class HolderDataReward extends RecyclerView.ViewHolder implements View.OnClickListener {
    public TextView rewardName, rewardType, rewardPoint;
    public Context context;
    public ModelReward reward;

    private View modalBottomSheet;
    private TextView optionDetail, optionEdit, optionDelete, optionExcel, optionManual;
    private BottomSheetDialog bottomSheetDialog;
    private Dialog dialog;
    private TextView toolbarDialog;
    private Button save;
    private TextInputEditText valEdtPoint, valEdtNominal;
    private RadioButton valCash, valPulsa;

    public HolderDataReward(@NonNull View itemView) {
        super(itemView);
        rewardName = itemView.findViewById(R.id.valueReward);
        rewardType = itemView.findViewById(R.id.valueType);
        rewardPoint = itemView.findViewById(R.id.valuePoint);

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

        dialog = new Dialog(context);
        dialog.setContentView(R.layout.activity_add_reward);
        toolbarDialog = dialog.findViewById(R.id.textViewTitle);
        valEdtNominal = dialog.findViewById(R.id.inputNominal);
        valEdtPoint = dialog.findViewById(R.id.inputPoint);
        valCash = dialog.findViewById(R.id.cash);
        valPulsa = dialog.findViewById(R.id.pulsa);
        save = dialog.findViewById(R.id.btnSave);
        valEdtPoint.setText(String.valueOf(reward.getRewardPoint()));
        valEdtNominal.setText(String.valueOf(reward.getRewardName()));
        if (reward.getRewardType().equals("Cash")){
            valCash.setChecked(true);
            valPulsa.setChecked(false);
        }else {
            valCash.setChecked(false);
            valPulsa.setChecked(true);
        }
        dialog.setCanceledOnTouchOutside(false);
        Objects.requireNonNull(dialog.getWindow()).getAttributes().windowAnimations = R.style.DialogTheme;
        dialog.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE);
        dialog.getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT);

        switch (v.getId()){
            case R.id.textEdit :
                toolbarDialog.setText(context.getString(R.string.edit_reward));
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
