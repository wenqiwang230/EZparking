package com.example.wenqwang.ezparking;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;

import java.util.ArrayList;

public class Profile extends AppCompatActivity implements View.OnClickListener{
    private FirebaseAuth firebaseAuth;
    private Button buttonlogout, viewbooking, newbooking;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        firebaseAuth = FirebaseAuth.getInstance();
        if(firebaseAuth.getCurrentUser()==null)
        {
            finish();
            startActivity(new Intent(this,Login.class));
        }
        FirebaseUser user = firebaseAuth.getCurrentUser();
        buttonlogout = (Button)findViewById(R.id.button4);
        buttonlogout.setOnClickListener(this);
        viewbooking = (Button)findViewById(R.id.button3);
        viewbooking.setOnClickListener(this);
        newbooking = (Button)findViewById(R.id.button);
        newbooking.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        if(view == buttonlogout)
        {
            FirebaseAuth.getInstance().signOut();
            startActivity(new Intent(this,Login.class));
        }
        if( view == viewbooking)
        {
            startActivity(new Intent(this,BookingView.class));
        }
        if( view == newbooking)
        {
            startActivity(new Intent(this,Booking.class));
        }

    }
}
