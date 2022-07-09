import java.util.Arrays;
import java.util.List;

public class testCalculator {
	public static void main(String[] args) {
	
		//public int calculator(String[] a, String[] b ) {
			int count = 0;
			String[] nummersArray = {"1","1","(","12","3","3","12",")"}; 
			String[] operatorsArray = {null,"-","+",null,"+","-","+",null};// test arrays -> how will it look ?
			// 1 - 1 + (12 + 3 - 3 + 12) 
			int len = nummersArray.length;
			
			for (int i = 0; i < len; i++) {
				if (nummersArray[i].equals("(")) { 
					// if there is "(", then there is also ")". assuming the error is checked by the first function
				}
					count += 1;
			}
			while (count >= 1) {
				for (int i = 0; i < len; i++) {
					if (nummersArray[i].equals(")")) { 
						// Klammern zu -> die erste Klammern zu lösen
						// (a - b + (c + (1 + 2))) -> (1+2) should be calculated first
						int tmp = 0 ; // this for loop is entered only when there is a bracket
						
						for (int j = 0; j < i; j++) {
							if (nummersArray[j].equals("(")) { //find all "(" and update it until we find the one just before ")"
								tmp = j;
							}
						}
						
						for (int k = tmp+1; k <= i; k++) { // nummersArray[tmp] equals "(" and nummersArray[i] equals ")"
							nummersArray[tmp] += nummersArray[k]; // "(" . "1" . "+" . "2" . ")" => "(1+2)" 
							
							if (k == i-1) {
								nummersArray[k] = null; //this null data will be deleted below
								operatorsArray[k] = null;// can be [k] or [k+1] depending on how operatorsArray list looks
							}
							
							else if (k <= i-1) {
								nummersArray[tmp] += operatorsArray[k+1];
							}
							nummersArray[k] = null; //this null data will be deleted below
							operatorsArray[k] = null;
							
							System.out.println(nummersArray[tmp]); 
						}
						//String solidBracket = nummersArray[tmp];
						// delete brackets ( which is both edges)
						// nummersArray[tmp] = solidBracket[1:-1]; 
						// nummersArray[tmp] = solidBracket.substring(1, -2); //range checked
						nummersArray[tmp] = nummersArray[tmp].substring(1, nummersArray[tmp].length()-1);
						
						// arrays to arrayList to delete null
						List<String> nummersArr = Arrays.asList(nummersArray); 
						List<String> operatorsArr = Arrays.asList(operatorsArray); 
						System.out.println(nummersArr);
						System.out.println(operatorsArr);

						// delete null
						// BUG HERE
						while(nummersArr.remove(null)); 
						while(operatorsArr.remove(null));
						
						nummersArray = nummersArr.stream().toArray(String[]::new);
						operatorsArray = operatorsArr.stream().toArray(String[]::new); // back to array
						
						//calculation
						String calculation = nummersArray[tmp]; // formula inside brackets
						// find number parts and calculate them
						int countOperator = 0; 
						// find how many operators there are = how many times it has to iterate
						for (int c =0; c < calculation.length(); c++) {
							char cal = calculation.charAt(c);
							if (cal == '+'||cal == '-'||cal == '*') {
								countOperator += 1;
							}
						}
						
						while (countOperator >= 1) { // if there are still brackets
							int firstOp = -1;
							int secondOp = -1; // 
							for (int b1 =0; b1 < calculation.length(); b1++) {
								char cal = calculation.charAt(b1);
								if (cal == '+'||cal == '-'||cal == '*') {
									firstOp = b1;
									break;
								}
							}
	
							//if (countOperator >= 2) {
							for (int ii = 0; ii < calculation.length(); ii++) {
								char cal = calculation.charAt(ii);
								if (ii != firstOp && cal == '+'||cal == '-'||cal == '*') {
									secondOp = ii;
									break;
								}
							}
	
							for (int b1 =0; b1 < secondOp; b1++) {
								
								String firstNum = calculation.substring(0, firstOp); // range check 
								String secondNum = calculation.substring(firstOp+1,secondOp);
										//calculation[firstOp+1:secondOp];  firstOp is an operator
								int first = Integer.parseInt(firstNum); // string to int
				    			int second = Integer.parseInt(secondNum);
				    			
								char cal = calculation.charAt(b1);
								if (cal == '+') {
					    			int ans = first + second;
					    			//calculation[0:secondOp] = String.valueOf(ans);// reformation : Str to Int
					    			calculation = calculation.substring(-secondOp) + String.valueOf(ans);
								}
								
								else if (cal == '-') {
					    			int ans = first - second;
					    			calculation = calculation.substring(-secondOp) + String.valueOf(ans);
								}
								
								else if (cal == '*') {
					    			int ans = first * second;
					    			calculation = calculation.substring(-secondOp) + String.valueOf(ans);
								}
							}	
						}
					}
				}
			}
	
			count -= 1; 

		System.out.println(nummersArray);
	}
}
