package refactor;

import java.util.Enumeration;

class TextStatement {

    public String value(Customer aCustomer) {
        Enumeration rentals = (Enumeration) aCustomer.getRentals();
        String result = headerString(aCustomer);

        while (rentals.hasMoreElements()) {
            Rental each = (Rental) rentals.nextElement();
            result += "\t" + each.getMovie().getTitle() + "\t"
                    + String.valueOf(each.getCharge()) + "\n";
        }
        result += "Amount owed is " + String.valueOf(aCustomer.getTotalCharge()) + "\n";
        result += "You earned "
                + String.valueOf(aCustomer.getTotalFrequentRenterPoints())
                + " frequent renter points";
        return result;
    }

    String headerString(Customer aCustomer) {
        return "Rental Record for " + aCustomer.getName() + "\n";
    }
}
