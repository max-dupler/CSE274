/////  Copyright: The codes in this file are prepared for the students of CSE 274 using the content of the following textbook:

////   Data Structures and Algorithms in Java, 2nd Edition by Robert Lafore

////   The codes in this file are shared with the students of CSE 274 course by the instructor of the course,

////   so that students use the codes for learning purpose. 

////   Accordingly, the instructor of the course is not in a position to give a permission to the students

////   to use these codes for any other purposes, such as sharing the codes with other individuals.  

// Max Dupler
// CSE 274 First Project




class Link             //////// Class Link 

{
	
	public int iData;

	public double dData;

	public Link next;

	public Link (int id, double dd) ///// Constructor 

	{
		iData=id;
		dData=dd;
	}

	public void displayLink()     //// printing the data in the link

	{

	System.out.println("{"+iData+","+dData+"}");

	}

}


class LinkList

{


	private Link first;

	public void LinkList()   ///////////  constructor 

	{
	first=null;              //// Initializing "first" variable.
	}


	public void insertFirst(int id, double dd)    //// inserting a link at the beginning part of the linked list

    {

	Link newLink=new Link(id, dd);
	newLink.next=first;
	first=newLink;
    }


    public void displayList()            /// printing the data in all links
    
    {
    	Link current=first;
    	while(current!=null)
    	{
    		current.displayLink();
    		current=current.next;

    	}
    }


    public Link deleteFirst()                ////// deleting the link at the beginning part of the linked list 
    
    {
        if (first == null) {
            return null;
        } else {
        	Link temp=first;
        	first=first.next;
        	return temp;
        }
        

    }


    public Link find(int key)              /// finding a link in which iData is equal to key

    {
        Link current =first;               

        if (current == null) {
            return null;
        }

        while(current.iData!=key)          //// Keep iterating until finding the link with iData=key

        {

            if (current.next == null) {
                return null;
            }
        	    

        	current=current.next;

        }

      return current;


    }



    public void insertLast(int id, double dd)

    {

    	if (first==null)

    	{

    		insertFirst(id, dd);
    		return; 
    	}



    	Link current=first;




    	while(current.next!=null)

    	{

    		current=current.next;

    	}
    	
    	
    	Link newLink=new Link(id, dd);
        newLink.next=null;
        current.next = newLink;




    }
    
    public void CountandDisplay(int index) {
        Link current = first;
        for (int i = 1; i <= index; i++) {
            if (current.next == null) {
                System.out.println();
            } else if(i == index) {
                current.displayLink();
            } else {
                current = current.next;
            }
        }
    }
}





class Application       ////
{

	public static void main (String[] args)
	{
	    LinkList myLinkedlist = new LinkList();
	    System.out.println(myLinkedlist.find(4)==null);
	    myLinkedlist.deleteFirst();
	    myLinkedlist.insertLast(1, 29.2);
	    myLinkedlist.insertFirst(3, 13.5);
	    myLinkedlist.insertLast(2, 22.2);
	    myLinkedlist.deleteFirst();
	    myLinkedlist.displayList();
	    System.out.println(myLinkedlist.find(1)==null);
	    myLinkedlist.insertFirst(6,17.8);
	    myLinkedlist.insertFirst(5,21.6);
	    myLinkedlist.insertFirst(4,81.3);
	    myLinkedlist.displayList();
	    System.out.println("The link with index 4:");
	    myLinkedlist.CountandDisplay(4);



	}




}

