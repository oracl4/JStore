/**
 * <h1>DatabaseCustomer.java</h1>
 * <p>
 * Static Java Customer Database
 * </p>
 *
 * @author Mahdi Yusuf
 * @version 13.0
 * @since 2019/31/05
 */
package jstore;

import java.util.ArrayList;

/**
 * The type Database customer.
 */
public class DatabaseCustomer {
    private static ArrayList<Customer> CUSTOMER_DATABASE = new ArrayList<Customer>();
    private static int LAST_CUSTOMER_ID = 0;

    /**
     * Instantiates a new Database customer.
     */
    public DatabaseCustomer() {
    }

    /**
     * Gets customer database.
     *
     * @return the customer database
     */
    public static ArrayList<Customer> getCustomerDatabase() {
        return CUSTOMER_DATABASE;
    }

    /**
     * Gets last customer id.
     *
     * @return the last customer id
     */
    public static int getLastCustomerID() {
        return LAST_CUSTOMER_ID;
    }

    /**
     * Add customer boolean.
     *
     * @param customer the customer
     * @return the boolean
     * @throws CustomerAlreadyExistsException the customer already exists exception
     */
    public static boolean addCustomer(Customer customer) throws CustomerAlreadyExistsException {
        for (Customer temp : CUSTOMER_DATABASE) {
            if (((temp.getName().equals(customer.getName()))
                    || (temp.getEmail().equals(customer.getEmail())))) {
                throw new CustomerAlreadyExistsException(customer);
            }
        }
        CUSTOMER_DATABASE.add(customer);
        LAST_CUSTOMER_ID = customer.getID();
        return true;
    }

    /**
     * Gets customer.
     *
     * @param id the id
     * @return the customer
     */
    public static Customer getCustomer(int id) {
        for (Customer customer : CUSTOMER_DATABASE) {
            if (customer.getID() == id) {
                return customer;
            }
        }
        return null;
    }

    /**
     * Remove customer boolean.
     *
     * @param id the id
     * @return the boolean
     * @throws CustomerNotFoundException the customer not found exception
     */
    public static boolean removeCustomer(int id) throws CustomerNotFoundException {
        for (Customer customer : CUSTOMER_DATABASE) {
            if (customer.getID() == id) {
                CUSTOMER_DATABASE.remove(customer);
                return true;
            }
        }
        throw new CustomerNotFoundException(id);
    }

    /**
     * Gets customer login.
     *
     * @param email    the email
     * @param password the password
     * @return the customer login
     */
    public static Customer getCustomerLogin(String email, String password) {
        for (Customer customerPtr : CUSTOMER_DATABASE) {
            if (customerPtr.getEmail().equals(email) && customerPtr.getPassword().equals(password)) {
                return customerPtr;
            }
        }
        return null;
    }
}