/*
Copyright Notice: ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
The codes in this file are prepared for the students of CSE 274 using the content of the following webpage:
https://www.baeldung.com/java-print-binary-tree-diagram
The codes in this file are shared with the students of CSE 274 course by the instructor of the course,
Seyed Mahdi Ghamkhari, so that students use the codes for learning purpose.
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
*/



class Node {
	Vertex myVertex;
	int value;
	Node down;
	Node up;

	Node(Vertex myVertex, int value) {
		this.value = value;
		this.myVertex=myVertex;
		up = null;
		down = null;
	}

	public int getValue() {
		return value;
	}

	public Node getdown() {
		return down;
	}

	public Node getup() {
		return up;
	}
}



class Vertex {

	String label;

	Vertex(String theLabel) {

		label = theLabel;
	}

}



class MinHeap {

	private int Size;
	public Node root;

	public MinHeap() {
		Size = 0;
	}

	public void display() {
		StringBuilder sb = new StringBuilder();
		span(sb, "", "", root);
		System.out.print(sb.toString());
		System.out.println();

	}

	public void span(StringBuilder sb, String padding, String pointer, Node node) {

		if (node == null)

		{
			sb.append(padding);
			sb.append(pointer);
			sb.append("");
			sb.append("\n");

		}

		if (node != null) {
			sb.append(padding);
			sb.append(pointer);
			sb.append(node.getValue()+","+node.myVertex.label);
			sb.append("\n");

			StringBuilder paddingBuilder = new StringBuilder(padding);
			paddingBuilder.append("   │   ");

			String paddingForBoth = paddingBuilder.toString();
			String pointerForup = "   ┝━━";
			String pointerFordown = "   └──";

			span(sb, paddingForBoth, pointerForup, node.getup());
			span(sb, paddingForBoth, pointerFordown, node.getdown());
		}
	}

	public String[] route(int Position)

	{
		String BinaryString = Integer.toBinaryString(Position);

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

	public void add(Vertex myVertex,int value)

	{
		if (root == null) {
			root = new Node(myVertex, value);
			Size = Size + 1;
			return;
		}
		int Position = Size + 1;

		String[] Direction = route(Position);


		int level = 1;
		Node current = root;

		while (true) {
			if (current.value > value) {
				int tmp = current.value;
				current.value = value;
				value = tmp;
				
				Vertex tmpVertex=current.myVertex;
				current.myVertex=myVertex;
				myVertex=tmpVertex;
			}

			if (level == Direction.length - 1)
				break;

			if (Direction[level].equals("DownWard"))

				current = current.down;

			if (Direction[level].equals("UpWard"))
				current = current.up;

			level = level + 1;

		}

		if (Direction[level].equals("DownWard"))
			current.down = new Node(myVertex,value);

		if (Direction[level].equals("UpWard"))
			current.up = new Node(myVertex, value);

		Size = Size + 1;

	}

	public boolean isEmpty()

	{
		return Size == 0;
	}

	public Vertex delete()

	{

		Vertex DeletedVertex=root.myVertex;

		if (root.up == null && root.down == null) {

			root = null;
			Size = Size - 1;
			return DeletedVertex;
		}

		if (Size == 3) {
			if (root.up.value <= root.down.value) {
				root.value = root.up.value;
				root.myVertex=root.up.myVertex;
				root.up = null;
				Size = Size - 1;
				return DeletedVertex;
			}

			if (root.up.value > root.down.value) {
				root.value = root.down.value;
				root.myVertex = root.down.myVertex;
				root.down.value = root.up.value;
				root.down.myVertex = root.up.myVertex;
				root.up = null;
				Size = Size - 1;
				return DeletedVertex;
			}

		}

		if (Size == 2) {
			root.value = root.down.value;
			root.myVertex=root.down.myVertex;
			root.down = null;
			Size = Size - 1;
			return DeletedVertex;

		}

		Node current = root;
		Node parent = root;

		String[] Direction = route(Size);

		for (int i = 1; i < Direction.length; i++) {
			if (Direction[i].equals("UpWard")) {
				parent = current;
				current = current.up;
			}

			if (Direction[i].equals("DownWard")) {
				parent = current;
				current = current.down;
			}

		}

		int LastValue = current.value;
		Vertex LastVertex=current.myVertex;

		if (Direction[Direction.length - 1].equals("UpWard"))
			parent.up = null;

		if (Direction[Direction.length - 1].equals("DownWard"))
			parent.down = null;

		current = root;

		int tmp;
		Vertex tmpVertex;

		while (true) {
			if (current.up == null && current.down == null) {

				current.value = LastValue;
				current.myVertex = LastVertex;
				Size = Size - 1;
				return DeletedVertex;

			}

			if (current.down == null) {
				current.value = current.up.value;
				current.myVertex = current.up.myVertex;

				if (current.value>LastValue)
				{
				tmp=current.value;	
				current.value=LastValue;
			    LastValue=tmp;
			    
			    tmpVertex=current.myVertex;
			    current.myVertex=LastVertex;
			    LastVertex=tmpVertex;
		        }


				current = current.up;
				continue;

			}

			if (current.up == null) {
				current.value = current.down.value;
				current.myVertex = current.down.myVertex;

				if (current.value>LastValue)
				{
				tmp=current.value;	
				current.value=LastValue;
			    LastValue=tmp;
			    
			    tmpVertex=current.myVertex;
			    current.myVertex=LastVertex;
			    LastVertex=tmpVertex;
		        }

				current = current.down;

				continue;

			}

			if (current.down.value < current.up.value) {
				current.value = current.down.value;
				current.myVertex = current.down.myVertex;

				if (current.value>LastValue)
				{
				tmp=current.value;	
				current.value=LastValue;
			    LastValue=tmp;
			    
			    tmpVertex=current.myVertex;
			    current.myVertex=LastVertex;
			    LastVertex=tmpVertex;
		        }

				current = current.down;

				continue;
			}

			if (current.down.value > current.up.value) {
				current.value = current.up.value;
				current.myVertex = current.up.myVertex;


				if (current.value>LastValue)
				{
				tmp=current.value;	
				current.value=LastValue;
			    LastValue=tmp;
			    
			    tmpVertex=current.myVertex;
			    current.myVertex=LastVertex;
			    LastVertex=tmpVertex;
		        }

				current = current.up;

				continue;
			}

			if (current.down.value == current.up.value) {

				current.value = current.down.value;
				current.myVertex = current.down.myVertex;

				

				if (current.value>LastValue)
				{
				tmp=current.value;	
				current.value=LastValue;
			    LastValue=tmp;
			    
			    tmpVertex=current.myVertex;
			    current.myVertex=LastVertex;
			    LastVertex=tmpVertex;
		        }

				current = current.down;

			}

		}

	}

}



class WeightedGraph {
	private int[][] Adjacency;
	private Vertex[] VertexArray;

