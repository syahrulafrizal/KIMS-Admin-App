package com.kharisma.inside.mandiri.sejahtera.kimsapp.fragment;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.kharisma.inside.mandiri.sejahtera.kimsapp.adapter.AdapterApproval;
import com.kharisma.inside.mandiri.sejahtera.kimsapp.model.ModelApproval;
import com.kharisma.inside.mandiri.sejahtera.kimsapp.R;

import java.util.ArrayList;
import java.util.List;

public class ApprovalFragment extends Fragment {
    List<ModelApproval> modelApprovalList;
    RecyclerView listApproval;
    RecyclerView.Adapter adapterApproval;
    RecyclerView.LayoutManager layoutManagerApproval;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_approval_fragment, container, false);
        listApproval = view.findViewById(R.id.listApproval);
        layoutManagerApproval = new LinearLayoutManager(getContext());
        listApproval.setLayoutManager(layoutManagerApproval);
        modelApprovalList = new ArrayList<>();
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ModelApproval modelApproval = new ModelApproval("Syahrul Afrizal",
                "afrizalsyahrul@gmail.com", "085100610811", "AN'S COMPUTER", "Jl. p Suryanegara");
        modelApprovalList.add(modelApproval);
        modelApprovalList.add(modelApproval);
        modelApprovalList.add(modelApproval);
        modelApprovalList.add(modelApproval);
        modelApprovalList.add(modelApproval);
        modelApprovalList.add(modelApproval);
        modelApprovalList.add(modelApproval);
        adapterApproval = new AdapterApproval(getActivity(), modelApprovalList);
        listApproval.setAdapter(adapterApproval);
        adapterApproval.notifyDataSetChanged();
        listApproval.setItemAnimator(new DefaultItemAnimator());
    }
}
