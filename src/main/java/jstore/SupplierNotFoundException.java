/**
 * <h1>SupplierNotFoundException.java</h1>
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

public class SupplierNotFoundException extends Exception
{
    private int supplier_error;

    public SupplierNotFoundException(int supplier_error)
    {
        super("Supplier ID : ");
        this.supplier_error = supplier_error;
    }

    public String getExMessage()
    {
        return super.getMessage() + supplier_error + " not found.";
    }
}
