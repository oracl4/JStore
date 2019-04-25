/**
 * <h1>CustomerAlreadyExistsException.java</h1>
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

public class CustomerAlreadyExistsException extends Exception
{
    private Customer customer_error;

    public CustomerAlreadyExistsException(Customer customer_input)
    {
        super("Customer Email : ");
        customer_error = customer_input;
    }

    public String getExMessage()
    {
        return super.getMessage() + customer_error.getEmail()
                + ", or username: " + customer_error.getUsername() + " already exists.";
    }
}