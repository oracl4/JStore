
/**
 * Write a description of class Buy_Paid here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Sell_Installment extends Invoice
{
    private static final InvoiceType INVOICE_TYPE = InvoiceType.Sell;
    private static final InvoiceStatus INVOICE_STATUS = InvoiceStatus.Installment;
    private int installmentPeriod;
    private int installmentPrice;

    /**
     * Constructor for objects of class Buy_Paid
     */
    public Sell_Installment (int id, Item item, String date, int totalItem, int totalPrice, int installmentPeriod)
    {
        super(id, item, date, totalItem, totalPrice);
        this.installmentPeriod=installmentPeriod;
        setInstallmentPrice(totalPrice);
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public int getInstallmentPeriod()
    {
        return installmentPeriod;
    }
    
    public int getInstallmentPrice()
    {
        return installmentPrice;
    }
    
    public InvoiceStatus getInvoiceStatus()
    {
        return INVOICE_STATUS;
    }
    
    public InvoiceType getInvoiceType(){
        return INVOICE_TYPE;
    }

    public void setInstallmentPrice(int totalPrice){
        installmentPrice=(totalPrice/installmentPeriod)*(102/100);
    }

    public void setTotalPrice(){
        totalPrice=installmentPrice*installmentPeriod;
    }

    public void printData(){
        System.out.println("==========INVOICE=======");
        System.out.println("ID :" + getId());
        System.out.println("Date :" + getDate());
        System.out.println("Item :" + getItem().getName());
        System.out.println("Invoice Status :" + getInvoiceStatus());
        System.out.println("Invoice Type :" + getInvoiceType());
        System.out.println("Total harga :" + getTotalPrice());
        System.out.println("Installation Price :" + getInstallmentPrice());
    }
}
