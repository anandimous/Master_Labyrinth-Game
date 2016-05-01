package code.model;

public class TileUtilities {
	//Tile Type
	public static final char T = 'T';
	public static final char L = 'L';
	public static final char I = 'I';
	//Tile Rotation
	public static final int N = 0;
	public static final int E = 1;
	public static final int S = 2;
	public static final int W = 3;
	
	/**This method takes a tile and determines the type of tile it is.
	 * 
	 * 
	 * @param t insert Tile
	 * @return T,L, or I
	 * @throws IllegalArgumentException If the tile does not conform to a type.
	 */
	public static char tileType(AbstractTile t){
		int truth = 0;
		if(1==t.getTop()){
			truth++;
		}
		if(1==t.getRight()){
			truth++;
		}
		if(1==t.getBottom()){
			truth++;
		}
		if(1==t.getLeft()){
			truth++;
		}
		if(truth == 3){
			return T;
		}
		if(truth == 2){
			if(1==t.getTop() && 1==t.getBottom()){
				return I;
			}else{
				return L;
			}
		}
		throw new IllegalArgumentException("Tile is an illegal type");
	}
	
	/**given a tile, it will calculate the 
	 * 
	 * @param t Tile parameter
	 * @param tileType return from code.tile.TileUtilities.TileRotation(t)
	 * @return N,E,S, or W
	 * @throws IllegalArgumentException for some stupid ass reason, if this thing throws, then the fucking tile is so dumb. it should never be the cause of throws, instead the tileType should just throw through this method.
	 */
	public static int TileRotation(AbstractTile t){
		switch(TileUtilities.tileType(t)){
		case T:
			if(1==t.getTop()){
				return N;
			}
			if(1==t.getRight()){
				return E;
			}
			if(1==t.getBottom()){
				return S;
			}
			if(1==t.getLeft()){
				return W;
			}
		case L:
			if(1==t.getTop()){
				if(1==t.getRight()){
					return N;
				}else{
					return W;
				}
			}else{
				if(1==t.getRight()){
					return E;
				}else{
					return S;
				}
			}
		case I:
			if(1==t.getTop()){
				return N;
			}else{
				return E;
			}
		default:
			throw new IllegalArgumentException("tileRotaion has failed, something is incredibly wrong.");
		}
	}
}
