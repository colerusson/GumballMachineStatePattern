public class NoGumYesQuarter implements MachineState {
    private final GumballMachine gumballMachine;

    public NoGumYesQuarter(GumballMachine gumballMachine) {
        this.gumballMachine = gumballMachine;
    }

    @Override
    public void addGumballs(int count) {
        System.out.println("You added " + count + " gumballs.");
        gumballMachine.gumballCount += count;
        gumballMachine.setState(new YesGumYesQuarter(gumballMachine));
    }

    @Override
    public void insertQuarter() {
        System.out.println("You inserted a quarter, but there already is a quarter. That is beyond quantum physics. Try turning the handle bud.");
    }

    @Override
    public void removeQuarter() {
        System.out.println("You removed a quarter.");
        gumballMachine.hasQuarter = false;
        gumballMachine.setState(new NoGumNoQuarter(gumballMachine));
    }

    @Override
    public void turnHandle() {
        System.out.println("You turned the handle, but there are no gumballs.");
        gumballMachine.hasQuarter = false;
        gumballMachine.setState(new NoGumNoQuarter(gumballMachine));
    }
}
