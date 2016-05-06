package code.model;

import java.util.ArrayList;
import java.util.Random;

public class PlayerFormulaCard {

	private ArrayList<Integer> ingrediant = new ArrayList<Integer>();

	public PlayerFormulaCard(){
		ArrayList<Integer> output = new ArrayList<Integer>();

		for(int i=1;i<=20;i++){
			output.add(i);
		}
		output.add(25);

		Random rand = new Random();

		for(int j=1;j<=3;j++){
			ingrediant.add(output.remove(rand.nextInt(output.size())));
		}
	}
	
	public PlayerFormulaCard(int one,int two, int three){
		ingrediant.add(one);
		ingrediant.add(two);
		ingrediant.add(three);
		
	}
	
	public int getNum1(){
		return ingrediant.get(0);
	}
	
	public int getNum2(){
		return ingrediant.get(1);
	}
	
	public int getNum3(){
		return ingrediant.get(2);
	}
	
	public String allNumbers(){
		return "["+ingrediant.get(0)+","+ingrediant.get(1)+","+ingrediant.get(2)+"]";
	}
	
}
