/**
 * <h1>InvoiceStatus.java</h1>
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

public enum InvoiceStatus
{
    Paid("Paid"), Unpaid("Unpaid"), Installment("Installment");

    String status;
    
    InvoiceStatus(String status){
        this.status = status;
    }
    
    public String toString(){
        return status;
    }
}