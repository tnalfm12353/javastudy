package com.douzone.paint.main;

import com.douzone.paint.interf.Drawable;
import com.douzone.paint.point.ColorPoint;
import com.douzone.paint.point.Point;
import com.douzone.paint.shape.*;
import com.douzone.paint.text.GraphicText;

public class PaintApp {

	public static void draw(Drawable drawable) {
		drawable.draw();
	}
//	public static void drawColorPoint(ColorPoint pt) {
//		pt.show();
//	}
//	public static void drawPoint(Point pt) {
//		pt.show();
//	}
//	public static void drawShape(Shape shape) {
//		shape.draw();
//	}
//	public static void drawRect(Rect rect) {
//		rect.draw();
//	}
//	public static void drawTriangle(Triangle triangle) {
//		triangle.draw();
//	}
	
	public static void main(String[] args) {
		
		Point point1 = new Point();
		point1.setX(10);
		point1.setY(20);
		point1.show();
		point1.show(false);
		
		Point point2 = new Point(100, 200);
//		point2.show();
//		drawPoint(point2);
		draw(point2);
		
		Point point3 = new ColorPoint(50,100,"red");
//		point3.setX(50);
//		point3.setY(100);
//		((ColorPoint)point3).setColor("red");
//		point3.show();
//		point3.show(true);
//		drawPoint(point3);
		draw(point3);
		
		Rect rect = new Rect();
//		drawShape(rect);
		draw(rect);
		
		Triangle triangle = new Triangle();
//		drawShape(triangle);
		draw(triangle);
		
		Circle circle = new Circle();
//		drawShape(circle);
		draw(circle);
		
		draw(new GraphicText("hello~"));
		
		//instanceof test 
		
		System.out.println(circle instanceof Object);
		System.out.println(circle instanceof Shape);
		System.out.println(circle instanceof Circle);
		// Error : class는 hierachy 상위와 하위만 instanceof 연산자를 사용할 수 있다. 
//		System.out.println(circle instanceof Triangle);
		
		Shape shape = new Circle();
		System.out.println(shape instanceof Object);
		System.out.println(shape instanceof Shape);
		System.out.println(shape instanceof Circle);
		System.out.println(shape instanceof Rect);  // false
		
		// interface는 hierachy와 상관없이  instanceof 연산자를 사용할 수 있다.
		System.out.println(shape instanceof Drawable);
		System.out.println(shape instanceof Runnable); // false -> 스레드의 인터페이스로 paintApp 과는 관련 없음.
		
	}
}