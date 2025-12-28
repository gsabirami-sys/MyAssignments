package week4day1assignments;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindIntersectionList {

    public static void main(String[] args) {

        // Declare the arrays
        Integer[] arr1 = {3, 2, 11, 4, 6, 7};
        Integer[] arr2 = {1, 2, 8, 4, 9, 7};

        // Convert arrays to lists
        List<Integer> list1 = new ArrayList<>(Arrays.asList(arr1));
        List<Integer> list2 = new ArrayList<>(Arrays.asList(arr2));

        // Compare both lists and print common elements
        for (Integer num : list1) {
            if (list2.contains(num)) {
                System.out.println(num);
            }
        }
}
}