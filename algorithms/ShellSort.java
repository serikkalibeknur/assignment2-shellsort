package algorithms;

public class ShellSort {
    private static int comparisons = 0;
    private static int swaps = 0;

    public static void shellSort(int[] arr, String sequenceType) {
        int n = arr.length;
        int gap = getInitialGap(sequenceType, n);

        while (gap > 0) {
            for (int i = gap; i < n; i++) {
                int temp = arr[i];
                int j = i;
                while (j >= gap && arr[j - gap] > temp) {
                    arr[j] = arr[j - gap];
                    j -= gap;
                    comparisons++;
                    swaps++;
                }
                arr[j] = temp;
                if (j != i) {
                    swaps++;
                }
            }
            gap = getNextGap(sequenceType, gap);
        }
    }

    private static int getInitialGap(String sequenceType, int n) {
        switch (sequenceType) {
            case "Shell":
                return n / 2;
            case "Knuth":
                return (int) (Math.pow(3, Math.floor(Math.log(n) / Math.log(3))) - 1) / 2;
            case "Sedgewick":
                return n / 2; // Простая реализация, можно улучшить.
            default:
                throw new IllegalArgumentException("Unknown sequence type");
        }
    }

    private static int getNextGap(String sequenceType, int gap) {
        switch (sequenceType) {
            case "Shell":
                return gap / 2;
            case "Knuth":
                return (gap - 1) / 3;
            case "Sedgewick":
                return gap / 2;
            default:
                throw new IllegalArgumentException("Unknown sequence type");
        }
    }

    public static int getComparisons() {
        return comparisons;
    }

    public static int getSwaps() {
        return swaps;
    }

    public static void resetCounters() {
        comparisons = 0;
        swaps = 0;
    }
}