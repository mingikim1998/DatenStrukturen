import java.util.Stack;
import java.util.ArrayList;
public class Main {
	static Stack<Character> stack = new Stack<Character>();
//	public class ListStack() {
//		private ArrayList stacks;
//	}
    public static void main(String[] args) {
    	Stack<Character> stack = new Stack<Character>();
    	stack.push('9');
    	stack.push('2');
    	stack.push('4');
    	stack.push('8');
    	stack.push('5');
    	stack.push('1');
    	System.out.println(isParenthesisMatch("{[()]}"));
    }
    public static char push(char value) {
    	return stack.push(value);
    }
    public boolean isEmpty(Stack<Character> stack) {
    	return stack.empty();
    }
    public static Stack sortStack(Stack<Character> stack) {
    	Stack<Character> tempStack = new Stack<Character>();
    	while (stack.empty()==false) {
    		char tmp = stack.pop();
    		while (tempStack.empty()== false && tempStack.peek()<tmp) {
    			stack.push(tempStack.pop());
    		}
    		tempStack.push(tmp);
    	}
    	return tempStack;
    }
    public static boolean isParenthesisMatch(String str) {
    	Stack<Character> stack1 = new Stack<Character>();
    	Stack<Character> stack2 = new Stack<Character>();
    	if (str.length()%2 !=0) {return false;}
    	for (int i=0; i<str.length()/2; i++) {stack1.push(str.charAt(i));}
    	for (int i=(str.length())-1; i>=str.length()/2; i--) {stack2.push(str.charAt(i));}
    	while (!stack1.isEmpty()){
    		char tmp = stack1.pop();// 이거 왜 변수 지정하면 되고?? 따로 쓰면 안돼?
    		char tmp2 = stack2.pop();
    		//if ((stack1.pop()=='(' && stack2.pop()==')')||(stack1.pop()=='[' && stack2.pop()==']')||(stack1.pop()=='{' && stack2.pop()=='}')) {
    		if ((tmp=='(' && tmp2==')')||(tmp=='[' && tmp2==']')||(tmp=='{' && tmp2=='}')) {
    			continue; 
    		}
    		else {return false;}
    	}
    	return true;
    }
}
