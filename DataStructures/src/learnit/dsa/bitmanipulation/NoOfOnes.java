package learnit.dsa.bitmanipulation;
/*
 * Write a function that takes an unsigned integer and returns the number of ’1' bits it has (also known as the Hamming weight).
 * For example, the 32-bit integer ’11' has binary representation 00000000000000000000000000001011, so the function should return 3.
 */
public class NoOfOnes {
	public static void main(String[] args) {
		NoOfOnes noOfOnes = new NoOfOnes();
		System.out.println(noOfOnes.findNoOfOnes(100));
	}
	
	private int findNoOfOnes(int n){
	      int count = 0;
	      while(n!=0){
	            if((n&1) !=0){
	                count++;
	            }
	            n = n>>>1;
	        }
	      return count;
	}

}
