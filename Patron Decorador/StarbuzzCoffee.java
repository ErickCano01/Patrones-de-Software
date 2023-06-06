import java.util.Scanner;

public class StarbuzzCoffee {
	 
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Bienvenido a la cafetería. Por favor, elige un tipo de café:");
        System.out.println("1. DarkRoast");
        System.out.println("2. Decaf");
        System.out.println("3. Espresso");
        System.out.println("4. Flatwhite");
        System.out.println("5. Hawaiano");
        System.out.println("6. HouseBlend");
        System.out.println("7. Macchiato");

        System.out.print("Opción: ");
        int opcionCafe = scanner.nextInt();

        Beverage beverage = obtenerTipoCafe(opcionCafe);

        System.out.println("\nElige los condimentos que deseas (selecciona los números separados por coma):");
        System.out.println("1. Caramel");
        System.out.println("2. Chay");
        System.out.println("3. Chocolatte");
        System.out.println("4. Milk");
        System.out.println("5. Soy");
        System.out.println("6. Whip");
        System.out.println("7. Mocha");
        System.out.println("8. Terminar y pagar");

        // Leer los condimentos seleccionados por el usuario
        scanner.nextLine(); // Limpiar el búfer
        System.out.print("Condimentos: ");
        String opcionesCondimentos = scanner.nextLine();

        // Separar las opciones de condimentos seleccionadas
        String[] opcionesArray = opcionesCondimentos.split(",");

        // Decorar la bebida con los condimentos seleccionados
        for (String opcion : opcionesArray) {
            int opcionCondimento = Integer.parseInt(opcion.trim());
            switch (opcionCondimento) {
                case 1:
                    beverage = new Caramel(beverage);
                    break;
                case 2:
                    beverage = new Chay(beverage);
                    break;
                case 3:
                    beverage = new Chocolatte(beverage);
                    break;
                case 4:
                    beverage = new Milk(beverage);
                    break;
                case 5:
                    beverage = new Soy(beverage);
                    break;
                case 6:
                    beverage = new Whip(beverage);
                    break;
                case 7:
                    beverage = new Mocha(beverage);
                    break;
                case 8:
                	break;
                default:
                    System.out.println("Condimento inválido: " + opcionCondimento);
            }
        }

        System.out.println("\n¡Tu orden es la siguiente!");
        System.out.println("Bebida: " + beverage.getDescription());
        System.out.println("Costo: $" + beverage.cost());
        scanner.close();
    }

    public static Beverage obtenerTipoCafe(int opcion) {
        switch (opcion) {
            case 1:
                return new DarkRoast();
            case 2:
                return new Decaf();
            case 3:
                return new Espresso();
            case 4:
                return new Flatwhite();
            case 5:
                return new Hawaiano();
            case 6:
                return new HouseBlend();
            case 7:
                return new Macchiato();
            default:
                System.out.println("Opción inválida");
                return null;
        }
    }
}