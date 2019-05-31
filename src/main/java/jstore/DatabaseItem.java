/**
 * <h1>DatabaseItem.java</h1>
 * <p>
 * Static Java Item Database
 * </p>
 *
 * @author Mahdi Yusuf
 * @version 13.0
 * @since 2019/31/05
 */
package jstore;

import java.util.*;

/**
 * The type Database item.
 */
public class DatabaseItem {
    private static ArrayList<Item> ITEM_DATABASE = new ArrayList<Item>();
    private static int LAST_ITEM_ID = 0;

    /**
     * Method DatabaseItem merupakan Constructor dari DatabaseItem Class
     * Method ini dapat berisi nilai default dari variabel dalam DatabaseItem Class
     */
    public DatabaseItem() {
    }

    /**
     * Gets item database.
     *
     * @return the item database
     */
    public static ArrayList<Item> getItemDatabase() {
        return ITEM_DATABASE;
    }

    /**
     * Gets last item id.
     *
     * @return the last item id
     */
    public static int getLastItemID() {
        return LAST_ITEM_ID;
    }

    /**
     * Add item boolean.
     *
     * @param item the item
     * @return the boolean
     * @throws ItemAlreadyExistsException the item already exists exception
     */
    public static boolean addItem(Item item) throws ItemAlreadyExistsException {
        for (Item itemDB1 : ITEM_DATABASE) {
            if ((itemDB1.getName().equals(item.getName()))
                    && (itemDB1.getStatus().equals(item.getStatus()))
                    && (itemDB1.getCategory().equals(item.getCategory()))
                    && (itemDB1.getSupplier().equals(item.getSupplier()))) {
                throw new ItemAlreadyExistsException(item);
            }
        }
        ITEM_DATABASE.add(item);
        LAST_ITEM_ID = item.getId();
        return true;
    }

    /**
     * Gets item from id.
     *
     * @param id the id
     * @return the item from id
     */
    public static Item getItemFromID(int id) {
        for (Item itemDB2 : ITEM_DATABASE) {
            if (itemDB2.getId() == id) {
                return itemDB2;
            }
        }
        return null;
    }

    /**
     * Gets item from supplier.
     *
     * @param supplier the supplier
     * @return the item from supplier
     */
    public static ArrayList<Item> getItemFromSupplier(Supplier supplier) {
        ArrayList<Item> itemDB3 = new ArrayList<Item>();
        for (Item item : ITEM_DATABASE) {
            if (item.getSupplier() == supplier) {
                itemDB3.add(item);
            }
        }
        return itemDB3;
    }

    /**
     * Gets item from category.
     *
     * @param category the category
     * @return the item from category
     */
    public static ArrayList<Item> getItemFromCategory(ItemCategory category) {
        ArrayList<Item> itemDB4 = new ArrayList<Item>();
        for (Item item : ITEM_DATABASE) {
            if (item.getCategory() == category) {
                itemDB4.add(item);
            }
        }
        return itemDB4;
    }

    /**
     * Gets item from status.
     *
     * @param status the status
     * @return the item from status
     */
    public static ArrayList<Item> getItemFromStatus(ItemStatus status) {
        ArrayList<Item> bar = new ArrayList<Item>();
        for (Item item : ITEM_DATABASE) {
            if (item.getStatus() == status) {
                bar.add(item);
            }
        }
        return bar;
    }

    /**
     * Remove item boolean.
     *
     * @param id the id
     * @return the boolean
     * @throws ItemNotFoundException the item not found exception
     */
    public static boolean removeItem(int id) throws ItemNotFoundException {
        for (Item item : ITEM_DATABASE) {
            if (item.getId() == id) {
                ITEM_DATABASE.remove(item);
                return true;
            }
        }
        throw new ItemNotFoundException(id);
    }
}