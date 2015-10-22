package sort_1.mergeSort;

public class MergeSort {
	static void mergesort(int[] a, int low, int high) {
		if(low < high) {
			int mid = low + (high - low) / 2;
			mergesort(a, low, mid);
			mergesort(a, mid+1, high);
			merge(a, low, mid, high);
		}
	}

	static void merge(int[] a, int low, int mid, int high) {
		
	}

	public static void main(String[] args) {
		int[] a = { 14, 4, 5, 1, 3, 5, 6, 5, 10, 5, 34, 531, 3433 };
		for (int i = 0; i < a.length; i++)
			System.out.print(a[i]+" ");
		System.out.println();
		mergesort(a, 0, a.length - 1);
		for (int i = 0; i < a.length; i++)
			System.out.print(a[i]+" ");

	}
}
