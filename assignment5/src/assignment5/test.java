package assignment5;
import java.util.Arrays;
public class test {

	public static String[] getNGrams(String keyword, int number) {
		int keywordLength = keyword.length() - number + 1;
//		int cnt = 0;
		String[] answer;
		
		if (keyword.length() <= number) {
			answer = new String[1];
			while (keyword.length() < number) {
				keyword = keyword + "*";
			}
			answer[0] = keyword;
		}
		
		else {
			answer = new String[keywordLength];
			
			for (int i = 0; i <= keywordLength - 1; i++) {
				answer[i] = keyword.substring(i,i+number);
			}
		}
//		System.out.println(Arrays.toString(answer));
		return answer;
	}
	
	public static String[] getShared(String[] firstSet, String[] secondSet) {
		//int gramLength = firstSet[0].length(); // lengths are assumed to be the same -> NO??
		int count = 0; // initialise error occurs when variables do not have a number to compute
		String[] commonContains;
		if (firstSet.length >= secondSet.length) {  // '>=' because case of SAME length is also considered
			commonContains = new String[firstSet.length];
		}
		else {
			commonContains = new String[secondSet.length];
		}
		
		for (int i = 0; i <= firstSet.length - 1; i++) {
			for (int j = 0; j <= secondSet.length - 1; j++) {
				if (firstSet[i].equals(secondSet[j])) { // content comparison, not location
					commonContains[i] = firstSet[i];
					count += 1;
				}
			}
		}
		String[] res = new String[count];
		int countRes = -1; // making commonContains[0], but not [1] in the first iteration
		for (int i = 0; i <= commonContains.length - 1; i++) {
			if (commonContains[i] != null) {
				countRes += 1;
				res[countRes] = commonContains[i];
			}
		}		
//		System.out.println(Arrays.toString(res));
		return res;
		
	}
	
	
	public static double getDistance(String[] originalKeyword, String[] compareKeyword) {
		double distance;
		String[] res = getShared(originalKeyword, compareKeyword);
		distance = ((double)res.length / (originalKeyword.length + compareKeyword.length)); // class change into double
		System.out.println(distance);
		return distance;
	}
	
	
	public static boolean isRelevant(String keyword, String text) {
		boolean relevancy = false; // if not true, what is left is only false.
		String[] ngramKeyword = getNGrams(keyword, 3);
		String[] textDivided = text.split(" ");
		// this method requires to make 3-grams beforehand
		
		String[] ngramText = new String[1];
		for (int i = 0; i <= textDivided.length - 1; i++) {
			ngramText = getNGrams(textDivided[i], 3);
			if (getDistance(ngramKeyword, ngramText) >= 0.4) {
				relevancy = true;
			}
			else continue;
		}
		System.out.println(relevancy);
		return relevancy;
		
	}
	

	public static void main(String[] args) {
		String [] houseNGrams = getNGrams("house", 3);
		String [] trousersNGrams = getNGrams("trousers", 3);
		getShared(houseNGrams, trousersNGrams);
		getDistance(houseNGrams, trousersNGrams);
		isRelevant("house", "trousers");
		isRelevant("house", "the house is clean");
		
//		String[] a = {"A","B","C"};
//		String[] b = {"Z"};
//		String[] both;
////		
////		System.out.println(Arrays.toString(a));
////		System.out.println(a.length);
//		
//		
//		String[] c = {"A","B",null,null,"C"};
//		String[] newC = new String[c.length];
//		for (int i =0; i <= c.length -1; i++) {
//			if (c[i] != null) {
//				newC[i] = c[i];
//			}
//		}
//		System.out.println("newC is;");
//		System.out.println(Arrays.toString(newC));
//		System.out.println();
		
//
//		String[] firstSet = new String[] {"ab","bc","cd", "de","ss"}; // 배열의 크기는 a,b가 반드시 동일.
//		String[] secondSet = new String[] {"ab","bc","cdd", "de", "ss"}; 
//		int count = 0;
//		String[] commonContains = new String[firstSet.length];
//		
//		for (int i = 0; i <= firstSet.length - 1; i++) {
//			for (int j = 0; j <= secondSet.length - 1; j++) {
//				if (firstSet[i] == secondSet[j]) {
//					commonContains[i] = firstSet[i];
//					count += 1;
//				}
//			}
//		}
//		System.out.println("commonContains is;"); // null -> because they were not declared
//		System.out.println(Arrays.toString(commonContains));
		System.out.println("      ");
//		
//		String[] res = new String[count];
//		
//		int countRes = -1;
//		for (int i = 0; i <= commonContains.length - 1; i++) {
//			if (commonContains[i] != null) {
//				countRes += 1;
//				res[countRes] = commonContains[i];
//			}
//		}
//
//		System.out.println(Arrays.toString(res));
//		// 1. for 문 -> a, b -> 중첩된거 개수.
//		// 2. 새로운 array 생 - 
//		// 3. 새로운 array의 크기 
		
		
	}
}



















		
