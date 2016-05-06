package code.fileIO;

public class StringParser {
	
	private String _string;
	private int _curObjLocation;
	
	public StringParser(String s){
		_string = s;
		_curObjLocation = 0;
	}
	/**
	 * this moves the pointer to the next object in the filestring.
	 * The pointer will be at the '[' open bracket location.
	 */
	public void moveToNextObject(){
		int bracketCount = 1;
		int templocation = _curObjLocation+1;
		while(bracketCount>0){
			if(_string.charAt(templocation)=='['){
				bracketCount++;
			}else if(_string.charAt(templocation)==']'){
				bracketCount--;
			}
			templocation++;
		}
		_curObjLocation = templocation;
	}
	
	
	
	
}
