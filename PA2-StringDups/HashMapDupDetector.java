/*
 *  Assignment: Comparing String Duplicate Algorithms
 *
 *  BruteForceDupDetector: An N^2 "Biggest Hammer" approach to duplicate detection
 *   Duplicates Detector / Filter
 * 
 *  Contributors:
 *    Aaron S. Crandall <acrandal@wsu.edu>, 2019
 * 
 *  Copyright:
 *   For academic use only under the Creative Commons
 *   Attribution-NonCommercial-NoDerivatives 4.0 International License
 *   http://creativecommons.org/licenses/by-nc-nd/4.0
 */

import java.util.ArrayList;
import java.util.HashMap;

class HashMapDupDetector extends StringDupDetectorBase {

    public HashMapDupDetector() {
        // Constructor - should set your algorithms general metadata

        // Give your algorithm a name to identify it
        algorithm_name = "HashMap O(1) Hotrod!";

        // Describe the key feature(s) of your algorithm
        description = "Uses a whatawhat?";

        // Estimate your algorithm's complexity
        complexity = "I dunno!";
    }

    // The one function that does the duplicates detection for your algorithm.
    // This function is called by the testing code
    // It returns a list of duplicate strings found - NOTE: you CANNOT have
    // duplicates in the results themselves!
    @Override
    public ArrayList<String> doDupDetection(ArrayList<String> strings) {
        // These two arrays are stored in the results when your algorithm is done
        // NOTE: The duplicates ArrayList *cannot* have duplicates within itself!
        ArrayList<String> duplicates = new ArrayList<>(); // Lists a set of strings that appear more than once

        HashMap<String, String> map = new HashMap<>(); // hashtable that accept strings for thier key

        for (int i = 0; i < strings.size(); i++) { // iterate through each string in an ArrayList of Strings
            String str = strings.get(i); // get the string from index i
            // if hashtable has current index string and duplicate arraylist doesnot 
            if (map.containsKey(str) && (!duplicates.contains(str))) {
                duplicates.add(str); // add the current index to duplicate arraylist 
            } else {

                map.put(str, null);// otherwise add into hashtable
            }
        }

       

        // return the string lists which appear more than once from the parameter string
        
        return duplicates;

    }
}