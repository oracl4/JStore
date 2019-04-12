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
* <h1>Invoice.java</h1>
* <p>
* Class ini merupakan bagian invoice dari JStore Application
* Class ini representasi dari sebuah invoice yang terdapat pada JStore Application
* </p>
* 
* 
* @author   Mahdi Yusuf
* @version  1.0
* @since    2019/03/04
*/
import java.util.*;

public abstract class Invoice
{
    /**
    * ID dari Object Invoice yang dibuat
    */
    private int id;
    
    /**
    * Item dari Object Invoice yang dibuat
    */
    //private Item item;
    
    /**
    * Tanggal dari Object Invoice yang dibuat
    */
    private Calendar date;
    
    private int totalPrice;
    
    private boolean isActive;
    
    private Customer customer;
    
    private ArrayList<Integer> item = new ArrayList<Integer>();

    /**
    * Total Harga dari Object Invoice yang dibuat
    */
    //private int totalItem;

    //private InvoiceStatus status;

    //private InvoiceType type;
    
    
    /**
    * Method Invoice merupakan Constructor dari Invoice Class
    *
    * @param id             ID dari objek invoice yang dibuat
    * @param item           Item dari objek invoice yang dibuat
    * @param date           Tanggal dari objek invoice yang dibuat
    * @param totalPrice     Total Harga dari objek invoice yang dibuat
    */
    public Invoice(ArrayList<Integer> item)
    {
        this.item=item;
        this.id=DatabaseInvoice.getLastInvoiceID()+1;
    }
    
    /**
    * Accessor Method untuk mengambil nilai ID dari objek Invoice
    * @return Nilai ID dari Invoice Object
    */
    public int getId()
    {
        return id;
    }
    
    /**
    * Accessor Method untuk mengambil Item dari objek Invoice
    * @return Item dari Invoice Object
    */
    public ArrayList<Integer> getItem()
    {
        return item;
    }
    
    /**
    * Accessor Method untuk mengambil String Date dari objek Invoice
    * @return String Date dari Invoice Object
    */
    public Calendar getDate()
    {
        return date;
    }
    
    /**
    * Accessor Method untuk mengambil nilai TotalPrice dari objek Invoice
    * @return Nilai TotalPrice dari Invoice Object
    */
    public int getTotalPrice()
    {
        return totalPrice;
    }

    public boolean getIsActive()
    {
        return isActive;
    }
    
    public Customer getCustomer()
    {
        return customer;
    }
    
    public abstract InvoiceStatus getInvoiceStatus();

    public abstract InvoiceType getInvoiceType();

    /**
    * Mutator Method untuk mengubah ID dari objek Invoice
    * @param id Nilai ID yang diinginkan
    */
    public void setId(int id)
    {
        this.id=id;
    }

    /**
    * Mutator Method untuk mengubah Item dari objek Invoice
    * @param item Item yang diinginkan
    */
    public void setItem(ArrayList<Integer> item)
    {
        this.item=item;
    }
    
    /**
    * Mutator Method untuk mengubah Date dari objek Invoice
    * @param date String Date yang diinginkan
    */
    public void setDate(Calendar date)
    {
        this.date=date;
    }

    /**
    * Mutator Method untuk mengubah ID dari objek Invoice
    * @param totalPrice Nilai TotalPrice yang diinginkan
    */
    public void setTotalPrice(int totalPrice)
    {
        for(Integer invoice : item)
        {
            totalPrice=totalPrice+DatabaseItem.getItemFromID(invoice).getPrice();
        }
    }

    public void setIsActive(boolean isActive)
    {
        this.isActive=isActive;
    }

    public abstract void setInvoiceStatus(InvoiceStatus status);

    /**
    * Sebuah Method untuk melakukan Print Data dari Object Invoice (totalPrice)
    */
    public abstract String toString();
}