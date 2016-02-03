import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;


public class Food {
	Rectangle rect = new Rectangle();
	Random rn;
	
	public Food(int x ,int y){
		rect.x = x;
		rect.y =y;
		rect.width = 50;
		rect.height = 50;
		rn = new Random();
		resetPosition();
	}
	
	public void update(Player player){
		if(player.rect.intersects(this.rect)){
			player.score++;
			resetPosition();
			player.collided = true;
		}
		else{
			player.collided = false;
		}
		
	}
	
	public void render(Graphics g){
	Color color = new Color(rn.nextInt(255),rn.nextInt(255),rn.nextInt(255));
		g.setColor(color);
		g.fillOval(rect.x,rect.y,rect.width,rect.height);
				
	}
	public void resetPosition(){
		int randx = rn.nextInt((Core.WIDTH-50) -50 + 1);
		int remx = randx%50;
		rect.x = randx - remx;
		int randy = rn.nextInt((Core.HEIGHT-50)-50 + 1);
		int remy = randy%50;
		rect.y = randy-remy;
	}

}
