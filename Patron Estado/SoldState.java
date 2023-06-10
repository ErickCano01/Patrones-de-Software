
public class SoldState implements State {
    GumballMachine gumballMachine;
    private static SoldState uniqueInstance;
    
    private SoldState(GumballMachine gumballMachine) {
        this.gumballMachine = gumballMachine;
    }
    
    public static synchronized SoldState getInstance(GumballMachine gumballMachine) {
        if (uniqueInstance == null) {
            uniqueInstance = new SoldState(gumballMachine);
        }
        return uniqueInstance;
    }
       
	public void insertQuarter() {
		System.out.println("Please wait, we're already giving you a gumball");
	}
 
	public void ejectQuarter() {
		System.out.println("Sorry, you already turned the crank");
	}
 
	public void turnCrank() {
		System.out.println("Turning twice doesn't get you another gumball!");
	}
 
	public void dispense() {
		gumballMachine.releaseBall();
		if (gumballMachine.getCount() > 0) {
			gumballMachine.setState(gumballMachine.getNoQuarterState());
		} else {
			System.out.println("Oops, out of gumballs!");
			gumballMachine.setState(gumballMachine.getSoldOutState());
		}
	}
	
	public void refill() { }
 
	public String toString() {
		return "dispensing a gumball";
	}
}
