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
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.model.Customer;
import com.example.model.ListCustomer;
import com.example.model.ListEmployee;

import java.util.zip.Inflater;

public class CustomerManagementActivity extends AppCompatActivity {

    ListView lvCustomer;
    ArrayAdapter<Customer> adapter;
    ListCustomer lc=new ListCustomer();
    MenuItem menu_new_customer;
    MenuItem menu_broadcast_adv;
    MenuItem menu_help;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_customer_management);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        addViews();
        addEvents();
    }

    private void addEvents() {
        lvCustomer.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Customer c=adapter.getItem(position);
                openCustomerDetailActivity(c);
            }
        });
    }

    private void openCustomerDetailActivity(Customer c) {
        Intent intent=new Intent(CustomerManagementActivity.this,CustomerDetailActivity.class);
        intent.putExtra("Selected_Customer",c);
        startActivity(intent);
    }

    private void addViews() {
        lvCustomer=findViewById(R.id.lvCustomer);
        adapter=new ArrayAdapter<>(
                CustomerManagementActivity.this,
                android.R.layout.simple_list_item_1);

        lc.generate_sample_dataset();
        adapter.addAll(lc.getCustomers());

        lvCustomer.setAdapter(adapter);

        menu_new_customer=findViewById(R.id.menu_new_customer);
        menu_broadcast_adv=findViewById(R.id.menu_broadcast_adv);
        menu_help=findViewById(R.id.menu_help);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.option_menu_customer,menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId()==R.id.menu_new_customer) {
            Toast.makeText(CustomerManagementActivity.this,"Mở màn hình thêm khách hàng mới",Toast.LENGTH_LONG).show();
            openNewCustomerActivity();
        }
        else if (item.equals(menu_broadcast_adv)) {
            Toast.makeText(CustomerManagementActivity.this,"Bắn tin qc tới hàng loạt khách hàng",Toast.LENGTH_LONG).show();
        }
        else if (item.getItemId()==R.id.menu_help){
            Toast.makeText(CustomerManagementActivity.this,"Hướng dẫn sử dụng",Toast.LENGTH_LONG).show();
        }
        return super.onOptionsItemSelected(item);
    }

    private void openNewCustomerActivity() {
    }
}
