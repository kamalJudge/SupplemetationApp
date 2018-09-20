package com.lotusapps.kamaljudge.supplemetationapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.lotusapps.kamaljudge.supplemetationapp.Model.Category;
import com.lotusapps.kamaljudge.supplemetationapp.Model.Orders;

public class MainActivity extends AppCompatActivity {

    Button btnSignIn,btnSignUp;
    TextView txtSlogan;
    Category profile;
    String titleName,imageName;
    SingeltonClass singeltonObj;
    Orders ordersProfile;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        singeltonObj = singeltonObj.getInstance( );

        btnSignIn =(Button)findViewById(R.id.btnSignIn);
        btnSignUp = (Button)findViewById(R.id.btnSignUp);


        for(int i = 1 ; i<9 ; i++)
        {
            firebaseCall(i);
        }
        for(int i = 1 ; i<5 ; i++)
        {
            subfirebaseCall(i);
            ordersfirebaseCall(i);
        }

        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent signUp = new Intent(MainActivity.this,SignUp.class);
                startActivity(signUp);
            }
        });

        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent signIn = new Intent(MainActivity.this,SignIn.class);
                startActivity(signIn);
            }
        });
    }

    public Category firebaseCall(final int i)
    {

        final FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference ref = database.getReference("Category/0"+Integer.toString(i));
        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                profile = dataSnapshot.getValue(Category.class);
                titleName = profile.getName();
                imageName = profile.getImage();
                singeltonObj.singeltonTitle[i-1] = titleName;
                singeltonObj.singeltonImgid[i-1] = imageName;
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                System.out.println("The read failed: " + databaseError.getCode());
            }
        });
        return profile;
    }

    public Category subfirebaseCall(final int i)
    {

        final FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference ref = database.getReference("SubCat/0"+Integer.toString(i));
        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                profile = dataSnapshot.getValue(Category.class);
                titleName = profile.getName();
                imageName = profile.getImage();
                singeltonObj.singeltonsubTitle[i-1] = titleName;
                singeltonObj.singeltonsubImgid[i-1] = imageName;
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                System.out.println("The read failed: " + databaseError.getCode());
            }
        });
        return profile;
    }

    public void ordersfirebaseCall(final int i)
    {

        final FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference ref = database.getReference("Orders/"+Integer.toString(i));
        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                ordersProfile = dataSnapshot.getValue(Orders.class);
                if(ordersProfile!= null)
                {
                    titleName = ordersProfile.getName();
                    imageName = ordersProfile.getPassword();
                    singeltonObj.ordersName.add(titleName);
                    singeltonObj.ordersAddress.add(imageName);
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                System.out.println("The read failed: " + databaseError.getCode());
            }
        });
    }


}
