/**
 * <h1>InvoiceStatus.java</h1>
 * <p>
 * Invoice Status Enum
 * </p>
 *
 * @author Mahdi Yusuf
 * @version 13.0
 * @since 2019/31/05
 */
package jstore;

/**
 * The enum Invoice status.
 */
public enum InvoiceStatus {
    /**
     * Paid invoice status.
     */
    Paid("Paid"),
    /**
     * Unpaid invoice status.
     */
    Unpaid("Unpaid"),
    /**
     * Installment invoice status.
     */
    Installment("Installment");

    /**
     * The Status.
     */
    String status;

    InvoiceStatus(String status) {
        this.status = status;
    }

    public String toString() {
        return status;
    }
}