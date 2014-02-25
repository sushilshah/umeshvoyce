package com.voyce.quiz.engine;

import java.util.Comparator;
import java.util.Map;

public class OtherUtils {

	
	/**
	 * Class ValueComparator will sort the TreeMap with value. only for Map<Double, Double> 
	 * @author sushil_k_shah
	 *
	 */
	
/*	Usage Example
 * 	HashMap<Double,Double> map = new HashMap<Double,Double>();
    ValueComparator bvc =  new ValueComparator(map);
    TreeMap<Double,Double> sorted_map = new TreeMap<Double,Double>(bvc);
   //Change it to Double, Double map.put("A",99.5);    map.put("B",67.4);    map.put("C",67.4);    map.put("D",67.3);
    System.out.println("unsorted map: "+map);
    sorted_map.putAll(map);
    System.out.println("results: "+sorted_map);
}*/
	public static class ValueComparator implements Comparator<Double> {

	    Map<Double, Double> base;
	    public ValueComparator(Map<Double, Double> base) {
	        this.base = base;
	    }

	    // Note: this comparator imposes orderings that are inconsistent with equals.    
	    public int compare(Double a, Double b) {
	        if (base.get(a) >= base.get(b)) {
	            return -1;
	        } else {
	            return 1;
	        } // returning 0 would merge keys
	    }
	}
}
