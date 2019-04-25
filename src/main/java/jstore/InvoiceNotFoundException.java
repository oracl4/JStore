/**
 * <h1>InvoiceNotFoundException.java</h1>
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

public class InvoiceNotFoundException extends Exception
{
    private int invoice_error;

    public InvoiceNotFoundException(int invoice_input)
    {
        super("Invoice ID : ");
        this.invoice_error=invoice_input;
    }

    public String getExMessage(){
        return super.getMessage() + invoice_error + " not found.";
    }
}