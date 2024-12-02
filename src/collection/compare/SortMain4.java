package collection.compare;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class SortMain4 {

    public static void main(String[] args) {
        MyUser myUser1 = new MyUser("a", 30);
        MyUser myUser2 = new MyUser("b", 20);
        MyUser myUser3 = new MyUser("c", 10);

        List<MyUser> list = new LinkedList<>();
        list.add(myUser1);
        list.add(myUser2);
        list.add(myUser3);

        System.out.println(list);

        list.sort(null);
        System.out.println("list.sort(null) " + list);

        list.sort(new IdComparator());
        System.out.println("list.sort(new IdComparator()) " + list);

        Collections.sort(list);
        System.out.println("Collections.sort(list) " + list);

        Collections.sort(list, new IdComparator());
        System.out.println("Collections.sort(list, new IdComparator()) " + list);
    }
}
