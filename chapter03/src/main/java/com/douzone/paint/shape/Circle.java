package com.douzone.paint.shape;

public class Circle extends Shape{

	private int x1;
	private int y1;
	private int raidus;	
	
	public int getX1() {
		return x1;
	}

	public void setX1(int x1) {
		this.x1 = x1;
	}

	public int getY1() {
		return y1;
	}

	public void setY1(int y1) {
		this.y1 = y1;
	}

	public int getRaidus() {
		return raidus;
	}

	public void setRaidus(int raidus) {
		this.raidus = raidus;
	}

	@Override
	public void draw() {
		System.out.println("원을 그렸습니다.");
	}
}
