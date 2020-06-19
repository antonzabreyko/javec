package javec;

/** Object representation of a matrix. */
import java.util.ArrayList;

public class Matrix<A extends Info> {

    /** 2D ArrayList representation of the matrix. */
    private ArrayList<ArrayList<A>> mat;

    /** The number of rows in the matrix. */
    private int rows;

    /** The number of columns in the matrix. */
    private int cols;

    /** Default constructor for matrix, creates an empty matrix. */
    public Matrix() {
        mat = new ArrayList<ArrayList<A>>();
        rows = 0;
        cols = 0;
    }

    /** Sets up a matrix with dimensions (rows, cols), with default value a. */
    public Matrix(int rows, int cols, A a) {
        mat = new ArrayList<ArrayList<A>>();
        this.rows = rows;
        this.cols = cols;
        for (int i = 0; i < rows; i++) {
            mat.set(i, new ArrayList<A>());
        }

        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < this.cols; j++) {
                this.mat.get(i).set(j, a);
            }
        }
    }

    /** Stacks given row into the matrix. Errors when length of the row does not match up with the
     * number of columns, or when the data inside is not of type A. */
    public void rowStack(Object[] row) throws LinAlgException {
        if (!checkInit() && row.length != cols) {
            throw new LinAlgException(String.format("Invalid Dimensions! Was expecting %o, but got %o", cols, row.length));
        }
        mat.add(new ArrayList<A>());
        for (int i = 0; i < row.length; i++) {
            Object obj = row[i];
            try {
                A data = (A)obj;
                mat.get(mat.size()-1).add(data);
            } catch (ClassCastException e) {
                System.out.println(String.format("Object at index %o is not of the correct type!", i));
                mat.remove(mat.size()-1);
                return;
            }
        }
    }

    public Matrix<A> dot(Matrix<A> other) throws LinAlgException {
        if (!checkValidity(this.dims(), other.dims())) {
            throw new LinAlgException("Invalid dimensions!");
        }
        return new Matrix<A>();
    }

    /** Sets the given value a at the provided row and column, if that index exists. */
    public void set(A a, int row, int col) throws LinAlgException {
        if (row > this.rows || col > this.cols) {
            throw new LinAlgException(String.format("Provided index does not exist in matrix! " +
                    "Dimensions are (%o, %o)", this.rows, this.cols));
        }
        this.mat.get(row).set(col, a);
    }

    /** Checks to make sure that the provided dimensions match up for multiplication. */
    private boolean checkValidity(int[] d1, int[] d2) {
        if (d1[1] == d2[0]) {
            return true;
        }
        return false;
    }

    /** Returns the dimensions of the matrix in the format [rows, columns]. */
    public int[] dims() {
        return new int[] {this.rows, this.cols};
    }

    /** Checks to see whether or not a matrix has been initialized. */
    private boolean checkInit() {
        if (cols == 0) {
            return true;
        }
        return false;
    }

    /** Returns a string representation of the matrix. */
    public String toString() {
        String str = "[";
        for (int i = 0; i < this.mat.size(); i++) {
            for (int j = 0; j < this.mat.get(0).size(); j++) {
                str += this.mat.get(i).get(j) + " ";
            }
            str += "\n";
        }
        if (str.length() > 1) {
            str = str.substring(0, str.length()-1);
        }
        str += "]";
        return str;
    }


}
