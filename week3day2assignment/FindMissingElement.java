package week3day2assignment;
import java.util.Arrays;

public class FindMissingElement {

    public static void main(String[] args) {

        int[] arr = {1, 4, 3, 2, 8, 6, 7};

        // Step 1: Sort the array
        Arrays.sort(arr);

        // Step 2: Loop through the array
        for (int i = arr[0]; i < arr.length; i++) {

            // Step 3: Check for missing element
            if (arr[i - 1] != i) {
                System.out.println("Missing Number is: " + i);
                break;
            }
        }
    }
}
