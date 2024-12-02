package collection.set.test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SetOperationsTest {

    public static void main(String[] args) {
        Set<Integer> set1 = new HashSet<>(List.of(1, 2, 3, 4, 5));
        Set<Integer> set2 = new HashSet<>(List.of(3, 4, 5, 6, 7));

        union(set1, set2);

        intersection(set1, set2);

        difference(set1, set2);
    }

    private static void difference(Set<Integer> set1, Set<Integer> set2) {
        Set<Integer> tempSet1 = new HashSet<>(set1);

        tempSet1.removeAll(set2);
        System.out.println("차집합: " + tempSet1);
    }

    private static void intersection(Set<Integer> set1, Set<Integer> set2) {
        Set<Integer> tempSet1 = new HashSet<>(set1);

        tempSet1.retainAll(set2);
        System.out.println("교집합: " + tempSet1);
    }

    private static void union(Set<Integer> set1, Set<Integer> set2) {
        Set<Integer> tempSet1 = new HashSet<>(set1);

        tempSet1.addAll(set2);
        System.out.println("합집합: " + tempSet1);
    }

}
