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

public class LocalGames extends AppCompatActivity {
    TextView eLocation, eTime, eDate, eGender, eAgeGroup;
    DatabaseReference reff;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_local_games);

        eLocation = (TextView) findViewById(R.id.eLocation);
        eTime = (TextView) findViewById(R.id.eTime);
        eDate = (TextView) findViewById(R.id.eDate);
        eGender = (TextView) findViewById(R.id.eGender);
        eAgeGroup = (TextView) findViewById(R.id.eAgeGroup);

        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        String email = user.getEmail();
        reff = FirebaseDatabase.getInstance().getReference().child(email).child("games");
        reff.addValueEventListener(new ValueEventListener(){
            @Override
            public void onDataChange(@NonNull DataSnapshot ds) {
                String location = ds.child("Location").getValue().toString();
                String time = ds.child("Time").getValue().toString();
                String date = ds.child("Date").getValue().toString();
                String gender = ds.child("Gender").getValue().toString();
                String ageGroup = ds.child("Age Group").getValue().toString();
                eLocation.setText(location);
                eTime.setText(time);
                eDate.setText(date);
                eGender.setText(gender);
                eAgeGroup.setText(ageGroup);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError)
            {}
        });
    }
}