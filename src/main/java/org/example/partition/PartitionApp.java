package org.example.partition;


import java.util.Random;

public class PartitionApp {
    public static void main(String[] args) {
        int maxSize = 16;
        ArrayPartition arrayPartition = new ArrayPartition(maxSize);

        Random random = new Random();
        for (int i = 0; i < maxSize; i++) {
            long number = random.nextInt(200);
            arrayPartition.insert(number);
        }

        arrayPartition.display();

        long pivot = 99;
        System.out.println("Pivot: " + pivot);

        int size = arrayPartition.size();
        if (size > 0) {
            int partitionIndex = arrayPartition.partition(0, size - 1, pivot);
            System.out.println("Partition index: " + partitionIndex);

            arrayPartition.display();
        } else {
            System.out.println("Array is empty.");
        }
    }
}
