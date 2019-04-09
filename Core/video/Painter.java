package video;

import Game.Arrow;
import Game.Block;
import Game.Information;
import Game.Map;
import Game.Tank;

public class Painter {
	public static char[][] getPicture(){
		int x = Information.getCharMapSize().getX();
		int y = Information.getCharMapSize().getY();
		
		char[][] array = new char[x][y];
		try{
		paintMap(array);
		paintArrows(array);
		paintTanks(array);
		}
		catch(Exception e){
			
		}
		
		return array;
	}

	private static void paintArrows(char[][] array) {
		for(Arrow a : Arrow.getArrows())
		for(Block block : a.getBlocks()){
			array[block.getX()*2][block.getY()]  = block.getLeft();
			array[block.getX()*2+1][block.getY()]  = block.getRight();
		}
	}

	private static void paintTanks(char[][] array) {
		for(Tank t : Tank.getTanks()){
			for(Block block : t.getBlocks()){
				array[block.getX()*2][block.getY()]  = block.getLeft();
				array[block.getX()*2+1][block.getY()]  = block.getRight();
			}
		}
	}

	private static void paintMap(char[][] array) {
		for(int i = 0;i<Information.getMapSize().getX();i++){
			for(int j = 0;j<Information.getMapSize().getY();j++){
				array[i*2][j] = Map.get()[j][i].getLeft();
				array[i*2+1][j] = Map.get()[j][i].getRight();
			}
		}
	}
}
