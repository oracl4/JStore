/**
 * <h1>ItemAlreadyExistsException.java</h1>
 * <p>
 * Item Already Exists Exception
 * </p>
 *
 * @author Mahdi Yusuf
 * @version 13.0
 * @since 2019/31/05
 */
package jstore;

/**
 * The type Item already exists exception.
 */
public class ItemAlreadyExistsException extends Exception {
    private Item item_error;

    /**
     * Instantiates a new Item already exists exception.
     *
     * @param item_input the item input
     */
    public ItemAlreadyExistsException(Item item_input) {
        super("Item Name : ");
        this.item_error = item_input;
    }

    /**
     * Gets ex message.
     *
     * @return the ex message
     */
    public String getExMessage() {
        return super.getMessage() + item_error.getName()
                + " , Category : " + item_error.getCategory()
                + " , Status : " + item_error.getStatus()
                + " From : " + item_error.getSupplier().getName()
                + "already exists.";
    }
}