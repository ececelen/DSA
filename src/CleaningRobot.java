
public class CleaningRobot extends AbstractRobot {
	
    public CleaningRobot(String id) {
        super(id, "Cleaning");
    }

    public void performTask() {
        if (batteryLevel < 10) {
            System.out.println("Robot " + id + " (" + type + ") has critically low battery! Cannot perform task.");
            return;
        }
        System.out.println("Robot " + id + " (" + type + ") is cleaning.");
        batteryLevel -= 10;
        System.out.println("batteryLevel  (" + type + " " + id + ") " + batteryLevel);
    }
}
