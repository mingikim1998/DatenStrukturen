package G23;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import PVL.PVL4;

public class G23 implements PVL4{

	private Node root;
	
	private HashMap<Character, String> dicCharToString;
	private HashMap<String, Character> dicStringToChar;
	
	@Override
	public void set_alphabet(char[] alphabet, float[] probabilities) {
		/*System.out.println("set_alphabet");
		System.out.println("chars & probs");
		for(int i = 0; i < alphabet.length; i++) {
			System.out.println(alphabet[i] + " | " + probabilities[i]);
		}*/
		Help.order(alphabet, probabilities);
		root = new Node(alphabet, probabilities, 1.0f, 0);
		
		//putting the alphabet into a dictionary -> easy to use
		dicCharToString = new HashMap<Character, String>();
		dicStringToChar = new HashMap<String, Character>();
		List<List<String>> list = get_codes();
		for(int i = 0; i < list.size(); i++) {
			dicCharToString.put(list.get(i).get(0).charAt(0), list.get(i).get(1));
			dicStringToChar.put(list.get(i).get(1), list.get(i).get(0).charAt(0));
		}
		//System.out.println(dicCharToString);
	}

	@Override
	public List<List<String>> get_codes() {
		//System.out.println("public get_codes");
		ArrayList<List<String>> list = new ArrayList<List<String>>();
		if(root != null) {
			get_codes(root, list, "");
		}
		return list;
	}
	
	private List<List<String>> get_codes(Node n, List<List<String>> list, String code){
		//System.out.println("private get_codes");
		if(!n.isLeaf()) {
			get_codes(n.getLeft(), list, code + "1");
			get_codes(n.getRight(), list, code + "0");
		} else {
			ArrayList<String> l = new ArrayList<String>();
			l.add(String.valueOf(n.getCharacter()));
			l.add(code);
			list.add(l);
			}
		return list;
	}

	@Override
	public String encode(String plain_text) {
		//System.out.println("encode");
		String code = "";
		for(int i = 0; i < plain_text.length(); i++) {
			code = code + dicCharToString.get(plain_text.charAt(i));
		}
		return code;
	}

	@Override
	public String decode(String huffman_text) {
		//System.out.println("decode");
		String text = "";
		while(huffman_text.length() > 0) {
			//System.out.println(huffman_text + " " + text);
			for(int i = 0; i <= huffman_text.length(); i++) {
				if(dicStringToChar.containsKey(huffman_text.substring(0, i))) {
					text += dicStringToChar.get(huffman_text.substring(0, i));
					huffman_text = huffman_text.replaceFirst(huffman_text.substring(0, i), "");
				}
			}
		}
		//System.out.println("end decode");
		return text;
	}


}
