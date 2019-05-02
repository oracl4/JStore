/**
 * <h1>Location.java</h1>
 * <p>
 * Class Description
 * Class Description
 * </p>
 *
 *
 * @author   Mahdi Yusuf
 * @version  7.0
 * @since    2019/24/04
 */
package jstore;

public class Location{

    private String province;
    private String description;
    private String city;

    public Location(String province, String description, String city){
        this.province=province;
        this.city=city;
        this.description=description;
    }
    
    public String getProvince(){
        return province;
    }
    
    public String getDescription(){
        return description;
    }
    
    public String getCity(){
        return city;
    }
    
    public void setProvince(String province){
        this.province=province;
    }
    
    public void setDescription(String description){
        this.description=description;
    }
    
    public void setCity(String city){
        this.city=city;
    }

    public String toString()
    {
        return "= Location ===============================" +
                "\nProvince      : " + province +
                "\nCity          : " + city +
                "\nDescription   : " + description +
                "\n==========================================";
    }
}