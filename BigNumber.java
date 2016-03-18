//U10416020

import java.util.*;
import java.lang.*;

public class BigNumber{
	//Data field
	String print = "";
	int length_N1, length_N2, length_min;
	ArrayList<Integer> list1 = new ArrayList<Integer>();
	ArrayList<Integer> list2 = new ArrayList<Integer>();
	ArrayList<Integer> plus = new ArrayList<Integer>();
	
	//Constructor
	BigNumber(String newNumber1, String newNumber2){		
		setList(newNumber1, newNumber2);
		setLength_min();
		calculatePlus();
	}
	
	//Mutator method to set array list
	public void setList(String number1, String number2){
		for(int i = number1.length() - 1; i >= 0; i--){
			list1.add((int)number1.charAt(i)- 48);
		}
		
		for(int i = number2.length() - 1; i >= 0; i--){
			list2.add((int)number2.charAt(i)- 48);
		}		
	}
	
	//Mutator method to set length_min 
	public void setLength_min(){
		length_N1 = list1.size();
		length_N2 = list2.size();
		if(length_N1<length_N2)
			length_min = length_N1;
		else
			length_min = length_N2;
	}
	
	//Method to plus two numbers
	public void calculatePlus(){
		int carry = 0, digit_N1, digit_N2;
		for(int i = 0; i < length_min; i++){
			digit_N1 = list1.get(i);
			digit_N2 = list2.get(i);
			plus.add((digit_N1+digit_N2+carry) % 10);
			if((digit_N1+digit_N2+carry) / 10 == 1)
				carry = 1;
			else
				carry = 0;
		}		
		if(length_N1 > length_N2 && carry == 1){
			digit_N1 = list1.get(length_min) + carry;
			plus.add(digit_N1 % 10);
			if(digit_N1 / 10 == 1)
				carry = 1;
			else
				carry = 0;
			for(int i = length_min + 1; i < length_N1; i++){
				digit_N1 = list1.get(i) + carry;
				plus.add(digit_N1 % 10);
				if(digit_N1 / 10 == 1)
					carry = 1;
				else
					carry = 0;
			}
		}
		else if(length_N2 > length_N1 && carry == 1){
			digit_N2 = list2.get(length_min) + carry;
			plus.add(digit_N2 % 10);
			if(digit_N2 / 10 == 1)
				carry = 1;
			else
				carry = 0;
			for(int i = length_min + 1; i < length_N2; i++){
				digit_N2 = list2.get(i);
				plus.add(digit_N2 % 10);
				if(digit_N2 / 10 == 1)
					carry = 1;
				else
					carry = 0;
			}
			
		}
		if(carry == 1)
			plus.add(carry);			
	}
	
	//Accessor method to return print
	public String getPrint(){		
		for(int i = plus.size()-1; i >=0; i--){
			print += String.valueOf(plus.get(i));
		}
		
		return print;		
	}	
}
