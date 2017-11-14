import java.util.Arrays;

public class Stack {
	
	private String[] stackArray;
	private int stackSize;
	private int topOfStack=-1;
	
	Stack(int size){
		stackSize = size;
		stackArray = new String[size];
		Arrays.fill(stackArray, "-1");
	}
	public void push(String input){
		if(topOfStack+1<stackSize){
			topOfStack++;
			stackArray[topOfStack]=input;
		}
		else
			System.out.println("TOo bad it's full");
	}
	
	public static void main(String[]args){
		Stack stack = new Stack(10);
		stack.push("hi");
	}

}
