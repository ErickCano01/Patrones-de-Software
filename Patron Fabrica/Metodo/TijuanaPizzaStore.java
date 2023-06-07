public class TijuanaPizzaStore extends PizzaStore{
	Pizza createPizza(String item) {
    	if (item.equals("cheese")) {
        		return new TijuanaStyleCheesePizza();
    	} else if (item.equals("veggie")) {
    	    	return new TijuanaStyleVeggiePizza();
    	} else if (item.equals("clam")) {
    	    	return new TijuanaStyleClamPizza();
    	} else if (item.equals("pepperoni")) {
        		return new TijuanaStylePepperoniPizza();
    	} else return null;
	}
}
