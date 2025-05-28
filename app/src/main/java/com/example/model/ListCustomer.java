package com.example.model;

import java.util.ArrayList;

public class ListCustomer {
    private ArrayList<Customer> customers;

    public ListCustomer() {
        customers=new ArrayList<>();
    }
    public  void addCustomer(Customer c)
    {
        customers.add(c);
    }

    public ArrayList<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(ArrayList<Customer> customers) {
        this.customers = customers;
    }
    public void generate_sample_dataset()
    {
        addCustomer(new Customer(1,"Teo","teo@gmail.com","0981234312","teo","123"));
        addCustomer(new Customer(2,"Ty","ty@gmail.com","0901234456","ty","456"));
        addCustomer(new Customer(3,"Bin","bin@gmail.com","0921234432","bin","456"));
        addCustomer(new Customer(4,"Bo","bo@gmail.com","09553334456","bo","456"));
        addCustomer(new Customer(5,"Tun","tun@gmail.com","097123463","tun","456"));
        addCustomer(new Customer(6,"Mun","mun@gmail.com","0901234234","mun","456"));
        addCustomer(new Customer(7,"hoa","hoa@gmail.com","0941239956","hoa","456"));
        addCustomer(new Customer(8,"hong","hong@gmail.com","0911234777","hong","456"));
        addCustomer(new Customer(9,"hue","hue@gmail.com","0921234888","hue","456"));
        addCustomer(new Customer(10,"cuc","cuc@gmail.com","0921234666","cuc","456"));
    }
}
