/**
 * 
 */
package ds_3.sort.elementary;

import java.util.ArrayList;

/**
 * @author kaush
 *
 */
public class SelectonSortGeneric {
	public static void sort(Comparable[] a) {

		for(int i=0; i<a.length; i++) {
			int min = i;
			for(int j=i; j<a.length; j++) {
				if(compare_lessThan(a[j], a[min])) {
					min = j;
					swap(a, i, min);
				}
			}
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
		SelectionSortGeneric s = new SelectionSortGeneric();
		Comparable<Integer> a = new ArrayList<Integer>();
		s.sort(a);
		System.out.println(a);
	}
}
