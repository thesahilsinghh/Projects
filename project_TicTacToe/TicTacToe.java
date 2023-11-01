package project_TicTacToe;

import java.util.Scanner;

public class TicTacToe {

	private Players p1, p2;
	private Board brd;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TicTacToe t = new TicTacToe();
		t.playGame();

	}

	public Players playerInput(int num) {
		// TODO Auto-generated method stub

		// initialized player's name and their symbol
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter" + num + " player name:");
		String p1Name = sc.next();
		System.out.println("Enter" + num + "player symbol:");
		String temp = sc.next();
		char p1symbol = temp.charAt(0);
		Players p = new Players(p1Name, p1symbol);
		return p;
	}

	private void playGame() {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		p1 = playerInput(1);
		p2 = playerInput(2);

		while (p1.getSymbol() == p2.getSymbol()) {
			System.out.println("Player 2 symbol same as 1, please use another symbol");
			p2.setSymbol(sc.next().charAt(0));
		}

		// board
		brd = new Board(p1.getSymbol(), p2.getSymbol());

		boolean p1Turn = true;
		int status = brd.Incomplete;
		while (status == brd.Incomplete || status == brd.InvalidMove) {

			if (p1Turn) {

				System.out.println("X & y co'ordinates for player " + p1.getName());
				int x = sc.nextInt();
				int y = sc.nextInt();

				status = brd.move(p1.getSymbol(), x, y);
				if (status == 5) {
					System.out.println("Invalid Move");
					continue;
				}

			} else {

				System.out.println("X & y co'ordinates for player " + p2.getName());
				int x = sc.nextInt();
				int y = sc.nextInt();

				status = brd.move(p2.getSymbol(), x, y);
				if (status == 5) {
					System.out.println("Invalid Move");
					continue;
				}

			}

			p1Turn = !p1Turn;

			brd.print();

		}

		if (status == brd.player1Wins) {
			System.out.println(p1.getName() + " wins");
		}

		if (status == brd.player2Wins) {
			System.out.println(p2.getName() + " wins");
		}

		if (status == brd.Tie) {
			System.out.println("Tie");
		}

	}

}
