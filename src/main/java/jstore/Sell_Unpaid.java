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

public class Sell_Unpaid extends Invoice
{
    private static final InvoiceType INVOICE_TYPE = InvoiceType.Sell;
    private static final InvoiceStatus INVOICE_STATUS = InvoiceStatus.Unpaid;
    private Customer customer;
    private Calendar dueDate;
    private boolean isActive;

    public Sell_Unpaid (ArrayList<Integer> item, Customer customer)
    {
        super(item);
        this.customer = customer;
        this.dueDate=(Calendar)getDate().clone();
        dueDate.add(Calendar.DATE, +14);
        isActive = true;
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
    
    public Calendar getDueDate()
    {
        return dueDate;
    }

    public void setCustomer(Customer customer)
    {
        this.customer=customer;
    }

    public void setDueDate(Calendar dueDate)
    {
        this.dueDate=dueDate;
    }
    
    public void setInvoiceStatus(InvoiceStatus status)
    {
    }

    public String toString()
    {
        System.out.println("= INVOICE SELL INSTALLMENT ===============");
        System.out.println("= SELL INSTALLMENT ITEMS LIST ============");
        for (int itemPtr : this.getItem())
        {
            System.out.println(DatabaseItem.getItemFromID(itemPtr).toString());
        }
        System.out.println("= END OF SELL INSTALLMENT ITEMS LIST =====");

        SimpleDateFormat sdf = new SimpleDateFormat("dd MMMM yyyy");

        String tempStatus;
        if(isActive){
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
                "\nInvoice Due Date   : " + sdf.format(getDueDate().getTime()) +
                "\nStatus             : " + InvoiceStatus.Unpaid +
                "\nInvoice Status     : " + tempStatus +
                "\nTotal Price        : " + getTotalPrice() +
                "\n= END OF INVOICE ==================";
    }
}
