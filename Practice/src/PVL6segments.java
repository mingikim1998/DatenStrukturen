import java.util.ArrayList;
import java.util.Collections;
public class PVL6segments {
	public static void main(String[] args) {
	ArrayList<Integer> list = new ArrayList<Integer>();
	list.add(1);list.add(9);list.add(2);list.add(7);list.add(4);list.add(9999);list.add(0);
	segments(list);
	}
	
	public static StringBuilder segments(ArrayList<Integer> numbersList) {
		ArrayList<Integer> arr = new ArrayList<Integer>();
		StringBuilder sb = new StringBuilder();
	    for (int i=0; i<numbersList.size(); i++) {
	    	if (numbersList.get(i)==9999) {break;}
	    	else {arr.add(numbersList.get(i));}
	    }
	    Collections.sort(arr);
	    System.out.println(arr);
	    for (int i=0; i<arr.size()-1; i++) {
	    	if (i==0 || (sb.charAt(sb.length()-1)=='|')) {sb.append(arr.get(i));} //java does not support negative indexes
	    	else if (arr.get(i)+1 == arr.get(i+1) || arr.get(i) == arr.get(i+1)) {continue;}
	    	else {sb.append("-").append(arr.get(i)).append("|").append(arr.get(i+1));}
	    }
	    sb.append("|");
    	System.out.println(sb);
	    return sb;
	}
}
