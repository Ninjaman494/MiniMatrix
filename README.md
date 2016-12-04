# MiniMatrix
A program that simulates humanity. Squares represent humans and they interact with each other according to various social forces and environments. 

##TO-DO List 
* Implement vision areas to improve movement 
* Make Social force and Relationship interfaces 
* Improve documentation and create a wiki to make contribution easier  
* Improve structure of code so it's easier to create and implement new Social forces, Relationships, and Environments 
* Create a debug tool which can be used to monitor the stats of any character in the world

##Current Features 
* The world is autopopulated with male and female characters.  
  * They are randomly spawned in the world and their gender is decided randomly, but a 50/50 ratio will try to be maintained.  
* The social force for marriage has been created.  
  * Currently it's very crude, characters get married according to the number of collisions they've had and only heterosexual marriages are allowed 
  * A Social Force affects characters through Relationships, a relationship is an object "shared" between all the characters in the relationship. It holds variables and uses its Social Force's onCollision and onFrame methods.
* Basic environments have been created 
   * GoodHealth environments and BadHealth environment exist, both implement the Environment interface. Characters will leave a BadHealth environment if they're spawned in one and head to the nearest GoodHealth environment. Characters start off knowing the location of all environments in the world.
* Basic movement algorithim has been created. 
  * Characters currently have two movements algorithims, the proper algorithim to use is chosen based on a master algorithim in the character's chooseMove method. Default movement is chosen if in a GoodHealth environment. Default movement simply moves the characters randomly within a 5x5 area.
