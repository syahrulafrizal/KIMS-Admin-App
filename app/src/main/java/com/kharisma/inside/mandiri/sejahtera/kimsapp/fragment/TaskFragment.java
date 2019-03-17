package com.kharisma.inside.mandiri.sejahtera.kimsapp.fragment;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomSheetDialog;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.kharisma.inside.mandiri.sejahtera.kimsapp.activity.task.AddTaskActivity;
import com.kharisma.inside.mandiri.sejahtera.kimsapp.adapter.AdapterTask;
import com.kharisma.inside.mandiri.sejahtera.kimsapp.model.ModelTask;
import com.kharisma.inside.mandiri.sejahtera.kimsapp.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class TaskFragment extends Fragment implements View.OnClickListener {

    List<ModelTask> modelTaskList;
    RecyclerView listTask;
    RecyclerView.Adapter adapterTask;
    RecyclerView.LayoutManager layoutManagerTask;
    FloatingActionButton btnAdd;
    View modalBottomSheet;
    TextView optionDetail, optionEdit, optionDelete, optionExcel, optionManual;
    BottomSheetDialog bottomSheetDialog;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_task_fragment, container, false);
        listTask = view.findViewById(R.id.listTask);
        btnAdd = view.findViewById(R.id.actionBtnAddTask);
        layoutManagerTask = new LinearLayoutManager(getContext());
        listTask.setLayoutManager(layoutManagerTask);
        modelTaskList = new ArrayList<>();
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ModelTask modelTask = new ModelTask("12 Maret 2019", "Kirim KNK");
        ModelTask modelTask1 = new ModelTask("13 Maret 2019", "Tansfer Claim Yogya");
        ModelTask modelTask2 = new ModelTask("14 Maret 2019", "Report Pameren");
        modelTaskList.add(modelTask);
        modelTaskList.add(modelTask1);
        modelTaskList.add(modelTask2);

        Log.d("Model", String.valueOf(modelTaskList.size()));

        adapterTask = new AdapterTask(modelTaskList, getContext());
        listTask.setAdapter(adapterTask);
        adapterTask.notifyDataSetChanged();
        listTask.setItemAnimator(new DefaultItemAnimator());

        btnAdd.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        modalBottomSheet = LayoutInflater.from(getContext()).inflate(R.layout.option_list, null);
        bottomSheetDialog = new BottomSheetDialog(Objects.requireNonNull(getContext()));

        optionEdit = modalBottomSheet.findViewById(R.id.textEdit);
        optionDetail = modalBottomSheet.findViewById(R.id.textDetail);
        optionDelete = modalBottomSheet.findViewById(R.id.textDelete);
        optionExcel = modalBottomSheet.findViewById(R.id.textExcel);
        optionManual = modalBottomSheet.findViewById(R.id.textManual);

        optionExcel.setVisibility(View.VISIBLE);
        optionManual.setVisibility(View.VISIBLE);

        optionExcel.setOnClickListener(this);
        optionManual.setOnClickListener(this);

        switch (v.getId()){
            case R.id.textExcel:
                break;

            case R.id.textManual:
                startActivity(new Intent(getActivity(), AddTaskActivity.class));
                break;

            default:
                bottomSheetDialog.setContentView(modalBottomSheet);
                bottomSheetDialog.show();
        }
    }
}
