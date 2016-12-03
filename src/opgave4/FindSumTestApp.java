package opgave4;

public class FindSumTestApp {
	public static void main(String[] args) {
		int[] array = { 4, 3, 12, 5, 7, -4, 1, 8, 12 };

		Measurer.start();
		int index = findSum(array, 9);
		Measurer.stop();

		System.out.println(String.format("findSum -- Total time in milliseconds: " + Measurer.durationMilliSeconds()));
		System.out
				.println(String.format("findSum  -- Total time in seconds: " + Measurer.durationMilliSeconds() / 1000));
		System.out.println("Found index is: " + index);
	}

	/**
	 * Finds the index of the array which holds the first integer that sums up
	 * to 'total'
	 * 
	 * @param array
	 *            the array to be searched
	 * @param total
	 *            the total sum that a potential sub array should give
	 * @return index the index of the sub-array with a sum of total else -1
	 */
	public static int findSum(int[] array, int total) {
		for (int i = 1; i < array.length; i++) {
			array[i] += array[i - 1];
		}
		int index = 0;
		boolean indexFound = false;

		while (!indexFound && index < array.length) {
			int endIndex = array.length - 1;

			while (!indexFound && index < endIndex) {
				if (Math.abs(array[index] - array[endIndex]) == total) {
					indexFound = true;
				} else {
					endIndex--;
				}
			}
			index++;
		}

		return index;
	}
}