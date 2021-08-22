package com.hackathon.ballers;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class HomePage extends AppCompatActivity {
    TextView eLocation, eTime, eDate;
    DatabaseReference reff;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        eLocation = (TextView) findViewById(R.id.eLocation);
        eTime = (TextView) findViewById(R.id.eTime);
        eDate = (TextView) findViewById(R.id.eDate);

        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        String email = user.getEmail();
        reff = FirebaseDatabase.getInstance().getReference().child(email).child("games");
        reff.addValueEventListener(new ValueEventListener(){
            @Override
            public void onDataChange(@NonNull DataSnapshot ds) {
                String location = ds.child("Location").getValue().toString();
                String time = ds.child("Time").getValue().toString();
                String date = ds.child("Date").getValue().toString();
                eLocation.setText(location);
                eTime.setText(time);
                eDate.setText(date);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError)
            {}
        });
    }
}