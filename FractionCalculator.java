//import java.util.Scanner;
import java.util.*;
public class FractionCalculator {

	//private static int calc = 0;
	private static String str = null;
	private static Fraction memory = new Fraction (0, 1);
	private static Fraction answer = new Fraction (0, 1);

	
	public static void main(String[] args) {
		launchBanner();
		launchCalc();
	}
	//welcome banner
		public static void launchBanner() {
		System.out.println("Welcome to James Thornton's fraction calculator");
		System.out.println("to use enter fractions using the / operator without a space eg. a/b");
		System.out.println("and place a space in between fractions and operators");
		System.out.println("fractions greater than 1 must be entered as improper fractions not mixed numbers");
		System.out.println("this calculator evaluates sums in the order that you enter them");
		System.out.println(answer);
		}
	//Main calculator		
	public static void launchCalc() {
		try {
			Scanner input = new Scanner(System.in);
			str = input.nextLine();
		
			//Splits the input into sections
			String[] splitInput = str.split("\\s");
		
			//Calculates the number of operations needed
			int noOfCalculations = (splitInput.length -1)/2;
			
			//exit clause
			if (!splitInput[0].equals("q") && !splitInput[0].equals("Q") && !splitInput[0].equals("quit")) {
				// runs negate absolute and clear functions and deals with single fraction input
				if (splitInput[0].equals("n") || splitInput[0].equals("N") || splitInput[0].equals("neg")) {
					answer = answer.negate();
					System.out.println(answer);
				} else if (splitInput[0].equals("a") || splitInput[0].equals("A") || splitInput[0].equals("abs")) {
					answer = answer.absValue();
					System.out.println(answer);
				} else if (splitInput[0].equals("c") || splitInput[0].equals("C") || splitInput[0].equals("clear")) {
					clear(answer);
					System.out.println(answer);
				} else if (splitInput[0].equals("")) {
				} else if (splitInput.length == 1) {
					answer = calculation(splitInput);
				}
				
				//Deals with functions that use an operator and a fraction
				if (splitInput.length == 2){
					answer = calculation(splitInput);
				} 
				//Deals with functions that have more than one operator eg. 2 + 3 * 5
				if (splitInput.length > 2){ 
					for (int i = 0; i < noOfCalculations; i++) {
						if (i == 0) {
							String[] subArray = Arrays.copyOfRange(splitInput, 2*i, 2*i+3);
							answer = calculation(subArray);
							Memory(answer);
						} 
						if (i > 0) {
							String[] subArray = {memory.toString(), splitInput[2*i+1], splitInput[2*i+2]};
							answer = calculation(subArray);
							Memory(answer);
						}
					}		
				}		
			System.out.println(answer);
			launchCalc();
			}
			//Exit banner
			if (splitInput[0].equals("q") || splitInput[0].equals("Q") || splitInput[0].equals("quit")) {
				System.out.println("Goodbye");
			}
		}
		//error catchers
		catch(NumberFormatException ex){ 
			System.out.println("Error");
			clear(answer);
			System.out.println(answer);
			launchCalc();
		}
		catch(ArrayIndexOutOfBoundsException ex){ 
			System.out.println("Error");
			clear(answer);
			System.out.println(answer);
			launchCalc();
		}
	}
	//method to set memory
	public static Fraction Memory(Fraction mem) {
		memory = mem;
		return memory;
	}
	//returns a new fraction from an integer or a fraction
	public static Fraction fractionMaker(String s) {
		String[] splitFraction = s.split("/");
		if (splitFraction.length == 1) {
			int a = Integer.parseInt(splitFraction[0]);
			int b = 1;
			Fraction f = new Fraction(a,b);
			return f;
		}
		int a = Integer.parseInt(splitFraction[0]);
		int b = Integer.parseInt(splitFraction[1]);
		Fraction f = new Fraction(a,b);
		return f;
	}
	//Performs a calculation based on receiving either a fraction or a fraction and an operator or 2 fractions and an operator 
	public static Fraction calculation(String[] splitInput) {
		if (splitInput.length == 0) {
			answer = memory;
			return answer;
		}
		if (splitInput.length == 1) {
			answer = fractionMaker(splitInput[0]);
			return answer;
		}
		if (splitInput.length == 2) {
			for (int i = 0; i < splitInput.length; i++) {
				if (splitInput[i].length() == 1 && splitInput[i].equals("/")) {
					answer = memory.divide(fractionMaker(splitInput[i+1]));
					return answer;
				}
				else if (splitInput[i].equals("*")) {
					answer = memory.multiply(fractionMaker(splitInput[i+1]));
					return answer;
				}
				else if (splitInput[i].equals("+")) {
					answer = memory.add(fractionMaker(splitInput[i+1]));
					return answer;
				}
				else if (splitInput[i].equals("-")) {
					answer = memory.subtract(fractionMaker(splitInput[i+1]));
					return answer;
				}
			}
		} 
		if (splitInput.length == 3) {
			for (int i = 0; i < splitInput.length; i++) {
				if (splitInput[i].length() == 1 && splitInput[i].equals("/")) {
					answer = fractionMaker(splitInput[i-1]).divide(fractionMaker(splitInput[i+1]));
					return answer;
				}
				else if (splitInput[i].equals("*")) {
					answer = fractionMaker(splitInput[i-1]).multiply(fractionMaker(splitInput[i+1]));
					return answer;
				}
				else if (splitInput[i].equals("+")) {
					answer = fractionMaker(splitInput[i-1]).add(fractionMaker(splitInput[i+1]));
					return answer;
				}
				else if (splitInput[i].equals("-")) {
					answer = fractionMaker(splitInput[i-1]).subtract(fractionMaker(splitInput[i+1]));
					return answer;
				}
			}
		}
	Fraction f = new Fraction(0,1);
	return f;
	}
	//method to clear calculator and memory
	public static void clear(Fraction a) {
		a.setNumerator(0);
		a.setDenominator(1);
		memory.setNumerator(0);
		memory.setDenominator(1);
	}
}