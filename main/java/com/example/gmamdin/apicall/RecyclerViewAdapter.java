package com.example.gmamdin.apicall;


import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder>{

   private List<Places> places;



    public RecyclerViewAdapter(List<Places> places) {
       this.places=places;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.item_places, parent, false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
            holder.city.setText(places.get(position).getDescription());
            holder.rank.setText(places.get(position).getId().toString());

        }

    @Override
    public int getItemCount() {
        return places.size();
    }

    public static  class MyViewHolder extends RecyclerView.ViewHolder{
        private TextView city;
        private TextView rank;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            city=(TextView)itemView.findViewById(R.id.cityname);
            rank=(TextView)itemView.findViewById(R.id.cityrank);

        }
    }
}