	int size;

	WeightedGraph() {
		size = 0;

	}

	public void display() {

		System.out.print("Adjacancy Matrix:\n\n");

		System.out.print(String.format("%-6s", String.valueOf("")));
		for (int i = 0; i < size; i++)
			System.out.print(String.format("%-7s", String.valueOf(VertexArray[i].label)));

		System.out.println();

		for (int i = 0; i < size; i++) {
			System.out.print(String.format("%-6s", String.valueOf(VertexArray[i].label)));
			for (int j = 0; j < size; j++) {

				System.out.print(String.format("%-6s", String.valueOf(Adjacency[i][j])));
				System.out.print(" ");
			}

			System.out.println();
		}

		System.out.println();

	}

	public void addVertex(String label) {

		size = size + 1;
		int[][] tmp;

		tmp = new int[size][size];

		for (int i = 0; i < size - 1; i++)
			for (int j = 0; j < size - 1; j++)
				tmp[i][j] = Adjacency[i][j];

		for (int j = 0; j < size; j++)
			tmp[size - 1][j] = -1;

		for (int i = 0; i < size; i++)
			tmp[i][size - 1] = -1;

		Adjacency = tmp;

		Vertex[] pro;
		pro = new Vertex[size];
		for (int i = 0; i < size - 1; i++)
			pro[i] = VertexArray[i];

		pro[size - 1] = new Vertex(label);

		VertexArray = pro;

	}

	
public void addWeightedEdge(String SLabel, String DLabel, int weight)

	{
		int u = VertexToIndex(LabelToVertex(SLabel));
		int v = VertexToIndex(LabelToVertex(DLabel));

		Adjacency[u][v] = weight;

	}
	

	public int VertexToIndex(Vertex myVertex)

	{

		for (int i = 0; i < size; i++)
			if (VertexArray[i] == myVertex)
				return i;

		return -1; /// This line does not needed logically.

	}

	

	public Vertex LabelToVertex(String label)

	{
		for (int i = 0; i < size; i++) {
			Vertex myVertex = VertexArray[i];
			if (myVertex.label.equals(label))
				return myVertex;
		}
		return null;

	}
	
