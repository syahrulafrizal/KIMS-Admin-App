package com.kharisma.inside.mandiri.sejahtera.kimsapp.HolderData;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.kharisma.inside.mandiri.sejahtera.kimsapp.Model.ModelMenu;
import com.kharisma.inside.mandiri.sejahtera.kimsapp.R;

public class HolderDataMenu extends RecyclerView.ViewHolder {

    public ImageView imgMenu;
    public TextView txtMenu;
    public Activity activity;
    public ModelMenu menu;
    public MenuItemClickListener itemClickListener;

    public HolderDataMenu(@NonNull View itemView) {
        super(itemView);

        imgMenu = itemView.findViewById(R.id.imgMenu);
        txtMenu = itemView.findViewById(R.id.textViewMenu);

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                itemClickListener.onMenuItemClick(menu.getTitleMenu());
            }
        });
    }

    public interface MenuItemClickListener{
        void onMenuItemClick(int itemString);
    }
}
