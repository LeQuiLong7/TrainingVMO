package concurrency;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class ThreadSafetyWithCollections {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(4);
        list.add(6);
        list.add(7);
        list.add(8);


        // this will throw a ConcurrentModificationException
        // ArrayList only allows either update or read at a time
//        for(int i : list) {
//            System.out.println(i);
//            list.add(i);
//        }

        // concurrent collection
        list = new CopyOnWriteArrayList<>(list);
        for(int i : list) {
            System.out.println(i);
            list.add(i);
        }
    }
}
