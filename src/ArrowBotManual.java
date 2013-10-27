import java.util.Scanner;

/*
 * This is where the meat of the ArrowBot code is going to be. This class will implement
 * the blueprint provided by the "ArrowBot" abstract class. It will be manually be
 * controlled by the user using wasd.
 * 
 * Author: Rob Rucker
 * Date of creation: 10/26/2013
 */

public class ArrowBotManual extends ArrowBot {
	
	Scanner keyboard;
	
	public ArrowBotManual(gridPosition p) {
		super(p);
		keyboard = new Scanner(System.in);
	}

	/*
	 * Each different implementation of ArrowBot (autonomous or no) will move differently.
	 * This is what defines an ArrowBot. So every child class of ArrowBot will implement
	 * its movement in different ways. This one is controlled by wasd.
	 */
	@Override
	public void move() {
		char input='o';

		/*
		 * The user controls the robot by using wasd, with q for quit. However, the user has to
		 * hit the enter key after each command. There is no good way to read a single character
		 * from the command line in Java. It's a hard limitation on the language.
		 */
		
		while (true){
			input=keyboard.next().charAt(0);
			switch (input){
			case 'w':
				moveUp();
				return;
			case 'a':
				moveLeft();
				return;
			case 's':
				moveDown();
				return;
			case 'd':
				moveRight();
				return;
			case 'q':
				ArrowBotActivity.quit();
				
			}		
		}
	}
	
	private void moveUp(){
		int curX=robotPosition.getX(),curY=robotPosition.getY();
		robotPosition.setPosition(curX, curY-1);
	}
	
	private void moveLeft(){
		robotPosition.setPosition(robotPosition.getX()-1, robotPosition.getY());
	}
	
	private void moveRight(){
		robotPosition.setPosition(robotPosition.getX()+1, robotPosition.getY());
	}

	private void moveDown(){
		robotPosition.setPosition(robotPosition.getX(), robotPosition.getY()+1);
	}
	
}
