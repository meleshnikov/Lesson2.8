package hw2.task2;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class Solution {
    public static void main(String[] args) {
        Set<Integer> intSet = new HashSet<>();
        Random random = new Random();
        for (int i = 0; i < 20; i++) {
            intSet.add(random.nextInt(1001));
        }
        System.out.println(intSet);
        intSet.removeIf(num -> num % 2 == 0);
        System.out.println(intSet);
    }


}
