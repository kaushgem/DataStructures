/**
 * Selection Sort
 */
package sort_1.elementary;

/**
 * @author kaush
 *
 */
public class SelectionSort {

	public static void sort(int[] a) {

		for (int i = 0; i < a.length; i++) {
			int min = i;
			for (int j = i + 1; j < a.length; j++)
				if (compare_lessThan(a[j], a[min]))
					min = j;
			swap(a, i, min);
		}
	}

	private static boolean compare_lessThan(int x, int y) {
		return x < y;
	}

	private static void swap(int[] a, int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}

	// Test method
	public static void main(String[] args) {
		
		int[] a = { 10, 4, 45, 34, 7, 56, 5, 23, 43, 99, 56, 34, 54, 76 };
		
		for (int val : a)	System.out.print(val + " ");
		System.out.println();
		sort(a);
		for (int val : a)	System.out.print(val + " ");
	}
}
