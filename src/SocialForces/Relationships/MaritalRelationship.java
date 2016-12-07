package SocialForces.Relationships;

import Characters.*;
import SocialForces.Marriage;

public class MaritalRelationship {
	public BaseCharacter husband;
	public BaseCharacter wife;
	public int intimacyLevel;
	Marriage Force = new Marriage();
	public MaritalRelationship(BaseCharacter b1, BaseCharacter b2){    
		if(b1.gender.equals("male")){ 
			this.husband = b1; 
			this.wife = b2;   
		} 
		else{ 
			this.husband = b2; 
			this.wife = b1;   
		}
		intimacyLevel = 0;
	}  
	
	public void onCollision(){ 
		Force.onCollision(this);
	} 
	
	public void onFrame(){ 
		Force.onFrame(this);
	}
}
