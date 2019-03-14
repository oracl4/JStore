/**
 * Enumeration class ItemStatus - write a description of the enum class here
 *
 * @author (your name here)
 * @version (version number or date here)
 */
public enum InvoiceStatus{
    Paid {
        public String toString() {
            return "Paid";
        }
    }
    ,
    Unpaid {
        public String toString() {
            return "Unpaid";
        }
    }
    ,
    Installment {
        public String toString() {
            return "Installment";
        }
    }
}