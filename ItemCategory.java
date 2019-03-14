/**
 * Enumeration class ItemStatus - write a description of the enum class here
 *
 * @author (your name here)
 * @version (version number or date here)
 */
public enum ItemCategory{
    Electronics {
        public String toString() {
            return "Electronics";
        }
    }
    ,
    Furniture {
        public String toString() {
            return "Furniture";
        }
    }
    ,
    Stationary {
        public String toString() {
            return "Stationary";
        }
    }
}