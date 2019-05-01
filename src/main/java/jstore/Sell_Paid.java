/**
 * <h1>Sell_Paid.java</h1>
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
import java.text.SimpleDateFormat;
import java.util.*;

public class Sell_Paid extends Invoice
{
   private static final InvoiceType INVOICE_TYPE = InvoiceType.Sell;
   private static final InvoiceStatus INVOICE_STATUS = InvoiceStatus.Paid;
   private Customer customer;

   public Sell_Paid (ArrayList<Integer> item, Customer customer)
   {
       super(item);
       this.setTotalPrice();
       this.customer=customer;
       super.setIsActive(false);
       this.setTotalPrice();
   }

    public InvoiceStatus getInvoiceStatus()
    {
        return INVOICE_STATUS;
    }
    
    public InvoiceType getInvoiceType()
    {
        return INVOICE_TYPE;
    }

    public Customer getCustomer()
    {
        return customer;
    }

    public void setCustomer(Customer customer)
    {
        this.customer = customer;
    }
    
    public void setInvoiceStatus(InvoiceStatus status)
    {
    }

    public String toString()
    {
        int tempTotalHarga=0;
        System.out.println("= INVOICE SELL INSTALLMENT ===============");
        System.out.println("= SELL INSTALLMENT ITEMS LIST ============");
        for (int itemPtr : this.getItem())
        {
            tempTotalHarga=tempTotalHarga+DatabaseItem.getItemFromID(itemPtr).getPrice();
            System.out.println(DatabaseItem.getItemFromID(itemPtr).toString());
        }
        System.out.println("= END OF SELL INSTALLMENT ITEMS LIST =====");

        SimpleDateFormat sdf = new SimpleDateFormat("dd MMMM yyyy");

        String tempStatus;
        if(super.getIsActive()){
            tempStatus = "Invoice is Active";
        }
        else{
            tempStatus = "Invoice is Inactive";
        }

        return  "= INVOICE ========================" +
                "\nInvoice ID         : " +  getId() +
                "\nCustomer ID        : " + getCustomer().getID() +
                "\nCustomer Name      : " + getCustomer().getName() +
                "\nInvoice Date       : " + sdf.format(getDate().getTime()) +
                "\nStatus             : " + InvoiceStatus.Paid +
                "\nInvoice Status     : " + tempStatus +
                "\nTotal Price        : " + getTotalPrice() +
                "\n= END OF INVOICE ==================";
    }
}