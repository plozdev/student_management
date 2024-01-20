package com.example.quanlihocsinh.rvactivity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.quanlihocsinh.DAOStudent;
import com.example.quanlihocsinh.R;
import com.example.quanlihocsinh.adapter.RVAdapter;
import com.example.quanlihocsinh.add.AddActivity;
import com.example.quanlihocsinh.model.Student;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class RVActivity extends AppCompatActivity {

    SwipeRefreshLayout swipeRefreshLayout;
    RecyclerView recyclerView;
    RVAdapter adapter;
    FloatingActionButton fab,refreshFab;
    DAOStudent dao;
    boolean isLoading=false;
    String key = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rvactivity);
        swipeRefreshLayout = findViewById(R.id.swip);
        recyclerView = findViewById(R.id.rv);
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(manager);
        adapter = new RVAdapter(this);
        recyclerView.setAdapter(adapter);
        dao = new DAOStudent();
        loadData();
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                LinearLayoutManager linearLayoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();
                int totalItem = linearLayoutManager.getItemCount();
                int lastVisible = linearLayoutManager.findLastCompletelyVisibleItemPosition();
                if (totalItem < lastVisible+3)
                {
                    if (!isLoading)
                    {
                        isLoading = true;
                        loadData();
                    }
                }
            }
        });
        swipeRefreshLayout.setColorSchemeResources(android.R.color.holo_blue_bright,
                android.R.color.holo_green_light,
                android.R.color.holo_orange_light,
                android.R.color.holo_red_light);

        fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(RVActivity.this, AddActivity.class);
                startActivity(i);
            }
        });
        refreshFab = findViewById(R.id.fab2);
        refreshFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(RVActivity.this, RVActivity.class);
                startActivity(i);
            }
        });
    }

    private void loadData() {
        swipeRefreshLayout.setRefreshing(true);
        dao.get(key).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                ArrayList <Student> stus = new ArrayList<>();
                Intent i = new Intent(RVActivity.this, RVActivity.class);
                    for (DataSnapshot data : snapshot.getChildren()) {
                        Student stu = data.getValue(Student.class);
                        stu.setKey(data.getKey());
                        stus.add(stu);
                        key = data.getKey();
                    }
                    //adapter.clear();
                    adapter.setItem(stus);
                    adapter.notifyDataSetChanged();
                    isLoading = false;
                    swipeRefreshLayout.setRefreshing(false);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                swipeRefreshLayout.setRefreshing(false);

            }
        });
//        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
//            @Override
//            public void onRefresh() {
//                swipeRefreshLayout.setRefreshing(false);
//            }
//        });
        }

}