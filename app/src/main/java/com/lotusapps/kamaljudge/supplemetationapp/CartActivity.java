package com.lotusapps.kamaljudge.supplemetationapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;


public class CartActivity extends AppCompatActivity {


    private CartAdaptor adapter;
    SingeltonClass singeltonObj;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);
        singeltonObj = singeltonObj.getInstance( );
        Button btn_placeOrder = findViewById(R.id.btn_placeOrder);


        // set up the RecyclerView
        RecyclerView recyclerView = findViewById(R.id.my_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        adapter = new CartAdaptor(this, singeltonObj.cartName,singeltonObj.cartID);

        recyclerView.setAdapter(adapter);

        btn_placeOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent placeIntent = new Intent(CartActivity.this,PlaceOrderActivity.class);
                startActivity(placeIntent);

            }
        });




    }
}
