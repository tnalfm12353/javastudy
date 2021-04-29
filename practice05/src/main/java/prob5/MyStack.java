package prob5;

public class MyStack {
	
	private String [] data;
	private int top = -1;
	
	public MyStack (int size) {
		data = new String [size];
	}
	
	public void push(String data) {
		if(this.data.length-1 == top) {
			resize();
		}
		top++;
		this.data[top] = data;
	}
	
	public String pop() throws MyStackException{
		if(top < 0) {
			throw new MyStackException();
		}
		String popData = data[top]; 
		data[top] = null;
		top--;
		return popData;
	}
	
	public void resize() {
		String [] resizingData = new String [top + 10];
		for(int i = 0 ; i < data.length; i++) {
			resizingData[i] = data[i];
		}
		
		data = resizingData;
	}

	public boolean isEmpty() {
		return top >= 0? false : true;
	}
}