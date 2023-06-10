
public class ChocolateBoiler {
	private boolean empty;
	private boolean boiled;
	private static ChocolateBoiler uniqueInstance;
  
	private ChocolateBoiler() {
		empty = true;
		boiled = false;
	}
  
	public static synchronized ChocolateBoiler getInstance() {
		if (uniqueInstance == null) {
			System.out.println("Se creo el objeto");
			uniqueInstance = new ChocolateBoiler();
		}
		System.out.println("Se regresa el objeto creado");
		return uniqueInstance;
	}

	public void fill() {
		if (isEmpty()) {
			empty = false;
			boiled = false;
		}
	}
 
	public void drain() {
		if (!isEmpty() && isBoiled()) {
			empty = true;
		}
	}
 
	public void boil() {
		if (!isEmpty() && !isBoiled()) {
			boiled = true;
		}
	}
  
	public boolean isEmpty() {
		return empty;
	}
 
	public boolean isBoiled() {
		return boiled;
	}
}