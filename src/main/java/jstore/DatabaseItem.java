/**
 * <h1>DatabaseItem.java</h1>
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

public class DatabaseItem
{
    private static ArrayList<Item> ITEM_DATABASE = new ArrayList<Item>();
    private static int LAST_ITEM_ID = 0;

    /**
    * Method DatabaseItem merupakan Constructor dari DatabaseItem Class
    * Method ini dapat berisi nilai default dari variabel dalam DatabaseItem Class
    */
    public DatabaseItem(){
    }
    
    public static ArrayList<Item> getItemDatabase(){
        return ITEM_DATABASE;
    }
    
    public static int getLastItemID(){
        return LAST_ITEM_ID;
    }
    
    public static boolean addItem(Item item) throws ItemAlreadyExistsException
    {
        for (Item itemDB1 : ITEM_DATABASE )
        {
            if((itemDB1.getName().equals(item.getName()))
                    && (itemDB1.getStatus().equals(item.getStatus()))
                    && (itemDB1.getCategory().equals(item.getCategory()))
                    && (itemDB1.getSupplier().equals(item.getSupplier())))
            {
                throw new ItemAlreadyExistsException(item);
            }
        }
        ITEM_DATABASE.add(item);
        LAST_ITEM_ID = item.getId();
        return true;
    }
    
    public static Item getItemFromID(int id)
    {
        for (Item itemDB2 : ITEM_DATABASE)
        {
            if (itemDB2.getId() == id)
            {
                return itemDB2;
            }
        }
        return null;
    }

    public static ArrayList<Item> getItemFromSupplier(Supplier supplier)
    {
        ArrayList<Item> itemDB3 = new ArrayList<Item>();
        for (Item item : ITEM_DATABASE){
            if (item.getSupplier() == supplier )
            {
                itemDB3.add(item);
            }
        }
        return itemDB3;
    }

    public static ArrayList<Item> getItemFromCategory(ItemCategory category)
    {
        ArrayList<Item> itemDB4 = new ArrayList<Item>();
        for (Item item : ITEM_DATABASE)
        {
            if (item.getCategory() == category )
            {
                itemDB4.add(item);
            }
        }
        return itemDB4;
    }
    
    public static ArrayList<Item> getItemFromStatus(ItemStatus status)
    {
        ArrayList<Item> bar = new ArrayList<Item>();
        for (Item item : ITEM_DATABASE)
        {
            if (item.getStatus() == status )
            {
                bar.add(item);
            }
        }
        return bar;
    }

    public static boolean removeItem(int id) throws ItemNotFoundException
    {
        for(Item item : ITEM_DATABASE)
        {
            if(item.getId() == id)
            {
                ITEM_DATABASE.remove(item);
                return true;
            }
        }
        throw new ItemNotFoundException(id);
    }
}