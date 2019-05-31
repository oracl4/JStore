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

import java.util.ArrayList;

@SpringBootApplication
public class JStore{

    public static void main(String[] args)
    {
        Location lokasi1 = new Location("DKI Jakarta", "Red Zone", "Jakarta Selatan");
        Location lokasi2 = new Location("DKI Jakarta", "Blue Zone", "Jakarta Selatan");
        Location lokasi3 = new Location("DKI Jakarta", "Yellow Zone", "Jakarta Selatan");
        try {
            //Create 1 Supplier
            DatabaseSupplier.addSupplier(new Supplier("Supplier Rena", "it1.mahdi.yusuf@gmail.com", "081310275391", lokasi1));
            DatabaseSupplier.addSupplier(new Supplier("Supplier Kane", "it2.mahdi.yusuf@gmail.com", "081310275392", lokasi2));
            DatabaseSupplier.addSupplier(new Supplier("Supplier Shio", "it3.mahdi.yusuf@gmail.com", "081310275393", lokasi3));
        } catch (SupplierAlreadyExistsException e) {
            System.out.println(e.getExMessage());
        }

        try {
            //Create 3 Item
            DatabaseItem.addItem(new Item("Mikon 8051", 1501, ItemCategory.Electronics, ItemStatus.New, DatabaseSupplier.getSupplier(1)));
            DatabaseItem.addItem(new Item("Mikon 8052", 1502, ItemCategory.Electronics, ItemStatus.New, DatabaseSupplier.getSupplier(1)));
            DatabaseItem.addItem(new Item("Mikon 8053", 1503, ItemCategory.Electronics, ItemStatus.New, DatabaseSupplier.getSupplier(2)));
            DatabaseItem.addItem(new Item("Mikon 8054", 1504, ItemCategory.Electronics, ItemStatus.New, DatabaseSupplier.getSupplier(2)));
            DatabaseItem.addItem(new Item("Mikon 8055", 1505, ItemCategory.Electronics, ItemStatus.New, DatabaseSupplier.getSupplier(3)));
            DatabaseItem.addItem(new Item("Mikon 8056", 1506, ItemCategory.Electronics, ItemStatus.New, DatabaseSupplier.getSupplier(3)));
        } catch (ItemAlreadyExistsException e) {
            System.out.println(e.getExMessage());
        }

//        DatabaseCustomerPostgre.insertCustomer("Mahdi","js.mahdi@gmail.com","oracl4","4ltius", 1998, 07, 05);

//        ArrayList<Integer> itemTemp1 = new ArrayList<>();
//        itemTemp1.add(1);
//        ArrayList<Integer> itemTemp2 = new ArrayList<>();
//        itemTemp2.add(2);
//        ArrayList<Integer> itemTemp3 = new ArrayList<>();
//        itemTemp3.add(3);
//        ArrayList<Integer> itemTemp4 = new ArrayList<>();
//        itemTemp4.add(4);
//
//        Transaction.sellItemUnpaid(itemTemp1, DatabaseCustomerPostgre.getCustomer(1));
//        Transaction.sellItemUnpaid(itemTemp2, DatabaseCustomerPostgre.getCustomer(1));
//        Transaction.sellItemUnpaid(itemTemp3, DatabaseCustomerPostgre.getCustomer(1));
//        Transaction.sellItemUnpaid(itemTemp4, DatabaseCustomerPostgre.getCustomer(1));

//        try {
//            DatabaseCustomer.addCustomer(new Customer("Mahdi","1","oracl4","2", 1998, 07, 05));
//        } catch (CustomerAlreadyExistsException e) {
//            System.out.println(e.getExMessage());
//        }
        SpringApplication.run(JStore.class, args);
    }

    public JStore()
    {
    }
}