package Project2;

public class PostfixTestUsingLinkedStack {
	
	public static void main(String[] args) {	
	String result2 ="57*1+6*23^34*-1+/h-";
//since 72 is not single char, I manually put it in.
	System.out.println("Evaluate Postfix: ");
	System.out.println(Postfix.evaluatePostfix(result2));

	}

}
