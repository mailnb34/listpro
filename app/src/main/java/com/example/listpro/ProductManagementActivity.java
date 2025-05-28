package com.example.listpro;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.model.Category;
import com.example.model.Customer;
import com.example.model.ListCategory;
import com.example.model.Product;

public class ProductManagementActivity extends AppCompatActivity {

    Spinner spinnerCategory;
    ArrayAdapter<Category> adapterCategory;
    ListCategory listCategory;

    ListView lvProduct;
    ArrayAdapter<Product> adapterProduct;
    MenuItem menu_softdrink;
    MenuItem menu_cake;
    MenuItem menu_fastfood;
    MenuItem menu_beer;
    MenuItem menu_seafood;
    MenuItem menu_vegetarian;
    MenuItem menu_fruit;
    MenuItem menu_snack;
    MenuItem menu_coffee;
    MenuItem menu_icecream;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_product_management);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        addViews();
        addEvents();
    }

    private void addEvents() {
        spinnerCategory.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Category c=adapterCategory.getItem(i);
                displayProductByCategory(c);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        lvProduct.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Product p=adapterProduct.getItem(position);
                openProductDetailActivity(p);
            }
        });
    }


    private void openProductDetailActivity(Product p) {
        Intent intent=new Intent(ProductManagementActivity.this,ProductDetailActivity.class);
        intent.putExtra("Selected_Product",p);
        startActivity(intent);
    }

    private void displayProductByCategory(Category c) {
        
        adapterProduct.clear();
        
        adapterProduct.addAll(c.getProducts());
    }

    private void addViews() {
        spinnerCategory=findViewById(R.id.spinnerCategory);
        adapterCategory=new ArrayAdapter<>(ProductManagementActivity.this,
                android.R.layout.simple_spinner_item);
        adapterCategory.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerCategory.setAdapter(adapterCategory);

        listCategory=new ListCategory();
        listCategory.generate_product_dataset();
        adapterCategory.addAll(listCategory.getCategories());

        lvProduct=findViewById(R.id.lvProduct);
        adapterProduct=new ArrayAdapter<>(ProductManagementActivity.this,
                android.R.layout.simple_list_item_1);
        lvProduct.setAdapter(adapterProduct);

        menu_softdrink=findViewById(R.id.menu_softdrink);
        menu_cake=findViewById(R.id.menu_cake);
        menu_fastfood=findViewById(R.id.menu_fastfood);
        menu_beer=findViewById(R.id.menu_beer);
        menu_seafood=findViewById(R.id.menu_seafood);
        menu_vegetarian=findViewById(R.id.menu_vegetarian);
        menu_fruit=findViewById(R.id.menu_fruit);
        menu_snack=findViewById(R.id.menu_snack);
        menu_coffee=findViewById(R.id.menu_coffee);
        menu_icecream=findViewById(R.id.menu_icecream);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.option_menu_product,menu);
        return true;
    }



    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        Category selectedCategory = null;

        if (id == R.id.menu_softdrink) {
            Toast.makeText(this, "Soft Drink", Toast.LENGTH_SHORT).show();
            selectedCategory = listCategory.getCategoryByName("Soft Drink");
        } else if (id == R.id.menu_cake) {
            Toast.makeText(this, "Cake", Toast.LENGTH_SHORT).show();
            selectedCategory = listCategory.getCategoryByName("Cake");
        } else if (id == R.id.menu_fastfood) {
            selectedCategory = listCategory.getCategoryByName("Fastfood");
        } else if (id == R.id.menu_beer) {
            selectedCategory = listCategory.getCategoryByName("Beer");
        } else if (id == R.id.menu_seafood) {
            selectedCategory = listCategory.getCategoryByName("Seafood");
        } else if (id == R.id.menu_vegetarian) {
            selectedCategory = listCategory.getCategoryByName("Vegetarian");
        } else if (id == R.id.menu_fruit) {
            selectedCategory = listCategory.getCategoryByName("Fruit");
        } else if (id == R.id.menu_snack) {
            selectedCategory = listCategory.getCategoryByName("Snack");
        } else if (id == R.id.menu_coffee) {
            selectedCategory = listCategory.getCategoryByName("Coffee");
        } else if (id == R.id.menu_icecream) {
            selectedCategory = listCategory.getCategoryByName("Ice Cream");
        }

        if (selectedCategory != null) {
            displayProductByCategory(selectedCategory);
            return true; 
        }

        return super.onOptionsItemSelected(item);
    }


    private void openNewProductActivity() {
        
    }


}
