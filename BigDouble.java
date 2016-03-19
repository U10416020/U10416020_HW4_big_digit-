//U10416020

import java.util.*;
import java.lang.*;

public class BigDouble{
	//Data field
	String print = "";
	int carry = 0;
	int point1,point2,before_point1,before_point2,after_point1,
	after_point2, after_point_min;
	
	ArrayList<String> list1 = new ArrayList<String>();
	ArrayList<String> list2 = new ArrayList<String>();
	ArrayList<String> plus = new ArrayList<String>();
	
	//Constructor
	BigDouble(String newNumber1, String newNumber2){
		setList(newNumber1, newNumber2);
		point1 = list1.indexOf(".");
		point2 = list2.indexOf(".");
		checkPoint();
		calculatePlus();
	}
	
	//Mutator method to set array list
	public void setList(String number1, String number2){
		for(int i = number1.length() - 1; i >= 0; i--){
			list1.add(String.valueOf(number1.charAt(i)));
		}
		for(int i = number2.length() - 1; i >= 0; i--){
			list2.add(String.valueOf(number2.charAt(i)));
		}
	}	
	
	//Method to check the digit before and after the point
	public void checkPoint(){		
		before_point1 = list1.size() - point1 - 1;
		before_point2 = list2.size() - point2 - 1;
		after_point1 = point1 - 1;
		after_point2 = point2 - 1;		
	}
	
