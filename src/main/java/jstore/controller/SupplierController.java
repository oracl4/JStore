package jstore.controller;

import jstore.*;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Calendar;

@RestController
public class SupplierController {

    @RequestMapping(value = "/suppliers", method = RequestMethod.GET)
    public ArrayList<Supplier> supplierList() {
        return DatabaseSupplier.getSupplierDatabase();
    }

    @RequestMapping(value = "/suppliers/{id_supplier}", method = RequestMethod.GET)
    public Supplier getSupllier(@PathVariable int id_supplier) {
        Supplier supplier = DatabaseSupplier.getSupplier(id_supplier);
        return supplier;
    }
}