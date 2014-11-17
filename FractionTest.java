/**
 * Created by keith for the second coursework assignment.
 */
public class FractionTest {
    public static void main(String[] args) {

        // test divide by zero - should print an error and exit
        new Fraction(1, 0);
        // test multiply
	Fraction f = new Fraction(6,20);
	Fraction g = new Fraction(1,2);
	Fraction h = new Fraction(3,5);
	Fraction i = new Fraction(4,5);
	Fraction j = new Fraction(1,5);
	Fraction k = new Fraction(1, -3);
	Fraction l = new Fraction(-1, 2);
	Fraction m = new Fraction(-1, -2);
	if (!f.equals(g.multiply(h))) System.out.println("Multiply failed");
        // test equals
	test(new Fraction(1, 2),new Fraction(1, 2),"error test 1");
	test(new Fraction(1, 2),new Fraction(3, 6),"error test 2");
	test(new Fraction(-1, 2),new Fraction(1, -2),"error test 3");
	test(new Fraction(-1, -2),new Fraction(1, 2),"error test 4");
	test(new Fraction(4, -8),new Fraction(1, 2),"error test 5");

        // test divide
	if (!h.equals(f.divide(g))) System.out.println("divide failed");
    
    
        // test add
	if (!i.equals(f.add(g))) System.out.println("add failed");
    

	    // test subtract
	if (!j.equals(g.subtract(f))) System.out.println("subtract failed");
    
    
		// test add
	if (!i.equals(f.add(g))) System.out.println("add failed");
	
		//test absValue
	test(f, f.absValue(), "absolute test 1 failed");
	test(k, k.absValue(), "absolute test 2 failed");
	test(l, l.absValue(), "absolute test 3 failed");
	test(m, m.absValue(), "absolute test 4 failed");
	k.absValue();
	l.absValue();
	m.absValue();
	
		//test negate
	f.negate();
	k.negate();
	l.negate();
	m.negate();

	}

    static void test(Fraction f1, Fraction f2, String msg){
    	if (! f1.equals(f2))
		System.out.println(msg);
    }
}
