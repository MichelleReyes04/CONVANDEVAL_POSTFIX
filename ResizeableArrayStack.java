package Project2;
import java.util.Arrays;
import java.util.*;

public final class ResizeableArrayStack<T> implements StackInterface<T>{
	private T[] stack;    
	 private int topIndex; 
	 private boolean integrityOK = false;
	 private static final int DEFAULT_CAPACITY = 50;
	  
	 private void checkIntegrity() { //check if there is an array 
		 if(!integrityOK)
		 throw new SecurityException("Array is corrupt.");
		 }
		
	 public ResizeableArrayStack()
	 {
		 integrityOK = false;

		 @SuppressWarnings("unchecked")
		 T[] tempStack = (T[])new Object[DEFAULT_CAPACITY];
		 stack = tempStack;
		 topIndex = -1;
		 integrityOK = true;
		 }
	 
	  public ResizeableArrayStack(int initialCapacity)
	 {
		  integrityOK = false;
		  @SuppressWarnings("unchecked")
		  T[] tempStack1 = (T[])new Object[initialCapacity];
		  stack = tempStack1;
		  topIndex = -1;
		  integrityOK = true;
		  
	 }
	  private void ensureCapacity()
	  {
	  if (topIndex >= stack.length- 1) // If array is full, double its size
	  {
	  int newLength = 2 * stack.length;
	  
	  stack = Arrays.copyOf(stack, newLength);
	  } 
	  }
	  
	 public void push(T newEntry) {
		 checkIntegrity();
		 ensureCapacity();
		 stack[topIndex + 1] = newEntry;
		 topIndex++;
	}
	
	public T pop() {
		 checkIntegrity();
		 if (isEmpty())
		 throw new EmptyStackException();
		 else
		 {
		 T goingTop = stack[topIndex];
		 stack[topIndex] = null;
		 topIndex--;
		 return goingTop;
		 }
	}
	
	
	public T peek() {
		 checkIntegrity();
		 if (isEmpty())
		 throw new EmptyStackException();
		 else
		 return stack[topIndex];
	}

	public boolean isEmpty() {
		return topIndex< 0;
	}

	public void clear() {
		 checkIntegrity();
		 
		 while(topIndex> -1)
		 {
		 stack[topIndex] = null;
		 topIndex--;
		 }
		
	}
	
	 
	 
	 
	 
	 
}
