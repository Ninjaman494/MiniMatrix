import javafx.animation.Animation;
import javafx.animation.AnimationTimer;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.PathTransition;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.HLineTo;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

public class CanvasDraw extends Application {
	@Override
    public void start(Stage stage) { 	
        //Canvas canvas = new Canvas(500, 500); 
        int POPULATION_COUNT = 100;
        Group root = populate(POPULATION_COUNT);  
        Scene scene = new Scene(root, 1000, 1000); 
        stage.setTitle("Mini Matrix");
        stage.setScene(scene);
        stage.show();        


        AnimationTimer timer = new AnimationTimer() { 
        private long last =0;  
            @Override // Actions to handle on every frame update
            public void handle(long l) { 
            	if(l-last>=100_000_000){ 
            		//default actions
            		for(Node o: root.getChildren()){
            			((BaseCharacter)o).chooseMove(); 
            			((BaseCharacter)o).onFrame();
            		}   
            		
            		//Methods to check(relationship's "check" method)
            		checkForCollisions(root);
            		last = l;
            	}
            }
            
        };  
        timer.start(); 

    }  
	
	private Group populate(int pop){ 
		String[] maleNames = {"Nicky", "Titus", "Charlie", "Agustin" ,"Damion" ,"Floyd","Theodore","Marcel"
							,"Kennith","Randall"};
		Group root = new Group();  
		for(int i = 0;i<pop;i++){ 
			int x = (int) (Math.random()*800)+100;//+250;  
			int y = (int) (Math.random()*800)+100;//+250;    

			int gender = (int)(Math.random()*2); 
			if(gender ==0){
				root.getChildren().add(new BaseCharacter(x,y,10,10,"male",maleNames[1]));
			} 
			else if(gender ==1){
				root.getChildren().add(new BaseCharacter(x,y,10,10,"female",maleNames[1]));
			} 
		} 
		return root;
	} 
	
	public void checkForCollisions(Group root){  
		for(int i = 0;i<root.getChildren().size();i++){  
			Node o = root.getChildren().get(i);
			for(int j = 1;j<root.getChildren().size();j++){  
				Node x = root.getChildren().get(j);
				 if (x.getBoundsInParent().intersects(o.getBoundsInParent()) && !x.equals(o)){ 
					 ((BaseCharacter) o).onCollisionDetected((BaseCharacter) x); 
					 ((BaseCharacter) x).onCollisionDetected((BaseCharacter) o); 
					 
				 }
			}
		}
	}
	
	public static void main(String[] args){ 
		launch(args); 
	} 
}
