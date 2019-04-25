/**
 * <h1>Sell_Installment.java</h1>
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

public class Sell_Installment extends Invoice
{
    private static final InvoiceType INVOICE_TYPE = InvoiceType.Sell;
    private static final InvoiceStatus INVOICE_STATUS = InvoiceStatus.Installment;
    private Customer customer;
    private int installmentPeriod;
    private int installmentPrice;
    private boolean isActive;

    public Sell_Installment (ArrayList<Integer> item, int installmentPeriod, Customer customer)
    {
        super(item);
        this.installmentPeriod = installmentPeriod;
        this.customer = customer;
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

    public Customer getCustomer(){
        return customer;
    }

    public int getInstallmentPeriod()
    {
        return installmentPeriod;
    }
    
    public int getInstallmentPrice()
    {
        return installmentPrice;
    }

    @Override
    public void setTotalPrice()
    {
        //Set Total Price
        int tempTotalHarga=0;
        for (int itemPtr : this.getItem())
        {
            tempTotalHarga=tempTotalHarga+DatabaseItem.getItemFromID(itemPtr).getPrice();
        }

        double tempInstallmentPrice = (tempTotalHarga/installmentPeriod)*1.02;
        installmentPrice = (int) tempInstallmentPrice;
        super.totalPrice=installmentPrice*installmentPeriod;
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
                "\nStatus             : " + InvoiceStatus.Installment +
                "\nInvoice Status     : " + tempStatus +
                "\nInstallment Period : " + getInstallmentPeriod() +
                "\nTotal Price        : " + getTotalPrice() +
                "\n= END OF INVOICE ==================";
    }
}
