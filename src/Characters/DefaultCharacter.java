package Characters;

import Behaviors.Behavior;
import Environments.Environment;
import SocialForces.SocialForce;
import javafx.scene.paint.Color;

import java.util.ArrayList;

/**
 * Created by akash on 12/20/2016.
 */
public class DefaultCharacter extends Character {

    public DefaultCharacter(int x, int y, int width, int height, String gender, String name) {
        super(x,y,width,height,gender,name);
    }
    public void onSpawn(ArrayList<Environment> environments, ArrayList<SocialForce> forces){
        this.environments = environments;
        this.forces = forces;

        for(Environment e: environments){
            if(e.inEnvironment(this)){
                this.currentEnvironment = e;
                break;
            }
        }
    }

    public void onFrame(){

    }
    public void onCollisionDetected(Character collidedWith){

    }
    public ArrayList<Behavior> chooseBehaviors(){
        return null;
    }
    public void defaultMovement(){
        int i = (int) (Math.random()*11) - 5;
        int j = (int) (Math.random()*11) - 5;
        super.setX(super.getX()+i);
        super.setY(super.getY()+j);
    }
}
