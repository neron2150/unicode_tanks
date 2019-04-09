package Game;

public class Texture {
	
	public static Texture Tvoid = new Texture(' ',' ',"void");
	public static Texture Twall = new Texture('#','#',"wall");
	public static Texture T1 = new Texture('▒','▒',"T1");
	public static Texture T2 = new Texture('▓','▓',"T2");
	public static Texture T3 = new Texture('█','█',"T3");
	
	private String name;
	private char left,right;
	
	public Texture(){
		
	}
	public Texture(char l,char r,String name){
		this.left = l;
		this.right = r;
		this.name = name;
	}
	public Texture(char l,char r){
		this.left = l;
		this.right = r;
	}
	
	public char getLeft() {
		return left;
	}
	public void setLeft(char left) {
		this.left = left;
	}
	public char getRight() {
		return right;
	}
	public void setRight(char right) {
		this.right = right;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}