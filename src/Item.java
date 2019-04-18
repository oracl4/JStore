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
* <h1>Item.java</h1>
* <p>
* Class ini merupakan bagian item dari JStore Application
* Class ini representasi dari sebuah item yang terdapat pada JStore Application
* </p>
* 
* 
* @author   Mahdi Yusuf
* @version  1.0
* @since    2019/03/04
*/
import java.util.*;

public class Item
{
    /**
    * ID dari Object Item yang dibuat
    */
    private int id;

    /**
    * Nama dari Object Item yang dibuat
    */
    private String name;
    
    /**
    * Stok dari Object Item yang dibuat
    */
    //private int stock;
    
    /**
    * Harga dari Object Item yang dibuat
    */
    private int price;
    
    /**
    * Kategori dari Object Item yang dibuat
    */
    private ItemCategory category;

    private ItemStatus status;
    
    /**
    * Supplier dari Object Item yang dibuat
    */
    private Supplier supplier;

    /**
    * Method Item merupakan Constructor dari Item Class
    *
    * @param id         ID dari objek barang yang dibuat
    * @param name       Nama dari objek barang yang dibuat
    * @param stock      Stock dari objek barang yang dibuat
    * @param price      Harga dari objek barang yang dibuat
    * @param category   Kategori dari objek barang yang dibuat
    * @param Supplier   Supplier dari objek barang yang dibuat
    */
    public Item(String name, int price, ItemCategory category, ItemStatus status, Supplier supplier)
    {
        id=DatabaseItem.getLastItemID()+1;
        this.name=name;
        this.price=price;
        this.category=category;
        this.status=status;
        this.supplier=supplier;
    }

    /**
    * Accessor Method untuk mengambil nilai ID dari objek Item
    * @return Nilai ID dari Item Object
    */
    public int getId()
    {
        return id;
    }
    
    /**
    * Accessor Method untuk mengambil String Nama dari objek Item
    * @return String Nama dari Item Object
    */
    public String getName()
    {
        return name;
    }

    /**
    * Accessor Method untuk mengambil nilai Stock dari objek Item
    * @return Nilai Stock dari Item Object
    */
    /*public int getStock()
    {
        return stock;
    }*/
    
    /**
    * Accessor Method untuk mengambil nilai Price dari objek Item
    * @return Nilai Price dari Item Object
    */
    public int getPrice()
    {
        return price;
    }
    
    /**
    * Accessor Method untuk mengambil String Category dari objek Item
    * @return String Category dari Item Object
    */
    public ItemCategory getCategory()
    {
        return category;
    }

    public ItemStatus getStatus()
    {
        return status;
    }

    /**
    * Accessor Method untuk mengambil Supplier dari objek Item
    * @return Supplier dari Item Object
    */
    public Supplier getSupplier()
    {
        return supplier;
    }
    
    /**
    * Mutator Method untuk mengubah ID dari objek Item
    * @param id Nilai ID yang diinginkan
    */
    public void setId(int id)
    {
        this.id=id;
    }
    
    /**
    * Mutator Method untuk mengubah Name dari objek Item
    * @param name String Name yang diinginkan
    */
    public void setName(String name)
    {
        this.name=name;
    }
    
    /**
    * Mutator Method untuk mengubah Stock dari objek Item
    * @param stock Nilai Stock yang diinginkan
    */
    /*public void setStock(int stock)
    {
        this.stock=stock;
    }*/

    /**
    * Mutator Method untuk mengubah Price dari objek Item
    * @param price Nilai Price yang diinginkan
    */
    public void setPrice(int price)
    {
        this.price=price;
    }

    /**
    * Mutator Method untuk mengubah Category dari objek Item
    * @param category String Category yang diinginkan
    */
    public void setCategory(ItemCategory category)
    {
        this.category=category;
    }

    public void setStatus(ItemStatus status)
    {
        this.status=status;
    }

    /**
    * Mutator Method untuk mengubah Supplier dari objek Item
    * @param supplier Supplier yang diinginkan
    */
    public void setSupplier(Supplier supplier)
    {
        this.supplier=supplier;
    }

    /**
    * Sebuah Method untuk melakukan Print Data dari Object Item
    */
   public String toString()
   {
        return "======ITEM=======\nId: "+id+"\nName: "+name+"\nCategory: "+category+"\nStatus: "+status+"\nSupplier: "+supplier.getName();
   }
}