package com.example.lore;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.MyViewHolder> {

    private List<Table> table;
    private Context context;
    private List<Table>  filteredtable;

    public Adapter(List<Table> table, Context context) {
        this.table = table;
        this.context = context;
        this.filteredtable=table;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false );

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        holder.MEDICINE_NAME.setText(table.get(position).getMedicine ());
        holder.AVAILABILITY.setText(table.get(position).getAvailability());
        holder.SHOPNAME_ADDRESS.setText(table.get(position).getShop_Add());

    }

    @Override
    public int getItemCount() {

        return filteredtable.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        TextView MEDICINE_NAME,AVAILABILITY,SHOPNAME_ADDRESS;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            MEDICINE_NAME=itemView.findViewById(R.id.MEDICINE_NAME);
            AVAILABILITY=itemView.findViewById(R.id.AVAILABILITY);
            SHOPNAME_ADDRESS=itemView.findViewById(R.id.SHOPNAME_ADDRESS);
        }
    }
}

