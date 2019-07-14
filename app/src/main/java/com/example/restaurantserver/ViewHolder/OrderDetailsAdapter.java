package com.example.restaurantserver.ViewHolder;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.restaurantserver.R;
import com.example.restaurantserver.model.Order;

import java.util.List;

class MyViewHolder extends RecyclerView.ViewHolder{

    public TextView name,price,quantity,discount;

    public MyViewHolder(@NonNull View itemView) {
        super(itemView);

        name = itemView.findViewById(R.id.product_name);
        price = itemView.findViewById(R.id.product_price);
        quantity = itemView.findViewById(R.id.product_quantity);
        discount = itemView.findViewById(R.id.product_discount);
    }
}

public class OrderDetailsAdapter extends RecyclerView.Adapter<MyViewHolder> {


    List<Order> myOrders;

    public OrderDetailsAdapter(List<Order> myOrders) {
        this.myOrders = myOrders;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.order_details_layout,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Order order = myOrders.get(position);
        holder.name.setText(String.format("Name : %s",order.getProductName()));
        holder.quantity.setText(String.format("Quantity : %s",order.getQuantity()));
        holder.discount.setText(String.format("Discount : %s",order.getDiscount()));
        holder.price.setText(String.format("Price : %s",order.getPrice()));


    }

    @Override
    public int getItemCount() {
        return myOrders.size();
    }
}
