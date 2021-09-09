package prob5;

public class MyStack {
	
	private int top;
	private String[] stack;
	private int size;
	
	public MyStack(int size) {
		top = -1;
		stack = new String[size];
		this.size = size;
	}

	public void push(String string) {
		++top;
		int i;
		if(top >= size) {
			size = top+1;
			String[] cpy = new String[size];
			for(i=0; i<stack.length; i++) {
				cpy[i] = stack[i];
			}
			cpy[i] = string;
			stack = new String[size];
			for(i=0; i<size; i++) {
				stack[i] = cpy[i];
			}
		}else {
			stack[top] = string;
		}
		
	}

	public String pop() throws MyStackException {
		if(top < 0) {
			throw new MyStackException();
		}
		return stack[top--];
	}

	public boolean isEmpty() {
		if(top > -1) {
			return false;
		}
		return true;
	}
	
}