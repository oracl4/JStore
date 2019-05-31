/**
 * <h1>InvoiceController.java</h1>
 * <p>
 * Invoice controller for Springboot Framework
 * </p>
 *
 * @author Mahdi Yusuf
 * @version 13.0
 * @since 2019/31/05
 */
package jstore.controller;

import jstore.*;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class InvoiceController {

    /**
     * Get inactive invoice history by customer id request
     *
     * @param id_customer the customer id
     * @return the array list of invoice
     */
    @RequestMapping(value = "/invoicehistorycust/{id_customer}", method = RequestMethod.GET)
    public ArrayList<Invoice> invoiceHistoryCust(@PathVariable int id_customer) {
        ArrayList<Invoice> tempInvoiceList = new ArrayList<Invoice>();
        tempInvoiceList = DatabaseInvoice.getInactiveOrder(DatabaseCustomerPostgre.getCustomer(id_customer));
        return tempInvoiceList;
    }

    /**
     * Get active invoice by customer id request
     *
     * @param id_customer the customer id
     * @return the array list of invoice
     */
    @RequestMapping(value = "/invoicecustomer/{id_customer}", method = RequestMethod.GET)
    public ArrayList<Invoice> invoiceCust(@PathVariable int id_customer) {
        ArrayList<Invoice> tempInvoiceList = new ArrayList<Invoice>();
        try {
            tempInvoiceList = DatabaseInvoice.getActiveOrder(DatabaseCustomerPostgre.getCustomer(id_customer));
        } catch (CustomerDoesntHaveActiveException e) {
            System.out.println(e.getExMessage());
        }
        return tempInvoiceList;
    }

    /**
     * Get invoice by id request
     *
     * @param id_invoice the invoice id
     * @return the invoice
     */
    @RequestMapping("/invoice/{id_invoice}")
    public Invoice getInvoice(@PathVariable int id_invoice) {
        return DatabaseInvoice.getInvoice(id_invoice);
    }

    /**
     * Create paid invoice request
     *
     * @param listItem    the list of item
     * @param id_customer the customer id
     * @return the invoice
     */
    @RequestMapping(value = "/createinvoicepaid", method = RequestMethod.POST)
    public Invoice createInvoicePaid(@RequestParam(value = "listitem") ArrayList<Integer> listItem,
                                     @RequestParam(value = "id") int id_customer) {
        try {
            boolean res = DatabaseInvoice.addInvoice(new Sell_Paid(listItem, DatabaseCustomerPostgre.getCustomer(id_customer)));
            if (res) {
                return DatabaseInvoice.getInvoice(DatabaseInvoice.getLastInvoiceID());
            }
        } catch (InvoiceAlreadyExistsException e) {
            System.out.println(e.getExMessage());
        }
        return null;
    }

    /**
     * Create unpaid invoice request
     *
     * @param listItem    the list of item
     * @param id_customer the customer id
     * @return the invoice
     */
    @RequestMapping(value = "/createinvoiceunpaid", method = RequestMethod.POST)
    public Invoice createInvoiceUnpaid(@RequestParam(value = "listitem") ArrayList<Integer> listItem,
                                       @RequestParam(value = "id") int id_customer) {
        try {
            boolean res = DatabaseInvoice.addInvoice(new Sell_Unpaid(listItem, DatabaseCustomerPostgre.getCustomer(id_customer)));
            if (res) {
                return DatabaseInvoice.getInvoice(DatabaseInvoice.getLastInvoiceID());
            }
        } catch (InvoiceAlreadyExistsException e) {
            System.out.println(e.getExMessage());
        }
        return null;
    }

    /**
     * Create installment invoice request
     *
     * @param listItem    the list of item
     * @param id_customer the customer id
     * @param installment_period the installment period
     * @return the invoice
     */
    @RequestMapping(value = "/createinvoiceinstallment", method = RequestMethod.POST)
    public Invoice createInvoiceInstallment(@RequestParam(value = "listitem") ArrayList<Integer> listItem,
                                            @RequestParam(value = "period") int installment_period,
                                            @RequestParam(value = "id") int id_customer) {
        try {
            boolean res = DatabaseInvoice.addInvoice(new Sell_Installment(listItem, installment_period, DatabaseCustomerPostgre.getCustomer(id_customer)));
            if (res) {
                return DatabaseInvoice.getInvoice(DatabaseInvoice.getLastInvoiceID());
            }
        } catch (InvoiceAlreadyExistsException e) {
            System.out.println(e.getExMessage());
        }
        return null;
    }

    /**
     * Cancel invoice transaction request
     *
     * @param id_invoice the invoice id
     * @return the invoice
     */
    @RequestMapping(value = "/canceltransaction", method = RequestMethod.POST)
    public Invoice cancelTransaction(@RequestParam(value = "id") int id_invoice) {
        boolean res = Transaction.cancelTransaction(DatabaseInvoice.getInvoice(id_invoice));
        if (res) {
            System.out.println("Invoice Canceled!");
            return DatabaseInvoice.getInvoice(id_invoice);
        }
        return null;
    }

    /**
     * Finish invoice transaction request
     *
     * @param id_invoice the invoice id
     * @return the invoice
     */
    @RequestMapping(value = "/finishtransaction", method = RequestMethod.POST)
    public Invoice finishTransaction(@RequestParam(value = "id") int id_invoice) {
        boolean res = Transaction.finishTransaction(DatabaseInvoice.getInvoice(id_invoice));
        if (res) {
            System.out.println("Invoice Finished!");
            return DatabaseInvoice.getInvoice(id_invoice);
        }
        return null;
    }
}