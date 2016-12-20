package Client;

import Characters.BaseCharacter;
import javafx.application.Application;
import javafx.scene.Group;
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

    public static void main(String[] args){
        launch(args);
    }
}
