package com.example.wenqwang.ezparking;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Profile extends AppCompatActivity implements View.OnClickListener{

    private FirebaseAuth firebaseAuth;
    private Button buttonlogout;
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
    }

    @Override
    public void onClick(View view) {

        if(view == buttonlogout)
        {
           finish();
           startActivity(new Intent(this,Login.class));
        }

    }
}
