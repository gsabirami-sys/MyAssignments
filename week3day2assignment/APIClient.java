package week3day2assignment;

public class APIClient {
	
	

	    // Overloaded Method 1: Accepts only endpoint
	    public void sendRequest(String endpoint) {
	        System.out.println("Sending request to endpoint: " + endpoint);
	    }

	    // Overloaded Method 2: Accepts endpoint, requestBody, and requestStatus
	    public void sendRequest(String endpoint, String requestBody, boolean requestStatus) {
	        System.out.println("Sending request to endpoint: " + endpoint);
	        System.out.println("Request Body: " + requestBody);
	        System.out.println("Request Successful: " + requestStatus);
	    }

	    // Main method to demonstrate method overloading
	    public static void main(String[] args) {

	        // Create object of APIClient class
	        APIClient apiClient = new APIClient();

	        // Call first version of sendRequest
	        apiClient.sendRequest("/getUsers");

	        System.out.println("--------------------");

	        // Call second version of sendRequest
	        apiClient.sendRequest("/createUser", "{name: 'Abi', role: 'Admin'}", true);
	    }
	}



