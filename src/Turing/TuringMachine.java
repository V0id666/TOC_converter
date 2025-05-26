package Turing;

import java.util.List;
import java.util.Set;

public class TuringMachine {
    Tape tape;
    String startStateName;
    String currentState;
    Set<String> acceptStates;
    List<TMTransition> tmTransitions;

    public TuringMachine(Tape tape, String startStateName, Set<String> acceptStates, List<TMTransition> tmTransitions) {
        this.tape = tape;
        this.startStateName = startStateName;
        this.acceptStates = acceptStates;
        this.tmTransitions = tmTransitions;
        this.currentState = startStateName;
    }

    // Overload to skip the tape simulation
    public TuringMachine(String startStateName, Set<String> acceptStates, List<TMTransition> tmTransitions) {
        this.startStateName = startStateName;
        this.acceptStates = acceptStates;
        this.tmTransitions = tmTransitions;
        this.currentState = startStateName;
    }

    public boolean step() {

        for (TMTransition t : tmTransitions) {
            if (tape.read() == '_'){
                break;
            }
            if (t.getCurrentState().equals(currentState) &&
                    t.getReadSymbol() == tape.read()) {
                currentState = t.getNextState();
                tape.write(t.getWriteSymbol());
                tape.moveHead(t.getDirection());
                tape.printTape();
                return true;
            }
        }

        return false;
    }

    public void run() {
        System.out.println("🎬 Starting Turing Machine Simulation...\n");
        tape.printTape();

        while (step()) {
            // Each step will print tape state if step() is designed that way.
        }

        System.out.println(); // Add spacing after simulation

        if (acceptStates.contains(currentState) && tape.read() == '_') {
            System.out.println("✅ String Accepted 🎉");
        } else {
            System.out.println("❌ String Rejected");
        }
    }
}
