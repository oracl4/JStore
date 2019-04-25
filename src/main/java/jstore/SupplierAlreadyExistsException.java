/**
 * <h1>SupplierAlreadyExistsException.java</h1>
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

public class SupplierAlreadyExistsException extends Exception
{
    private Supplier supplier_error;

    public SupplierAlreadyExistsException(Supplier supplier_input)
    {
        super("Supplier Email: ");
        supplier_error = supplier_input;
    }

    public String getExMessage()
    {
        return super.getMessage() + supplier_error.getEmail()
                + ", or phoneNumber: " + supplier_error.getPhoneNumber()
                + " already exists.";
    }
}