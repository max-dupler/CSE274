/*
Copyright Notice: ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
The codes in this file are prepared for the students of CSE 274 using the content of the following webpage:
https://www.baeldung.com/java-print-binary-tree-diagram
The codes in this file are shared with the students of CSE 274 course by the instructor of the course,
Seyed Mahdi Ghamkhari, so that students use the codes for learning purpose.
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
*/



class ArrayMaxHeap {

private int size;

private int LastIndex;

private int[] InternalArray;


ArrayMaxHeap(int theSize)

{
 LastIndex=0;
 size=theSize;

 InternalArray =new int[size];
 
 for (int i=0; i<size;i++)
	 InternalArray[i]=-1;

}

public void display() {
	
	 
    System.out.print("InternalArray: | ");
	System.out.print(InternalArray[0]);
	System.out.print(" | ");
	for (int i=1;i<size;i++)
	{
		System.out.print(InternalArray[i]);
	System.out.print(" | ");}
	
	System.out.println("\n");
	
    System.out.println("Corresponding Tree Structure:\n");

    StringBuilder sb = new StringBuilder();
    span(sb, "", "", 1);
    System.out.print(sb.toString());
    System.out.println();
    
    
   

}



public void span(StringBuilder sb, String padding, String pointer, int index) {
	
	if (index>LastIndex)
		
	{
		sb.append(padding);
	        sb.append(pointer);
	        sb.append("");
	        sb.append("\n");
		
	}
	
    if (index <=LastIndex) {
        sb.append(padding);
        sb.append(pointer);
        sb.append(InternalArray[index]);
        sb.append("\n");

        StringBuilder paddingBuilder = new StringBuilder(padding);
        paddingBuilder.append("│   ");

        String paddingForBoth = paddingBuilder.toString();
        String pointerForup = "┝━━";
        String pointerFordown = "└──";
        

        span(sb, paddingForBoth, pointerForup, index*2+1);
        span(sb, paddingForBoth, pointerFordown, index*2);
    }
}






public String[] route(int LastIndex)

{
	String BinaryString = Integer.toBinaryString(LastIndex);

	String[] myroute = new String[BinaryString.length()];

	myroute[0] = "NON";

	for (int i = 1; i < BinaryString.length(); i++) {
		if (BinaryString.charAt(i) == '0')
			myroute[i] = "DownWard";

		if (BinaryString.charAt(i) == '1')
			myroute[i] = "UpWard";
	}

	return myroute;

}





public boolean isEmpty()

{
	return LastIndex==0;
}

public void add(int value) {
    
    LastIndex++;
    
    if (LastIndex == 1) {
        InternalArray[LastIndex] = value;
        return;
    }
    
    if (LastIndex == 2) {
        if (InternalArray[1] < value) {
            int tmp = InternalArray[1];
            InternalArray[1] = value;
            value = tmp;
        }
        
        InternalArray[LastIndex] = value;
        return;
    }
    
    if (LastIndex == 3) {
        if (InternalArray[1] < value) {
            int tmp = InternalArray[1];
            InternalArray[1] = value;
            value = tmp;
        }
        
        if (InternalArray[2] < value) {
            int tmp = InternalArray[2];
            InternalArray[2] = value;
            value = tmp;
        }
        
        InternalArray[LastIndex] = value;
        return;
    }
    
    int index = 1;
    int level = 1;
    String[] Direction = route(LastIndex);
    
    while (level < Direction.length) {
        if (InternalArray[index] < value) {
            int tmp = InternalArray[index];
            InternalArray[index] = value;
            value = tmp;
        }
        
        if (Direction[level].equals("DownWard")) {
            index = index * 2;
        }
        
        if (Direction[level].equals("UpWard")) {
            index = (index * 2) + 1;
        }
        
        level++;
    }
    
    InternalArray[index] = value;
    return;
}

public int delete() {
    
    int deleted = InternalArray[1];
    
    if (LastIndex == 1) {
        LastIndex = 0;
        return deleted;
    }
    
    if (LastIndex == 2) {
        InternalArray[1] = InternalArray[2];
        LastIndex = 1;
        return deleted;
    }
    
    if (LastIndex == 3) {
        if (InternalArray[2] <= InternalArray[3]) {
            InternalArray[1] = InternalArray[3];
        }
        
        if (InternalArray[2] > InternalArray[3]) {
            InternalArray[1] = InternalArray[2];
            InternalArray[2] = InternalArray[3];
        }
        
        LastIndex = 2;
        return deleted;
    }
    
    int index = 1;
    int last = InternalArray[LastIndex];
    
    
    while(true) {
        
        if (2 * index + 1 > LastIndex) {
            InternalArray[index] = last;
            break;
        }
        
        if (InternalArray[2 * index + 1] >= InternalArray[2 * index]) {
            InternalArray[index] = InternalArray[2 * index + 1];
            if (InternalArray[index] < last) {
                int tmp = InternalArray[index];
                InternalArray[index] = last;
                last = tmp;
            }
            
            index = 2 * index + 1;
            continue;
        }
        if (InternalArray[2 * index + 1] < InternalArray[2 * index]) {
            InternalArray[index] = InternalArray[2 * index];
  
            if (InternalArray[index] < last) {
                int tmp = InternalArray[index];
                InternalArray[index] = last;
                last = tmp;
            }
            
            index = 2 * index;
            continue;
        }
        
    }
    
    InternalArray[LastIndex] = -1;
    LastIndex--;
    return deleted;
}



}


class Application
{
	
	public static void main(String[] args)
	{
	
	    /*ArrayMaxHeap myHeap = new ArrayMaxHeap(20);
	    myHeap.add(25);
	    myHeap.add(19);
	    myHeap.add(1);
	    myHeap.add(3);
	    myHeap.add(4);
	    myHeap.add(8);
	    myHeap.add(9);
	    myHeap.add(18);
	    myHeap.add(7);
	    myHeap.add(6);
	    myHeap.add(5);
	    myHeap.add(12);
	    myHeap.display();*/
	    
	    ArrayMaxHeap myHeap = new ArrayMaxHeap(20);
	    myHeap.add(25);
	    myHeap.add(19);
	    myHeap.add(1);
	    myHeap.add(3);
	    myHeap.add(4);
	    myHeap.add(8);
	    myHeap.add(9);
	    myHeap.add(18);
	    myHeap.add(7);
	    myHeap.add(6);
	    myHeap.add(5);
	    myHeap.add(12);
	    while (!myHeap.isEmpty())
	    System.out.println(myHeap.delete());

		
	}
}       

 
