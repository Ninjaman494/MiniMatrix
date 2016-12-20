package Environments;

import Characters.Character;
import javafx.geometry.Bounds;
import javafx.scene.shape.Rectangle;

public interface Environment {
	public boolean getHealthState(); 
	public boolean inEnvironment(Character c);
	public Rectangle getBoundingBox();  
	public double getX(); 
	public double getY(); 
	public double getWidth(); 
	public double getHeight();
}
