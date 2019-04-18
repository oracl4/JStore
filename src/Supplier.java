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
* <h1>Supplier.java</h1>
* <p>
* Class ini merupakan bagian supplier dari JStore Application
* Class ini representasi dari sebuah supplier yang terdapat pada JStore Application
* </p>
* 
* 
* @author   Mahdi Yusuf
* @version  1.0
* @since    2019/03/04
*/
import java.util.*;

public class Supplier{

    /**
    * ID dari Object Supplier yang dibuat
    */
    private int id;
    
    /**
    * Nama dari Object Supplier yang dibuat
    */
    private String name;
    
    /**
    * Email dari Object Supplier yang dibuat
    */
    private String email;
    
    /**
    * Nomor Telepon dari Object Supplier yang dibuat
    */
    private String phoneNumber;
    
    /**
    * Lokasi dari Object Supplier yang dibuat
    */
    private Location location;


    /**
    * Method Supplier merupakan Constructor dari Supplier Class
    *
    * @param id             ID dari objek supplier yang dibuat
    * @param name           Nama dari objek supplier yang dibuat
    * @param email          Email dari objek supplier yang dibuat
    * @param phoneNumber    Nomor Telepon dari objek supplier yang dibuat
    * @param location       Lokasi dari objek supplier yang dibuat
    */
    public Supplier(String name, String email, String phoneNumber, Location location)
    {
        this.id=DatabaseSupplier.getLastSupplierID()+1;
        this.name=name;
        this.email=email;
        this.phoneNumber=phoneNumber;
        this.location=location;
    }
    
    /**
    * Accessor Method untuk mengambil nilai ID dari objek Supplier
    * @return Nilai ID dari Supplier Object
    */
    public int getId(){
        return id;
    }
    
    /**
    * Accessor Method untuk mengambil String Name dari objek Supplier
    * @return String Name dari Supplier Object
    */
    public String getName(){
        return name;
    }
    
    /**
    * Accessor Method untuk mengambil String Email dari objek Supplier
    * @return String Email dari Supplier Object
    */
    public String getEmail(){
        return email;
    }
    
    /**
    * Accessor Method untuk mengambil String PhoneNumber dari objek Supplier
    * @return String PhoneNumber dari Supplier Object
    */
    public String getPhoneNumber(){
        return phoneNumber;
    }
    
    /**
    * Accessor Method untuk mengambil Location dari objek Supplier
    * @return Location dari Supplier Object
    */
    public Location getLocation(){
        return location;
    }
    
    /**
    * Mutator Method untuk mengubah ID dari objek Supplier
    * @param id Nilai ID yang diinginkan
    */
    public void setId(int id){
        this.id=id;
    }
    
    /**
    * Mutator Method untuk mengubah Name dari objek Supplier
    * @param name String Name yang diinginkan
    */
    public void setName(String name){
        this.name=name;
    }

    /**
    * Mutator Method untuk mengubah Email dari objek Supplier
    * @param email String Email yang diinginkan
    */
    public void setEmail(String email){
        this.email=email;
    }

    /**
    * Mutator Method untuk mengubah PhoneNumber dari objek Supplier
    * @param phoneNumber String PhoneNumber yang diinginkan
    */
    public void setPhoneNumber(String phoneNumber){
        this.phoneNumber=phoneNumber;
    }

    /**
    * Mutator Method untuk mengubah Location dari objek Supplier
    * @param location Location yang diinginkan
    */
    public void setLocation(Location location){
        this.location=location;
    }

    /**
    * Sebuah Method untuk melakukan Print Data dari Object Invoice (name)
    */
    /*public void printData(){
        System.out.println("==========SUPPLIER=======");
        System.out.println("ID :" + id);
        System.out.println("Name :" + name);
        System.out.println("Email :" + email);
        System.out.println("No telpon :" + phoneNumber);
        System.out.println("Lokasi Supplier :" + location.getCity());
    }*/
    
    public String toString()
    {
        return "========SUPPLIER=========\nID: "+ id +
                "\nnama: "+name+
                "\nemail: "+email+
                "\nnomor telepon: "+phoneNumber+
                "\nlokasi: "+location.getCity()+", "+location.getProvince();
    }
}
