/*
Copyright Notice: ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
The codes in this file are prepared for the students of CSE 274 using the content of the following webpages:
https://www.baeldung.com/java-binary-tree
https://www.baeldung.com/java-print-binary-tree-diagram
The codes in this file are shared with the students of CSE 274 course by the instructor of the course,
Seyed Mahdi Ghamkhari, so that students use the codes for learning purpose.
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
*/

/*
 * Part 1 Answers
 * a) 3
 * b) 2
 * c) 11
 * d) 2
 * e) 0
 * f) 24 and 22
 * g) 13 and 17
 * h) Yes, this is a binary tree because each node has at most 2 children
 * i) 24
 * j) 22
 */


class Node {
    int value;
    Node down;
    Node up;

    Node(int value) {
        this.value = value;
        up = null;
        down = null;
    }
    
    public int getValue(){return value;}
    
    public Node getdown(){return down;}
    
    public Node getup() {return up;}
}





 class BinaryTree {

    public Node root;

 
    public void display() {
	    StringBuilder sb = new StringBuilder();
	    span(sb, "", "", root);
	    System.out.print(sb.toString());
	    System.out.println();

	}
    
 
    
    public void span(StringBuilder sb, String padding, String pointer, Node node) {
    	
    	if (node==null)
    		
    	{
    		sb.append(padding);
   	        sb.append(pointer);
   	        sb.append("");
   	        sb.append("\n");
    		
    	}
    	
	    if (node != null) {
	        sb.append(padding);
	        sb.append(pointer);
	        sb.append(node.getValue());
	        sb.append("\n");

	        StringBuilder paddingBuilder = new StringBuilder(padding);
	        paddingBuilder.append("│   ");

	        String paddingForBoth = paddingBuilder.toString();
	        String pointerForup = "┝━━";
	        String pointerFordown = "└──";
	        

	        span(sb, paddingForBoth, pointerForup, node.getup());
	        span(sb, paddingForBoth, pointerFordown, node.getdown());
	    }
	}
    

   
  
   
   public int NodeCounter()
   {
	   
	   
	   return RecursiveNodeCounter(root);
	
   }
   public int RecursiveNodeCounter(Node mynode)
   
   {
	   
	   if (mynode==null)
		   return 0;
	   
	   return 1 + RecursiveNodeCounter(mynode.down)+ RecursiveNodeCounter(mynode.up);
	   
   }
   
   public int Length()
   {return RecursiveLength(root);}
   
   public int RecursiveLength(Node myNode) {
       
       if (myNode == null)
           return 0;
        
       return 1 + Math.max(RecursiveLength(myNode.up)
               , RecursiveLength(myNode.down));
   }
   
 
   
  
 
}
 


class Application {
	
	public static  void main(String argv[])
	{
		
		
	    BinaryTree myBinaryTree = new BinaryTree();
	    myBinaryTree.root=new Node(11);
	    myBinaryTree.root.up= new Node(17);
	    myBinaryTree.root.down= new Node(13);
	    myBinaryTree.root.down.down= new Node(22);
	    myBinaryTree.root.down.up= new Node(24);
	    myBinaryTree.root.up.down= new Node(27);
	    myBinaryTree.root.up.up= new Node(28);
	    System.out.println(myBinaryTree.Length());
	    
	    
	    
	    
	    	
	}
	
}

