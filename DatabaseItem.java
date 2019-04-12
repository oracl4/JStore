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
    
    public static boolean addItem(Item item){
        boolean value = false;
        for(Item itemPtr : ITEM_DATABASE)
        {
            if(item.getName() != itemPtr.getName() && item.getStatus() != itemPtr.getStatus() && item.getSupplier() != itemPtr.getSupplier())
            {
            ITEM_DATABASE.add(item); 
            value=true;
            }
        }
        return value;
    }
    
    public static Item getItemFromID(int id)
    {
        Item value = null;
        for(Item itemPtr : ITEM_DATABASE)
        {
            if(itemPtr.getId() == id)
            {
                value = itemPtr;
            }
        }
        return value;
    }

    public static ArrayList<Item> getItemFromSupplier(Supplier supplier)
    {
        ArrayList<Item> value = null;
        for(Item itemPtr : ITEM_DATABASE)
        {
            if(itemPtr.getSupplier() == supplier)
            {
                value.add(itemPtr);
            }
        }
        return value;
    }

    public static ArrayList<Item> getItemFromCategory(Item category)
    {
        ArrayList<Item> value = null;
        for(Item itemPtr : ITEM_DATABASE)
        {
            if(itemPtr.getCategory() == category.getCategory())
            {
                value.add(itemPtr);
            }
        }
        return value;
    }
    
    public static ArrayList<Item> getItemFromStatus(Item status)
    {
        ArrayList<Item> value = null;
        for(Item itemPtr : ITEM_DATABASE)
        {
            if(itemPtr.getStatus() == status.getStatus())
            {
                value.add(itemPtr);
            }
        }
        return value;
    }

    public static boolean removeItem(int id)
    {
        boolean value = false;
        for(Item itemPtr : ITEM_DATABASE)
        {      
            if(itemPtr.getId() == id)
            {
                ITEM_DATABASE.remove(id);
                value = true;
            }  
        }
        return value;
    }
}