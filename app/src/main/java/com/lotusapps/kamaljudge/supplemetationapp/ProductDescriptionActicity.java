package com.lotusapps.kamaljudge.supplemetationapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.QuickContactBadge;
import android.widget.TextView;
import android.widget.Toast;

public class ProductDescriptionActicity extends AppCompatActivity {

    SingeltonClass singeltonObj;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        singeltonObj = singeltonObj.getInstance( );

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_description_acticity);

        TextView tvprice = findViewById(R.id.textItemName);
        Button addtoCart = findViewById(R.id.button2);
        tvprice.setText(singeltonObj.descriptionName);
        new DownloadImageTask((ImageView) findViewById(R.id.descImage))
                .execute(singeltonObj.descriptionId);

        addtoCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Toast.makeText(ProductDescriptionActicity.this, "Item Added In Cart", Toast.LENGTH_SHORT).show();
                singeltonObj.cartID.add("$50");
                singeltonObj.cartName.add(singeltonObj.descriptionName);

            }
        });
    }
}
