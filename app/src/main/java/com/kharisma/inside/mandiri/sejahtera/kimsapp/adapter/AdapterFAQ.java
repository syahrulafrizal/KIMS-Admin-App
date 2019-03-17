package com.kharisma.inside.mandiri.sejahtera.kimsapp.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationSet;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.OvershootInterpolator;
import android.widget.ImageView;
import android.widget.TextView;

import com.kharisma.inside.mandiri.sejahtera.kimsapp.model.ModelFAQ;
import com.kharisma.inside.mandiri.sejahtera.kimsapp.R;

import net.cachapa.expandablelayout.ExpandableLayout;

import java.util.List;

public class AdapterFAQ extends RecyclerView.Adapter<AdapterFAQ.HolderDataFAQ> {

    private static final int UNSELECTED = -1;
    private RecyclerView recyclerView;
    private int selectedItem = UNSELECTED;
    private List<ModelFAQ> modelFAQList;
    private Context context;

    public AdapterFAQ(RecyclerView recyclerView, List<ModelFAQ> modelFAQList, Context context) {
        this.recyclerView = recyclerView;
        this.modelFAQList = modelFAQList;
        this.context = context;
    }

    @NonNull
    @Override
    public HolderDataFAQ onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.custom_list_faq, viewGroup, false);
        return new HolderDataFAQ(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HolderDataFAQ holderDataFAQ, int i) {
        ModelFAQ modelFAQ = modelFAQList.get(i);
        boolean isSelected = i == selectedItem;
        holderDataFAQ.expandContent.setText(modelFAQ.getContenFAQ());
        holderDataFAQ.expandButton.setText(modelFAQ.getTitleFAQ());
        holderDataFAQ.expandButton.setSelected(isSelected);
        holderDataFAQ.expandableLayout.setExpanded(isSelected, false);
        holderDataFAQ.faq = modelFAQ;
    }

    @Override
    public int getItemCount() {
        return modelFAQList.size();
    }
    public class HolderDataFAQ extends RecyclerView.ViewHolder implements View.OnClickListener,
            ExpandableLayout.OnExpansionUpdateListener {

        private ExpandableLayout expandableLayout;
        private TextView expandButton, expandContent;
        private ModelFAQ faq;
        private ImageView imgArrow;

        AnimationSet animSet = new AnimationSet(true);


        HolderDataFAQ(@NonNull View itemView) {
            super(itemView);
            animSet.setInterpolator(new DecelerateInterpolator());
            animSet.setFillAfter(true);
            animSet.setFillEnabled(true);
            expandableLayout = itemView.findViewById(R.id.expandable_layout);
            expandableLayout.setInterpolator(new OvershootInterpolator());
            expandableLayout.setOnExpansionUpdateListener(this);
            expandButton = itemView.findViewById(R.id.expand_button);
            expandContent = itemView.findViewById(R.id.expandable_layout_child);
            imgArrow = itemView.findViewById(R.id.button);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {

            HolderDataFAQ holder = (HolderDataFAQ) recyclerView.findViewHolderForAdapterPosition(selectedItem);
            if (holder != null) {
                holder.expandButton.setSelected(false);
                holder.expandableLayout.collapse();
            }

            int position = getAdapterPosition();
            if (position == selectedItem) {
                selectedItem = UNSELECTED;
            } else {
                expandButton.setSelected(true);
                expandableLayout.expand();
                selectedItem = position;
            }
        }

        @Override
        public void onExpansionUpdate(float expansionFraction, int state) {
            if (state == ExpandableLayout.State.EXPANDING) {
                recyclerView.smoothScrollToPosition(getAdapterPosition());
            }
        }
    }
}
