package com.example.quanlihocsinh.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.quanlihocsinh.DAOStudent;
import com.example.quanlihocsinh.R;
import com.example.quanlihocsinh.StudentVH;
import com.example.quanlihocsinh.add.AddActivity;
import com.example.quanlihocsinh.model.Student;

import java.util.ArrayList;
import java.util.List;

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
        vh.txt_phone.setText(stu.getPhone());
        vh.txt_gmail.setText(stu.getGmail());
        vh.txt_option.setOnClickListener(v ->
        {
            PopupMenu popupMenu = new PopupMenu(context,vh.txt_option);
            popupMenu.inflate(R.menu.option_menu);
            popupMenu.setOnMenuItemClickListener(item ->
            {
                if (item.getItemId()==R.id.menu_edit) {
                    Intent intent = new Intent(context, AddActivity.class);
                    intent.putExtra("EDIT",stu);
                    context.startActivity(intent);
                }
                else if(item.getItemId()==R.id.menu_remove) {
                    DAOStudent dao=new DAOStudent();
                    dao.remove(stu.getKey()).addOnSuccessListener(suc->
                    {
                        Toast.makeText(context, "Record is removed", Toast.LENGTH_SHORT).show();
                        notifyItemRemoved(position);
                        list.remove(stu);

                    }).addOnFailureListener(er->
                    {
                        Toast.makeText(context, ""+er.getMessage(), Toast.LENGTH_SHORT).show();
                    });
                }

                return false;
            });
            popupMenu.show();
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
