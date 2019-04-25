/**
 * <h1>Customer.java</h1>
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
//Library
package jstore;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.*;

public class Customer
{
    // instance variables - replace the example below with your own
    private int id;
    private String name;
    private String email;
    private String username;
    private String password;
    private Calendar birthDate;

    public Customer(String name,String email,String username,String password,Calendar birthDate)
    {
        this.name=name;
        this.email=email;
        this.username=username;
        this.password=password;
        id=DatabaseCustomer.getLastCustomerID()+1;
        this.birthDate=birthDate;
        this.birthDate.add(Calendar.MONTH, -1);
    }

    public Customer(String name,String email,String username,String password,int year,int month,int dayOfMonth)
    {
        this.name=name;
        this.email=email;
        this.username=username;
        this.password=password;
        id=DatabaseCustomer.getLastCustomerID()+1;
        this.birthDate= new GregorianCalendar(year,month-1,dayOfMonth);
    }

    public String getName()
    {
        return name;
    }

    public String getEmail()
    {
        return email;
    }

    public String getUsername()
    {
        return username;
    }
    
    public String getPassword()
    {
        return password;
    }
    
    public int getID()
    {
        return id;
    }

    public Calendar getBirthDate()
    {
        /*SimpleDateFormat sdf = new SimpleDateFormat("dd MMMM yyyy");
        String birthDateString = sdf.format(birthDate.getTime());
        System.out.println("Birth date : " + birthDateString);*/
        return birthDate;
    }

    public void setName(String name){
        this.name=name;
    }

    public void setUsername(String username){
        this.username=username;
    }

    public void setEmail(String email)
    {
        this.email=email;
        String pattern = "^[a-zA-Z0-9_+&*-]+(?:\\."+  
                         "[a-zA-Z0-9_+&*-]+)*@" +  
                         "(?:[a-zA-Z0-9-]+\\.)+[a-z" +  
                         "A-Z]{2,7}$";
                         
        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(email);

        if(m.find()){
            System.out.println("Email : " + m.group());
            this.email = email;
        }
        else{
            System.out.println("Email Change Failed!");
            System.out.println("Email : NULL");
            this.email = "NULL";
        }
    }

    public void setPassword(String password)
    {
        
        String pattern = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z]).{6,}$";
        
        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(password);
        
        if(m.find()){
            System.out.println("Password : " + m.group());
            this.password = password;
        }
        else{
            System.out.println("Password Change Failed!");
            System.out.println("Password : NULL");
            this.password = "NULL";
        }
    }

    public void setID(int id){
        this.id=id;
    }
    
    public void setBirthDate(Calendar birthDate){
        this.birthDate=birthDate;
    }
    
    public void setBirthDate(int year, int month, int dayOfMonth)
    {
        this.birthDate= new GregorianCalendar(year,month-1,dayOfMonth);
    }

    public String toString()
    {
        SimpleDateFormat sdf = new SimpleDateFormat("dd MMMM yyyy");
        return "= Customer ===================================" +
                "\nName       : " + getID() +
                "\nUsername   : " + getName() +
                "\nEmail      : " + getEmail() +
                "\nPassword   : " + getPassword() +
                "\nBirthdate  : " + sdf.format(getBirthDate().getTime()) +
                "\n==========================================";
    }
}