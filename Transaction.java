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
* <h1>Transaction.java</h1>
* <p>
* XClass ini merupakan bagian invoice dari JStore Application
* XClass ini representasi dari sebuah invoice yang terdapat pada JStore Application
* </p>
* 
* 
* @author   Mahdi Yusuf
* @version  1.0
* @since    2019/03/14
*/
public class Transaction{
    
    public static void orderNewItem(Supplier supplier){
        ItemCategory category = ItemCategory.Electronics;
        ItemStatus statusItem1 = ItemStatus.New;
        Item item1 = new Item(1, "Notebook", statusItem1, 13, 10000000, category, supplier);

        DatabaseItem.addItem(item1);
        
        InvoiceStatus statusInvoice1 = InvoiceStatus.Paid;
        Invoice pesan1 = new Invoice(1, item1, "14 Maret 2019", item1.getPrice(), statusInvoice1);
        
        item1.setStatus(statusItem1);
        pesan1.setInvoiceStatus(statusInvoice1);

        System.out.println("=ORDER NEW ITEM=");
        item1.printData();
        pesan1.printData();
    }

    public static void orderSecondItem(Supplier supplier){
        ItemCategory category = ItemCategory.Furniture;
        ItemStatus statusItem2 = ItemStatus.Second;
        Item item2 = new Item(2, "Kursi", statusItem2, 23, 50000, category, supplier);
    
        DatabaseItem.addItem(item2);
        
        InvoiceStatus statusInvoice2 = InvoiceStatus.Paid;
        Invoice pesan2 = new Invoice(2, item2, "14 Maret 2019", item2.getPrice(), statusInvoice2);
        
        item2.setStatus(statusItem2);
        pesan2.setInvoiceStatus(statusInvoice2);

        System.out.println("=ORDER SECOND ITEM=");
        item2.printData();
        pesan2.printData();
    }

    public static void orderRefurbishedItem(Supplier supplier){
        ItemCategory category = ItemCategory.Stationary;
        ItemStatus statusItem3 = ItemStatus.Refurbished;
        Item item3 = new Item(3, "Pensil", statusItem3, 33, 3000, category, supplier);
        
        DatabaseItem.addItem(item3);
        
        InvoiceStatus statusInvoice3 = InvoiceStatus.Paid;
        Invoice pesan3 = new Invoice(3, item3, "14 Maret 2019", item3.getPrice(), statusInvoice3);
        
        item3.setStatus(statusItem3);
        pesan3.setInvoiceStatus(statusInvoice3);
        
        System.out.println("=ORDER REFURBISHED ITEM=");
        item3.printData();
        pesan3.printData();
    }

    public static void sellItemPaid(Item item){
        InvoiceStatus statusInvoice4 = InvoiceStatus.Paid;
        ItemStatus statusItem4 = ItemStatus.Sold;

        Invoice pesan4 = new Invoice(4, item, "14 Maret 2019", item.getPrice(), statusInvoice4);

        pesan4.setInvoiceStatus(statusInvoice4);
        item.setStatus(statusItem4);

        System.out.println("=SELL ITEM PAID=");
        pesan4.printData();
        item.printData();
    }

    public static void sellItemUnpaid(Item item){
        InvoiceStatus statusInvoice5 = InvoiceStatus.Unpaid;
        ItemStatus statusItem5 = ItemStatus.Sold;

        Invoice pesan5 = new Invoice(5, item, "14 Maret 2019", item.getPrice(), statusInvoice5);

        pesan5.setInvoiceStatus(statusInvoice5);
        item.setStatus(statusItem5);

        System.out.println("=SELL ITEM UNPAID=");
        pesan5.printData();
        item.printData();
    }

    public static void sellItemInstallment(Item item){
        InvoiceStatus statusInvoice6 = InvoiceStatus.Installment;
        ItemStatus statusItem6 = ItemStatus.Sold;

        Invoice pesan6 = new Invoice(6, item, "14 Maret 2019", item.getPrice(), statusInvoice6);

        pesan6.setInvoiceStatus(statusInvoice6);
        item.setStatus(statusItem6);

        System.out.println("=SELL ITEM INSTALLMENT=");
        pesan6.printData();
        item.printData();
    }
}