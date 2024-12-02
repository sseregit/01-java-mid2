package collection.map.test.cart;

import java.util.HashMap;
import java.util.Map;

public class Cart {

    private final Map<Product, Integer> cartMap = new HashMap<>();

    public void add(Product product, int quantity) {
        cartMap.put(product, cartMap.getOrDefault(product, 0) + quantity);
    }

    public void printAll() {
        System.out.println("==모든 상품 출력==");
        for (Map.Entry<Product, Integer> cart : cartMap.entrySet()) {
            System.out.println("상품: " + cart.getKey() + " 수량: " + cart.getValue());
        }
    }

    public void minus(Product product, int quantity) {
        int count = cartMap.getOrDefault(product, 0) - quantity;

        if (count > 0) {
            cartMap.put(product, count);
        } else {
            cartMap.remove(product);
        }
    }
}
