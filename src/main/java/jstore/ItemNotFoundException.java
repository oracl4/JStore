/**
 * <h1>ItemNotFoundException.java</h1>
 * <p>
 * Item Not Found Exception
 * </p>
 *
 * @author Mahdi Yusuf
 * @version 13.0
 * @since 2019/31/05
 */
package jstore;

/**
 * The type Item not found exception.
 */
public class ItemNotFoundException extends Exception {
    private int item_error;

    /**
     * Instantiates a new Item not found exception.
     *
     * @param item_input the item input
     */
    public ItemNotFoundException(int item_input) {
        super("Item ID : ");
        this.item_error = item_input;
    }

    /**
     * Gets ex message.
     *
     * @return the ex message
     */
    public String getExMessage() {
        return super.getMessage() + item_error + " not found.";
    }
}
