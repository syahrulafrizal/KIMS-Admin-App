package com.kharisma.inside.mandiri.sejahtera.kimsapp.holderdata;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.support.annotation.NonNull;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.kharisma.inside.mandiri.sejahtera.kimsapp.activity.MainActivity;
import com.kharisma.inside.mandiri.sejahtera.kimsapp.model.ModelApproval;
import com.kharisma.inside.mandiri.sejahtera.kimsapp.R;

import java.util.Objects;

import static android.content.ContentValues.TAG;

public class HolderDataApproval extends RecyclerView.ViewHolder implements View.OnClickListener {
    public ModelApproval approval;
    public Context context;
    public TextView name, email;
    private TextInputEditText valName, valPhone, valEmail, valStore, valAlamat;
    private Dialog dialog;
    private TextView toolbarDialog;
    private Button accept, reject;
    public HolderDataApproval(@NonNull View itemView) {
        super(itemView);
        name = itemView.findViewById(R.id.valueName);
        email = itemView.findViewById(R.id.valueEmail);

        itemView.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        AlertDialog.Builder  builder = new AlertDialog.Builder(context);
        AlertDialog alertDialog;
        dialog = new Dialog(context);
        dialog.setContentView(R.layout.activity_detail_approval);
        toolbarDialog = dialog.findViewById(R.id.textViewTitle);
        valName = dialog.findViewById(R.id.inputNama);
        valPhone = dialog.findViewById(R.id.inputPhone);
        valEmail = dialog.findViewById(R.id.inputEmail);
        valStore = dialog.findViewById(R.id.inputNameStore);
        valAlamat = dialog.findViewById(R.id.inputAlamat);
        accept = dialog.findViewById(R.id.btnAccept);
        reject = dialog.findViewById(R.id.btnReject);
        dialog.setCanceledOnTouchOutside(false);
        Objects.requireNonNull(dialog.getWindow()).getAttributes().windowAnimations = R.style.DialogTheme;
        dialog.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE);
        dialog.getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT);

        accept.setOnClickListener(this);
        reject.setOnClickListener(this);

        switch (v.getId()){
            case R.id.btnReject:
                builder.setMessage("Apakah Anda Yakin Akan Menolak Pengajuan Ini ?");
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

            case R.id.btnAccept:
                builder.setMessage("Apakah Anda Yakin Akan Mengkonfirmasi Pengajuan Ini ?");
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
                toolbarDialog.setText(context.getString(R.string.detail_pengajuan_member));
                valName.setText(approval.getName());
                valPhone.setText(approval.getPhoneNumber());
                valEmail.setText(approval.getEmail());
                valAlamat.setText(approval.getAddress());
                valStore.setText(approval.getStore());
                dialog.show();
        }
    }
}
