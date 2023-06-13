package org.example.recursion;

import java.util.Arrays;
import java.util.Scanner;

public class KnapsackCustom {
    public static void main(String[] args) {
        int[] weights = inputWeights();
//        int[] weights = inputNumbers();
        int targetWeight = inputCapacity();
        System.out.println(Arrays.toString(weights));
        System.out.println(targetWeight);

        boolean isPossible = fillKnapsack(weights, targetWeight, weights.length - 1);
        System.out.println("Is it possible to achieve the target weight? " + isPossible);

    }

    public static boolean fillKnapsack(int[] weights, int targetWeight, int currentIndex) {
        if (targetWeight == 0) {
            return true;
        }

        if (currentIndex < 0 || targetWeight < 0) {
            return false;
        }

        return fillKnapsack(weights, targetWeight - weights[currentIndex], currentIndex - 1)
                || fillKnapsack(weights, targetWeight, currentIndex - 1);
    }
    private static int inputCapacity() {
        System.out.println("Enter the max capacity weight of your knapsack: ");
        Scanner scanner1 = new Scanner(System.in);
        int targetWeight = scanner1.nextInt();
        scanner1.close();
        return targetWeight;
    }

    private static int[] inputWeights() {
        System.out.println("Enter the weights of the items separated by spaces you want to put: ");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        input = input.replaceAll("[^0-9\\s]+", " ");
        String[] stringNumbers = input.trim().split("\\s+");

        int[] numbers = new int[stringNumbers.length];
        for (int i = 0; i < stringNumbers.length; i++) {
            numbers[i] = Integer.parseInt(stringNumbers[i]);
        }
        return numbers;
    }



    private static int[] inputNumbers() {
        Scanner scanner = new Scanner(System.in);
        String input;
        boolean validInput = false;
        int[] numbers = null;

        while (!validInput) {
            System.out.println("Enter the weights of the items separated by spaces you want to put: ");
            input = scanner.nextLine();
            input = input.replaceAll("[^0-9\\s]+", " ");
            String[] stringNumbers = input.trim().split("\\s+");

            numbers = new int[stringNumbers.length];
            boolean validNumber = true;

            for (int i = 0; i < stringNumbers.length; i++) {
                try {
                    numbers[i] = Integer.parseInt(stringNumbers[i]);
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input: " + stringNumbers[i] + ". Please enter only digits.");
                    validNumber = false;
                    break;
                }
            }
            if (validNumber) {
                validInput = true;
            }
        }
        return numbers;
    }



}
