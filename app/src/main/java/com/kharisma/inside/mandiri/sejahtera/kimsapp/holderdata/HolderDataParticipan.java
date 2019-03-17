package com.kharisma.inside.mandiri.sejahtera.kimsapp.holderdata;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import com.kharisma.inside.mandiri.sejahtera.kimsapp.R;
import com.kharisma.inside.mandiri.sejahtera.kimsapp.model.ModelParticipan;

import java.util.List;

public class HolderDataParticipan extends RecyclerView.ViewHolder implements View.OnClickListener {
    public Context context;
    public ModelParticipan participan;
    public EditText txtName, txtDate, txtNote;
    public Button btnDelete;
    public List<ModelParticipan> modelParticipans;
    public HolderDataParticipan(@NonNull View itemView) {
        super(itemView);
        txtName = itemView.findViewById(R.id.textName);
        txtDate = itemView.findViewById(R.id.textDeadline);
        txtNote = itemView.findViewById(R.id.textNote);
        btnDelete = itemView.findViewById(R.id.btnDelete);

//        btnDelete.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
//        modelParticipans.remove(getAdapterPosition());
//        notifyItemRemoved(getAdapterPosition());
//        notifyDataSetChanged();
    }
}
