package DataStructure;

import java.util.Stack;

//演示栈Stack的基本使用
public class TestStack {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Stack<String> stack = new Stack();
		//入栈
		stack.add("jack");
		stack.add("tom");
		stack.add("smith");
		
		//取出
		while (stack.size()>0) {
			System.out.println(stack.pop());  //将栈顶的数据取出
			
		}
		//recap：栈遵循先入后出的原则(FILO, First in last out!)
		
	}

}
