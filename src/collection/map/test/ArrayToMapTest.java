package collection.map.test;

import java.util.HashMap;
import java.util.Map;

public class ArrayToMapTest {

    public static void main(String[] args) {
        String[][] productArr = {{"Java", "10000"}, {"Spring", "20000"}, {"JPA", "30000"}};
        // 주어진 배열로부터 Map 생성 - 코드 작성
        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < productArr.length; i++) {
            map.put(productArr[i][0], Integer.valueOf(productArr[i][1]));
        }
        // Map의 모든 데이터 출력 - 코드 작성
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println("제품: " + entry.getKey() + ", 가격: " + entry.getValue());
        }
    }
}
