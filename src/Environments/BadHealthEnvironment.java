package Environments;

import Characters.BaseCharacter;
import Environments.Environment;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class BadHealthEnvironment extends Rectangle implements Environment {
	
	public BadHealthEnvironment(int x,int y,int w,int h){ 
		super(x,y,w,h); 
		super.setFill(Color.BLACK);
	}
	
	@Override
	public boolean getHealthState() {
		return false;
	}

	@Override
	public boolean inEnvironment(BaseCharacter c) {
		//System.out.println(c.intersects(this.getBoundsInLocal())); 
		return c.intersects(this.getBoundsInLocal());
	}

	@Override
	public Rectangle getBoundingBox() {
		return this;
	}

}
