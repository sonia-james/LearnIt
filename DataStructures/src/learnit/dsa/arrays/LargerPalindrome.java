package learnit.dsa.arrays;

/*
 * Given an integer find the immediate larger integer that that which is a palindrome, 
 * Example :
 * 1234212 -> 1234321
 * 345676 -> 346643
 * 3214123 -> 3215123
 * 321123 -> 322223
 * 
 * Steps : 
 * 1. If the String has even number of digits
 * 		1. Get left half and right half
 *      2. Reverse left half
 *      3. If reverse of left greter than right then return
 *      4. If not then increment left by 1
 *      5. Find the reverse of the increment
 *      6. Append incr and reverse of incr. Return
 * 2. If the String has odd number of digits
 * 		1. Divide string to left, right and mid
 *  	2. If Reverse of left greter that right 
 *  	3. Return append of left mid and reverse left
 *   	4. If not then increment append of left and mid
 *      5. Return incr append with reverse left (only left no mid)
 */
public class LargerPalindrome {
	public static void main(String[] args) {
		LargerPalindrome largerPalindrome = new LargerPalindrome();
		System.out.println(largerPalindrome.nextPalindrome(3214123));
	}
	
	private String nextPalindrome(int num){
		if(num==0){
			return Integer.toString(1);
		}
		String numString = Integer.toString(num);
		if(numString.length()<2){
			return new StringBuffer(numString).append(numString).toString();
		}
		int midIndex = numString.length()/2;
		boolean odd = numString.length()%2!=0;
		String leftHalf = numString.substring(0,midIndex);
		String rightHalf = odd?numString.substring(midIndex+1):numString.substring(midIndex);
		String reverseLeft = reverse(leftHalf);
		if(!odd){
			if(Integer.parseInt(reverseLeft)>Integer.parseInt(rightHalf)){
				return new StringBuffer(leftHalf).append(reverseLeft).toString();
			}else{
				int incr = Integer.parseInt(leftHalf)+1;
				reverseLeft = reverse(Integer.toString(incr));
				return new StringBuffer(Integer.toString(incr)).append(reverseLeft).toString();
			}
		}else{
			if(Integer.parseInt(reverseLeft)>Integer.parseInt(rightHalf)){
				return new StringBuffer(numString.substring(0,midIndex+1)).append(reverseLeft).toString();
			}else{
				int incr = Integer.parseInt(numString.substring(0,midIndex+1))+1;
				return ((new StringBuffer(Integer.toString(incr))).append(reverseLeft)).toString();
			}
		}
	}
	
	private String reverse(String inputString){
		char[] inputArray = inputString.toCharArray();
		char temp;
		for(int i = 0,j=inputArray.length-1;i<=j;i++,j--){
			temp = inputArray[i];
			inputArray[i] = inputArray[j];
			inputArray[j] = temp;
		}
		return new String(inputArray);	
	}
}
