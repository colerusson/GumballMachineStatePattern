public class YesGumYesQuarter implements MachineState {
    private final GumballMachine gumballMachine;

    public YesGumYesQuarter(GumballMachine gumballMachine) {
        this.gumballMachine = gumballMachine;
    }

    @Override
    public void addGumballs(int count) {
        System.out.println("You added " + count + " gumballs.");
        gumballMachine.gumballCount += count;
    }

    @Override
    public void insertQuarter() {
        System.out.println("You inserted a quarter, but there already is a quarter. That is beyond quantum physics. Try turning the handle bud.");
        gumballMachine.hasQuarter = true;
    }

    @Override
    public void removeQuarter() {
        System.out.println("You removed a quarter.");
        gumballMachine.hasQuarter = false;
        gumballMachine.setState(new YesGumNoQuarter(gumballMachine));
    }

    @Override
    public void turnHandle() {
        System.out.println("You turned the handle and recieved a gumball. Good for you bud.");
        gumballMachine.hasQuarter = false;
        gumballMachine.gumballCount--;
        System.out.println("There are " + gumballMachine.gumballCount + " gumballs left.");
        if (gumballMachine.gumballCount == 0) {
            gumballMachine.setState(new NoGumNoQuarter(gumballMachine));
        } else {
            gumballMachine.setState(new YesGumNoQuarter(gumballMachine));
        }
    }
}
