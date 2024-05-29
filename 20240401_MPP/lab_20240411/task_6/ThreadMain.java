package lab_20240411.task_6;


import java.util.ArrayList;
import java.util.List;

public class ThreadMain {
    public static void main(String[] args) throws InterruptedException {

        System.out.println("**************** Before Starting Thread ****************");

        List<String> strings = new ArrayList<>();

        List<Thread> threads = new ArrayList<>();

        // find primes in the range of 0 to 1,000,000 using 5 threads
        for (int i = 0; i <= 9; i++) {

            int start = 100_000 * i + 1;

            int end = 100_000 * (i + 1);
            Thread t = new PrimeNumberThread(i + 1, start, end, strings);

            threads.add(t);
            t.start();
//            t.join();

        }

        for (var t: threads){
            t.join();
        }


        String string = String.join(", ", strings);

        System.out.println(string);
        

        System.out.println("**************** After Thread Execution ****************");
    }
}
