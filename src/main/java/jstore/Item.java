/**
 * <h1>Item.java</h1>
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
import java.util.*;

public class Item
{
    private int id;
    private String name;
    private int price;
    private ItemCategory category;
    private ItemStatus status;
    private Supplier supplier;

    public Item(String name, int price, ItemCategory category, ItemStatus status, Supplier supplier)
    {
        id=DatabaseItem.getLastItemID()+1;
        this.name=name;
        this.price=price;
        this.category=category;
        this.status=status;
        this.supplier=supplier;
    }

    public int getId()
    {
        return id;
    }
    
    public String getName()
    {
        return name;
    }

    public int getPrice()
    {
        return price;
    }
    
    public ItemCategory getCategory()
    {
        return category;
    }

    public ItemStatus getStatus()
    {
        return status;
    }

    public Supplier getSupplier()
    {
        return supplier;
    }
    
    public void setId(int id)
    {
        this.id=id;
    }
    
    public void setName(String name)
    {
        this.name=name;
    }

    public void setPrice(int price)
    {
        this.price=price;
    }

    public void setCategory(ItemCategory category)
    {
        this.category=category;
    }

    public void setStatus(ItemStatus status)
    {
        this.status=status;
    }

    public void setSupplier(Supplier supplier)
    {
        this.supplier=supplier;
    }

    public String toString()
    {
        return "= Item ===================================" +
                "\nItem ID       : " +  getId() +
                "\nItem Name     : " + getName() +
                "\nItem Price    : " + getPrice() +
                "\nItem Category : " + getCategory() +
                "\nItem Status   : " + getStatus() +
                "\nSupplier      : " + getSupplier().getName() +
                "\n==========================================";
    }
}