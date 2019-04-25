/**
 * <h1>ItemAlreadyExistsException.java</h1>
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

public class ItemAlreadyExistsException extends Exception{
    private Item item_error;

    public ItemAlreadyExistsException(Item item_input)
    {
        super("Item Name : ");
        this.item_error=item_input;
    }

    public String getExMessage()
    {
        return super.getMessage() + item_error.getName()
                + " , Category : "+ item_error.getCategory()
                + " , Status : "+ item_error.getStatus()
                + " From : " + item_error.getSupplier().getName()
                + "already exists.";
    }
}