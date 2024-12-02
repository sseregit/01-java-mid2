package collection.deque.test.stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class BrowserHistory {

    private final Deque<String> stack = new ArrayDeque<>();

    public void visitPage(String domain) {
        stack.push(domain);
        System.out.println("방문: " + domain);
    }

    public String goBack() {
        if (!stack.isEmpty()) {
            stack.pop();
            System.out.println("뒤로 가기: " + stack.peek());
            return stack.peek();
        }
        return null;
    }
}
