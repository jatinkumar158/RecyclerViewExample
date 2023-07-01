package com.example.recyclerviewexample;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

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

        // adding click event to each item
        // adding functionality to update the item
        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Dialog dialog = new Dialog(context);
                dialog.setContentView(R.layout.dialog_add_update_layout);

                EditText editText = dialog.findViewById(R.id.dialog_add_update_edittext);
                Button button = dialog.findViewById(R.id.dialog_add_update_button);
                TextView textView = dialog.findViewById(R.id.dialog_add_update_textview);

                textView.setText("Update the item");
                button.setText("Update");
                editText.setText(data.get(position).text);

                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        String name = editText.getText().toString();
                        if(!name.equals("")) {
                            data.set(position, new CustomData(data.get(position).image, name));
                            notifyItemChanged(position);
                            dialog.dismiss();
                        } else {
                            Toast.makeText(context, "Name can't be empty", Toast.LENGTH_SHORT).show();
                        }

                    }
                });

                dialog.show();
            }
        });


        holder.linearLayout.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {

                String name = data.get(position).text;
                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                builder.setTitle("Delete")
                        .setMessage("Do you really want to delete the entry " + name + "?")
                        .setIcon(R.drawable.delete_button)
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                data.remove(position);
                                notifyItemRemoved(position);
                            }
                        })
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Toast.makeText(context, "Delete operatin cancelled", Toast.LENGTH_SHORT).show();
                            }
                        }).show();

                return true;
            }
        });


    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView textView;
        LinearLayout linearLayout;

        public MyViewHolder(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.recycler_view_item_image);
            textView = itemView.findViewById(R.id.recycler_view_item_text);
            linearLayout = itemView.findViewById(R.id.recycler_view_item_ll);
        }
    }
}
