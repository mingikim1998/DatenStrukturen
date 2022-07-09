
public class testCalculator {


	public int calculator(String[] a, String[] b ) {

		String[] nummersArray = {"1","1","(12","3","3","12)"}; // test
		String[] operatorsArray = {"-","+","+","-","-","+"};
		
		int len = nummersArray.length;
		int ans;
		int result = 0; //start = 0
    	for (int i = 0; i < len; i++) {
    		if (operatorsArray[i] == "*") {
    			int tmp = Integer.parseInt(nummersArray[i]);
    			int tmp2 = Integer.parseInt(nummersArray[i+1]);
            	ans = tmp * tmp2;
            	result += ans;
            	
            	String output = String.valueOf(ans);
            	nummersArray[i] = output;
            	nummersArray[i+1] = "1"; // for multiplying by 1 is still its own
    		}
    		
        for (int i = 0; i < len; i++) {
    		if (operatorsArray[i] == "+") {
    			int tmp = Integer.parseInt(nummersArray[i]);
    			int tmp2 = Integer.parseInt(nummersArray[i+1]);
            	ans = tmp + tmp2;
            	result += ans;
            	
            	String output = String.valueOf(ans);
            	nummersArray[i] = output;
            	nummersArray[i+1] = "0";
    		}
    		else if (operatorsArray[i] == "-") {
    			int tmp = Integer.parseInt(nummersArray[i]);
    			int tmp2 = Integer.parseInt(nummersArray[i+1]);
            	ans = tmp - tmp2;
            	result += ans;
            	
            	String output = String.valueOf(ans);
            	nummersArray[i] = output;
            	nummersArray[i+1] = "0";
    		}
        	
    	return result;
	}
}
