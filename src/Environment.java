import javafx.geometry.Bounds;
import javafx.scene.shape.Rectangle;

public interface Environment { 
	public boolean getHealthState(); 
	public boolean inEnvironment(BaseCharacter c); 
	public Rectangle getBoundingBox();  
	public double getX(); 
	public double getY(); 
	public double getWidth(); 
	public double getHeight();
}
