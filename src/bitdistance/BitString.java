package bitdistance;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BitString {

	/**
	 * Given a bit string (string with only 0s and 1s), return the number of
	 * substrings that are weight balanced.
	 * 
	 * @param bitstring should not contain characters other than 0 and 1
	 * 
	 * @return number of weight balanced substrings of bitstring
	 */
	public static int countWBsubstrings(String bitstring) {
	    List<String> allSubstring = new ArrayList<String>();
	    List<String> allBalancedSubstring = new ArrayList<String>();
	    
		for(int i=0; i<bitstring.length(); i++){
		    if(bitstring.charAt(i)!='1' & bitstring.charAt(i)!='0'){
		        throw new IllegalArgumentException();
		    }
		}
		
		allSubstring = getAllSubstring(bitstring);
		
		for(String s : allSubstring){
		    for(int index = 0; index<s.length(); index++){
		        if(isWeightBalanced(s, index)){
		            allBalancedSubstring.add(s);
		            break;
		        }
		    }
		}
		    
		return allBalancedSubstring.size();
	}
	
	private static List<String> getAllSubstring (String bitstring){
	    int start, end;
	    List<String> returnList = new ArrayList<String>();
	    
	    for(start = 0; start < bitstring.length(); start++){
	        for(end = start; end <= bitstring.length(); end++){
	            String substring = bitstring.substring(start, end);
	            if(!substring.isEmpty())
	            returnList.add(bitstring.substring(start, end));
	        }
	    }
	    return returnList;
	}
	
	private static Boolean isWeightBalanced (String bitstring, int posj){
	    int weightToLeft = 0;
	    int weightToRight = 0;
	    
	    //to the left
	    for(int index=0; index<posj; index++){
	        if(bitstring.charAt(index)=='1'){
	            weightToLeft += Math.abs(posj-index);
	        }
	    }
	    
	    //to the right
	    for(int index = posj; index<bitstring.length(); index++){
	           if(bitstring.charAt(index)=='1'){
	                weightToRight += Math.abs(posj-index);
	            }
	    }
	    
	    return weightToLeft==weightToRight;
	}
}
