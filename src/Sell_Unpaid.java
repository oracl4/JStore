
/**
 * Write a description of class Buy_Paid here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.text.SimpleDateFormat;
import java.util.*;

public class Sell_Unpaid extends Invoice
{
    private static final InvoiceType INVOICE_TYPE = InvoiceType.Sell;
    private static final InvoiceStatus INVOICE_STATUS = InvoiceStatus.Unpaid;
    private Calendar dueDate;
    private Customer customer;
    private boolean isActive;

    /**
     * Constructor for objects of class Buy_Paid
     */
    public Sell_Unpaid (ArrayList<Integer> item, Customer customer)
    {
        super(item);
        this.customer = customer;
        isActive = true;
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
        System.out.println("========INVOICE SELL UNPAID========");
        setTotalPrice(0);
        System.out.println("========SELL UNPAID ITEMS LIST========");
        for (int temp1 : this.getItem())
        {
            System.out.println(DatabaseItem.getItemFromID(temp1).toString());
        }
        SimpleDateFormat sdf = new SimpleDateFormat("dd MMMMM yyyy");
        String tempStatus;

        if(isActive==true){
            tempStatus = "Invoice is Active";
        }
        else{
            tempStatus = "Invoice is Inactive";
        }

        return "\n========INVOICE========" +
                "\nInvoice ID: " +  getId() +
                "\nStatus: " + InvoiceStatus.Unpaid +
                "\nCustomer ID: " + customer.getId() +
                "\nCustomer Name: " + customer.getName() +
                "\nInvoice Status: " + tempStatus;
    }
}
