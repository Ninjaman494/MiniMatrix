package Behaviors;

import Characters.Character;

/**
 * Created by akash on 12/20/2016.
 */
public class Wander implements Behavior {
    public void execute(Character c){
        int i = (int) (Math.random()*11) - 5;
        int j = (int) (Math.random()*11) - 5;
        c.setX(c.getX()+i);
        c.setY(c.getY()+j);
    }
}
