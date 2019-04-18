import java.text.SimpleDateFormat;
import java.util.*;

public class Buy_Paid extends Invoice
{
   private static final InvoiceType INVOICE_TYPE = InvoiceType.Buy;
   private static final InvoiceStatus INVOICE_STATUS = InvoiceStatus.Paid;
   private boolean isActive;
   
    /**
     * Constructor for objects of class Buy_Paid
     */
    public Buy_Paid(ArrayList<Integer> item)
    {
        super(item);
        this.isActive=false;
    }

    public InvoiceStatus getInvoiceStatus()
    {
        return INVOICE_STATUS;
    }
    
    public InvoiceType getInvoiceType(){
        return INVOICE_TYPE;
    }
    
    public void setInvoiceStatus(InvoiceStatus status)
    {
    }
    
    public String toString()
    {
        System.out.println("========INVOICE BUY PAID========");
        setTotalPrice(0);
        System.out.println("========BUY PAID ITEMS LIST========");
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
                "\nInvoice Status: " + tempStatus;
    }
}
