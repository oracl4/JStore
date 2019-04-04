
/**
 * Write a description of class Buy_Paid here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.*;

public class Sell_Installment extends Invoice
{
    private static final InvoiceType INVOICE_TYPE = InvoiceType.Sell;
    private static final InvoiceStatus INVOICE_STATUS = InvoiceStatus.Installment;
    private int installmentPeriod;
    private int installmentPrice;
    Customer customer;

    /**
     * Constructor for objects of class Buy_Paid
     */
    public Sell_Installment (int id, Item item, int totalItem, int installmentPeriod, Customer customer)
    {
        super(id, item, totalItem);
        this.installmentPeriod=installmentPeriod;
        this.customer=customer;
        //setInstallmentPrice(totalPrice);
        //setTotalPrice(installmentPrice);
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public int getInstallmentPeriod()
    {
        return installmentPeriod;
    }
    
    public int getInstallmentPrice()
    {
        return installmentPrice;
    }

    public Customer getCustomer(){
        return customer;
    }
    
    public InvoiceStatus getInvoiceStatus()
    {
        return INVOICE_STATUS;
    }
    
    public InvoiceType getInvoiceType(){
        return INVOICE_TYPE;
    }

    public void setInstallmentPrice(int totalPrice){
        installmentPrice=(totalPrice/installmentPeriod)*(102/100);
    }

    public void setTotalPrice(){
        //totalPrice=installmentPrice*installmentPeriod;
    }

    public void setCustomer(Customer customer){
        this.customer=customer;
    }
    
    public void setInvoiceStatus(InvoiceStatus status){
    }


    public String toString(){
     return "===== Invoice =====" + "ID: " + this.getId() + "Item: " + this.getItem().getName() + "Amount:"
                + this.getTotalItem() + "Buy Date: " + this.getDate() + "Price: " + this.getItem().getPrice()
                + "Price total: " + this.getTotalPrice() + "Supplier ID: " + this.getItem().getSupplier().getId()
                + "Supplier name: " + this.getItem().getSupplier().getName() + "Customer ID: "
                + this.getCustomer().getId() + "Customer name: " + this.getCustomer().getName() + "status: "
                + this.INVOICE_STATUS + "Installment Period: " + this.installmentPeriod + "Sell success";
    }

    /*public void printData(){
        System.out.println("==========INVOICE=======");
        System.out.println("ID :" + getId());
        System.out.println("Date :" + getDate());
        System.out.println("Item :" + getItem().getName());
        System.out.println("Invoice Status :" + getInvoiceStatus());
        System.out.println("Invoice Type :" + getInvoiceType());
        System.out.println("Installment Period :" + getInstallmentPeriod());
        System.out.println("Total harga :" + getTotalPrice());
        System.out.println("Installation Price :" + getInstallmentPrice());
    }*/
}
