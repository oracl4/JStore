/**
 * <h1>CustomerController.java</h1>
 * <p>
 * Customer controller for Springboot Framework
 * </p>
 *
 * @author Mahdi Yusuf
 * @version 13.0
 * @since 2019/31/05
 */
package jstore.controller;

import jstore.*;
import org.springframework.web.bind.annotation.*;

@RestController
public class CustomerController {

    /**
     * Creating new customer request
     *
     * @param name     the name
     * @param email    the email
     * @param username the username
     * @param password the password
     * @param year     the year
     * @param month    the month
     * @param date     the date
     * @return the customer
     */
    @RequestMapping(value = "/newcustomer", method = RequestMethod.POST)
    public Customer newCust(@RequestParam(value = "name") String name,
                            @RequestParam(value = "email") String email,
                            @RequestParam(value = "username") String username,
                            @RequestParam(value = "password") String password,
                            @RequestParam(value = "birthyear", defaultValue = "1999") Integer year,
                            @RequestParam(value = "birthmonth", defaultValue = "1") Integer month,
                            @RequestParam(value = "birthdate", defaultValue = "1") Integer date
    ) {
        Customer customer = DatabaseCustomerPostgre.insertCustomer(name, email, username, password, year, month, date);
        return customer;
    }

    /**
     * Customer login request
     *
     * @param email    the email
     * @param password the password
     * @return the customer
     */
    @RequestMapping(value = "/logincust", method = RequestMethod.POST)
    public Customer loginCust(@RequestParam(value = "email") String email,
                              @RequestParam(value = "password") String password) {
        return DatabaseCustomerPostgre.getCustomer(email, password);
    }

    /**
     * Get customer by id request
     *
     * @param id the id
     * @return the customer
     */
    @RequestMapping("/getcustomer/{id}")
    public Customer getCust(@PathVariable int id) {
        Customer customer = DatabaseCustomerPostgre.getCustomer(id);
        return customer;
    }
}