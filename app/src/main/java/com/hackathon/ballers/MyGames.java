package com.hackathon.ballers;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class MyGames extends AppCompatActivity {
    private EditText eLocation, eDate, eTime, eAgeGroup, eGender;
    private Button button;
    private String name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_games);

        eLocation = findViewById(R.id.eLocation);
        eDate = findViewById(R.id.eDate);
        eTime= findViewById(R.id.eTime);
        eAgeGroup = findViewById(R.id.eAgeGroup);
        eGender= findViewById(R.id.eGender);
        button= findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                HashMap<String, Object> map = new HashMap<>();
                map.put("Location", eLocation.getText().toString());
                map.put("Date", eDate.getText().toString());
                map.put("Time", eTime.getText().toString());
                map.put("Age Group", eAgeGroup.getText().toString());
                map.put("Gender", eGender.getText().toString());
                FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
                String email = user.getEmail();

                FirebaseDatabase.getInstance().getReference().child(email).child("game")
                        .setValue(map)
                        .addOnCompleteListener(new OnCompleteListener<Void>()
                        {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {
                                Log.i("asdfs", "onComplete: ");
                            }
                        })

                        .addOnFailureListener(new OnFailureListener(){
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Log.i("asdfs", "onFailure: " + e.toString());
                            }
                });
            }
        });
    }
}