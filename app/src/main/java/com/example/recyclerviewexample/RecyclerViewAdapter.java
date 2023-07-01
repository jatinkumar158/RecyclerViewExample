package com.example.recyclerviewexample;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {

    Context context;
    ArrayList<CustomData> data;

    public RecyclerViewAdapter(Context context, ArrayList<CustomData> data) {
        // As current class is not an activity class so we can't use this keyword
        // so to have context we will call this class from an activity class (like MainActivity.java)
        // and will pass the context from there
        this.context = context;
        this.data = data;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // In this you create view from the layout
        // we will create view from our xml so for that reason we have use layout inflator
        View view = LayoutInflater.from(context).inflate(R.layout.recycler_view_item, parent, false);
        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        // here we will bind the data to view holder
        // but here we can't use findViewById but our MyViewHolder class has access to the view
        // so we will set the findViewById in MyViewHolder class

        // now our ViewHolder has access to imageView and textView
        // now to set the data we must have data, so add it in the constructor
        // now set the data
        holder.imageView.setImageResource(data.get(position).image); // set image
        holder.textView.setText(data.get(position).text); // set text
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView textView;

        public MyViewHolder(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.recycler_view_item_image);
            textView = itemView.findViewById(R.id.recycler_view_item_text);
        }
    }
}
