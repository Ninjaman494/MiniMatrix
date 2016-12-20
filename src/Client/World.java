package Client;

import Characters.Character;
import Characters.DefaultCharacter;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.scene.paint.Color;

import java.awt.*;

/**
 * Created by akash on 12/20/2016.
 */
public class World extends Application {
    @Override
    public void start(Stage stage){
        int POP_SIZE = 100;
        Group root = populate(POP_SIZE);
       // Group root = new Group();
       // Rectangle r = new Rectangle(250,250,250,250);
        //r.setFill(Color.BLACK);
        //root.getChildren().add(r);
        Scene scene = new Scene(root, 1000, 1000);
        stage.setTitle("Mini Matrix");
        stage.setScene(scene);
        stage.show();



        AnimationTimer timer = new AnimationTimer() {
            private long last =0;
            @Override
            // Actions to handle on every frame update
            public void handle(long l) {
                if(l-last>=100_000_000){
                    //default actions
                    for(Node o: root.getChildren()){
                        ((Character)o).onFrame();
                    }

                    //Methods to check(relationship's "check" method)
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
                root.getChildren().add(new DefaultCharacter(x,y,10,10,"male",maleNames[1]));
            }
            else if(gender ==1){
                root.getChildren().add(new DefaultCharacter(x,y,10,10,"female",maleNames[1]));
            }
        }
        return root;
    }

    public static void main(String[] args){
        launch(args);
    }
}
