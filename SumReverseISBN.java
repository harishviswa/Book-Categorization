/**
 * SumReverseISBN lab
 * Name: Harish Viswa
 * 
 * Describe any assistance you received from a parent or classmate when implementing this lab.
 *	Worked with Anwith and Anshul during class
 **/

import java.util.Scanner; //Scanner import


public class SumReverseISBN {
   
   /**
	 * sum all the digits within a number  
	 * @param num 
	 */
   private static int sumDigits(int num) {
	 //creation of sum variable to store later on
     int sum = 0; 
     //while to make sure positive value
     while(num > 0) {
    	 //reassigning sum value
    	 sum = sum + num % 10;
    	 num = num/10;
     }
      return sum;
   }
   
   /**
	 * reverse the digits within a number  
	 * @param num 
	 */
   private static int reverseDigits(int num) {
	  //creation of reversed variable to store for later use
	  int reversed = 0;
	  while(num > 0) {
		  // to pull out digit specifically
		  int digit = num % 10;
		  //reassigning value of reversed
		 reversed = reversed *10 + digit;
		 num /= 10;
	  }
	  
	  return reversed;
		  
	  }
      
   
   /**
	 * compute and return the full ISBN number 
	 * @param isbn 
	 */
   private static String computeISBN10(int num) {
	   
	   //creation of variables for later use
	   int sum = 0;
	   int multiple = 9;
	   int digit = num;
	   int num2 = num;
	   //length of ISBN
	   for(int i = 0; i < 9; i++) {
		   //working backwards through ISBN
		   digit = num2 % 10;
		   sum = sum + (digit * multiple);
		   num2 = num2 / 10;
		   multiple--;
	   }
	   
	   //checkSum math
	   int checkSum = sum;
	   checkSum = checkSum % 11;
	   String number = "";
	   //assigning X for the value of 10
	   if(checkSum == 10) {
		   number = num + "-" + "X";
	   } else {
	   
	   number = num + "-" + checkSum;
	   
	   }
	   
      return number;
   }
   
   /**
	 * verify the full ISBN number 
	 * @param isbn 
	 */
   private static String verifyISBN(String isbn) {
	  //storing ISBN before the hyphen in a variable
	 String fullISBN = isbn.substring(0, isbn.length() -2);
	 //converting string to integer
	int integer = Integer.parseInt(fullISBN);
	//pulling last digit of ISBN
	 char lastISBN = isbn.charAt(isbn.length()-1);
//converting char to int for later testing of validity
	 int lastISBNInt = Integer.parseInt(String.valueOf(lastISBN));  
	 
	 //same ISBN math logic as previous method
	 int sum = 0;
	 int num = integer;
	   int multiple = 9;
	   int digit = num;
	   int num2 = num;
	   for(int i = 0; i < 9; i++) {
		   digit = num2 % 10;
		   sum = sum + (digit * multiple);
		   num2 = num2 / 10;
		   multiple--;
	   }
	   
	   int checkSum = sum;
	   checkSum = checkSum % 11;
	   
	   //verifying if calculated checkSum matches the provided
	   if(checkSum == lastISBNInt) {
		   return "Valid ISBN";
	   } else {
		   return "Invalid ISBN";
	   }
	  
   }
   
  
   //read input with Scanner and test methods 
   public static void main(String[] args) {
	   //Test part 1 sum/reverse here
	   Scanner s = new Scanner(System.in);
	   for(int i = 0; i < 5; i++) {
	   System.out.println("Please Enter A Number: ");
	   int input = s.nextInt();
	   System.out.println("Integer: " + input);
	   int x = sumDigits(input);
	   System.out.println("Sum: " + x);
	   int y = reverseDigits(input);
	   System.out.println("Reverse: " + y);
	   }
	   //Test part 2 ISBN here
       System.out.println("Please Enter A Number: ");
       int input2 = s.nextInt();
       String ISBN = computeISBN10(input2);
       System.out.println("ISBN Number: " + ISBN);
       //test part 3 extension verifyISBN
	   System.out.println("Please Enter A Full ISBN Number: ");
	   Scanner s2 = new Scanner(System.in);
	   String input3 = s2.nextLine();
	   String isbnTest = verifyISBN(input3);
	   System.out.println(isbnTest);
   }
}