package com.lotusapps.kamaljudge.supplemetationapp;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.lotusapps.kamaljudge.supplemetationapp.Model.User;

public class PlaceOrderActivity extends AppCompatActivity {

    EditText et_Name , et_Address , et_postalCode;
    Button bt;
    SingeltonClass singeltonObj;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_place_order);
        singeltonObj = singeltonObj.getInstance( );

        et_Name = findViewById(R.id.editText);
        et_Address = findViewById(R.id.editText2);
        et_postalCode = findViewById(R.id.editText3);
        bt = findViewById(R.id.button3);

        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                final FirebaseDatabase database = FirebaseDatabase.getInstance();
                final DatabaseReference table_user = database.getReference("Orders");

                final ProgressDialog mDialog = new ProgressDialog(PlaceOrderActivity.this);
                mDialog.setMessage("Please waiting...");
                mDialog.show();
              //  singeltonObj.ordersName.add(et_Name.getText().toString());
              //  singeltonObj.ordersAddress.add(et_Address.getText().toString());

                table_user.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {

                        if (dataSnapshot.child(et_Name.getText().toString()).exists()) {
                            mDialog.dismiss();
                            //Toast.makeText(SignUp.this, "Phone Number Already exist", Toast.LENGTH_SHORT).show();
                        } else {
                            mDialog.dismiss();
                            User user = new User(et_Name.getText().toString(), et_Address.getText().toString());
                            table_user.child(et_postalCode.getText().toString()).setValue(user);

                            Toast.makeText(PlaceOrderActivity.this, "Order Confirmed Successfuly", Toast.LENGTH_SHORT).show();
                            finish();

                        }
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {
                    }

                });


            }
        });
    }
}
