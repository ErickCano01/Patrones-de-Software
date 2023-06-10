
public class SoldOutState implements State {
    GumballMachine gumballMachine;
    private static SoldOutState uniqueInstance;
    
    private SoldOutState(GumballMachine gumballMachine) {
        this.gumballMachine = gumballMachine;
    }
    public static synchronized SoldOutState getInstance(GumballMachine gumballMachine) {
        if (uniqueInstance == null) {
            uniqueInstance = new SoldOutState(gumballMachine);
        }
        return uniqueInstance;
    }
 
	public void insertQuarter() {
		System.out.println("You can't insert a quarter, the machine is sold out");
	}
 
	public void ejectQuarter() {
		System.out.println("You can't eject, you haven't inserted a quarter yet");
	}
 
	public void turnCrank() {
		System.out.println("You turned, but there are no gumballs");
	}
 
	public void dispense() {
		System.out.println("No gumball dispensed");
	}
	
	public void refill() { 
		gumballMachine.setState(gumballMachine.getNoQuarterState());
	}
 
	public String toString() {
		return "sold out";
	}
}
