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
		//This string is required (along with the import statement up top) to read input from the user.
		//You'll need it if you want to take input from the terminal window. Let's put it here with
		//the other function-level variables.
		int gridX,gridY;
		Grid g;
		Position p;
		gridPosition robotStart;
		ArrowBot a;
		
		
		//Welcome the user. The while loop ensures that the program does not proceed until
		//the user enters the input in the right format.
		
		System.out.println("Welcome to ArrowBot!\nWhat would you like the size of the grid to be?\n");
		
		p = getPosition();
		
		gridX=p.getX();
		gridY=p.getY();
		
		//The below line is what's known as a debugging line. I ran this at first to test that
		//the input reading was working correctly. It didn't at first, so I'm glad I put it in.
		//Now that it's working, I comment out the line or remove it completely.
		//System.out.println("Your numbers are: "+gridX+" and "+gridY+".");
		
		g = new Grid(gridX,gridY);
		g.drawGrid();
		
		System.out.println("Check out your grid! This is where your robot is going to roam.");
		
		System.out.println("Where should your robot start?");
		
		robotStart = getGridPosition(g);
		
		a = new ArrowBotManual(robotStart);
		
		System.out.println("Now let's go!\n\n");
		
		/*
		 * The user controls the robot by using wasd, with q for quit. However, the user has to
		 * hit the enter key after each command. There is no good way to read a single character
		 * from the command line in Java. It's a hard limitation on the language.
		 */
		g.drawGrid(a.getRobotPosition());
		while(true){
			a.move();
			g.drawGrid(a.getRobotPosition());
			if(a.getRobotPosition().equals(g.getGoalPosition())){
				System.out.println("You're winner!");
				quit();
			}
		}

	}
	
	private static Position getPosition(){
		Scanner keyboard = new Scanner(System.in);
		String input="";
		int posX,posY;
		
		while (!Pattern.matches("\\d+,\\d+", input)){
			System.out.print("Enter a comma-delimited pair of numbers: ");
			input=keyboard.next();
		}
		
		posX=Integer.parseInt(input.split(",")[0]);
		posY=Integer.parseInt(input.split(",")[1]);
		
		return new Position(posX,posY);
	}
	
	private static gridPosition getGridPosition(Grid g){
		Position p = getPosition();
		return new gridPosition(p.getX(),p.getY(),g);
	}
	
	public static void quit(){
		System.out.println();
		System.out.println("Bye bye!\n");
		System.exit(0);
	}

}
