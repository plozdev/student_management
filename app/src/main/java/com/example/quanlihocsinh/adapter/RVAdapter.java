package com.example.quanlihocsinh.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.quanlihocsinh.R;
import com.example.quanlihocsinh.StudentVH;

import com.example.quanlihocsinh.model.Student;

import java.util.ArrayList;


public class RVAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;
    ArrayList<Student> list = new ArrayList<>();

    public RVAdapter(Context cxt) {
        this.context = cxt;
    }

    public void setItem(ArrayList<Student> stu) {
        list.addAll(stu);
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.layout_item,parent,false);
        return new StudentVH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        StudentVH vh = (StudentVH) holder;
        Student stu = list.get(position);
        vh.txt_name.setText(stu.getName());
        vh.txt_major.setText(stu.getMajor());
        vh.txt_gender.setText(stu.getGender());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
