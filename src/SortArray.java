import java.util.Arrays;
import java.util.Random;

public class SortArray {

	public static void main(String[] args) {

		int arraySize = PrimeGenerator.getInputInRange("Please enter array size between 20 and 40: ", 20, 40);

		int[] Arr01 = new int[arraySize];

		for (int i = 0; i < arraySize; i++) {
			Arr01[i] = new Random().nextInt(90) + 10;
		}

		System.out.println("Random value array:");
		System.out.println(Arrays.toString(Arr01));

		Boolean SwapDone = false;

		while (true) { //sorting ascending

			SwapDone = false;

			for (int i = 1; i < arraySize; i++) {
				if (Arr01[i - 1] > Arr01[i]) {
					int tmpNumber = Arr01[i - 1];
					Arr01[i - 1] = Arr01[i];
					Arr01[i] = tmpNumber;
					SwapDone = true;
				}
			}
			if (!SwapDone) {
				break;
			}
			arraySize--;
		}
		System.out.println("Sorted array:");
		System.out.println(Arrays.toString(Arr01));
	}
}