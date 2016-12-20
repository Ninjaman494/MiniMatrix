package Characters;

import java.util.ArrayList;

import Environments.*;
import SocialForces.Relationships.MaritalRelationship;
import javafx.geometry.Point2D;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class BaseCharacter /*extends Character*/ extends Rectangle {
	public boolean isMarried;
	public String gender;
	String name;
	ArrayList<BaseCharacter> knownPeople = new ArrayList<>(); 
	ArrayList<MaritalRelationship> relationships = new ArrayList<>();
	ArrayList<Environment> environments = new ArrayList<>();   
	Environment currentEnvironment = null;
	
	public BaseCharacter(double x,double y,double width,double height,String gender,String name){
		//super(x,y,width,height);
		//4 quadrants
		environments.add(new BadHealthEnvironment(0,0,500,500));  
		environments.add(new GoodHealthEnvironment(0,500,500,500)); 
		environments.add(new BadHealthEnvironment(500,500,500,500));  
		environments.add(new GoodHealthEnvironment(500,0,500,500));  
		//
		/* 2 halves, horizontal
		environments.add(new Environments.BadHealthEnvironment(0,0,1000,500));
		environments.add(new Environments.GoodHealthEnvironment(0,500,1000,500));
		*/
		/*3 Areas ,1 Good top left,1 Bad bottom left,1 Bad right side
		environments.add(new Environments.GoodHealthEnvironment(0,0,500,500));
		environments.add(new Environments.BadHealthEnvironment(0,500,500,500));
		environments.add(new Environments.BadHealthEnvironment(500,0,500,1000));
		*/
		/*5,border pane layout, Bad in the center, Good around
		environments.add(new Environments.GoodHealthEnvironment(0,0,250,1000));
		environments.add(new Environments.GoodHealthEnvironment(250,0,500,250));
		environments.add(new Environments.GoodHealthEnvironment(750,0,250,1000));
		environments.add(new Environments.BadHealthEnvironment(250,250,500,500));
		*/
		this.setX(x);this.setY(y);this.setWidth(width);this.setHeight(height);
		this.gender = gender; 
		this.name = name; 
		isMarried = false;
		if(gender.equals("male")){  
			super.setFill(Color.BLUE);
		} 
		else if(gender.equals("female")){ 
			super.setFill(Color.RED);
		}
	}
	public void chooseMove(){ 
		//Algorithm for movement 
		//TO-DO: Implement vision areas and use them in algorithm 
		
		//Environments.Environment section of algorithm
		if(currentEnvironment !=null){  
			if(currentEnvironment.getHealthState()){
				//if in a GoodHealth environment, choose default movement algorithm
				defaultMovement();
			} 
			else{  
				//Algorithm for leaving a BadHealth environment
				float angle = getAngle(getNearest());
				int i;
				int j;
				if(angle>=315 || (angle>0 && angle<45)){    
					super.setX(super.getX()+5); 
					j = (int) (Math.random()*11) - 5; 
					super.setY(super.getY()+j);
				} 
				else if(angle>=45 && angle<135){  
					j = (int) (Math.random()*11)-5;
					super.setX(super.getX()-j);  
					super.setY(super.getY()+5);
				} 
				else if(angle>=135 && angle<225){ 
					i = (int) (Math.random()*11) - 5;
					super.setX(super.getX()-5); 
					super.setY(super.getY()-i);		
				} 
				else if(angle>=225 && angle<=315){  
					i = (int) (Math.random()*11) - 5;
					super.setX(super.getX()+i); 
					super.setY(super.getY()-5);
				}
				/*
				if(moveToX>super.getX()){ 
					super.setX(super.getX()+5);  
				} 
				else if(moveToX<super.getX()) { 
					super.setX(super.getX()-5);  
				}  
				//Y
				if(moveToY>super.getY()){ 
					super.setY(super.getY()+5);  
				} 
				else if(moveToY<super.getY()) { 
					super.setY(super.getY()-5);  
				}   
				*/
			}
		} 
	} 
	
	public float getAngle(Point2D target) {
	    float angle = (float) Math.toDegrees(Math.atan2(target.getY() - super.getY(), target.getX() - super.getX()));
	    if(angle < 0){
	        angle += 360;
	    }

	    return angle;
	}
	
	public void defaultMovement(){ 
		int i = (int) (Math.random()*11) - 5;  
		int j = (int) (Math.random()*11) - 5;     
		super.setX(super.getX()+i); 
		super.setY(super.getY()+j);
	} 
	
	public void onCollisionDetected(BaseCharacter collidedWith){  
		if(!collidedWith.gender.equals(this.gender) && !knownPeople.contains(collidedWith) && !isMarried && !collidedWith.isMarried){  
			relationships.add(new MaritalRelationship(this,collidedWith));  
			knownPeople.add(collidedWith);
		}  
		
		//onCollision methods
		for(MaritalRelationship m : relationships){ 
			m.onCollision();
		}
	}  
	
	public void onFrame(){   
		boolean isInOne = false;
		for(Environment e: environments){ 
			if(e.inEnvironment(this)){  
				currentEnvironment = e; 
				isInOne = true;
			} 
		} 
		if(!isInOne){currentEnvironment = null; };
		for(MaritalRelationship m : relationships){ 
			m.onFrame();
		}
	}
	public String toString(){ 
		return name;
	} 

	public Point2D getNearest(){  
		double leftpoint; 
		double rightpoint;  
		double min = Double.MAX_VALUE;
		Environment minE =null; 
		Point2D closest = new Point2D(0,0);
		for(Environment e: environments){ 
			if (e.getHealthState()) { 	 			
				double centerx = e.getX()+e.getWidth()/2; 
				double centery = e.getY()+e.getHeight()/2; 
				double distance = Math.sqrt(Math.pow(centerx-getX(),2)+Math.pow(centery-getY(),2));
				if(distance<min){ 
					min = distance; 
					closest = new Point2D(centerx,centery);
				}
				
			}
		}
		return closest;
	}
}
