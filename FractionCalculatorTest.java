 import java.util.Scanner;
 
 public class FractionCalculatorTest {
	public static void main(String[] args) {
		
		FractionCalculator CalcTest = new FractionCalculator();
		Fraction testFraction1 = new Fraction(1,2);
		Fraction testFraction2 = new Fraction(1,3);
		
		//tests if calculator works with 1 operation
		
		String addtest1 = "1/2 + 1/3"; 
		Fraction addtestanswer1 = new Fraction(5,6);
		test(CalcTest.launchcalculator(addtest1), addtestanswer1,"error test 1");

		//tests if calculator works with 2 operations
				
		String addtest2 = "1/2 + 1/3 * 2"; 
		Fraction addtestanswer2 = new Fraction(10,6);
		test(CalcTest.launchcalculator(addtest2), addtestanswer2,"error test 2");

		//tests if calculator works with 3 operations
		
		String addtest3 = "1/2 + 1/3 * 2 / 3"; 
		Fraction addtestanswer3 = new Fraction(5,9);
		test(CalcTest.launchcalculator(addtest3), addtestanswer3,"error test 3");
		
		//tests memory + fraction
		String addtest4 = "+ 1/3"; 
		Fraction addtestanswer4 = new Fraction(8,9);
		test(CalcTest.launchcalculator(addtest4), addtestanswer4,"error test 4");
		
		//tests memory + 2 fractions
		String addtest5 = "+ 1/3 + 1/2"; 
		Fraction addtestanswer5 = new Fraction(31,18);
		test(CalcTest.launchcalculator(addtest5), addtestanswer5,"error test 5");
		
		//tests negate
		String negatetest = "n"; 
		Fraction negateanswer = new Fraction(-31,18);
		test(CalcTest.launchcalculator(negatetest), negateanswer,"error negate");

		//tests absolute
		String absolutetest5 = "a"; 
		test(CalcTest.launchcalculator(absolutetest5), addtestanswer5,"error absolute");

		//tests clear
		String cleartest = "c"; 
		Fraction clearanswer = new Fraction(0,1);		
		test(CalcTest.launchcalculator(cleartest), clearanswer,"error clear");
		
		//tests - fraction
		String subtracttest1 = "1/2 - 1/3"; 
		Fraction subtracttestanswer1 = new Fraction(1,6);
		test(CalcTest.launchcalculator(subtracttest1), subtracttestanswer1,"error subtract test");
		
		//tests * fraction
		String multiplytest1 = "1/2 * 1/3"; 
		Fraction multiplytestanswer1 = new Fraction(1,6);
		test(CalcTest.launchcalculator(multiplytest1), multiplytestanswer1,"error multiply test");
		
		//tests / fraction
		String dividetest1 = "1/2 / 1/3"; 
		Fraction dividetestanswer1 = new Fraction(3,2);
		test(CalcTest.launchcalculator(dividetest1), dividetestanswer1,"error divide test");
		
		//tests evaluatemethod
		Fraction evaluatetestfrac = new Fraction(1,2);
		String evaluatetest1 = "/ 1/3"; 
		Fraction evaluatetestanswer = new Fraction(3,2);
		test(CalcTest.evaluate(evaluatetestfrac, evaluatetest1), evaluatetestanswer,"error evaluate test");
	}
	
    static void test(Fraction f1, Fraction f2, String msg){
    	if (!f1.equals(f2))
		System.out.println(msg);
    }
}