package com.quin.project195;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.widget.AdapterView;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.quin.model.Category;
import com.quin.model.Customer;
import com.quin.model.ListCategory;
import com.quin.model.Product;

public class ProductDetailActivity extends AppCompatActivity {

    EditText edtProductname;
    EditText edtProductquantity;
    EditText edtProductprice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_product_detail);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        addViews();
    }


    private void addViews() {
        edtProductname=findViewById(R.id.edtProductname);
        edtProductquantity=findViewById(R.id.edtProductquantity);
        edtProductprice=findViewById(R.id.edtProductprice);
        display_product_details();

        int productId = getIntent().getIntExtra("productId", -1);

    }

    private void display_product_details() {
        Intent intent=getIntent();
        Product p = (Product) getIntent().getSerializableExtra("Selected_Product");
        edtProductname.setText(p.getName());
        edtProductquantity.setText(String.valueOf(p.getQuantity()));
        edtProductprice.setText(String.valueOf(p.getPrice()));


    }

}