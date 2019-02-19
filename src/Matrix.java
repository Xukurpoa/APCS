/**
 * @author Tomasz Mroz
 * Implements the mathematical matrix as a 2D array and defines several operations for it
 * Throws subclass Matrix Exception at any input errors
 */
public class Matrix{
    private double[][] matrix;
    private int row;
    private int column;

    /**
     * Creates a matrix of size (a,b)
     * @throws MatrixException Thrown if a or b is negative
     */
    public Matrix(int r, int c)throws MatrixException{
        if(r < 0 || c < 0){
            throw new MatrixException("Matrix Indices cannot be less than 0)");
        }
        else {
            matrix = new double[r][c];
            row = r;
            column = c;
        }
    }

    /**
     * Sets the value of the matrix at (row,column)
     * @param row row to be changed
     * @param column column to be changed
     * @param value value to be set to
     * @throws MatrixException Thrown if row or column are less than zero or greater than the matrix dimensions
     */
    public void set(int row, int column, double value)throws MatrixException{
        if(row < 0 || row > this.row || column < 0 || column > this.column){
            throw new MatrixException("Out of bounds");
        }
        else{
            matrix[row][column] = value;
        }
    }

    /**
     * Returns the value of the matrix at (row,column)
     * @param row row to be changed
     * @param column column to be changed
     * @return value of the matrix at (row,column)
     * @throws MatrixException Thrown if row or column are less than zero or greater than the matrix dimensions
     */
    public double get(int row, int column)throws MatrixException{
        if(row < 0 || row > matrix.length || column < 0 || column > matrix[0].length){
            throw new MatrixException();
        }
        else{
            return matrix[row][column];
        }
    }

    /**
     * Adds the two parameter matrices
     * @return The sum of the two matrices
     * @throws MatrixException Thrown if either matrix is null or the dimensions of the two matrices are not identical
     */
    public static Matrix add(Matrix a, Matrix b)throws MatrixException{
        if(a == null || b == null){
            throw new MatrixException("Matrices cannot be null");
        }
        else if((a.row != b.getMatrix().length) || (b.column != b.getMatrix()[0].length)){
            throw new MatrixException("Matrices need to have the same Dimensions");
        }
        else{
            Matrix mFinal = new Matrix(a.row, a.column);
            for(int x = 0; x < a.row; x++){
                for(int y = 0; y < b.column; y++){
                    mFinal.set(x,y, a.get(x, y) + b.get(x, y));
                }
            }
            return mFinal;
        }
    }

    /**
     * Subtracts the first matrix from the second matrix (a-b)
     * @return the result of the operation
     * @throws MatrixException Thrown if either matrix is null or the dimensions of the two matrices are not identical
     */
    public static Matrix sub (Matrix a, Matrix b) throws MatrixException{
        if(a == null || b == null){
            throw new MatrixException("Matrices cannot be null");
        }
        else if((a.row != b.getMatrix().length) || (b.column != b.getMatrix()[0].length)){
            throw new MatrixException("Matrices need to have the same Dimensions");
        }
        else{
            Matrix mFinal = new Matrix(a.row, a.column);
            for(int x = 0; x < a.row; x++){
                for(int y = 0; y < b.getMatrix()[0].length; y++){
                    mFinal.set(x,y, a.get(x, y) - b.get(x, y));
                }
            }
            return mFinal;
        }
    }

    /**
     * Multiples two matrices
     * @return Product of the two parameters
     * @throws MatrixException Thrown if either matrix is null or the numbers of rows in the first one does not match the number of columns in the second
     */
    public static Matrix mult (Matrix aMatrix, Matrix bMatrix)throws MatrixException{
        if(aMatrix == null || bMatrix == null){
            throw new MatrixException();
        }
        else if(aMatrix.row != bMatrix.column){
            throw new MatrixException();
        }
        else{
            Matrix mFinal = new Matrix(aMatrix.row, bMatrix.column);
            double sum;
            for(int x = 0; x < aMatrix.row; x++){
                for(int y = 0; y < bMatrix.column; y++){
                    for(int z = 0; z < aMatrix.column; z++){
                        sum = mFinal.get(x,y) + aMatrix.get(x,z) * bMatrix.get(z,y);
                        mFinal.set(x,y,sum);
                    }
                }
            }
            return mFinal;
        }
    }

    /**
     * Performs scalar multiplication upon the matrix a
     * @param a matrix to be multiplied
     * @param d scalar to multiply by
     * @return Product matrix
     * @throws MatrixException Thrown if a is null
     */
    public static Matrix mult(Matrix a, double d)throws MatrixException{
        if(a == null){
            throw new MatrixException("Matrix cannot be void");
        }
        else{
            Matrix mFinal = new Matrix(a.row,a.column);
            for(int x = 0; x < a.row; x++){
                for(int y = 0; y < a.getMatrix()[0].length; y++){
                    mFinal.set(x ,y , a.get(x,y) * d );
                }
            }
            return mFinal;
        }

    }

    /**
     * Transposes the matrix and returns the result
     * @param a matrix to be transposed
     * @return transposed matrix
     * @throws MatrixException Thrown if a is null
     */
    public static Matrix transpose(Matrix a) throws MatrixException{
        if(a == null){
            throw new MatrixException("Matrix cannot be void");
        }
        else {
            Matrix t = new Matrix(a.column, a.row);
            for (int x = 0; x < a.column; x++) {
                for (int y = 0; y < a.row; y++) {
                        t.set(x,y,a.get(y,x));
                }
            }
            return t;
        }
    }

    /**
     * Returns the private array Matrix
     */
    public double[][] getMatrix() {
        return matrix;
    }

    /**
     * MatrixException
     * This exception is thrown for any error associated with the
     * methods in the Matrix class.
     *
     * @author Mr. Kramer
     * @version 10/3/2010
     */

    public static class MatrixException extends Exception{
        public MatrixException() { super(); }
        public MatrixException (String s) { super (s); }
    }
}