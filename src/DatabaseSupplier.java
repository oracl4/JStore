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
    
    public static boolean addSupplier(Supplier supplier) throws SupplierAlreadyExistsException
    {

        for(Supplier supplierDB : SUPPLIER_DATABASE)
        {
            if(supplier.getEmail().equals(supplierDB.getEmail()) ||
                    supplier.getPhoneNumber().equals(supplierDB.getPhoneNumber()))
            {
                throw new SupplierAlreadyExistsException(supplier);
            }
        }
        SUPPLIER_DATABASE.add(supplier);
        LAST_SUPPLIER_ID = supplier.getId();
        return true;
    }
    
    public static Supplier getSupplier(int id)
    {
        for (Supplier supplier : SUPPLIER_DATABASE){
            if (supplier.getId() == id)
            {
                return supplier;
            }
        }
        return null;
    }

    public static boolean removeSupplier(int id) throws SupplierNotFoundException
    {
        try {
            for (Supplier supplierPtr : SUPPLIER_DATABASE) {
                if (supplierPtr.getId() == id) {
                    DatabaseItem.getItemDatabase().removeAll(DatabaseItem.getItemFromSupplier(supplierPtr));
                    SUPPLIER_DATABASE.remove(supplierPtr);
                    return true;
                }
            }
            throw new SupplierNotFoundException(id);
        }
        catch (SupplierNotFoundException e){
            System.out.println(e.getExMessage());
            return false;
        }
    }
}