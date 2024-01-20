package com.example.quanlihocsinh;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.quanlihocsinh.model.Student;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;

import java.util.HashMap;

public class DAOStudent {
    private DatabaseReference databaseReference;
    public DAOStudent () {
        FirebaseDatabase db = FirebaseDatabase.getInstance();
        databaseReference = db.getReference(Student.class.getSimpleName());
    }

    public Task<Void> add(Student stu) {

        return databaseReference.push().setValue(stu);
    }

    public Task<Void> update(String key, HashMap<String ,Object> hashMap)
    {
        return databaseReference.child(key).updateChildren(hashMap);
    }
    public Task<Void> remove(String key)
    {
        return databaseReference.child(key).removeValue();
    }

    public Query get(String key)
    {
        if(key == null)
        {
            return databaseReference.orderByKey().limitToFirst(8);
        }
        return databaseReference.orderByKey().startAfter(key).limitToFirst(8);
    }

    public Query get()
    {
        return databaseReference;
    }
}
