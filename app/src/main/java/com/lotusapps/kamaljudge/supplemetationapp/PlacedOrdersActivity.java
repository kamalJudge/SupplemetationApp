package com.lotusapps.kamaljudge.supplemetationapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;


public class PlacedOrdersActivity extends AppCompatActivity {


    private CartAdaptor adapter;
    SingeltonClass singeltonObj;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_placed_orders);
        singeltonObj = singeltonObj.getInstance( );





        // data to populate the RecyclerView with

        // set up the RecyclerView
        RecyclerView recyclerView = findViewById(R.id.my_recycler_view_orders);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        adapter = new CartAdaptor(this,singeltonObj.ordersName ,singeltonObj.ordersAddress);

        recyclerView.setAdapter(adapter);

    }
}
