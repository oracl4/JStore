/**
 * <h1>SupplierAlreadyExistsException.java</h1>
 * <p>
 * Supplier Already Exists Exception
 * </p>
 *
 * @author Mahdi Yusuf
 * @version 13.0
 * @since 2019/31/05
 */
package jstore;

/**
 * The type Supplier already exists exception.
 */
public class SupplierAlreadyExistsException extends Exception {
    private Supplier supplier_error;

    /**
     * Instantiates a new Supplier already exists exception.
     *
     * @param supplier_input the supplier input
     */
    public SupplierAlreadyExistsException(Supplier supplier_input) {
        super("Supplier Email: ");
        supplier_error = supplier_input;
    }

    /**
     * Gets ex message.
     *
     * @return the ex message
     */
    public String getExMessage() {
        return super.getMessage() + supplier_error.getEmail()
                + ", or phoneNumber: " + supplier_error.getPhoneNumber()
                + " already exists.";
    }
}