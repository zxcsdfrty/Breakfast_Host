package com.example.test01.ViewHolder;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.ContextMenu;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.test01.Common.Common;
import com.example.test01.Interface.ItemClickListener;
import com.example.test01.R;

public class FoodViewHolder extends RecyclerView.ViewHolder implements
        View.OnClickListener,
        View.OnCreateContextMenuListener
{

    public TextView food_name;
    public ImageView food_image;

    private ItemClickListener itemClickListener;

    public FoodViewHolder(@NonNull View itemView) {
        super(itemView);

        food_name=(TextView)itemView.findViewById(R.id.food_name);
        food_image =(ImageView)itemView.findViewById(R.id.food_image);
        itemView.setOnCreateContextMenuListener(this);
        itemView.setOnClickListener(this);

    }

    public void setItemClickListener (ItemClickListener itemClickListener){
        this.itemClickListener=itemClickListener;
    }

    @Override
    public void onClick(View view) {
        itemClickListener.onClick(view,getAdapterPosition(),false);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        menu.setHeaderTitle("編輯");
        menu.add(0,0,getAdapterPosition(), Common.UPDATE);
        menu.add(0,0,getAdapterPosition(), Common.DELETE);

    }
}