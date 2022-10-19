package hw3.task4;

import java.util.*;

public class Experiment {
    private static final int COUNT = 20_000_000;
    private static final List<Integer> arrayList = new ArrayList<>(COUNT);
    private static final List<Integer> linkedList = new LinkedList<>();
    private static final Set<Integer> hashSet = new HashSet<>();
    private static final List<Integer> list = new ArrayList<>();

    public static void main(String[] args) {
        fillCollection(list, COUNT, 0, 1);
        long t1 = test(arrayList);
        long t2 = test(linkedList);
        long t3 = test(hashSet);
        System.out.println("t1/t3 = " + t1 / t3);
        System.out.println("t2/t3 = " + t2 / t3);
    }

    private static void process(Collection<Integer> firstCollection, List<Integer> list) {
        if (firstCollection.containsAll(list)) {
            System.out.println("Первая коллекция содержит все элементы списка");
        } else {
            System.out.println("Некоторые (или все) элементы из списка отсутствуют в первой коллекции");
        }
    }

    private static void fillCollection(Collection<Integer> collection, int from, int to, int step) {
        step = Math.abs(step);
        if (from < to) {
            for (int i = from; i <= to; i += step) {
                collection.add(i);
            }
        } else {
            for (int i = from; i >= to; i -= step) {
                collection.add(i);
            }
        }
    }

    private static long test(Collection<Integer> collection) {
        fillCollection(collection, 0, COUNT, 1);
        long t1 = System.currentTimeMillis();
        process(collection, list);
        long t2 = System.currentTimeMillis();
        long deltaT = t2 - t1;
        System.out.printf("%s - %dмс\n", collection.getClass().getSimpleName(), deltaT);
        return deltaT;
    }
}
