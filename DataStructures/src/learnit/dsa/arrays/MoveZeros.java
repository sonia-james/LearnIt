package learnit.dsa.arrays;

/*
 * You are given an integer array which contains some zeros. 
 * Move the zeros to the right/left side of the array with minimum number of swaps. 
 * The order of the original array can be destroyed.
 * 
 * Steps : Start 2 pointers. Advance 1 pointer from beginning to end for left and end to beginning for right.
 * 		   If zero is encountered, swap with other second. The second point keeps track of zeros and advances with swap only.
 * Special case : Array starts/ends with zero
 *                Instead of swap can set to zero. Then this will break if first element is non-zero. 
 *                The second pointer will have to first advance until first zero. 'temp' variable solves the issue.
 * Complexity : O(n)
 */

public class MoveZeros {
	public static void main(String[] args) {
		MoveZeros moveZerosToRight = new MoveZeros();
		int[] input = new int[]{0,5,0,1,0,6,0,2,0};
		System.out.println("\nInput Array");
		for(int a : input){
			System.out.print(" " + a);
		}
		int[] result1 = moveZerosToRight.moveZerosToRight(input);
		input = new int[]{0,5,0,1,0,6,0,2,0};
		int[] result2 = moveZerosToRight.moveZerosToLeft(input);
		System.out.println("\nMoving zeros to Right");
		for(int a : result1){
			System.out.print(" " + a);
		}
		System.out.println("\nMoving zeros to Left");
		for(int a : result2){
			System.out.print(" " + a);
		}
	}
	
	private int[] moveZerosToRight(int[] numbers){
		if(null==numbers || numbers.length<2) {
			return numbers;
		}
		int j=numbers.length-1;
		int temp;
		for(int i=numbers.length-1;i>=0;i--) {
			if(numbers[i]==0){
				temp = numbers[i];
				numbers[i] = numbers[j];
				numbers[j] = temp;
				j--;
			}
		}
		return numbers;
	}

	private int[] moveZerosToLeft(int[] numbers){
		if(null==numbers || numbers.length<2) {
			return numbers;
		}
		int j=0;
		int temp;
		for(int i=0;i<numbers.length;i++) {
			if(numbers[i]==0){
				temp = numbers[i];
				numbers[i] = numbers[j];
				numbers[j] = temp;
				j++;
			}
		}
		return numbers;
	}
}
