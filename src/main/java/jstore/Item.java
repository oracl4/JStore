/**
 * <h1>Item.java</h1>
 * <p>
 * Item Java Class
 * </p>
 *
 * @author Mahdi Yusuf
 * @version 13.0
 * @since 2019/31/05
 */
package jstore;

/**
 * The type Item.
 */
public class Item {
    private int id;
    private String name;
    private int price;
    private ItemCategory category;
    private ItemStatus status;
    private Supplier supplier;

    /**
     * Instantiates a new Item.
     *
     * @param name     the name
     * @param price    the price
     * @param category the category
     * @param status   the status
     * @param supplier the supplier
     */
    public Item(String name, int price, ItemCategory category, ItemStatus status, Supplier supplier) {
        this.id = DatabaseItem.getLastItemID() + 1;
        this.name = name;
        this.price = price;
        this.category = category;
        this.status = status;
        this.supplier = supplier;
    }

    /**
     * Gets id.
     *
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * Gets name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Gets price.
     *
     * @return the price
     */
    public int getPrice() {
        return price;
    }

    /**
     * Gets category.
     *
     * @return the category
     */
    public ItemCategory getCategory() {
        return category;
    }

    /**
     * Gets status.
     *
     * @return the status
     */
    public ItemStatus getStatus() {
        return status;
    }

    /**
     * Gets supplier.
     *
     * @return the supplier
     */
    public Supplier getSupplier() {
        return supplier;
    }

    /**
     * Sets id.
     *
     * @param id the id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Sets name.
     *
     * @param name the name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Sets price.
     *
     * @param price the price
     */
    public void setPrice(int price) {
        this.price = price;
    }

    /**
     * Sets category.
     *
     * @param category the category
     */
    public void setCategory(ItemCategory category) {
        this.category = category;
    }

    /**
     * Sets status.
     *
     * @param status the status
     */
    public void setStatus(ItemStatus status) {
        this.status = status;
    }

    /**
     * Sets supplier.
     *
     * @param supplier the supplier
     */
    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }

    public String toString() {
        return "= Item ===================================" +
                "\nItem ID       : " + getId() +
                "\nItem Name     : " + getName() +
                "\nItem Price    : " + getPrice() +
                "\nItem Category : " + getCategory() +
                "\nItem Status   : " + getStatus() +
                "\nSupplier      : " + getSupplier().getName() +
                "\n==========================================";
    }
}