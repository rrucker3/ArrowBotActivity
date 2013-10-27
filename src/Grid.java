import java.util.Random;
//This import allows me to use the random number generator from Java.

/*
 * Author: Rob Rucker
 * This class contains the grid the will be used in the ArrowBot activity.
 */
public final class Grid {

	public enum Square{
		EMPTYSQUARE,GOALSQUARE,OBSTACLE
	}
	private int sizeX, sizeY;
	private Position goalPosition;
	private Square[][] arena;
	
	public Grid(int sizex, int sizey){
		Random gen = new Random();
		int goalX,goalY;
		
		//Generate goal position
		goalX=gen.nextInt(sizex);
		goalY=gen.nextInt(sizey);
		this.goalPosition=new Position(goalX,goalY);
		
		this.sizeX=sizex;
		this.sizeY=sizey;
		this.arena=new Square[sizex][sizey];
		this.createEmptyStage(sizex, sizey);
	}
	
	//I'll create a customizable grid later.
	/*public Grid(int sizex, int sizey, String[] spec){
	}
	*/
	
	//Getters
	public int getsizeX(){
		return sizeX;
	}
	
	public int getsizeY(){
		return sizeY;
	}
	
	public Position getGoalPosition(){
		return goalPosition;
	}
	
	public void drawGrid(){
		Position p = new Position(-1,-1);  //If the position is negative, there are no robots on the board.
		drawGrid(p);
	}
	
	//Print grid to console
	public void drawGrid(final Position robotPosition){
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
		
		if (goalPosition!=null){
			arena[goalPosition.getX()][goalPosition.getY()]=Square.GOALSQUARE;
		}
	}
	
}
