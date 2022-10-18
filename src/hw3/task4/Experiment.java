package hw3.task4;

import java.math.BigInteger;
import java.time.Instant;
import java.util.*;

public class Experiment {

    private static final int COUNT = 100_000;

    private static List<Integer> firstArrayList = new ArrayList<>(COUNT);
    private static List<Integer> firstLinkedList = new LinkedList<>();
    private static Set<Integer> firstHashSet = new HashSet<>();

    private static final List<Integer> list = new ArrayList<>();


    public static void main(String[] args) {

        fillCollection(list, 0, COUNT);

        test(firstArrayList);
        //firstArrayList = null;
        test(firstLinkedList);
        //firstLinkedList = null;
        test(firstHashSet);

    }

    private static void process(Collection<Integer> firstCollection, List<Integer> list) {
        if (firstCollection.containsAll(list)) {
            System.out.println("Первая коллекция содержит все элементы списка");
        } else {
            System.out.println("Некоторые (или все) элементы из списка отсутствуют в первой коллекции");
        }
    }

    private static void fillCollection(Collection<Integer> collection, int from, int to) {
        for (int i = from; i < to; i++) {
            collection.add(i);
        }
    }

    private static void test(Collection<Integer> collection) {
        fillCollection(collection, 0, COUNT);
        long t1 = System.currentTimeMillis();
        process(collection, list);
        long t2 = System.currentTimeMillis();
        long deltaT = t2 - t1;
        System.out.printf("%s - %dмс\n", collection.getClass().getSimpleName(), deltaT);
    }
}
