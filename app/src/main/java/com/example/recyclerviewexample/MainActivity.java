package com.example.recyclerviewexample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<CustomData> data = new ArrayList<>(); // This ArrayList will contain our data set.
    RecyclerViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        FloatingActionButton floatingActionButton = findViewById(R.id.floating_action_button);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // populate our ArrayList
        addData();

        // now create and set the adapter
        adapter = new RecyclerViewAdapter(this, data);
        recyclerView.setAdapter(adapter);

        // add action to our floating action button
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Dialog dialog = new Dialog(MainActivity.this);
                dialog.setContentView(R.layout.dialog_add_update_layout);

                EditText editText = dialog.findViewById(R.id.dialog_add_update_edittext);
                Button button = dialog.findViewById(R.id.dialog_add_update_button);

                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if(!editText.getText().toString().equals("")) {
                            String name = editText.getText().toString();
                            data.add(new CustomData(R.drawable.a, name));
                            adapter.notifyItemInserted(data.size() - 1);
                            recyclerView.scrollToPosition(data.size() - 1);
                            dialog.dismiss();
                        } else {
                            Toast.makeText(MainActivity.this, "Name can't be empty", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
                dialog.show();
            }
        });

    }

    private void addData() {

        data.add(new CustomData(R.drawable.a, "Jatin"));
        data.add(new CustomData(R.drawable.b, "Sachin"));
        data.add(new CustomData(R.drawable.c, "Tarun"));
        data.add(new CustomData(R.drawable.d, "Prashant"));
        data.add(new CustomData(R.drawable.e, "Pinak"));
        data.add(new CustomData(R.drawable.f, "Crypty"));
        data.add(new CustomData(R.drawable.a, "Varish"));
        data.add(new CustomData(R.drawable.b, "Shani"));
        data.add(new CustomData(R.drawable.c, "Suraj"));
        data.add(new CustomData(R.drawable.d, "Mridul"));
        data.add(new CustomData(R.drawable.a, "Jatin"));
        data.add(new CustomData(R.drawable.b, "Sachin"));
        data.add(new CustomData(R.drawable.c, "Tarun"));
        data.add(new CustomData(R.drawable.d, "Prashant"));
        data.add(new CustomData(R.drawable.e, "Pinak"));
        data.add(new CustomData(R.drawable.f, "Crypty"));
        data.add(new CustomData(R.drawable.a, "Varish"));
        data.add(new CustomData(R.drawable.b, "Shani"));
        data.add(new CustomData(R.drawable.c, "Suraj"));
        data.add(new CustomData(R.drawable.d, "Mridul"));

    }

}