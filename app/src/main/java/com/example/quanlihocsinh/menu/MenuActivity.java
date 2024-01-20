package com.example.quanlihocsinh.menu;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;

import com.example.quanlihocsinh.R;
import com.example.quanlihocsinh.main.MainActivity;

public class MenuActivity extends AppCompatActivity {
    CardView studentsCard,schoolCard,newsCard,photosCard,TKBCard,settingsCard;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

        studentsCard = findViewById(R.id.studentsCard);
        schoolCard = findViewById(R.id.schoolCard);
        newsCard = findViewById(R.id.newsCard);
        photosCard = findViewById(R.id.photosCard);
        TKBCard = findViewById(R.id.TKBCard);
        settingsCard = findViewById( R.id.settingsCard);

        studentsCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MenuActivity.this, MainActivity.class);
                startActivity(i);
            }
        });

        schoolCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showFalseDialog1();
            }
        });
        newsCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showFalseDialog1();
            }
        });
        photosCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showFalseDialog1();

            }
        });
        TKBCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showFalseDialog1();

            }
        });
        settingsCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showFalseDialog1();
            }
        });

    }

    private void showFalseDialog1() {
        ConstraintLayout falseConstraintLayout2 = findViewById(R.id.falseConstrainLayout2);
        View view = LayoutInflater.from(MenuActivity.this).inflate(R.layout.false_dialog_2, falseConstraintLayout2);
        Button falseDone2 = view.findViewById(R.id.falseDone_2);

        AlertDialog.Builder builder = new AlertDialog.Builder(MenuActivity.this);
        builder.setView(view);
        final AlertDialog alertDialog2 = builder.create();

        falseDone2.findViewById(R.id.falseDone_2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertDialog2.dismiss();
                //Toast.makeText(MainActivity.this, "OK", Toast.LENGTH_SHORT).show();
            }
        });
        if (alertDialog2.getWindow()!=null) {
            alertDialog2.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        }
        alertDialog2.show();
    }
}