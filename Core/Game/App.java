package Game;
import video.Show;

public class App {
public static Tank tank1;
public static Tank tank2;
public static int a = 0;
public static int b = 0;
	public static void main(String[] args) {
		
		Map.Create(1);
		new Show();
		
		createTanks();
		while(true){
		try{
			Arrow.flyAll();
			Thread.sleep(30);
		}
			catch(Exception e){
				
			}
		
		}
		
	}
	public static void createTanks(){
		
		tank1 = new Tank(2,2,1);
		tank1.turnDown();
		tank2 = new Tank(Information.getMapSize().getX()-3,Information.getMapSize().getY()-3,2);
		Tank.addTank(tank1);
		Tank.addTank(tank2);
	}

}
