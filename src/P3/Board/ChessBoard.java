package P3.Board;

import P3.Game.Player;
import P3.Piece.Piece;

import P3.Position.Position;

public class ChessBoard extends Board{
	private final String[][] chessBoard = new String[8][8];
	// Abstraction function:
    // 	AF(chessBoard) = the board that you will play the game on
    // Representation invariant:
    //	the field must be non null,and the reference could not be changed
    // Safety from rep exposure:
    //  the field is private and final
    //	all the mutators do not change the rep invariant
	//	the observer will make copy defensive
    
    // constructor
		public ChessBoard()
		{
			initailBoard();
			checkRep();
		}
		//checkRep
		private void checkRep()
		{
			for(int i = 0;i<8;i++)
			{
				for(int j =0;j<8;j++)
				{
					assert chessBoard[i][j] != null;
				}
			}
		}
	@Override
	public String getPosition(Position thisPlace)
	{
		if(isLegalPlace(thisPlace))
		return new String(chessBoard[thisPlace.getX()][thisPlace.getY()]);
		else
		{
			System.out.println("Illegal place");
			return null;
		}
	}
	
	@Override
	public void initailBoard()
	{
		for(int i = 0;i < chessBoard.length;i++)
		{
			for(int j = 0;j < chessBoard.length;j++)
			{
				chessBoard[i][j] = "empty";
			}
		}
	}
	
	@Override
	public void printBoard()
	{
		for(int i = 0;i < chessBoard.length;i++)
			System.out.printf("%-12s",i);
		
		System.out.println();
		for(int i = 0;i < chessBoard.length;i++)
		{
			for(int j = 0;j <=chessBoard.length;j++)
			{
				if(j == chessBoard.length)
					System.out.print("	"+i);
				else
					System.out.printf("%-12s",chessBoard[i][j]);
			}
			System.out.println();
		}
	}
	
	@Override
	public boolean isLegalPlace(Position where)
	{
		if((where.getX()>= 0 && where.getX() < 8) && (where.getY()>= 0 && where.getY() < 8))
			return true;
		else
			return false;
	}
	
	@Override
	public boolean isEmpty(Position where)
	{
		if(!isLegalPlace(where))
		{
			System.out.println("illegal place");
			return false;
		}
		if(chessBoard[where.getX()][where.getY()].equals("empty"))
			return true;
		else
			return false;
			
	}
	
	/**
	 * put the piece on a legal and empty position
	 * @param whichPlayer,the player that the piece belongs to
	 * @param whichPiece,the piece that you want to put
	 * @param where,the place you want to put at
	 * @return true if succeeded,else false
	 */	
	public boolean putPiece(Player whichPlayer,Piece whichPiece,Position where)
	{
		if(!isLegalPlace(where))
		{
			System.out.println("illegal place");
			return false;
		}
		if(isEmpty(where)) {
			chessBoard[where.getX()][where.getY()] = whichPlayer.toString()+"'s "+whichPiece.toString();
			return true;
		}
		else
		{
			System.out.println("有棋子了！");
			return false;
		}
	}
	
	/**
	 * make a legal place where has existed a piece empty
	 * @param where,the position you want to make it empty
	 * @return true if succeeded,else false
	 */
	public boolean makePositionEmpty(Position where)
	{
		if(!isLegalPlace(where))
		{
			System.out.println("illegal place");
			return false;
		}
		else
		{
			if(isEmpty(where))
			{
				System.out.println("NO piece at this place!");
				return false;
			}
			else {
				chessBoard[where.getX()][where.getY()] = "empty";
				return true;
			}
		}
	}
	
	
}
