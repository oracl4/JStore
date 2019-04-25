/**
 * <h1>Invoice.java</h1>
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

public abstract class Invoice
{
    private int id;
    private Calendar date;
    private boolean isActive;
    private Customer customer;
    private ArrayList<Integer> item = new ArrayList<Integer>();

    //Testing
    public int totalPrice;

    public Invoice(ArrayList<Integer> item)
    {
        this.item=item;
        this.id=DatabaseInvoice.getLastInvoiceID()+1;
        this.date=Calendar.getInstance();
    }
    
    public int getId()
    {
        return id;
    }
    
    public ArrayList<Integer> getItem()
    {
        return item;
    }
    
    public Calendar getDate()
    {
        return date;
    }
    
    public int getTotalPrice()
    {
        return totalPrice;
    }

    public boolean getIsActive()
    {
        return isActive;
    }
    
    public Customer getCustomer()
    {
        return customer;
    }
    
    public abstract InvoiceStatus getInvoiceStatus();

    public abstract InvoiceType getInvoiceType();

    public void setId(int id)
    {
        this.id=id;
    }

    public void setItem(ArrayList<Integer> item)
    {
        this.item=item;
    }
    
    public void setDate(Calendar date)
    {
        this.date=date;
    }

    public void setTotalPrice()
    {
        //Set Total Price
        int tempTotalHarga=0;
        for (int itemPtr : this.getItem())
        {
            tempTotalHarga=tempTotalHarga+DatabaseItem.getItemFromID(itemPtr).getPrice();
        }
        this.totalPrice=tempTotalHarga;
    }

    public void setIsActive(boolean isActive)
    {
        this.isActive=isActive;
    }

    public abstract void setInvoiceStatus(InvoiceStatus status);

    public abstract String toString();
}