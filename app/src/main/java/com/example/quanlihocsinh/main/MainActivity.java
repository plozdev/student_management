package com.example.quanlihocsinh.main;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.Toast;

import com.example.quanlihocsinh.R;
import com.example.quanlihocsinh.classActivity.LTActivity;

public class MainActivity extends AppCompatActivity {
    String[] items = {"Khối 10", "Khối 11", "Khối 12"};
    String[] secondItems = {};
    AutoCompleteTextView autoCompleteTxt;
    AutoCompleteTextView secondAutoCompleteTxt;

    Button buttonNext;
    ArrayAdapter<String> adapterItems;
    ArrayAdapter<String> secondAdapterItems;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        buttonNext = findViewById(R.id.buttonNext);


        autoCompleteTxt = findViewById(R.id.auto_complete_txt);
        adapterItems = new ArrayAdapter<>(this, R.layout.list_item,items);
        autoCompleteTxt.setAdapter(adapterItems);

        secondAutoCompleteTxt = findViewById(R.id.second_auto_complete_txt);
        secondAutoCompleteTxt.setVisibility(View.GONE);

        autoCompleteTxt.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selectedText = parent.getItemAtPosition(position).toString();
                Toast.makeText(MainActivity.this, "Bạn đã chọn: "+selectedText, Toast.LENGTH_SHORT).show();
                secondItems = new String[0];
                // Update the data and adapter for the second AutoCompleteTextView based on the selected item
                updateSecondAutoCompleteSuggestions(selectedText);
                secondAdapterItems = new ArrayAdapter<>(MainActivity.this, R.layout.list_item, secondItems);
                // Set the updated adapter to the second AutoCompleteTextView
                secondAutoCompleteTxt.setAdapter(secondAdapterItems);
                secondAutoCompleteTxt.setVisibility(View.VISIBLE);
            }
        });

        secondAutoCompleteTxt.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                buttonNext.setVisibility(View.VISIBLE);
                String selectedText = parent.getItemAtPosition(position).toString();
                Toast.makeText(MainActivity.this, "Bạn đã chọn: "+selectedText, Toast.LENGTH_SHORT).show();

                if (selectedText.equals("12 Lý-Tin")) {
                    buttonNext.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent i = new Intent(MainActivity.this, LTActivity.class);
                            startActivity(i);
                            finish();
                        }
                    });
                }
                else {
                    buttonNext.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            showFalseDialog();
                        }
                    });
                }
            }
        });



    }


    private void updateSecondAutoCompleteSuggestions(String selectedText) {
        // Logic to dynamically update the suggestions for the second AutoCompleteTextView based on the selected item
        // You can populate secondAutoCompleteSuggestions array or list based on the selectedText
        // For example:
        if (selectedText.equals("Khối 10")) {
            secondItems = new String[]{"10 A", "10 Anh", "10 Hóa", "10 Lý", "10 Tin", "10 Sinh", "10 Sử", "10 Địa", "10 Toán", "10 Văn"};
        } else if (selectedText.equals("Khối 11")) {
            secondItems = new String[]{"11 A", "11 Anh", "11 Hóa", "11 Lý-Tin", "11 Sinh", "11 Sử-Địa", "11 Toán", "11 Văn"};
        } else {
            secondItems = new String[]{"12 A", "12 Anh", "12 Hóa", "12 Lý-Tin", "12 Sinh", "12 Sử-Địa", "12 Toán", "12 Văn"};
        }
    }

    private void showFalseDialog() {
        ConstraintLayout falseConstraintLayout = findViewById(R.id.falseConstrainLayout);
        View view = LayoutInflater.from(MainActivity.this).inflate(R.layout.false_dialog, falseConstraintLayout);
        Button falseDone = view.findViewById(R.id.falseDone);

        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setView(view);
        final AlertDialog alertDialog = builder.create();

        falseDone.findViewById(R.id.falseDone).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertDialog.dismiss();
                //Toast.makeText(MainActivity.this, "OK", Toast.LENGTH_SHORT).show();
            }
        });
        if (alertDialog.getWindow()!=null) {
            alertDialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        }
        alertDialog.show();
    }


}