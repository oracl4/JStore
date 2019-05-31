/**
 * <h1>Transaction.java</h1>
 * <p>
 * Transaction Java Class, this consists of main transaction method
 * </p>
 *
 * @author Mahdi Yusuf
 * @version 13.0
 * @since 2019/31/05
 */
package jstore;

import java.util.*;

/**
 * The type Transaction.
 */
public class Transaction {
    /**
     * Order new item.
     *
     * @param item_list the item list
     */
    public static void orderNewItem(ArrayList<Integer> item_list) {
        try {
            DatabaseInvoice.addInvoice(new Buy_Paid(item_list));
        } catch (InvoiceAlreadyExistsException e) {
            System.out.println(e.getExMessage());
        }
    }

    /**
     * Order second item.
     *
     * @param item_list the item list
     */
    public static void orderSecondItem(ArrayList<Integer> item_list) {
        try {
            DatabaseInvoice.addInvoice(new Buy_Paid(item_list));
        } catch (InvoiceAlreadyExistsException e) {
            System.out.println(e.getExMessage());
        }
    }

    /**
     * Order refurbished item.
     *
     * @param item_list the item list
     */
    public static void orderRefurbishedItem(ArrayList<Integer> item_list) {
        try {
            DatabaseInvoice.addInvoice(new Buy_Paid(item_list));
        } catch (InvoiceAlreadyExistsException e) {
            System.out.println(e.getExMessage());
        }
    }

    /**
     * Sell item paid.
     *
     * @param item_list the item list
     * @param customer  the customer
     */
    public static void sellItemPaid(ArrayList<Integer> item_list, Customer customer) {
        try {
            DatabaseInvoice.addInvoice(new Sell_Paid(item_list, customer));
        } catch (InvoiceAlreadyExistsException e) {
            System.out.println(e.getExMessage());
        }
    }

    /**
     * Sell item unpaid.
     *
     * @param item_list the item list
     * @param customer  the customer
     */
    public static void sellItemUnpaid(ArrayList<Integer> item_list, Customer customer) {
        try {
            DatabaseInvoice.addInvoice(new Sell_Unpaid(item_list, customer));
        } catch (InvoiceAlreadyExistsException e) {
            System.out.println(e.getExMessage());
        }
    }

    /**
     * Sell item installment.
     *
     * @param item_list         the item list
     * @param customer          the customer
     * @param installmentPeriod the installment period
     */
    public static void sellItemInstallment(ArrayList<Integer> item_list, Customer customer, int installmentPeriod) {
        try {
            DatabaseInvoice.addInvoice(new Sell_Installment(item_list, installmentPeriod, customer));
        } catch (InvoiceAlreadyExistsException e) {
            System.out.println(e.getExMessage());
        }
    }

    /**
     * Finish transaction boolean.
     *
     * @param invoice the invoice
     * @return the boolean
     */
    public static boolean finishTransaction(Invoice invoice) {
        if (DatabaseInvoice.getInvoice(invoice.getId()) != null) {
            invoice.setIsActive(false);
            System.out.println("Invoice Status : " + invoice.getIsActive());
            return true;
        }
        return false;
    }

    /**
     * Cancel transaction boolean.
     *
     * @param invoice the invoice
     * @return the boolean
     */
    public static boolean cancelTransaction(Invoice invoice) {
        if (DatabaseInvoice.getInvoice(invoice.getId()) != null) {
            try {
                DatabaseInvoice.removeInvoice(invoice.getId());
            } catch (InvoiceNotFoundException e) {
                System.out.println(e.getExMessage());
            }
            return true;
        }
        return false;
    }
}