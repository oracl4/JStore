public class DatabaseInvoice
{
    // variabel yang digunakan dalam class
    private Invoice[] listInvoice; // inisialisasi variabel
    public static Invoice invoice;
    
    /**
     * Method of class DatabaseInvoice
     * @return true
     */
    public static boolean addInvoice(Invoice invoice)
    {
        // return dari accessor 
        return true;
    }

    public static boolean removeInvoice(Invoice invoice)
    {
        // return dari accessor 
        return true;
    }
    
    
    /**
     * Method of class DatabaseInvoice
     * @return supplier
     */
    public Invoice getInvoice()
    {
        // return dari accessor 
        return invoice;
    }
    
    /**
     * Method of class DatabaseInvoice
     * @return listSupplier
     */
    public Invoice[] getListInvoice(){
        // return dari accessor 
        return listInvoice;
    }
}