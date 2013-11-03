/*
 * This class represents the position of something in 2D space. I originally tracked 
 * everything as separate x and y variables, but this is exactly the kind of thing class
 * abstraction comes in handy for.
 * Author: Rob Rucker
 * Creation date: 10/26/2013
 * 
 * rpr 11/3/2013: Renamed this from "Position" to "Pair". Since this class doesn't have
 * a reference to any type of "position", it is just a pair of numbers. Renaming this
 * class brings it closer to the proper abstraction.
 */
public class Pair {

	protected int x,y;
	
	/*
	 * This constructor is for the default initial position.
	 */
	public Pair(){
		this.x=1;
		this.y=1;
	}
	
	public Pair(int x,int y){
		this.x=x;
		this.y=y;
	}
	
	public void setPosition(int x, int y){
		this.x=x;
		this.y=y;
	}
	
	public int getX(){
		return x;
	}
	
	public int getY(){
		return y;
	}
	
	public boolean equals(Pair p){
		return (this.x==p.getX()&&this.y==p.getY());
	}
	
}
