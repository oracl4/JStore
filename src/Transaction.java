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
    public static void orderNewItem(ArrayList<Integer> item_list) throws InvoiceAlreadyExistsException {
        DatabaseInvoice.addInvoice(new Buy_Paid(item_list));
    }

    public static void orderSecondItem(ArrayList<Integer> item_list) throws InvoiceAlreadyExistsException {
        DatabaseInvoice.addInvoice(new Buy_Paid(item_list));
    }

    public static void orderRefurbishedItem(ArrayList<Integer> item_list) throws InvoiceAlreadyExistsException {
        DatabaseInvoice.addInvoice(new Buy_Paid(item_list));
    }

    public static void sellItemPaid(ArrayList<Integer> item_list, Customer customer) throws InvoiceAlreadyExistsException {
        DatabaseInvoice.addInvoice(new Sell_Paid(item_list, customer));
    }

    public static void sellItemUnpaid(ArrayList<Integer> item_list, Customer customer) throws InvoiceAlreadyExistsException {
        DatabaseInvoice.addInvoice(new Sell_Unpaid(item_list, customer));
    }

    public static void sellItemInstallment(ArrayList<Integer> item_list, Customer customer, int installmentPeriod) throws InvoiceAlreadyExistsException {
        DatabaseInvoice.addInvoice(new Sell_Installment(item_list, installmentPeriod, customer));
    }
    
    public static boolean finishTransaction(Invoice invoice)
    {
        if(invoice.getInvoiceStatus().equals(InvoiceStatus.Installment)
                || invoice.getInvoiceStatus().equals(InvoiceStatus.Unpaid)){
            for (Invoice invoiceDB : DatabaseInvoice.getInvoiceDatabase()){
                if (invoiceDB.getId() == invoice.getId()) {
                    invoice.setIsActive(false);
                    System.out.println("Invoice Status : " + invoice.getIsActive());
                    return true;
                }
            }
        }
        return false;
    }
    
    public static boolean cancelTransaction(Invoice invoice)
    {
        if(invoice.getInvoiceStatus().equals(InvoiceStatus.Installment)
                || invoice.getInvoiceStatus().equals(InvoiceStatus.Unpaid)){
            for (Invoice invoiceDB : DatabaseInvoice.getInvoiceDatabase()) {
                if (invoiceDB.getId() == invoice.getId()) {
                    try {
                        DatabaseInvoice.removeInvoice(invoice.getId());
                    } catch (InvoiceNotFoundException e) {
                        e.getExMessage();
                    }
                    return true;
                }
            }
        }
        return false;
    }
}