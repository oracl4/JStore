import java.util.*;

public class DatabaseInvoice
{
    private static ArrayList<Invoice> INVOICE_DATABASE = new ArrayList<Invoice>();
    private static int LAST_INVOICE_ID = 0;
    
    public static ArrayList<Invoice> getInvoiceDatabase()
    {
        return INVOICE_DATABASE;

    }

    public static int getLastInvoiceID()
    {
        return LAST_INVOICE_ID;
    }

    public static boolean addInvoice(Invoice invoice)
    {
        INVOICE_DATABASE.add(invoice);
        LAST_INVOICE_ID = invoice.getId();
        return true;
    }
    
    public static Invoice getInvoice(int id)
    {
        Invoice value = null;
        for(Invoice invoicePtr : INVOICE_DATABASE)
        {
            if(invoicePtr.getId() == id)
            {
                value = invoicePtr;
            }
        }
        return value;
    }

    public static Invoice getActiveOrder(Customer customer)
    {
        Invoice value = null;
        for(Invoice invoicePtr : INVOICE_DATABASE)
        {
            if((invoicePtr.getInvoiceStatus() == InvoiceStatus.Installment || invoicePtr.getInvoiceStatus() == InvoiceStatus.Paid) && invoicePtr.getIsActive() == true)
            {
                value = invoicePtr;
            }  
        }
        return value;
    }
  
    public static boolean removeInvoice(int id)
    {
        boolean value = false;
        for(Invoice invoicePtr : INVOICE_DATABASE)
        {
            if(invoicePtr.getId() == id && invoicePtr.getIsActive() == true)
            {
                invoicePtr.setIsActive(false);
                INVOICE_DATABASE.remove(id);
                value = true;
            }
        }
        return value;
    }
}