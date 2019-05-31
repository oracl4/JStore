/**
 * <h1>ItemStatus.java</h1>
 * <p>
 * Item Status Enum
 * </p>
 *
 * @author Mahdi Yusuf
 * @version 13.0
 * @since 2019/31/05
 */
package jstore;

/**
 * The enum Item status.
 */
public enum ItemStatus {
    /**
     * New item status.
     */
    New("New"),
    /**
     * Second item status.
     */
    Second("Second"),
    /**
     * Refurbished item status.
     */
    Refurbished("Refurbished"),
    /**
     * Sold item status.
     */
    Sold("Sold");

    /**
     * The Status.
     */
    String status;

    ItemStatus(String status) {
        this.status = status;
    }

    public String toString() {
        return status;
    }
}