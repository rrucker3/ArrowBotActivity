/*
 * This is what's known as an abstract class. You can't make one of these in a program;
 * it's only used for inheritance. Manually controlled and autonomous ArrowBots are going
 * to work differently, but they will share some characteristics that will be stored here.
 * You wouldn't want an ArrowBot that doesn't know whether it's manually or autonomously
 * controlled, so this class will remain abstract.
 * 
 * Author: Rob Rucker
 * Created on: 10/26/2013
 */

public abstract class ArrowBot {

	/*
	 * Protected variables are visible to the class and its children. All robots are going
	 * to have a position, so I declare it here.
	 */
	protected gridPosition robotPosition;
	
	public ArrowBot(gridPosition p){
		robotPosition = p;
	}
	
	public gridPosition getRobotPosition(){
		return robotPosition;
	}
	
	/*How the robot moves will depend on whether it's autonomously or manually controlled.
	 * If you leave the visibility blank, it defaults to "package-private", which means that
	 * every class in this package/project can see it, but nothing else can. This is probably
	 * adequate for this project.
	 */
	abstract void move();
	
	/*
	 * There are two ways to do a read-write combination: the one-line method or the two-line
	 * method. Personally, I prefer putting it in one line because it keeps the code shorter,
	 * but if it helps you keep track to have the reading and writing take place on separate
	 * lines, that is fine too, and the performance change is trival.
	 */
	protected void moveUp(){
		int curX=robotPosition.getX(),curY=robotPosition.getY();
		robotPosition.setPosition(curX, curY-1);
	}
	
	protected void moveLeft(){
		robotPosition.setPosition(robotPosition.getX()-1, robotPosition.getY());
	}
	
	protected void moveRight(){
		robotPosition.setPosition(robotPosition.getX()+1, robotPosition.getY());
	}

	protected void moveDown(){
		robotPosition.setPosition(robotPosition.getX(), robotPosition.getY()+1);
	}
}
