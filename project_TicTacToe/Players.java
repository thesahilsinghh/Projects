package project_TicTacToe;

public class Players {

	String name;
	char symbol;

	public Players(String name, char sy) {
		// TODO Auto-generated constructor stub
		this.name = name;
		this.symbol = sy;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	public void setSymbol(char symbol) {
		this.symbol = symbol;
	}
	public String getName() {
		return name;
	}
	public char getSymbol() {
		return symbol;
	}

}
