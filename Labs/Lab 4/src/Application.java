/* 
Copyright Notice: This file is created by Seyed Mahdi Ghamkhari. All rights are reserved.
The file is provided to the students enrolled in sections E and F of the CSE 274 class in Fall 2022 semester. 
These students can use the file during the Fall 2022 semester for their education. 
Other uses of the file or distribution of the file is not permitted.
*/




class HashTable

{

	private String[] InternalArray;

	private int arraySize;
	
	private int num;

	public HashTable(int size)

	{

		arraySize = size;
		
		num = 0;

		InternalArray = new String[arraySize];

		for (int j = 0; j < arraySize; j++) {
			InternalArray[j] = "**";
		}

	}

	public void displayTable()

	{

		System.out.println("Table: ");

		for (int j = 0; j < arraySize; j++)

		{

			System.out.print(InternalArray[j] + ": ");

			if (j == Math.floor(arraySize / 2) - 1)
				System.out.print("\n");

		}

		System.out.println("");

	}

	public int hashFunc(String key)

	{

		int result = 100 * LetterToNumber(key.charAt(0)) + LetterToNumber(key.charAt(1));

		return result % arraySize;

	}

	public void insert(String key)

	{

		int hashIndex = hashFunc(key);

		InternalArray[hashIndex] = key;

	}

	public void delete(String key)

	{

		int hashIndex = hashFunc(key);

		InternalArray[hashIndex] = "**";

		return;

	}

	public boolean find(String key)

	{

		int hashIndex = hashFunc(key);

		if (InternalArray[hashIndex].equals(key))

			return true;

		return false;

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
	
	public void ProbeANDinsert(String key)
	{
        int hashIndex = hashFunc(key);
        while (!InternalArray[hashIndex].equals("**"))
	{
            if (InternalArray[hashIndex].equals(key))
                return;
            ++hashIndex;
            hashIndex = hashIndex % arraySize;
	}
        InternalArray[hashIndex] = key;
	}
	
	public void ProbeANDdelete(String key) {
	    int hashIndex = hashFunc(key);
	    
	    while (!(InternalArray[hashIndex] == "**")) {
	        if (InternalArray[hashIndex].equals(key)) {
	            InternalArray[hashIndex] = "**";
	            return;
	        }
	        
	        hashIndex++;
	        hashIndex = hashIndex % arraySize;
	    }
	}
	
	public void ProbeANDdeleteButNoGap(String key) {
	    
	    int hashIndex = hashFunc(key);
	    
	    while (InternalArray[hashIndex] != "**") {
  
    	    if (InternalArray[hashIndex].equals(key)) {
    	        while (!(InternalArray[hashIndex] == "**")) {
    	            int NextIndex = (hashIndex + 1) % arraySize;
                    InternalArray[hashIndex] = InternalArray[NextIndex];
                    hashIndex++;
                    hashIndex = hashIndex % arraySize;
    	        }
    	        return;
    	        
    	    }
    	    hashIndex++;
    	    hashIndex = hashIndex % arraySize;
	    }
	    return;
	}
	
	public void ProbeANDinsertNotForever(String key) {
	    if (num == arraySize - 1) {
	        return;
	    }
	    
	    int hashIndex = hashFunc(key);
	    
        while (!InternalArray[hashIndex].equals("**")) {
            if (InternalArray[hashIndex].equals(key)) {
                return;
            }
            ++hashIndex;
            hashIndex = hashIndex % arraySize;
        }
        InternalArray[hashIndex] = key;
        num++;
        return;
	    
	}
	
	public void ProbeANDdeleteButNoGapNotForever(String key) {

        int hashIndex = hashFunc(key);

        while (!InternalArray[hashIndex].equals("**")) {

            if (InternalArray[hashIndex].equals(key)) {
                
                num=num-1;
                
                while (!InternalArray[hashIndex].equals("**")) {
                
                    int NextIndex=(hashIndex+1)%arraySize;
                    InternalArray[hashIndex] = InternalArray[NextIndex];
                    hashIndex=hashIndex+1;
                    hashIndex=hashIndex % arraySize;
                
                }
                return;
            }

            ++hashIndex;
            hashIndex= hashIndex % arraySize;

        }

        return;

    }
	
	
	public boolean ProbeANDfind(String key) {

        int hashIndex = hashFunc(key);

        while (!InternalArray[hashIndex].equals("**")) {

            if (InternalArray[hashIndex].equals(key))

                return true;

            ++hashIndex;

            hashIndex = hashIndex % arraySize;

        }
        return false;
    }

}

class Application

{

	public static void main(String[] args)

