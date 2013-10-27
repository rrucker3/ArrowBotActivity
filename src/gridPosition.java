/*
 * When I had finished the robot moving part, I noticed that sometimes, the robot could
 * have a position outside the grid. This was no good, so I decided to create a type of
 * Position that would prevent a robot from existing outside of the grid. This class 
 * enforces this upon creation or setting of the position, but, since this class is an 
 * extension of Position, I didn't have to rewrite any of the code I used there. Object-
 * oriented programming at its most useful.
 * Author: Rob Rucker
 * Creation date: 10/26/2013
 */
public class gridPosition extends Position {

	private int maxX,maxY;
	
	/*
	 * This constructor prevents a position outside of the grid from being created.
	 */
	public gridPosition(int x, int y, Grid g){
		super(x,y);
		maxX=g.getsizeX();
		maxY=g.getsizeY();
		if (this.x>=maxX){
			this.x=maxX-1;
		}
		if (this.y>=maxY){
			this.y=maxY-1;
		}
	}
	/*
	 * This overridden version of setPosition prevents the caller from making a position
	 * outside the grid.
	 */
	@Override
	public void setPosition(int x,int y){
		if (0<=x&&x<maxX&&0<=y&&y<maxY){
			super.setPosition(x, y);
		}
	}
	
}
