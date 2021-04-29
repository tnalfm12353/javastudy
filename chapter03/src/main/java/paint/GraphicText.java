package paint;

public class GraphicText implements Drawable {

	private String text;
	
	public GraphicText(String text) {
		this.text = text;
	}
	
	@Override
	public void draw() {
		System.out.println(text + " 그래픽 텍스트를 그렸습니다.");

	}

}
