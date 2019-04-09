package Game;


import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class Map {
	private static Block[][] map;
	private static int current = 0;
	
	public static Block[][] get() {
		return map;
	}
	public static void Create(int num) {
		Map.map = Creator.get(num);
		current = num;
		
	}
	 public static void next(){
		 current++;
		 
		 Map.Create(current);
		
	 }
	
	
	
	private static class Creator{
		
		public static Block[][] get(int num)
		{
			List<String>str = null;
			try {
				String sp = "Core/Game/maps/"+num+".map";
				Path p = Paths.get(sp);
				str = Files.readAllLines(p);
			} 
			catch (Exception e) {
				

			}
			return create(str);
		}
		private static Block[][] create(List<String>str){
			int x,y;
			x = str.get(0).length()/2;
			y = str.size();
			Information.setCharMapSize(new Point(x*2,y));
			Information.setMapSize(new Point(x,y));
			
			System.out.println(x+" | "+y);
			Block[][] m = new Block[y][x];
			for(int i = 0;i<y;i++){
				for(int j = 0;j<x;j++){
					char l = str.get(i).charAt(j*2);
					char r = str.get(i).charAt((j*2)+1);
					m[i][j] = getBlock(i,j,l,r,1);
				}	
			}
			return m;
		}
		private static Block getBlock(int x,int y,char l,char r,int h){
			Point point =new Point(x,y);
			Texture texture = getTexture(l,r);
			return new Block(point,texture ,h);
		}
		private static Texture getTexture(char left,char right){
			switch(left){
			case '█':  return Texture.T3;
			case '░':
			case ' ': return Texture.Tvoid;
			case '#': return Texture.Twall;
			}
			return null;
		}
	
	}
}
