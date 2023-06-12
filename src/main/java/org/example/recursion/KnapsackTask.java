package org.example.recursion;

public class KnapsackTask {
    public static void main(String[] args) {
        int[] weights = {11, 8, 7, 6, 5};
        int targetWeight = 20;
        boolean isPossible = knapsack(weights, targetWeight, weights.length - 1); // currentIndex (первоначально задается последний индекс массива)
        System.out.println("Is it possible to achieve the target weight? " + isPossible);
    }

    /*
     * Включить текущий предмет в рюкзак: knapsack(weights, targetWeight - weights[currentIndex], currentIndex - 1).
     * Здесь мы вычитаем вес текущего предмета из целевого веса targetWeight
     *      и рекурсивно вызываем функцию knapsack для оставшихся предметов (currentIndex - 1).
     * Мы исследуем, можно ли заполнить рюкзак с учетом текущего предмета и уменьшенного целевого веса.
     *
     * Не включать текущий предмет в рюкзак: knapsack(weights, targetWeight, currentIndex - 1).
     * Здесь мы просто рекурсивно вызываем функцию knapsack для оставшихся предметов (currentIndex - 1) без изменения целевого веса.
     * Мы исследуем, можно ли заполнить рюкзак без учета текущего предмета.
     *
     * Обратите внимание на оператор || (логическое ИЛИ). Он используется для объединения результатов двух рекурсивных вызовов.
     * Если хотя бы один из вызовов возвращает true, то возвращается true.
     * Это означает, что если рюкзак может быть заполнен с учетом текущего предмета (первый вариант) или без него (второй вариант), то функция вернет true.
     * Если ни один из вариантов не приводит к заполнению рюкзака, то будет возвращено false.
     *
     * Таким образом, эта строка кода позволяет рекурсивно проверить все возможные комбинации предметов для достижения целевого веса.
     */
    public static boolean knapsack(int[] weights, int targetWeight, int currentIndex) {
        // Базовый случай: если целевой вес равен 0, то рюкзак успешно заполнен
        if (targetWeight == 0) {
            return true;
        }

        // Базовый случай: если индекс предмета становится отрицательным (то есть дошли до начала массива)
        //      или целевой вес становится отрицательным,
        // рюкзак не может быть заполнен
        if (currentIndex < 0 || targetWeight < 0) {
            return false;
        }

        // Рекурсивно проверяем два случая:
        // 1. Включить текущий предмет в рюкзак и рекурсивно проверить оставшийся вес
        // 2. Не включать текущий предмет и рекурсивно проверить оставшийся вес
        return knapsack(weights, targetWeight - weights[currentIndex], currentIndex - 1)
               || knapsack(weights, targetWeight, currentIndex - 1);
    }
}

