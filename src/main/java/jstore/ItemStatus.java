/**
 * <h1>ItemStatus.java</h1>
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

public enum ItemStatus
{
    New("New"), Second("Second"), Refurbished("Refurbished"), Sold("Sold");

    String status;

    ItemStatus(String status){
        this.status = status;
    }
    
    public String toString(){
        return status;
    }
}