/**
 * <h1>Invoice.java</h1>
 * <p>
 * Invoice Java Class
 * </p>
 *
 * @author Mahdi Yusuf
 * @version 13.0
 * @since 2019/31/05
 */
package jstore;

import java.util.*;

/**
 * The type Invoice.
 */
public abstract class Invoice {
    private int id;
    private Calendar date;
    private boolean isActive;
    private Customer customer;
    private ArrayList<Integer> item = new ArrayList<Integer>();

    /**
     * The Total price.
     */
//Testing
    public int totalPrice;

    /**
     * Instantiates a new Invoice.
     *
     * @param item the item
     */
    public Invoice(ArrayList<Integer> item) {
        this.item = item;
        this.id = DatabaseInvoice.getLastInvoiceID() + 1;
        this.date = Calendar.getInstance();
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
     * Gets item.
     *
     * @return the item
     */
    public ArrayList<Integer> getItem() {
        return item;
    }

    /**
     * Gets date.
     *
     * @return the date
     */
    public Calendar getDate() {
        return date;
    }

    /**
     * Gets total price.
     *
     * @return the total price
     */
    public int getTotalPrice() {
        return totalPrice;
    }

    /**
     * Gets is active.
     *
     * @return the is active
     */
    public boolean getIsActive() {
        return isActive;
    }

    /**
     * Gets customer.
     *
     * @return the customer
     */
    public Customer getCustomer() {
        return customer;
    }

    /**
     * Gets invoice status.
     *
     * @return the invoice status
     */
    public abstract InvoiceStatus getInvoiceStatus();

    /**
     * Gets invoice type.
     *
     * @return the invoice type
     */
    public abstract InvoiceType getInvoiceType();

    /**
     * Sets id.
     *
     * @param id the id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Sets item.
     *
     * @param item the item
     */
    public void setItem(ArrayList<Integer> item) {
        this.item = item;
    }

    /**
     * Sets date.
     *
     * @param date the date
     */
    public void setDate(Calendar date) {
        this.date = date;
    }

    /**
     * Sets total price.
     */
    public void setTotalPrice() {
        //Set Total Price
        int tempTotalHarga = 0;
        for (int itemPtr : this.getItem()) {
            tempTotalHarga = tempTotalHarga + DatabaseItem.getItemFromID(itemPtr).getPrice();
        }
        this.totalPrice = tempTotalHarga;
    }

    /**
     * Sets is active.
     *
     * @param isActive the is active
     */
    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }

    /**
     * Sets invoice status.
     *
     * @param status the status
     */
    public abstract void setInvoiceStatus(InvoiceStatus status);

    public abstract String toString();
}