package com.bcal.www.vangills;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class OrderAdapter extends RecyclerView.Adapter<OrderAdapter.OrderViewHolder> {

    Context context;

    ArrayList<Order> list;

    public OrderAdapter(Context context, ArrayList<Order> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public OrderViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.item,parent,false);
        return new OrderViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull OrderViewHolder holder, int position) {

        Order order = list.get(position);
        holder.orderID.setText(order.getOrderID().toString());
        holder.cusID.setText(order.getCusID().toString());
        holder.noItems.setText(order.getNoItems().toString());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class OrderViewHolder extends RecyclerView.ViewHolder{

        TextView orderID, cusID, noItems;

        public OrderViewHolder(@NonNull View itemView) {
            super(itemView);

            orderID = itemView.findViewById(R.id.txt_OrderID);
            cusID = itemView.findViewById(R.id.txt_CusID);
            noItems = itemView.findViewById(R.id.txt_Noitems);
        }
    }

}
