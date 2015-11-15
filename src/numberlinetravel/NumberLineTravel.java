package numberlinetravel;

import java.util.LinkedList;
import java.util.List;

public class NumberLineTravel {

	/**
	 * Determine how many unique cities you can visit via monorail if you are
	 * limited to k kilometers per trip. You are permitted an infinite number of
	 * trips. You are given an array that represents city locations and you
	 * start your journey at the first city in the array.
	 * 
	 * @param x
	 *            is an array that represents the cities on a number line. The
	 *            distance between city x[i] and city x[j] is | x[i]-x[j] |
	 *            kilometers.
	 * @param k
	 *            represents the maximum distance, in kilometers, that one can
	 *            travel in one monorail trip. k should be greater than 0.
	 * @return the number of new cities that one can visit starting from x[0].
	 *         x[0] is not included in the count.
	 */
	public static int howManyCitiesCanIVisit(int[] x, int k) {
		// TODO: Implement this method
	    
	    int disTravellingE;
	    int disTravellingW;
	    int currCity;
	    int homeCity;
	    int cityVisited=0;
	    
	    List<Integer> cityList = new LinkedList<Integer>();
	    
	    //getting list of cities on the map 
	    for(int i = 0; i<x.length; i++){
	        cityList.add(x[i]);
	    }
	    System.out.println("city list is: "+ cityList+"\n");
	    
	    
	    //boolean cantGoEast = false;
	    
	    
	    //setting home city
	    homeCity = cityList.get(0);
	    currCity = homeCity;
	    System.out.println("homeCity is: "+currCity);
	    
	    //keep going east until you have no more cities to go to 
    	    for(disTravellingE = 1; disTravellingE<=k; disTravellingE++){
    	        
    	        System.out.println("\ndistance travelling east: "+disTravellingE);
    	        
    	        if(cityList.contains(currCity+disTravellingE)){
    	            currCity = currCity + disTravellingE;
    	            disTravellingE = 0;
    	            cityVisited++;
    	        }
    	       
    	        System.out.println("currCity is: "+currCity);
    	        System.out.println("# of cities visited is: "+cityVisited);
    	    }
	    
	    //go back home 
	    currCity = homeCity;
	    System.out.println("currCity is: "+currCity);
	    
	    System.out.println("");
	    System.out.println("travelling west\n");
	    
	    //keep going west until you have no more cities to go to 
        for(disTravellingW = 1; disTravellingW<=k; disTravellingW++){
            
            System.out.println("\ndistance travelling west: "+disTravellingW);
            
            if(cityList.contains(currCity-disTravellingW)){
                currCity = currCity - disTravellingW;
                disTravellingW = 0;
                cityVisited++;
            }

            System.out.println("currCity is: "+currCity);
            System.out.println("# of cities visited is: "+cityVisited+"\n");
        }
		return cityVisited;
	}
	
	/*
	 * problem: each time when you go to a new city, you need to reset disTravelling
	 */

}
