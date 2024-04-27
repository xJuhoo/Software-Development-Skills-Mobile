package com.example.mobileproject;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ItemListAdapter extends RecyclerView.Adapter<ItemViewHolder> {
    private Context context;

    private ArrayList<Product> items = new ArrayList<>();

    public ItemListAdapter(Context context, ArrayList<Product> items){
        this.context = context;
        this.items = items;
    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ItemViewHolder(LayoutInflater.from(context).inflate(R.layout.item_view, parent, false));

    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position){

        // Editing values
        holder.editProduct.setOnClickListener(view -> {
            int iPosition = holder.getAdapterPosition();
            if (holder.editName.getVisibility() == View.VISIBLE) {
                Product product = Storage.getInstance().getProduct(iPosition);
                product.setName(holder.editName.getText().toString());
                product.setDetails(holder.editDetails.getText().toString());
                holder.editName.setVisibility(View.GONE);
                holder.editDetails.setVisibility(View.GONE);

                notifyDataSetChanged();
            }
            else {
                holder.editName.setVisibility(View.VISIBLE);
                holder.editDetails.setVisibility(View.VISIBLE);
            }
        });

        // Deleting values
        holder.productName.setText(items.get(position).getName());
        holder.details.setText(items.get(position).getDetails());
        holder.editName.setText(items.get(position).getName());
        holder.editDetails.setText(items.get(position).getDetails());
        holder.deleteProduct.setOnClickListener(view -> {
            int iPosition = holder.getAdapterPosition();
            Storage.getInstance().deleteProduct(items.get(iPosition).getName());
            notifyItemRemoved(iPosition);
        });

    }

    @Override
    public int getItemCount() {return items.size();}
}
