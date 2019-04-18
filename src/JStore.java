/*******************************************************************************
 * Copyright (c) 2019 Mahdi Yusuf. All rights reserved.
 *
 * Licensed under the GNU General Public License, Version 3 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   https://www.gnu.org/licenses/gpl-3.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 ******************************************************************************/

/**
* <h1>JStore.java</h1>
* <p>
* Class ini merupakan main class dari JStore Application
* </p>
* 
* 
* @author   Mahdi Yusuf
* @version  1.0
* @since    2019/03/04
*/
import java.util.*;

public class JStore{
    
    /**
    * Method main merupakan main method dari JStore Application
    * @param args Unused
    * @return sNothing
    */    
    public static void main(String[] args) {
        //Location
        Location lokasi1 = new Location("DKI Jakarta", "Red Zone", "Jakarta Selatan");

        try {
            DatabaseSupplier.addSupplier(new Supplier("Mahdi", "it.mahdi.yusuf@gmail.com", "081310275390", lokasi1));
            DatabaseSupplier.addSupplier(new Supplier("Mahdi", "it.mahdi.yusuf@gmail.com", "081310275390", lokasi1));
        } catch (SupplierAlreadyExistsException e) {
            System.out.println(e.getExMessage());
        }

        //Customer
        try {
            DatabaseCustomer.addCustomer(new Customer("Customer Mahdi", "custom1@gmail.com", "Oracl4", "4ltius1", 2019, 4, 18));
            DatabaseCustomer.addCustomer(new Customer("Customer Mahdi", "custom1@gmail.com", "Oracl4", "4ltius1", 2019, 4, 18));
        } catch (CustomerAlreadyExistsException e) {
            System.out.println(e.getExMessage());
        }

        //Item
        try {
            DatabaseItem.addItem(new Item("Mikon 8051", 1, ItemCategory.Electronics, ItemStatus.New, DatabaseSupplier.getSupplier(1)));
            DatabaseItem.addItem(new Item("Mikon 8051", 1, ItemCategory.Electronics, ItemStatus.New, DatabaseSupplier.getSupplier(1)));
        } catch (ItemAlreadyExistsException e) {
            System.out.println(e.getExMessage());
        }


        ArrayList<Integer> itemArray = new ArrayList<>();
        itemArray.add(1);
        itemArray.add(2);
        itemArray.add(3);

        try {
            DatabaseInvoice.addInvoice(new Sell_Installment(itemArray, 13, DatabaseCustomer.getCustomer(1)));
            DatabaseInvoice.addInvoice(new Sell_Installment(itemArray, 13, DatabaseCustomer.getCustomer(1)));
        } catch (InvoiceAlreadyExistsException e) {
            System.out.println(e.getExMessage());
        }

        try {
            DatabaseCustomer.removeCustomer(13);
        } catch (CustomerNotFoundException e) {
            System.out.println(e.getExMessage());
        }

        try {
            DatabaseInvoice.removeInvoice(13);
        } catch (InvoiceNotFoundException e) {
            System.out.println(e.getExMessage());
        }

        try {
            DatabaseItem.removeItem(13);
        } catch (ItemNotFoundException e) {
            System.out.println(e.getExMessage());
        }

        try {
            DatabaseSupplier.removeSupplier(13);
        } catch (SupplierNotFoundException e) {
            System.out.println(e.getExMessage());
        }

        try {
            DatabaseInvoice.addInvoice(new Buy_Paid(itemArray));
            System.out.println(DatabaseInvoice.getInvoice(2));
        } catch (InvoiceAlreadyExistsException e) {
            System.out.println(e.getExMessage());
        }

        try {
            DatabaseInvoice.getActiveOrder(DatabaseCustomer.getCustomer(2));
        } catch (CustomerDoesntHaveActiveException e) {
            System.out.println(e.getExMessage());
        }
    }
    /**
    * Method JStore merupakan Constructor dari JStore Class
    * Method ini dapat berisi nilai default dari variabel dalam JStore Class
    */
    public JStore(){
    }
}