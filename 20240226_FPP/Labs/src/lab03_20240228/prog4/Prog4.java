package lab03_20240228.prog4;

public class Prog4 {

	public static void main(String[] args) {
		// 1. Get the records
		String records = Data.records;

		// 2. Get each row
		String[] rows = records.split(":");
	
		
		// Fetch the ids and print it to the console
		for(int i=0;i<rows.length;i++) {
			// Get the row
			String row = rows[i];
			
			/**
			 * We can either use substring or split using ,
			 * Lets go with split,
			 * , method will be commented here as well
			 */
			String id = row.substring(0,4);
			
//			 // or 
//			id = row.split(",")[0];
			
			System.out.println(id);
			
		}
	}

}
