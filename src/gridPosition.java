
public class gridPosition extends Position {

	private int maxX,maxY;
	
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
	
	@Override
	public void setPosition(int x,int y){
		if (0<=x&&x<maxX&&0<=y&&y<maxY){
			super.setPosition(x, y);
		}
	}
	
}
