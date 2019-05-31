/**
 * <h1>SupplierController.java</h1>
 * <p>
 * Supplier controller for Springboot Framework
 * </p>
 *
 * @author Mahdi Yusuf
 * @version 13.0
 * @since 2019/31/05
 */
package jstore.controller;

import jstore.*;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class SupplierController {

    /**
     * Get all suppliers request
     *
     * @return the array list of suppliers
     */
    @RequestMapping(value = "/suppliers", method = RequestMethod.GET)
    public ArrayList<Supplier> supplierList() {
        return DatabaseSupplier.getSupplierDatabase();
    }

    /**
     * Get supplier by id request
     *
     * @param id_supplier the supplier id
     * @return the supplier from id
     */
    @RequestMapping(value = "/suppliers/{id_supplier}", method = RequestMethod.GET)
    public Supplier getSupllier(@PathVariable int id_supplier) {
        Supplier supplier = DatabaseSupplier.getSupplier(id_supplier);
        return supplier;
    }
}