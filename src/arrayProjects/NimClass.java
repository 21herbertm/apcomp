package arrayProjects;

public class NimClass {




	private int [] _board;//the board for the game -> just an array


	public NimClass()
	{

		NIM_6 nimGame;
		//Determing # of stones in each pile at the beginning.
		_board = new int [4];
		_board[0] = 3;//pile 1 - 3 stones
		_board[1] = 5;//pile 2 - 5 stones
		_board[2] = 8;//pile 3 - 8 stones


		System.out.println("Welcome to the Game of Nim\n" +
				"You'll need to first pick a pile\n" +
				"Then select how many stones you wish to remove\n");
	}
	public String boardAsString()//return the board as a string
	{
		
		String boardStr="";
		for(int row = 0; row < 3; row++)
		{
			if ( row==0) {
				boardStr+=" Pile 1:";
			}
			if (row ==1) {
				boardStr+=" Pile 2:";
			}
			if (row==2) {
				boardStr+=" Pile 3:";
			}
			if(_board[row] == 0)
				boardStr+="    0    ";
			else
				boardStr+= _board[row] + "   ";
		}
		//Print out the piles
	
		return boardStr;

	}

	//Display the game board
	public void displayBoard()//just setting up the board with default values
	{
		for(int row = 0; row < 3; row++)
		{
			if(_board[row] == 0)
				System.out.print("    0    ");
			else
				System.out.print("     " + _board[row] + "   ");
		}
		//Print out the piles
		System.out.println("\n  Pile 1   Pile 2   Pile 3   \n");

	}

	//Determine the player's moves
	public boolean playerMove (int pile, int stones)
	{
		if ((pile < 1) || (pile > _board.length))
		{
			return false;//user specified wrong pile
		}

		if (_board[pile - 1] >= stones)
		{
			_board[pile - 1] -= stones;
			return true;
		}
		else
		{
			return false;
		}
	}


	//Determine the winner of the game
	public int determineWinner()
	{
		boolean complete = true;
		int winner = -1;

		//Checking the piles to see if they're empty.
		if((_board[0] == 0) && ( _board[1]== 0) && ( _board[2]==0) )
		{
			winner = NIM_6.player;//GET STATIC VAR FROM NIM_6 ADDED THIS SO WE CAN DETERMINE WHAT PLAYER IT CURRENTLY IS
			complete = false;
		}

		if(complete == false && winner == 1)
		{
			//Display the results of player 1 winning.
			System.out.println("Player 1 Wins!");
			winner = 1;
		}

		if(complete == false && winner == 2)
		{
			//Display the results of player 2 winning.
			System.out.println("Player 2 Wins!");
			winner = 2;
		}
		return winner;

	}




}
