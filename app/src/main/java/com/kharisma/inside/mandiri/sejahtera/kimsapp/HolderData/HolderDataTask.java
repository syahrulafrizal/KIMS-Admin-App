package com.kharisma.inside.mandiri.sejahtera.kimsapp.HolderData;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.kharisma.inside.mandiri.sejahtera.kimsapp.Model.ModelTask;
import com.kharisma.inside.mandiri.sejahtera.kimsapp.R;

public class HolderDataTask extends RecyclerView.ViewHolder {
    public TextView date, name;
    public ModelTask task;
    public Context context;
    public HolderDataTask(@NonNull View itemView) {
        super(itemView);
        date = itemView.findViewById(R.id.txttaskDate);
        name = itemView.findViewById(R.id.texttaskName);
    }
}