	{
	    /*HashTable myhashtable = new HashTable(52);
	    myhashtable.ProbeANDinsert("AK");
	    myhashtable.ProbeANDinsert("FL");
	    myhashtable.ProbeANDinsert("IA");
	    myhashtable.ProbeANDinsert("MN");
	    myhashtable.ProbeANDinsert("NV");
	    myhashtable.ProbeANDinsert("VT");
	    myhashtable.ProbeANDinsert("ND");
	    myhashtable.ProbeANDinsert("CO");
	    myhashtable.ProbeANDinsert("ME");
	    myhashtable.ProbeANDinsert("AZ");
	    myhashtable.ProbeANDdeleteButNoGap("CO");
	    myhashtable.ProbeANDdeleteButNoGap("ME");
	    myhashtable.displayTable();*/
	   
	    
	    HashTable myhashtable = new HashTable(52);
	    myhashtable.ProbeANDinsertNotForever("AL");
	    myhashtable.ProbeANDinsertNotForever("AK");
	    myhashtable.ProbeANDinsertNotForever("AZ");
	    myhashtable.ProbeANDinsertNotForever("AR");
	    myhashtable.ProbeANDinsertNotForever("CA");
	    myhashtable.ProbeANDinsertNotForever("CO");
	    myhashtable.ProbeANDinsertNotForever("CT");
	    myhashtable.ProbeANDinsertNotForever("DE");
	    myhashtable.ProbeANDinsertNotForever("DC");
	    myhashtable.ProbeANDinsertNotForever("FL");
	    myhashtable.ProbeANDinsertNotForever("GA");
	    myhashtable.ProbeANDinsertNotForever("HI");
	    myhashtable.ProbeANDinsertNotForever("ID");
	    myhashtable.ProbeANDinsertNotForever("IL");
	    myhashtable.ProbeANDinsertNotForever("IN");
	    myhashtable.ProbeANDinsertNotForever("IA");
	    myhashtable.ProbeANDinsertNotForever("KS");
	    myhashtable.ProbeANDinsertNotForever("KY");
	    myhashtable.ProbeANDinsertNotForever("LA");
	    myhashtable.ProbeANDinsertNotForever("ME");
	    myhashtable.ProbeANDinsertNotForever("MD");
	    myhashtable.ProbeANDinsertNotForever("MA");
	    myhashtable.ProbeANDinsertNotForever("MI");
	    myhashtable.ProbeANDinsertNotForever("MN");
	    myhashtable.ProbeANDinsertNotForever("MS");
	    myhashtable.ProbeANDinsertNotForever("MO");
	    myhashtable.ProbeANDinsertNotForever("MT");
	    myhashtable.ProbeANDinsertNotForever("NE");
	    myhashtable.ProbeANDinsertNotForever("NV");
	    myhashtable.ProbeANDinsertNotForever("NH");
	    myhashtable.ProbeANDinsertNotForever("NJ");
	    myhashtable.ProbeANDinsertNotForever("NM");
	    myhashtable.ProbeANDinsertNotForever("NY");
	    myhashtable.ProbeANDinsertNotForever("NC");
	    myhashtable.ProbeANDinsertNotForever("ND");
	    myhashtable.ProbeANDinsertNotForever("OH");
	    myhashtable.ProbeANDinsertNotForever("OK");
	    myhashtable.ProbeANDinsertNotForever("OR");
	    myhashtable.ProbeANDinsertNotForever("PA");
	    myhashtable.ProbeANDinsertNotForever("PR");
	    myhashtable.ProbeANDinsertNotForever("RI");
	    myhashtable.ProbeANDinsertNotForever("SC");
	    myhashtable.ProbeANDinsertNotForever("SD");
	    myhashtable.ProbeANDinsertNotForever("TN");
	    myhashtable.ProbeANDinsertNotForever("TX");
	    myhashtable.ProbeANDinsertNotForever("UT");
	    myhashtable.ProbeANDinsertNotForever("VT");
	    myhashtable.ProbeANDinsertNotForever("VA");
	    myhashtable.ProbeANDinsertNotForever("WA");
	    myhashtable.ProbeANDinsertNotForever("WV");
	    myhashtable.ProbeANDinsertNotForever("WI");
	    myhashtable.ProbeANDinsertNotForever("WY");
	            
	    myhashtable.ProbeANDdeleteButNoGapNotForever("VT");
	    myhashtable.displayTable();  
	    
	    /*HashTable myhashtable = new HashTable(52);
	    myhashtable.ProbeANDinsertNotForever("AL");
	    myhashtable.ProbeANDinsertNotForever("AK");
	    myhashtable.ProbeANDinsertNotForever("AZ");
	    myhashtable.ProbeANDinsertNotForever("AR");
	    myhashtable.ProbeANDinsertNotForever("FL");
	    myhashtable.ProbeANDinsertNotForever("CO");
	    myhashtable.ProbeANDinsertNotForever("CT");
	    myhashtable.ProbeANDinsertNotForever("DE");
	    myhashtable.ProbeANDinsertNotForever("ME");
	    System.out.println(myhashtable.ProbeANDfind("ME"));
	    myhashtable.ProbeANDdeleteButNoGapNotForever("ME");
	    System.out.println(myhashtable.ProbeANDfind("ME"));
	    System.out.println(myhashtable.ProbeANDfind("FL"));
	    System.out.println(myhashtable.ProbeANDfind("CA"));*/
	}

}
