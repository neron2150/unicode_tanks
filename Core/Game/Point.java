package Game;

public class Point {

	//Поля
	private int x,y;
	
	//Конструкторы
	public Point(int X, int Y){
		this.x = X;
		this.y = Y;
	}
	public Point(){
		
	}
	
	//Методы
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public void changePosition(Direction d){
		x+=d.getX();
		y+=d.getY();
	}
	public Point clone(){
		return new Point(x,y);
	}
	public static boolean checkTurnEnable(Tank tank){
		
		Direction direction = tank.getDirection();
		for(Block block : tank.getBlocks()){
			if(Map.get()[block.getY()+direction.getY()][block.getX()+direction.getX()].getTexture().getName()!=Texture.Tvoid.getName())return false;
		}
		return true;
			
	}
	public static boolean checkMapRange(Point point, Direction direction){
		return(	point.x+direction.getX() > 0 &&
				point.x+direction.getX() < Information.getMapSize().getX()-1 &&
				point.y+direction.getY() > 0 &&
				point.y+direction.getY() < Information.getMapSize().getY()-1);
			
	}
	public static boolean collisionCheck(Point a,Point b){
	return a.getX()==b.getX()&&a.getY()==b.getY();
	
	}
}
