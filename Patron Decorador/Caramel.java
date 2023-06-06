public class Caramel extends CondimentDecorator {
	public Caramel(Beverage beverage) {
		this.beverage = beverage;
	}

	public String getDescription() {
		return beverage.getDescription() + ", Caramel";
	}

	public double cost() {
		return .10 + beverage.cost();
	}
}
