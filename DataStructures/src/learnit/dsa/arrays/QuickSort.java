package learnit.dsa.arrays;

/*
 * Implement quick sort
 * 1. Fix a pivot.
 * 2. Partition based on pivot.
 * 3. Recursively call for left and right of pivot.
 * 4. Invalid index to be taken care. Its achieved with if(start<end)
 */
public class QuickSort {
	
	public static void main(String[] args) {
		int[] array = new int[]{4,7,1,9,2,3};
		QuickSort QuickSort = new QuickSort();
		QuickSort.quickSort(array,0,array.length-1);
		for(int a:array){
			System.out.print(" "+a);
		}
	}
	
	public void quickSort(int[] a,int start, int end){
		if(start<end){
			int pivotIndex = partition(a,start,end);
			quickSort(a,start,pivotIndex-1);
			quickSort(a,pivotIndex+1,end);
		}
	}
	
	public int partition(int[] a, int start, int end) {
		int pivot = a[end];
		int temp, i = start, j = end - 1, pivotIndex = start;
		while (i < j) {
			if (a[i] > pivot && a[j] < pivot) {
				temp = a[i];
				a[i] = a[j];
				a[j] = temp;
			}
			if (a[i] < pivot) {
				i++;
			}
			if (a[j] > pivot) {
				j--;
			}
		}
		if (a[i] > pivot) {
			temp = a[i];
			a[i] = pivot;
			a[end] = temp;
			pivotIndex = i;
		} else {
			temp = a[i + 1];
			a[i + 1] = pivot;
			a[end] = temp;
			pivotIndex = i + 1;
		}
		return pivotIndex;
	}
}
