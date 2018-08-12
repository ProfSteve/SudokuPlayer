
/**
 * Cell view, used for obtaining coordinate and value data about a board cell
 *
 * @author Stephen Lackey
 * @version August 7, 2018
 */
public class Cell
{
    // instance variables - replace the example below with your own
    private int row;
    private int column;
    private int playvalue;

    /**
     * Constructor for each Play
     */
    public Cell()
    {
        // initialise instance variables
        playvalue = 0;
    }

        public Cell(int row, int col, int val)
    {
        // initialise instance variables
        this.row = row ; 
        this.column = col;
        this.playvalue = val;
    }
    
    
    /**
     * Get the value of the cell
     *
     * @return    the value of the cell
     */
    public int getPlayValue()
    {
        // put your code here
        return playvalue;
    }
    
    /**
     * set the value of the cell
     *
     * @param    newVal     the value of the cell
     */
    public void setPlayValue(int newVal)
    {
        // put your code here
        playvalue = newVal;
    }
    
    
    /**
     * Get the row number of the cell
     *
     * @return    the row number of the cell
     */
    public int getRow()
    {
        // put your code here
        return row;
    }
    
    /**
     * Get the column number of the cell
     *
     * @return    the column number of the cell
     */
    public int getColumn()
    {
        // put your code here
        return column;
    }
        /**
     * Get the box number of the cell
     *
     * @return    the box number of the cell
     */
    public int getBox()
    {
        // put your code here
        int boxRow = 3 * ( row / 3);
        int boxCol = column / 3 ;
        
        return boxRow + boxCol ;
    }
    
    public String toString()
    {
        return "row: " + row + "\tcol: " + column + "\tbox: " + getBox() + "\tval: " + playvalue;
    }
    
}
