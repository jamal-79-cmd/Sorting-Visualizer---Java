package Visualizer.Sorts;
import Visualizer.SortingVisualizer;

public class MergeSort implements Runnable {

    public void run() {
        Integer[] toBeSorted = SortingVisualizer.toBeSorted;
        mergeSort(toBeSorted, 0, toBeSorted.length - 1);
        SortingVisualizer.isSorting = false;
    }
    public void mergeSort(Integer[] arr, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;

            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);

            merge(arr, left, mid, right);
        }
    }
    private void merge(Integer[] arr, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        Integer[] L = new Integer[n1];
        Integer[] R = new Integer[n2];

        for (int i = 0; i < n1; ++i)
            L[i] = arr[left + i];
        for (int j = 0; j < n2; ++j)
            R[j] = arr[mid + 1 + j];

        int i = 0, j = 0;
        int k = left;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
            SortingVisualizer.frame.reDrawArray(arr, left, right, k);
            try {
                Thread.sleep(SortingVisualizer.sleep);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
            SortingVisualizer.frame.reDrawArray(arr, left, right, k);
            try {
                Thread.sleep(SortingVisualizer.sleep);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
            SortingVisualizer.frame.reDrawArray(arr, left, right, k);
            try {
                Thread.sleep(SortingVisualizer.sleep);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}