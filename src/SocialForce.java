public class SocialForce {
		
	public void onCollision(MaritalRelationship r){ 
		this.calculations(r);
	} 
	
	private void calculations(MaritalRelationship r){ 
		if(r.intimacyLevel>=10){ 
			r.husband.isMarried = true;    
			r.wife.isMarried = true;
		} 
		else{ 
			r.intimacyLevel++;
		}
	} 
	
	public void onFrame(MaritalRelationship r){ 
		if(r.intimacyLevel>=10){ 
			r.husband.setX(r.wife.getX()+10); 
			r.husband.setY(r.wife.getY());
		} 
	}
}
