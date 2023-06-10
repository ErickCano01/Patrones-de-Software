
public class NoQuarterState implements State {
    GumballMachine gumballMachine;
    private static NoQuarterState uniqueInstance;
    
    private NoQuarterState(GumballMachine gumballMachine) {
        this.gumballMachine = gumballMachine;
    }
    
    public static synchronized NoQuarterState getInstance(GumballMachine gumballMachine) {
        if (uniqueInstance == null) {
            uniqueInstance = new NoQuarterState(gumballMachine);
        }
        return uniqueInstance;
    }
 
	public void insertQuarter() {
		System.out.println("You inserted a quarter");
		gumballMachine.setState(gumballMachine.getHasQuarterState());
	}
 
	public void ejectQuarter() {
		System.out.println("You haven't inserted a quarter");
	}
 
	public void turnCrank() {
		System.out.println("You turned, but there's no quarter");
	 }
 
	public void dispense() {
		System.out.println("You need to pay first");
	} 
	
	public void refill() { }
 
	public String toString() {
		return "waiting for quarter";
	}
}
