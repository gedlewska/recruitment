package com.company;

import java.util.*;

public class Main {

    static Integer[] diff(Integer[] a, Integer[] b) {
        final HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int element : b) {
            hashMap.compute(element, (key, val) -> (val == null) ? 1 : val + 1);
        }
        final int max = Collections.max(hashMap.entrySet(), Comparator.comparingInt(HashMap.Entry::getValue)).getValue();
        final ArrayList<Integer> primes = getPrimes(max);
        final ArrayList<Integer> diff = new ArrayList<>();
        for (int element : a) {
            if (!hashMap.containsKey(element) || !primes.contains(hashMap.get(element))) {
                diff.add(element);
            }
        }
        return diff.toArray(Integer[]::new);
    }

    static ArrayList<Integer> getPrimes(int max) {
        final ArrayList<Integer> primes = new ArrayList<>();
        primes.add(2);
        primes.add(3);
        for (int i = 1; 6 * i - 1 <= max; i++) {
            for (int d = -1; d < 2; d += 2) {
                int p = 6 * i + d;
                boolean isPrime = true;
                for (int j = 2; j < primes.size() && primes.get(j) <= Math.sqrt(p); j++) {
                    if (p % primes.get(j) == 0) {
                        isPrime = false;
                        break;
                    }
                }
                if (isPrime) primes.add(p);
            }
        }
        return primes;
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
