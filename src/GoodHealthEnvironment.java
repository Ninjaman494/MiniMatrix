import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class GoodHealthEnvironment extends Rectangle implements Environment {

	public GoodHealthEnvironment(int x,int y,int w,int h){ 
		super(x,y,w,h); 
		super.setFill(Color.GRAY);
	}
	
	@Override
	public boolean getHealthState() {
		return true;
	}

	@Override
	public boolean inEnvironment(BaseCharacter c) { 
		return c.intersects(this.getBoundsInLocal());
	}

	@Override
	public Rectangle getBoundingBox() {
		return this;
	}

}
