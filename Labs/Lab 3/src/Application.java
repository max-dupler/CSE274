
/////  Copyright: The codes in this file are prepared for the students of CSE 274 using the content of the following textbook:

////   Data Structures and Algorithms in Java, 2nd Edition by Robert Lafore

////   The codes in this file are shared with the students of CSE 274 course by the instructor of the course,

////   so that students use the codes for learning purpose. 

////   Accordingly, the instructor of the course is not in a position to give a permission to the students

////   to use these codes for any other purposes, such as sharing the codes with other individuals.    

import java.io.*;




class Stack<unknown> {
	  
	  private  int maxSize;

	  private unknown [] StackArray;
	  
	  private int top;

	  public Stack(int s) {
	    maxSize = s;
	    top = -1;

	     StackArray = (unknown[]) new Object[maxSize];
	  }


public void push(unknown c) {
    StackArray[++top] = c;
}

public unknown pop() {
    
    return StackArray[top--];
}

public boolean isFull() {
    return top == maxSize - 1;
}

public boolean isEmpty() {
    return top == -1;
}
}
 
class StackC

{

private int maxSize;

private char[] stackArray;

private int top;


public StackC(int s)

{

maxSize = s;

stackArray = new char[maxSize];

top = -1;

}


public void push(char j)

{

top=top+1;
stackArray[top] = j;

}


public char pop()

{

char temp = stackArray[top];
top=top-1;
return temp;

}



public boolean isEmpty()

{

return (top == -1);

}


}



class ExpressionChecker

{

private String input;




public ExpressionChecker(String in)

{ input = in; }


public boolean check()

{

int stackSize = input.length();

//StackC theStack = new StackC(stackSize); //(code from first part for non generic stack)

Stack<Character> theStack = new Stack<Character> (stackSize);



for(int j=0; j<input.length(); j++)

{

char ch = input.charAt(j);




if (ch=='{')
theStack.push(ch);


if (ch=='[')
theStack.push(ch);

if (ch=='(')
theStack.push(ch);




if (ch=='}')
{
	if(theStack.isEmpty() ) 
		return false;
	if(theStack.pop()!='{') 
		return false;
}


if (ch==']')
{
	if(theStack.isEmpty() ) 
		return false;
	if(theStack.pop()!='[') 
		return false;
}


if (ch==')')
{
	if(theStack.isEmpty() ) 
		return false;
	
	if(theStack.pop()!='(') 
		return false;
}


}

if (!theStack.isEmpty()) {
    return false;
} else {
    return true;
}

}

}



class Application

{

public static void main(String[] args) throws IOException

{
    /** main method from part 2
        String input = "";
        
        do {
            System.out.print("Enter an expression to find if it is balanced: ");
            input = getString();
            
            if (input.isBlank()) {
                System.out.println("Thank you for using this expression checker");
                return;
            } else {
                ExpressionChecker checker = new ExpressionChecker(input);
                System.out.println(checker.check());
            }
            
        } while (!input.isBlank());
    **/
    
    //main method for part 3
    /**
    String input= "(38[72{53}])";
    ExpressionChecker theChecker = new ExpressionChecker(input);
    System.out.println(theChecker.check());
    **/
    
    //main method for part 4
    String input= "{(38[72{53}])";
    ExpressionChecker theChecker = new ExpressionChecker(input);
    System.out.println(theChecker.check());
    
    
    

/**
public static String getString() throws IOException

{

InputStreamReader isr = new InputStreamReader(System.in);

BufferedReader br = new BufferedReader(isr);

String s = br.readLine();

return s;

}
**/

}
}


