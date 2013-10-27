/*
 * This class represents the position of something in 2D space.
 * Author: Rob Rucker
 * Creation date: 10/26/2013
 */
public class Position {

	protected int x,y;
	
	/*
	 * This constructor is for the default initial position.
	 */
	public Position(){
		this.x=1;
		this.y=1;
	}
	
	public Position(int x,int y){
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
	
	public boolean equals(Position p){
		return (this.x==p.getX()&&this.y==p.getY());
	}
	
}
