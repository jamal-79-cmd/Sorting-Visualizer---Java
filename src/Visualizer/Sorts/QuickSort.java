package Visualizer.Sorts;

import Visualizer.SortingVisualizer;
public class QuickSort implements Runnable {

    public void run() {
        Integer[] toBeSorted = SortingVisualizer.toBeSorted;
        inPlaceSort(toBeSorted);
        SortingVisualizer.isSorting = false;
    }
    public void inPlaceSort(Integer[] x) {
        inPlaceSort(x, 0, x.length - 1);
    }
    private void inPlaceSort(Integer[] x, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(x, low, high);
            inPlaceSort(x, low, pivotIndex - 1);
            inPlaceSort(x, pivotIndex + 1, high);
        }
    }
    private int partition(Integer[] x, int low, int high) {
        int pivot = x[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (x[j] < pivot) {
                i++;
                int temp = x[i];
                x[i] = x[j];
                x[j] = temp;
                SortingVisualizer.frame.reDrawArray(x, i, j, -1);
                try {
                    Thread.sleep(SortingVisualizer.sleep);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        int temp = x[i + 1];
        x[i + 1] = x[high];
        x[high] = temp;
        SortingVisualizer.frame.reDrawArray(x, i + 1, high, -1);
        try {
            Thread.sleep(SortingVisualizer.sleep);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return i + 1;
    }
}