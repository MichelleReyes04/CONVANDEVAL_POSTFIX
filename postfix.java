package Project2;


public class Postfix{

	 static int getPrecedence(char object)
	{
    switch(object) {
		case '+': case '-':
	   return 1;
case '*': case '/':
	   return 2;
	  case '^':
	  return 3;	  
	  default:
			return 0;

	}
		}

	public static String convertToPostfix(String inflix) {
		
		ResizeableArrayStack <Character> operatorStack = new ResizeableArrayStack<>();
		StringBuilder postfix = new StringBuilder();
		
	    
	    int i=0;
	 while(i<inflix.length()){
	    	char nextCharacter = inflix.charAt(i);
	    	
	    	if(Character.isLetter(nextCharacter)) {
	    		postfix.append(nextCharacter);	
	    	}
	    	else {
	    	switch(nextCharacter) {
	   
	    	case '^':
	    		operatorStack.push(nextCharacter);
	        break;
	        
	    	case '+' : case '-' : case '*' : case '/' :  
		
	    	 while (!operatorStack.isEmpty() && 
	    			 getPrecedence(nextCharacter) <=  getPrecedence(operatorStack.peek())){
	    		postfix.append(operatorStack.peek());
	                operatorStack.pop();
	             }
	    	 operatorStack.push(nextCharacter);   // i thought this would fill up the case 
	             break;
	             
	    	
	        
	    case '(':
	    	operatorStack.push(nextCharacter);
	         break; 
	         
	    case ')' : 
	    	   char topOperator = operatorStack.pop();
	           while (topOperator != '('){
	           postfix.append(topOperator); 
	            topOperator = operatorStack.pop();
	         }
	         break;
	         
	    default:
	    	  postfix.append(nextCharacter);
	    	  break; 
	  	 
	   }
   	
	 }
	 i++;   	
	}
	 
	 while(!operatorStack.isEmpty()) {
         postfix.append(operatorStack.pop());
	 }   	
	 
		return postfix.toString();
		   
	}    	
	 
	//start of evaluatePostfix	
	
	static int operations(char result, int data1, int data2) {
	
		switch(result) {
		case '+':
		return data1+data2;	
		
		case '-':
	    return data1-data2;
	    
		case '/':
		return data1/data2;
		
		case '*':
	    return data1*data2;
	    
		case '^':
		return (int) Math.pow(data1, data2);
	    
		default:return -1;
		}
	
	}
	
	public static int evaluatePostfix(String postfix) {
		LinkedStack <Integer> valueStack = new LinkedStack<>();
		
		int i =0;
		int operandOne;
		int operandTwo;
	
		
		while(i < postfix.length()) {
			char nextCharacter = postfix.charAt(i);
			if(Character.isDigit(nextCharacter) ) {
	    		valueStack.push(Character.getNumericValue(nextCharacter));
	    	}
		
			else {
			switch(nextCharacter) {
			
			case '+' : case '-' : case '*' : case '/' : case '^' :
			 operandTwo = valueStack.pop();
			 operandOne = valueStack.pop();
			     
			int result=	operations(nextCharacter,operandOne,operandTwo);
			     
				   valueStack.push(result);
		
				break;
			
			case 'h':
				valueStack.push(72);
				
				default:break;
				
			}
		}
			i++;
	}
		return valueStack.peek();
	}
	
}


