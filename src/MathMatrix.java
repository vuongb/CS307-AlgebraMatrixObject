//MathMatrix.java.

//imports


/**
 * A class that models systems of linear equations (Math Matrices)
 * as used in linear algebra.
 *
 * @version Skeleton file for students
 */
public class MathMatrix
{
	
	//Class Constants??
	
	
	private int[][] values;
    
    /**
     * create a MathMatrix with cells equal to the values in mat.
     * A "deep" copy of mat is made.
     * Changes to mat after this constructor do not affect this
     * Matrix and changes to this MathMatrix do not affect mat
     * @param  mat  mat !=null, mat.length > 0, mat[0].length > 0,
     * mat is a rectangular matrix
     */
    public MathMatrix(int[][] mat){
        // check the precondition. rectangularMatrix is a private method at end of Matrix class
        assert ( mat != null ) && ( mat.length > 0 ) && ( mat[0].length > 0 )
                && ( rectangularMatrix(mat) ) : "Violation of precondition: int[][] Matrix constructor";
                
                //Making a Hard copy of arrays, so no problems arrise later.
                //Making a new array, and copying the values.
                values = new int[mat.length][mat[0].length];
                for(int i = 0; i < values.length; i++){
                	for (int j =0;j < values[0].length;j++){
                    values[i][j] = mat[i][j];
                	}
                }
    }


    /**
     * create a MathMatrix of the specified size with all cells set to the intialValue.
     * <br>pre: numRows > 0, numCols > 0
     * <br>post: create a matrix with numRows rows and numCols columns. 
     * All elements of this matrix equal initialVal.
     * In other words after this method has been called getVal(r,c) = initialVal 
     * for all valid r and c.
     * @param numRows numRows > 0
     * @param numCols numCols > 0
     * @param initialVal all cells of this Matrix are set to initialVal
     */
    public MathMatrix(int numRows, int numCols, int initialVal){
    	assert ( numCols > 0 ) && ( numRows > 0 ): "Violation of precondition: Rows and Columns must be > 0";
    	
    	//Putting specified rows and columns in array.
    	values = new int[numRows][numCols];
    	//Storing initialVal in entire 2D array.
    	for (int i =0;  i < values.length;i++)
    	{
    		for ( int j = 0; j < values.length;j++)
    			values[i][j] = initialVal; 		
    	}	
    }


    /**
     * change the value of one of the cells in this MathMatrix.
     * <br>pre: 0 <= row < numRows(), 0 <= col < numCols()
     * <br>post: getVal(row, col) = newValue
     * @param row 0 <= row < numRows()
     * @param col 0 <= col < numCols()
     */
    public void changeElement(int row, int col, int newValue){
    	assert (row >= 0) || ( row < numRows() || col >= 0) || ( col < numCols() ): 
    		"Violation of precondition: Rows and Columns must be > 0";
    	
    	//Changing value into one of the cells given.
    	values[row][col] = newValue;
    }


    /**
     * Get the number of rows.
     * @return the number of rows in this MathMatrix
     */
    public int numRows(){
        return values.length; 
    }


    /**
     * Get the number of columns.
     * @return the number of columns in this MathMatrix
     */
    public int numCols(){
        return values[0].length; 
    }


    /**
     * get the value of a cell in this MathMatrix.
     * <br>pre: row  0 <= row < numRows(), col  0 <= col < numCols()
     * @param  row  0 <= row < numRows()
     * @param  col  0 <= col < numCols()
     * @return the value at the specified position
     */
    public int getVal(int row, int col){
    	assert (row >= 0 && row < numRows() && col >= 0 && col < numCols() ): 
    		"Violation of precondition: Rows and Columns must be >= 0 and within bounds of matrix";
        
    	return values[row][col]; 
    }


