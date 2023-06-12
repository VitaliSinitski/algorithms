package org.example.recursion;

public class Recursion {
    public static void main(String[] args) {
        System.out.println(fac(4));
        // 4! = 4 * 3 * 2 * 1;
    }

    // 1
    // 2 * fac(1)
    // 3 * fac(2)
    // 4 * fac(3)
    // fac(4)

    private static int fac(int n) {
        if (n == 1) return n;
        return n * fac(n -1);
    }


}
