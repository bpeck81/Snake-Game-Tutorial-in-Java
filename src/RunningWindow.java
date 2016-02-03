import java.awt.Color;
import java.awt.Graphics;


public class RunningWindow {
	public static Player player;
	public static Food food;

	
	public void update(){
		
		
	}
	public void render(Graphics g){
		g.setColor(Color.BLUE);
		g.fillRect(0, 0,Core.WIDTH, Core.HEIGHT);
		
		player.render(g);
		
		food.render(g);

		
	}
}
