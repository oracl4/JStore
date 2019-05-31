/**
 * <h1>Sell_Installment.java</h1>
 * <p>
 * Sell Installment Invoice Class
 * </p>
 *
 * @author Mahdi Yusuf
 * @version 13.0
 * @since 2019/31/05
 */
package jstore;

import java.text.SimpleDateFormat;
import java.util.*;

public class Sell_Installment extends Invoice {
    private static final InvoiceType INVOICE_TYPE = InvoiceType.Sell;
    private static final InvoiceStatus INVOICE_STATUS = InvoiceStatus.Installment;
    private Customer customer;
    private int installmentPeriod;
    private int installmentPrice;

    /**
     * Instantiates a new Sell installment Invoice
     *
     * @param item              the item
     * @param installmentPeriod the installment period
     * @param customer          the customer
     */
    public Sell_Installment(ArrayList<Integer> item, int installmentPeriod, Customer customer) {
        super(item);
        this.installmentPeriod = installmentPeriod;
        this.customer = customer;
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
     * Gets installment period
     *
     * @return the installment period
     */
    public int getInstallmentPeriod() {
        return installmentPeriod;
    }

    /**
     * Gets installment price
     *
     * @return the installment price
     */
    public int getInstallmentPrice() {
        return installmentPrice;
    }

    /**
     *  Set Total Price based on Installement Period and totalPrice
     */
    @Override
    public void setTotalPrice() {
        //Set Total Price
        int tempTotalHarga = 0;
        for (int itemPtr : this.getItem()) {
            tempTotalHarga = tempTotalHarga + DatabaseItem.getItemFromID(itemPtr).getPrice();
        }

        double tempInstallmentPrice = (tempTotalHarga / installmentPeriod) * 1.02;
        installmentPrice = (int) tempInstallmentPrice;
        super.totalPrice = installmentPrice * installmentPeriod;
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
                "\nStatus             : " + InvoiceStatus.Installment +
                "\nInvoice Status     : " + tempStatus +
                "\nInstallment Period : " + getInstallmentPeriod() +
                "\nTotal Price        : " + getTotalPrice() +
                "\n= END OF INVOICE ==================";
    }
}
