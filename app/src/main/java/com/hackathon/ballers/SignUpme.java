package com.hackathon.ballers;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class SignUpme extends AppCompatActivity {
    private FirebaseAuth mAuth;
    private EditText ePassword, eEmail;
    private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_upme);

        mAuth = FirebaseAuth.getInstance();
        ePassword = findViewById(R.id.ePassword);
        eEmail = findViewById(R.id.eEmail);
        button = (Button) findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = eEmail.getText().toString();
                String password = ePassword.getText().toString();

                if (email.isEmpty()) {
                    eEmail.setError("Please enter your email");
                    eEmail.requestFocus();
                }
                if (password.isEmpty()) {
                    ePassword.setError("Please enter a password");
                    ePassword.requestFocus();
                }

                if (!(password.isEmpty() && email.isEmpty())) {
                    mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(SignUpme.this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (!task.isSuccessful()) {
                                Toast.makeText(SignUpme.this, "Please try again", Toast.LENGTH_SHORT).show();
                            } else {
                                startActivity(new Intent(SignUpme.this, MyGames.class));
                            }
                        }
                    });
                }
            }
        });}}