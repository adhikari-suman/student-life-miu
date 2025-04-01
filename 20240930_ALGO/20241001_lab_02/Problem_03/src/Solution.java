import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();

        List<Integer> list = new ArrayList<>(List.of(1,2,3));

        var result = solution.powerSet(list);

        System.out.printf("Number of powerset for array %s is: %s", List.of(1,2,3), result);

//        solution.countOnesAndZeroes(new int[]{1});
//        solution.countOnesAndZeroes(new int[]{0, 0, 1, 1, 1});
//        solution.countOnesAndZeroes(new int[]{0, 0, 0, 0, 0, 1, 1, 1});
    }


    /**
     * Algorithm: PowerSet(X)
     * Input: A list X of elements
     * Output: A list P consisting of all subsets of X – elements of P are Sets
     *      P ← new list
     *      S ← new Set //S is the empty set
     *
     *      P.add(S) //P is now the set { S }
     *
     *      T ← new Set
     *
     *      while (!X.isEmpty() ) do
     *          f ← X.removeFirst()
     *
     *          for each x in P do
     *              T ← x U {f} // T is the set containing f & all elements of x
     *              P.add(T)
     *      return P
     */
    List<Set<Integer>> powerSet(List<Integer> X){
        List<Set<Integer>> P = new ArrayList<>();
        Set<Integer> S = new HashSet<>();

        P.add(S);

        while (!X.isEmpty()){
            Integer f = X.remove(0);

            List<Set<Integer>> newSubsets = new ArrayList<>();

            for (var x : P) {
                Set<Integer> newSubset = new HashSet<>(x);
                newSubset.add(f);
                newSubsets.add(newSubset);
            }

            P.addAll(newSubsets);
        }

        return P;
    }

    void countOnesAndZeroes(int[] arr) {
        int left  = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == 1) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        int numberOfZeroes = left;
        int numberOfOnes   = arr.length - left;

        System.out.println("Array: " + Arrays.toString(arr));
        System.out.println("Number of zeroes: " + numberOfZeroes);
        System.out.println("Number of ones: " + numberOfOnes);

    }

}
