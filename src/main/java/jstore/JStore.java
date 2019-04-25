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
import java.util.*;

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
            DatabaseSupplier.addSupplier(new Supplier("Mahdi2", "it2.mahdi.yusuf@gmail.com", "081310275392", lokasi1));
            DatabaseSupplier.addSupplier(new Supplier("Mahdi3", "it3.mahdi.yusuf@gmail.com", "081310275393", lokasi1));
        } catch (SupplierAlreadyExistsException e) {
            e.getExMessage();
        }

        try {
            DatabaseItem.addItem(new Item("Mikon 8051", 1501, ItemCategory.Electronics, ItemStatus.New, DatabaseSupplier.getSupplier(1)));
            DatabaseItem.addItem(new Item("Mikon 8052", 1502, ItemCategory.Electronics, ItemStatus.New, DatabaseSupplier.getSupplier(2)));
            DatabaseItem.addItem(new Item("Mikon 8053", 1503, ItemCategory.Electronics, ItemStatus.New, DatabaseSupplier.getSupplier(3)));
            DatabaseItem.addItem(new Item("Mikon 8054", 1504, ItemCategory.Electronics, ItemStatus.New, DatabaseSupplier.getSupplier(1)));
        } catch (ItemAlreadyExistsException e) {
            e.getExMessage();
        }

        SpringApplication.run(JStore.class, args);
    }

    public JStore()
    {
    }
}