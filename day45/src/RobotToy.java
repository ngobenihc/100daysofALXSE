public class RobotToy {
    private int positionX;
    private int positionY;
    private String direction;

    public RobotToy() {
        this.positionX = 0;
        this.positionY = 0;
        this.direction = "NORTH";
    }

    public void moveForward() {
        switch (direction) {
            case "NORTH":
                positionY++;
                break;
            case "SOUTH":
                positionY--;
                break;
            case "EAST":
                positionX++;
                break;
            case "WEST":
                positionX--;
                break;
            default:
                System.out.println("Invalid direction.");
        }
    }

    public void turnRight() {
        switch (direction) {
            case "NORTH":
                direction = "EAST";
                break;
            case "SOUTH":
                direction = "WEST";
                break;
            case "EAST":
                direction = "SOUTH";
                break;
            case "WEST":
                direction = "NORTH";
                break;
            default:
                System.out.println("Invalid direction.");
        }
    }

    public void turnLeft() {
        switch (direction) {
            case "NORTH":
                direction = "WEST";
                break;
            case "SOUTH":
                direction = "EAST";
                break;
            case "EAST":
                direction = "NORTH";
                break;
            case "WEST":
                direction = "SOUTH";
                break;
            default:
                System.out.println("Invalid direction.");
        }
    }

    public void displayPosition() {
        System.out.println("Current Position: (" + positionX + ", " + positionY + "), Facing: " + direction);
    }

    public static void main(String[] args) {
        RobotToy robot = new RobotToy();

        // Move the robot forward
        robot.moveForward();
        robot.displayPosition();

        // Turn the robot right
        robot.turnRight();
        robot.displayPosition();

        // Move the robot forward again
        robot.moveForward();
        robot.displayPosition();
    }
}
