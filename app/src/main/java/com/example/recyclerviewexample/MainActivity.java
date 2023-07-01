package com.example.recyclerviewexample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<CustomData> data = new ArrayList<>(); // This ArrayList will contain our data set.

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // populate our ArrayList
        addData();

        // now create and set the adapter
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(this, data);
        recyclerView.setAdapter(adapter);

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