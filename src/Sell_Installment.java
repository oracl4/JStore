
/**
 * Write a description of class Buy_Paid here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.text.SimpleDateFormat;
import java.util.*;

public class Sell_Installment extends Invoice
{
    private static final InvoiceType INVOICE_TYPE = InvoiceType.Sell;
    private static final InvoiceStatus INVOICE_STATUS = InvoiceStatus.Installment;
    private int installmentPeriod;
    private int installmentPrice;
    private Customer customer;
    private boolean isActive;

    public Sell_Installment (ArrayList<Integer> item, int InstallmentPeriod, Customer customer)
    {
        super(item);
        this.installmentPeriod = installmentPeriod;
        this.customer = customer;
        isActive = true;
    }

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
    
    public InvoiceType getInvoiceType()
    {
        return INVOICE_TYPE;
    }

    public void setInstallmentPrice(int totalPrice)
    {
        installmentPrice=(totalPrice/installmentPeriod)*(102/100);
    }

    public void setTotalPrice()
    {
        setTotalPrice(installmentPrice*installmentPeriod);
    }

    public void setCustomer(Customer customer)
    {
        this.customer=customer;
    }
    
    public void setInvoiceStatus(InvoiceStatus status)
    {
    }

    public String toString()
    {
        System.out.println("========INVOICE SELL INSTALLMENT========");
        setTotalPrice(0);
        System.out.println("========SELL INSTALLMENT ITEMS LIST========");
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
