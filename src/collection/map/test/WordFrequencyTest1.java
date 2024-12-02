package collection.map.test;

import java.util.HashMap;
import java.util.Map;

public class WordFrequencyTest1 {

    public static void main(String[] args) {
        String text = "orange banana apple apple banana apple";

        // 코드 작성
        String[] texts = text.split(" ");

        Map<String, Integer> map = new HashMap<>();

        for (String t : texts) {
            map.put(t, map.getOrDefault(t, 0) + 1);
        }

        System.out.println(map);

    }
}
