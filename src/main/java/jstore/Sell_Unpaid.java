/**
 * <h1>Sell_Unpaid.java</h1>
 * <p>
 * Sell Unpaid Invoice Class
 * </p>
 *
 * @author Mahdi Yusuf
 * @version 13.0
 * @since 2019/31/05
 */
package jstore;

import java.text.SimpleDateFormat;
import java.util.*;

public class Sell_Unpaid extends Invoice {
    private static final InvoiceType INVOICE_TYPE = InvoiceType.Sell;
    private static final InvoiceStatus INVOICE_STATUS = InvoiceStatus.Unpaid;
    private Customer customer;
    private Calendar dueDate;

    /**
     * Instantiates a new Sell unpaid Invoice
     *
     * @param item     the item
     * @param customer the customer
     */
    public Sell_Unpaid(ArrayList<Integer> item, Customer customer) {
        super(item);
        this.customer = customer;
        this.dueDate = (Calendar) getDate().clone();
        dueDate.add(Calendar.DATE, +14);
        super.setIsActive(true);
        this.setTotalPrice();
    }

    /**
     * Gets invoice status
     *
     * @return the invoice status
     */
    public InvoiceStatus getInvoiceStatus() {
        return INVOICE_STATUS;
    }

    /**
     * Gets invoice type
     *
     * @return the invoice type
     */
    public InvoiceType getInvoiceType() {
        return INVOICE_TYPE;
    }

    /**
     * Gets customer
     *
     * @return the customer
     */
    public Customer getCustomer() {
        return customer;
    }

    /**
     * Gets due date
     *
     * @return the due date
     */
    public Calendar getDueDate() {
        return dueDate;
    }

    /**
     * Sets customer
     *
     * @param customer the customer
     */
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    /**
     * Sets due date
     *
     * @param dueDate the due date
     */
    public void setDueDate(Calendar dueDate) {
        this.dueDate = dueDate;
    }

    /**
     * Abstract method implementation
     *
     * @param status the status
     */
    public void setInvoiceStatus(InvoiceStatus status) {
    }

    /**
     * To String Function
     *
     * @return Formated Required String
     */
    public String toString() {
        System.out.println("= INVOICE SELL INSTALLMENT ===============");
        System.out.println("= SELL INSTALLMENT ITEMS LIST ============");
        for (int itemPtr : this.getItem()) {
            System.out.println(DatabaseItem.getItemFromID(itemPtr).toString());
        }
        System.out.println("= END OF SELL INSTALLMENT ITEMS LIST =====");

        SimpleDateFormat sdf = new SimpleDateFormat("dd MMMM yyyy");

        String tempStatus;
        if (super.getIsActive()) {
            tempStatus = "Invoice is Active";
        } else {
            tempStatus = "Invoice is Inactive";
        }

        return "= INVOICE ========================" +
                "\nInvoice ID         : " + getId() +
                "\nCustomer ID        : " + getCustomer().getID() +
                "\nCustomer Name      : " + getCustomer().getName() +
                "\nInvoice Date       : " + sdf.format(getDate().getTime()) +
                "\nInvoice Due Date   : " + sdf.format(getDueDate().getTime()) +
                "\nStatus             : " + InvoiceStatus.Unpaid +
                "\nInvoice Status     : " + tempStatus +
                "\nTotal Price        : " + getTotalPrice() +
                "\n= END OF INVOICE ==================";
    }
}
