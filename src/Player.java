import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;



public class Player implements KeyListener{
	Rectangle rect = new Rectangle(0,0,0,0);
	int speed;
	public Integer score;
	boolean up,down,left,right, collided;
	List<AddBlock> addBlockArr;
	Random rand;
	Rectangle prevRect = new Rectangle();
	int x,y;
	AddBlock block1;

	public Player(int x, int y){
		rect.x =x;
		rect.y = y;
		rect.width =50;
		rect.height = 50;
		speed =50;
		up = false;
		down = false;
		left = false;
		right = false;
		collided = false;
		score = 0;
		addBlockArr = new ArrayList<AddBlock>();
		rand =  new Random();

	}
	
	
	public void update(Food food){
		this.checkBounds();
		this.checkInternalCollision();
		Rectangle previousRect = new Rectangle(this.rect);
		this.move();
		if(this.rect.intersects(food.rect)){
			score++;
			food.resetPosition();
			if(addBlockArr.isEmpty()){
				addBlockArr.add(new AddBlock(previousRect));
			}
			else{
				addBlockArr.add(new AddBlock((addBlockArr.get(addBlockArr.size()-1).previousRect)));
			}

		}
		
		for(int i =0; i<addBlockArr.size(); i++){
			if(i ==0){
				addBlockArr.get(i).update(previousRect);
			}
			else{
				addBlockArr.get(i).update(addBlockArr.get(i-1).previousRect);


			}
			

		}

		
	}	 

	public void render(Graphics g) {
		g.setColor(Color.WHITE);
		g.setFont(new Font("TimesRoman", Font.PLAIN, 40));
		String scoreString = "Score: "+score.toString();
		g.drawString(scoreString, 10, 50);
		

		g.setColor(new Color(0,255,250));
		g.fillOval(rect.x, rect.y, rect.width, rect.height);
		
		for(int i = 0;i <addBlockArr.size(); i++){
			addBlockArr.get(i).render(g);
		}
	}


	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_UP){
			up = true;
			down = false;
			left = false;
			right = false;
		}
		else if(e.getKeyCode() == KeyEvent.VK_DOWN){
			up = false;
			down = true;
			left = false;
			right = false;
		}
		else if(e.getKeyCode() == KeyEvent.VK_LEFT){
			up = false;
			down = false;
			left = true;
			right = false;		}
		else if(e.getKeyCode() == KeyEvent.VK_RIGHT){
			up = false;
			down = false;
			left = false;
			right = true;		}
	}


	@Override
	public void keyReleased(KeyEvent e) {
	
		
	}


	@Override
	public void keyTyped(KeyEvent e) {
		
		
	}
	public void move(){
		if (up == true){
			rect.y -= speed;
		}
		if (down == true){
			rect.y += speed;
		}
		if(right == true){
			rect.x += speed;
		}
		if(left  == true){
			rect.x -= speed;
		}
	}
	public void checkBounds(){
		if(this.rect.x < (-this.rect.width/2)){
			this.rect.x = Core.WIDTH-(rect.width/2);
			
		}
		if(this.rect.x > Core.WIDTH -(rect.width/2)){
			this.rect.x = -1*this.rect.width/2;
		}
		if(this.rect.y < -this.rect.height/2){
			this.rect.y = Core.HEIGHT-(rect.height/2);
			}
		if(this.rect.y > Core.HEIGHT-(rect.height/2)){
			this.rect.y = -this.rect.height/2;
		}
		
		
	}
	
	public void checkInternalCollision(){
		for(int i = 0; i<addBlockArr.size(); i++){
			if(addBlockArr.get(i).rect.intersects(this.rect)){
				
				System.out.println("Game over");
				System.exit(0);
			}
		}
		
		
	}
	
	
	
}
