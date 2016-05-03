package code.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import code.model.AbstractTile;
import code.model.GameBoard;
import code.model.Player;

public class SaveEvent implements ActionListener{
	
	private GameBoard _gb;
	private GameBoardGUI _gameBoard;
	
	public SaveEvent(code.model.GameBoard gb, GameBoardGUI t){
		_gb = gb;
		_gameBoard = t;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		//create String
		
		//do line 1 players
		Player[] players = _gb.getPlayers();
		String line1 = "";
		for(int i = 0;i<players.length;i++){
			boolean usedForLoop = false;
			line1 = line1 +"[" + GameBoard.CURRENTPLAYER.getName() + "," + 
					GameBoard.CURRENTPLAYER.getColor() + "," +
					GameBoard.CURRENTPLAYER.get_wands() + "," +
					GameBoard.CURRENTPLAYER.codeFormula() + ",[";
			for(int frat = 0;frat < GameBoard.CURRENTPLAYER.getTokens().size();frat++){
				line1 = line1 + GameBoard.CURRENTPLAYER.getTokens().get(frat).getValue() + ",";
				usedForLoop = true;
			}
			if(usedForLoop){
			line1 = line1.substring(0,line1.length()-1)+ "]]";
			}else{
				line1 = line1+ "]]";
			}
			_gb.toggleNextPlayer();
		}
		//do line 2 Tiles
		String line2 = "";
		AbstractTile[][] board = _gb.getBoard();
		for(int i = 0;i < 49;i++){
			AbstractTile tile = board[i%7][i/7];
			boolean usedForLoop = false;
			
			int tokenValue = 0;
			if(tile.hasToken()){
				tokenValue = tile.getToken().getValue();
			}
			line2 = line2 + "[" +
					code.model.TileUtilities.tileType(tile) + code.model.TileUtilities.TileRotation(tile) + "," +
					tokenValue + ",[";
			for(int frat = 0;frat < tile.getPlayers().size();frat++){
				line2 = line2 + tile.getPlayers().get(frat).getColor() + ",";
				usedForLoop = true;
			}
			if(usedForLoop){
				line2 = line2.substring(0,line2.length()-1)+ "]]";
			}else{
				line2 = line2+ "]]";
			}

		}


		//do line 3 illegal push point
		String line3 = "";
		switch(_gb.getMoveableTileArray().get(0).getLastTileNum()){
		case 1:
			line3 = "9";
			break;
		case 3:
			line3 = "8";
			break;
		case 5:
			line3 = "7";
			break;
		case 7:
			line3 = "4";
			break;
		case 13:
			line3 = "12";
			break;
		case 21:
			line3 = "5";
			break;
		case 27:
			line3 = "11";
			break;
		case 35:
			line3 = "6";
			break;
		case 41:
			line3 = "10";
			break;
		case 43:
			line3 = "1";
			break;
		case 45:
			line3 = "2";
			break;
		case 47:
			line3 = "3";
			break;
		default:
			line3 = "-1";
			break;
		}
		
		
		
		System.out.println(line1);
		System.out.println(line2);
		System.out.println(line3);
		//end string creation.
		
		
		// write string to file
		String newLine = System.getProperty("line.separator");
		
		code.fileIO.FileIO.writeStringToFile("126SavedGame.mls", line1 +newLine+ line2 +newLine+ line3);
		
		
		//close window
		System.exit(1);
		
	}
	
}
