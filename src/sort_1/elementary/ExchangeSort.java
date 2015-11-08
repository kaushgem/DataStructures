package sort_1.elementary;

public class ExchangeSort {

	public static void sort(int[] a) {

		for(int i=0; i<a.length-1; i++) {
			for(int j=i; j<a.length; j++) {
				if(a[i] > a[j]) {
					int temp = a[i];
					a[i] = a[j];
					a[j] = temp;
				}
			}
		}
	}


	public static void main(String[] args) {
		int[] a = { 10, 4, 45, 34, 7, 56, 5, 23, 43, 99, 56, 34, 54, 76 };
		for (int val : a)	System.out.print(val + " ");
		System.out.println();
		sort(a);
		for (int val : a)	System.out.print(val + " ");
	}

}
