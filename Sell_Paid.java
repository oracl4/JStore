
/**
 * Write a description of class Buy_Paid here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.*;

public class Sell_Paid extends Invoice
{
   private static final InvoiceType INVOICE_TYPE = InvoiceType.Sell;
   private static final InvoiceStatus INVOICE_STATUS = InvoiceStatus.Paid;
   private Customer customer;

    /**
     * Constructor for objects of class Buy_Paid
     */
    public Sell_Paid (int id, Item item, int totalItem, Customer customer)
    {
        super(id, item, totalItem);
        this.customer=customer;
    }

    public Customer getCustomer(){
        return customer;
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public InvoiceStatus getInvoiceStatus()
    {
        return INVOICE_STATUS;
    }
    
    public InvoiceType getInvoiceType(){
        return INVOICE_TYPE;
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
                + this.INVOICE_STATUS + "Sell success";
    }

    /*public void printData(){
        System.out.println("==========INVOICE=======");
        System.out.println("ID :" + getId());
        System.out.println("Date :" + getDate());
        System.out.println("Item :" + getItem().getName());
        System.out.println("Invoice Status :" + getInvoiceStatus());
        System.out.println("Invoice Type :" + getInvoiceType());
        System.out.println("Total harga :" + getTotalPrice());
    }*/
}
