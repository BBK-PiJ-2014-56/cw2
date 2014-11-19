//import java.util.Scanner;
import java.util.*;
public class FractionCalculator {
	public static void main(String[] args) {
	
		int calc = 0;
		System.out.println(calc);
		String str = null;
        Scanner input = new Scanner(System.in);
		str = input.nextLine();
		String[] splitInput = str.split("\\s");
		int noOfCalculations = (splitInput.length -1)/2;
		System.out.println(noOfCalculations);
		for (int i = 0; i < noOfCalculations; i++) {
			if (i == 0) {
				calculation(splitInput);
			} else {
				String[] subArray = Arrays.copyOfRange(splitInput, 2*i, 2*i+3);
				calculation(subArray);
				//recursion...????
			}
		}

		
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
				System.out.println(answer);
				return answer;
			}
			else if (splitInput[i].equals("*")) {
				Fraction answer = fractionMaker(splitInput[i-1]).multiply(fractionMaker(splitInput[i+1]));
				System.out.println(answer);
				return answer;
			}
			else if (splitInput[i].equals("+")) {
				Fraction answer = fractionMaker(splitInput[i-1]).add(fractionMaker(splitInput[i+1]));
				System.out.println(answer);
				return answer;
			}
			else if (splitInput[i].equals("-")) {
				Fraction answer = fractionMaker(splitInput[i-1]).subtract(fractionMaker(splitInput[i+1]));
				System.out.println(answer);
				return answer;
			}
		}
	Fraction f = new Fraction(0,1);
	return f;
	}
}
//Integer.parseInt();
