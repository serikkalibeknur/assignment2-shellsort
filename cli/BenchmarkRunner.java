package cli;

import algorithms.ShellSort;
import metrics.PerformanceTracker;

public class BenchmarkRunner {

    public static void main(String[] args) {
        // Проверка, передан ли аргумент
        if (args.length == 0) {
            System.out.println("Usage: java BenchmarkRunner <array_size>");
            System.exit(1);  // Завершаем программу с кодом ошибки
        }

        // Если аргумент передан, используем его для размера массива
        int n = Integer.parseInt(args[0]);

        // Генерация массива случайных чисел
        int[] arr = generateArray(n);

        // Запуск сортировки и измерение времени
        long startTime = System.nanoTime();
        ShellSort.shellSort(arr, "Shell");
        long endTime = System.nanoTime();

        // Время выполнения
        long duration = (endTime - startTime);
        PerformanceTracker.writeToCSV("ShellSort", n, duration, ShellSort.getComparisons(), ShellSort.getSwaps());

        // Вывод отсортированного массива
        System.out.println("Sorted array: ");
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println("\nExecution time: " + duration + " ns");
    }

    private static int[] generateArray(int size) {
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = (int)(Math.random() * 1000);  // Генерация случайных чисел
        }
        return arr;
    }
}