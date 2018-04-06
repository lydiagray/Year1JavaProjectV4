package TextAnalysis;

import java.util.ArrayList;

public class HelperMethods {
	
    public static boolean compareTwoArrays(int[] arrayOne, int[] arrayTwo) {             
        boolean equalOrNot = true;
         
        if(arrayOne.length == arrayTwo.length) {
            for (int i = 0; i < arrayOne.length; i++) {
                if(arrayOne[i] != arrayTwo[i]) {
                    equalOrNot = false;
                }
            }
        }
        else {
        	equalOrNot = false;
        }
        
        return equalOrNot;
    }
    
    public static boolean compareTwoArrays(String[] arrayOne, String[] arrayTwo) {             
        boolean equalOrNot = true;
         
        if(arrayOne.length == arrayTwo.length) {
            for (int i = 0; i < arrayOne.length; i++) {
                if(!arrayOne[i].equals(arrayTwo[i])) {
                    equalOrNot = false;
                }
            }
        }
        else {
        	equalOrNot = false;
        }  
        
        return equalOrNot;
    }
    
    public static boolean compareTwoArrays(char[] arrayOne, char[] arrayTwo) {             
        boolean equalOrNot = true;
         
        if(arrayOne.length == arrayTwo.length) {
            for (int i = 0; i < arrayOne.length; i++) {
                if(arrayOne[i] != (arrayTwo[i])) {
                    equalOrNot = false;
                }
            }
        }
        else {
        	equalOrNot = false;
        }  
        
        return equalOrNot;
    }
    
    public static boolean compareTwoArrayLists(ArrayList<Integer> expected, ArrayList<Integer> result) {
    	boolean equalOrNot = true;
    	
    	if (expected.size() == result.size()) {
    		for (int i = 0; i < expected.size(); i ++) {
        		if (expected.get(i) != result.get(i)) {
        				equalOrNot = false;
        		}
        	}
    	}
    	else {
    		equalOrNot = false;
    	}  
    	
    	return equalOrNot;
    }
    
    public static boolean compareTwoStringArrayLists(ArrayList<String> expected, ArrayList<String> result) {
    	boolean equalOrNot = true;
    	
    	if (expected.size() == result.size()) {
    		for (int i = 0; i < expected.size(); i ++) {
        		if (expected.get(i).equals(result.get(i))) {
        				equalOrNot = true;
        		}
        		else {
        			equalOrNot = false;
        		}
        	}
    	}
    	else {
    		equalOrNot = false;
    	}  
    	
    	return equalOrNot;
    }
}
