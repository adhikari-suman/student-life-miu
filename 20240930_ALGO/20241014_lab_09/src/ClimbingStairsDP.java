public class ClimbingStairsDP {

    public int climbStairs(int n) {
        int[] steps = new int[n + 1];

        steps[0] = 1;   // reached a solution
        steps[1] = 1;   // exists one solution

        for (int i = 2; i <= n; i++) {
            steps[i] = -1;
        }

        return climbStairsDP(n, steps);
    }

    private int climbStairsDP(int n, int[] steps) {
        if(n == 0 || n == 1)
            return 1;

        if(n < 0){
            return 0;
        }

        if(steps[n] != -1){
            return steps[n];
        }

        steps[n] = climbStairsDP(n-1, steps) + climbStairsDP(n-2, steps);

        return steps[n];
    }

    public static void main(String[] args) {
        ClimbingStairsDP dp =  new ClimbingStairsDP();

        System.out.println(dp.climbStairs(1));
        System.out.println(dp.climbStairs(2));
        System.out.println(dp.climbStairs(3));
        System.out.println(dp.climbStairs(4));
    }
}
