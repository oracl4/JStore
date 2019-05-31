/**
 * <h1>InvoiceType.java</h1>
 * <p>
 * Invoice Type Enum
 * </p>
 *
 * @author Mahdi Yusuf
 * @version 13.0
 * @since 2019/31/05
 */
package jstore;

/**
 * The enum Invoice type.
 */
public enum InvoiceType {
    /**
     * Buy invoice type.
     */
    Buy("Buy"),
    /**
     * Sell invoice type.
     */
    Sell("Sell");

    /**
     * The Type.
     */
    String type;

    InvoiceType(String type) {
        this.type = type;
    }

    public String toString() {
        return type;
    }
}