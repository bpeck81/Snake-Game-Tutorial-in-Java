import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;


public class AddBlock {
	Rectangle rect;
	Rectangle previousRect;
	public AddBlock(int x, int y){
		rect = new Rectangle(x,y,50,50);
	}
	
	public AddBlock(Rectangle rect2) {
		rect = rect2;
	}

	public void update(Rectangle rectAhead){
		previousRect = new Rectangle(this.rect);
		this.rect = rectAhead;
		
	}
	
	public void render(Graphics g){
		g.setColor(Color.GREEN);
		g.fillOval(rect.x, rect.y, rect.width, rect.height);
		
	}
	
}
