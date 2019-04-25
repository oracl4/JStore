/**
 * <h1>ItemCategory.java</h1>
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

public enum ItemCategory
{
    Electronics("Electronics"), Furniture("Furniture"), Stationary("Stationary");

    String category;
    
    ItemCategory(String category){
        this.category = category;
    }
    
    public String toString(){
        return category;
    }
}