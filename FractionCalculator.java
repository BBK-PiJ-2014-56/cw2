//import java.util.Scanner;
import java.util.*;
public class FractionCalculator {

	private static int calc = 0;
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
		System.out.println(calc);
	}
	//Main calculator		
	public static void launchCalc() {
		
        Scanner input = new Scanner(System.in);
		str = input.nextLine();
		
		//Splits the input into sections
		String[] splitInput = str.split("\\s");
		
		//Calculates the number of operations needed
		int noOfCalculations = (splitInput.length -1)/2;
		
		//exit clause
		if (!splitInput[0].equals("q") && !splitInput[0].equals("Q") && !splitInput[0].equals("quit")) {
			
			if (splitInput[0].equals("n") || splitInput[0].equals("N") || splitInput[0].equals("neg")) {
				answer = answer.negate();
			}
			if (splitInput[0].equals("a") || splitInput[0].equals("A") || splitInput[0].equals("abs")) {
				answer = answer.absValue();
			}
			if (splitInput[0].equals("c") || splitInput[0].equals("C") || splitInput[0].equals("clear")) {
				clear(answer);
			}
			//if the function is missing an operator or has the wrong length
			if ((splitInput.length -1)%2 != 0){ //|| !splitInput[1].equals("+") || !splitInput[1].equals("-") || !splitInput[1].equals("*") || !splitInput[1].equals("/")) {
				System.out.println("Error");
				clear(answer);
				System.out.println(answer);
			} else {
				for (int i = 0; i < noOfCalculations; i++) {
					if (i == 0) {
						String[] subArray = Arrays.copyOfRange(splitInput, 2*i, 2*i+3);
						answer = calculation(subArray);
					} else {
						String[] subArray = {memory.toString(), splitInput[2*i-1], splitInput[2*i+2]};
						answer = calculation(subArray);
					}
				}
			Memory(answer);
			System.out.println(answer);
			
			}
		launchCalc();
		}
		if (splitInput[0].equals("q") || splitInput[0].equals("Q") || splitInput[0].equals("quit")) {
			System.out.println("Goodbye");
		}
	}
	public static Fraction Memory(Fraction mem) {
		memory = mem;
		return memory;
	}
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
	public static Fraction calculation(String[] splitInput) {
		for (int i = 0; i < splitInput.length; i++) {
			if (splitInput[i].length() == 1 && splitInput[i].equals("/")) {
				Fraction answer = fractionMaker(splitInput[i-1]).divide(fractionMaker(splitInput[i+1]));
				return answer;
			}
			else if (splitInput[i].equals("*")) {
				Fraction answer = fractionMaker(splitInput[i-1]).multiply(fractionMaker(splitInput[i+1]));
				return answer;
			}
			else if (splitInput[i].equals("+")) {
				Fraction answer = fractionMaker(splitInput[i-1]).add(fractionMaker(splitInput[i+1]));
				return answer;
			}
			else if (splitInput[i].equals("-")) {
				Fraction answer = fractionMaker(splitInput[i-1]).subtract(fractionMaker(splitInput[i+1]));
				return answer;
			}
		}
	Fraction f = new Fraction(0,1);
	return f;
	}
	public static void clear(Fraction a) {
		a.setNumerator(0);
		a.setDenominator(1);
	}
}