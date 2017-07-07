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
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Game extends Application{
	
	int boardSize = 10; //tiles
	int sceneWidth = 640; // pixels
	int sceneHeight = 480; //pixels
	int mines = 20;
	public static void main(String [] args){
		launch(args);
		
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
		Board board = new Board();
		Tile [][] gameBoard = board.initialize(boardSize, mines);
		Rectangle[][] rect = new Rectangle[boardSize][boardSize];
		//int[] coords = new int[2];
		Group root = new Group();
		for(int x=0;x<boardSize;x++){
			for(int y=0;y<boardSize;y++){
				rect[x][y] = new Rectangle();
				rect[x][y].setX((sceneWidth/4)+((((sceneWidth/2)/boardSize)*x))); 
				rect[x][y].setY((((sceneWidth/2)/boardSize)*y)+sceneHeight/5); 
				rect[x][y].setWidth(((sceneWidth/2)/boardSize)-2); 
				rect[x][y].setHeight(((sceneWidth/2)/boardSize)-2); 
				rect[x][y].setArcWidth(30.0); 
				rect[x][y].setArcHeight(20.0); 
				rect[x][y].setFill(Color.DARKGREEN);
				root.getChildren().add(rect[x][y]);
			}
		}
		root.setOnMouseClicked(new EventHandler<MouseEvent>() 
		{
			  public void handle(MouseEvent event) {
				int[] coords;
				
				coords = board.getRect(event.getSceneX(), event.getSceneY(),sceneWidth, sceneHeight,boardSize);
			    //System.out.println(coords[0]+", "+coords[1]);
				rect[coords[0]][coords[1]].setFill(Color.BROWN);
				rect[coords[0]][coords[1]].setFill(Color.BROWN);
			    gameBoard[coords[0]][coords[1]].setRevealed(true);
			    if(!gameBoard[coords[0]][coords[1]].isMine()){
			    	if (gameBoard[coords[0]][coords[1]].getValue()!=0){
			    	String value = Integer.toString(gameBoard[coords[0]][coords[1]].getValue());
			    	Text text = new Text(value);
			    	text.setX((((sceneWidth/2)/boardSize)/2)+(sceneWidth/4)+((((sceneWidth/2)/boardSize)*coords[0])));
			    	text.setY((((sceneWidth/2)/boardSize)*coords[1])+(sceneHeight/5)+((sceneWidth/2)/boardSize)/2 ); 
			    	root.getChildren().add(text);
			    	}
			    }
			    else{
			    	rect[coords[0]][coords[1]].setFill(Color.BLACK);
			    }
			    
			  }
			});
	    Scene scene = new Scene(root, sceneWidth, sceneHeight);
		scene.setFill(Color.GREEN);
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}
}
