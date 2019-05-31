/**
 * <h1>Supplier.java</h1>
 * <p>
 * Supplier Java Class
 * </p>
 *
 * @author Mahdi Yusuf
 * @version 13.0
 * @since 2019/31/05
 */
package jstore;

/**
 * The type Supplier.
 */
public class Supplier {

    private int id;
    private String name;
    private String email;
    private String phoneNumber;
    private Location location;

    /**
     * Instantiates a new Supplier.
     *
     * @param name        the name
     * @param email       the email
     * @param phoneNumber the phone number
     * @param location    the location
     */
    public Supplier(String name, String email, String phoneNumber, Location location) {
        this.id = DatabaseSupplier.getLastSupplierID() + 1;
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.location = location;
    }

    /**
     * Gets id.
     *
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * Gets name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Gets email.
     *
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Gets phone number.
     *
     * @return the phone number
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * Gets location.
     *
     * @return the location
     */
    public Location getLocation() {
        return location;
    }

    /**
     * Sets id.
     *
     * @param id the id
     */
    public void setId(int id) {
        this.id = id;
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
     * Sets email.
     *
     * @param email the email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Sets phone number.
     *
     * @param phoneNumber the phone number
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     * Sets location.
     *
     * @param location the location
     */
    public void setLocation(Location location) {
        this.location = location;
    }

    public String toString() {
        return "= Location ===============================" +
                "\nName      : " + name +
                "\nEmail     : " + email +
                "\nTelephone : " + phoneNumber +
                "\nLocation  : " + location.getCity() + ", " + location.getProvince() +
                "\n==========================================";
    }
}
