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

public class MainActivity_Register extends AppCompatActivity {

    Button btnReg;
    TextView txtSI_GG,txtSI_Reg;
    EditText name,email_reg,pass,pass1;
    private FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);
        btnReg = (Button) findViewById(R.id.btn_Reg_Reg);
        txtSI_Reg =(TextView) findViewById(R.id.txt_SI_Reg);
        txtSI_GG = (TextView) findViewById(R.id.txt_SI_GG_Reg);
        name = (EditText) findViewById(R.id.yourname);
        email_reg = (EditText) findViewById(R.id.email_Reg);
        pass = (EditText) findViewById(R.id.pass_Reg);
        pass1 = (EditText) findViewById(R.id.pass1_Reg);

        auth = FirebaseAuth.getInstance();

        btnReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email1 = email_reg.getText().toString().trim();
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
                auth.createUserWithEmailAndPassword(email1,password).addOnCompleteListener(MainActivity_Register.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (!task.isSuccessful()) {
                            Toast.makeText(MainActivity_Register.this, "Authentication failed." + task.getException(),
                                    Toast.LENGTH_SHORT).show();
                        } else {
                            startActivity(new Intent(MainActivity_Register.this, MainActivity_SignIn.class));
                            finish();
                        }
                    }
                });


            }
        });

        txtSI_Reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intent = new Intent(MainActivity_SignIn.this,MainActivity_Register.class);
//                startActivity(intent);
                Intent intent = new Intent(MainActivity_Register.this,MainActivity_SignIn.class);
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