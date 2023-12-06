public class GumballMachine {
    int gumballCount;
    boolean hasQuarter;

    MachineState state;
    void addGumballs(int count) {
        state.addGumballs(count);
    }

    void insertQuarter() {
        state.insertQuarter();
    }

    void removeQuarter() {
        state.removeQuarter();
    }

    void turnHandle() {
        state.turnHandle();
    }

    void setState(MachineState state) {
        this.state = state;
    }

    public static void main(String[] args) {
        GumballMachine machine = new GumballMachine();
        machine.setState(new NoGumNoQuarter(machine));
        machine.addGumballs(2);
        machine.turnHandle();
        machine.insertQuarter();
        machine.turnHandle();
        machine.insertQuarter();
        machine.turnHandle();
        machine.removeQuarter();
        machine.turnHandle();
        machine.removeQuarter();
        machine.turnHandle();
        machine.addGumballs(3);
        machine.insertQuarter();
        machine.turnHandle();
        machine.insertQuarter();
        machine.turnHandle();
        machine.removeQuarter();
    }
}
