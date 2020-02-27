package com.example.myappfirebasecrud;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import static com.example.myappfirebasecrud.MainActivity.currentUser;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.VH> {

    Context context;
    ArrayList<MyModelData> listData;

    public MyAdapter(Context context, ArrayList<MyModelData> listData) {

        this.context = context;
        this.listData = listData;

    }

    @NonNull
    @Override
    public VH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView;
        itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_item, parent, false);

        return new VH(itemView);
    }


    @Override
    public void onBindViewHolder(@NonNull VH holder, int position) {

        if(currentUser.isEmpty()){
            holder.tvName.setText(listData.get(position).getName());

        }else {


            if (listData.get(position).getUID().equals(currentUser)) {
                //ซ่อนข้อมูล
                holder.itemView.setVisibility(View.GONE);
                // ให้ Item ถัดไปเลื่อนขึ้นมา
                holder.itemView.setLayoutParams(new RecyclerView.LayoutParams(0, 0));
            } else {
            /*holder.itemView.setVisibility(View.VISIBLE);
            holder.itemView.setLayoutParams(new RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));*/

                holder.tvName.setText(listData.get(position).getName());

            }


        }

    }

    @Override
    public int getItemCount() {
        return listData.size();
    }

    public class VH extends RecyclerView.ViewHolder {

        TextView tvName;

        public VH(@NonNull View itemView) {
            super(itemView);

            tvName = itemView.findViewById(R.id.tvName);
        }
    }
}
