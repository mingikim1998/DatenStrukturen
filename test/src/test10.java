
public class test10 {
	
	public static int calculator(String[] a, String[] b ) {

		String[] nummersArray = {"1","1","(12","3","3","12)"}; // test arrays
		String[] operatorsArray = {"-","+","+","-","-","+"};
		
		int len = nummersArray.length;
		int ans;
		int result = 0; //start = 0
    	for (int i = 0; i < len; i++) {
    		if (operatorsArray[i].equals("*")) { //calculating multiplication first then summation...so on
    			int tmp = Integer.parseInt(nummersArray[i]); // string to int
    			int tmp2 = Integer.parseInt(nummersArray[i+1]);
            	ans = tmp * tmp2;
            	result += ans; //this will duplicate the same number when i+1 becomes i
            	
            	
            	String output = String.valueOf(ans); 
            	//int back to string because we will have to go through this array several times
            	nummersArray[i] = output;
    		}
    		
        for (int i = 0; i < len; i++) { // now summation
    		if (operatorsArray[i].equals("+")) {
    			int tmp = Integer.parseInt(nummersArray[i]);
    			int tmp2 = Integer.parseInt(nummersArray[i+1]);
            	ans = tmp + tmp2;
            	result += ans;
            	
            	String output = String.valueOf(ans);
            	nummersArray[i] = output;
    		}
    		else if (operatorsArray[i].equals("-")) {
    			int tmp = Integer.parseInt(nummersArray[i]);
    			int tmp2 = Integer.parseInt(nummersArray[i+1]);
            	ans = tmp - tmp2;
            	result += ans;
            	
            	String output = String.valueOf(ans);
            	nummersArray[i] = output;
    		}
        	
    	return result;
        }
        public static void calculate(String expression) {
    		String[] nummersArray = {"1","1","(12","3","3","12)"};
    		String[] operatorsArray = {"-","+","+","-","-","+"};
        	// for the rest outside parenthesis
        	// multipliers
        	// since the formula in parenthesis should be calculated first -> find all '()'
        	int len = nummersArray.length; // nummersArray = Number's array(strings)
        	for (int i = 0; i < len; i++) {
        		if (nummersArray[i].contains("(") ) { // if there is a parenthesis
        			nummersArray[i].replace("(",""); // delete the parenthesis and do calculation
        			// how can this be calculated?
        			
//        			while (nummersArray[i].contains(")") ) {
//        				
//        			}
        		}
        			// calculate "tmp" first and update arrays
        			
//        			nummersArray[i] = ans;
//        			operatorsArray[i] = "";
        	}
        System.out.println(ans);
	}
}
