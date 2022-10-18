package hw3.task2;

import java.util.*;

public class Solution {

    private static final Random random = new Random();

    public static void main(String[] args) {
        System.out.println("1 способ");
        printRandomMultiplicationTable1(2, 9, 15);

        System.out.println("\n2 способ");
        printRandomMultiplicationTable2(2, 9, 15);
    }

    //1 способ с применением List
    private static void printRandomMultiplicationTable1(int from, int to, int count) {
        if (count < 0) {
            throw new IllegalArgumentException("Количество примеров не может быть отрицательным");
        }
        if (from > to) {
            int tmp = from;
            from = to;
            to = tmp;
        }
        ArrayList<String> allExamples = new ArrayList<>();
        // заполняем list всеми возможными примерами из диапазона from - to
        for (int i = from; i <= to; i++) {
            for (int j = i; j <= to; j++) {
                allExamples.add(String.format("%d*%d", i, j));
            }
        }
        // перемешиваем
        Collections.shuffle(allExamples);
        if (count > allExamples.size()) {
            count = allExamples.size();
        }
        // печатаем нужное количество
        for (int i = 0; i < count; i++) {
            System.out.println(allExamples.get(i));
        }
    }

    // 2 способ с применением Set
    private static void printRandomMultiplicationTable2(int from, int to, int count) {
        if (count < 0) {
            throw new IllegalArgumentException("Количество примеров не может быть отрицательным");
        }
        if (from > to) {
            int tmp = from;
            from = to;
            to = tmp;
        }
        // количество всех цифр таблицы умножения
        int n = Math.abs(to + 1 - from);
        // максимальное количество возможных вариантов примеров
        // сумма арифметической прогрессии от 1 до n
        int maxCount = (1 + n) * n / 2;
        if (count > maxCount) {
            count = maxCount;
        }
        Set<String> examples = new HashSet<>();
        // заполняем случайными цифрами пока не наберется нужное количество примеров
        // не очень эффективное решение, потому что могут генерироваться уже существующие примеры и цикл будет долго гоняться
        while (examples.size() != count) {
            int n1 = randomInt(from, to);
            int n2 = randomInt(n1, to);
            examples.add(String.format("%d*%d", n1, n2));
        }
        for (String exam : examples) {
            System.out.println(exam);
        }
    }

    private static int randomInt(int from, int to) {
        ++to;
        to -= from;
        return random.nextInt(to) + from;
    }
}
