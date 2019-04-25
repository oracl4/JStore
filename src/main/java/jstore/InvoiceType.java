/**
 * <h1>InvoiceType.java</h1>
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

public enum InvoiceType
{
    Buy("Buy"), Sell("Sell");

    String type;
    
    InvoiceType(String type){
    	this.type = type;
    }
    
    public String toString(){
    	return type;
    }
}