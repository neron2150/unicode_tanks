package Game;

import java.util.ArrayList;

import javax.xml.stream.events.ProcessingInstruction;

public class Tank {
	private Point position;
	private Point startPosition;
	private int id;
	private Block[] blocks = new Block[6];
	private Direction direction;
	private boolean enable = true;
	private static ArrayList<Tank> tanks = new ArrayList<Tank>();
	
	//конструкторы
	public Tank(){
		
	}
	public Tank(Point position){
		setPosition(position);
		setStartPosition(position);
		setDirection(Direction.Up);	
		
		blocks[0] = new Block(new Point(position.getX(),position.getY()-1),  Texture.T3,2);
		blocks[1] = new Block(new Point(position.getX()-1,position.getY()),  Texture.T3,2);
		blocks[2] = new Block(new Point(position.getX(),position.getY()),    Texture.T3,2);
		blocks[3] = new Block(new Point(position.getX()+1,position.getY()),  Texture.T3,2);
		blocks[4] = new Block(new Point(position.getX()-1,position.getY()+1),Texture.T3,2);
		blocks[5] = new Block(new Point(position.getX()+1,position.getY()+1),Texture.T3,2);
		
	}
	public Tank(int x,int y,int id){
		Point position = new Point(x,y);
		setPosition(position);
		setDirection(Direction.Up);	
		setId(id);
		blocks[0] = new Block(new Point(position.getX(),position.getY()-1),  Texture.T3,2);
		blocks[1] = new Block(new Point(position.getX()-1,position.getY()),  Texture.T3,2);
		blocks[2] = new Block(new Point(position.getX(),position.getY()),    Texture.T3,2);
		blocks[3] = new Block(new Point(position.getX()+1,position.getY()),  Texture.T3,2);
		blocks[4] = new Block(new Point(position.getX()-1,position.getY()+1),Texture.T3,2);
		blocks[5] = new Block(new Point(position.getX()+1,position.getY()+1),Texture.T3,2);
		
	}
	
	//геттеры, сеттеры
	public Point getPosition() {
		return position;
	}
	public void setPosition(Point position) {
		this.position = position;
	}
	public Block[] getBlocks() {
		return blocks;
	}
	public void setBlocks(Block[] blocks) {
		this.blocks = blocks;
	}
	public Direction getDirection() {
		return direction;
	}
	public void setDirection(Direction direction) {
		this.direction = direction;
	}
	public static ArrayList<Tank> getTanks() {
		return tanks;
	}
	public static void addTank(Tank tank) {
		Tank.tanks.add(tank);
	}
	public static void remove(Tank tank) {
		Tank.tanks.remove(tank);
		tank.setEnable(false);
	}
	
	//получить-задать информацию
	public void turnUp(){
		if(this.direction == Direction.Up) go();
		else{
			this.direction = Direction.Up;
			Point _0 =new Point(position.getX(),position.getY()-1);
			Point _1 =new Point(position.getX()-1,position.getY());
			Point _2 =new Point(position.getX(),position.getY());
			Point _3 =new Point(position.getX()+1,position.getY());
			Point _4 =new Point(position.getX()-1,position.getY()+1);
			Point _5 =new Point(position.getX()+1,position.getY()+1);
													
			blocks[0].setPoint(_0);
			blocks[1].setPoint(_1);
			blocks[2].setPoint(_2);
			blocks[3].setPoint(_3);
			blocks[4].setPoint(_4);
			blocks[5].setPoint(_5);
		}
	}
	public void turnDown(){
		if(this.direction == Direction.Down) go();
		else{
			this.direction = Direction.Down;
			Point _0 =new Point(position.getX(),position.getY()+1);
			Point _1 =new Point(position.getX()+1,position.getY());
			Point _2 =new Point(position.getX(),position.getY());
			Point _3 =new Point(position.getX()-1,position.getY());
			Point _4 =new Point(position.getX()+1,position.getY()-1);
			Point _5 =new Point(position.getX()-1,position.getY()-1);
													
			blocks[0].setPoint(_0);
			blocks[1].setPoint(_1);
			blocks[2].setPoint(_2);
			blocks[3].setPoint(_3);
			blocks[4].setPoint(_4);
			blocks[5].setPoint(_5);
		}
	}
	public void turnLeft(){
		if(this.direction == Direction.Left) go();
		else{
			this.direction = Direction.Left;
			Point _0 =new Point(position.getX()-1,position.getY());
			Point _1 =new Point(position.getX(),position.getY()+1);
			Point _2 =new Point(position.getX(),position.getY());
			Point _3 =new Point(position.getX(),position.getY()-1);
			Point _4 =new Point(position.getX()+1,position.getY()+1);
			Point _5 =new Point(position.getX()+1,position.getY()-1);
													
			blocks[0].setPoint(_0);
			blocks[1].setPoint(_1);
			blocks[2].setPoint(_2);
			blocks[3].setPoint(_3);
			blocks[4].setPoint(_4);
			blocks[5].setPoint(_5);
		}
	}
	public void turnRight(){
		if(this.direction == Direction.Right) go();
		else{
			this.direction = Direction.Right;
			Point _0 =new Point(position.getX()+1,position.getY());
			Point _1 =new Point(position.getX(),position.getY()-1);
			Point _2 =new Point(position.getX(),position.getY());
			Point _3 =new Point(position.getX(),position.getY()+1);
			Point _4 =new Point(position.getX()-1,position.getY()-1);
			Point _5 =new Point(position.getX()-1,position.getY()+1);
													
			blocks[0].setPoint(_0);
			blocks[1].setPoint(_1);
			blocks[2].setPoint(_2);
			blocks[3].setPoint(_3);
			blocks[4].setPoint(_4);
			blocks[5].setPoint(_5);
		}
	}
	private void go(){
		if(enable&&Point.checkTurnEnable(this))
		{
			for(Block b : blocks){
				if(!Point.checkMapRange(b.getPoint(), direction))
				{
					return; }
			}
				for(Block b : blocks){
					b.changePosition(direction);
					
				}position.changePosition(direction);
			
			
		}
	}
	public void shoot() {
		if(enable)
		Arrow.add(new Arrow(this));
	}
	public boolean isEnable() {
		return enable;
	}
	public void setEnable(boolean enable) {
		this.enable = enable;
	}
	
	public Point getStartPosition() {
		return startPosition;
	}
	public void setStartPosition(Point startPosition) {
		this.startPosition = startPosition;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
}
