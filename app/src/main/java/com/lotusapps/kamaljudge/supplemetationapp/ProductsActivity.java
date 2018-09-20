package com.lotusapps.kamaljudge.supplemetationapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class ProductsActivity extends AppCompatActivity {

    SingeltonClass singeltonObj;
    String[] subtitle ={
            "Sub Title 1","Sub Title 2",
            "Sub Title 3","Sub Title 4",
    };

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_products);
        singeltonObj = singeltonObj.getInstance( );
        ListView list = findViewById(R.id.list_product);
        MyListAdaptor adapter = new MyListAdaptor(this, singeltonObj.singeltonsubTitle, subtitle,singeltonObj.singeltonsubImgid);
        list.setAdapter(adapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {
                singeltonObj.descriptionName = singeltonObj.singeltonsubTitle[position];
                singeltonObj.descriptionId = singeltonObj.singeltonsubImgid[position];
                Intent productIntent = new Intent(ProductsActivity.this,ProductDescriptionActicity.class);
                startActivity(productIntent);
            }
        });
    }
}
