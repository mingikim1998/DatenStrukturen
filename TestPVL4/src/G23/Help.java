package G23;

public class Help {

	public static void order(char[] alphabet, float[] probabilities) {
		//System.out.println("Help.order");
		//new Arrays, in which we can change positions, but still have one with the original alphabet
		float[] probs = new float[probabilities.length];
		System.arraycopy(probabilities, 0, probs, 0, probabilities.length);
		char[] chars = new char[probabilities.length];
		System.arraycopy(alphabet, 0, chars, 0, probabilities.length);
		
		//normal bubblesort, but changes also the positions of the alpha array
		//sorts the characters by their probability
		boolean sorted = false;
		while(!sorted) {
			sorted = true;
			for(int i = 0; i < probs.length -1; ++i) {
				if(probs[i] < probs[i+1]) {
					float memoryF = probs[i];
					char memoryC = chars[i];
					probs[i] = probs[i+1];
					chars[i] = chars[i+1];
					probs[i+1] = memoryF;
					chars[i+1] = memoryC;
					sorted = false;
				}
			}
		}
		
		//bubblesort
		//sorts 2 characters with the same probability, so that the one earlier in the alphabet will be after the other one
		sorted = false;
		while(!sorted) {
			sorted = true;
			for(int i = 0; i < probs.length -1; ++i) {
				if(probs[i] == probs[i+1] && searchNum(alphabet, chars[i]) < searchNum(alphabet, chars[i+1])) {
					float memoryF = probs[i];
					char memoryC = chars[i];
					probs[i] = probs[i+1];
					chars[i] = chars[i+1];
					probs[i+1] = memoryF;
					chars[i+1] = memoryC;
					sorted = false;
				}
			}
		}
		
		/*System.out.println("chars & probs");
		for(int i = 0; i < alphabet.length; i++) {
			System.out.println(chars[i] + " | " + probs[i]);
		}*/
		
		//copying back the arrays, so we can use them
		System.arraycopy(probs, 0, probabilities, 0, probabilities.length);
		System.arraycopy(chars, 0, alphabet, 0, probabilities.length);
	}
	
	public static int searchNum(char[] chars, char toFind) {
		//System.out.println("Help.searchNum");
		for(int i = 0; i < chars.length; ++i) {
			if(chars[i] == toFind) {
				return i;
			}
		}
		//System.out.println("searchNum could not find " + toFind + " in " + chars);
		return -1;
		
	}
}
