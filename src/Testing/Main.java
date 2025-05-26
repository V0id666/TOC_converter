package Testing;

import Turing.ConvertRegexToTuringMachine;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.println("🔢 Enter a regular expression: "); //(e.g., ab(c|d)*)
            String regex = scanner.nextLine();

            System.out.println("📥 Enter a test input string: ");
            String input = scanner.nextLine();

            // Print transitions and simulate
            System.out.println("\n🛠️ Converting regex to DFA and Turing Machine...");
            ConvertRegexToTuringMachine.convertAndPrintTransitions(regex);

            //System.out.println("\n🚦 Simulating Turing Machine with input:");
            //ConvertRegexToTuringMachine.convertAndSimulate(regex, input);

        } catch (Exception e) {
            System.out.println("❌ An error occurred: " + e.getMessage());
        }
    }
}
