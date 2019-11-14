/*
 *  Assignment: Implementing Quick, Merge, and Radix sort
 *
 *  [this file]: QuickSort Implementation
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

public class QuickSort<T extends Comparable<T>> extends Sorter<T> {
    QuickSort() {
        name = "QuickSort";
    }

    public ArrayList<T> sort(SortStats stats, ArrayList<T> data) {
        Quicksort(data, 0, data.size() - 1, stats);

        return data;
    }

    private void Quicksort(ArrayList<T> data, int left, int right, SortStats stats) {
        if (left + 10 <= right) {
            int center = (left + right) / 2; // find middle index
            // sort low ,high and median value
            // place the median value at the end of the arraylist
            if (data.get(center).compareTo(data.get(left)) < 0) {
                stats.swaps++;
                swap(data, left, center);
            }

            if (data.get(right).compareTo(data.get(left)) < 0) {
                stats.swaps++;
                swap(data, left, right);

            }

            if (data.get(right).compareTo(data.get(center)) < 0) {
                stats.swaps++;
                swap(data, center, right);
            }

            // get pivot
            T pivot = data.get(right);

            int i = left - 1;
            // move values less than pivot to the left and greater than pivot to the right
            for (int j = left; j < right; j++) {
                stats.comparisons++;
                if (data.get(j).compareTo(pivot) < 0) {
                    i++;
                    stats.swaps++;
                    swap(data, i, j);
                }
            }
            stats.swaps++;
            // move pivot
            swap(data, i + 1, right);

            Quicksort(data, left, i - 1, stats); // Sort small elements
            Quicksort(data, i + 1, right, stats); // Sort large elements
        }

        else {
            InsertionSort(stats, data);

        }
    }

    // method to swap elements in the arraylist
    private void swap(ArrayList<T> data, int left, int right) {
        T temp = data.get(left);

        data.set(left, data.get(right));
        data.set(right, temp);

    }

    // insersion sort method for arraylist size less than 10
    private void InsertionSort(SortStats stats, ArrayList<T> data) {

        for (int i = 1; i < data.size(); i++) {
            T value = data.get(i);
            int j = i - 1;
            while (j >= 0) {
                T curr_candidate = data.get(j);
                stats.comparisons++;
                if (curr_candidate.compareTo(value) > 0) {

                    stats.swaps++;
                    data.set(j + 1, curr_candidate);
                    j--;
                } else {
                    break;
                }
            }

            data.set(j + 1, value);
        }

    }
}
