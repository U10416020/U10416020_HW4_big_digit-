//U10416020

import java.util.*;

public class BigNumber{
	String number;
	ArrayList<Integer> list = new ArrayList<Integer>();
	
	BigNumber(String newNumber){
		number = newNumber;
		setList();
	}
	
	public void setList(){
		for(int i = number.length() - 1; i >= 0; i--){
			list.add((int)number.charAt(i)- 48);
		}
	}
}
