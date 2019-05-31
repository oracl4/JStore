/**
 * <h1>InvoiceNotFoundException.java</h1>
 * <p>
 * Invoice Not Found Exception
 * </p>
 *
 * @author Mahdi Yusuf
 * @version 13.0
 * @since 2019/31/05
 */
package jstore;

/**
 * The type Invoice not found exception.
 */
public class InvoiceNotFoundException extends Exception {
    private int invoice_error;

    /**
     * Instantiates a new Invoice not found exception.
     *
     * @param invoice_input the invoice input
     */
    public InvoiceNotFoundException(int invoice_input) {
        super("Invoice ID : ");
        this.invoice_error = invoice_input;
    }

    /**
     * Gets ex message.
     *
     * @return the ex message
     */
    public String getExMessage() {
        return super.getMessage() + invoice_error + " not found.";
    }
}