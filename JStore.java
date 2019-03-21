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
public class JStore{
    
    /**
    * Method main merupakan main method dari JStore Application
    * @param args Unused
    * @return Nothing
    */    
    public static void main(String[] args){
        Location location1 = new Location("DKI Jakarta", "Zona Merah", "Jakarta");
        Supplier supplier1 = new Supplier(1, "Mahdi Yusuf", "it.mahdi.yusuf@gmail.com", "081310275390", location1);      
        Item item1 = new Item(13, "Microcontroller", ItemStatus.New, 113, 1400, ItemCategory.Electronics, supplier1);
        
        DatabaseItem.addItem(item1);
        
        Transaction.orderNewItem(item1);
        Transaction.sellItemPaid(item1);
        Transaction.sellItemUnpaid(item1);
        Transaction.sellItemInstallment(item1);
    }
    
    /**
    * Method JStore merupakan Constructor dari JStore Class
    * Method ini dapat berisi nilai default dari variabel dalam JStore Class
    */
    public JStore(){
    }
}