/**
 * <h1>DatabaseInvoice.java</h1>
 * <p>
 * Static Java Invoice Database
 * </p>
 *
 * @author Mahdi Yusuf
 * @version 13.0
 * @since 2019/31/05
 */
package jstore;

import java.util.*;

/**
 * The type Database invoice.
 */
public class DatabaseInvoice {
    private static ArrayList<Invoice> INVOICE_DATABASE = new ArrayList<Invoice>();
    private static int LAST_INVOICE_ID = 0;

    /**
     * Gets invoice database.
     *
     * @return the invoice database
     */
    public static ArrayList<Invoice> getInvoiceDatabase() {
        return INVOICE_DATABASE;

    }

    /**
     * Gets last invoice id.
     *
     * @return the last invoice id
     */
    public static int getLastInvoiceID() {
        return LAST_INVOICE_ID;
    }

    /**
     * Add invoice boolean.
     *
     * @param invoice the invoice
     * @return the boolean
     * @throws InvoiceAlreadyExistsException the invoice already exists exception
     */
    public static boolean addInvoice(Invoice invoice) throws InvoiceAlreadyExistsException {
        for (Invoice invoicePtr : INVOICE_DATABASE) {
            if (invoicePtr.getItem().equals(invoice.getItem()) &&
                    invoicePtr.getCustomer().getID() == invoice.getCustomer().getID() &&
                    invoicePtr.getIsActive()) {
                throw new InvoiceAlreadyExistsException(invoice);
            }
        }
        INVOICE_DATABASE.add(invoice);
        LAST_INVOICE_ID = invoice.getId();
        return true;
    }

    /**
     * Gets invoice.
     *
     * @param id the id
     * @return the invoice
     */
    public static Invoice getInvoice(int id) {
        for (Invoice invoice : INVOICE_DATABASE) {
            if (invoice.getId() == id) {
                return invoice;
            }
        }
        return null;
    }

    /**
     * Gets active order.
     *
     * @param customer the customer
     * @return the active order
     * @throws CustomerDoesntHaveActiveException the customer doesnt have active exception
     */
    public static ArrayList<Invoice> getActiveOrder(Customer customer) throws CustomerDoesntHaveActiveException {
        ArrayList<Invoice> tempInvoiceList = new ArrayList<Invoice>();
        for (Invoice invoicePtr : INVOICE_DATABASE) {
            if (invoicePtr.getIsActive() &&
                    invoicePtr.getCustomer().getID() == customer.getID()
            ) {
                tempInvoiceList.add(invoicePtr);
            }
        }
        return tempInvoiceList;
    }

    /**
     * Gets inactive order.
     *
     * @param customer the customer
     * @return the inactive order
     */
    public static ArrayList<Invoice> getInactiveOrder(Customer customer) {
        ArrayList<Invoice> tempInvoiceList = new ArrayList<Invoice>();
        for (Invoice invoicePtr : INVOICE_DATABASE) {
            if (!invoicePtr.getIsActive() &&
                    invoicePtr.getCustomer().getID() == customer.getID()
            ) {
                tempInvoiceList.add(invoicePtr);
            }
        }
        return tempInvoiceList;
    }

    /**
     * Remove invoice boolean.
     *
     * @param id the id
     * @return the boolean
     * @throws InvoiceNotFoundException the invoice not found exception
     */
    public static boolean removeInvoice(int id) throws InvoiceNotFoundException {
        for (Invoice invoice : INVOICE_DATABASE) {
            if (invoice.getId() == id) {
                if (invoice.getIsActive()) {
                    invoice.setIsActive(false);
                }
                INVOICE_DATABASE.remove(invoice);
                return true;
            }
        }
        throw new InvoiceNotFoundException(id);
    }
}