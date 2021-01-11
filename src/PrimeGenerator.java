import java.util.Scanner;

public class PrimeGenerator {

	public static void main(String[] args) {

		int countOfPrimeNumbers = getInputInRange("Please enter amount of sequental prime numbers to generate (0-100): ", 0, 100);

		String primenumbersSeq = "";

		int primeNumber = 1; // prime number sequence starts from 1

		while (countOfPrimeNumbers != 0) {
			boolean primeFlag = true;
			for (int i = 2; i <= (primeNumber / 2); i++) {
				if (primeNumber % i == 0) {
					// condition for non prime -> divides with 2 or 3 or 5 (in range from 2 -->
					// number/2)
					primeFlag = false;
					break;
				}
			}
			if (primeFlag) {
				// number is prime if flag value == true

				if (countOfPrimeNumbers > 1) { // generate output for main string with comma
					primenumbersSeq = primenumbersSeq + primeNumber + ", ";
					countOfPrimeNumbers--;
				} else {
					primenumbersSeq = primenumbersSeq + primeNumber; // different output for last element
					countOfPrimeNumbers--;
				}
			}
			primeNumber++;

		}
		System.out.println("Sequence of primes: " + primenumbersSeq);

	}

	public static int getInputInRange(String message, int min, int max) {

		int inputNumber = -1; // initial value to compare with 0
		Scanner sc = new Scanner(System.in);
		while (inputNumber < min || inputNumber > max) {
			System.out.print(message);
			inputNumber = sc.nextInt();
		}
		sc.close();
		return inputNumber;
	}
}