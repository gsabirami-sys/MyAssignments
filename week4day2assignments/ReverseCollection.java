package week4day2assignments;

import java.util.*;

public class ReverseCollection {

    public static void main(String[] args) {

        // Step 1: Declare String array
        String[] companies = {"HCL", "Wipro", "Aspire Systems", "CTS"};

        // Step 2: Add array to a list
        List<String> companyList = new ArrayList<>(Arrays.asList(companies));

        // Step 3: Arrange the collection in ascending order
        Collections.sort(companyList);

        // Step 4: Reverse loop to iterate and print
        for (int i = companyList.size() - 1; i >= 0; i--) {
            System.out.print(companyList.get(i));
            if (i != 0) {
                System.out.print(", ");
            }
        }
    }
}

