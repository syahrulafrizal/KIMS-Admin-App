package com.kharisma.inside.mandiri.sejahtera.kimsapp.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.kharisma.inside.mandiri.sejahtera.kimsapp.HolderData.HolderDataReward;
import com.kharisma.inside.mandiri.sejahtera.kimsapp.Model.ModelReward;
import com.kharisma.inside.mandiri.sejahtera.kimsapp.R;

import java.util.List;

public class AdapterReward extends RecyclerView.Adapter<HolderDataReward> {
    private List<ModelReward> modelRewardList;
    private Context context;

    public AdapterReward(List<ModelReward> modelRewardList, Context context) {
        this.modelRewardList = modelRewardList;
        this.context = context;
    }

    @NonNull
    @Override
    public HolderDataReward onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.custom_list_reward, viewGroup, false);
        return new HolderDataReward(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HolderDataReward holderDataReward, int i) {
        ModelReward modelReward = modelRewardList.get(i);
        holderDataReward.rewardName.setText(modelReward.getRewardName());
        holderDataReward.rewardPoint.setText(String.valueOf(modelReward.getRewardPoint()));
        holderDataReward.rewardType.setText(modelReward.getRewardType());
        holderDataReward.context = context;
        holderDataReward.reward = modelReward;
    }

    @Override
    public int getItemCount() {
        return modelRewardList.size();
    }
}
