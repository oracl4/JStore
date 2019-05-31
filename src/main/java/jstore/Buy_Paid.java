/**
 * <h1>Buy_Paid.java</h1>
 * <p>
 * Buy Paid Invoice Class
 * </p>
 *
 * @author Mahdi Yusuf
 * @version 13.0
 * @since 2019/31/05
 */
package jstore;

import java.text.SimpleDateFormat;
import java.util.*;

public class Buy_Paid extends Invoice {
    private static final InvoiceType INVOICE_TYPE = InvoiceType.Buy;
    private static final InvoiceStatus INVOICE_STATUS = InvoiceStatus.Paid;

    /**
     * Instantiates a new Buy paid Invoice
     *
     * @param item the item
     */
    public Buy_Paid(ArrayList<Integer> item) {
        super(item);
        this.setTotalPrice();
        super.setIsActive(false);
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
        System.out.println("= INVOICE BUY PAID =======================");
        System.out.println("= BUY PAID ITEMS LIST ====================");
        for (int itemPtr : this.getItem()) {
            System.out.println(DatabaseItem.getItemFromID(itemPtr).toString());
        }
        System.out.println("= END OF BUY PAID ITEMS LIST =============");

        SimpleDateFormat sdf = new SimpleDateFormat("dd MMMM yyyy");

        String tempStatus;
        if (super.getIsActive()) {
            tempStatus = "Invoice is Active";
        } else {
            tempStatus = "Invoice is Inactive";
        }

        return "= INVOICE ========================" +
                "\nInvoice ID      : " + getId() +
                "\nInvoice Date    : " + sdf.format(getDate().getTime()) +
                "\nStatus          : " + InvoiceStatus.Unpaid +
                "\nInvoice Status  : " + tempStatus +
                "\nTotal Price     : " + getTotalPrice() +
                "\n= END OF INVOICE ==================";
    }
}
