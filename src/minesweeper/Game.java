package minesweeper;

public class Game {
	public static void main(String [] args){
		Board board = new Board();
		Tile [][] gameBoard = board.initialize(10, 20);
		for(int x=0;x<10;x++){
			for(int y=0;y<10;y++){
				if (gameBoard[x][y].isMine())
					System.out.print("* ");
				else if(gameBoard[x][y].getValue()>0)
					System.out.print(gameBoard[x][y].getValue()+" ");
				else
					System.out.print("0 ");
			}
			System.out.println();
		}
	}
}
