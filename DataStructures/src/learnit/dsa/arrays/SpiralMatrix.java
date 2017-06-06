package learnit.dsa.arrays;

import java.util.ArrayList;
import java.util.List;

/*
 * Print a matrix in spiral fashion.
 * Steps : Traverse right and increment rowBegin, then traverse down and decrement colEnd, 
 * then Traverse left and decrement rowEnd, and finally Traverse up and increment colBegin.
 * Repeat while colBegin<=colEnd and rowBegin<=rowEnd
 * Make sure sure initialize to length-1
 * For the case where its not a square matrix have to add check of row and column to avoid duplicate printing
 */


public class SpiralMatrix {
	
	public static void main(String[] args) {
		SpiralMatrix spiralMatrix = new SpiralMatrix();
		List<Integer> spriralList = spiralMatrix.spiralMatrix(new int[][]{{1,2,3},{4,5,6},{7,8,9}});
		System.out.println(spriralList);
		spriralList = spiralMatrix.spiralMatrix(new int[][]{{2,3}});
		System.out.println(spriralList);
	}
	
	private List<Integer> spiralMatrix(int[][] matrix){
		List<Integer> list = new ArrayList<Integer>();
		if(null == matrix || matrix.length<1){
			return list;
		}
		int rowBegin = 0;
		int rowEnd = matrix.length-1;
		int colBegin = 0;
		int colEnd = matrix[0].length-1;
		
		while(rowBegin<=rowEnd && colBegin<=colEnd){
			//Left-> Right
			for(int i = colBegin;i<=colEnd;i++){
				list.add(matrix[rowBegin][i]);
			}
			rowBegin++;
			//Right->Bottom
			for(int i = rowBegin;i<=rowEnd;i++){
				list.add(matrix[i][colEnd]);
			}
			colEnd--;
			//Bottom->Left
			if(rowBegin<=rowEnd)
			for(int i = colEnd;i>=colBegin;i--){
				list.add(matrix[rowEnd][i]);
			}
			rowEnd--;
			//Bottom -> Top
			if(colBegin<=colEnd)
			for(int i = rowEnd;i>=rowBegin;i--){
				list.add(matrix[i][colBegin]);
			}
			colBegin++;
		}
		return list;
	}

}
