package algorithmstester;

public class Algorithms {
	
	public static int[] sort(int type, int[] arr) {
		switch(type) {
		case 0:
			return bubbleSort(arr);
		case 1:
			return insertionSort(arr);
		case 2:
			return selectionSort(arr);
		case 3:
			return mergeSort(arr);
		case 4:
			return shellSort(arr);
		}
		return arr;
	}
	
	private static int[] bubbleSort(int[] arr) {
		boolean sorted = false;
		while (!sorted) {
			for (int i = 0; i < arr.length-1; i++) {
				if (arr[i] > arr[i+1]) {
					int temp = arr[i];
					arr[i] = arr[i+1];
					arr[i+1] = temp;
				}
			}
			sorted = isSorted(arr);
		}
		return arr;
	}
	
	private static int[] insertionSort(int[] arr) {
		for (int i = 1; i < arr.length-1; i++) {
			for (int j = i; j >= 0; j--) {
				if (arr[j] > arr[j+1]) {
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}
			}
		}
		return arr;
	}
	
	private static int[] selectionSort(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			int smallest = arr[i];
			int index = i;
			int temp;
			for (int j = i; j < arr.length; j++) {
				if (smallest > arr[j]) {
					smallest = arr[j];
					index = j;
				}
			}
			temp = arr[i];
			arr[i] = smallest;
			arr[index] = temp;
		}
		return arr;
	}
	
	public static boolean isSorted(int[] arr) {
	    for (int i = 0; i < arr.length - 1; i++) {
	        if (arr[i] > arr[i + 1]) {
	            return false;
	        }
	    }
	    return true;
	}
	
	private static int[] mergeSort(int[] arr) {
		if (arr.length <=2) {
			if (arr.length == 1) return arr;
			if (arr[0] > arr[1]) {
				int temp = arr[0];
				arr[0] = arr[1];
				arr[1] = temp;
			}
			return arr;
		}
		int[] leftArr = new int[(int)Math.floor(arr.length/(double)2)];
		int[] rightArr = new int[(int)Math.ceil(arr.length/(double)2)];
		for (int i = 0; i < leftArr.length; i++) {
			leftArr[i] = arr[i];
		}
		for (int i = 0; i < rightArr.length; i++) {
			rightArr[i] = arr[i+leftArr.length];
		}
		leftArr = mergeSort(leftArr);
		rightArr = mergeSort(rightArr);
		actuallyMerge(leftArr, rightArr, arr);
		return arr;
	} 

	private static int[] actuallyMerge(int[] leftArr, int[] rightArr, int[] arr) {
		if (leftArr[leftArr.length-1] > rightArr[0]) {
			int temp = leftArr[leftArr.length-1];
			leftArr[leftArr.length-1] = rightArr[0];
			rightArr[0] = temp;
		}
		for (int i = 0; i < leftArr.length; i++) {
			arr[i] = leftArr[i];
		}
		for (int i = 0; i < rightArr.length; i++) {
			arr[i+leftArr.length] = rightArr[i];
		}
		return arr;
	}
	
	private static int[] shellSort(int[] arr) {
		for (int i = 0; i < arr.length/2; i++) {
			if (arr[i] > arr[i*2]) {
				int temp = arr[i];
				arr[i] = arr[i*2];
				arr[i*2] = temp;
			}
		}
		for (int i = 0; i < arr.length; i+=2) {
			if (arr[i] > arr[i+1]) {
				int temp = arr[i+1];
				arr[i] = arr[i+1];
				arr[i+1] = temp;
			}
		}
		for (int i = 1; i < arr.length-1; i++) {
			for (int j = i; j >= 0; j--) {
				if (arr[j] > arr[j+1]) {
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}
			}
		}
		return arr;
	}
}
