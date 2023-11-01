package project_TicTacToe;

public class Board {

	char[][] arr;
	int cross;
	private char sym1;
	private char sym2;
	int count = 0;
	final char empty = ' ';

	public final static int player1Wins = 1;
	public final static int player2Wins = 2;
	public final static int Tie = 3;
	public final static int Incomplete = 4;
	public final static int InvalidMove = 5;

	public Board(char sym1, char sym2) {
		this.cross = 3;
		arr = new char[cross][cross];

		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length; j++) {
				arr[i][j] = empty;
			}
		}
		this.sym1 = sym1;
		this.sym2 = sym2;
	}

	public int move(char symbol, int x, int y) {

		if (x < 0 || y < 0 || x >= cross || y >= cross || arr[x][y] != empty) {
			return 5;
		}

		arr[x][y] = symbol;
		count++;

		// row
		if (arr[x][0] == arr[x][1] && arr[x][0] == arr[x][2]) {
			return symbol == sym1 ? player1Wins : player2Wins;
		}
		// column
		if (arr[0][y] == arr[1][y] && arr[0][y] == arr[2][y]) {
			return symbol == sym1 ? player1Wins : player2Wins;
		}

		// diagonal

		if (arr[1][1] != empty && arr[0][2] == arr[1][1] && arr[0][2] == arr[2][0]) {

			return symbol == arr[0][2] ? player1Wins : player2Wins;
		}

		if (arr[1][1] != empty && arr[0][0] == arr[1][1] && arr[0][0] == arr[2][2]) {

			return symbol == arr[0][2] ? player1Wins : player2Wins;
		}
		if (count == 3 * 3)
			return Tie;

		return Incomplete;

	}

	public void print() {
		// TODO Auto-generated method stub
		System.out.println("----------------");
		for (int i = 0; i < arr.length; i++) {
			System.out.print("||");
			for (int j = 0; j < arr.length; j++) {
				System.out.print(arr[i][j] + "||");
			}
			System.out.println();
		}
		System.out.println("----------------");

	}

}
