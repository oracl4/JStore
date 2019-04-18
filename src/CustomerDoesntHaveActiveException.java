public class CustomerDoesntHaveActiveException extends Exception {
    private Customer customer_error;

    public CustomerDoesntHaveActiveException(Customer customer_input) {
        super("Customer : ");
        this.customer_error=customer_input;
    }

    public String getExMessage()
    {
        return super.getMessage() + customer_error + "\ndoesnt have active invoice.";
    }
}
