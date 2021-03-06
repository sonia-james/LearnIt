package learnit.dsa.arrays;

/*
 * Given a number whose digits are unique, 
 * find the next larger number that can be formed with those digits.
 * Eg-1 : 4325 -> 4352
 * Eg-2 : 754621 ->   756421  -> 756124
 * Eg-3 : 5963 -> -> 6953 -> 6359
 * 
 * Steps : 
 * 	  1 : Traverse from right to left
 *    2 : if right>left -> swap left,next smallest to right
 *    3 : Arrange the previous indices on descending order
 */
public class LargerNumber {
	public static void main(String[] args) {
		LargerNumber largerNumber = new LargerNumber();
		largerNumber.findLargerNumber(754621);
	}
	
	private void findLargerNumber(int num){
		String numString = Integer.toString(num);
		char[] numArray = numString.toCharArray();
		boolean hasLargerNum = false;
		for(int j=numArray.length-1;j>0;j--){
			if(numArray[j]>numArray[j-1]){
				swapWithNextSmall(numArray,j-1);
				hasLargerNum = true;
				System.out.println(new String(numArray));
				reverse(numArray,j);
				break;
			}
		}
		if(hasLargerNum)
		System.out.println(new String(numArray));
		else System.out.println("No larger number");
	}
	
	private void swapWithNextSmall(char[] numArray, int index){
		int minIndex = index+1;
		for(int i=index+1;i<numArray.length;i++){
			if(numArray[i]>numArray[index] && numArray[i]<numArray[minIndex]){
				minIndex = i;
			}
		}
		char temp = numArray[minIndex];
		numArray[minIndex] = numArray[index];
		numArray[index] = temp;
	}
	
	private void reverse(char[] numArray, int index){
		char temp;
		for(int i=index,j=numArray.length-1;i<=j;i++,j--){
			temp = numArray[i];
			numArray[i] = numArray[j];
			numArray[j] = temp;
		}
	}
}
