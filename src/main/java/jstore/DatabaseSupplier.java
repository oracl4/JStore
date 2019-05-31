/**
 * <h1>DatabaseSupplier.java</h1>
 * <p>
 * Static Java Supplier Database
 * </p>
 *
 * @author Mahdi Yusuf
 * @version 13.0
 * @since 2019/31/05
 */
package jstore;

import java.util.*;

/**
 * The type Database supplier.
 */
public class DatabaseSupplier {
    private static ArrayList<Supplier> SUPPLIER_DATABASE = new ArrayList<Supplier>();
    private static int LAST_SUPPLIER_ID = 0;

    /**
     * Instantiates a new Database supplier.
     */
    public DatabaseSupplier() {
    }

    /**
     * Gets supplier database.
     *
     * @return the supplier database
     */
    public static ArrayList<Supplier> getSupplierDatabase() {
        return SUPPLIER_DATABASE;
    }

    /**
     * Gets last supplier id.
     *
     * @return the last supplier id
     */
    public static int getLastSupplierID() {
        return LAST_SUPPLIER_ID;
    }

    /**
     * Add supplier boolean.
     *
     * @param supplier the supplier
     * @return the boolean
     * @throws SupplierAlreadyExistsException the supplier already exists exception
     */
    public static boolean addSupplier(Supplier supplier) throws SupplierAlreadyExistsException {

        for (Supplier supplierDB : SUPPLIER_DATABASE) {
            if (supplier.getEmail().equals(supplierDB.getEmail()) ||
                    supplier.getPhoneNumber().equals(supplierDB.getPhoneNumber())) {
                throw new SupplierAlreadyExistsException(supplier);
            }
        }
        SUPPLIER_DATABASE.add(supplier);
        LAST_SUPPLIER_ID = supplier.getId();
        return true;
    }

    /**
     * Gets supplier.
     *
     * @param id the id
     * @return the supplier
     */
    public static Supplier getSupplier(int id) {
        for (Supplier supplier : SUPPLIER_DATABASE) {
            if (supplier.getId() == id) {
                return supplier;
            }
        }
        return null;
    }

    /**
     * Remove supplier boolean.
     *
     * @param id the id
     * @return the boolean
     * @throws SupplierNotFoundException the supplier not found exception
     */
    public static boolean removeSupplier(int id) throws SupplierNotFoundException {
        try {
            for (Supplier supplierPtr : SUPPLIER_DATABASE) {
                if (supplierPtr.getId() == id) {
                    DatabaseItem.getItemDatabase().removeAll(DatabaseItem.getItemFromSupplier(supplierPtr));
                    SUPPLIER_DATABASE.remove(supplierPtr);
                    return true;
                }
            }
            throw new SupplierNotFoundException(id);
        } catch (SupplierNotFoundException e) {
            System.out.println(e.getExMessage());
            return false;
        }
    }
}