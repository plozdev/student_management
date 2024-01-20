package com.example.quanlihocsinh.add;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.quanlihocsinh.DAOStudent;
import com.example.quanlihocsinh.R;
import com.example.quanlihocsinh.rvactivity.RVActivity;
import com.example.quanlihocsinh.model.Student;
import com.google.android.material.textfield.TextInputEditText;

import java.util.HashMap;

public class AddActivity extends AppCompatActivity {

    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        final TextInputEditText edit_gender = findViewById(R.id.edtGender);
        final TextInputEditText edit_major = findViewById(R.id.edtMajor);
        final TextInputEditText edit_gmail = findViewById(R.id.edtGmail);
        final TextInputEditText edit_name = findViewById(R.id.edtName);
        final TextInputEditText edit_phone = findViewById(R.id.edtPhone);
        DAOStudent dao = new DAOStudent();
        btn = findViewById(R.id.buttonAdd);
        Button btn_open = findViewById(R.id.btn_open);
        btn_open.setOnClickListener(v -> {
            Intent i = new Intent(AddActivity.this, RVActivity.class);
            startActivity(i);
        });
        Student stu_edit = (Student) getIntent().getSerializableExtra("EDIT");
        if (stu_edit != null) {
            btn.setText("UPDATE");
            edit_name.setText(stu_edit.getName());
            edit_major.setText(stu_edit.getMajor());
            edit_gender.setText(stu_edit.getGender());
            edit_phone.setText(stu_edit.getPhone());
            edit_gmail.setText(stu_edit.getGmail());
            btn_open.setVisibility(View.GONE);
        }
        else
        {
            btn.setText("SUBMIT");
            btn_open.setVisibility(View.VISIBLE);
        }
        btn.setOnClickListener(v -> {


            Student stu = new Student(edit_name.getText().toString(),edit_major.getText().toString(),edit_gender.getText().toString(),edit_phone.getText().toString(),edit_gmail.getText().toString());
            if (stu_edit==null) {
                dao.add(stu).addOnSuccessListener(suc -> {
                    Toast.makeText(this, "Success", Toast.LENGTH_SHORT).show();
                }).addOnFailureListener(er -> {
                    Toast.makeText(this, "" + er.getMessage(), Toast.LENGTH_SHORT).show();
                });
            } else {
                HashMap<String, Object> hashMap = new HashMap<>();
                hashMap.put("name", edit_name.getText().toString());
                hashMap.put("major", edit_major.getText().toString());
                hashMap.put("gender", edit_gender.getText().toString());
                hashMap.put("phone", edit_phone.getText().toString());
                hashMap.put("gmail", edit_gmail.getText().toString());
                dao.update(stu_edit.getKey(), hashMap).addOnSuccessListener(suc ->
                {
                    Toast.makeText(this, "Updated", Toast.LENGTH_SHORT).show();
                    finish();
                }).addOnFailureListener(er ->
                {
                    Toast.makeText(this, "" + er.getMessage(), Toast.LENGTH_SHORT).show();
                });
            }
        });


    }
}