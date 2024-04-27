package com.example.mobileproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddItemActivity extends AppCompatActivity {

    private EditText productName, details;
    private Button buttonAddProduct;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_item);
        productName = findViewById(R.id.productName);
        details = findViewById(R.id.details);
        buttonAddProduct = findViewById(R.id.productSave);
        context = this;
    }

    // For adding products
    public void addProduct(View view) {
        // The creation time can be compared with the size of the current list of products
        // After adding first product the size is 1 and after second product its 2, so we know which one came first
        Product product = new Product(productName.getText().toString(), details.getText().toString(), Storage.getInstance().getProducts().size());
        Storage.getInstance().addProduct(product);

        // Switching back to main page
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}