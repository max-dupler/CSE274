/* 
Copyright Notice: This file is created by Seyed Mahdi Ghamkhari. All rights are reserved.
The file is provided to the students enrolled in sections E and F of the CSE 274 class in Fall 2022 semester. 
These students can use the file during the Fall 2022 semester for their education. 
Other uses of the file or distribution of the file is not permitted.
*/

class DoublyLinkedList {
    private Link first;
    private Link last;
    
    public DoublyLinkedList() {
        first = null;
        last = null;
    }
    
    public boolean isEmpty() {
        return first == null;
    }
    
    public void insertNoDuplicate(String id) {
        if (this.isEmpty()) {
            insertFirst(id);
            return;
        } 
        
        if (find(id)) {
            return;
        } else {
            Link tmp = new Link(id);
            last.next = tmp;
            tmp.previous = last;
            tmp.next = null;
            last = tmp;
        }
        
        
        
    }
    
    public void insertFirst(String id) {
        if (first == null) {
            Link newLink = new Link(id);
            newLink.next = null;
            first = newLink;
            last = newLink;
        }
    }
    
    public void displayForward() {
        
        Link current = first;
        
        while (current != null) {
            current.displayLink();
            System.out.print(" ");
            current = current.next;
        }
        
        System.out.println();
    }
    
    public void delete(String id) {
        if (find(id)) {
            return;
        }
        Link current = first;
        
        // check if key is first link
        if (id == first.SData) {
            deleteFirst();
            return;
        } 
        
        // check if key exists
        while (current != null) {
            if (current.SData == id) {
               // check if last link
               if (current.next == null) {
                   deleteLast();
                   return;
               } else {
                   current.next.previous = current.previous;
                   current.previous.next = current.next;
               }
            }
            
            current = current.next;
        }
    }
    
    public void deleteFirst() {
        
        if (first.next == null) {
            last = null;
        } else {
            first.next.previous = null;
        }
        
        first = first.next;
    }
    
    public void deleteLast() {
        
        if (last.previous == null) {
            first = null;
        } else {
            last.previous.next = null;
        }
        
        last = last.previous;
    }
    
    public boolean find(String id) {
        Link current = first;
        
        while (current.next != null) {
            if (current.SData == id) {
                return true;
            }
            current = current.next;
        }
        
        return false;
    }
    
    
}

class Link {
    
    public String SData;
    public Link next;
    public Link previous;
    
    public Link(String id) {
        SData = id;
    }
    
    public void displayLink() {
        System.out.print(SData);
    }
}


class HashTableChain

{

	private DoublyLinkedList[] InternalArray;

	private int arraySize;

	public HashTableChain(int size)

	{

		arraySize = size;
		
		InternalArray = new DoublyLinkedList[arraySize];

		for (int j=0;j<arraySize;j++)
			InternalArray[j]=new DoublyLinkedList();
	

	}

	public void displayChains()

	{



		for (int j = 0; j < arraySize; j++)

		{
			
			System.out.print("Chain "+j+": ");
			InternalArray[j].displayForward();

	

		}

		System.out.println("");

	}

	public int hashFunc(String key)

	{

		int result = LetterToNumber(key.charAt(0)) + LetterToNumber(key.charAt(1));

		return result % arraySize;

	}

	public void insertInaChain(String key)

	{

		int hashIndex = hashFunc(key);
		
		

		InternalArray[hashIndex].insertNoDuplicate(key);

	}

	public void deletefromaChain(String key)

	{

		int hashIndex = hashFunc(key);

		InternalArray[hashIndex].delete(key);

		return;

	}

	public boolean findinChains(String key)

	{

		int hashIndex = hashFunc(key);

		return InternalArray[hashIndex].find(key);



	}

	public int LetterToNumber(char ch)

	{

		int digit = 0;
		if (ch == 'A')
			digit = 0;

		if (ch == 'B')
			digit = 1;

		if (ch == 'C')
			digit = 2;

		if (ch == 'D')
			digit = 3;

		if (ch == 'E')
			digit = 4;

		if (ch == 'F')
			digit = 5;

		if (ch == 'G')
			digit = 6;

		if (ch == 'H')
			digit = 7;

		if (ch == 'I')
			digit = 8;

		if (ch == 'J')
			digit = 9;

		if (ch == 'K')
			digit = 10;

		if (ch == 'L')
			digit = 11;

		if (ch == 'M')
			digit = 12;

		if (ch == 'N')
			digit = 13;

		if (ch == 'O')
			digit = 14;

		if (ch == 'P')
			digit = 15;

		if (ch == 'Q')
			digit = 16;

		if (ch == 'R')
			digit = 17;

		if (ch == 'S')
			digit = 18;

		if (ch == 'T')
			digit = 19;

		if (ch == 'U')
			digit = 20;

		if (ch == 'V')
			digit = 21;

		if (ch == 'W')
			digit = 22;

		if (ch == 'X')
			digit = 23;

		if (ch == 'Y')
			digit = 24;

		if (ch == 'Z')
			digit = 25;
		return digit;
	}

}

class Application

{

	public static void main(String[] args)

	{

		HashTableChain myhashtable = new HashTableChain(52);
		myhashtable.insertInaChain("AK");
		myhashtable.insertInaChain("FL");
		myhashtable.insertInaChain("IA");
		myhashtable.insertInaChain("MN");
		myhashtable.insertInaChain("NV");
		myhashtable.insertInaChain("SC");
		myhashtable.insertInaChain("VT");
		myhashtable.insertInaChain("ND");
		myhashtable.insertInaChain("ME");
		myhashtable.deletefromaChain("CO");
		myhashtable.deletefromaChain("ME");
		System.out.println(myhashtable.findinChains("ME"));
		myhashtable.displayChains();
		 


	}

}
