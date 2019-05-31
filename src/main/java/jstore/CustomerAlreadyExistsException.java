/**
 * <h1>CustomerAlreadyExistsException.java</h1>
 * <p>
 * Customer Already Exists Exception
 * </p>
 *
 * @author Mahdi Yusuf
 * @version 13.0
 * @since 2019/31/05
 */
package jstore;

/**
 * The type Customer already exists exception.
 */
public class CustomerAlreadyExistsException extends Exception {
    private Customer customer_error;

    /**
     * Instantiates a new Customer already exists exception.
     *
     * @param customer_input the customer input
     */
    public CustomerAlreadyExistsException(Customer customer_input) {
        super("Customer Email : ");
        customer_error = customer_input;
    }

    /**
     * Gets ex message.
     *
     * @return ex message
     */
    public String getExMessage() {
        return super.getMessage() + customer_error.getEmail()
                + ", or username: " + customer_error.getUsername() + " already exists.";
    }
}