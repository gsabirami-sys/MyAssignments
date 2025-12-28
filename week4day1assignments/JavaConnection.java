package week4day1assignments;

public class JavaConnection implements DatabaseConnection {

	@Override
	public void connect() {
		System.out.println("Database connected successfully.");
		
	}

	@Override
	public void disconnect() {
		System.out.println("Database disconnected successfully.");
		
	}

	@Override
	public void executeUpdate() {
		System.out.println("Update executed on the database.");
	}
		
		 public static void main(String[] args) {

			 JavaConnection db = new JavaConnection();

		        db.connect();
		        db.executeUpdate();
		        db.disconnect();
		
	}

}