   /**
    * implements MathMatrix addition, (this MathMatrix) + rightHandSide.
    * <br>pre: rightHandSide.numRows() = numRows(), rightHandSide.numCols() = numCols()
    * <br>post: This method does not alter the calling object or rightHandSide
    * @param rightHandSide rightHandSide.numRows() = numRows(), rightHandSide.numCols() = numCols()
    * @return a new MathMatrix that is the result of adding this Matrix to rightHandSide.
    * The number of rows in the returned Matrix is equal to the number of rows in this MathMatrix.
    * The number of columns in the returned Matrix is equal to the number of columns in this MathMatrix.
    */
    public MathMatrix add(MathMatrix rightHandSide){
    	assert (rightHandSide.numRows() == this.numRows() && 
    			rightHandSide.numCols() == this.numCols() ): 
    				"Violation of precondition: Rows and Columns need to be of equal length.";

    	//Creating a new Matrix to store the new added matrix.
    	MathMatrix matrix = new MathMatrix(values);
    	int temp = 0;
    	int tempThis = 0;
        for ( int i = 0; i < values.length;i++)
        {
        	temp = 0;
        	tempThis = 0;
        	for ( int j = 0; j < values[0].length;j++)
        	{
        		temp = rightHandSide.getVal(i,j);
        		tempThis = values[i][j];
        		temp = temp+tempThis;
        		matrix.changeElement(i,j,temp);
        	}
        }
        return matrix;
    }


   /**
    * implements MathMatrix subtraction, (this MathMatrix) - rightHandSide.
    * <br>pre: rightHandSide.numRows() = numRows(), rightHandSide.numCols() = numCols()
    * <br>post: This method does not alter the calling object or rightHandSide
    * @param rightHandSide rightHandSide.numRows() = numRows(), rightHandSide.numCols() = numCols()
    * @return a new MathMatrix that is the result of subtracting rightHandSide from this MathMatrix.
    * The number of rows in the returned MathMatrix is equal to the number of rows in this MathMatrix.
    * The number of columns in the returned MathMatrix is equal to the number of columns in this MathMatrix.
    */
    public MathMatrix subtract(MathMatrix rightHandSide){
    	assert (rightHandSide.numRows() == this.numRows() && 
    			rightHandSide.numCols() == this.numCols() ): 
    				"Violation of precondition: Rows and Columns need to be of equal length.";
    	
    	MathMatrix matrix = new MathMatrix(values);
    	int temp = 0;
    	int tempThis = 0;
        for ( int i = 0; i < values.length;i++)
        {
        	temp = 0;
        	tempThis = 0;
        	for ( int j = 0; j < values[0].length;j++)
        	{
        		temp = rightHandSide.getVal(i,j);
        		tempThis = values[i][j];
        		temp = temp-tempThis;
        		matrix.changeElement(i,j,temp);
        	}
        }
        return matrix;
    }


   /**
    * implements matrix multiplication, (this MathMatrix) * rightHandSide.
    * <br>pre: rightHandSide.numRows() = numCols()
    * <br>post: This method should not alter the calling object or rightHandSide
    * @param rightHandSide rightHandSide.numRows() = numCols()
    * @return a new MathMatrix that is the result of multiplying this MathMatrix and rightHandSide.
    * The number of rows in the returned MathMatrix is equal to the number of rows in this MathMatrix.
    * The number of columns in the returned MathMatrix is equal to the number of columns in rightHandSide.
    */
    public MathMatrix multiply(MathMatrix rightHandSide){
        assert(this.numCols() == rightHandSide.numRows()): 
        	"Violation of precondition: # of Columns of calling MathMatrix " +
        	"doesn't equal parameter matrix's # of rows";
        
        int sum = 0;
        int rowIndex = 0;
        int colIndex = 0;
        MathMatrix matrix = new MathMatrix(this.numRows(), rightHandSide.numCols(), 0);
        for(int i = 0; i < matrix.numRows(); i++)
        {
        	for(int j = 0; j < matrix.numCols(); j++)
        	{
        		sum = 0;
        		rowIndex = 0;
        		colIndex = 0;
        		while(rowIndex < rightHandSide.numRows() && colIndex < values[0].length)
        		{
        			sum += values[i][colIndex] * rightHandSide.getVal(rowIndex, j);
        			rowIndex++;
        			colIndex++;
        		}
        		matrix.changeElement(i,j,sum);
//        		for(int m = 0; m < rightHandSide.numCols(); m++)
//        		{
//	        		sum += values[i][colIndex] * rightHandSide.getVal(rowIndex,j);
//	        		colIndex++;
//	        		rowIndex++;
//        		}
        	}
        }
        
        return matrix;
    } 


