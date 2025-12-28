package week4day1assignments;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MissingNumbers {

	public static void main(String[] args) {
		Integer[] arr = {1, 2, 3, 4, 10, 6, 8};

        // Convert array to list
        List<Integer> list = new ArrayList<>(Arrays.asList(arr));

        // Sort the list in ascending order
        Collections.sort(list);

        // Loop through the list to find gaps
        for (int i = 0; i < list.size() - 1; i++) {

            int current = list.get(i);
            int next = list.get(i + 1);

            // Check if there is a gap
            if (current + 1 != next) {
                for (int missing = current + 1; missing < next; missing++) {
                    System.out.println("Missing number: " + missing);
                }
            }
        }

	}

}
