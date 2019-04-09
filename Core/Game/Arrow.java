package Game;

import java.util.ArrayList;

public class Arrow {
	private static ArrayList<Arrow>arrows = new ArrayList<Arrow>();
	private Block[] blocks = new Block[3];
	private Direction direction;
	private Tank tank;
	private boolean enable = true;
	public Arrow(){
		
	}
	public Arrow(Tank tank){
		setDirection(tank.getDirection());
		setTank(tank);
		setBlocks(direction);
		
	}
	
	public Block[] getBlocks() {
		return blocks;
	}

	public void setBlocks(Direction direction) {
		
			blocks[0] = new Block(tank.getPosition().clone(),Texture.T3,1);
			blocks[0].changePosition(direction);
			blocks[0].changePosition(direction);
			blocks[1] = new Block(tank.getPosition().clone(),Texture.T2,1);
			blocks[1].changePosition(direction);
			blocks[2] = new Block(tank.getPosition().clone(),Texture.T1,1);
			
		
	}

	public static ArrayList<Arrow> getArrows() {
		return arrows;
	}

	public static void add(Arrow arrow) {
		Arrow.arrows.add(arrow);
	}

	public Direction getDirection() {
		return direction;
	}
	public void setDirection(Direction direction) {
		this.direction = direction;
	}
	public static void flyAll(){
		for(Arrow a: arrows){
			a.fly();
		}
	}
	
	public void fly(){
		if(enable)
		for(Block b : blocks){
			if(	b.getPoint().getX() > 1 &&
				b.getPoint().getX() < Information.getMapSize().getX()-2 &&
				b.getPoint().getY() > 1 &&
				b.getPoint().getY() < Information.getMapSize().getY()-2)
			{
				damageMap();
				damageTanks(tank);
				b.changePosition(direction);
			}
			else{
				this.remove();
				return;
			}
		}
	}
	private void damageTanks(Tank tank) {
		if(enable)
		for(Tank t : Tank.getTanks()){
			for(Block b : t.getBlocks()){
				int x,y,x1,y1;
				x = blocks[0].getX();
				y = blocks[0].getY(); 
				y1 = b.getY();
				x1 = b.getX();
				
				if(x1==x && y1==y)
				{	
					switch(b.getTexture().getName()){
					case "T1":
						switch(tank.getId()){
						case 1:App.a+=5;break;
						case 2:App.b+=5;break;}
						
						try{
							Map.next();
						}
						catch(Exception e)
						{
							
						}
							Tank.remove(App.tank1);
							Tank.remove(App.tank2);
							App.createTanks();
							
							
							
						break;
					case "T2":b.setTexture(Texture.T1);
						switch(tank.getId()){
						case 1:App.a+=2;break;
						case 2:App.b+=2;break;
					
					}
					break;
					case "T3":b.setTexture(Texture.T2);
						switch(tank.getId()){
						case 1:App.a+=1;break;
						case 2:App.b+=1;break;
						
						}
					break;
					}
					remove();
					
				}
			}
		}
		
	}
	private void damageMap() {
		
		int x,y;
		y = blocks[0].getX();
		x = blocks[0].getY(); 
		if(enable)
		if(Map.get()[x][y].getTexture()!=Texture.Tvoid)
		{	
			Map.get()[x][y].setTexture(Texture.Tvoid);
			
			
		if(Map.get()[x][y-1].getTexture()	==Texture.T3) Map.get()[x][y-1].setTexture(Texture.Tvoid);
		if(Map.get()[x-1][y].getTexture()	==Texture.T3) Map.get()[x-1][y].setTexture(Texture.Tvoid);
		if(Map.get()[x+1][y].getTexture()	==Texture.T3) Map.get()[x+1][y].setTexture(Texture.Tvoid);
		if(Map.get()[x][y+1].getTexture()	==Texture.T3) Map.get()[x][y+1].setTexture(Texture.Tvoid);
		
		if(Map.get()[x-1][y-1].getTexture()	==Texture.T3) Map.get()[x-1][y-1].setTexture(Texture.Tvoid);
		if(Map.get()[x-1][y+1].getTexture()	==Texture.T3) Map.get()[x-1][y+1].setTexture(Texture.Tvoid);
		if(Map.get()[x+1][y-1].getTexture()	==Texture.T3) Map.get()[x+1][y-1].setTexture(Texture.Tvoid);
		if(Map.get()[x+1][y+1].getTexture()	==Texture.T3) Map.get()[x+1][y+1].setTexture(Texture.Tvoid);
		remove();
		}
	}
	private void remove() {
		arrows.remove(this);
		enable = false;
	}
	public Tank getTank() {
		return tank;
	}
	public void setTank(Tank tank) {
		this.tank = tank;
	}
	
}
