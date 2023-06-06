public class Chay extends CondimentDecorator {
	public Chay(Beverage beverage) {
		this.beverage = beverage;
	}

	public String getDescription() {
		return beverage.getDescription() + ", Chay";
	}

	public double cost() {
		return .10 + beverage.cost();
	}
}
