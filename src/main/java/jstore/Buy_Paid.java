/**
 * <h1>Buy_Paid.java</h1>
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
//Library
package jstore;
import java.text.SimpleDateFormat;
import java.util.*;

public class Buy_Paid extends Invoice
{
    //Variable
    private static final InvoiceType INVOICE_TYPE = InvoiceType.Buy;
    private static final InvoiceStatus INVOICE_STATUS = InvoiceStatus.Paid;

    public Buy_Paid(ArrayList<Integer> item)
    {
        super(item);
        super.setIsActive(false);
        this.setTotalPrice();
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
        System.out.println("= INVOICE BUY PAID =======================");
        System.out.println("= BUY PAID ITEMS LIST ====================");
        for (int itemPtr : this.getItem())
        {
            System.out.println(DatabaseItem.getItemFromID(itemPtr).toString());
        }
        System.out.println("= END OF BUY PAID ITEMS LIST =============");

        SimpleDateFormat sdf = new SimpleDateFormat("dd MMMM yyyy");

        String tempStatus;
        if(super.getIsActive()){
            tempStatus = "Invoice is Active";
        }
        else{
            tempStatus = "Invoice is Inactive";
        }

        return  "= INVOICE ========================" +
                "\nInvoice ID      : " +  getId() +
                "\nInvoice Date    : " + sdf.format(getDate().getTime()) +
                "\nStatus          : " + InvoiceStatus.Unpaid +
                "\nInvoice Status  : " + tempStatus +
                "\nTotal Price     : " + getTotalPrice() +
                "\n= END OF INVOICE ==================";
    }
}
