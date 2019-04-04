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
* Class ini merupakan bagian Database Supplier dari JStore Application
* Class ini representasi dari sebuah Database Supplier yang terdapat pada JStore Application
* </p>
* 
* 
* @author   Mahdi Yusuf
* @version  1.0
* @since    2019/03/04
*/
import java.util.*;

public class DatabaseSupplier{
    
    /**
    * List Array dari Supplier yang dibuat
    */
    private Supplier listSupplier[];
    
    /**
    * Supplier dari Object Database Supplier yang dibuat
    */
    private Supplier supplier;

    /**
	* Method DatabaseSupplier merupakan Constructor dari DatabaseSupplier Class
	* Method ini dapat berisi nilai default dari variabel dalam DatabaseSupplier Class
	*/
    public DatabaseSupplier(){
    }
    
    /**
	* Method ini merupakan method yang menambahkan Supplier baru
	* Kedalam Database Supplier
	* @param supplier Supplier yang ingin dimasukan kedalam database
	* @return nilai boolean apakah pemasukan supplier berhasil atau gagal
	*/
    public boolean addSupplier(Supplier supplier){
    	return true;
    }
    
    /**
	* Method ini merupakan method yang menghapus Supplier
	* Dari Database Supplier
	* @param supplier Supplier yang ingin dihapus dari database
	* @return nilai boolean apakah penghapusan supplier berhasil atau gagal
	*/
    public boolean removeSupplier(Supplier supplier){
    	return true;
    }
    
    /**
    * Accessor Method untuk mengambil Supplier dari objek DatabaseSupplier
    * @return Supplier dari DatabaseSupplier Object
    */
    public Supplier getSupplier(){
    	return supplier;
    }

    /**
    * Accessor Method untuk mengambil List Array Supplier dari objek DatabaseSupplier
    * @return List Array Supplier dari DatabaseSupplier Object
    */
    public Supplier[] getListSupplier(){
    	return listSupplier;
    }
}
