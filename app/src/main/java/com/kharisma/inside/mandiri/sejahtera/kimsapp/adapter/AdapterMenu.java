package com.kharisma.inside.mandiri.sejahtera.kimsapp.adapter;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.kharisma.inside.mandiri.sejahtera.kimsapp.holderdata.HolderDataMenu;
import com.kharisma.inside.mandiri.sejahtera.kimsapp.model.ModelMenu;
import com.kharisma.inside.mandiri.sejahtera.kimsapp.R;

import java.util.List;

public class AdapterMenu extends RecyclerView.Adapter<HolderDataMenu> {

    private List<ModelMenu> modelMenuList;
    private Context context;
    private Activity activity;

    public AdapterMenu(List<ModelMenu> modelMenuList, Context context, Activity activity) {
        this.modelMenuList = modelMenuList;
        this.context = context;
        this.activity = activity;
    }

    @NonNull
    @Override
    public HolderDataMenu onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.custom_list_menu, viewGroup, false);
        return new HolderDataMenu(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HolderDataMenu holderDataMenu, int i) {
        ModelMenu modelMenu = modelMenuList.get(i);
        holderDataMenu.imgMenu.setImageResource(modelMenu.getImgMenu());
        holderDataMenu.txtMenu.setText(modelMenu.getTitleMenu());
        holderDataMenu.activity = activity;
        holderDataMenu.menu = modelMenu;
        holderDataMenu.itemClickListener = (HolderDataMenu.MenuItemClickListener) activity;
    }

    @Override
    public int getItemCount() {
        return modelMenuList.size();
    }
}
