/**
 * ArrowBotActivity
 * This program will allow students to learn the ins and outs of robot programming.
 * An arrow, which we will pretend is a robot, will find its way through a maze.
 * The robot will first be manually controlled by the user. Then, we will work our way
 * up to an autonomous robot with knowledge of the location of the goal, then an
 * autonomous robot without knowledge of the location of the goal.
 * 
 * The grid will also vary in complexity. At first, it will have no obstacles, but it
 * will increase in difficulty and size until it resembles a maze.
 * 
 * Date of creation: 10/26/2013
 */

/*
 * Here we have our import statements. These are used to bring in classes, methods, and other
 * things written by other people. They are essential to even the smallest programs. Java
 * comes standard with a large set of standard libraries, and there are many, many others
 * that are available on the Internet.
 */
import java.util.*;
import java.util.regex.Pattern;

/**
 * @author Rob Rucker
 *
 */
public class ArrowBotActivity {
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		/*
		 * The first thing you want to put in any of your methods (Java refers to a general
		 * subroutine as a method) is a list of the variables you will use in the method.
		 * You have to declare all of your variables before you use them so that the Java
		 * compiler will know how to treat them in your program. ints are stored, accessed,
		 * and used differently than floats, floats are different from doubles, and the
		 * intrinsic types (which are always available, like integers, booleans, etc) are
		 * different from classes that you write on your own or import.
		 */
		Grid g;
		Pair gridSize;
		gridPosition robotStart;
		ArrowBot a;
		Scanner keyboard = new Scanner(System.in);
		//I initialize the keyboard before I perform any input and pass it into all methods that
		//use it, since the console is shared among all methods in this class.
		
		/*
		 * END VARIABLE DECLARATIONS
		 * ___________________________________________________________________________
		 * BEGIN PROGRAM
		 */
		
		System.out.println("Welcome to ArrowBot!\nWhat would you like the size of the grid to be?\n");
		
		/*
		 * When you reuse code (like getting two integers from a user), you need to put it 
		 * in a subroutine. This serves many, many purposes, such as making your main method
		 * much easier to read, preventing you from copying and pasting code, hiding abstraction,
		 * and a host of other benefits. Subroutines are essential to any program written 
		 * after about 1960.
		 */
		gridSize = getPosition(keyboard);
		
		//The below line is what's known as a debugging line. I ran this at first to test that
		//the input reading was working correctly. It didn't at first, so I'm glad I put it in.
		//Now that it's working, I comment out the line or remove it completely.
		//System.out.println("Your numbers are: "+p.getX()+" and "+p.getY()+".");
		
		g = new Grid(gridSize.getX(),gridSize.getY());
		g.drawGrid();
		
		System.out.println("Check out your grid! This is where your robot is going to roam.");
		
		System.out.println("Where should your robot start?");
		
		robotStart = getGridPosition(keyboard,g);
		
		/*
		 * Later, this is where the user will be queried about which type of robot will
		 * be used. However, since only the manual robot is implemented right now, there
		 * is no choice to be made.
		 */
		
		a = new ArrowBotManual(robotStart);
		
		System.out.println("Now let's go! Use wasd to control and q to quit.\n\n");
		
		/*
		 * This is the main loop of the program. Each turn, it moves the robot one square.
		 * Whether this move is automatic or manual is controlled by what type of robot a is.
		 * If manual, the robot will move based on user input. The first letter of the input
		 * string (up until the user presses enter) will be used to determine where the 
		 * robot moves. q will be used to quit out.
		 */
		g.drawGrid(a.getRobotPosition());
		while(true){
			a.move();
			g.drawGrid(a.getRobotPosition());
			if(a.getRobotPosition().equals(g.getGoalPosition())){
				System.out.println("You're winner!");
				keyboard.close();
				quit();
			}
		}

	}
	
	private static Pair getPosition(Scanner keyboard){
		String input="";
		int posX,posY;
		
		/*
		 * This loop is used to validate input. You should always always always validate
		 * any input to your program, whether it's input from a user, input from a file, input
		 * from the Internet, etc. Your program should never crash based on its input. In this
		 * case, the while loop ensures that the input is not read (potentially producing a 
		 * crash) until the input is exactly what I want, ie, two integers separated by a 
		 * comma. The character matching uses Regular Expressions, which, once you learn them,
		 * are very handy for this sort of thing.
		 */
		while (!Pattern.matches("\\d+,\\d+", input)){
			System.out.print("Enter a comma-delimited pair of numbers: ");
			input=keyboard.next();
		}
		
		/*
		 * The while loop above ensures that the format of the input matches "Integer,Integer".
		 * This allows us to proceed without fear to reading the input into the program.
		 * The two statements below take the first and second integers and store them into
		 * two different variables, which are then used to build a "Position" object.
		 */
		posX=Integer.parseInt(input.split(",")[0]);
		posY=Integer.parseInt(input.split(",")[1]);
		
		return new Pair(posX,posY);
	}
	
	/*
	 * The above function, getPosition, is used to return a position, but if a gridPosition
	 * is used, the function below can be used to create a position with respect to a grid.
	 */
	private static gridPosition getGridPosition(Scanner keyboard,Grid g){
		Pair p = getPosition(keyboard);
		return new gridPosition(p.getX(),p.getY(),g);
	}
	
	/*
	 * If the user chooses to quit, exit the program.
	 */
	public static void quit(){
		System.out.println();
		System.out.println("Bye bye!\n");
		System.exit(0);
	}

}
