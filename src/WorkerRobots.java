import java.util.Scanner;

public class WorkerRobots {
	
    public static void main(String[] args) {
    	
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Worker Robot Simulator!\n");

        System.out.print("Enter the number of Cleaning Robots: ");
        int numCleaning = scanner.nextInt();

        System.out.print("Enter the number of Delivering Robots: ");
        int numDelivering = scanner.nextInt();

        AbstractRobot[] robots = new AbstractRobot[numCleaning + numDelivering];

        System.out.println("\nCreating Cleaning Robots...");
        for (int i = 0; i < numCleaning; i++) {
            System.out.print("Enter ID for Cleaning Robot " + (i + 1) + ": ");
            String id = scanner.next();
            robots[i] = new CleaningRobot(id);
        }

        System.out.println("Creating Delivering Robots...");
        for (int i = numCleaning; i < numCleaning + numDelivering; i++) {
            System.out.print("Enter ID for Delivering Robot " + (i + 1 - numCleaning) + ": ");
            String id = scanner.next();
            robots[i] = new DeliveringRobot(id);
        }

        System.out.println("\nSimulating Robot Actions:");
        for (AbstractRobot robot : robots) {
            robot.performTask();
            robot.move();
        }

        scanner.close();
    }
    
}
