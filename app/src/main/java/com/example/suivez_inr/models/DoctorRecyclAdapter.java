package com.example.suivez_inr.models;

/*
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

public class Adapter extends RecyclerView.Adapter<Adapter.myViewHolder> {

    Context context;
    ArrayList<Mon_Graphique_INR> arrayList ;

    public Adapter(Context context, ArrayList<Mon_Graphique_INR> arrayList) {
        this.context=context;
        this.arrayList=arrayList;
    }

    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater=LayoutInflater.from(context);
        View view =inflater.inflate(R.layout.one_row,parent,false);

        RelativeLayout item = (RelativeLayout)findViewById(R.id.item);
        View child = getLayoutInflater().inflate(R.layout.child, null);
        item.addView(child);

        return new Adapter.myViewHolder(view,my_Interface);
    }

    @Override
    public void onBindViewHolder(@NonNull myViewHolder holder, int position) {
        holder.data.setText(arrayList.get(position).getName());


    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public static class myViewHolder extends RecyclerView.ViewHolder{
        RelativeLayout grapheView;
        //private Object my_Interface;//2
        //2
      //  public myViewHolder(@NonNull View itemView/*,myInterface my_Interface) {
          //  super(itemView);
          //  grapheView=itemView.findViewById(R.id.graph);

            /*itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if ((my_Interface != null)){
                        int pos = getAdapterPosition();
                        if (pos !=RecyclerView.NO_POSITION){
                            my_Interface.onItemClick(pos);
                        }
                    }

                }
            });

        }

    }
}
}*/
