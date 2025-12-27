package week3day1assignment;

public class ReverseOddWord {

	public static void main(String[] args) {
		
		 String test = "I am a software tester";
		// Split the string into words
	        String[] words = test.split(" ");
	        // Traverse through each word
	        for (int i = 0; i < words.length; i++) {
	        	 // If index is odd, reverse the word
	            if (i % 2 != 0) {

	                char[] charArray = words[i].toCharArray();

	                // Print reversed word using another loop
	                for (int j = charArray.length - 1; j >= 0; j--) {
	                    System.out.print(charArray[j]);
	                }
	            } 
	            // If index is even, print word as it is
	            else {
	                System.out.print(words[i]);
	            }
	         // Add space after each word
	            System.out.print(" ");
	        }
	}
}
