public class Chocolatte extends CondimentDecorator {
	public Chocolatte(Beverage beverage) {
		this.beverage = beverage;
	}

	public String getDescription() {
		return beverage.getDescription() + ", Chocolatte";
	}

	public double cost() {
		return .10 + beverage.cost();
	}
}

