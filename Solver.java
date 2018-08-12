
/**
 * Session Controller for Sudoku solver
 *
 * @author Steve Lackey
 * @version 08/06/2018
 */

public class Solver
{
  public static void main(String[] args) 
  {
      String thisFile ; 
      if (args.length >0)
        thisFile = args[0];
      else 
        thisFile = "puzzle1.txt";
      
       Plays newGame = new Plays();
       newGame.startBoard(thisFile);
       
       // Limit to 40 iterations. Easy boards finish in ~10 iterations
       for (int f=0;f<40;f++)
       {
       newGame.showBoard();
       
       System.out.println("Remaining cells: " + newGame.getNumLeft());
       
       if (newGame.getNumLeft()==0) 
        {
            System.out.println("solved in: " + f + " iterations");
            break;
        }
      
       
       for (int i=0;i<newGame.getNumLeft();i++)
       {
          Cell testCell = newGame.getNextEmpty();
          System.out.println(testCell);
          int matches = 0; 
          int matchvalue = 0;
          // matching to a 1-based list...
          for (int j=1; j<10; j++)
          {
              if (newGame.testCell(testCell, j))
              {
                  matches++;
                  matchvalue = j;
                  System.out.println(j);
            }
          }
          if (matches == 1)
          {
           testCell.setPlayValue(matchvalue);
           newGame.addPlay(testCell);
            }
       
        }
       //System.out.println(newGame.getNextEmpty());
    }
    newGame.showBoard();
    
    newGame.saveBoard(thisFile+".sln");

  }
  
 
}