package com.bcal.www.vangills;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bcal.www.vangills.insert.InsertCart;
import com.bcal.www.vangills.insert.InsertItem;
import com.bumptech.glide.Glide;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;

public class ViewProduct extends AppCompatActivity {

    private ImageView productImg;
    private DatabaseReference reff;
    private DatabaseReference cartReff;
    private Context currentContext;
    private TextView productTitle;
    private TextView productName;
    private TextView price;
    private TextView units;
    private TextView unitType;
    private TextView itemCount;

    private int availableItems;
    private int itemID;

    private InsertCart cart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_product);

        productImg = this.findViewById(R.id.productImg);
        productTitle = this.findViewById(R.id.productTitle);
        productName = this.findViewById(R.id.productName);
        price = this.findViewById(R.id.productPrice);
        units = this.findViewById(R.id.units);
        unitType = this.findViewById(R.id.unitType);
        itemCount = this.findViewById(R.id.itemCount);


        currentContext = this.getApplicationContext();

        /*Get Item ID send by the item page*/
        Intent intent = getIntent();
        itemID = intent.getIntExtra("id",0);

        reff = FirebaseDatabase.getInstance().getReference().child("items");
        Query query = reff.orderByChild("id").equalTo(itemID);

        reff.keepSynced(true);

        query.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

                Glide.with(currentContext).load(snapshot.child("url").getValue().toString()).into(productImg);
                productTitle.setText(snapshot.child("productName").getValue().toString());
                productName.setText(snapshot.child("productName").getValue().toString());
                price.setText("Rs."+snapshot.child("price").getValue().toString());

                String unitT = new String(snapshot.child("unitType").getValue().toString());
                availableItems = Integer.parseInt(snapshot.child("availableUnits").getValue().toString());

                units.setText(snapshot.child("availableUnits").getValue().toString()+unitT);


                if(unitT.equals("pc")){
                    unitT = "Packets";
                }

                unitType.setText(unitT);

            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

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

    }

    public void backHome(View view) {
        super.onBackPressed();
    }

    public void mynusItem(View view) {

        int calItem = Integer.parseInt((String) this.itemCount.getText());

        calItem -= 1;
        if(calItem >= 0){
            itemCount.setText(String.valueOf(calItem));
        }

    }

    public void plusItem(View view) {

        int calItem = Integer.parseInt((String) this.itemCount.getText());

        calItem += 1;
        if(calItem <= availableItems){
            itemCount.setText(String.valueOf(calItem));
        }

    }

    public void addCart(View view) {

        cart = new InsertCart();

        cartReff = FirebaseDatabase.getInstance().getReference().child("cart");

        cart.setUserID(1);
        cart.setItemId(itemID);
        cart.setItemCount(Integer.parseInt((String) this.itemCount.getText()));

        cartReff.push().setValue(cart);

        Toast.makeText(getApplicationContext(),"Item Added to the Cart!",Toast.LENGTH_SHORT).show();
        this.backHome(view);
    }
}
