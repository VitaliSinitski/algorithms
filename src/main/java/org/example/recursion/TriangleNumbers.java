package org.example.recursion;

public class TriangleNumbers {
    public static void main(String[] args) {
        int number = 7;
        int result = recursionSolution(number);
        System.out.println(result);
    }

    //i: 0  1  2  3   4   5   6   7
    //   0  1, 3, 6, 10, 15, 21, 28
    private static int[] simpleSolution() {
        int[] array = new int[100];
        array[1] = 1;
        for (int i = 2; i < 100; i++) {
            array[i] = array[i - 1] + i;
        }
        return array;
    }

    private static int recursionSolution(int n) {
        System.out.println("Entering: n=" + n);
        if (n == 1) {
            System.out.println("Returning 1");
            return 1;
        }
        int temp = n + recursionSolution(n - 1);
        System.out.println("Returning " + temp);
        return temp;
    }
}
