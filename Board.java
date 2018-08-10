
/**
 * The Sudoku board, 
 *
 * @author Stephen Lackey
 * @version August 7, 2018
 */
import java.io.*;
public class Board
{
   private int[][] thisBoard ;
   
    /**
     * Constructor for objects of class Board.
     * The board is defined as 9x9 cells.
     */
        
    public Board()
    {
       thisBoard = new int[9][9];
    }
    
    /**
     * Loads board from data in given file
     * 
     * @param   fileName    The filename. If path not specified, current directory is assumed
     */
     public void loadBoard(String fileName)
    {
      int rowcounter = 0;
        try {
                File file = new File(fileName );
     
                BufferedReader reader = new BufferedReader(new FileReader(file));
     
                String thisLine;
                while ((thisLine = reader.readLine()) != null)
                {
                    loadRow(rowcounter++,thisLine);
                    //System.out.println(thisLine);
                }
            }
            
                catch (FileNotFoundException fe)
        {
            System.out.println(fe.getMessage());
        }
    
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    
    }
    
    
    
    /**
     * Create row for Sudoku board from 9-digit input string. 
     *
     * @param  rowNum  the current row number
     *
     * @param  thisRow  a string of the current row values from input data file
     */
    public void loadRow(int rowNum, String thisRow)
    {
     
        for (int i=0; i<thisRow.length(); i++)
        {
            // the indexOf returns a zero-based index or -1 if not found. Just add 1
            //   so that non-numeric values are 0 and numeric values match search string.
            thisBoard[rowNum][i] = "123456789".indexOf(thisRow.charAt(i)) + 1;
        }
    }
    /**
     * Scan row for given value. Returns true if value is found.
     *
     * @param  rowNum  the current row number
     *
     * @param  scanValue  a string of the current row values from input data file
     */
    public boolean scanRow (int rowNum, int scanValue)
    {
        for (int i=0; i<9; i++)
        {
            if (thisBoard[rowNum][i] == scanValue)
            return true;
        }
        return false;
    }
    
    
    
    /**
     * Scan column for given value. Returns true if value is found.
     *
     * @param  colNum  the current row number
     *
     * @param  scanValue  a string of the current row values from input data file
     */
    public boolean scanColumn (int colNum, int scanValue)
    {
        for (int i=0; i<9; i++)
        {
            if (thisBoard[i][colNum] == scanValue)
            return true;
        }
        return false;
    }
    
    /**
     * Scan each box for given value. Returns true if value is found.
     *
     * @param  boxNum  the current box number
     *
     * @param  scanValue  a string of the current row values from input data file
     */
    public boolean scanBox(int boxNum, int scanValue)
    {
        int rowStart = 0;
        int colStart = 0;
        
        switch (boxNum)
        {
            // clarify that the box list is 0-based
            case 0: rowStart = 0;   colStart = 0;   break;
            case 1: rowStart = 0;   colStart = 3;   break;    
            case 2: rowStart = 0;   colStart = 6;   break;   

            case 3: rowStart = 3;   colStart = 0;   break;
            case 4: rowStart = 3;   colStart = 3;   break;    
            case 5: rowStart = 3;   colStart = 6;   break;                
   
            case 6: rowStart = 6;   colStart = 0;   break;
            case 7: rowStart = 6;   colStart = 3;   break;    
            case 8: rowStart = 6;   colStart = 6;   break;                
        }
        
        for (int i=0; i<3; i++)
        {
            for (int j=0; j<3; j++)
            {
                if (thisBoard[rowStart+i][colStart+j] == scanValue)
                return true;
            }    
        }
      
        return false;
    }
    
    
    /**
     * This converts the row, column coordinates into the corresponding box number
     * 
     * @param   thisRow Current row
     * @param   thisCol Current column
     * 
     * @returns     box number corresponding to row/column
     */
    
    public int getBox(int thisRow, int thisCol)

    {
        int boxRow = 3 * ( thisRow / 3);
        int boxCol = thisCol / 3 ;
        
        return boxRow + boxCol ;
    }
   
    /**
     * Outputs board state to a String including played cells
     * 
     * @returns a string representation of the board state
     */
     public String toString()
     {
        StringBuffer output = new StringBuffer("");
         
         for (int i=0; i<9; i++)
        {
            for (int j=0; j<9; j++)
            {
                if (thisBoard[i][j] == 0)
                    output.append('_');
                else
                    output.append(thisBoard[i][j]);
              
            }    
            output.append("\n");
        }
        return output.toString();
        }

        /**
         * Counts the number of blank cells on the board
         * 
         * @returns the count of blank cells
         */
    public int getNumLeft()
    {
        int numBlanks = 0;
        
        for (int i=0; i<9; i++)
        {
            for (int j=0; j<9; j++)
            {
                if (thisBoard[i][j] == 0)
                   numBlanks++     ;           
            }    
        }
        
        return numBlanks;
    }
    /**
     * Returns the current value of a given cell on the board
     * 
     * @param   rowref  the row reference
     * @param   colref  the column reference
     * 
     * @returns     the current value for the corresponding cell
     * 
     */
     public int getValue(int rowref, int colref)   
     {
        return thisBoard [rowref][colref];
        }
     
   /**
    * Sets the value for a given cell on the board
    * @param   rowref   the row reference
    * @param   colref   the column reference
    * @param   value    the value to set
    * 
    */     
    public void setValue(int rowref, int colref, int value)   
     {
        thisBoard [rowref][colref] = value ;
        }    
        
}

