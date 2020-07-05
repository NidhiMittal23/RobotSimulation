import java.util.Scanner;

public class Simulation {

    public static String simulate(Robot robot, char[] traverse){
    char initialDirection = robot.getDirection();
    for(char instruction: traverse){
        if(instruction!='A'){
            String newDirection = Character.toString(robot.getDirection()) + Character.toString(instruction);
            robot.setDirection(changeDirection(newDirection));
        } else {
            switch (robot.getDirection()){
                case 'N': robot.setY(robot.getY() +1);
                break;
                case 'S': robot.setY(robot.getY() -1);
                break;
                case 'W': robot.setX(robot.getX() -1);
                break;
                case 'E': robot.setX(robot.getX() +1);
                break;
                default:
                    throw new IllegalStateException("Unexpected value: " + initialDirection);
            }
        }
    }
    return(displayResult(robot));
    }

    private static String displayResult(Robot robot){
       String  result =robot.getX() + " " + robot.getY()+ " " + robot.getDirection();
       return result;
    }

    private static char changeDirection(String direction) {
        switch (direction){
            case "NR" : case "SR" : return 'E';
            case "NL" : case "SL" : return 'W';
            case "ER" : case "WL" : return 'S';
            case "EL" : case "WE" : return 'N';
        }
        return 0;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Please enter the robot coordinates. Ex: 73N");
        String initialCoordinates = s.nextLine().toUpperCase().trim();
        char[] initialPosition = initialCoordinates.toCharArray();
        int x = Character.getNumericValue(initialPosition[0]);
        int y = Character.getNumericValue(initialPosition[1]);
        char direction = initialPosition[2];
        Robot robot = new Robot(x,y,direction);
        System.out.println("Please enter the instruction, A: advance, R: right, L: left");
        String instructions = s.nextLine().toUpperCase().trim();
        String result = simulate(robot, instructions.toCharArray());
        System.out.println(result);
    }
}
