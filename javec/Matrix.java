package javec;

/** Object representation of a matrix.
 * @author: Anton A. Zabreyko
 */
import java.util.ArrayList;

public class Matrix<A extends Info> {

    /** 2D ArrayList representation of the matrix. */
    private ArrayList<ArrayList<A>> mat;

    /** The number of rows in the matrix. */
    private int rows;

    /** The number of columns in the matrix. */
    private int cols;

    /**Default constructor for matrix, creates an empty matrix. */
    public Matrix() {
        mat = new ArrayList<ArrayList<A>>();
        rows = 0;
        cols = 0;
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

    /** Checks to see whether or not a matrix has been initialized. */
    private boolean checkInit() {
        if (cols == 0) {
            return true;
        }
        return false;
    }

    /** Returns a string representation of the matrix. */
    public String toString() {
        String str = "";
        for (int i = 0; i < this.mat.size(); i++) {
            str += "[";
            for (int j = 0; j < this.mat.get(0).size(); j++) {
                str += this.mat.get(i).get(j) + " ";
            }
            str += "]\n";
        }
        return str;
    }


}
