import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;

public class Ship implements KeyListener, Runnable
{
	
	BufferedImage image;

	/**
	 * The x position of the ship
	 */
	private double xPos;
	/**
	 * The y position of the ship
	 */
	private double yPos;

	/**
	 * The x velocity of the ship
	 */
	private double xVel;
	/**
	 * The y velocity of the ship
	 */
	private double yVel;
	/**
	 * How fast the ship is accelerating
	 */
	private double acceleration;
	
	/**
	 * The angle the ship is facing, always between 0 and 360
	 */
	private double angle;
	/**
	 * The speed the ship is rotating - positive is clockwise, negative is counterclockwise
	 */
	private double rotateSpeed;
	
	/**
	 * The acceleration of the ship will always be this number
	 */
	public static final double ACCELERATION_CONSTANT = 1;
	
	/**
	 * Creates the ship and sets all the values of the ship to 0
	 */
	public Ship()
	{
		xPos = 0;
		yPos = 0;
		xVel = 0;
		yVel = 0;
		acceleration = 0;
		angle = 0;
		rotateSpeed = 0;
		
	}



	@Override
	public void keyPressed(KeyEvent e)
	{
		//Accelerates the ship
		if(e.getKeyChar() == 'w')
		{
			acceleration = ACCELERATION_CONSTANT;
		}
		
		//Rotates the ship
		if(e.getKeyChar() == 'a')
		{
			rotateSpeed = 5;
		}
		if(e.getKeyChar() == 'd')
		{
			rotateSpeed = -5;
		}
	}



	@Override
	public void keyReleased(KeyEvent e)
	{
		//Stops acceleration
		if(e.getKeyChar() == 'w')
		{
			acceleration = 0;
		}
		
		//Stops rotation
		if(e.getKeyChar() == 'a')
		{
			rotateSpeed = 0;
		}
		if(e.getKeyChar() == 'd')
		{
			rotateSpeed = 0;
		}
	}

	@Override
	public void keyTyped(KeyEvent e)
	{
		//this method is unused
	}



	@Override
	public void run()
	{
		while(true)
		{
			try
			{
				Thread.sleep(100);
				update();
			}
			catch(InterruptedException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public void update()
	{
		//changes the angle of the ship, stays between 0 and 360
		angle += rotateSpeed;
		while(angle>360)
		{
			angle-=360;
		}
		while(angle<0)
		{
			angle+=360;
		}
		
		
		//Changes the x and y velocities based on the components of the acceleration vector
		yVel += acceleration * Math.sin(Math.toRadians(angle));
		xVel += acceleration * Math.cos(Math.toRadians(angle));
		
		//moves the ship based on velocities;
		xPos+=xVel;
		yPos+=yVel;
	}


	//Accessors and mutators
	public BufferedImage getImage()
	{
		return image;
	}

	public void setImage(BufferedImage image)
	{
		this.image = image;
	}

	public double getxPos()
	{
		return xPos;
	}

	public void setxPos(double xPos)
	{
		this.xPos = xPos;
	}

	public double getyPos()
	{
		return yPos;
	}

	public void setyPos(double yPos)
	{
		this.yPos = yPos;
	}

	public double getAngle()
	{
		return angle;
	}

	public void setAngle(double angle)
	{
		this.angle = angle;
	}
}
