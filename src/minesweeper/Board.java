package minesweeper;
import java.util.Random;

public class Board {
	public Board(){};
	Random rand = new Random();
	public Tile[][] initialize(int size, int mines){
		Tile[][] newBoard = new Tile[size][size];
		int x,y;
		for(x=0;x<size;x++){
			for(y=0;y<size;y++){
				newBoard[x][y] = new Tile();
			}
		}
		while(mines>0){
			x = rand.nextInt(size);
			//System.out.println(x);
			y = rand.nextInt(size);
			//System.out.println(y);
			if (!newBoard[x][y].isMine()){
				newBoard[x][y].setMine(true);
				mines--;
			}
		}
		int nxStart, nxFinish,nyStart,nyFinish;
		for(x=0;x<size;x++){
			for(y=0;y<size;y++){
				if (!newBoard[x][y].isMine()){
					if (x==0) nxStart = x;
					else nxStart = x-1;
					if (x==size-1) nxFinish = x;
					else nxFinish = x+1;
					if (y==0) nyStart = y;
					else nyStart = y-1;
					if (y==size-1) nyFinish = y;
					else nyFinish = y+1;
					
					for(int nx = nxStart;nx <= nxFinish; nx++){
						for(int ny = nyStart;ny <= nyFinish;ny++){
							if (newBoard[nx][ny].isMine()){
								newBoard[x][y].setValue(newBoard[x][y].getValue()+1);
							}
						}
							
					}
				
				}
			}
		}
	
		return newBoard;
	}
public void reveal(Tile tile){
	tile.setRevealed(true);
}
public int[] getRect(double x, double y,int width, int height,int size){
	int[] coordinates = new int[2];
	int rectX = (int)((x-(width/4))*size)/(width/2);
	int rectY = (int)((y-(height/5))*size)/(width/2);
	//System.out.println(rectX+", "+rectY);
	
	coordinates[0] = rectX;
	coordinates[1] = rectY;
	return coordinates;
}

}