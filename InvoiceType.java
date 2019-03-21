/**
 * Enumeration class ItemStatus - write a description of the enum class here
 *
 * @author (your name here)
 * @version (version number or date here)
 */
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