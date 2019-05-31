/**
 * <h1>InvoiceAlreadyExistsException.java</h1>
 * <p>
 * Invoice Already Exists Exception
 * </p>
 *
 * @author Mahdi Yusuf
 * @version 13.0
 * @since 2019/31/05
 */
package jstore;

/**
 * The type Invoice already exists exception.
 */
public class InvoiceAlreadyExistsException extends Exception {
    private Invoice invoice_error;

    /**
     * Instantiates a new Invoice already exists exception.
     *
     * @param invoice_input the invoice input
     */
    public InvoiceAlreadyExistsException(Invoice invoice_input) {
        super("Invoice with Item list : ");
        this.invoice_error = invoice_input;
    }

    /**
     * Gets ex message.
     *
     * @return the ex message
     */
    public String getExMessage() {
        return super.getMessage() + invoice_error.getItem()
                + " already ordered by " + invoice_error.getCustomer().getUsername();
    }
}