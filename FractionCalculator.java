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
		Fraction memory = new Fraction (0, 1);
		for (int i = 0; i < noOfCalculations; i++) {
			if (i == 0) {
				String[] subArray = Arrays.copyOfRange(splitInput, 2*i, 2*i+3);
				memory = calculation(subArray);
			} else {
				String[] subArray = {memory.toString(), splitInput[2*i-1], splitInput[2*i+2]};
				memory = calculation(subArray);
			}
		}
	System.out.println(memory);
		
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
}