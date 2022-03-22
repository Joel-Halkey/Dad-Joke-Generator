package dadjokegeneratorfx;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class DadJokeGeneratorFX extends Application {
    public static Text dadda = new Text();
    public static Text dad = new Text("      ");
    public static ArrayList<String> dadJokes = new ArrayList();
    public void start(Stage primaryStage) throws IOException {
        
        Button btn = new Button("Generate");
        
        btn.setOnAction(this::processDadJoke);
        
        Scanner fileIn = new Scanner(new File("dadjokes.txt"));
        //Creating the gridpane
        GridPane grid = new GridPane();
               
        while(fileIn.hasNext()){
            String tmp = fileIn.nextLine();
            dadJokes.add(tmp);
        }
        
        grid.add(btn,0,1); 
        grid.add(dad, 1, 1);
        grid.add(dadda, 2 ,1);
        btn.setFont(Font.font(20));
        dadda.setFont(Font.font(20));
        
        
        Scene scene = new Scene(grid, 1000, 50);
        primaryStage.setTitle("Dad Joke Generator");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    
    public static void main(String[] args) {
        launch(args);
    }

    public void processDadJoke(ActionEvent event) {
        Random rand = new Random();
        int temp = rand.nextInt(dadJokes.size());
        dadda.setText(dadJokes.get(temp));
    }
    
}
