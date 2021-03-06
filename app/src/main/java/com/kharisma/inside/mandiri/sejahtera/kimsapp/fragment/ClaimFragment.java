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

import com.kharisma.inside.mandiri.sejahtera.kimsapp.adapter.AdapterClaim;
import com.kharisma.inside.mandiri.sejahtera.kimsapp.model.ModelClaim;
import com.kharisma.inside.mandiri.sejahtera.kimsapp.R;

import java.util.ArrayList;
import java.util.List;

public class ClaimFragment extends Fragment {

    List<ModelClaim> modelClaimList;
    RecyclerView listClaim;
    RecyclerView.Adapter adapterClaim;
    RecyclerView.LayoutManager layoutManagerClaim;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_claim_fragment, container, false);
        listClaim = view.findViewById(R.id.listClaim);
        layoutManagerClaim = new LinearLayoutManager(getContext());
        listClaim.setLayoutManager(layoutManagerClaim);
        modelClaimList = new ArrayList<>();
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ModelClaim modelClaim = new ModelClaim("afrizalsyahrul@gmail.com", "Syahrul A.F",
                "Cash", "085200610811", 100000);
        ModelClaim modelClaim1 = new ModelClaim("afrizalsyahrul@gmail.com", "Syahrul A.F",
                "Pulsa", "085200610811",100000);
        ModelClaim modelClaim2 = new ModelClaim("afrizalsyahrul@gmail.com", "Syahrul A.F",
                "Cash", "085200610811",100000);
        ModelClaim modelClaim3 = new ModelClaim("afrizalsyahrul@gmail.com", "Syahrul A.F",
                "Pulsa", "085200610811",100000);
        modelClaimList.add(modelClaim);
        modelClaimList.add(modelClaim1);
        modelClaimList.add(modelClaim2);
        modelClaimList.add(modelClaim3);
        adapterClaim = new AdapterClaim(getContext(), modelClaimList);
        listClaim.setAdapter(adapterClaim);
        adapterClaim.notifyDataSetChanged();
        listClaim.setItemAnimator(new DefaultItemAnimator());
    }
}
