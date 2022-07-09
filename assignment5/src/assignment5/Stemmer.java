package assignment5;

public class Stemmer {
	public static String[] getNGrams(String keyword, int number) {
		int keywordLength = keyword.length() - number + 1;
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
		return answer;
	}
	
	public static String[] getShared(String[] firstSet, String[] secondSet) {
		int count = 0; 
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
		return res;
		
	}
	
	
	public static double getDistance(String[] originalKeyword, String[] compareKeyword) {
		double distance;
		String[] res = getShared(originalKeyword, compareKeyword);
		distance = ((double)res.length / (originalKeyword.length + compareKeyword.length)); // class change into double
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
		return relevancy;
		
	}
	
}
