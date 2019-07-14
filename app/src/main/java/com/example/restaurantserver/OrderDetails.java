package com.example.restaurantserver;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.TextView;

import com.example.restaurantserver.Common.Common;
import com.example.restaurantserver.ViewHolder.OrderDetailsAdapter;

public class OrderDetails extends AppCompatActivity {

    TextView order_id,order_phone,order_address,order_total;
    String order_id_value = "";
    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_details);

        order_id = findViewById(R.id.order_id);
        order_phone = findViewById(R.id.order_phone);
        order_address = findViewById(R.id.order_address);
        order_total = findViewById(R.id.order_total);

        recyclerView = findViewById(R.id.lstFood);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);


        if (getIntent() != null)
            order_id_value = getIntent().getStringExtra("OrderId");

        // set value
        order_id.setText(order_id_value);
        order_phone.setText(Common.currentRequest.getPhone());
        order_address.setText(Common.currentRequest.getAddress());
        order_total.setText(Common.currentRequest.getTotal());


        OrderDetailsAdapter orderDetailsAdapter = new OrderDetailsAdapter(Common.currentRequest.getFoods());
        orderDetailsAdapter.notifyDataSetChanged();
        recyclerView.setAdapter(orderDetailsAdapter);



    }
}
