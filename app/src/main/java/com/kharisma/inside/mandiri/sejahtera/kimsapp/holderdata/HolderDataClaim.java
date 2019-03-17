package com.kharisma.inside.mandiri.sejahtera.kimsapp.holderdata;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomSheetDialog;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.kharisma.inside.mandiri.sejahtera.kimsapp.model.ModelClaim;
import com.kharisma.inside.mandiri.sejahtera.kimsapp.R;

import java.util.Objects;

public class HolderDataClaim extends RecyclerView.ViewHolder implements View.OnClickListener {
    public ModelClaim claim;
    public TextView nama, email, jenis, nominal;
    public Context context;
    private TextInputEditText valName, valPhone, valEmail, valJenis, valNominal;
    private Dialog dialog;
    private TextView toolbarDialog;
    private Button accept;
    public HolderDataClaim(@NonNull View itemView) {
        super(itemView);
        nama = itemView.findViewById(R.id.txtName);
        email = itemView.findViewById(R.id.valueEmail);
        jenis = itemView.findViewById(R.id.valueJenis);
        nominal = itemView.findViewById(R.id.valueNominal);

        itemView.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        AlertDialog.Builder  builder = new AlertDialog.Builder(context);
        AlertDialog alertDialog;
        dialog = new Dialog(context);
        dialog.setContentView(R.layout.activity_detail_claim);
        toolbarDialog = dialog.findViewById(R.id.textViewTitle);
        valName = dialog.findViewById(R.id.inputNama);
        valPhone = dialog.findViewById(R.id.inputPhone);
        valEmail = dialog.findViewById(R.id.inputEmail);
        valJenis = dialog.findViewById(R.id.inputJenis);
        valNominal = dialog.findViewById(R.id.inputNominal);
        accept = dialog.findViewById(R.id.btnAccept);
        dialog.setCanceledOnTouchOutside(false);
        Objects.requireNonNull(dialog.getWindow()).getAttributes().windowAnimations = R.style.DialogTheme;
        dialog.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE);
        dialog.getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT);

        accept.setOnClickListener(this);

        switch (v.getId()){
            case R.id.btnAccept:
                builder.setMessage("Apakah Anda Yakin Akan Mengkonfirmasi Claim Reward Ini ?");
                builder.setPositiveButton("Ya", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                    }
                });
                builder.setNegativeButton("Tidak", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                    }
                });
                alertDialog = builder.create();
                alertDialog.getWindow().getAttributes().windowAnimations = R.style.DialogTheme;
                alertDialog.show();
                break;

            default:
                toolbarDialog.setText(context.getString(R.string.detail_claim_reward));
                valName.setText(claim.getNama());
                valPhone.setText(claim.getPhone());
                valEmail.setText(claim.getEmail());
                valJenis.setText(claim.getJenis());
                valNominal.setText(String.valueOf(claim.getNominal()));
                dialog.show();
        }
    }
}
