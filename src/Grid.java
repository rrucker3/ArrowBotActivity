import java.util.Random;
/* This import allows me to use the random number generator from Java.
 * The goal's position will be randomly generated each time a grid is created.
 */
/*
 * Author: Rob Rucker
 * This class contains the grid the will be used in the ArrowBot activity.
 */
public final class Grid {

	/*
	 * The first thing I'll do in the class is determine what kinds of squares there will
	 * be on the grid. There are only three types of things that can be on a square
	 * (excepting the ArrowBot), so I will use an enum type to make sure that only these
	 * 3 values can be chosen. If there were only two things, I could use a boolean, but 
	 * it wouldn't make as much sense unless I rewrote the underlying grid structure to be 
	 * a grid of "is the square empty" questions, which is slightly less easy to keep
	 * track of. Most, if not all, compiler checks are there to help the programmer 
	 * remember things that otherwise might be forgotten.
	 */
	public enum Square{
		EMPTYSQUARE,GOALSQUARE,OBSTACLE
	}
	private int sizeX, sizeY;
	private Pair goalPosition;
	private Square[][] arena;
	
	/*
	 * Each class needs a constructor, which describes how to build an object. How should
	 * each of the class variables be set? What else should run when creating a grid?
	 */
	public Grid(int sizex, int sizey){
		Random gen = new Random();
		int goalX,goalY;
		
		//Generate goal position randomly
		goalX=gen.nextInt(sizex);
		goalY=gen.nextInt(sizey);
		this.goalPosition=new Pair(goalX,goalY);
		
		this.sizeX=sizex;
		this.sizeY=sizey;
		/*
		 * In Java, whenever you create an array, you must use the "new" keyword. This is 
		 * because Java considers arrays objects instead of intrinsic types, and the "new"
		 * keyword is used to indicate that memory will be allocated dynamically for this
		 * object. In this case, the arena/grid will be a 2D array of squares.
		 */
		this.arena=new Square[sizex][sizey];
		/*
		 * Later, we'll make a way to put obstacles in the grid. For now, the grid will be 
		 * empty except for the goal.
		 */
		this.createEmptyStage(sizex, sizey);
	}
	
	//I'll create a customizable grid later. For now, this will stay commented out.
	/*public Grid(int sizex, int sizey, String[] spec){
	}
	*/
	
	/* These are getters. To prevent just anybody from monkeying around with the internal
	 * workings of your class, you make them private, meaning that only the class itself can
	 * directly access them. Then, you create getters to expose their values to the world
	 * outside safely.
	 */
	public int getsizeX(){
		return sizeX;
	}
	
	public int getsizeY(){
		return sizeY;
	}
	
	public Pair getGoalPosition(){
		return goalPosition;
	}
	
	//Print grid if a robot position is not specified
	public void drawGrid(){
		Pair p = new Pair(-1,-1);  //If the position is negative, there are no robots on the board.
		drawGrid(p);
	}
	
	//Print grid to console
	public void drawGrid(final Pair robotPosition){
		int indexX,indexY;
		
		//Draw top border
		drawHorizontalBorder();

		//Draw the main portion of the grid to the screen, bordered by "|" on each side
		for (indexY=0;indexY<sizeY;indexY++){
			System.out.print("|");
			for (indexX=0;indexX<sizeX;indexX++){
				if (indexX==robotPosition.getX()&&indexY==robotPosition.getY()){
					System.out.print("V");
				} else {
					switch (arena[indexX][indexY]){
					case EMPTYSQUARE:
						System.out.print(" ");
						break;
					case GOALSQUARE:
						System.out.print("O");
						break;
					case OBSTACLE:
						System.out.print("X");
						break;
					default:
						System.out.print(" ");
						break;
					}
				}
			}
			System.out.println("|");
		}

		//Draw bottom border
		drawHorizontalBorder();

	}

	/*
	 * I only need this code twice, but I put it in a subroutine because if I ever need
	 * to change something, like what character to use as a border, I only need to change
	 * it in one place.
	 */
	private void drawHorizontalBorder(){
		int indexX;
		for (indexX=0;indexX<sizeX+2;indexX++){
			System.out.print("-");
		}
		System.out.println();
	}
	
	private void createEmptyStage(int sizex,int sizey){
		int iX,iY;
		
		for (iX=0;iX<sizex;iX++) {
			for (iY=0;iY<sizey;iY++){
				arena[iX][iY]=Square.EMPTYSQUARE;
			}
		}
		
		/*
		 * In Java, if an object is never created, it will be equal to "null". This is an
		 * easy way to check if you have made something. However, if you need to check an
		 * already-created object to see if it is equal to a particular value, you should
		 * make an equals() method for your class.
		 */
		if (goalPosition!=null){
			arena[goalPosition.getX()][goalPosition.getY()]=Square.GOALSQUARE;
		}
	}
	
}
