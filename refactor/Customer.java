package refactor;

import java.util.Enumeration;

class Customer {

    private String _name;
    private java.util.Vector _rentals = new java.util.Vector();

    public Customer(String name) {
        _name = name;
    }

    public void addRental(Rental arg) {
        _rentals.addElement(arg);
    }

    public String getName() {
        return _name;
    }
    
    

    public double getTotalCharge() {
        double result = 0;
        Enumeration rentals = _rentals.elements();
        while (rentals.hasMoreElements()) {
            Rental each = (Rental) rentals.nextElement();
            result += each.getCharge();
        }

        return result;
    }

    public double getTotalFrequentRenterPoints() {
        int result = 0;
        Enumeration rentals = _rentals.elements();
        while (rentals.hasMoreElements()) {
            Rental each = (Rental) rentals.nextElement();
            result += each.getFrecuentRenterPoints();
        }

        return result;
    }

    private double amountFor(Rental aRental) {
        double result = 0;

        switch (aRental.getMovie().getPriceCode()) {
            case Movie.REGULAR -> {
                result += 2;

                if (aRental.getDaysRented() > 2) {
                    result += (aRental.getDaysRented() - 2) * 1.5;
                }
            }
            case Movie.NEW_RELEASE ->
                result += aRental.getDaysRented() * 3;
            case Movie.CHILDREN -> {
                result += 1.5;
                if (aRental.getDaysRented() > 3) {
                    result += (aRental.getDaysRented() - 3) * 1.5;
                }
            }

        }

        return result;
    }

    public String statement() {
        Enumeration rentals = _rentals.elements();
        String result = "Rental Record for " + getName() + "\n";
        while (rentals.hasMoreElements()) {
            Rental each = (Rental) rentals.nextElement();
            result += "\t" + each.getMovie().getTitle() + "\t"
                    + String.valueOf(each.getCharge())
                    + "\n";
        }
        result += "Amount owed is " + String.valueOf(getTotalCharge()) + "\n";
        result += "You earned "
                + String.valueOf(getTotalFrequentRenterPoints())
                + " frequent renter points";
        return result;
    }

    public String htmlStatement() {
        Enumeration rentals = _rentals.elements();
        String result = "<H1>Rentals for <EM>" + getName() + "</EM></H1><P>\n";
        while (rentals.hasMoreElements()) {
            Rental each = (Rental) rentals.nextElement();
            result += each.getMovie().getTitle() + ": " + String.valueOf(each.getCharge())
                    + "<BR>\n";
        }
        result += "<P> You owe <EM> " + String.valueOf(getTotalCharge()) + "</EM> <P>\n";
        result += "On this renatal you earned <EM>"
                + String.valueOf(getTotalFrequentRenterPoints())
                + "</EM> frequent renter points<P>";
        return result;
    }

    public java.util.Vector getRentals() {
        return _rentals;
    }

    public void setRentals(java.util.Vector _rentals) {
        this._rentals = _rentals;
    }
}
