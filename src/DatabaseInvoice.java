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

    public static boolean addInvoice(Invoice invoice) throws InvoiceAlreadyExistsException
    {
        for (Invoice invoicePtr : INVOICE_DATABASE ) {
            if(invoicePtr.getItem().equals(invoice.getItem())){
                throw new InvoiceAlreadyExistsException(invoice);
            }
        }
        INVOICE_DATABASE.add(invoice);
        LAST_INVOICE_ID = invoice.getId();
        return true;
    }
    
    public static Invoice getInvoice(int id)
    {
        for (Invoice invoice : INVOICE_DATABASE){
            if (invoice.getId() == id)
            {
                return invoice;
            }
        }
        return null;
    }

    public static ArrayList<Invoice> getActiveOrder(Customer customer) throws CustomerDoesntHaveActiveException
    {
        ArrayList<Invoice> tempInvoiceList = new ArrayList<Invoice>();
        for (Invoice invoicePtr : INVOICE_DATABASE) {
            if (invoicePtr.getIsActive() == true) {
                tempInvoiceList.add(invoicePtr);
            }
        }
        if (tempInvoiceList != null) {
            return tempInvoiceList;
        }
        throw new CustomerDoesntHaveActiveException(customer);
    }

    public static boolean removeInvoice(int id) throws InvoiceNotFoundException
    {
        for(Invoice invoice : INVOICE_DATABASE){
            if(invoice.getId() == id){
                if (invoice.getIsActive() == true) {
                    invoice.setIsActive(false);
                }
                INVOICE_DATABASE.remove(invoice);
                return true;
            }
        }
        throw new InvoiceNotFoundException(id);
    }
}