 import java.util.Scanner;
 
 public class FractionCalculatorTest {
	public static void main(String[] args) {
		
		FractionCalculator CalcTest = new FractionCalculator();
		Fraction testFraction1 = new Fraction(1,2);
		Fraction testFraction2 = new Fraction(1,3);
		
		//tests if calculator works with 1 operation
		
		String[] addtest1 = {"1/2","+","1/3"}; 
		Fraction addtestanswer1 = new Fraction(5,6);
		test(CalcTest.calculation(addtest1) ,addtestanswer1,"error test 1");

		//tests if calculator works with 2 operations
		
		String[] addtest2 = {"1/2","+","1/3","*","2"}; 
		Fraction addtestanswer2 = new Fraction(5,3);
		test(CalcTest.calculation(addtest2) ,addtestanswer2,"error test 2");

		//tests if calculator works with 3 operations
		
		String[] addtest = {"1/2","+","1/3","*","2","/","3"}; 
		Fraction addtestanswer = new Fraction(5,2);
		test(CalcTest.calculation(addtest) ,addtestanswer,"error test 3");

		//question = "1/3 + 1/2";
		//Fraction a = new Fraction(5, 6);
		
		//a = FractionCalculator clear(a);
		//System.out.println(a);
		
		System.out.println(CalcTest.calculation(addtest1));
		
		
		//test for correct input
		/*testInput = "4/5 + 2/3";
		Fraction a = new Fraction(22,15);
		if(!FTtest.evaluate(testValue,testInput).equals(a)) System.out.println("Evaluation failed");
		*/
		
		//launchCalc();
		//FractionCalculator fractionMaker(1/2);
		//test(question.launchCalc(),a,"error test 1");
	}
	
    static void test(Fraction f1, Fraction f2, String msg){
    	if (!f1.equals(f2))
		System.out.println(msg);
    }
}