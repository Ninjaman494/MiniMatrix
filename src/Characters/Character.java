package Characters;

import Environments.Environment;
import SocialForces.*;
import Behaviors.*;

import SocialForces.Relationships.*;
import javafx.geometry.Point2D;
import javafx.scene.paint.*;
import javafx.scene.shape.Rectangle;
import java.util.ArrayList;

/**
 * Created by akash on 12/7/2016.
 */
public abstract class Character extends Rectangle {
    public String gender;
    public String name;
    public Environment currentEnvironment;
    ArrayList<Environment> environments;
    ArrayList<Character> knownPeople;
    ArrayList<Relationship> relationships;
    ArrayList<SocialForce> forces;
    public Character(int x, int y, int width, int height, String gender, String name) {
        super(x,y,width,height);
        this.gender = gender;
        this.name = name;
        if(gender.equals("male")){
            super.setFill(Color.BLUE);
        }
        else if(gender.equals("female")){
            super.setFill(javafx.scene.paint.Color.RED);
        }
    }

    public abstract void onSpawn(ArrayList<Environment> environments,ArrayList<SocialForce> forces);
    public abstract void onFrame();
    public abstract void onCollisionDetected(Character collidedWith);
    public abstract ArrayList<Behavior> chooseBehaviors();
    public abstract void defaultMovement();

    public String getGender(){
        return gender;
    }
    public String getName(){
        return name;
    }


    //Helper methods for geometric calculations
    public float getAngle(Point2D target) {
        float angle = (float) Math.toDegrees(Math.atan2(target.getY() - super.getY(), target.getX() - super.getX()));
        if(angle < 0){
            angle += 360;
        }

        return angle;
    }

    public Point2D getNearestEnvironment(){
        double min = Integer.MAX_VALUE;
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