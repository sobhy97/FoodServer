package com.example.restaurantserver.ViewHolder;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import android.view.ContextMenu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.restaurantserver.Interfaces.ItemClickListener;
import com.example.restaurantserver.R;

public class OrderViewHolder extends RecyclerView.ViewHolder
{

    public TextView txtOrderId,txtOrderStatus,txtOrderPhone,txtOrderAddress;
    public Button bttnEdit,bttnRemove,bttnDetails,bttnDirections;

//    private ItemClickListener itemClickListener;


    public OrderViewHolder(@NonNull View itemView) {
        super(itemView);

        txtOrderId = itemView.findViewById(R.id.order_id);
        txtOrderStatus = itemView.findViewById(R.id.order_status);
        txtOrderAddress = itemView.findViewById(R.id.order_address);
        txtOrderPhone = itemView.findViewById(R.id.order_phone);
        bttnEdit = itemView.findViewById(R.id.bttn_edit);
        bttnRemove = itemView.findViewById(R.id.bttn_remove);
        bttnDetails = itemView.findViewById(R.id.bttn_details);
        bttnDirections = itemView.findViewById(R.id.bttn_directions);



//        itemView.setOnCreateContextMenuListener(this);
//        itemView.setOnClickListener(this);
    }


//    public void setItemClickListener(ItemClickListener itemClickListener) {
//        this.itemClickListener = itemClickListener;
//    }
//
//    @Override
//    public void onClick(View v) {
//
//        itemClickListener.onClick(v,getAdapterPosition(),false);
//
//    }

//    @Override
//    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
//
//        menu.setHeaderTitle("Select the action");
//        menu.add(0,0,getAdapterPosition(),"Update");
//        menu.add(0,1,getAdapterPosition(),"Delete");
//
//    }
}
