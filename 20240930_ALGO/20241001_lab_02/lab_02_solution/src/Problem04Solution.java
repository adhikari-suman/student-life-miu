import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Problem04Solution {
    public static void main(String[] args) {
        Problem04Solution solution = new Problem04Solution();

        List<List<Integer>> inputs = new ArrayList<>(List.of(
                        new ArrayList<>(List.of(1, 3, 9, 4, 8, 5)),
                        new ArrayList<>(List.of(1, 3, 9)),
                        new ArrayList<>(List.of(1, 3, 9, 4, 8, 5))
                       ));

        int[] ks = new int[]{4, 5, 0};

        for (int i = 0; i < inputs.size(); i++){
            System.out.printf("Array: %s%n", inputs.get(i));
            System.out.printf("Sum of %d exists in subset: %s %n%n",
                              ks[i],
                              solution.subsetSumExists(inputs.get(i), ks[i]));
        }


    }

    Set<Integer> subsetSumExists(List<Integer> X, int k){
        List<Set<Integer>> P = new ArrayList<>();
        Set<Integer> S = new HashSet<>();

        if (k == 0)
            return S;

        P.add(S);

        Integer sum = 0;

        while (!X.isEmpty()){
            Integer f = X.remove(0);

            List<Set<Integer>> newSubsets = new ArrayList<>();

            sum = 0;

            for (var x : P) {
                Set<Integer> newSubset = new HashSet<>(x);
                newSubset.add(f);

                sum = newSubset.stream().mapToInt(Integer::valueOf).sum();

                if (sum == k){
                    return newSubset;
                }

                newSubsets.add(newSubset);
            }

            P.addAll(newSubsets);
        }

        return null;
    }
}
