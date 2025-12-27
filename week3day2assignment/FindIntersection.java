package week3day2assignment;

public class FindIntersection {
	
	 public static void main(String[] args) {
		 
		  // Declare first array
	        int[] a = {3, 2, 11, 4, 6, 7};

	        // Declare second array
	        int[] b = {1, 2, 8, 4, 9, 7};

	        // Loop through first array
	        for (int i = 0; i < a.length; i++) {

	            // Nested loop through second array
	            for (int j = 0; j < b.length; j++) {

	                // Compare elements of both arrays
	                if (a[i] == b[j]) {
	                    System.out.println(a[i]);
	                }
	            }
	        }
	    }

}
