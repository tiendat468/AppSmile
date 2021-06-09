package com.example.lab8_ungdungdongian;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity_SignIn extends AppCompatActivity {

    Button btnSI;
    TextView txtReg,txtSI_GG;
    EditText email,pass;

    private FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signin);
        btnSI = (Button) findViewById(R.id.btn_SI_SI);
        txtReg =(TextView) findViewById(R.id.reg_SI);
        txtSI_GG = (TextView) findViewById(R.id.txt_SI_GG);
        email = (EditText) findViewById(R.id.email_SI);
        pass = (EditText) findViewById(R.id.pass_SI);

        auth = FirebaseAuth.getInstance();

        btnSI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email1 = email.getText().toString().trim();
                String password = pass.getText().toString().trim();

                if (TextUtils.isEmpty(email1)) {
                    Toast.makeText(getApplicationContext(), "Enter email address!", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (TextUtils.isEmpty(password)) {
                    Toast.makeText(getApplicationContext(), "Enter password!", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (password.length() < 6) {
                    Toast.makeText(getApplicationContext(), "Password too short, enter minimum 6 characters!", Toast.LENGTH_SHORT).show();
                    return;
                }
                auth.signInWithEmailAndPassword(email1, password).addOnCompleteListener(MainActivity_SignIn.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (!task.isSuccessful()) {
                            Toast.makeText(MainActivity_SignIn.this, "Authentication failed." + task.getException(),
                                    Toast.LENGTH_SHORT).show();
                        } else {
                            startActivity(new Intent(MainActivity_SignIn.this, MainActivity_Vote.class));
                            finish();
                        }
                    }
                });
            }
        });

        txtReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intent = new Intent(MainActivity_SignIn.this,MainActivity_Register.class);
//                startActivity(intent);
                Intent intent = new Intent(MainActivity_SignIn.this,MainActivity_Register.class);
                startActivity(intent);
            }
        });

        txtSI_GG.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

    }
}