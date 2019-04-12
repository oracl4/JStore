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

public class Transaction
{
    public static void orderNewItem(Item item)
    {
        ArrayList<Integer> itemID = new ArrayList<Integer>();
        itemID.add(item.getId());
        Invoice invoice = new Buy_Paid(itemID);
        DatabaseInvoice.addInvoice(invoice);
    }

    public static void orderSecondItem(Item item)
    {
        ArrayList<Integer> itemID = new ArrayList<Integer>();
        itemID.add(item.getId());
        Invoice invoice = new Buy_Paid(itemID);
        DatabaseInvoice.addInvoice(invoice);
    }

    public static void orderRefurbishedItem(Item item)
    {
        ArrayList<Integer> itemID = new ArrayList<Integer>();
        itemID.add(item.getId());
        Invoice invoice = new Buy_Paid(itemID);
        DatabaseInvoice.addInvoice(invoice);
    }

    public static void sellItemPaid(Item item, Customer customer)
    {
        ArrayList<Integer> itemID = new ArrayList<Integer>();
        itemID.add(item.getId());
        Invoice invoice = new Sell_Paid(itemID,customer);
        DatabaseInvoice.addInvoice(invoice);
    }

    public static void sellItemUnpaid(Item item, Customer customer)
    {
        ArrayList<Integer> itemID = new ArrayList<Integer>();
        itemID.add(item.getId());
        Invoice invoice = new Sell_Unpaid(itemID,customer);
        DatabaseInvoice.addInvoice(invoice);
    }

    public static void sellItemInstallment(Item item, Customer customer, int installmentPeriod)
    {
        ArrayList<Integer> itemID = new ArrayList<Integer>();
        itemID.add(item.getId());
        Invoice invoice = new Sell_Installment(itemID,installmentPeriod,customer);
        DatabaseInvoice.addInvoice(invoice);
    }
    
    public boolean finishTransaction(Invoice invoice)
    {
        boolean value = false;
        for (Invoice invoiceDB : DatabaseInvoice.getInvoiceDatabase())
        {
            if (invoiceDB.getId() == invoice.getId())
            {
                invoice.setIsActive(false);
                System.out.print(invoice.getIsActive());
                value = true;
            }
        }
        return value;
    }
    
    public boolean cancelTransaction(Invoice invoice)
    {
        boolean value = false;
        for (Invoice invoiceDB : DatabaseInvoice.getInvoiceDatabase())
        {
            if (invoiceDB.getId() == invoice.getId())
            {
                DatabaseInvoice.removeInvoice(invoice.getId());
                value = true;
            }
        }
        return value;
    }
}