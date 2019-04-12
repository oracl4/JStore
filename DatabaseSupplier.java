import java.util.*;

public class DatabaseSupplier
{
    private static ArrayList<Supplier> SUPPLIER_DATABASE = new ArrayList<Supplier>();
    private static int LAST_SUPPLIER_ID = 0;
   
    public DatabaseSupplier()
    {
    }
    
    public static ArrayList<Supplier> getSupplierDatabase()
    {
        return SUPPLIER_DATABASE;
    }
    
    public static int getLastSupplierID()
    {
        return LAST_SUPPLIER_ID;
    }
    
    public static boolean addSupplier(Supplier supplier)
    {
        boolean value = false;
        for(Supplier supplierPtr : SUPPLIER_DATABASE)
        {
            if(supplier.getName() != supplierPtr.getName() && supplier.getEmail() != supplierPtr.getEmail() && supplier.getPhoneNumber() != supplierPtr.getPhoneNumber())
            {
                SUPPLIER_DATABASE.add(supplier);
                LAST_SUPPLIER_ID = supplier.getId();
                value = true;
            }
        }
        return value;
    }
    
    public static Supplier getSupplier(int id)
    {
        Supplier value = null;
        for(Supplier supplierPtr : SUPPLIER_DATABASE)
        {
            if(supplierPtr.getId() == id)
            {
                value = supplierPtr;
            }
        }
        return value;
    }

    public static boolean removeSupplier(int id)
    {
        boolean value = false;
        for(Supplier supplierPtr : SUPPLIER_DATABASE)
        {
            if(supplierPtr.getId() == id)
            {
                DatabaseItem.getItemDatabase().removeAll(DatabaseItem.getItemFromSupplier(supplierPtr));
                SUPPLIER_DATABASE.remove(id);
                value = true;
            }
        }
        return value;
    }
}