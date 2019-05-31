/**
 * <h1>CustomerDoesntHaveActiveException.java</h1>
 * <p>
 * Customer Doesnt Have Active Invoice Exception
 * </p>
 *
 * @author Mahdi Yusuf
 * @version 13.0
 * @since 2019/31/05
 */
package jstore;

/**
 * The type Customer doesnt have active exception.
 */
public class CustomerDoesntHaveActiveException extends Exception {
    private Customer customer_error;

    /**
     * Instantiates a new Customer doesnt have active exception.
     *
     * @param customer_input the customer input
     */
    public CustomerDoesntHaveActiveException(Customer customer_input) {
        super("Customer : ");
        this.customer_error = customer_input;
    }

    /**
     * Gets ex message.
     *
     * @return the ex message
     */
    public String getExMessage() {
        return super.getMessage() + customer_error + "\ndoesnt have active invoice.";
    }
}
