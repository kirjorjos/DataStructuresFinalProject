package algorithmstester;

import java.util.Random;
import java.util.Arrays;

public class AlgorithmsTester {
	public static void main(String[] args) {
		final int ALGORITHM_AMMOUNT = 7;
		long[] bubbleSortTimes = new long[ALGORITHM_AMMOUNT];
		long[] insertIntoSortTimes = new long[ALGORITHM_AMMOUNT];
		long[] selectAndSortTimes = new long[ALGORITHM_AMMOUNT];
		long[] mergeSort = new long[ALGORITHM_AMMOUNT];
		long[] shellSort = new long[ALGORITHM_AMMOUNT];
		long[] quickSort = new long[ALGORITHM_AMMOUNT];
		long[] heapSort = new long[ALGORITHM_AMMOUNT];
		Random random = new Random();
		int[] ammounts = {10000, 20000, 200000};
		for (int i = 0; i < ammounts.length; i++) {
			long[] arr = new long[0];
			int[] values = new int[ammounts[i]];
			for (int j = 0; j < ammounts[i]; j++) {
				values[j] = random.nextInt();
			}
			for (int j = 0; j < ALGORITHM_AMMOUNT; j++) {
				int[] copy = Arrays.copyOf(values, values.length);
				System.out.println(Algorithms.isSorted(copy));
				long startTime = System.currentTimeMillis();
				Algorithms.sort(j, copy);
				long endTime = System.currentTimeMillis();
				switch(j) {
					case 0:
						arr = bubbleSortTimes;
						break;
					case 1:
						arr = insertIntoSortTimes;
						break;
					case 2:
						arr = selectAndSortTimes;
						break;
					case 3:
						arr = mergeSort;
						break;
					case 4:
						arr = shellSort;
				}
				arr[i] = (endTime-startTime);
			}
		}
		System.out.println("Bubble sort times:");
		for (int i = 0; i < ammounts.length; i++) {
			System.out.println(bubbleSortTimes[i]);
		}
		System.out.println("Insert into sort times:");
		for (int i = 0; i < ammounts.length; i++) {
			System.out.println(insertIntoSortTimes[i]);
		}
		System.out.println("Select and sort times:");
		for (int i = 0; i < ammounts.length; i++) {
			System.out.println(selectAndSortTimes[i]);
		}
		System.out.println("Merge sort times:");
		for (int i = 0; i < ammounts.length; i++) {
			System.out.println(mergeSort[i]);
		}
		System.out.println("Shell sort times:");
		for (int i = 0; i < ammounts.length; i++) {
			System.out.println(shellSort[i]);
		}
	}
}
