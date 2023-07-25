package com.luism.customer;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class CustomerDataAccessService implements CustomerDAO{

    private static List<Customer> customers;

    static {
        customers = new ArrayList<>();
        Customer luis = new Customer(
                1,
                "Luis",
                "luis@gmail.com",
                45
        );
        customers.add(luis);

        Customer vale = new Customer(
                2,
                "Valentina",
                "vale@gmail.com",
                6
        );
        customers.add(vale);
    }


    @Override
    public List<Customer> selectAllCustomers() {
        return customers;
    }

    @Override
    public Optional<Customer> selectCustomerById(Integer id) {
        return customers.stream()
                .filter(cust -> cust.getId().equals(id))
                .findFirst();
    }
}