	public void FindDistance(String SLabel) {
	    int[] distance = new int[size];
	    Vertex CurrentVertex;
	    Vertex S = LabelToVertex(SLabel);
	    
	    for (int i = 0; i < size; i++) {
	        distance[i] = 1000;
	    }
	    
	    MinHeap myHeap = new MinHeap();
	    myHeap.add(S, size);
	    distance[VertexToIndex(S)] = 0;
	    
	    while (!myHeap.isEmpty()) {
	        CurrentVertex = myHeap.delete();
	        
	        for (int j = 0; j < size; j++) {
	            if (!(Adjacency[VertexToIndex(CurrentVertex)][j] == -1)) {
	                Vertex NeighborVertex = VertexArray[j];
	                
	                int newDistance = distance[VertexToIndex(CurrentVertex)]
	                        + Adjacency[VertexToIndex(CurrentVertex)][VertexToIndex(NeighborVertex)];
	                
	                if (newDistance < distance[j]) {
	                    distance[j] = newDistance;
	                    myHeap.add(NeighborVertex, distance[j]);
	                }
	            }
	        }
	    }
	    
	    System.out.println("Distance from vertex " + SLabel + " to vertex");
	    
	    for (int i = 0; i < size; i++) {
	        System.out.print(VertexArray[i].label+ ": "+distance[i]+"\n");
	    }
	    return;
	    
	}
	
	
	public void FindShortestPath(String SLabel,String DLabel) {
	    int[] distance = new int[size];
        Vertex CurrentVertex;
        Vertex[] PreviousVertexArray = new Vertex[size];
        
        for (int i = 0; i < size; i++) {
            distance[i] = 1000;
        }
        
        MinHeap myHeap = new MinHeap();
        myHeap.add(LabelToVertex(SLabel), size);
        distance[VertexToIndex(LabelToVertex(SLabel))] = 0;
        
        while (!myHeap.isEmpty()) {
            CurrentVertex = myHeap.delete();
            
            for (int j = 0; j < size; j++) {
                if (!(Adjacency[VertexToIndex(CurrentVertex)][j] == -1)) {
                    Vertex NeighborVertex = VertexArray[j];
                    
                    int newDistance = distance[VertexToIndex(CurrentVertex)]
                            + Adjacency[VertexToIndex(CurrentVertex)][VertexToIndex(NeighborVertex)];
                    
                    if (newDistance < distance[j]) {
                        PreviousVertexArray[j] = CurrentVertex;
                        distance[j] = newDistance;
                        myHeap.add(NeighborVertex, distance[j]);
                    }
                }
            }
        }
        
        
	    
	    
	    System.out.print("Shortest Path from "+SLabel+" to "+DLabel+": ");
	    String ShortestPath="";
	    CurrentVertex=LabelToVertex(DLabel);
	    while (!CurrentVertex.label.equals(SLabel)) {
    	    int Index=VertexToIndex(CurrentVertex);
    	    CurrentVertex=PreviousVertexArray[Index];
    	    ShortestPath=CurrentVertex.label+"-"+ShortestPath;
	    }
	    ShortestPath=ShortestPath+DLabel;
	    System.out.println(ShortestPath);
	}

	


}

class Application {

	public static void main(String[] argv)

	{
        ///////// Test 1
        Vertex VertexA=new Vertex("A");
        Vertex VertexB=new Vertex("B");
        Vertex VertexC=new Vertex("C");
        Vertex VertexD=new Vertex("D");
        Vertex VertexE=new Vertex("E");
        Vertex VertexF=new Vertex("F");
        Vertex VertexG=new Vertex("G");
        Vertex VertexH=new Vertex("H");
        Vertex VertexI=new Vertex("I");
        MinHeap myHeap= new MinHeap();
        myHeap.add(VertexA, 71);
        myHeap.add(VertexB, 66);
        myHeap.add(VertexC, 63);
        myHeap.add(VertexD, 74);
        myHeap.add(VertexE, 48);
        myHeap.add(VertexF, 53);
        myHeap.add(VertexG, 42);
        myHeap.add(VertexH, 79);
        myHeap.add(VertexI, 65);
        myHeap.display();
        while(!myHeap.isEmpty())
        System.out.print(myHeap.delete().label+" ");
        System.out.println("");
        ///////// Test 2
        WeightedGraph myGraph = new WeightedGraph();
        myGraph.addVertex("A");
        myGraph.addVertex("B");
        myGraph.addVertex("C");
        myGraph.addVertex("D");
        myGraph.addVertex("E");
        myGraph.addVertex("F");
        myGraph.addVertex("G");
        myGraph.addVertex("H");
        myGraph.addWeightedEdge("A", "B", 5);
        myGraph.addWeightedEdge("B", "D", 6);
        myGraph.addWeightedEdge("D", "E", 3);
        myGraph.addWeightedEdge("C", "D", 2);
        myGraph.addWeightedEdge("A", "F", 1);
        myGraph.addWeightedEdge("F", "G", 1);
        myGraph.addWeightedEdge("G", "C", 1);
        myGraph.addWeightedEdge("E", "H", 4);
        myGraph.addWeightedEdge("C", "H", 8);
        myGraph.display();
        ///////// Test 3
        myGraph.FindDistance("A");
        ///////// Test 4
        myGraph.FindShortestPath("A", "H");
        myGraph.FindShortestPath("A", "B");
        myGraph.FindShortestPath("C", "E");
        myGraph.FindShortestPath("F", "D");
        myGraph.FindShortestPath("C", "H");



	}

}
