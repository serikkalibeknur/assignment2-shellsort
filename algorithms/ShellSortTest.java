package algorithms;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ShellSortTest {

    @Test
    public void testHeapSort() {
        int[] arr = {38, 27, 43, 3, 9, 82, 10};
        ShellSort.shellSort(arr, "Shell");
        assertArrayEquals(new int[]{3, 9, 10, 27, 38, 43, 82}, arr);
    }

    @Test
    public void testEmptyArray() {
        int[] arr = {};
        ShellSort.shellSort(arr, "Shell");
        assertArrayEquals(new int[]{}, arr);
    }

    @Test
    public void testSingleElement() {
        int[] arr = {5};
        ShellSort.shellSort(arr, "Shell");
        assertArrayEquals(new int[]{5}, arr);
    }

    @Test
    public void testDuplicates() {
        int[] arr = {5, 5, 5, 5};
        ShellSort.shellSort(arr, "Shell");
        assertArrayEquals(new int[]{5, 5, 5, 5}, arr);
    }

    @Test
    public void testReverseSortedArray() {
        int[] arr = {10, 9, 8, 7, 6};
        ShellSort.shellSort(arr, "Shell");
        assertArrayEquals(new int[]{6, 7, 8, 9, 10}, arr);
    }

    @Test
    public void testSortedArray() {
        int[] arr = {1, 2, 3, 4, 5};
        ShellSort.shellSort(arr, "Shell");
        assertArrayEquals(new int[]{1, 2, 3, 4, 5}, arr);
    }
}