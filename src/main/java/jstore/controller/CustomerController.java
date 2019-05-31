package jstore.controller;

import jstore.*;
import org.springframework.web.bind.annotation.*;

import java.util.Calendar;

@RestController
public class CustomerController {
    @RequestMapping(value = "/newcustomer", method=RequestMethod.POST)
    public Customer newCust(@RequestParam(value="name") String name,
                            @RequestParam(value="email") String email,
                            @RequestParam(value="username") String username,
                            @RequestParam(value="password") String password,
                            @RequestParam(value="birthyear", defaultValue = "1999") Integer year,
                            @RequestParam(value="birthmonth", defaultValue = "1") Integer month,
                            @RequestParam(value="birthdate",  defaultValue = "1") Integer date
    )
    {
        Customer customer = DatabaseCustomerPostgre.insertCustomer(name, email, username, password, year, month, date);
        return customer;
    }

    @RequestMapping(value = "/logincust", method = RequestMethod.POST)
    public Customer loginCust(@RequestParam(value="email") String email,
                              @RequestParam(value="password") String password){
        return DatabaseCustomerPostgre.getCustomer(email, password);
    }

    @RequestMapping("/getcustomer/{id}")
    public Customer getCust(@PathVariable int id) {
        Customer customer = DatabaseCustomerPostgre.getCustomer(id);
        return customer;
    }
}