/**
 * <h1>CustomerDoesntHaveActiveException.java</h1>
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

public class CustomerDoesntHaveActiveException extends Exception
{
    private Customer customer_error;

    public CustomerDoesntHaveActiveException(Customer customer_input)
    {
        super("Customer : ");
        this.customer_error=customer_input;
    }

    public String getExMessage()
    {
        return super.getMessage() + customer_error + "\ndoesnt have active invoice.";
    }
}
