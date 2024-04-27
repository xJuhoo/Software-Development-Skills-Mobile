package com.example.mobileproject;

import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ItemViewHolder extends RecyclerView.ViewHolder {

    ImageView editProduct, deleteProduct;
    ImageView sortOrder, sortName;
    TextView productName, details;
    EditText editName, editDetails;

    public ItemViewHolder(@NonNull View itemView){
        super(itemView);
        editProduct = itemView.findViewById(R.id.iconEditItem);
        deleteProduct = itemView.findViewById(R.id.iconDeleteItem);
        productName = itemView.findViewById(R.id.txtItemName);
        details = itemView.findViewById(R.id.txtItemNotes);
        editName = itemView.findViewById(R.id.txtEditName);
        editDetails = itemView.findViewById(R.id.txtEditNotes);
        sortOrder = itemView.findViewById(R.id.calendarIcon);
        sortName = itemView.findViewById(R.id.sortingIcon);
    }
}