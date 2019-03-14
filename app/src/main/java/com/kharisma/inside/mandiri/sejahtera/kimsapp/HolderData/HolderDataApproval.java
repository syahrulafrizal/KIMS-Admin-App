package com.kharisma.inside.mandiri.sejahtera.kimsapp.HolderData;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.kharisma.inside.mandiri.sejahtera.kimsapp.Model.ModelApproval;
import com.kharisma.inside.mandiri.sejahtera.kimsapp.R;

public class HolderDataApproval extends RecyclerView.ViewHolder {
    public ModelApproval approval;
    public Context context;
    public TextView name, email;
    public HolderDataApproval(@NonNull View itemView) {
        super(itemView);
        name = itemView.findViewById(R.id.valueName);
        email = itemView.findViewById(R.id.valueEmail);
    }
}
