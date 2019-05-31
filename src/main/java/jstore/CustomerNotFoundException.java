/**
 * <h1>CustomerNotFoundException.java</h1>
 * <p>
 * Customer Not Found Exception
 * </p>
 *
 * @author Mahdi Yusuf
 * @version 13.0
 * @since 2019/31/05
 */
package jstore;

/**
 * The type Customer not found exception.
 */
public class CustomerNotFoundException extends Exception {
    private int customer_error;

    /**
     * Instantiates a new Customer not found exception.
     *
     * @param customer_input the customer input
     */
    public CustomerNotFoundException(int customer_input) {
        super("Customer ID : ");
        this.customer_error = customer_input;
    }

    /**
     * Gets ex message.
     *
     * @return the ex message
     */
    public String getExMessage() {
        return super.getMessage() + customer_error + " not found.";
    }
}