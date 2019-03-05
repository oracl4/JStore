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
* <h1>Location.java</h1>
* <p>
* Class ini merupakan bagian location dari JStore Application
* Class ini representasi dari sebuah lokasi yang terdapat pada JStore Application
* </p>
* 
* 
* @author   Mahdi Yusuf
* @version  1.0
* @since    2019/03/04
*/
public class Location{

    /**
    * Provinsi dari Object Location yang dibuat
    */
    private String province;
    
    /**
    * Deskripsi dari Object Location yang dibuat
    */
    private String description;
    
    /**
    * Kota dari Object Location yang dibuat
    */
    private String city;

    /**
    * Method Location merupakan Constructor dari Location Class
    *
    * @param province       Provinsi dari objek location yang dibuat
    * @param description    Deskripsi dari objek location yang dibuat
    * @param city           Kota dari objek location yang dibuat
    */
    public Location(String province, String description, String city){
        this.province=province;
        this.city=city;
        this.description=description;
    }
    
    /**
    * Accessor Method untuk mengambil String Province dari objek Location
    * @return String Province dari Location Object
    */
    public String getProvince(){
        return province;
    }
    
    /**
    * Accessor Method untuk mengambil String Description dari objek Location
    * @return String Description dari Location Object
    */
    public String getDescription(){
        return description;
    }
    
    /**
    * Accessor Method untuk mengambil String City dari objek Location
    * @return String City dari Location Object
    */
    public String getCity(){
        return city;
    }
    
    /**
    * Mutator Method untuk mengubah Name dari objek Location
    * @param province String Province yang diinginkan
    */
    public void setProvince(String province){
        this.province=province;
    }
    
    /**
    * Mutator Method untuk mengubah Name dari objek Location
    * @param description String Description yang diinginkan
    */
    public void setDescription(String description){
        this.description=description;
    }
    
    /**
    * Mutator Method untuk mengubah Name dari objek Location
    * @param city String City yang diinginkan
    */
    public void setCity(String city){
        this.city=city;
    }

    /**
    * Sebuah Method untuk melakukan Print Data dari Object Location (province)
    */
    public void printData(){
        System.out.println(province);
    }
}