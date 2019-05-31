/**
 * <h1>Transaction.java</h1>
 * <p>
 * Class Description
 * Class Description
 * </p>
 *
 *
 * @author   Mahdi Yusuf
 * @version  7.0
 * @since    2019/24/04
 */
package jstore;
import java.util.*;

public class Transaction
{
    public static void orderNewItem(ArrayList<Integer> item_list)
    {
        try {
            DatabaseInvoice.addInvoice(new Buy_Paid(item_list));
        } catch (InvoiceAlreadyExistsException e) {
            System.out.println(e.getExMessage());
        }
    }

    public static void orderSecondItem(ArrayList<Integer> item_list)
    {
        try {
            DatabaseInvoice.addInvoice(new Buy_Paid(item_list));
        } catch (InvoiceAlreadyExistsException e) {
            System.out.println(e.getExMessage());
        }
    }

    public static void orderRefurbishedItem(ArrayList<Integer> item_list)
    {
        try {
            DatabaseInvoice.addInvoice(new Buy_Paid(item_list));
        } catch (InvoiceAlreadyExistsException e) {
            System.out.println(e.getExMessage());
        }
    }

    public static void sellItemPaid(ArrayList<Integer> item_list, Customer customer)
    {
        try {
            DatabaseInvoice.addInvoice(new Sell_Paid(item_list, customer));
        } catch (InvoiceAlreadyExistsException e) {
            System.out.println(e.getExMessage());
        }
    }

    public static void sellItemUnpaid(ArrayList<Integer> item_list, Customer customer)
    {
        try {
            DatabaseInvoice.addInvoice(new Sell_Unpaid(item_list, customer));
        } catch (InvoiceAlreadyExistsException e) {
            System.out.println(e.getExMessage());
        }
    }

    public static void sellItemInstallment(ArrayList<Integer> item_list, Customer customer, int installmentPeriod)
    {
        try {
            DatabaseInvoice.addInvoice(new Sell_Installment(item_list, installmentPeriod, customer));
        } catch (InvoiceAlreadyExistsException e) {
            System.out.println(e.getExMessage());
        }
    }
    
    public static boolean finishTransaction(Invoice invoice)
    {
        if(DatabaseInvoice.getInvoice(invoice.getId()) != null)
        {
            invoice.setIsActive(false);
            System.out.println("Invoice Status : " + invoice.getIsActive());
            return true;
        }
        return false;
    }
    
    public static boolean cancelTransaction(Invoice invoice)
    {
        if(DatabaseInvoice.getInvoice(invoice.getId()) != null)
        {
            try
            {
                DatabaseInvoice.removeInvoice(invoice.getId());
            }
            catch (InvoiceNotFoundException e)
            {
                System.out.println(e.getExMessage());
            }
            return true;
        }
        return false;
    }
}