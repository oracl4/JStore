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
import java.util.*;

public class Transaction{
    
    public static void orderNewItem(Item item){
        /*Invoice invoiceNewItem = new Buy_Paid(11, item, "13/12/2019", 13, item.getPrice());
        
        if (invoiceNewItem instanceof Sell_Paid)
        {
            System.out.println("Benar, Invoice Type adalah Sell_Paid");
        }
        else
        {
            System.out.println("Salah, Invoice Type adalah Sell_Paid");
        }
        System.out.println("=========");
        invoiceNewItem.printData();
        item.printData();*/
    }

    public static void orderSecondItem(Item item){
        /*Invoice invoiceSecondItem = new Buy_Paid(12, item, "13/12/2019", 14, item.getPrice());
        
        if (invoiceSecondItem instanceof Sell_Paid)
        {
            System.out.println("Benar, Invoice Type adalah Sell_Paid");
        }
        else
        {
            System.out.println("Salah, Invoice Type adalah Sell_Paid");
        }
        System.out.println("=========");
        invoiceSecondItem.printData();
        item.printData();*/
    }

    public static void orderRefurbishedItem(Item item){
        /*Invoice invoiceRefurbishedItem = new Buy_Paid(13, item, "13/12/2019", 15, item.getPrice());
        
        if (invoiceRefurbishedItem instanceof Sell_Paid)
        {
            System.out.println("Benar, Invoice Type adalah Sell_Paid");
        }
        else
        {
            System.out.println("Salah, Invoice Type adalah Sell_Paid");
        }
        System.out.println("=========");
        invoiceRefurbishedItem.printData(); 
        item.printData();*/
    }

    public static void sellItemPaid(Item item, Customer customer){
        /*Invoice invoiceSellItemPaid = new Sell_Paid(14, item, "13/12/2019", 16, item.getPrice());
        System.out.println("=========");
        invoiceSellItemPaid.printData();
        item.printData();*/
    }

    public static void sellItemUnpaid(Item item, Customer customer){
        /*Invoice invoiceSellItemUnpaid = new Sell_Unpaid(14, item, "13/12/2019", 16, item.getPrice(), "14/12/2019");
        System.out.println("=========");
        invoiceSellItemUnpaid.printData();
        item.printData();*/
    }

    public static void sellItemInstallment(Item item, Customer customer, int installmentPeriod){
        /*Invoice invoiceSellItemInstallment = new Sell_Installment(14, item, "13/12/2019", 16, item.getPrice(), 13);
        System.out.println("=========");
        invoiceSellItemInstallment.printData();
        item.printData();*/
    }
}