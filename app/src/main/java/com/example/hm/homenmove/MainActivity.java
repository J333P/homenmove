package com.example.hm.homenmove;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

public class MainActivity extends AppCompatActivity {

    private RecyclerView monRecyclerView;
    private RecyclerView.Adapter monAdapter;
    private RecyclerView.LayoutManager monLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        monRecyclerView = (RecyclerView) findViewById(R.id.recycleView);

        monLayoutManager = new LinearLayoutManager(this);
        monRecyclerView.setLayoutManager(monLayoutManager);

        String[] monDataSet = {"1","2","3","4"};
        monAdapter = new AdapterMain(getBaseContext(), monDataSet);
        monRecyclerView.setAdapter(monAdapter);
    }
}
