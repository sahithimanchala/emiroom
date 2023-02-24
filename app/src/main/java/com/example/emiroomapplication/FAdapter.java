package com.example.emiroomapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import java.util.List;

public class FAdapter extends RecyclerView.Adapter<FAdapter.ViewHolder>{
    Context ct;
    List<EmiEntity> list;

    public FAdapter(recycleractivity mainActivity, List<EmiEntity> list) {
        this.ct = mainActivity;
        this.list = list;
    }



    @NonNull
    @Override
    public FAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(ct).inflate(R.layout.fetch,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull FAdapter.ViewHolder holder, int position) {
       holder.s1.setText(list.get(position).getDate());
       holder.s2.setText(list.get(position).getName());
       holder.s3.setText(list.get(position).getAmount());
       holder.s4.setText(list.get(position).getEmi());
       holder.s5.setText(list.get(position).getInterest());
       holder.s6.setText(list.get(position).getTotalamount());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public  class ViewHolder extends RecyclerView.ViewHolder{
        TextView s1,s2,s3,s4,s5,s6;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            s1= itemView.findViewById(R.id.ftime);
            s2= itemView.findViewById(R.id.fname);
            s3= itemView.findViewById(R.id.famount);
            s4= itemView.findViewById(R.id.femi);
            s5= itemView.findViewById(R.id.finterest);
            s6= itemView.findViewById(R.id.ftotalamount);



        }
    }

}
