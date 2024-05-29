package lab_20240411.task_5;


public class ThreadMain {
    public static void main(String[] args) {

        System.out.println("**************** Before Starting Thread ****************");

        // find primes in the range of 0 to 1,000,000 using 5 threads
        for (int i = 0; i <= 9; i++) {

            int start = 100_000 * i + 1;

            int end = 100_000 * (i + 1);

            Thread t = new PrimeNumberThread(i+1, start, end);

            t.start();

        }

        System.out.println("**************** After Thread Execution ****************");
    }
}
