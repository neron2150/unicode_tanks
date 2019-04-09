package Game;

public class Block {

	private Texture texture;
	private Point point;
	private int health;
	public Block(){
		
	}
	public Block(Point pt, Texture tex,int h){
	setTexture(tex);
	setPoint(pt);
	setHealth(h);
	}
	public Block(int x,int y,char l,char r,int h){
		setTexture(new Texture(l,r));
		setPoint(new Point(x,y));
		setHealth(h);
	}
	
	public Point getPoint() {
		return point;
	}
	public void setPoint(Point point) {
		this.point = point;
	}
	public Texture getTexture() {
		return texture;
	}
	public void setTexture(Texture texture) {
		this.texture = texture;
	}
	
	public char getLeft() {
		return texture.getLeft();
	}
	public void setLeft(char left) {
		texture.setLeft(left);
	}
	public char getRight() {
		return texture.getRight();
	}
	public void setRight(char right) {
		texture.setRight(right);;
	}


	public int getX() {
		return point.getX();
	}
	public void setX(int x) {
		point.setX(x);
	}
	public int getY() {
		return point.getY();
	}
	public void setY(int y) {
		point.getY();
	}
	public int getHealth() {
		return health;
	}
	public void setHealth(int health) {
		this.health = health;
	}
	public void changePosition(Direction d){
		point.changePosition(d);
	}
}
