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
    * @return Nothing
    */    
    public static void main(String[] args){
        //Testing
        Customer customer1 = new Customer("Mahdi", "it.mahdi.yusuf@gmail.com", "Oracl4", "Password", 2019, 4, 4);
        Customer customer2 = new Customer("Gilang", "it.gilang.yudharaka@gmail.com", "Gogol", "Password", 2019, 4, 4);

        DatabaseCustomer CustomerDB = new DatabaseCustomer();
        
        int temp;
        boolean stat;
        
        CustomerDB.addCustomer(customer1);
        //System.out.println(customer1.toString());

        stat = CustomerDB.addCustomer(customer2);
        stat = CustomerDB.removeCustomer(1);
        if(stat=true)
        {
            System.out.println("True");
        }
        else
        {
            System.out.println("False");
        }
        
        temp = CustomerDB.getLastCustomerID();
        //System.out.println(customer2.toString());
        
    }
    
    /**
    * Method JStore merupakan Constructor dari JStore Class
    * Method ini dapat berisi nilai default dari variabel dalam JStore Class
    */
    public JStore(){
    }
}