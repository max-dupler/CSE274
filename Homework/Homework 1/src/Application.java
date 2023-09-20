/////  Copyright: The codes in this file are prepared for the students of CSE 274 using the content of the following textbook:

////   Data Structures and Algorithms in Java, 2nd Edition by Robert Lafore

////   The codes in this file are shared with the students of CSE 274 course by the instructor of the course,

////   so that students use the codes for learning purpose. 

////   Accordingly, the instructor of the course is not in a position to give a permission to the students

////   to use these codes for any other purposes, such as sharing the codes with other individuals.    

// Max Dupler
// Dr. Ghamkhari
// CSE 274
// 9/8/2022

/*
 * Questions
 * 1. O(1)
 * 2. O(N)
 * 3. O(N)/2
 * 4. No, links can be deleted and added
 * 5. No, the memory location doesn't matter. Links are stored in a random memory location
 *      unlike arrays that are stored in an ordered memory location. Links are organized by
 *      using references. Reference fields don't hold objects, they hold a reference to an
 *      object somewhere else in memory
 * 6. Yes the delete method works correctly. The only test I found it will not work is if 
 *      there is 2 links with the same key but that is not a problem with the method
 *      but rather a problem with the programmer who made the list with two links
 *      that have the same key.
 * 
 */




class Link             //////// Class Link 

{
	
	public int iData;

	public double dData;

	public Link next;

	public Link (int id, double dd)  ///// Constructor 

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
	
	/*public void insertOrdered(int id, double dd) {
	    if (first == null) {
	        insertFirst(id, dd);
	        return;
	    }
	    
	    Link newLink = new Link(id, dd);
	    Link current = first;
	    Link previous = null;
	    
	    while (current != null && id > current.iData) {
	        previous = current;
	        current = current.next;
	    }
        
	    if (previous == null) {
            first = newLink;
        } else {
            previous.next = newLink;
            
        }
        newLink.next = current;
	}
*/

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

    	

    	Link temp=first;
    	
    	if (first==null)
    		return null; 
    	
    	
    	first=first.next;
    	return temp;

    }


    public Link find(int key)              /// finding a link in which iData is equal to key

    {
        Link current =first;               

        if (current==null)
        	return null;

        while(current.iData!=key)          //// Keep iterating until finding the link with iData=key

        {

        	
        	if (current.next==null)
        		return null;
        	    

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


    	Link newlink =new Link(id, dd);
    	
    	newlink.next=null;
    	current.next=newlink;


    }
    
    public void CountandDisplay(int index)

    {

    	if (first==null)

    	{
    		
    		return; 
    	}



    	Link current=first;


    	int count=1;
    	

    	while(current!=null)

    	{

    		
    		if (count==index)
    		{
    			
    		current.displayLink();
    		return;
    				
    		}
    		count=count+1;
    		current=current.next;

    	}


   


    }
    
    
    public void delete(int key)
    
    {
    	if (first==null)
    		return;
    	
    	if (first.next==null)
    		
    	{
    		if (first.iData!=key)
    				
    			return;
    			
    		if (first.iData==key)
    			
    		{
    			first=null;
    			return;
    		}
    	}
    	
    	if (first.iData==key)
    		
    	{
    		first=first.next;
    		return;
    		
    	}
    	
    	
    	Link previous= first;
    	
    	Link current=first.next;
    	
    	while(current.iData!=key)
    	{
    		
    		
    		
    		
    		previous=current;
    		current=current.next;
    		
         if (current==null)
    			
    			return;
    	}
    	
    	previous.next=current.next;
    	return;
    }
    
 
    
    public void insertOrdered(int id, double dd) {

        Link newLink = new Link(id, dd);
        Link previous = null;
        Link current = first;
        
        if (first == null) {
            first = newLink;
            return;
        }
        
        while (current != null && id > current.iData) {
            previous = current;
            current = current.next;
        }
        
        if (previous == null) {
            first = newLink;
        } else {
            previous.next = newLink;
            
        }
        newLink.next = current;
        
    }
    
    
}



class Application       ////
{

	public static void main (String[] args)
	{

	    LinkList myLinkedlist = new LinkList();
	    myLinkedlist.insertOrdered(21, 10.3);
	    myLinkedlist.insertOrdered(15, 11.8);
	    myLinkedlist.insertOrdered(18, 12.1);
	    myLinkedlist.insertOrdered(9, 19.9);
	    myLinkedlist.insertOrdered(50, 15.7);
	    myLinkedlist.insertOrdered(26, 11.4);
	    myLinkedlist.displayList();





	}

//ff


}


