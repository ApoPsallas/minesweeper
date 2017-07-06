package minesweeper;

public class Tile {
	private boolean mine;
	private boolean revealed;
	private int value;
	public Tile(){
		this.mine = false;
		this.revealed = false;
		this.value = 0;
	}
	public boolean isMine() {
		return mine;
	}
	public void setMine(boolean mine) {
		this.mine = mine;
	}
	public boolean isRevealed() {
		return revealed;
	}
	public void setRevealed(boolean revealed) {
		this.revealed = revealed;
	}
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	};
	
}