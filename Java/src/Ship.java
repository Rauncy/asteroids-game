import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;

public class Ship implements KeyListener, Runnable
{
	
	BufferedImage image;

	double velocityX;
	double velocityY;
	double angle;
	double acceleration;
	
	
	public Ship()
	{
		
		
	}



	@Override
	public void keyPressed(KeyEvent arg0)
	{
		// TODO Auto-generated method stub
		
	}



	@Override
	public void keyReleased(KeyEvent e)
	{
		// TODO Auto-generated method stub
		
	}



	@Override
	public void keyTyped(KeyEvent e)
	{
		if(e.getKeyChar() == 'a')
		{
			angle+=5;
		}
		if(e.getKeyChar() == 'd')
		{
			angle-=5;
		}
		if(e.getKeyChar() == 'w')
		{
			acceleration = 1;
		}
		else
		{
			acceleration = 0;
		}
	}



	@Override
	public void run()
	{
		
		
	}
}
