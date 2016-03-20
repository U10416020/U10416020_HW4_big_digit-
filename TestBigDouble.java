//U10416020

import java.util.*;

public class TestBigDouble{
	//Main method
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		
		//Prompt user to enter doubles
		System.out.println("Enter two big number: ");
		String num1 = input.next();
		String num2 = input.next();
		
		//Create a object of BigDouble
		BigDouble test = new BigDouble(num1, num2);
		
		//Print the result
		System.out.println(test.getPrint());		
	}
}