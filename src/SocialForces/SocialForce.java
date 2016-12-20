package SocialForces;

import Behaviors.Behavior;
import Characters.Character;
import SocialForces.Relationships.Relationship;

/**
 * Created by akash on 12/7/2016.
 */
public interface SocialForce {
    public boolean logic(Character c);
    public Relationship createRelationship(Character c);
    public Behavior chooseBehavior(Character c);
}
