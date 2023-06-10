package org.example;

public class Fibonacci {
    public static void main(String[] args) {
        int value = 100;
        long[] mem = new long[value + 1];
        long result = fibNaive(value, mem);
        System.out.println(result);
    }

    private static long fibNaive(int value, long[] mem) {
        return 0;
    }

    // наивным, медленным, очевидным
    public static long fibNaive(int n) {
        if (n <= 1) return n;
        long naiveOne = fibNaive(n - 1);
        long naiveTwo = fibNaive(n - 2);
        System.out.println(naiveOne);
        System.out.println(naiveTwo);
        return naiveOne + naiveTwo;
    }

    private static long figEffective(int n) {
        long [] arr = new long [n + 1];
        arr[0] = 0;
        arr[1] = 1;
        for (int i = 2; i <= n; i++) {
            arr[i] = arr[i - 1] + arr[i - 2];
        }
        return arr[n];
    }
}
