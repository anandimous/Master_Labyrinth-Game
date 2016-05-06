package code.fileIO;

public class HoldThreeStrings {
	public String line1players;
	public String line2Tiles;
	public String line3IllegalPush;
	
	/**
	 * Wraper class for 3 strings
	 * 
	 * @param a
	 * @param b
	 * @param c
	 */
	public HoldThreeStrings(String a, String b, String c){
		line1players = a;
		line2Tiles = b;
		line3IllegalPush = c;
	}
}
