import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.JFrame;


public class Core extends Canvas implements Runnable{
	public static int WIDTH = 1080; 
	public static int HEIGHT = 920;
	public static final int SCALE =1;
	public final String TITLE = "Game";
	private boolean running = false;
	private Thread thread;
	public static Player player;
	public static Food food;
	public List<AddBlock> addBlockArr;
	public GameState gameState;
	
	public Core(){
		player = new Player(50,50);
		food = new Food(500,500);
		addBlockArr = new ArrayList<AddBlock>();
		gameState = GameState.RUNNING;

	}
	
	private synchronized void start(){
		running = true;
		thread = new Thread(this);
		thread.start();
	}


	private synchronized void stop(){
		if (!running){
			return;}
		running = false;
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.exit(1);
	}

	public void run(){
		while(running){
			switch(gameState){
			case START:
				break;
			case RUNNING:
				update();
				render();
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
				break;
			case GAMEOVER:
				break;
			}
		}
		stop();

	}


	public void update(){
		player.update(food);
	//	food.update(player);
	}

	public void render(){
		BufferStrategy bs = getBufferStrategy();
		if (bs == null){
			createBufferStrategy(3);
			return;
		}
		Graphics g = bs.getDrawGraphics(); 
		//graphics stuff
		g.setColor(Color.BLUE);
		g.fillRect(0, 0,this.getWidth(), this.getHeight());
		
		player.render(g);
		
		food.render(g);
		
		g.dispose();
		bs.show();
	}

	public static void main(String[] args) {
		Core game = new Core();
		game.setPreferredSize(new Dimension(WIDTH* SCALE, HEIGHT * SCALE));
	//	game.setMaximumSize(new Dimension(WIDTH* SCALE, HEIGHT * SCALE));
	//	game.setMinimumSize(new Dimension(WIDTH* SCALE, HEIGHT * SCALE));
		game.addKeyListener(player);
		JFrame frame = new JFrame(game.TITLE);
		frame.add(game);
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(true);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	
		game.start();	
	}

}






