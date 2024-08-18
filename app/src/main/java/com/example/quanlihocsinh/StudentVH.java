package com.example.quanlihocsinh;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class StudentVH extends RecyclerView.ViewHolder {
    public TextView txt_name,txt_major,txt_gender;

    public StudentVH(@NonNull View itemView) {
        super(itemView);
        txt_name = itemView.findViewById(R.id.txt_name);
        txt_major = itemView.findViewById(R.id.txt_major);
        txt_gender = itemView.findViewById(R.id.txt_gender);

    }
}
