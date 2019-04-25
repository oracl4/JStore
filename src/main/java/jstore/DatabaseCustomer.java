/**
 * <h1>DatabaseCustomer.java</h1>
 * <p>
 * Class Description
 * Class Description
 * </p>
 *
 *
 * @author   Mahdi Yusuf
 * @version  7.0
 * @since    2019/24/04
 */
package jstore;
import java.util.ArrayList;

public class DatabaseCustomer
{
    private static ArrayList<Customer> CUSTOMER_DATABASE = new ArrayList<Customer>();
    private static int LAST_CUSTOMER_ID = 0;
      
    public DatabaseCustomer()
    {
    }
    
    public static ArrayList<Customer> getCustomerDatabase()
    {
        return CUSTOMER_DATABASE;
    }

    public static int getLastCustomerID()
    {
        return LAST_CUSTOMER_ID;
    }

    public static boolean addCustomer(Customer customer) throws CustomerAlreadyExistsException
    {
        for (Customer temp : CUSTOMER_DATABASE )
        {
            if(((temp.getName().equals(customer.getName()))
                    || (temp.getEmail().equals(customer.getEmail()))))
            {
                throw new CustomerAlreadyExistsException(customer);
            }
        }
        CUSTOMER_DATABASE.add(customer);
        LAST_CUSTOMER_ID = customer.getID();
        return true;
    }

    public static Customer getCustomer(int id)
    {
        for (Customer customer : CUSTOMER_DATABASE)
        {
            if (customer.getID() == id )
            {
                return customer;
            }
        }
        return null;
    }

    public static boolean removeCustomer(int id) throws CustomerNotFoundException
    {
        for (Customer customer : CUSTOMER_DATABASE)
        {
            if (customer.getID() == id)
            {
                CUSTOMER_DATABASE.remove(customer);
                return true;
            }
        }
        throw new CustomerNotFoundException(id);
    }

    public static Customer getCustomerLogin(String email, String password){
        for (Customer customerPtr : CUSTOMER_DATABASE){
            if (customerPtr.getEmail().equals(email) && customerPtr.getPassword().equals(password))
            {
                return customerPtr;
            }
        }
        return null;
    }
}