package learnit.dsa.arrays;
/*
 * Implement merge sort
 * 1. Split array to 2 left and right
 * 2. Recursively call until there is only one element.
 * 3. Then merge the left and right sorting while merging. 
 */
public class MergeSort {

	public static void main(String[] args) {
		MergeSort mergeSort = new MergeSort();
		int[] array = mergeSort.mergeSort(new int[]{2,8,1,3,9,10});
		for(int a : array){
			System.out.println(a);
		}
	}
	
	private int[] mergeSort(int[] array){
		if(array.length==1){
			return array;
		}
		int mid = array.length/2;
		int[] left = new int[mid];
		int[] right = new int[array.length-mid];
		for(int i = 0, k =0;i<mid;i++,k++){
			left[k] = array[i];
		}		
		for(int i=mid,k=0;i<array.length;i++,k++){
			right[k] = array[i];
		}
		
		mergeSort(left);
		mergeSort(right);
		merge(left,right,array);
		return array;
	}
	
	private void merge(int[] left, int[] right, int[] array){
		int k=0,j=0,i=0;
		while(i<left.length && j<right.length){
			if(left[i]<right[j]){
				array[k] = left[i];
				i++;
			}else{
				array[k] = right[j];
				j++;
			}
			k++;
		}
		if(i<left.length){
			while(i<left.length){
				array[k] = left[i];
				k++;i++;
			}
		}else if(j<right.length){
			while(j<right.length){
				array[k] = right[j];
				j++;k++;
			}
		}
		
	}
}
