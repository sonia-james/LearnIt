package learnit.dsa.arrays;

/*
 *Given an array of integers, find the maximum and minimum of the array.
 *Find the answer in minimum number of comparisons. 
 */
public class MaxMin {
	
	public static void main(String[] args) {
		MaxMin maxMin = new MaxMin();
		int[] numbers = new int[]{5,8,12,9,13,6,3,1,5,7};
		maxMin.bruteForse(numbers);
		maxMin.twoPointers(numbers);
	}
	
	/**
	 * BruteForse Method. Keeps variable min and max and compares with each.
	 * Complexity -> O(n)
	 * Specifically -> 2n
	 * @param numbers
	 */
	private void bruteForse(int[] numbers){
		int min = numbers[0];
		int max = numbers[0];
		for(int i=0;i<numbers.length;i++){
			min = numbers[i]<min?numbers[i]:min;			
			max = numbers[i]>max?numbers[i]:max;		
		}
		System.out.println("Min : " + min );
		System.out.println("Max : " + max);
	}
	
	/**
	 * Slightly better method with 2 pointers, one from front and one from rear. 
	 * Compares 2 numbers at a time.
	 * Complexity -> O(n)
	 * Specifically -> 3*n/2 -> 1.5n
	 * @param numbers
	 */
	private void twoPointers(int[] numbers){
		int min = numbers[0];
		int max = numbers[0];
		for(int i=0,j=numbers.length-1;i<=j;i++,j--){
			if(numbers[j]<numbers[i]){
				min = numbers[j]<min?numbers[j]:min;
				max = numbers[i]>max?numbers[i]:max;
			}else{
				min = numbers[i]<min?numbers[i]:min;
				max = numbers[j]>max?numbers[j]:max;
			}
		}
		System.out.println("Min : " + min );
		System.out.println("Max : " + max);
	}

}
