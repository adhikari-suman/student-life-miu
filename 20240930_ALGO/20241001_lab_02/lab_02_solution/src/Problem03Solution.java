import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Problem03Solution {
    public static void main(String[] args) {

    }

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

}
