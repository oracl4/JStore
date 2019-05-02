/**
 * <h1>JStore.java</h1>
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

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JStore{

    public static void main(String[] args)
    {
        Location lokasi1 = new Location("DKI Jakarta", "Red Zone", "Jakarta Selatan");

        try {
            //Create 3 Supplier
            DatabaseSupplier.addSupplier(new Supplier("Mahdi1", "it1.mahdi.yusuf@gmail.com", "081310275391", lokasi1));
        } catch (SupplierAlreadyExistsException e) {
            e.getExMessage();
        }

        try {
            DatabaseItem.addItem(new Item("Mikon 8051", 1501, ItemCategory.Electronics, ItemStatus.New, DatabaseSupplier.getSupplier(1)));
            DatabaseItem.addItem(new Item("Mikon 8052", 1502, ItemCategory.Electronics, ItemStatus.New, DatabaseSupplier.getSupplier(1)));
            DatabaseItem.addItem(new Item("Mikon 8053", 1503, ItemCategory.Electronics, ItemStatus.New, DatabaseSupplier.getSupplier(1)));
        } catch (ItemAlreadyExistsException e) {
            e.getExMessage();
        }

        try {
            DatabaseCustomer.addCustomer(new Customer("Mahdi","1","oracl4","4", 1998, 07, 05));
        } catch (CustomerAlreadyExistsException e) {
            e.getExMessage();
        }
        /*
        ArrayList<Integer> arrayListItem = new ArrayList<Integer>();

        arrayListItem.add(1);
        arrayListItem.add(2);

        try {
            DatabaseInvoice.addInvoice(new Sell_Installment(arrayListItem, 13, DatabaseCustomer.getCustomer(1)));
        } catch (InvoiceAlreadyExistsException e) {
            e.getExMessage();
        }

        try {
            for (Invoice invoicePtr : DatabaseInvoice.getActiveOrder(DatabaseCustomer.getCustomer(1)))
            {
                System.out.println(invoicePtr);
            }
        } catch (CustomerDoesntHaveActiveException e) {
            e.getExMessage();
        }

        System.out.println(DatabaseInvoice.getInvoice(1));*/

        SpringApplication.run(JStore.class, args);
    }

    public JStore()
    {
    }
}