package refactor;

public class Refactor {

    public static void main(String[] args) {
        Customer customer = new Customer("Pepe");
        Movie pelicula = new Movie("hola",50);
        
        
        customer.addRental(new Rental(pelicula,3));
        System.out.println(customer.statement());
    }
    
}
