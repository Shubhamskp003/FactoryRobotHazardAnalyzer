import java.util.Scanner;

/**
 * Factory Robot Hazard Analyzer
 *
 * UC4 - Validation using conditional logic
 * UC5 - Refactored validation and calculation
 *
 * This program validates user inputs and calculates hazard risk
 * only when all inputs are valid.
 *
 * @Developer Shubham
 * @version 5.0
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

        sc.nextLine(); // clear buffer

        // Input: Machinery State
        System.out.print("Enter Machinery State (Worn/Faulty/Critical): ");
        String machineState = sc.nextLine();

        // Calculate hazard risk (includes validation)
        double hazardRisk = validateAndCalculateRisk(
                armPrecision,
                workerDensity,
                machineState
        );

        if (hazardRisk != -1) {
            System.out.println("\nHazard Risk Score: " + hazardRisk);
        } else {
            System.out.println("\nHazard risk calculation failed due to invalid inputs.");
        }

        sc.close();
    }

    // Refactored validation + calculation
    public static double validateAndCalculateRisk(
            double armPrecision,
            int workerDensity,
            String machineState) {

        // Validation
        if (armPrecision < 0.0 || armPrecision > 1.0) {
            System.out.println("Error: Arm precision must be between 0.0 and 1.0.");
            return -1;
        }

        if (workerDensity < 1 || workerDensity > 20) {
            System.out.println("Error: Worker density must be between 1 and 20.");
            return -1;
        }

        if (!machineState.equalsIgnoreCase("Worn")
                && !machineState.equalsIgnoreCase("Faulty")
                && !machineState.equalsIgnoreCase("Critical")) {

            System.out.println("Error: Machinery state must be Worn, Faulty, or Critical.");
            return -1;
        }

        // Risk factor
        double machineRiskFactor = getMachineRiskFactor(machineState);

        // Final hazard risk
        return calculateHazardRisk(
                armPrecision,
                workerDensity,
                machineRiskFactor
        );
    }

    // Returns machine risk factor
    public static double getMachineRiskFactor(String machineState) {

        if (machineState.equalsIgnoreCase("Worn")) {
            return 1.3;
        } else if (machineState.equalsIgnoreCase("Faulty")) {
            return 2.0;
        } else { // Critical
            return 3.0;
        }
    }

    // Calculates hazard risk
    public static double calculateHazardRisk(
            double armPrecision,
            int workerDensity,
            double machineRiskFactor) {

        return ((1.0 - armPrecision) * 15.0)
                + (workerDensity * machineRiskFactor);
    }
}
