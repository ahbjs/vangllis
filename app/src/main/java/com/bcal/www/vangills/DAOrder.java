package com.bcal.www.vangills;

import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class DAOrder {

    private DatabaseReference dbRef;

    public DAOrder(){

        FirebaseDatabase db = FirebaseDatabase.getInstance();
        dbRef = db.getReference(Order.class.getSimpleName());

    }

    public Task<Void> add(Order ord) { return dbRef.push().setValue(ord); }




}
