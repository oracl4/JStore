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
* Class ini merupakan bagian Database Item dari JStore Application
* Class ini representasi dari sebuah Database Item yang terdapat pada JStore Application
* </p>
* 
* 
* @author   Mahdi Yusuf
* @version  1.0
* @since    2019/03/04
*/
public class DatabaseItem{

    /**
    * List Array dari Item yang dibuat
    */
    public String listItem[];
    
    /**
    * Item dari Object Database Item yang dibuat
    */
    public static Item itemDB;

    /**
    * Method DatabaseItem merupakan Constructor dari DatabaseItem Class
    * Method ini dapat berisi nilai default dari variabel dalam DatabaseItem Class
    */
    public DatabaseItem(){
    }
    
    /**
    * Method ini merupakan method yang menambahkan Item baru
    * Kedalam Database Item
    * @param item Item yang ingin dimasukan kedalam database
    * @return nilai boolean apakah pemasukan item berhasil atau gagal
    */
    public static boolean addItem(Item item){
    	itemDB=item;
        return true;
    }
    
    /**
    * Method ini merupakan method yang menghapus Item
    * Dari Database Item
    * @param item Item yang ingin dihapus dari database
    * @return nilai boolean apakah penghapusan item berhasil atau gagal
    */
    public boolean removeItem(Item item){
    	return true;
    }
    
    /**
    * Accessor Method untuk mengambil Item dari objek DatabaseItem
    * @return Item dari DatabaseItem Object
    */
    public Item getItem(){
    	return itemDB;
    }

    /**
    * Accessor Method untuk mengambil List Array Item dari objek DatabaseItem
    * @return List Array Item dari DatabaseItem Object
    */
    public String[] getItemDatabase(){
    	return listItem;
    }
}
