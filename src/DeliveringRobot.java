
public class DeliveringRobot extends AbstractRobot {
	
    public DeliveringRobot(String id) {
        super(id, "Delivering");
    }

    public void performTask() {
        if (batteryLevel < 10) {
            System.out.println("Robot " + id + " (" + type + ") has critically low battery! Cannot perform task.");
            return;
        }
        System.out.println("Robot " + id + " (" + type + ") is delivering.");
        batteryLevel -= 10;
        System.out.println("batteryLevel  (" + type + " " + id + ") " + batteryLevel);
    }
}
