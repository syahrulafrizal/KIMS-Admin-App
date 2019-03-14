package com.kharisma.inside.mandiri.sejahtera.kimsapp.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.kharisma.inside.mandiri.sejahtera.kimsapp.HolderData.HolderDataApproval;
import com.kharisma.inside.mandiri.sejahtera.kimsapp.Model.ModelApproval;
import com.kharisma.inside.mandiri.sejahtera.kimsapp.R;

import java.util.List;

public class AdapterApproval extends RecyclerView.Adapter<HolderDataApproval> {
    private Context context;
    private List<ModelApproval> modelApprovalList;

    public AdapterApproval(Context context, List<ModelApproval> modelApprovalList) {
        this.context = context;
        this.modelApprovalList = modelApprovalList;
    }

    @NonNull
    @Override
    public HolderDataApproval onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.custom_list_approval, viewGroup, false);
        return new HolderDataApproval(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HolderDataApproval holderDataApproval, int i) {
        ModelApproval modelApproval = modelApprovalList.get(i);
        holderDataApproval.email.setText(modelApproval.getEmail());
        holderDataApproval.name.setText(modelApproval.getName());
        holderDataApproval.approval = modelApproval;
        holderDataApproval.context = context;
    }

    @Override
    public int getItemCount() {
        return modelApprovalList.size();
    }
}
