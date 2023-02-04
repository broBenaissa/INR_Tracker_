package com.example.suivez_inr;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.suivez_inr.Mon_Graphique_INR;

import java.util.ArrayList;

class Adapter extends RecyclerView.Adapter<Adapter.myViewHolder> {

    Context context;
    ArrayList<Mon_Graphique_INR> arrayList ;
    RecyclerView recyclerView;

    public Adapter(Context context, ArrayList<Mon_Graphique_INR> arrayList) {
        this.context=context;
        this.arrayList=arrayList;
    }

    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//valid
        LayoutInflater inflater=LayoutInflater.from(context);
        View view =inflater.inflate(R.layout.activity_mon_graphique_inr,parent,false);

       // RelativeLayout item = (RelativeLayout) Mon_Graphique_INR.findViewById(R.id.item);
        //View child = getLayoutInflater().inflate(R.layout.child, null);
       // item.addView(child);

        return new Adapter.myViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myViewHolder holder, int position) {
       // holder.setText(arrayList.get(position));


    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public static class myViewHolder extends RecyclerView.ViewHolder{
        RelativeLayout grapheView;
        private Object my_Interface;
        //2
        public myViewHolder(@NonNull View itemView) {
            super(itemView);
            grapheView=itemView.findViewById(R.id.graph);


        }

    }
}

