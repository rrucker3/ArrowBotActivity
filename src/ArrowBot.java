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

	protected gridPosition robotPosition;
	
	public ArrowBot(gridPosition p){
		robotPosition = p;
	}
	
	public gridPosition getRobotPosition(){
		return robotPosition;
	}
	
	//How the robot moves will depend on whether it's autonomously or manually controlled.
	public abstract void move();
	
}
