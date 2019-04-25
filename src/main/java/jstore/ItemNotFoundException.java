/**
 * <h1>ItemNotFoundException.java</h1>
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

public class ItemNotFoundException extends Exception
{
    private int item_error;

    public ItemNotFoundException(int item_input)
    {
        super("Item ID : ");
        this.item_error=item_input;
    }

    public String getExMessage()
    {
        return super.getMessage() + item_error + " not found.";
    }
}
