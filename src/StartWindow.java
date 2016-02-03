import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.image.BufferStrategy;

import javax.swing.event.MouseInputListener;


public class StartWindow extends Canvas implements MouseInputListener {
	Point mousePos;
	Rectangle startButRect;
	public StartWindow(){
		mousePos = new Point();
		startButRect = new Rectangle(0,0,100,50);
		
	}
	public void render(Graphics g){

	//	Graphics g = bs.getDrawGraphics(); 
		g.setColor(Color.BLACK);
		g.fillRect(startButRect.x, startButRect.y, startButRect.width, startButRect.height);
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		mousePos = MouseInfo.getPointerInfo().getLocation();
		if(startButRect.contains(mousePos)){
	//		Core.gameState = GameState.RUNNING;
		}
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseDragged(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
