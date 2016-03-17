//U10416020

import java.util.*;

public class TestBigNumber{
	//Main method
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		
		//Let user enter two number
		System.out.println("Enter two big number: ");		
		String number1 = input.next();
		String number2 = input.next();		
		
		//Create a object of BigNumber
		BigNumber test = new BigNumber(number1,number2);
		
		//Print the result
		System.out.println("Number: " + test.getPrint());
	}
}