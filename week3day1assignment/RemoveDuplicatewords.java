package week3day1assignment;

public class RemoveDuplicatewords {
	
	  public static void main(String[] args) {

	        String text = "We learn Java basics as part of java sessions in java week1";

	        // Step 1: Initialize count variable
	        int count = 0;

	        // Step 2: Split the string into words
	        String[] words = text.split(" ");

	        // Step 3: Compare each word with every other word
	        for (int i = 0; i < words.length; i++) {
	            for (int j = i + 1; j < words.length; j++) {

	                // Step 4: Case-insensitive comparison
	                if (words[i].equalsIgnoreCase(words[j])) {

	                    // Replace duplicate word with empty string
	                    words[j] = "";
	                    count++;
	                }
	            }
	        }

	        // Step 5: Print modified array if duplicates found
	        if (count >= 1) {
	            for (String word : words) {
	                System.out.print(word + " ");
	            }
	        }
	    }
	}

