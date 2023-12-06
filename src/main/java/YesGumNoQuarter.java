public class YesGumNoQuarter implements MachineState {
    private final GumballMachine gumballMachine;

    public YesGumNoQuarter(GumballMachine gumballMachine) {
        this.gumballMachine = gumballMachine;
    }

    @Override
    public void addGumballs(int count) {
        System.out.println("You added " + count + " gumballs.");
        gumballMachine.gumballCount += count;
    }

    @Override
    public void insertQuarter() {
        System.out.println("You inserted a quarter.");
        gumballMachine.hasQuarter = true;
        gumballMachine.setState(new YesGumYesQuarter(gumballMachine));
    }

    @Override
    public void removeQuarter() {
        System.out.println("You removed a quarter.");
        gumballMachine.hasQuarter = false;
        gumballMachine.setState(new YesGumNoQuarter(gumballMachine));
    }

    @Override
    public void turnHandle() {
        System.out.println("You turned the handle, but there is no quarter. No gum for you bud.");
    }
}
