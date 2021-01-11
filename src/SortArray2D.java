import java.util.Arrays;
import java.util.Random;

public class SortArray2D {

	public static void main(String[] args) {

		int arraySize = PrimeGenerator.getInputInRange("Please enter array count between 10 and 20: ", 10, 20);

		// create 2D array
		int[][] Arr01 = new int[arraySize][];

		for (int i = 0; i < Arr01.length; i++) {
			Arr01[i] = new int[new Random().nextInt(41) + 10]; // create random length arrays in range 10-50
			for (int j = 0; j < Arr01[i].length; j++) {
				Arr01[i][j] = new Random().nextInt(900) + 100; // Initialize array with random values in range 100-999
			}
		}

		// printout 2D array
		printArray(Arr01, "Initial Array:");

		// sorting arrays descending
		Boolean SwapDone = false;
		while (true) {
			SwapDone = false;
			for (int i = 0; i < arraySize; i++) {
				for (int j = 1; j < Arr01[i].length; j++) {
					if (Arr01[i][j - 1] < Arr01[i][j]) {
						int tmpNumber = Arr01[i][j - 1];
						Arr01[i][j - 1] = Arr01[i][j];
						Arr01[i][j] = tmpNumber;
						SwapDone = true;
					}
				}
			}
			if (!SwapDone) {
				break;
			}
			arraySize--;
		}

		// printout array
		printArray(Arr01, "After sorting:");

		// arrays average calculation
		arraySize = Arr01.length;
		double[] averageArr = new double[arraySize]; // average and 2D arrays at the same size
		for (int i = 0; i < arraySize; i++) {

			for (int j : Arr01[i]) {
				averageArr[i] += j;

			}
			averageArr[i] = averageArr[i] / Arr01[i].length;
		}
		// printout array
		System.out.println('\n' + "Average values of Arrays:");
		System.out.println(Arrays.toString(averageArr));

		// sorting both average and 2D arrays ascending
		arraySize = averageArr.length;
		SwapDone = false;
		while (true) {
			SwapDone = false;
			for (int i = 1; i < arraySize; i++) {

				if (averageArr[i - 1] > averageArr[i]) {
					double tmpNumber = averageArr[i - 1]; // sorting average array
					averageArr[i - 1] = averageArr[i];
					averageArr[i] = tmpNumber;

					int[] tmpArr = Arr01[i - 1]; // sorting 2D array
					Arr01[i - 1] = Arr01[i];
					Arr01[i] = tmpArr;

					SwapDone = true;
				}
			}
			if (!SwapDone) {
				break;
			}
			arraySize--;
		}
		System.out.println('\n' + "Sorted average array:");
		System.out.println(Arrays.toString(averageArr));
		System.out.println('\n' + "Sorted array with higher average: " + averageArr[averageArr.length - 1]);
		System.out.println(Arrays.toString(Arr01[averageArr.length - 1]));
	}

	public static void printArray(int[][] array, String header) {

		System.out.println(header);
		for (int i = 0; i < array.length; i++) {
			String message = i + ". [";
			for (int j = 0; j < array[i].length; j++) {
				message = message + array[i][j];
				if (j < array[i].length - 1) {
					message = message + ", ";
				} else {
					message = message + "]";
				}
			}
			System.out.println(message);
		}
	}
}