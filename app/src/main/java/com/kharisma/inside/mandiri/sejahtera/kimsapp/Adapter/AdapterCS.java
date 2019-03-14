package com.kharisma.inside.mandiri.sejahtera.kimsapp.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.kharisma.inside.mandiri.sejahtera.kimsapp.HolderData.HolderDataCustomerService;
import com.kharisma.inside.mandiri.sejahtera.kimsapp.Model.ModelCustomerService;
import com.kharisma.inside.mandiri.sejahtera.kimsapp.R;

import java.util.List;

public class AdapterCS extends RecyclerView.Adapter<HolderDataCustomerService> {
    private List<ModelCustomerService> modelCustomerServiceList;
    private Context context;

    public AdapterCS(List<ModelCustomerService> modelCustomerServiceList, Context context) {
        this.modelCustomerServiceList = modelCustomerServiceList;
        this.context = context;
    }

    @NonNull
    @Override
    public HolderDataCustomerService onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.custom_list_cs, viewGroup, false);
        return new HolderDataCustomerService(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HolderDataCustomerService holderDataCustomerService, int i) {
        ModelCustomerService modelCustomerService = modelCustomerServiceList.get(i);
        holderDataCustomerService.valOffice.setText(modelCustomerService.getOffice());
        holderDataCustomerService.valPlace.setText(modelCustomerService.getPlace().toUpperCase());
        holderDataCustomerService.valPerson.setText(modelCustomerService.getPerson());
        holderDataCustomerService.context = context;
        holderDataCustomerService.customerService = modelCustomerService;
    }

    @Override
    public int getItemCount() {
        return modelCustomerServiceList.size();
    }
}
