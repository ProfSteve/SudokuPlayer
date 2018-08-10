
/**
 * The Plays class tracks the board state and provides view to the Board model
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Plays
{
    // instance variables - replace the example below with your own
    private Cell[] playHistory ;
    private int lastPlay ; 
    private Board board ; 
    private int lastRow;
    private int lastCol;
    /**
     * Initialize the Play stack. This keeps track of the history of cells played.
     */
    public Plays()
    {
        // Initialize stack
        playHistory = new Cell[200];
        // initialize the play stack to -1
        lastPlay = 0;
        board = new Board();
        lastRow = 0;
        lastCol = 0;
    }

     /**
     * Initialize the board from the given filename
     *
     * @param  fileName - name of the file
     */
    
    public void startBoard(String fileName){

      board.loadBoard(fileName);
      // System.out.println(board);
    
    }
    
    /**
     *  Add a play to the play stack
     * 
     * @param   row
     * @param   col
     * @param   value
     */
    public void addPlay(int row, int col, int value)
    {    /**
     * Add a play to the play stack
     *
     * @param  row  the row of the value played
     * @param  col  the column of the value played
     * @param  value  the value played
     */
        // Could combine the two, but just no
        playHistory[lastPlay] = new Cell(row, col, value);
        lastPlay++;
    }
    
    /**
     * Add a play to the play stack
     *
     * @param  thisCell A Cell object containing the row, column, and value to be played
     */
    
    public void addPlay(Cell thisCell)
    {
        playHistory[lastPlay] = thisCell;
        lastPlay++;
         
        int thisRow = thisCell.getRow();
        int thisColumn = thisCell.getColumn();
        int thisValue = thisCell.getPlayValue();
        
        board.setValue(thisRow, thisColumn, thisValue) ; 
    }
     /**
     * Remove a play from the play stack
     *
     * @param  row  the row of the value played
     * @param  col  the column of the value played
     * @param  value  the value played
     */
    public Cell removePlay ()
    {
        if (lastPlay > 0)
            return playHistory[lastPlay--];
        else 
            return null;

    }
    /**
     *  Get a Cell class reference to the current board cell within each scan
     *  
     *  @returns a Cell object for the current board cell
     */
    public Cell getCurrent()
    {
        return new Cell(lastRow, lastCol, board.getValue(lastRow, lastCol));
    }
    
    /**
     * This returns the next cell as a Cell object reference
     * 
     * @returns a Cell object reference containing the properties of the next cell on the board
     */
    public Cell getNext()
    {
        lastCol++;
        if (lastCol>8) 
        {
            lastCol = 0;
            lastRow++;
            if (lastRow>8 )
            {
                lastRow = 0;
            }
        }
 
        return getCurrent();
    }
    
    /**
     * 
     * This returns the next empty cell as a Cell object reference
     * A cell is considered empty if it has a value of zero.
     * It iterates across each row, and wraps around at the end of the current row, while
     * the current row reference is moved to the next row. 
     * 
     * At the bottom of the board,the 
     * 
     * @returns a Cell object reference containing the properties of the next cell on the board
      */
    public Cell getNextEmpty()
    {
        int getnext = getNext().getPlayValue();
        
        while (getnext>0)
        {
               getnext = getNext().getPlayValue();
            }        
        return getCurrent()  ;      
    }
    /**
     * Get the size of the stack of plays
     * 
     * @returns the internal counter value for the size of the stack
     */
        
    public int getStackSize()
    {
        return lastPlay;
    }
    
    /**
     * Retrieves the number of empty cells from the playing board
     * 
     * @returns the number of empty cells left
     */
    public int getNumLeft()
    {
        return board.getNumLeft();
    }
    
    /**
     * Outputs the current state of the board to the console
     * 
     */
    
    public void showBoard()
    {
        System.out.println(board);
    }
    
    /**
     * Tests a given cell against row, column, and box to determine if the value
     * has been used already in these constraints.
     * 
     * @param   thisCell    instance of cell class containing value
     * @param   thisValue   value to test against row/col/box combination
     */
 
    public boolean testCell(Cell thisCell, int thisValue)
    {
       int  thisRow = thisCell.getRow();
       int thisColumn = thisCell.getColumn();
       int thisBoardValue = thisCell.getPlayValue();
       int thisBox = thisCell.getBox();
        
        if (thisBoardValue>0)
            return false;
        else
        {
            return !board.scanRow(thisRow, thisValue) 
                && !board.scanColumn(thisColumn, thisValue) 
                && !board.scanBox(thisBox, thisValue);
        }
            
    }
}
