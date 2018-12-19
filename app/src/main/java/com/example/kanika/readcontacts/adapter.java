package com.example.kanika.readcontacts;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class adapter extends RecyclerView.Adapter<adapter.MyViewHolder> {
    Context context;
    List<model> mymodels;

    public adapter(Context context, List<model> mymodels) {
        this.context = context;
        this.mymodels = mymodels;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemview= LayoutInflater.from(parent.getContext()).inflate(R.layout.contacts,parent,false);
        return new MyViewHolder(itemview);    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        model mymodel1=mymodels.get(position);
        holder.name.setText(mymodel1.getName());
        holder.number.setText(mymodel1.getNumber());
    }

    @Override
    public int getItemCount() {
        return mymodels.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView name,number;
        public MyViewHolder(View itemView) {
            super(itemView);
            name= (TextView) itemView.findViewById(R.id.name);
            number= (TextView) itemView.findViewById(R.id.number);
        }
    }
}
