import java.util.Scanner;

/**
 * Factory Robot Hazard Analyzer
 *
 * UC1 - Printing user input
 * UC3 - Calculating hazard risk
 *
 * This program collects robot arm precision, worker density,
 * and machinery condition, then calculates a hazard risk score.
 *
 * @Developer Shubham
 * @version 3.0
 */

public class FactoryRobotHazardAnalyzer {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Input: Arm Precision
        System.out.print("Enter Arm Precision (0.0 - 1.0): ");
        double armPrecision = sc.nextDouble();

        // Input: Worker Density
        System.out.print("Enter Worker Density (1 - 20): ");
        int workerDensity = sc.nextInt();

        sc.nextLine(); // Clear buffer

        // Input: Machinery State
        System.out.print("Enter Machinery State (Worn/Faulty/Critical): ");
        String machineState = sc.nextLine();

        // Echo Inputs
        System.out.println("\n--- Input Summary ---");
        System.out.println("Arm Precision   : " + armPrecision);
        System.out.println("Worker Density  : " + workerDensity);
        System.out.println("Machinery State : " + machineState);

        // Machine risk factor
        double machineRiskFactor = getMachineRiskFactor(machineState);

        // Hazard risk calculation
        double hazardRisk = calculateHazardRisk(
                armPrecision,
                workerDensity,
                machineRiskFactor
        );

        // Output result
        System.out.println("\nHazard Risk Score: " + hazardRisk);

        sc.close();
    }

    // Returns risk factor based on machinery state
    public static double getMachineRiskFactor(String machineState) {

        if (machineState.equalsIgnoreCase("Worn")) {
            return 1.3;
        } else if (machineState.equalsIgnoreCase("Faulty")) {
            return 2.0;
        } else if (machineState.equalsIgnoreCase("Critical")) {
            return 3.0;
        } else {
            System.out.println("Invalid input. Defaulting to Worn.");
            return 1.3;
        }
    }

    // Computes hazard risk score
    public static double calculateHazardRisk(
            double armPrecision,
            int workerDensity,
            double machineRiskFactor) {

        return ((1.0 - armPrecision) * 15.0)
                + (workerDensity * machineRiskFactor);
    }
}
