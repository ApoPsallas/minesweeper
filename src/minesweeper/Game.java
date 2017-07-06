package minesweeper;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class Game extends Application{
	public static void main(String [] args){
		launch(args);
		Board board = new Board();
		Tile [][] gameBoard = board.initialize(10, 20);
//		for(int x=0;x<10;x++){
//			for(int y=0;y<10;y++){
//				if (gameBoard[x][y].isMine())
//					System.out.print("* ");
//				else if(gameBoard[x][y].getValue()>0)
//					System.out.print(gameBoard[x][y].getValue()+" ");
//				else
//					System.out.print("0 ");
//			}
//			System.out.println();
//		}
	
	
	
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle("Minesweeper");
		
		Rectangle[][] rect = new Rectangle[10][10];
		Group root = new Group();
		for(int x=0;x<10;x++){
			
			for(int y=0;y<10;y++){
				rect[x][y] = new Rectangle();
				rect[x][y].setX(100+((400/10)*x)); 
				rect[x][y].setY(((400/10)*y)); 
				rect[x][y].setWidth((400/10)-2); 
				rect[x][y].setHeight((400/10)-2); 
				rect[x][y].setArcWidth(30.0); 
				rect[x][y].setArcHeight(20.0); 
				rect[x][y].setFill(Color.DARKGREEN);
				root.getChildren().add(rect[x][y]);
			}
		}
		root.setOnMouseClicked(new EventHandler<MouseEvent>() 
		{
			  public void handle(MouseEvent event) {
			    System.out.println(event.getSceneX());
			    System.out.println(event.getSceneY());
			  }
			});
	    Scene scene = new Scene(root, 600, 400);
		scene.setFill(Color.GREEN);
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}
}