	//Method to add two numbers
	public void calculatePlus(){
		//int carry = 0, 
		int a1, a2, list1_digit, list2_digit, b1, b2;
		
		//Check if the digit after point of number1 is more than the number2(ex:x.99 & x.1)
		if(after_point1 > after_point2){
			for(a1 = 0; a1 < (after_point1 - after_point2); a1++){
				plus.add(list1.get(a1));
			}
			for(a2 = 0; a2 <= after_point2;a2++){				
				list1_digit = Integer.valueOf(list1.get(a1+a2));
				list2_digit = Integer.valueOf(list2.get(a2));
				plus.add(String.valueOf((list1_digit+list2_digit+carry) % 10));
				if((list1_digit+list2_digit+carry) / 10 == 1)
					carry = 1;
				else
					carry = 0;
			}
			
			plus.add(".");
			
			//Check if the digit before point of number1 is more than the number2(ex:99.99 & 1.1)
			if(before_point1 > before_point2){
				b1 = a1;
				for(b2 = a2 + 1; b2 < list2.size();b2++){					
					list1_digit = Integer.valueOf(list1.get(b1 + b2));
					list2_digit = Integer.valueOf(list2.get(b2));
					plus.add(String.valueOf((list1_digit+list2_digit+carry) % 10));
					if((list1_digit+list2_digit+carry) / 10 == 1)
						carry = 1;
					else
						carry = 0;
				}
				for(b1 += b2; b1 < list1.size(); b1++){
					list1_digit = Integer.valueOf(list1.get(b1));
					plus.add(String.valueOf((list1_digit+carry) % 10));
					if((list1_digit+carry) / 10 == 1)
						carry = 1;
					else
						carry = 0;
				}
				if(carry == 1)
					plus.add(String.valueOf(1));
				
			}
			
			//Check if the digit before point of number2 is more than the number1(ex:9.99 & 11.1)
			else if(before_point2 > before_point1){
				b1 = a1;
				for(b2 = a2+1; b2 < (after_point1+before_point2); b2++){
					list1_digit = Integer.valueOf(list1.get(b1 + b2));
					list2_digit = Integer.valueOf(list2.get(b2));
					plus.add(String.valueOf((list1_digit+list2_digit+carry) % 10));
					if((list1_digit+list2_digit+carry) / 10 == 1)
						carry = 1;
					else
						carry = 0;
				}
				for(b2 = b2; b2 < before_point2;b2++){
					list2_digit = Integer.valueOf(list2.get(b2));
					plus.add(String.valueOf((list2_digit+carry) % 10));
					if((list2_digit+carry) / 10 == 1)
						carry = 1;
					else
						carry = 0;
				}
				if(carry == 1)
					plus.add(String.valueOf(1));
			}	
			
			//Check if the digit before point of two of number are the same(ex:9.99 & 1.1)
			else{
				b1 = a1;				
				for(b2 = a2+1; b2 < list2.size(); b2++){					
					list1_digit = Integer.valueOf(list1.get(b1 + b2));					
					list2_digit = Integer.valueOf(list2.get(b2));					
					plus.add(String.valueOf((list1_digit+list2_digit+carry) % 10));
					if((list1_digit+list2_digit+carry) / 10 == 1)
						carry = 1;
					else
						carry = 0;
				}
				if(carry == 1)
					plus.add(String.valueOf(1));
			}
		}
		
		//Check if the digit after point of number2 is more than the number1(ex:xx.9 & xx.11)
		else if(after_point2 > after_point1){
			for(a1 = 0; a1 < (after_point2-after_point1); a1++){
				plus.add(list2.get(a1));
			}
			System.out.println("A1: " + a1);
			for(a2 = 0; a2 <= after_point1; a2++){
				list1_digit = Integer.valueOf(list1.get(a2));
				list2_digit = Integer.valueOf(list2.get(a1+a2));
				plus.add(String.valueOf((list1_digit+list2_digit+carry)%10));
				if((list1_digit+list2_digit+carry)/10 == 1)
					carry = 1;
				else
					carry = 0;
			}
			
			plus.add(".");
			System.out.println("A2: " + a2);
			
			//Check if the digit before point of number1 is more than the number2(ex:99.9 & 1.11)
			if(before_point1 > before_point2){
				b1 = a1;
				for(b2 = a2+1; b2 < list2.size() - 1;b2++){						
					list1_digit = Integer.valueOf(list1.get(b2));					
					list2_digit = Integer.valueOf(list2.get(b1+b2));					
					plus.add(String.valueOf((list1_digit+list2_digit+carry) % 10));
					if((list1_digit+list2_digit+carry) / 10 == 1)
						carry = 1;
					else
						carry = 0;
				}
				for(b1 = b2; b1 < list1.size(); b1++){
					list1_digit = Integer.valueOf(list1.get(b1));
					plus.add(String.valueOf((list1_digit+carry) % 10));
					if((list1_digit+carry) / 10 == 1)
						carry = 1;
					else
						carry = 0;
				}
				if(carry == 1)
					plus.add(String.valueOf(1));
				
			}
			
			//Check if the digit before point of number2 is more than the number1(ex:9.99 & 11.1)
			else if(before_point2 > before_point1){
				b1 = a2;
				for(b2 = a1+1; b2 < list1.size(); b2++){
					System.out.println("B2: " + b2);
					list1_digit = Integer.valueOf(list1.get(b2));
					System.out.println("List1: " + list1_digit);
					list2_digit = Integer.valueOf(list2.get(b1+b2));
					System.out.println("List2: " + list2_digit);
					plus.add(String.valueOf((list1_digit+list2_digit+carry) % 10));
					if((list1_digit+list2_digit+carry) / 10 == 1)
						carry = 1;
					else
						carry = 0;
				}
				for(b2 += b1; b2 < list2.size();b2++){
					System.out.println("B2: " + b2);
					list2_digit = Integer.valueOf(list2.get(b2));
					plus.add(String.valueOf((list2_digit+carry) % 10));
					if((list2_digit+carry) / 10 == 1)
						carry = 1;
					else
						carry = 0;
				}
				if(carry == 1)
					plus.add(String.valueOf(1));
			}	
			
			//Check if the digit before point of two of number is the same(ex:9.99 & 1.1)
			else{
				b1 = a1;				
				for(b2 = a2+1; b2 < list1.size(); b2++){					
					list1_digit = Integer.valueOf(list1.get(b2));					
					list2_digit = Integer.valueOf(list2.get(b1+b2));					
					plus.add(String.valueOf((list1_digit+list2_digit+carry) % 10));
					if((list1_digit+list2_digit+carry) / 10 == 1)
						carry = 1;
					else
						carry = 0;
				}
				if(carry == 1)
					plus.add(String.valueOf(1));
			}
		}
		
		//Check if the digit after point of two of number are the same(ex:xx.9 & xx.1)
		else{
			for(a1 = 0; a1 <= after_point1; a1++){
				list1_digit = Integer.valueOf(list1.get(a1));
				list2_digit = Integer.valueOf(list2.get(a1));
				plus.add(String.valueOf((list1_digit+list2_digit+carry)%10));
				if((list1_digit+list2_digit+carry)/10 == 1)
					carry = 1;
				else
					carry = 0;
			}
			
			plus.add(".");
			
			//Check if the digit before point of number1 is more than the number2(ex:99.9 & 1.1)
			if(before_point1 > before_point2){
				for(b1 = a1+1; b1 < list2.size(); b1++){
					list1_digit = Integer.valueOf(list1.get(b1));
					list2_digit = Integer.valueOf(list2.get(b1));
					plus.add(String.valueOf((list1_digit+list2_digit+carry)%10));
					if((list1_digit+list2_digit+carry)/10 == 1)
						carry = 1;
					else
						carry = 0;
				}
				for(b1 = b1; b1 < list1.size();b1++){
					list1_digit = Integer.valueOf(list1.get(b1));
					plus.add(String.valueOf((list1_digit+carry)%10));
					if((list1_digit+carry)/10 == 1)
						carry = 1;
					else
						carry = 0;
				}
				if(carry == 1)
					plus.add(String.valueOf(1));
			}
			
			//Check if the digit before point of number2 is more than the number1(ex:9.9 & 11.1)
			else if(before_point2 > before_point1){
				for(b1 = a1+1; b1 < list1.size(); b1++){
					list1_digit = Integer.valueOf(list1.get(b1));
					list2_digit = Integer.valueOf(list2.get(b1));
					plus.add(String.valueOf((list1_digit+list2_digit+carry)%10));
					if((list1_digit+list2_digit+carry)/10 == 1)
						carry = 1;
					else
						carry = 0;
				}
				for(b1 = b1; b1 < list2.size();b1++){
					list2_digit = Integer.valueOf(list2.get(b1));
					plus.add(String.valueOf((list2_digit+carry)%10));
					if((list2_digit+carry)/10 == 1)
						carry = 1;
					else
						carry = 0;
				}
				if(carry == 1)
					plus.add(String.valueOf(1));
			}
			
			//Check if the digit before point of two of the numbers are tha same(ex:9.9 & 1.1)
			else
				for(b1 = a1+1; b1 < list1.size();b1++){
					list1_digit = Integer.valueOf(list1.get(b1));
					list2_digit = Integer.valueOf(list2.get(b1));
					plus.add(String.valueOf((list1_digit+list2_digit+carry)%10));
					if((list1_digit+list2_digit+carry)/10 == 1)
						carry = 1;
					else
						carry = 0;
				}
				if(carry == 1)
					plus.add(String.valueOf(1));
		}		
	}	

	//Accessor method to return result
	public String getPrint(){
		for(int i = plus.size()-1; i >= 0; i--){
			print += plus.get(i);
		}
		return print;
	}
}