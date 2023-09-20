/////  Copyright: The codes in this file are prepared for the students of CSE 274 using the content of the following textbook:

////   Data Structures and Algorithms in Java, 2nd Edition by Robert Lafore

////   The codes in this file are shared with the students of CSE 274 course by the instructor of the course,

////   so that students use the codes for learning purpose. 

////   Accordingly, the instructor of the course is not in a position to give a permission to the students

////   to use these codes for any other purposes, such as sharing the codes with other individuals.    

class Link

{

public int iData;

public Link next;



public Link(int id)

{ iData = id; }


}



class LinkList

{


	private Link first;

	public  LinkList()   

	{
	first=null;              
	}


	public void insertFirst(int id)    
    {

	Link newLink=new Link(id);
	newLink.next=first;
	first=newLink;
    }
	
	public boolean isEmpty() {
	    if (first == null) {
	        return true;
	    } else {
	        return false;
	    }
	}
	
	public Link deleteFirstandSendItBack() {
	    Link current = first;
	    first = first.next;
	    return current;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	/*public boolean isEmpty() {
	    return first == null;
	}
	
	public Link deleteFirstandSendItBack() {
	    Link current = first;
	    first = first.next;
	    return current;
	    
	}*/




}




class StackI

{

private int maxSize;

private int[] stackArray;

private int top;


public StackI(int s)

{

maxSize = s;

stackArray = new int[maxSize];// create array

top = -1;

}


public void push(int j)

{

top=top+1;
stackArray[top] = j;

}


public int pop()

{

int temp = stackArray[top];
top=top-1;
return temp;

}





public boolean isEmpty()

{

return (top == -1);

}


public boolean isFull()

{

return (top == maxSize-1);

}


}

class StackLinkedList {
    LinkList list = new LinkList();
    
    public void push(int x) {
        list.insertFirst(x);
    }
    
    public int pop() {
        Link temp = list.deleteFirstandSendItBack();
        return temp.iData;
    }
    
    public boolean isEmpty() {
        return list.isEmpty();
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    /*
    
    public void push(int x) {
        list.insertFirst(x);
    }
    
    public int pop() {
        if (!(list.isEmpty())) {
            Link temp = list.deleteFirstandSendItBack();
            return temp.iData;
        }
        return 0;
    }
    
    public boolean isEmpty() {
        return list.isEmpty();
    }
    */
}






class Application

{

public static void main(String[] args)

{

    StackLinkedList theStack =new StackLinkedList();
    theStack.push(11);
    theStack.push(22);
    theStack.push(33);
    theStack.push(44);
    theStack.push(55);
    theStack.push(66);
    while(!theStack.isEmpty())
    System.out.println(theStack.pop());
	

}

}

