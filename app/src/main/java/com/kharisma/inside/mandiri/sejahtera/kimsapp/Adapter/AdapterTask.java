package com.kharisma.inside.mandiri.sejahtera.kimsapp.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.kharisma.inside.mandiri.sejahtera.kimsapp.HolderData.HolderDataTask;
import com.kharisma.inside.mandiri.sejahtera.kimsapp.Model.ModelTask;
import com.kharisma.inside.mandiri.sejahtera.kimsapp.R;

import java.util.List;

public class AdapterTask extends RecyclerView.Adapter<HolderDataTask> {
    private List<ModelTask> modelTaskList;
    private Context context;

    public AdapterTask(List<ModelTask> modelTaskList, Context context) {
        this.modelTaskList = modelTaskList;
        this.context = context;
    }

    @NonNull
    @Override
    public HolderDataTask onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.custom_list_task, viewGroup, false);
        return new HolderDataTask(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HolderDataTask holderDataTask, int i) {
        ModelTask modelTask = modelTaskList.get(i);
        holderDataTask.name.setText(modelTask.getNameTask());
        holderDataTask.date.setText(modelTask.getTaskDate());
        holderDataTask.context = context;
        holderDataTask.task = modelTask;
    }

    @Override
    public int getItemCount() {
        return modelTaskList.size();
    }
}
