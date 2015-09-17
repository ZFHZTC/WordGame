package wordGame;

/* package whatever; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class WordGame
{
    public static void main (String[] args) throws java.lang.Exception
    {
        // your code goes here
    	//create four inputs
    	int length=10;
        String crystal="BFIBZRAFBF";
        int swap =2;
        String swapPoint = "3 4";       
        String result="";
        List<Integer> sp = new ArrayList<>();
        
        sp=toArrayList(swapPoint);

        /*----- this is how to get the inputs ------   */  
//        Scanner input = new Scanner(System.in).useDelimiter("\\n\\n*");
//        length = Integer.parseInt(input.next());
//        crystal=input.next();
//        swap=Integer.parseInt(input.next());
//        swapPoint=input.next();

        result=wordGame(crystal, swap, sp);
        System.out.println(result);
      
    }

	private static String wordGame( String crystal, int swap,
			List<Integer> sp) {
		
		String working=crystal;
		
		for (int i=0; i<swap; i++){
			working=swapword(working, sp.get(i));
			working=removeComp(working);
		}		
		return working;
	}
			
	private static String swapword(String crystal, Integer integer) {
		//swap the character
		char c []=crystal.toCharArray();
		char temp = c[integer];
		c[integer]=c[integer+1];
		c[integer+1]=temp;
		return new String(c);
		}


//remove compound words in the newly swapped string
	private static String removeComp(String working) {
		//FIZ BAR BAZ ZIF RAB ZAB 
		//FIZIF FIZAB BARAB BAZIF BAZAB ZIFIZ RABAR ZABAZ ZABAR
		
		String FIZ = "FIZ";
		String BAR = "BAR";
		String BAZ = "BAZ";
		String ZIF = "ZIF";
		String RAB = "RAB";
		String ZAB = "ZAB";
		String FIZIF = "FIZIF";
		String FIZAB = "FIZAB";
		String BARAB = "BARAB";
		String BAZIF = "BAZIF";
		String BAZAB = "BAZAB";
		String ZIFIZ = "ZIFIZ";
		String RABAR = "RABAR";
		String ZABAZ = "ZABAZ";
		String ZABAR = "ZABAR";
		String NoComp="";
		
		if (working.contains(FIZIF)) NoComp=working.replaceAll(FIZIF, "");
		else if (working.contains(FIZAB)) NoComp=working.replaceAll(FIZAB, "");
		else if (working.contains(BARAB)) NoComp=working.replaceAll(BARAB, "");
		else if (working.contains(BAZIF)) NoComp=working.replaceAll(BAZIF, "");
		else if (working.contains(BAZAB)) NoComp=working.replaceAll(BAZAB, "");
		else if (working.contains(ZIFIZ)) NoComp=working.replaceAll(ZIFIZ, "");
		else if (working.contains(RABAR)) NoComp=working.replaceAll(RABAR, "");
		else if (working.contains(ZABAZ)) NoComp=working.replaceAll(ZABAZ, "");
		else if (working.contains(ZABAR)) NoComp=working.replaceAll(ZABAR, "");
		else if (working.contains(FIZ)) NoComp=working.replaceAll(FIZ, "");
		else if (working.contains(BAR)) NoComp=working.replaceAll(BAR, "");
		else if (working.contains(BAZ)) NoComp=working.replaceAll(BAZ, ""); 
		else if (working.contains(ZIF)) NoComp=working.replaceAll(ZIF, "");
		else if (working.contains(RAB)) NoComp=working.replaceAll(RAB, ""); 
		else if (working.contains(ZAB)) NoComp=working.replaceAll(ZAB, "");
		//new StringBuilder(FIZ).reverse().toString();
		return NoComp;
	}
	//convert String to Integer ArrayList
	private static List<Integer> toArrayList(String line) {
		List<String> tempString = new ArrayList<>();
		List<Integer> tempInt = new ArrayList<>();			 	
		tempString=Arrays.asList(line.split("\\s+"));
		
        for (int n=0; n<tempString.size();n++)
        {
        	tempInt.add(Integer.parseInt(tempString.get(n)));
        }		
		return tempInt;
	}   

}