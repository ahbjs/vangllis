package com.bcal.www.vangills;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.Date;

import com.bcal.www.vangills.insert.*;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ArrayList<RecyclerData> recyclerDataArrayList;

    DatabaseReference reff;
    InsertItem item;
    InsertOrder order;
    InsertDeliveryOrders deliverORder;
    InsertDeliverStatus deliverStatus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /*Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);*/

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        recyclerView=findViewById(R.id.idCourseRV);

        // created new array list..
        recyclerDataArrayList=new ArrayList<>();

        reff = FirebaseDatabase.getInstance().getReference().child("items");
        reff.keepSynced(true);
        item = new InsertItem();

        reff.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                recyclerDataArrayList.add(new RecyclerData(R.drawable.loading,snapshot.child("productName").getValue().toString(),snapshot.child("url").getValue().toString(),snapshot.child("price").getValue().toString()));
                genItem();
            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                recyclerDataArrayList.add(new RecyclerData(R.drawable.loading,snapshot.child("productName").getValue().toString(),snapshot.child("url").getValue().toString(),snapshot.child("price").getValue().toString()));
                genItem();
            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot snapshot) {

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        
        // added data to array list
        /*recyclerDataArrayList.add(new RecyclerData("DSA",R.drawable.anchor,"Anchor"));
        recyclerDataArrayList.add(new RecyclerData("JAVA",R.drawable.anchor,"Anchor"));
        recyclerDataArrayList.add(new RecyclerData("C++",R.drawable.anchor,"Anchor"));
        recyclerDataArrayList.add(new RecyclerData("Python",R.drawable.anchor,"Anchor"));
        recyclerDataArrayList.add(new RecyclerData("Node Js",R.drawable.anchor,"Anchor"));*/

       /* item = new InsertItem();


        item.setProductName("Highland Milk");
        item.setAvailableUnits(100);
        item.setUnitType("Kg");
        item.setPrice(700);

        reff.push().setValue(item);*/

        /*order = new InsertOrder();

        reff = FirebaseDatabase.getInstance().getReference().child("orders");

        order.setName("Avishka Hiran");
        order.setCity("Eheliyagoda");
        order.setStreet("201/Welfare road");
        order.setPhoneNo1("078785475847");
        order.setPhoneNo2("34683274823");

        reff.push().setValue(order);


        deliverORder = new InsertDeliveryOrders();

        reff = FirebaseDatabase.getInstance().getReference().child("deliverList");

        deliverORder.setOrderNumber("123");
        deliverORder.setDeliverPerson("Kasub Kumara");

        reff.push().setValue(deliverORder);


       /* deliverStatus = new InsertDeliverStatus();
        reff = FirebaseDatabase.getInstance().getReference().child("deliverStatus");

        deliverStatus.setOrderID("125");
        deliverStatus.setDeliverTime(new Date());

        reff.push().setValue(deliverStatus);*/

    }

    public void genItem(){
        // added data from arraylist to adapter class.
        RecyclerViewAdapter adapter=new RecyclerViewAdapter(recyclerDataArrayList,this);

        // setting grid layout manager to implement grid view.
        // in this method '2' represents number of columns to be displayed in grid view.
        GridLayoutManager layoutManager=new GridLayoutManager(this,2);

        // at last set adapter to recycler view.
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
