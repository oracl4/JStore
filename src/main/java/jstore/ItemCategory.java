/**
 * <h1>ItemCategory.java</h1>
 * <p>
 * Item Category Enum
 * </p>
 *
 * @author Mahdi Yusuf
 * @version 13.0
 * @since 2019/31/05
 */
package jstore;

/**
 * The enum Item category.
 */
public enum ItemCategory {
    /**
     * Electronics item category.
     */
    Electronics("Electronics"),
    /**
     * Furniture item category.
     */
    Furniture("Furniture"),
    /**
     * Stationary item category.
     */
    Stationary("Stationary");

    /**
     * The Category.
     */
    String category;

    ItemCategory(String category) {
        this.category = category;
    }

    public String toString() {
        return category;
    }
}