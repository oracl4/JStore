/**
 * <h1>InvoiceAlreadyExistsException.java</h1>
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

public class InvoiceAlreadyExistsException extends Exception
{
    private Invoice invoice_error;

    public InvoiceAlreadyExistsException(Invoice invoice_input)
    {
        super("Invoice with Item list : ");
        this.invoice_error=invoice_input;
    }

    public String getExMessage()
    {
        return super.getMessage() + invoice_error.getItem()
                + " already ordered by " + invoice_error.getCustomer().getUsername();
    }
}