package com.example.datastorage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView tvBlack, tvRed, tvBlue, tvGreen, tvNumber;
    Button btnCount;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AnhXa();
        editor = sharedPreferences.edit();

        tvNumber.setText(sharedPreferences.getString("number", "0"));
        tvNumber.setBackgroundColor(sharedPreferences.getInt("background", Color.DKGRAY));
        tvBlack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tvNumber.setBackgroundColor(Color.BLACK);
                tvNumber.setTextColor(Color.WHITE);
                editor.putInt("background", Color.BLACK);
                editor.commit();
            }
        });
        tvRed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tvNumber.setBackgroundColor(Color.RED);
                editor.putInt("background", Color.RED);
                editor.commit();
            }
        });
        tvBlue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tvNumber.setBackgroundColor(Color.BLUE);
                editor.putInt("background", Color.BLUE);
                editor.commit();
            }
        });
        tvGreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tvNumber.setBackgroundColor(Color.GREEN);
                editor.putInt("background", Color.GREEN);
                editor.commit();
            }
        });

        btnCount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int currenValue = Integer.parseInt(tvNumber.getText().toString());
                currenValue++;
                tvNumber.setText("" + currenValue);
                editor.putString("number", String.valueOf(currenValue));
                editor.commit();
            }
        });
    }

    private void AnhXa() {
        btnCount = findViewById(R.id.buttonCount);
        tvNumber = findViewById(R.id.textViewNumber);
        tvBlack = findViewById(R.id.black);
        tvRed = findViewById(R.id.red);
        tvBlue = findViewById(R.id.blue);
        tvGreen = findViewById(R.id.green);
        sharedPreferences = getApplicationContext().getSharedPreferences("data1", Context.MODE_PRIVATE);
    }
}