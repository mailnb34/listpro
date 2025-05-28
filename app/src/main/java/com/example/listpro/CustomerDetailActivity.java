package com.quin.project195;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.quin.model.Customer;

public class CustomerDetailActivity extends AppCompatActivity {
    EditText edtCustomer_id;
    EditText edtCustomername;
    EditText edtCustomeremail;
    EditText edtCustomerphone;
    EditText edtCustomerusername;
    EditText edtCustomerpassword;
    

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_customer_detail);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        addViews();
    }

    private void addViews() {
         edtCustomer_id=findViewById(R.id.edtCustomer_id);
        edtCustomername=findViewById(R.id.edtCutomername);
         edtCustomeremail=findViewById(R.id.edtCustomeremail);
         edtCustomerphone=findViewById(R.id.edtCustomerphone);
         edtCustomerusername=findViewById(R.id.edtCustomerusername);
         edtCustomerpassword=findViewById(R.id.edtCustomerpassword);
         display_customer_details();
         
    }

    private void display_customer_details() {
        Intent intent=getIntent();
        Customer c=(Customer) intent.getSerializableExtra("Selected_Customer");
         edtCustomer_id.setText(c.getId()+"");
         edtCustomername.setText(c.getName());
         edtCustomeremail.setText(c.getEmail());
         edtCustomerphone.setText(c.getUsername());
         edtCustomerusername.setText(c.getUsername());
         edtCustomerpassword.setText(c.getPassword());
    }
}