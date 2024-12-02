package collection.iterable;

import java.util.Iterator;

public class MyArray implements Iterable<Integer> {

    private final int[] numbers;

    public MyArray(int[] numbers) {
        this.numbers = numbers;
    }

    @Override
    public Iterator<Integer> iterator() {
        return new MyArrayIterator(numbers);
    }

}
