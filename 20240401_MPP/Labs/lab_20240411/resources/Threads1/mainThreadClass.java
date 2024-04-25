package lab_20240411.resources.Threads1;

public class mainThreadClass {

    public static void main( String[] args ) {

        System.out.println("Inside main  ");        

        PrimeThread p = new PrimeThread(143);
        p.start();

    }
}
