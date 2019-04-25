/**
 * <h1>CustomerNotFoundException.java</h1>
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

public class CustomerNotFoundException extends Exception
{
    private int customer_error;

    public CustomerNotFoundException(int customer_input)
    {
        super("Customer ID : ");
        this.customer_error = customer_input;
    }

    public String getExMessage()
    {
        return super.getMessage() + customer_error + " not found.";
    }
}