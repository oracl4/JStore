/**
 * Enumeration class ItemStatus - write a description of the enum class here
 *
 * @author (your name here)
 * @version (version number or date here)
 */
public enum ItemStatus{
    New("New"),
    Second("Second"),
    Refurbished("Refurbished"),
    Sold("Sold");

    String status;
    
    private ItemStatus(String status){
        this.status = status;
    }
    
    public String toString(){
        return status;
    }
}