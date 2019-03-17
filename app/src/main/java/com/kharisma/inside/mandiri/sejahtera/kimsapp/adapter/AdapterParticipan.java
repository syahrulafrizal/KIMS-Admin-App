package com.kharisma.inside.mandiri.sejahtera.kimsapp.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.kharisma.inside.mandiri.sejahtera.kimsapp.R;
import com.kharisma.inside.mandiri.sejahtera.kimsapp.holderdata.HolderDataParticipan;
import com.kharisma.inside.mandiri.sejahtera.kimsapp.model.ModelParticipan;

import java.util.List;

public class AdapterParticipan extends RecyclerView.Adapter<HolderDataParticipan> {
    private Context context;
    private List<ModelParticipan> modelParticipanList;

    public AdapterParticipan(Context context, List<ModelParticipan> modelParticipanList) {
        this.context = context;
        this.modelParticipanList = modelParticipanList;
    }


    @NonNull
    @Override
    public HolderDataParticipan onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.custom_list_participan, viewGroup, false);
        return new HolderDataParticipan(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final HolderDataParticipan holderDataParticipan, int i) {
        ModelParticipan modelParticipan = modelParticipanList.get(i);
        holderDataParticipan.txtNote.setText(modelParticipan.getParticipanNote());
        holderDataParticipan.txtName.setText(modelParticipan.getParticipanName());
        holderDataParticipan.txtDate.setText(modelParticipan.getParticipanDeadline());
        holderDataParticipan.participan = modelParticipan;
        holderDataParticipan.context = context;
        holderDataParticipan.modelParticipans = modelParticipanList;

        holderDataParticipan.btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                modelParticipanList.remove(holderDataParticipan.getAdapterPosition());
                notifyItemRangeChanged(holderDataParticipan.getAdapterPosition(), modelParticipanList.size());
                notifyItemRemoved(holderDataParticipan.getAdapterPosition());
                notifyDataSetChanged();
            }
        });
    }

    @Override
    public int getItemCount() {
        return modelParticipanList.size();
    }
}
