/**
 * <h1>SupplierNotFoundException.java</h1>
 * <p>
 * Supplier Not Found Exception
 * </p>
 *
 * @author Mahdi Yusuf
 * @version 13.0
 * @since 2019/31/05
 */
package jstore;

/**
 * The type Supplier not found exception.
 */
public class SupplierNotFoundException extends Exception {
    private int supplier_error;

    /**
     * Instantiates a new Supplier not found exception.
     *
     * @param supplier_error the supplier error
     */
    public SupplierNotFoundException(int supplier_error) {
        super("Supplier ID : ");
        this.supplier_error = supplier_error;
    }

    /**
     * Gets ex message.
     *
     * @return the ex message
     */
    public String getExMessage() {
        return super.getMessage() + supplier_error + " not found.";
    }
}
