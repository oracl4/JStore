package jstore.controller;

import jstore.*;
import org.springframework.web.bind.annotation.*;

import javax.xml.crypto.Data;
import java.util.ArrayList;
import java.util.Calendar;

@RestController
public class InvoiceController {

    @RequestMapping(value = "/invoicehistorycust/{id_customer}", method = RequestMethod.GET)
    public ArrayList<Invoice> invoiceHistoryCust(@PathVariable int id_customer) {
        ArrayList<Invoice> tempInvoiceList = new ArrayList<Invoice>();
        tempInvoiceList = DatabaseInvoice.getInactiveOrder(DatabaseCustomerPostgre.getCustomer(id_customer));
        return tempInvoiceList;
    }

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

    @RequestMapping("/invoice/{id_invoice}")
    public Invoice getInvoice(@PathVariable int id_invoice) {
        return DatabaseInvoice.getInvoice(id_invoice);
    }

    @RequestMapping(value = "/createinvoicepaid", method = RequestMethod.POST)
    public Invoice createInvoicePaid(@RequestParam(value="listitem") ArrayList<Integer> listItem,
                                     @RequestParam(value="id") int id_customer){
        try {
            boolean res = DatabaseInvoice.addInvoice(new Sell_Paid(listItem, DatabaseCustomerPostgre.getCustomer(id_customer)));
            if(res){
                return DatabaseInvoice.getInvoice(DatabaseInvoice.getLastInvoiceID());
            }
        } catch (InvoiceAlreadyExistsException e) {
            System.out.println(e.getExMessage());
        }
        return null;
    }

    @RequestMapping(value = "/createinvoiceunpaid", method = RequestMethod.POST)
    public Invoice createInvoiceUnpaid(@RequestParam(value="listitem") ArrayList<Integer> listItem,
                                       @RequestParam(value="id") int id_customer){
        try {
            boolean res = DatabaseInvoice.addInvoice(new Sell_Unpaid(listItem, DatabaseCustomerPostgre.getCustomer(id_customer)));
            if(res){
                return DatabaseInvoice.getInvoice(DatabaseInvoice.getLastInvoiceID());
            }
        } catch (InvoiceAlreadyExistsException e) {
            System.out.println(e.getExMessage());
        }
        return null;
    }

    @RequestMapping(value = "/createinvoiceinstallment", method = RequestMethod.POST)
    public Invoice createInvoiceInstallment(@RequestParam(value="listitem") ArrayList<Integer> listItem,
                                            @RequestParam(value="period") int installment_period,
                                            @RequestParam(value="id") int id_customer){
        try {
            boolean res = DatabaseInvoice.addInvoice(new Sell_Installment(listItem, installment_period,DatabaseCustomerPostgre.getCustomer(id_customer)));
            if(res){
                return DatabaseInvoice.getInvoice(DatabaseInvoice.getLastInvoiceID());
            }
        } catch (InvoiceAlreadyExistsException e) {
            System.out.println(e.getExMessage());
        }
        return null;
    }

    @RequestMapping(value = "/canceltransaction", method = RequestMethod.POST)
    public Invoice cancelTransaction(@RequestParam(value="id") int id_invoice){
        boolean res = Transaction.cancelTransaction(DatabaseInvoice.getInvoice(id_invoice));
        if (res){
            System.out.println("Invoice Canceled!");
            return DatabaseInvoice.getInvoice(id_invoice);
        }
        return null;
    }

    @RequestMapping(value = "/finishtransaction", method = RequestMethod.POST)
    public Invoice finishTransaction(@RequestParam(value="id") int id_invoice){
        boolean res = Transaction.finishTransaction(DatabaseInvoice.getInvoice(id_invoice));
        if (res){
            System.out.println("Invoice Finished!");
            return DatabaseInvoice.getInvoice(id_invoice);
        }
        return null;
    }
}