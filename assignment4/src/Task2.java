package assignment4;

public class Task2 {
	public static int[] search(int[][] array, int size, int x) {
		int[] arr = new int[2];
		for (int i =0; i <= size; i++) {
			if ((arr[0])==0 && (arr[1]) ==0) {
				for (int j=0; j <= size; j++) {
					if (array[i][j] == x) {
						arr[0] = i;
						arr[1] = j;
					
					}
				
				}
			}
			else continue;
		}
		return arr;
	}

}