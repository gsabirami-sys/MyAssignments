package week4day1assignments;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SecondLargest {
	 public static void main(String[] args) {

    // Declare the array
    Integer[] arr = {3, 2, 11, 4, 6, 7};

    // Convert array to list
    List<Integer> list = new ArrayList<>(Arrays.asList(arr));

    // Sort the list in ascending order
    Collections.sort(list);

    // Pick the 2nd element from the last
    int secondLargest = list.get(list.size() - 2);

    // Print the second largest number
    System.out.println("Second largest number: " + secondLargest);
}
}