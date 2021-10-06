package com.bcal.www.vangills;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class activity_add_order extends AppCompatActivity {

    EditText numOID, numCID, numNITM;
    Button btnsubmit, btnopen, btnupdate, btndelete;
    DatabaseReference dbRef;
    Order ord;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_order);


        numOID = findViewById(R.id.edit_orderID);
        numCID = findViewById(R.id.edit_cusID);
        numNITM = findViewById(R.id.edit_noItems);

        btnsubmit = findViewById(R.id.btn_submit);
        btnopen = findViewById(R.id.btn_open);
        btnupdate = findViewById(R.id.btn_update);
        btndelete = findViewById(R.id.btn_delete);

        DAOrder dao = new DAOrder();

        btnsubmit.setOnClickListener(v->{
            Order order = new Order();
            order.setOrderID(Integer.parseInt(numOID.getText().toString()));
            order.setNoItems(Integer.parseInt(numNITM.getText().toString()));
            order.setCusID(Integer.parseInt(numCID.getText().toString()));
            dao.add(order);
            Log.d("SUBMIT",order.toString());
        });

        ord = new Order();
//
//        dbRef = FirebaseDatabase.getInstance().getReference().child("Order");
//        try{
//            if(TextUtils.isEmpty(numOID.getText().toString()))
//                Toast.makeText(getApplicationContext(), "Please Enter Order ID", Toast.LENGTH_SHORT).show();
//            else if (TextUtils.isEmpty(numCID.getText().toString()))
//                Toast.makeText(getApplicationContext(), "Please Enter Customer ID", Toast.LENGTH_SHORT).show();
//            else if (TextUtils.isEmpty(numNITM.getText().toString()))
//                Toast.makeText(getApplicationContext(), "Please Enter No of items", Toast.LENGTH_SHORT).show();
//            else {
//                ord.setOrderID(Integer.parseInt(numOID.getText().toString().trim()));
//                ord.setCusID(Integer.parseInt(numCID.getText().toString().trim()));
//                ord.setNoItems(Integer.parseInt(numNITM.getText().toString().trim()));
//
//                dbRef.push().setValue(ord);
//                Toast.makeText(getApplicationContext(), "Data Inserted", Toast.LENGTH_SHORT).show();
//
//            }
//
//        }catch (NumberFormatException e){
//            Toast.makeText(getApplicationContext(), "Invalid Number", Toast.LENGTH_SHORT).show();
//        }

    }

}