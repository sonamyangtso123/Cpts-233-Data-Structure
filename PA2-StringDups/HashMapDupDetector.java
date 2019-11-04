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

        HashMap<String, String> map = new HashMap<>(); // hashtable that accept strings that appear once for their key
        HashMap<String, String> duplicateLists = new HashMap<>();// hashtable that accept strings that appear more than
                                                                 // once

        for (int i = 0; i < strings.size(); i++) { // iterate through each string in a list of Strings
            String currentStr = strings.get(i); // get the current index string

            if (!map.containsKey(currentStr)) { // if current string is not in the hash table as key
                map.put(currentStr, null); // add to hashtable for key and put null for value
            } else {

                duplicateLists.put(currentStr, null);// if current string is present in the hash table, add here
            }
        }

        for (String key : duplicateLists.keySet()) { // iterate through each key
            duplicates.add(key); // add to an arraylist that accept strings that appear more than once
        }

        // return the string lists which appear more than onoce from the parameter
        // strings.
        return duplicates;

    }
}