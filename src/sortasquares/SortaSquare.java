package sortasquares;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SortaSquare {

	/**
	 * Return a subset of SortaSquares from the integers in set s.
	 * 
	 * @param s
	 *            the set from which we want to extract SortaSquares
	 * @return a subset with all the SortaSquares in s
	 */
	public static Set<Integer> getSortaSquares(Set<Integer> s) {
	    //to be a SortaSquare, the integer must be a perfect square first
	    List<Double> perfectSquare = new ArrayList<Double>();
	    Set<Integer> sortaSquare = new HashSet<Integer>();
	    int largestPosNum = Integer.MIN_VALUE;

	    
	    //get the largest positive number in s
	    for(int i : s){
	        if (i > largestPosNum)
	            largestPosNum = i;
	    }
	    
	    //generate a list of perfect squares in which the biggest perfect square <= largest number in s
	    for(int root = 1; (root*root)<=largestPosNum; root++){
	        perfectSquare.add((double)root*root);
	    }
	    
	    for(int i : s){
	        for(int factor = 1; factor < i; factor++){
	            if(perfectSquare.contains(i/(double)factor)){
	                if((factor*factor)<=(i/(factor*factor)))
	                    sortaSquare.add(i);
	            }
	        }      
	    } 
	    return sortaSquare;
	}

}
