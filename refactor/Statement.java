/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package refactor;

import java.util.Enumeration;

public abstract class Statement {

    abstract String headerString(Customer aCustomer);

    abstract String eachRentalString(Rental aRental);

    abstract String footerString(Customer aCustomer);

    public String value(Customer aCustomer) {
        Enumeration rentals = (Enumeration) aCustomer.getRentals();
        String result = headerString(aCustomer);

        while (rentals.hasMoreElements()) {
            Rental each = (Rental) rentals.nextElement();
            result += eachRentalString(each);
        }

        result += footerString(aCustomer);
        return result;
    }

}
