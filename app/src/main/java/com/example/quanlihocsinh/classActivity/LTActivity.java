package com.example.quanlihocsinh.classActivity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.quanlihocsinh.R;
import com.example.quanlihocsinh.adapter.RVAdapter;
import com.example.quanlihocsinh.model.Student;

import java.util.ArrayList;
import java.util.Arrays;


public class LTActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    RVAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rvactivity);
        Student[] students = new Student[]{
                new Student("Nguyen Truong Truong An","Physics","Male"),
                new Student("To Vinh An","IT","Male"),
                new Student("Nguyen Huy Chuong","Physics","Male"),
                new Student("Nguyen Thai Thuy Dung","Physics",""),
                new Student("Nguyen Ngoc Duy","Physics","Male"),
                new Student("Le Dinh Dat","IT","Male"),
                new Student("Nguyen Thanh Dat","IT","Male"),
                new Student("Nguyen Phuong Dong","IT","Male"),
                new Student("Nguyen Tien Duc","IT","Male"),
                new Student("Phan Anh Duc","IT","Male"),
                new Student("Nguyen Hoang Giap","Physics","Male"),
                new Student("Nguyen Ngoc Thanh Ha","Physics","Female"),
                new Student("Tran Nguyen Khanh Ha","Physics","Female"),
                new Student("Van Ngoc Han","Physics","Female"),
                new Student("Le Duc Hieu","IT","Male"),
                new Student("Nguyen Dinh Minh Hieu","IT","Male"),
                new Student("Mai Anh Hoang","IT","Male"),
                new Student("Pham Dang Huy","Physics","Male"),
                new Student("Doan Dang Khai","Physics","Male"),
                new Student("Luong Xuan Khai","Physics","Male"),
                new Student("Bui Anh Khoi","Physics","Male"),
                new Student("Trinh Gia Kiet","IT","Male"),
                new Student("Nguyen Bao Ly","Physics",""),
                new Student("Tran Minh","Physics","Male"),
                new Student("Trinh Minh Nghia", "Physics","Male"),
                new Student("Le Anh Quan", "IT","Male"),
                new Student("Dang To Ngoc Quynh", "IT","Female"),
                new Student("Nguyen Dong Son", "Physics","Male"),
                new Student("Pham Ba Thanh", "IT","Male"),
                new Student("Trinh Van Thanh", "IT","Male"),
                new Student("Nguyen Duy Thang", "Physics","Male"),
                new Student("Hoang Do Minh That", "Physics","Male"),
                new Student("Tran Pham Quynh Thuong", "Physics","Female"),
                new Student("Nguyen Vu Nhat Tin", "IT","Male"),
                new Student("Ha Duc Gia Toai", "IT","Male"),
                new Student("Huynh Bao Tu Trang", "IT","Female"),
                new Student("Phan Hoang Mai Truc", "IT","Female"),
                new Student("Nguyen Vo Trong Tuan", "IT","Male"),
                new Student("Luong Kien Van", "Physics","Male")
        };
        ArrayList<Student> studentArrayList = new ArrayList<>(Arrays.asList(students));

        recyclerView = findViewById(R.id.rv);
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(manager);
        adapter = new RVAdapter(this);
        adapter.setItem(studentArrayList);
        recyclerView.setAdapter(adapter);


    }
}