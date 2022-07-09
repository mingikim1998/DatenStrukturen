import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

public class HuffmanCode {
	
	    public void set_alphabet(char[] alphabet, float[] probabilities) {

	    	int len = alphabet.length;
		  // make a binary tree
//	    int tmp = 0;
//		  for (int i=0; i < probabilities.length; i ++) {
//			  tmp += i;
//		  }
//	    if (tmp ==1 && alphabet.length == probabilities.length) {
//	    	}
// If two or more letters have the same probability, the lexicographically smaller book stub should always be considered the one with the lower probability. 
// Generally, the leaf or node with the least probability is to be chosen as the left child.
	    	
	    	
//	    	char[] alphabet = {'a', 'b', 'd', 'e', 'g', 'h', 'j', 'c'};
//	        float[] probabilities = {0.05f, 0.15f, 0.3f, 0.2f, 0.1f, 0.07f, 0.03f, 0.1f};
	    	
	    	HashMap<Object, Object> map = new HashMap<>();
	    	for (int i = 0; i < len; i++) {
	    		
	    	}
	        map.put("people", "사람");
	        map.put("baseball", "야구");
	        
	    	float[len] baum;
	    	// baum -> priority dictionary?
	    	float minValue = probabilities[0];
	    	for (int i = 0; i < probabilities.length; i ++) {
	    		if(probabilities[i] > minValue){
	    		      minValue = probabilities[i];
	    		}
	    	}

	    	float minValue2 = probabilities[0];
	    	for (int i = 0; i < probabilities.length; i ++) {
	    		if(probabilities[i] > minValue2 && minValue2 != probabilities[i] ){ // if they are the same
	    		      minValue2 = probabilities[i];
	    		}
	    	}

	    	
	    	
	    	// 고른 두개의 문자를 자식노드로  하는 새로운 그룹(부모노드)을 생성합니다.
	    	float[] node; // len -1
	    	float sum = 0;
	    	for (int i = 0; i < node.length; i++) {
	    		if ( i == 0) {
	    			sum = minValue + minValue2;
	    			node[i] = sum;
	    		}
	    		else {
	    			sum += baum[i];
	    			node[i] = sum;
	    		}
	    	}
	    }
	    
	    @Override
	    public List<List<String>> get_codes() {
	        return null;
	    }

	    @Override
	    public String encode(String plain_text) {
	        return null;
	    }

	    @Override
	    public String decode(String huffman_text) {
	        return null;
	    }
	
	public static void getStringHuffmanCode(Node node, String str) {
		if(node == null) {
			return;
		}
		getStringHuffmanCode(node.getLeft(), str + "0");	// left node reflexiv 
		getStringHuffmanCode(node.getRight(), str + "1");
		if(node.getAlphabet() != '\0') {	
			encodedCode.put(node.getAlphabet(), str);
		}
	}
	
	public static DecodeNode makeHuffmanTree(PriorityQueue<DecodeNode> q) {
		DecodeNode root = new DecodeNode(null, '-'); 
		
		while(!q.isEmpty()) {
			DecodeNode node = q.poll();
			String code = node.getCode();
			char alphabet = node.getAlphabet();
			DecodeNode currentNode = root;
			for(int i = 0; i < code.length() - 1; i++) {	// 맨 끝 자리 수 전까지 탐색해서 노드를 만들어놓는다.
				char direction = code.charAt(i);
				if(direction == '0') {
					if(currentNode.getLeft() == null) {	//	왼쪽 자식의 노드가 널이면
						currentNode = addLeftNode(currentNode, null, '-');
					}
					else {
						currentNode = currentNode.getLeft();
					}
				}
				if(direction == '1') {
					if(currentNode.getRight() == null) {	//	오른쪽 자식의 노드가 널이면
						currentNode = addRightNode(currentNode, null, '-');
					}
					else {
						currentNode = currentNode.getRight();
					}
				}
//				addNode(direction, code, '-');
			}
			char direction = code.charAt(code.length() - 1);	// 가장 끝 코드 문자 얻기
			if(direction == '0') {
				addLeftNode(currentNode, code, alphabet);
			}
			if(direction == '1') {
				addRightNode(currentNode, code, alphabet);
			}
		}
		return root;
	}
}
