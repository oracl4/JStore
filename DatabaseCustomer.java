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

    public static boolean addCustomer(Customer customer)
    {
        boolean value = false;
        for(Customer customerPtr : CUSTOMER_DATABASE)
        {
            if(customer.getName() != customerPtr.getName() && customer.getEmail() != customerPtr.getEmail())
            {
                CUSTOMER_DATABASE.add(customer);
                LAST_CUSTOMER_ID = customer.getId();
                value = true;
            }
        }
        return value;
    }

    public static Customer getCustomer(int id)
    {
        Customer value = null;
        for(Customer customerPtr : CUSTOMER_DATABASE)
        {
            if(customerPtr.getId() == id)
            {
                value=customerPtr;
            }
        }
        return value;
    }

    public static boolean removeCustomer(int id)
    {
        boolean value = false;
        for(Customer customerPtr : CUSTOMER_DATABASE)
        {
            if(customerPtr.getId() == id)
            {
                CUSTOMER_DATABASE.remove(id);
                value = true;
            }
        }
        return value;
    }
}