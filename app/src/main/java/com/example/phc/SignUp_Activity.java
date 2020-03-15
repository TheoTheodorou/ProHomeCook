package com.example.phc;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class SignUp_Activity extends AppCompatActivity {

    private EditText editTextEmail, editTextPassword, editTextConfirmPassword;

    public static Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        actionRegisterPress();
        actionLoginPress();

        context = this;

        editTextEmail = findViewById(R.id.email_signUp);
        editTextPassword = findViewById(R.id.password_signUp);
        editTextConfirmPassword = findViewById(R.id.confirmPassword_signUp);

    }

    private void actionRegisterPress() {
        RelativeLayout registerButton = (RelativeLayout) findViewById(R.id.relativeSignUp);
        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registerUser();
            }
        });
    }

    private void registerUser() {
        String email = editTextEmail.getText().toString().trim();
        String password = editTextPassword.getText().toString().trim();
        String confirmPassword = editTextConfirmPassword.getText().toString().trim();

        if (email.isEmpty()){
            editTextEmail.setError("Email is required");
            editTextEmail.requestFocus();
            return;
        }

        if (password.isEmpty()){
            editTextPassword.setError("Password is required");
            editTextPassword.requestFocus();
            return;
        }

        if (confirmPassword.isEmpty()){
            editTextConfirmPassword.setError("Please retype password");
            editTextConfirmPassword.requestFocus();
            return;
        }

        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            editTextEmail.setError("Please enter a vail email address");
            editTextEmail.requestFocus();
            return;
        }

        if(password.length()<6){
            editTextPassword.setError("Password should be at least 6 characters long");
            editTextPassword.requestFocus();
            return;
        }



        LoginActivity.mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign up success, update UI with the signed-in user's information
                            FirebaseUser user = LoginActivity.mAuth.getCurrentUser();
                        } else {
                            Toast.makeText(context, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }


    private void actionLoginPress() {
        TextView loginText = (TextView) findViewById(R.id.text_login_signUp);
        loginText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SignUp_Activity.this,LoginActivity.class));
            }
        });
    }
}
