package assignment4;
public class Task1 {
	public static int productDiagonals(int[][] array, int size) {
		int productLeft = 1, productRight = 1;
		for (int i=0; i <= size; i++) {
			productLeft *= array[i][i];
			productRight *= array[size-i][i];
		}
		int sum;
		if (size % 2 == 0) {
			int middle = size - (size/2);
			sum = (productLeft * productRight) / array[middle][middle];
		}
		else sum = productLeft * productRight;
		return sum;
	}
	
}
