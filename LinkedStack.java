package Project2;
import java.util.*;

	public class LinkedStack<T> implements StackInterface<T>{

		private Node topNode; //the first node in the chain
		
		public LinkedStack() {
			topNode = null;
		}
		
		public void push(T newEntry) { //NewNode becomes the firstNode
		Node newNode = new Node(newEntry, topNode);
		topNode = newNode;
		}
		
		public T pop() {
		T top = peek(); // Might throw EmptyStackException
		
		if(topNode != null) { //idk about this one
		topNode = topNode.getNextNode();
		}
		
		return top;
		} 
		
		public T peek() {
		if (isEmpty()) {
		throw new EmptyStackException();
		}
		else {
		return topNode.getData();
		}
		} 
		
		public boolean isEmpty() {
		return topNode == null;
		} // end isEmpty
		
		public void clear() {
		topNode = null;
		}
		
		private class Node{
			private T data; //entry in stack 
			private Node next; //link to next node
		
			 private Node(T dataPortion)  {
			        this(dataPortion, null);
			     } 

			     private Node(T dataPortion, Node nextNode)
			     {
			        data = dataPortion;
			        next = nextNode;
			     } 
			     
			     private void setData(T newData) {
			    	 data = newData;
			     }
			    
			     private T getData() {
			    	 return data;
			     }
			     
			     private void setNextNode(Node nextNode) {
			    	 next = nextNode;
			     }
			     private Node getNextNode() {
			    	 return next;
			     }

		}
		
	
	}



