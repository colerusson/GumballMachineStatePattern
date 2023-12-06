public class NoGumNoQuarter implements MachineState {
    private final GumballMachine gumballMachine;
    public NoGumNoQuarter(GumballMachine gumballMachine) {
        this.gumballMachine = gumballMachine;
    }

    @Override
    public void addGumballs(int count) {
        System.out.println("You added " + count + " gumballs.");
        gumballMachine.gumballCount += count;
        gumballMachine.setState(new YesGumNoQuarter(gumballMachine));
    }

    @Override
    public void insertQuarter() {
        System.out.println("You inserted a quarter.");
        gumballMachine.hasQuarter = true;
        gumballMachine.setState(new NoGumYesQuarter(gumballMachine));
    }

    @Override
    public void removeQuarter() {
        System.out.println("You removed a quarter, but there is no quarter to remove. That is beyond quantum physics. Try adding a quarter bud.");
    }

    @Override
    public void turnHandle() {
        System.out.println("You turned the handle, but there is no quarter and no gum.");
    }
}