   /**
    * Multiply all elements of this MathMatrix by factor.
    * <br>pre: none
    * <br>post: all elements in this matrix have been multiplied by factor. 
    * In other words after this method has been called getVal(r,c) = old getVal(r, c) * factor
    * for all valid r and c.
    * @param factor the value to multipy every cell in this Matrix by.
    */
    public void scale(int factor){
    	for ( int i = 0;i < values.length;i++)
    	{
    		for ( int j = 0; j < values[0].length;j++)
    			values[i][j] = values[i][j] * factor;
    	}
    }


    /**
     * accessor: get a transpose of this MathMatrix. 
     * This Matrix is not changed.
     * <br>pre: none
     * @return a transpose of this MathMatrix
     */
    public MathMatrix getTranspose(){
    	
    	//Take a row and switch i and j values into new matrix. Take Col and switch i and j values into new matrix.
    	MathMatrix matrix = new MathMatrix(this.numCols(), this.numRows(), 0);
    	for(int i = 0; i < values.length; i++)
    	{
    		for(int j = 0; j < values[0].length; j++)
        		matrix.changeElement(j,i,values[i][j]);
    	}
        return matrix; //this return can be altered
    }


    /**
     * override equals.
     * @return true if rightHandSide is the same size as this MathMatrix and all values in the
     * two MathMatrix objects are the same, false otherwise
     */
    public boolean equals(Object rightHandSide){
        boolean result = true;
        if( rightHandSide != null && this.getClass() == rightHandSide.getClass()){
            // rightHandSide is a non null MathMatrix
            MathMatrix otherMatrix = (MathMatrix)rightHandSide;
            if ( this == otherMatrix){
            	return true;
            }
            else if (this.numRows() != otherMatrix.numRows() || this.numCols() != otherMatrix.numCols()){
            	return false;
            }
            else
            {
            	
            	for(int i = 0; i < values.length; i++)
            	{
            		for(int j = 0; j < values[0].length; j++)
            			result = result && (values[i][j] == otherMatrix.getVal(i,j));
            	}
            	return result;
            }
            
        }
        return result;
    }


    /**
     * override toString.
     * @return a String with all elements of this MathMatrix. 
     * Each row is on a seperate line.
     * Spacing based on longest element in this Matrix.
     */
    public String toString(){
        //Getting the max number in array
    	int max = 0;
    	String len = "";
    	String out = "";
    	int val = 0;
    	for(int i =0; i < values.length; i++){
    		for (int j =0; j < values[0].length;j++){
    			len = "";
    			val = values[i][j];
    			len += val;
    			max = Math.max(len.length(), max);
    		}
    	}
    	max++;
    	for(int k =0; k < values.length; k++){
    		for (int z =0; z < values[0].length;z++){
    			len = "";
    			len += values[k][z];
    			//Finding number of spaces for value in 2D array.
    			for ( int p = 0; p < max-len.length();p++){
    				out += " ";
    			}
    			out += len;
    		}
    		out += "\n";
    	}
        return out; //this return can be altered
    }
    
    /**
     * Return true if this MathMatrix is upper triangular. To
     * be upper triangular all elements below the main 
     * diagonal must be 0.<br>
     * pre: this is a square matrix. numRows() == numCols()  
     * @return <tt>true</tt> if this MathMatrix is upper triangular,
     * <tt>false</tt> otherwise. 
     */
    public boolean isUpperTriangular(){
    	assert(this.numRows() == this.numCols()): "Violation of PreCondition: The matrix is not a square matrix.";
    	
    	int i = 0;
    	int temp = 0;
    	int count = 0;
    	int counter = values.length-1;
    		for ( int k = 1; k < values.length;k++){
    		counter += values.length - k;
    	}
    	while ( i < values.length){
    		for ( int j=1; j <= values.length;j++){
    		temp = values[j][i];
    		if (temp == 0 && j != i){
    			count++;
    		}
    		}
    		i++;
    	}
    	//If True, then the matrix has all 0's below.
    	if ( counter == count){
    	return true;
    	}
    	else {
        return false;
    	}
    }
    
    //private method to ensure mat is rectangular
    private boolean rectangularMatrix( int[][] mat ){
        boolean isRectangular = true;
        int row = 1;
        final int COLUMNS = mat[0].length;

        while( isRectangular && row < mat.length )
        {   isRectangular = ( mat[row].length == COLUMNS );
            row++;
        }

        return isRectangular;
    }
}