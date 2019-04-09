package Game;

public class Information {
	private static Point mapSize;
	private static Point charMapSize;

	public static Point getMapSize() {
		return mapSize;
	}

	public static void setMapSize(Point mapSize) {
		Information.mapSize = mapSize;
	}

	public static Point getCharMapSize() {
		return charMapSize;
	}

	public static void setCharMapSize(Point charMapSize) {
		Information.charMapSize = charMapSize;
	}
}
