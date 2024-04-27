package com.example.mobileproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Context context;
    private Storage productStorage;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = this;

        productStorage = Storage.getInstance();
        recyclerView = findViewById(R.id.rvItemList);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new ItemListAdapter(getApplicationContext(), productStorage.getProducts()));
    }

    // For sorting items by order of adding
    public void sortOrder(View view){
        List<Product> itemsByOrder = Storage.getInstance().getProducts();
        Collections.sort(itemsByOrder, Product.sortByOrder);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new ItemListAdapter(getApplicationContext(), productStorage.getProducts()));
    }

    // For sorting items in alphabetical order
    public void sortName(View view){
        List<Product> itemsByName = Storage.getInstance().getProducts();
        Collections.sort(itemsByName, Product.sortByName);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new ItemListAdapter(getApplicationContext(), productStorage.getProducts()));
    }

    // Method for switching layout
    public void switchToAddProduct(View view){
        Intent intent = new Intent(this, AddItemActivity.class);
        startActivity(intent);
    }
}