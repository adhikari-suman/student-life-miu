package lab_20240411.task_4;



public class ThreadMain {
    public static void main(String[] args) {

        System.out.println("**************** Before Starting Thread ****************");

        // find primes in the range of 0 to 1,000,000 using 5 threads
        for (int i = 0; i <= 4; i++) {

            // 1, 200_001, 400_001, 600_001, 800_001
            int start = 200_000 * i + 1;

            //  200_000, 400_000, 600_000, 800_000, 1_000_000
            int end = 200_000 * (i + 1);

            Thread t = new PrimeNumberThread(i+1, start, end);

            t.start();

        }

        System.out.println("**************** After Thread Execution ****************");
    }
}
