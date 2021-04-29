package exception;

import java.io.IOException;

public class MyClass {

	public void danger() throws IOException, MyException{
		System.out.println("some codes1");
		System.out.println("some codes2");
		if(true) {
			throw new MyException();
		}
		
		if(true) {			
			throw new IOException();
		}
		
		System.out.println("some codes3");
		System.out.println("some codes4");
	}
}
