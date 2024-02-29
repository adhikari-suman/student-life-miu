package lab03_20240228.prog7;

public class Prog7 {

	public static void main(String[] args) {
		
		final int NUM_ROWS=2, NUM_COLS=4;
		
		// loop for two rows
		for(int i=0; i<NUM_ROWS;i++) {
			// line 1
			for(int j=0;j<NUM_COLS;j++) {
				System.out.printf("%4d    ",RandomNumbers.getRandomInt(1,99 ) );
			}
			System.out.println();
			
			// line 2
			for(int j=0;j<NUM_COLS;j++) {
				System.out.printf("+%3d    ",RandomNumbers.getRandomInt(1,99 ));
			}
			System.out.println();
			
			// line 3
			for(int j=0;j<NUM_COLS;j++) {
				System.out.printf("%4s    ","____" );
			}
			System.out.println("\n\n\n");
			
		}
	}

}
