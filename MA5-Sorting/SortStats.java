/*
 *  Assignment: Implementing Quick, Merge, and Radix sort
 *
 *  [this file]: A tiny data object to snag stats during a sort
 *   Used in Main for testing output/results
 * 
 *  Contributors:
 *    Aaron S. Crandall <acrandal@wsu.edu>, 2019
 * 
 *  Copyright:
 *   For academic use only under the Creative Commons
 *   Attribution-NonCommercial-NoDerivatives 4.0 International License
 *   http://creativecommons.org/licenses/by-nc-nd/4.0
 */

class SortStats {
    public Long comparisons = 0L;
    public Long swaps = 0L;
}