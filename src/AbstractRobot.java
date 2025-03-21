
public abstract class AbstractRobot implements Robot {
    protected String id;
    protected String type;
    protected int batteryLevel;

   
    public AbstractRobot(String id, String type) {
        this.id = id;
        this.type = type;
        this.batteryLevel = 100; 
    }

    public void move() {
        if (batteryLevel < 10) {
            System.out.println("Robot " + id + " (" + type + ") has critically low battery!");
            return;
        }
        System.out.println("Robot " + id + " (" + type + ") is moving.");
        batteryLevel -= 5;
        System.out.println("batteryLevel  (" + type + " " + id + ") " + batteryLevel);
    }

    
    public String getType() {
        return type;
    }
}