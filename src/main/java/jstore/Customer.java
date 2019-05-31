/**
 * <h1>Customer.java</h1>
 * <p>
 * Customer Java Class
 * </p>
 *
 * @author Mahdi Yusuf
 * @version 13.0
 * @since 2019/31/05
 */
package jstore;

import java.util.*;
import java.text.SimpleDateFormat;
import java.util.regex.*;

/**
 * The type Customer.
 */
public class Customer {
    private String name;
    private String email;
    private String username;
    private String password;
    private int id;
    private Calendar birthDate;

    /**
     * Instantiates a new Customer.
     *
     * @param id        the id
     * @param name      the name
     * @param email     the email
     * @param username  the username
     * @param password  the password
     * @param birthDate the birth date
     */
    public Customer(int id, String name, String email, String username, String password, Calendar birthDate) {
        this.name = name;
        this.email = email;
        this.username = username;
        this.password = password;
        this.id = id;
        this.birthDate = birthDate;
        this.birthDate.add(Calendar.MONTH, -1);
    }

    /**
     * Instantiates a new Customer.
     *
     * @param id         the id
     * @param name       the name
     * @param email      the email
     * @param username   the username
     * @param password   the password
     * @param year       the year
     * @param month      the month
     * @param dayOfMonth the day of month
     */
    public Customer(int id, String name, String email, String username, String password, int year, int month, int dayOfMonth) {
        this.name = name;
        this.email = email;
        this.username = username;
        this.password = password;
        this.id = id;
        this.birthDate = new GregorianCalendar(year, month - 1, dayOfMonth);
    }

    /**
     * Gets name.
     *
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * Gets email.
     *
     * @return email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Gets username.
     *
     * @return username
     */
    public String getUsername() {
        return username;
    }

    /**
     * Gets password.
     *
     * @return password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Gets id.
     *
     * @return id
     */
    public int getID() {
        return id;
    }

    /**
     * Gets birth date.
     *
     * @return birth date
     */
    public Calendar getBirthDate() {
        return birthDate;
    }

    /**
     * Sets name.
     *
     * @param name the name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Sets username.
     *
     * @param username the username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Sets email.
     *
     * @param email the email
     */
    public void setEmail(String email) {
        this.email = email;
        String pattern = "^[a-zA-Z0-9_+&*-]+(?:\\." +
                "[a-zA-Z0-9_+&*-]+)*@" +
                "(?:[a-zA-Z0-9-]+\\.)+[a-z" +
                "A-Z]{2,7}$";

        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(email);

        if (m.find()) {
            System.out.println("Email : " + m.group());
            this.email = email;
        } else {
            System.out.println("Email Change Failed!");
            System.out.println("Email : NULL");
            this.email = "NULL";
        }
    }

    /**
     * Sets password.
     *
     * @param password the password
     */
    public void setPassword(String password) {

        String pattern = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z]).{6,}$";

        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(password);

        if (m.find()) {
            System.out.println("Password : " + m.group());
            this.password = password;
        } else {
            System.out.println("Password Change Failed!");
            System.out.println("Password : NULL");
            this.password = "NULL";
        }
    }

    /**
     * Sets id.
     *
     * @param id the id
     */
    public void setID(int id) {
        this.id = id;
    }

    /**
     * Sets birth date.
     *
     * @param birthDate the birth date
     */
    public void setBirthDate(Calendar birthDate) {
        this.birthDate = birthDate;
    }

    /**
     * Sets birth date.
     *
     * @param year       the year
     * @param month      the month
     * @param dayOfMonth the day of month
     */
    public void setBirthDate(int year, int month, int dayOfMonth) {
        this.birthDate = new GregorianCalendar(year, month - 1, dayOfMonth);
    }

    /**
     * @return
     */
    public String toString() {
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