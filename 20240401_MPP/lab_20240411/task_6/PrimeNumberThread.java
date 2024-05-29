package lab_20240411.task_6;

import java.util.List;

public class PrimeNumberThread extends Thread {

    private final int id;
    private final int start;
    private final int end;

    private  final List<String> strings;

    public PrimeNumberThread(int id, int start, int end, List<String> strings) {
        this.id = id;
        this.start = start;
        this.end = end;
        this.strings = strings;
    }

    @Override
    public void run() {

        System.out.printf("Thread #%d starts\n\n", id);

        for (int i = start; i <= end; i++) {
            if (isPrime(i)) {
                synchronized (strings){

                    strings.add(String.valueOf(i));

//                    System.out.printf("Thread #%2d Prime in range [%06d,%06d] is %06d\n", id, start, end, i);
                }


            }
        }

        System.out.printf("Thread #%d ends\n\n", id);
    }


    public boolean isPrime(int n) {
        // check base conditions
        if (n <= 0) return false;
        if (n == 1) return true;


        int i = 2;
        // check from [2, n/2)
        while (i <= n / 2) {
            if (n % i == 0)
                return false;

            i++;
        }

        return true;

    }
}
