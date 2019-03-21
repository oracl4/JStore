/**
 * Enumeration class ItemStatus - write a description of the enum class here
 *
 * @author (your name here)
 * @version (version number or date here)
 */
public enum InvoiceStatus{
    Paid("Paid"), Unpaid("Unpaid"), Installment("Installment");

    String status;
    
    InvoiceStatus(String status){
        this.status = status;
    }
    
    public String toString(){
        return status;
    }
}