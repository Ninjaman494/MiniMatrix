package SocialForces;

import Characters.*;

public class MaritalRelationship {
	BaseCharacter husband; 
	BaseCharacter wife;  
	int intimacyLevel; 
	SocialForce Force = new SocialForce();
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
