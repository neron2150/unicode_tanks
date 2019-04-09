package Game;

public class Direction {

	public static Direction Up = new Direction( new Point(0,-1));
	public static Direction Down = new Direction(new Point(0,1));
	public static Direction Left = new Direction(new Point(-1,0));
	public static Direction Right = new Direction(new Point(1,0));
	private Point vector;

	
		public Direction (Point d){
		this.vector = d;
	}
	public Direction (){
		
		}
	public Point getVector() {
		return vector;
	}
	public void setVector(Point current) {
		this.vector = current;
	}
	public int getX() {
		return vector.getX();
	}
	public void setX(int x) {
		vector.setX(x);
	}
	public int getY() {
		return vector.getY();
	}
	public void setY(int y) {
		vector.getY();
	}
	
	
}
