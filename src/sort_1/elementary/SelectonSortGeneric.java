package sort_1.elementary;

/**
 * @author kaush
 *
 */
public class SelectonSortGeneric {
	public static void sort(Comparable[] a) {

		for (int i = 0; i < a.length; i++) {
			int min = i;
			for (int j = i + 1; j < a.length; j++)
				if (compare_lessThan(a[j], a[min]))
					min = j;
			swap(a, i, min);
		}
	}

	private static boolean compare_lessThan(Comparable x, Comparable y) {
		return x.compareTo(y) < 0;
	}

	private static void swap(Comparable[] a, int i, int j) {
		Comparable temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}

	public static void main(String[] args) {
		
		String[] a = {"cat","apple","orange","dog","pen","scissors","rat"};
		
		for (String val : a)	System.out.print(val + " ");
		System.out.println();
		sort(a);
		for (String val : a)	System.out.print(val + " ");
	}
}
