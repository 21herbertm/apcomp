package arrayProjects;
import java.util.*;
import java.awt.event.*;
import java.applet.*;  
import java.awt.Graphics;  
import java.awt.*;
import java.applet.*;
public class NIM_6 extends Applet implements ActionListener{
	
	NimClass myAssistant = new NimClass();
	public static int player = 1;

	TextField playerPile_1, playerStones_1;
	TextField playerPile_2, playerStones_2;
	TextField boardField;
	Label playerPile_1_label,playerStones_1_label;
	Label playerPile_2_label,playerStones_2_label;
	Label instructions_label;
	Label winner_label;

	Button runButton;		
	

	public NIM_6() {

	}

	public void init()
    {
		resize( 500,300);
		
		//CREATE BUTTON
		runButton = new Button("Run Player Turn");	
		
		//ASSIGN AN ACTION WHEN THE BUTTON IS CLICKED
		runButton.addActionListener(this);
		runButton.setActionCommand("Click");
		
		//ADD THE BUTTON TO THE APPLET
		add(runButton);
		
		
		boardField= new TextField(60);
            playerPile_1 = new TextField(10);
            playerStones_1 = new TextField(10);
            playerPile_2 = new TextField(10);
            playerStones_2 = new TextField(10);
            
            
            instructions_label = new Label("You'll need to first pick a pile, Then select how many stones you wish to remove");
            playerPile_1_label= new Label("player 1 Pile #:");
            playerStones_1_label= new Label("player 1 # of Stones:");
            
            
            playerPile_2_label= new Label("player 2 Pile #:");
            playerStones_2_label= new Label("player 2 # of Stones:");
            
            winner_label= new Label("NO WINNER YET!!!!!");
            
            add(instructions_label);
            add(playerPile_1_label);
            add(playerPile_1);
            add(playerStones_1_label);
            add(playerStones_1);
            add(playerPile_2_label);
            add(playerPile_2);
            add(playerStones_2_label);;
            add(playerStones_2);
            add(boardField);
            add(winner_label);
        
            playerPile_1.setText("1");
            playerStones_1.setText("1");
            playerPile_2.setText("1");
            playerStones_2.setText("1");
        	
            
            String boardAsString=myAssistant.boardAsString();//board gets set up
    		boardField.setText(boardAsString);
          

    }
	
	
	public void actionPerformed(ActionEvent ae) {
		int a=0,b=0,c=0;
		String str1,str2,str;



		int pile = 0;//which pile to pick from
		int stones = 0;//how many stones to pick


		String actionType=ae.getActionCommand();
		if ( actionType.equals("Click")) {
			try
			{
				if (player==1) {
					str1=playerPile_1.getText();
					pile=Integer.parseInt(str1);

					str2=playerStones_1.getText();
					stones=Integer.parseInt(str2);
					myAssistant.playerMove(pile, stones);

				} else {
					str1=playerPile_2.getText();
					pile=Integer.parseInt(str1);

					str2=playerStones_1.getText();
					stones=Integer.parseInt(str2);
					myAssistant.playerMove(pile, stones);
				}
				
			}
			catch(Exception e)
			{
			}

		}







		//ALTERNATE PLAYERS
		if (player == 1)
			player = 2;
		else
			player = 1;

		//Display board / determine the winner of the game.


		String boardAsString=myAssistant.boardAsString();//board gets set up
		boardField.setText(boardAsString);
		boardField.show();
		
		
		int winner =myAssistant.determineWinner();
		
		if ( winner==0) {
			winner_label.setText("!!!!!NO WINNER YET!!!!!");
		}else if (winner ==1) {
			winner_label.setText(" PLAYER 1 IS THE WINNER---GAME OVER");
		}else if ( winner==2){
			winner_label.setText("PLAYER 2 IS THE WINNER---GAME OVER");
		}
		winner_label.show();
		
	}
    public void paint(Graphics g)
    {
     
            
         
    
    		

    }
	  


	/*****public static void main(String[] args)
	{

	
		int pile = 0;//which pile to pick from
		int stones = 0;//how many stones to pick
		int counter = 0;//if the game is over or not -> 0 not over
		int move;

		//Scanner 
		Scanner input = new Scanner(System.in);

		NimClass myAssistant = new NimClass();
		myAssistant.displayBoard();//board gets set up

		//Begin loop
		while(counter == 0)
		{
			//Choose pile you want to remove stones from.
			System.out.print("Player " + player + " Please enter the pile you wish" +
					" to remove from. (1, 2, 3 )\n");
			pile = input.nextInt();//get a pile number

			//Enter # of stones you want to remove.
			System.out.print("Player " + player + " Please enter the amount of" +
					" stones you wish to remove\n");
			stones = input.nextInt();


			myAssistant.playerMove(pile, stones);





			//Determine what player is entering the values.
			if (player == 1)
				player = 2;
			else
				player = 1;

			//Display board / determine the winner of the game.
			myAssistant.displayBoard();
			myAssistant.determineWinner();


			if (myAssistant.determineWinner() != -1)
				counter = 1;

		}



	}******/


}
