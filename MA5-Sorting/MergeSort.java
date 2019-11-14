/*
 *  Assignment: Implementing Quick, Merge, and Radix sort
 *
 *  [this file]: MergeSort Implementation
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

public class MergeSort<T extends Comparable<T>> extends Sorter<T> {
    MergeSort() {
        name = "MergeSort";
    }

    public ArrayList<T> sort(SortStats stats, ArrayList<T> data) {

        if (data.size() > 1) {
            // find middle index
            int mid = data.size() / 2;

            ArrayList<T> left = new ArrayList<T>();// create temp arraylist
            ArrayList<T> right = new ArrayList<T>();
            for (int i = 0; i < mid; i++) {// copy elements into temp arraylist
                left.add(data.get(i));
            }
            for (int j = mid; j < data.size(); j++) { // copy elements into temp arraylist
                right.add(data.get(j));
            }

            left = sort(stats, left); // call sort on first half of elements
            right = sort(stats, right);// call sort on second half of elements

            merge(data, left, right, stats);// merge two halves in sorted
        }

        return data;
    }

    // merge method
    private void merge(ArrayList<T> result, ArrayList<T> left, ArrayList<T> right, SortStats stats) {
        int leftIndex = 0;
        int rightIndex = 0;
        int resultIndex = 0;
        while (leftIndex < left.size() && rightIndex < right.size()) { // if there is elements in both arraylists
            stats.comparisons++;
            if (left.get(leftIndex).compareTo(right.get(rightIndex)) <= 0) {

                result.set(resultIndex, left.get(leftIndex));
                leftIndex++;
            } else {
                result.set(resultIndex, right.get(rightIndex));
                rightIndex++;
            }

            resultIndex++;
        }

        while (leftIndex < left.size() && rightIndex >= right.size()) {
            result.set(resultIndex, left.get(leftIndex));
            leftIndex++;
            resultIndex++;
        }

        while (rightIndex < right.size() && leftIndex >= left.size()) {
            result.set(resultIndex, right.get(rightIndex));
            rightIndex++;
            resultIndex++;
        }
    }
}
