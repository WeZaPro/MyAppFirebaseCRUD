package com.example.myappfirebasecrud;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

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
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_item, parent, false);

        return new VH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull VH holder, int position) {

        holder.tvName.setText(listData.get(position).getName());
        holder.tvNumber.setText(listData.get(position).getNumber());

    }

    @Override
    public int getItemCount() {
        return listData.size();
    }

    public class VH extends RecyclerView.ViewHolder{

        TextView tvName,tvNumber;

        public VH(@NonNull View itemView) {
            super(itemView);

            tvName = itemView.findViewById(R.id.tvName);
            tvNumber = itemView.findViewById(R.id.tvNumber);
        }
    }
}
