package com.example.lab8_ungdungdongian;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity_Vote extends AppCompatActivity {

    ImageView vui,bt,buon;
    Button finish;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.vote);
        bt = (ImageView) findViewById(R.id.imgBT);
        vui = (ImageView) findViewById(R.id.imgVui);
        buon = (ImageView) findViewById(R.id.imgBuon);
        finish = (Button) findViewById(R.id.finish);

        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity_Vote.this, "binh thuong", Toast.LENGTH_SHORT).show();
            }
        });
        vui.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity_Vote.this, "vui", Toast.LENGTH_SHORT).show();

            }
        });
        buon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity_Vote.this, "buon", Toast.LENGTH_SHORT).show();

            }
        });

        finish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity_Vote.this,MainActivity_Vote.class);
                startActivity(intent);

            }
        });
    }
}