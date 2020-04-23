package com.company;

import java.util.*;

public class Main {

    static Integer[] diff(Integer[] a, Integer[] b) {
        final HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int element : b) {
            hashMap.compute(element, (key, val) -> (val == null) ? 1 : val + 1);
        }
        final int max = Collections.max(hashMap.entrySet(), Comparator.comparingInt(HashMap.Entry::getValue)).getValue();
        final ArrayList<Integer> primes = new ArrayList<>();
        primes.add(2);
        for (int n = 3; n <= max; n += 2) {
            if (isPrime(n)) primes.add(n);
        }
        final ArrayList<Integer> diff = new ArrayList<>();
        for (int element : a) {
            if (!hashMap.containsKey(element) || !primes.contains(hashMap.get(element))) {
                diff.add(element);
            }
        }
        return diff.toArray(Integer[]::new);
    }

    static boolean isPrime(int n) {
        for (int i = 3; i * i <= n; i += 2) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Integer[] A = {2, 3, 9, 2, 5, 1, 3, 7, 10};
        Integer[] B = {2, 1, 3, 4, 3, 10, 6, 6, 1, 7, 10, 10, 10};

        Integer[] C = diff(A, B);
        for (int x : C) {
            System.out.println(x);
        }

    }
}
